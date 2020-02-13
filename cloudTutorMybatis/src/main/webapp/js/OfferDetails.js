$(function(){
    let offerId = getParameter("offerId");
    load(offerId, null, searchName);
});

function getParameter(name) {
    let reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    let r = location.search.substr(1).match(reg);
    let temp = r.split("&");
    temp = temp[0].split("=");
    if (r != null) return (temp[1]);
    return null;
}

function load(offerId){
    $.post("offer/details", {"offerId":offerId}, function(data){
       //data到页面的展示
    });
}