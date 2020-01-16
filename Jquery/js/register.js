$(function () {

})


function index() {
    // 跳转到index
}

function recruitment() {
    if(judgeLogin() === 'true'){
        // 跳转到recruitment界面
    }else if(judgeLogin() === 'false'){
        alert('请先登录！');
        // 跳转到login界面
    }
}

function tutorInformation() {
    if(judgeLogin() === 'true'){
        // 跳转到tutorInformation界面
    }else if(judgeLogin() === 'false'){
        alert('请先登录！');
        // 跳转到login界面
    }
}
function login() {
    if(judgeLogin() === 'true'){
        // 跳转到index界面
    }
}

function register() {
    window.location = '#';
}

function accountCheckFocus() {
    $('#checkAccount').html('请输入账号在4-20个字符之间');
}

function accountCheckBlur() {
    let userId = $('#userId');
    let checkAccount = $('#checkAccount');

    if (userId.prop('value').length < 4 || userId.prop('value').length > 20) {
        checkAccount.html('输入账号不符合要求');
    } else {
        checkAccount.html('');
    }
}

function nameCheckFocus() {

}

function nameCheckBlur() {

}

function passwordCheckFocus() {

}

function passwordCheckBlur() {

}

function rePasswordCheckFocus() {

}

function rePasswordCheckBlur() {
    let userPassword = $('#userPassword');
    let userRePassword = $('#userRePassword');
    let checkRePassword = $('#checkRePassword');

    if (userPassword.prop('value') === userRePassword.prop('value')) {
        checkRePassword.html('');
    } else {
        checkRePassword.html('两次密码输入的不一致');
    }
}

function submit() {
    let userId = $('#userId');
    let username = $('#username');
    let userPassword = $('#userPassword');

    let url = '===========';
    let data = {
        "userId": userId.prop('value'),
        "username": username.prop('value'),
        "userPassword": userPassword.prop('value'),
    };

    ajaxMain("POST", url, data, function(){
        if(data){
            alert('注册成功');
        }
    }, function(){
        alert('注册失败');
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


