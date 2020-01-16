$(function () {
    getInformation();
})


// 返回按钮响应事件
function returnTo() {
    window.history.back(-1);
}

function reservation() {
    alert('this is to do!');
}

// 传回的信息加载在页面之上
function information(data) {
    let teacherName = $('#teacherName');
    let teacherImage = $('#teacherImage');
    let lookNumber = $('#lookNumber');
    let authentication = $('#authentication');
    let experience = $('#experience');
    let subject = $('#subject');
    let teacherTime = $('#teacherTime');
    let teacherCost = $('#teacherCost');
    let discount = $('#discount');
    let contact = $('#contact');
    let personInformation = $('#personInformation');

    teacherName.html(data.teacherName);
    teacherImage.prop({ 'src': data.teacherImage });
    lookNumber.html(data.lookNumber);
    authentication.html(data.authentication);
    experience.html(data.experience);
    subject.html(data.subject);
    teacherTime.html(data.teacherTime);
    teacherCost.html(data.teacherCost);
    discount.html(data.discount);
    contact.html(data.contact);
    personInformation.html(data.personInformation);
}

function getInformation() {
    let lookNumber = $('#lookNumber');
    let teacherName = $('#teacherName');
    url = 'www.baid.com';
    let data = {
        "teacherName": teacherName.html(),
        "lookNumber=": lookNumber.html()
    };

    ajaxMain('POST', url, data, information);
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