// 判断是否登录
const judgeLogin = () => {
    return getCookie('isLogin');
}

// 添加cookie的函数
const setCookie = (name, value, expireDay, path) => {
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
const getCookie = (name) => {
    return $.cookie(name);
}

// 改变指定的cookie
const changeCookie = (name, value) => {
    $.cookie(name, value);
}

// 删除指定的cookie
const delCookie = (name) => {
    $.cookie(name, null);
}

const ajaxMain = (type, url, data, su = () => { }, er = () => { }, be = () => { }, co = () => { }) => {
    $.ajax({
        type: type, //请求方式
        url: url, //请求的url地址
        dataType: "json", //返回格式为json
        async: true,//请求是否异步，默认为异步，这也是ajax重要特性
        data: data, //参数值
        success: function (req) {
            if (req.status == 'ok') {
                su.call(req);
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

const test = () => {
    return document.write('this is a test!');
}

exports.judgeLogin = judgeLogin;
exports.setCookie = setCookie;
exports.getCookie = getCookie;
exports.changeCookie = changeCookie;
exports.delCookie = delCookie;
exports.ajaxMain = ajaxMain;
exports.test = test;