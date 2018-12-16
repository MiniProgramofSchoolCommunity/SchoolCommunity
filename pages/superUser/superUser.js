// pages/superUser/superUser.js
var app=getApp()
Page({
  data: {
    newInfo:[],
    isFromSearch: true,   // 用于判断searchSongList数组是不是空数组，默认true，空的数组
    searchPageNum: 1,// 设置加载的第几次，默认是第一次
    searchLoading: false, //"上拉加载"的变量，默认false，隐藏
    searchLoadingComplete: false,  //“没有数据”的变量，默认false，隐藏
    scrollHeight: 0,
    flag:false
    //id:{}
  },
  confirm:function(e){
    var that =this
    var identifyId=e.currentTarget.dataset.id
    console.log(identifyId)
    wx.request({
      url: 'http://localhost:80/manage/verify.do',
      data:{
        manager:app.globalData.userid,
        interviewee:identifyId
      },
      method:'post',
      success:function(res){
        console.log(res.data)
        if(res.data.STATUS=="SUCCESS"){
          wx.showToast({
            title: '您已成功确认',
            duration:2000
          })
        }
        else if(res.data.STATUS=="FAILED"){
          wx.showToast({
            title: '确认失败1',
            duration: 2000
          })
        }
        else if (res.data.STATUS =="NOPERMISSION"){
          wx.showToast({
            title: '确认失败2',
            duration: 2000
          })
        }
        else if(res.data.STATUS =="VERIFIED"){
          wx.showToast({
            title: '已认证过此用户',
            duration: 2000
          })
        }
        else if (res.data.STATUS =="NOTEXISTS"){
          wx.showToast({
            title: '确认失败4',
            duration: 2000
          })
        }
      }
    })
  },
  searchScrollLower: function () {
    console.log("u have go to sS")
    let that = this;
    //console.log(that.data)
    if (that.data.searchLoading && !that.data.searchLoadingComplete) {
      that.setData({
        searchPageNum: that.data.searchPageNum + 1,  //每次触发上拉事件，把searchPageNum+1
        isFromSearch: false  //触发到上拉事件，把isFromSearch设为为false
      });
      console.log(that.data)
      that.onLoad();
    }
    // console.log(that.data.searchPageNum)
  },
  onLoad: function () {
    var that = this;
    console.log("initial data:" + that.data.newInfo)
    wx.getSystemInfo({
      success: function (res) {
        that.setData({
          scrollHeight: res.windowHeight
        });
      }
    })
    wx.request({
      url: 'http://localhost:80/manage/getRequestInfo.do',//todo
      method: 'post',
      data: {
        pageNum: that.data.searchPageNum,
        userid:app.globalData.userid,
        atype:app.globalData.usertype
      },
      success: function (res) {
        var infoList = [];
        if ((res.data.list.length == 10) && res.data.hasNextPage) {
          that.data.isFromSearch ? infoList = res.data.list : infoList = that.data.newInfo.concat(res.data.list);
          that.setData({
            newInfo: infoList, //获取数据数组
            searchLoading: true   //把"上拉加载"的变量设为true，显示
          });
          console.log("第一次post数据:" + that.data.newInfo)
        }
        else {
          that.data.isFromSearch ? infoList = res.data.list : infoList = that.data.newInfo.concat(res.data.list);
          that.setData({
            newInfo: infoList, //获取数据数组
            searchLoadingComplete: true, //把“没有数据”设为true，显示
            searchLoading: false  //把"上拉加载"的变量设为false，隐藏
          });
        }
        console.log(res)
        //console.log(that.data.newInfo)
      }
    })
  }
})