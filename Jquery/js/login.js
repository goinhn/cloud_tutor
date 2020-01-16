$(function () {
    if (judgeLogin() === 'true') {
        // 跳转到index界面
    }
})


function index() {
    // 跳转到index
}

function recruitment() {
    if (judgeLogin === 'true') {
        // 跳转到recruitment界面
    } else if (judgeLogin === 'false') {
        alert('请先登录！');
    }
}

function tutorInformation() {
    if (judgeLogin === 'true') {
        // 跳转到tutorInformation界面
    } else if (judgeLogin === 'false') {
        alert('请先登录！');
    }
}
function login() {
    window.location = '#';
}

function register() {
    // 跳转到注册界面
}

function judgeLogin() {
    let isLogin = getCookie('isLogin');
    return isLogin;
}

// 登录验证函数
function loginSubmit() {
    let userId = $('#username');
    let userPassword = $('#userPassword');
    let url = "===============";
    let data = {
        "userId": userId,
        "userPassword": userPassword
    }

    ajaxMain('POST', url, data, function () {
        this.setCookie('isLogin', 'true', 1, '/');
    }, function () {
        alert('账号或者密码错误请重新输入！')
    })
}

// 添加cookie的函数
function setCookie(name, value, expireDay, path) {
    //判断是否设置过期时间
    if (expireHours > 0) {
        $.cookie(name, value, {
            expires: expireDay,
            path: path,
            secure: true
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
function delCookie(name) {
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