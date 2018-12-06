Page({

  /**
   * 页面的初始数据
   */
  data: {
    name:'',
    school:'',
    intro:'',
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
    console.log('picker发送选择改变，携带值为', e.detail.value)
    if (e.detail.value == 0) {
      this.data.idType = 2
    }
    if (e.detail.value == 1) {
      this.data.idType = 3
    }
    console.log('idype: ', this.data.idType)
    this.setData({
      idFlag: e.detail.value,
    })
    console.log(this.data.idFlag)
  },
  fanhui: function () {
    wx.switchTab({
      url: '/pages/personal/personal',
    })
  },
  queding: function () {
    wx.switchTab({
      url: '/pages/index/index',
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