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

// ajax
const ajaxMain = (type, url, data, su = () => { }, er = () => { }, be = () => { }, co = () => { }) => {
    $.ajax({
        type: type, //请求方式
        url: url, //请求的url地址
        dataType: "json", //返回格式为json
        async: true,//请求是否异步，默认为异步，这也是ajax重要特性
        data: data, //参数值
        success:  (req) => {
            if (req.status == 'ok') {
                su.call(req);
            } else {
                console.log(req.status);
                console.log(req.responseText);
            }
        },
        error: (e) => {
            console.log(e.status);
            console.log(e.responseText);
            er();
        },
        beforeSend: () => {
            //请求前的处理
            be();
        },
        complete: () => {
            //请求完成的处理
            co();
        }
        
    });
}

// 判断是否登录
const judgeLogin = () => {
    return getCookie('isLogin');
}


const alertToDo = () => {
    alert('this is to do');
} 
 
const index = () => {
    window.location = '#';
}

const recruitment = () => {
    if(judgeLogin === 'true'){
       // 跳转到recruitiment界面进行登录
    }else if(judgeLogin === 'false'){
        alert('请先登录！');
    }
}

const tutorInformation = () => {
    if(judgeLogin === 'true'){
        // 跳转到tutorInformation界面进行登录
    }else if(judgeLogin === 'false'){
        alert('请先登录！');
    }
}

const login = () => {
    if(judgeLogin === 'true'){
        window.location = '#';
    }
}

const register = () => {
    let url = '=====';
    ajax['get'](url, function(){

    });
}


$(function(){
    
});


$('#talentMan').on({
    click: alertToDo
});

$('#helpCenter').on({
    click: alertToDo
});

$('#contactUs').on({
    click: alertToDo
})



