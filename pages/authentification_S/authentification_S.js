var app=getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    address:'',
    cintro:'',
    leaderidcard:{},
    leadername:'',
    leadernum:{},
    contactsnum:{},
    contactsname:'',
    cname:'',
    regisnum:{}
  },
  fanhui: function () {
    wx.switchTab({
      url: '/pages/personal/personal',
    })
  },
  addressget:function(e){
    this.setData({
      address: e.detail.value
    })
  },
  cintroget: function (e) {
    this.setData({
      cintro: e.detail.value
    })
  },
  leaderidcardget: function (e) {
    this.setData({
      leaderidcardget: e.detail.value
    })
  },
  leadernumget: function (e) {
    this.setData({
      leadernum: e.detail.value
    })
  },
  leadernameget: function (e) {
    this.setData({
      leadername: e.detail.value
    })
  },
  contactsnameget: function (e) {
    this.setData({
      contactsname: e.detail.value
    })
  },
  contactsnumget: function (e) {
    this.setData({
      contactsnum: e.detail.value
    })
  },
  cnameget: function (e) {
    this.setData({
      cname: e.detail.value
    })
  },
  regisnumget: function (e) {
    this.setData({
      regisnum: e.detail.value
    })
  },
  queding: function () {
    var that=this
    wx.request({
      url: 'http://localhost:80/user/verifyRequest.do',
      data:{
        userid:app.globalData.userid,
        usertype:app.globalData.usertype,
        address:that.data.address,
        cintro:that.data.cintro,
        leaderidcard: that.data.leaderidcard,
        leadername: that.data.leadername,
        leadernum: that.data.leadernum,
        contactsnum: that.data.contactsnum,
        contactsname: that.data.contactsname,
        cname:that.data.cname,
        regisnum: that.data.regisnum,
      },
      success:function(res){
        if (res.data.STATUS == "SUCCESS") {
          wx.showToast({
            title: '审核请求已发送',
          })
          wx.switchTab({
            url: '/pages/index/index',
          })
        }
        else if (res.data.STATUS == "FAILED") {
          wx.showToast({
            title: '数据库错误请重试',
            duration: 2000
          })
        }
        else {
          wx.showToast({
            title: '未知错误请重试',
            duration: 2000
          })
        }
      }
    })},
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