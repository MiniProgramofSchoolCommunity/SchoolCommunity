const app=getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    idFlag:0,
    name:'',
    school:'',
    intro:'',
    level:0,
    pname:'',
    pid:'',
    ptel:'',
    p2name:'',
    p2tel:'',
    array: ['校级社团', '院级社团'],
    objectArray: [
      {
        id: 0,
        name: '校级社团'
      },
      {
        id: 1,
        name: '院级社团'
      }
    ],
  },
  bindPickerChange: function (e) {
    // console.log('picker发送选择改变，携带值为', e.detail.value)
    // if (e.detail.value == 0) {
    //   this.data.idType = 2
    // }
    // if (e.detail.value == 1) {
    //   this.data.idType = 3
    // }
    // console.log('idype: ', this.data.idType)
    // this.setData({
    //   idFlag: e.detail.value,
    // })
    // console.log(this.data.idFlag)
    if(e.detail.value==0) this.data.level=0
    else this.data.level=1
  },
  nameget:function(e){
    this.setData({
      name:e.detail.value
    })
  },
  school_get:function (e) {
    console.log(e)
    this.setData({
      school: e.detail.value
    })
  },
  introget: function (e) {
    this.setData({
      intro: e.detail.value
    })
  },
  levelget: function (e) {
    this.setData({
      level: e.detail.value
    })
  },
  pnameget: function (e) {
    this.setData({
      pname: e.detail.value
    })
  },
  pidget: function (e) {
    this.setData({
      pid: e.detail.value
    })
  },
  ptelget: function (e) {
    this.setData({
      ptel: e.detail.value
    })
  },
  p2nameget: function (e) {
    this.setData({
      p2name: e.detail.value
    })
  },
  p2telget: function (e) {
    this.setData({
      p2tel: e.detail.value
    })
  },
  fanhui: function () {
    wx.switchTab({
      url: '/pages/personal/personal',
    })
  },
  queding: function () {
    var that=this
    wx.request({
      url: 'http://localhost:80/user/verifyRequest.do',
      method:'post',
      data:{
        userid:app.globalData.userid,
        usertype: app.globalData.usertype,
        sname:that.data.name,
        school:that.data.school,
        level: that.data.level,
        leadername:that.data.pname,
        leaderidcard:that.data.pid,
        leadernum:that.data.ptel,
        sintro:that.data.intro,
        contactsname:that.data.p2name,
        contactsnum:that.data.p2tel
      },
      success:function(res){
        if(res.data.STATUS=="SUCCESS"){
          wx.showToast({
            title: '审核请求已发送',
          })
          wx.switchTab({
            url: '/pages/index/index',
          })
        }
        else if (res.data.STATUS =="FAILED"){
          wx.showToast({
            title: '数据库错误请重试',
            duration:2000
          })
        }
        else{
          wx.showToast({
            title: '未知错误请重试',
            duration:2000
          })
        }
      }
    })
    
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
    
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
    
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
    
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
    
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
    
  }
})