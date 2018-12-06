Page({

  /**
   * 页面的初始数据
   */
  data: {
    array:['社团','企业'],
    objectArray:[
      {
        id: 0,
        name: '社团'
      },
      {
        id: 1,
        name: '企业'
      }
    ],
    idFlag:0,
    name:{},
    email:{},
    pwd:{},
    idtype:0
  },
  nameGet:function(e){
    this.setData({
      name:e.detail.value
    })
  },
  emailGet: function (e) {
    this.setData({
      email: e.detail.value
    })
  },
  pwdGet: function (e) {
    this.setData({
      pwd: e.detail.value
    })
  },
  bindPickerChange: function (e) {
    console.log('picker发送选择改变，携带值为', e.detail.value)
    if(e.detail.value==0){
      this.data.idType=2
    }
    if (e.detail.value == 1) {
      this.data.idType=3
    }
    console.log('idype: ', this.data.idType)
    this.setData({
      idFlag:e.detail.value,
    })
    console.log(this.data.idFlag)
  },
  fanhui: function () {
    wx.navigateTo({
      url: '/pages/login/login',
    })
  },
  queding: function () {
    //this.data.idtype=this.data.idFlag+2,
    console.log(this.data.idtype)
    wx.request({
      url: 'http://localhost:80/user/register.do',
      method:'post',
      data:{
        username:this.data.name,
        email:this.data.email,
        itype:this.data.idtype,
        pwd:this.data.pwd,
      },
      header:{
        'content-type': 'application/x-www-form-urlencoded'
      },
      success:function(res){
        if(res.data=='success'){
          wx.showToast({
            title: '注册成功',
            icon:'none',
            duration:2000
          })
          wx.navigateTo({
            url: '/pages/login/login',
          })
        }
      if(res.data=='exist') {
        wx.showToast({
          title: '邮箱或用户名重复',
          icon: 'none',
          duration: 2000
        })
      }
      else {
        wx.showToast({
          title: '用户信息不能为空',
          icon:'none',
          duration:2000
        })
      }
      },
      fail:function(res){
        console.log("调用后台失败")
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