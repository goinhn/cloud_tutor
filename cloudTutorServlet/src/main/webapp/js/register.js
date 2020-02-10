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

const index = () => {
    // 跳转到index
}

const recruitment = () => {
    if(judgeLogin === 'true'){
        // 跳转到recruitment界面
    }else if(judgeLogin === 'false'){
        alert('请先登录！');
        // 跳转到login界面
    }
}

const tutorInformation = () => {
    if(judgeLogin === 'true'){
        // 跳转到tutorInformation界面
    }else if(judgeLogin === 'false'){
        alert('请先登录！');
        // 跳转到login界面
    }
}
const login = () => {
    if(judgeLogin === 'true'){
        // 跳转到index界面
    }
}

const register = () => {
    window.location = '#';
}

const accountCheckFocus = () => {
    $('#checkAccount').html('请输入账号在4-20个字符之间');
}

const accountCheckBlur = () => {
    let userId = $('#userId');
    let checkAccount = $('#checkAccount');
    let reUser = /^\w{4,20}$/;
    if (!reUser.test(userId.val())) {
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

const rePasswordCheckBlur = () => {
    let userPassword = $('#userPassword');
    let userRePassword = $('#userRePassword');
    let checkRePassword = $('#checkRePassword');

    if (userPassword.val() === userRePassword.val()) {
        checkRePassword.html('');
    } else {
        checkRePassword.html('两次密码输入的不一致');
    }
}

const submit = () => {
    let userId = $('#userId');
    let username = $('#username');
    let userPassword = $('#userPassword');

    let url = '===========';
    let data = {
        "userId": userId.val(),
        "username": username.val(),
        "userPassword": userPassword.val(),
    };

    ajaxMain("POST", url, data, () => {
        if(data){
            alert('注册成功');
        }
    }, () => {
        alert('注册失败');
    });
}


$(() => {

})

$('#buttonIndex').click(index);
$('#buttonRecruitment').click(recruitment);
$('#buttonTutorInformation').click(tutorInformation);
$('#buttonLogin').click(login);
$('#buttonRegister').click(register);

$('#userId').focus(accountCheckFocus);
$('#userId').blur(accountCheckBlur);

$('#userRePassword').blur(rePasswordCheckBlur);

$('#registerSubmit').click(submit);