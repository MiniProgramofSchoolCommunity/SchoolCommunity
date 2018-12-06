module.exports={
  carousel: [
    "/pages/images/gate.jpg",
    "/pages/images/fall.jpg",
    "/pages/images/xiaohui.jpg"
  ],
  newInfo:newInfo,
  get_info:get_info
}
// function newGoods() {
//   var result = [];
//   var goodsLength = goods_list.goods.length;
//   var start;
//   if (goodsLength > 4) {
//     start = goodsLength - 4;
//     console.log(start);
//   } else {
//     start = 0;
//     console.log(start);
//   }
//   for (var i = start; i < goodsLength; i++) {
//     result.push(goods_list.goods[i]);
//   }
//   return result || {}
// }
function allInfo(){
  var list={
    info:[
      {
        "id":1,
        "images":"/pages/images/community.jpg",
        "requirement":"需要1000元赞助",
        "community_name":"IBM俱乐部",
        "level":"院级",
        "community_relater":"田煜鑫",
        "community_leader":"舔雨欣"
      },
      {
        "id": 2,
        "requirement": "需要2000元赞助",
        "images": "/pages/images/community.jpg",
        "community_name": "tecent俱乐部",
        "level": "院级",
        "community_relater": "ymx",
        "community_leader": "yymmxx"
      },
      {
        "id": 3,
        "requirement": "需要3000元赞助",
        "images": "/pages/images/interprise.jpg",
        "community_name": "huawei俱乐部",
        "level": "院级",
        "community_relater": "wht",
        "community_leader": "stt"
      },
      {
        "id": 4,
        "requirement": "需要3000元赞助",
        "images": "/pages/images/interprise.jpg",
        "community_name": "huawei俱乐部",
        "level": "院级",
        "community_relater": "wht",
        "community_leader": "stt"
      },
    ]}
  return list;
  }
  
var info_list=allInfo();
// function newInfo(){
//   var result=[];
// }
// function newInfo() {
//   var result = [];
//   var goodsLength = info_list.info.length;
//   var start;
//   if (goodsLength > 4) {
//     start = goodsLength - 4;
//     console.log(start);
//   } else {
//     start = 0;
//     console.log(start);
//   }
//   for (var i = start; i < goodsLength; i++) {
//     result.push(info_list.info[i]);
//   }
//   return result || {}
// }
function newInfo(){
  var result=[];
  for(let i=0;i<info_list.info.length;i++){
    result.push(info_list.info[i]);
  }
  return result || {}
}

function get_info(id) {
  var result = [];
  for (let i = 0; i < info_list.info.length; i++) {
    if (info_list.info[i].id == id) {
      result = info_list.info[i];
    }
  }
  return result || {}
}