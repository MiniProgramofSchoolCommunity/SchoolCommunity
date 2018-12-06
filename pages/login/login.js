const app=getApp()
Page({
  data: {
    username: '',
    pwd: '',
  },

  // 获取输入账号

  phoneInput: function (e) {
    this.setData({
      username: e.detail.value
    })
  },

  // 获取输入密码

  passwordInput: function (e) {
    this.setData({
      pwd: e.detail.value
    })
  },

  // 登录

  login: function () {
    var that=this
    if (this.data.username.length == 0 || this.data.pwd.length == 0) {
      wx.showToast({
        title: '用户名和密码不能为空',
        icon: 'loading',
        duration: 2000
      })
    } else {
      wx.request({
        url: 'http://localhost:80/user/login.do',
        header:{
          'content-type': 'application/x-www-form-urlencoded'
        },
        data:{
          username:this.data.username,
          pwd:this.data.pwd
        },
        method:'post',
        success:function(res){
          console.log(res);
          if(res.data.status == 'success'){
            app.globalData.uerid=res.data.userid,
            wx.showToast({
              title: '登录成功',
              icon: 'success',
              duration: 2000
            }),
          console.log(0)
          wx.switchTab({
            url: '/pages/index/index',
          })
          console.log(1)
          }
          else if (res.data.status == 'pwderror'){
            wx.showToast({
              title: '密码错误',
              icon: 'failed',
              duration: 2000
            })
          } else if (res.data.status == 'notexits') {
            wx.showToast({
              title: '账户不存在',
              icon: 'failed',
              duration: 2000
            })
            
          }
          else if (res.data.status == 'failed') {
            wx.showToast({
              title: '未知错误',
              icon: 'failed',
              duration: 2000
            })
          }
        }
      })

      // 这里修改成跳转的页面

      
    }
  },

  //跳转到注册界面
  register: function () {
    wx.navigateTo({
      url: '/pages/register/register',
    })
  },
})
