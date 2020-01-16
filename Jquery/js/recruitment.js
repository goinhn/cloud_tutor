$(function(){
    if (judgeLogin() === 'false') {
        alert('请先登录！');
        // 跳转到login界面
    }
})


function index(){
    if(judgeLogin() === 'true'){
        // 跳转到index界面
    }else{
        alert('请先登录！');
        // 跳转到login界面
    }
}

function recruitment(){
    if(judgeLogin() === 'false'){
        alert('请先登录！');
        // 跳转到login界面
    }
}

function tutorInformation(){
    if(judgeLogin() === 'false'){
        alert('请先登录！');
        // 跳转到login界面
    }else{
        // 跳转到tutorInformation
    }
}
function login(){
    if(judgeLogin() === 'true'){
        // 跳转到index界面
    }
}

function register(){
    // 跳转到注册页面
}

function judgeLogin(){
    let isLogin = getCookie('isLogin');
    return isLogin;
}

function everything(){
    let data = {
        "keyWord": "everything"
    }
    let url = '====================';
    ajaxMain('POST', url, data, lookInformation);
}

function subjectMath(){
    let data = {
        "keyWord": "subjectMath"
    }
    let url = '====================';
    ajaxMain('POST', url, data, lookInformation);
}

function subjectEnglish(){
    let data = {
        "keyWord": "subjectEnglish"
    }
    let url = '====================';
    ajaxMain('POST', url, data, lookInformation);
}

function subjectChinese(){
    let data = {
        "keyWord": "subjectChinese"
    }
    let url = '====================';
    ajaxMain('POST', url, data, lookInformation);
}

function keySearch(){
    let keyWord = $('#keyWord');
    let data = {
        "keyWord": keyWord
    }
    let url = '====================';
    ajaxMain('POST', url, data, lookInformation);
}

function lookInformation(data){
    $('#tutorTitle').html(data.tutorTitle);
    $('#tutorTime').html(data.tutorTime);
    $('#claim').html(data.claim);
    $('#teacherNumber').html(data.teacherNumber);
    $('#specific').html(data.specific);
    $('#gender').html(data.gender);
    $('#tutorFee').html(data.tutorFee);
}

function apply(){
    alert('this is todo!');
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