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

// 返回按钮响应事件
const returnTo = () => {
    window.history.back(-1);
}

const reservation = () => {
    alert('this is to do!');
}

// 传回的信息加载在页面之上
const information = (data) => {
    $('#teacherName').html(data.teacherName);
    $('#teacherImage').prop({ 'src': data.teacherImage });
    $('#lookNumber').html(data.lookNumber);
    $('#authentication').html(data.authentication);
    $('#experience').html(data.experience);
    $('#subject').html(data.subject);
    $('#teacherTime').html(data.teacherTime);
    $('#teacherCost').html(data.teacherCost);
    $('#discount').html(data.discount);
    $('#contact').html(data.contact);
    $('#personInformation').html(data.personInformation);
}

const getInformation = () => {
    let lookNumber = $('#lookNumber');
    let teacherName = $('#teacherName');
    url = 'www.baid.com';
    let data = {
        "teacherName": teacherName.html(),
        "lookNumber=": lookNumber.html()
    };

    ajaxMain('POST', url, data, information);
}

$(() => {
    alert('this is test!');
    // getInformation();
})