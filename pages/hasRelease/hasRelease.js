//var info = require('../hasRelease/data.js');
const app = getApp()
Page({
  data: {
    info: {},
    pageNum:1,
    usertype:app.globalData.usertype,
    atype:0
  },
  onPullDownRefresh:function(){
    this.onLoad()
  },
  onLoad: function () {
     var that = this;
    /*数据*/
    wx.request({
      url: 'http://localhost:80/user/activity/myActivity.do',
      method:'post',
      data:{
        userid:app.globalData.userid,
        pageNum:that.data.pageNum
      },
      success:function(res){
        if(res.data.STATUS=='FAILED'){
          wx.showToast({
            title: '访问失败',
          })
        }
        else{
          that.setData({
            info: res.data.list,
          })
          if (app.globalData.usertype == 2) that.setData({atype:0})
          if (app.globalData.usertype == 3) that.setData({ atype:1})
          console.log(that.data.atype)
        }
      }
    })
  },

  //手指触摸动作开始 记录起点X坐标
  touchstart: function (e) {
    //开始触摸时 重置所有删除
    let data = app.touch._touchstart(e, this.data.info)
    this.setData({
      info: data
    })
  },

  //滑动事件处理
  touchmove: function (e) {
    let data = app.touch._touchmove(e, this.data.info)
    this.setData({
      info: data
    })
  },

  //删除事件
  del: function (e) {
    var that=this
    wx.showModal({
      title: '提示',
      content: '确认要删除此条信息么？',
      success: function (res) {
        if (res.confirm) {
          console.log('用户点击确定')
          that.del_request(e.currentTarget.dataset.id)
          console.log(e.currentTarget.dataset.id)
        } else if (res.cancel) {
          console.log('用户点击取消')
        }
      }
    })
  },
  del_request:function(e){
    var that=this;
    wx.request({
      url: 'http://localhost:80/user/activity/delete.do',
      method:'post',
      data:{
        userid:app.globalData.userid,
        activityid:e
      },
      success:function(res){
        console.log(res.data)
          if(res.data.STATUS=='SUCCESS'){
            that.onLoad();
          }
          else{
            wx.showToast({
              title: '删除失败',
            })
          }
      }
    })
  }
})

