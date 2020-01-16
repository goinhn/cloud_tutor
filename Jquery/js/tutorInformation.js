$(function(){
    
})


function index(){
    let url = '=====';
    ajax['get'](url, function(){

    });
}

function recruitment(){
    let url = '=====';
    ajax['get'](url, function(){

    });
}

function tutorInformation(){
    let url = '=====';
    ajax['get'](url, function(){

    });
}
function login(){
    let url = '=====';
    ajax['get'](url, function(){

    });
}

function register(){
    let url = '=====';
    ajax['get'](url, function(){

    });
}


function subjectEverything(){

}

function subjectMath(){

}

function subjectEnglish(){

}

function subjectChinese(){

}

function searchGender(){

}

function searchMan(){

}

function searchWoman(){

}

function idEverything(){

}

function idHotSchool(){

}

function idNine(){

}

function idTwo(){

}

function idOne(){

}

function idTeachSchool(){

}

function tutorEverything(){

}

function tutorExperience(){

}

function tutorTime(){

}

function tutorInformation(data){
    $('#tutorImage').prop({src: data.tutorImage});
    $('tutorName').html(data.tutorName);
    $('tutorSchool').html(data.tutorSchool);
    $('tutorTime').html(data.tutorTime);
    $('tutorSubject').html(data.tutorSubject);
    $('tutorFee').html(data.tutorFee);
    $('tutorIntroduction').html(tutorIntroduction);
}

function contact(){

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