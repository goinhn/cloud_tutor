$(function(){
    
})

 
$('#talentMan').click(alertToDo);
$('#helpCenter').click(alertToDo);
$('#ontactUs').click(alertToDo);

function alertToDo(){
    alert('this is to do');
}

function index(){
    window.location = '#';
}

function recruitment(){
    if(judgeLogin === 'true'){
       // 跳转到recruitiment界面进行登录
    }else if(judgeLogin === 'false'){
        alert('请先登录！');
    }
}

function tutorInformation(){
    if(judgeLogin === 'true'){
        // 跳转到tutorInformation界面进行登录
    }else if(judgeLogin === 'false'){
        alert('请先登录！');
    }
}
function login(){
    if(judgeLogin === 'true'){
        window.location = '#';
    }
}

function register(){
    let url = '=====';
    ajax['get'](url, function(){

    });
}

function judgeLogin(){
    return getCookie('isLogin');
}

// 添加cookie的函数
function setCookie(name, value, expireDay, path) {
    //判断是否设置过期时间
    if (expireHours > 0) {
        $.cookie(name, value,{
            expires:expireDay, 
            path:path,
            secure:true
        })　
    }
}

// 获取指定的cookie
function getCookie(name) {
    return $.cookie(name);
}

// 改变指定的cookie
function changeCookie(name, value) {
    $.cookie(name, value);
}

// 删除指定的cookie
function delCookie(name){
    $.cookie(name, null);
}

function ajaxMain(type, url, data, su = function () { }, er = function () { }, be = function () { }, co = function () { }) {
    $.ajax({
        type: type, //请求方式
        url: url, //请求的url地址
        dataType: "json", //返回格式为json
        async: true,//请求是否异步，默认为异步，这也是ajax重要特性
        data: data, //参数值
        success: function (req) {
            if (req.status == 'ok') {
                su(req);
            } else {
                console.log(req.status);
                console.log(req.responseText);
            }
        },
        error: function (e) {
            console.log(e.status);
            console.log(e.responseText);
            er();
        },
        beforeSend: function () {
            //请求前的处理
            be();
        },
        complete: function () {
            //请求完成的处理
            co();
        }
    });
}