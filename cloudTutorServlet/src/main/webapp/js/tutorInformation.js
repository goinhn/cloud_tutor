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
    let url = '=====';
    ajax['get'](url, function(){

    });
}

const recruitment = () => {
    let url = '=====';
    ajax['get'](url, function(){

    });
}

const tutorInformation = () => {
    let url = '=====';
    ajax['get'](url, function(){

    });
}
const login = () => {
    let url = '=====';
    ajax['get'](url, function(){

    });
}

const register = () => {
    let url = '=====';
    ajax['get'](url, function(){

    });
}


const subjectEverything = () => {

}

const subjectMath = () => {

}

const subjectEnglish = () => {

}

const subjectChinese = () => {

}

const searchGender = () => {

}

const searchMan = () => {

}

const searchWoman = () => {

}

const idEverything = () => {

}

const idHotSchool = () => {

}

const idNine = () => {

}

const idTwo = () => {

}

const idOne = () => {

}

const idTeachSchool = () => {

}

const tutorEverything = () => {

}

const tutorExperience = () => {

}

const tutorTime = () => {

}

const tutorInformation = (data) => {
    $('#tutorImage').prop({src: data.tutorImage});
    $('tutorName').html(data.tutorName);
    $('tutorSchool').html(data.tutorSchool);
    $('tutorTime').html(data.tutorTime);
    $('tutorSubject').html(data.tutorSubject);
    $('tutorFee').html(data.tutorFee);
    $('tutorIntroduction').html(tutorIntroduction);
}

const contact = () => {

}

$(() => {
    
})


$('#buttonIndex').click(index);
$('#buttonRecruitment').click(recruitment);
$('#buttonTutorInformation').click(tutorInformation);
$('#buttonLogin').click(login);
$('#buttonRegister').click(register);

$('#subjectEverything').click(subjectEverything);
$('#subjectChinese').click(subjectChinese);
$('#subjectEnglish').click(subjectEnglish);
$('#subjectMath').click(subjectMath);

$('#searchGender').click(searchGender);
$('#searchMan').click(searchMan);
$('#searchWoman').click(searchWoman);

$('#idEverything').click(idEverything);
$('#idHotSchool').click(idHotSchool);
$('#idNine').click(idNine);
$('#idTwo').click(idTwo);
$('#idOne').click(idOne);
$('#idTeachSchool').click(idTeachSchool);

$('#tutorEverything').click(tutorEverything);
$('#tutorExperience').click(tutorExperience);
$('#tutorTime').click(tutorTime);

$('#contact').click(contact);