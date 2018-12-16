// pages/personal/personal.js
var app=getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    isIdentify:false
  },

  // wode: function () {
  //   wx.navigateTo({
  //     url: '/pages/login/login',
  //   })
  // },
  releaseDone:function(){
    wx.navigateTo({
      url: '/pages/hasRelease/hasRelease',   //todo
    })
  },
  identify:function(){
    //console.log(1)
    var that=this
    wx.request({
      url: 'http://localhost:80/user/verifyStatus.do',//todo
      header:{

      },
      data:{
        userid:app.globalData.userid
      },
      method:'post',
      success:function(res){
        // that.setData({
        //   isIdentify: res.data.isIdentify
        // })
        console.log(res)
        if(res.data.STATUS=="VERIFIED"){
          wx.showToast({
            title: '您已进行认证，请勿重复认证',
            duration:2000
          })
        }
        //else if()
        else if (res.data.STATUS =="NOPERMISSION"){
          console.log(1)
          console.log(app.globalData.usertype)
          if(app.globalData.usertype==2){
            console.log(app.globalData.usertype)
          wx.navigateTo({
            url: '/pages/authentification_C/authentification_C',
          })}
          if (app.globalData.usertype == 3){
            console.log(app.globalData.usertype)
            wx.navigateTo({
              url: '/pages/authentification_S/authentification_S',
            })
        }}
        else if (res.data.STATUS=="SENTED"){
          wx.showToast({
            title: '您已发送请求',
          })
        }
        else {
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

  onLoad: function () {

    if (app.globalData.userInfo) {

      this.setData({

        userInfo: app.globalData.userInfo,

        hasUserInfo: true

      })

    } else if (this.data.canIUse) {      // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回

      // 所以此处加入 callback 以防止这种情况

      app.userInfoReadyCallback = res => {
        this.setData({
          userInfo: res.userInfo, hasUserInfo: true

        })

      }

    } else {      // 在没有 open-type=getUserInfo 版本的兼容处理

      wx.getUserInfo({
        success: res => {

          app.globalData.userInfo = res.userInfo      
          this.setData({
            userInfo: res.userInfo, hasUserInfo: true

          })

        }

      })

    }

  },

  getUserInfo: function (e) {

    console.log(e)

    app.globalData.userInfo = e.detail.userInfo

    this.setData({

      userInfo: e.detail.userInfo,

      hasUserInfo: true

    })

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