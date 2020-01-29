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
    if(judgeLogin() === 'true'){
        // 跳转到index界面
    }else{
        alert('请先登录！');
        // 跳转到login界面
    }
}

const recruitment = () => {
    if(judgeLogin() === 'false'){
        alert('请先登录！');
        // 跳转到login界面
    }
}

const tutorInformation = () => {
    if(judgeLogin() === 'false'){
        alert('请先登录！');
        // 跳转到login界面
    }else{
        // 跳转到tutorInformation
    }
}
const login = () => {
    if(judgeLogin() === 'true'){
        // 跳转到index界面
    }
}

const register = () => {
    // 跳转到注册页面
}

const everything = () => {
    let data = {
        "keyWord": "everything"
    }
    let url = '====================';
    ajaxMain('POST', url, data, lookInformation);
}

const subjectMath = () => {
    let data = {
        "keyWord": "subjectMath"
    }
    let url = '====================';
    ajaxMain('POST', url, data, lookInformation);
}

const subjectEnglish = () => {
    let data = {
        "keyWord": "subjectEnglish"
    }
    let url = '====================';
    ajaxMain('POST', url, data, lookInformation);
}

const subjectChinese = () => {
    let data = {
        "keyWord": "subjectChinese"
    }
    let url = '====================';
    ajaxMain('POST', url, data, lookInformation);
}

const keySearch = () => {
    let keyWord = $('#keyWord');
    let data = {
        "keyWord": keyWord
    }
    let url = '====================';
    ajaxMain('POST', url, data, lookInformation);
}

const lookInformation = (data) => {
    $('#tutorTitle').html(data.tutorTitle);
    $('#tutorTime').html(data.tutorTime);
    $('#claim').html(data.claim);
    $('#teacherNumber').html(data.teacherNumber);
    $('#specific').html(data.specific);
    $('#gender').html(data.gender);
    $('#tutorFee').html(data.tutorFee);
}

const apply = () => {
    alert('this is todo!');
}


$(() => {
    if (judgeLogin() === 'false') {
        alert('请先登录！');
        // 跳转到login界面
    }
})


$('#buttonIndex').click(index);
$('#buttonRecruitment').click(recruitment);
$('#buttonTutorInformation').click(tutorInformation);
$('#buttonLogin').click(login);
$('#buttonRegister').click(register);

$('#everything').click(everything);
$('#subjectMath').click(subjectMath);
$('#subjectEnglish').click(subjectEnglish);
$('#subjectChinese').click(subjectChinese);

$('#keyWord').click(keySearch);

$('#apply').click(apply);