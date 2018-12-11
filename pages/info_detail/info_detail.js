//var infoData = require('../../utils/infoData.js');
Page({
  data: {
    detail_info:{},
    time:{}
  },
  onLoad: function (options) {
    var that = this;
    var id=options.id;
    var atype=options.atype;
    wx.request({
      url: 'http://localhost:80/activity/getActivityDetail.do',//todo
      data:{
        activityId:id,
        atype:atype
      },
      method:'post',
      success:function(res){
        console.log(res)
        that.setData({
          detail_info: res.data,
          time:res.data.date
        })
        var date = new Date()
        date.setTime(parseInt(that.data.time))
        console.log(date)
        date=date.toLocaleString()
        that.setData({
          time:date
        })
      }
    })
  },
})