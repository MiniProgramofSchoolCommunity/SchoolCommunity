//index.js
// var infoData=require('../../utils/infoData.js');
//获取应用实例
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    carousel: 
      [
        "/pages/images/gate.jpg",
        "/pages/images/fall.jpg",
        "/pages/images/xiaohui.jpg"
      ],
    newInfo:{}
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function () {
    var that = this
    //调用应用实例的方法获取全局数据
    // app.getUserInfo(function (userInfo) {
    //   //更新数据
    //   that.setData({
    //     userInfo: userInfo
    //   })
    // })
    wx.request({
      url: '',//todo
      header:{

      },
      method:'post',
      success:function(res){
        that.setData({
          newInfo:res.data
        })
      }
    })
    // console.log(infoData.newInfo());
    // that.setData({
    //   carousel:infoData.carousel,
    //   newInfo:infoData.newInfo()
    // })
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
