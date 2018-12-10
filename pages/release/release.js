// pages/release/release.js
const app=getApp()
var dateTo
var timeTo
Page({
  data: {
    name:'',
    date: '2018-12-04',
    place:'',
    require_intro:'',
    activity_intro:'',
    identifyFlag:false,
    activityType:{},
    time: '12:00',
    usertype:{},
    sponsor_req:''
  },
  sponGet:function(e){
    this.setData({
      sponsor_req:e.detail.value
    })
  },
  nameGet:function(e){
    this.setData({
      name:e.detail.value
    })
  },
  placeGet: function (e) {
    this.setData({
      place: e.detail.value
    })
  },
  reqGet: function (e) {
    this.setData({
      require_intro: e.detail.value
    })
  },
  actGet: function (e) {
    this.setData({
      activity_intro: e.detail.value
    })
  },
  bindDateChange: function (e) {
    console.log(e)
    console.log('picker发送选择改变，携带值为', e.detail.value)
    this.setData({
      date: e.detail.value
    })
  },
  bindTimeChange: function (e) {
    console.log(e)
    console.log('picker发送选择改变，携带值为', e.detail.value)
    this.setData({
      time: e.detail.value
    })
  },
  queding:function(){
    var that=this
    dateTo = new Date(that.data.date)
    timeTo=new Date(that.data.date)
    timeTo.setHours(parseInt(that.data.time))
    console.log("is  " + that.data.usertype)
    //如果是社团的发布
    if(that.data.usertype==2){
      that.setData({
        activityType: 0
      })
      wx.request({   //fetch FLAG
        url: 'http://localhost:80/user/activity/publish.do',      //todo
        data: {
          userid: app.globalData.userid,
          activityType: that.data.activityType,
          activityName: that.data.name,
          activityAddress: that.data.place,
          activityIntro: that.data.activity_intro,
          requirement: that.data.require_intro,
          time: timeTo,
          date: dateTo
        },
        method: 'post',
        success: function (res) {
          if (res.data.STATUS == "SUCCESS") {    //if had identified
            wx.showToast({
              title: '您已成功发布消息',
              duration: 2000
            })
            wx.navigateTo({
              url: '/pages/index/index',
            })
          }
          else if (res.data.STATUS == "FAILED") {
            wx.showToast({
              title: '数据库错误，请重试',
              duration: 2000
            })
          }
          else if (res.data.STATUS == "NOPERMISSION") {
            wx.showToast({
              title: '您尚未认证，请前往个人中心进行认证',
              duration: 2000
            })
          }
          else {
            wx.showToast({
              title: '信息未全或输入错误',
            })
          }
        }
      })
    }
    //如果是企业的发布
    else if(that.data.usertype==3){
      that.setData({
        activityType:1
      })
      console.log(that.data.activityType)
      console.log(typeof(that.data.activityType))
      wx.request({   //fetch FLAG
        url: 'http://localhost:80/user/activity/publish.do',      //todo
        data: {
          userid: app.globalData.userid,
          activityType: that.data.activityType,
          activityName: that.data.name,
          activityAddress: that.data.place,
          activityIntro: that.data.activity_intro,
          requirement: that.data.require_intro,
          time: timeTo,
          date: dateTo,
          sponsorship:that.data.sponsor_req
        },
        method: 'post',
        success: function (res) {
          if (res.data.STATUS == "SUCCESS") {    //if had identified
            wx.showToast({
              title: '您已成功发布消息',
              duration: 2000
            })
            wx.navigateTo({
              url: '/pages/index/index',
            })
          }
          else if (res.data.STATUS == "FAILED") {
            wx.showToast({
              title: '数据库错误，请重试',
              duration: 2000
            })
          }
          else if (res.data.STATUS == "NOPERMISSION") {
            wx.showToast({
              title: '您尚未认证，请前往个人中心进行认证',
              duration: 2000
            })
          }
          else {
            wx.showToast({
              title: '信息未全或输入错误',
            })
          }
        }
      })
    }
    else{
      wx.showToast({
        title: '非法用户',
        duration:2000
      })
    }
  },
  onLoad: function (options) {
    this.setData({
      usertype:app.globalData.usertype
    })
    console.log(this.data.usertype)
  },
})