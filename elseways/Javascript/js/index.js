window.onload = function(){
    
};

 
let talentMan = document.getElementById('talentMan');
let helpCenter = document.getElementById('helpCenter');
let contactUs = document.getElementById('contactUs');
talentMan.onclick = alertToDo;
helpCenter.onclick = alertToDo;
contactUs.onclick = alertToDo;



function index(){
    window.location = '#';
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


var ajax = {
    get: function (url, fn) {
        let xhr;
        if (window.XMLHttpRequest) {
            xhr = new XMLHttpRequest();
        } else {
            xhr = new ActiveXObject('Microsoft.XMLHTTP');
        }

        xhr.open('GET', url, true);
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4) {
                if (xhr.status == 200 || xhr.status == 304) {
                    console.log(xhr.responseText);
                    fn.call(this, xhr.responseText);
                } else {
                    console.log(xhr.status);
                }
            } else {
                console.log(xhr.readyState);
            }
        }
        xhr.send(null);
    },

    post: function (url, data, fn) {
        let xhr;
        if (window.XMLHttpRequest) {
            xhr = new XMLHttpRequest();
        } else {
            xhr = new ActiveXObject('Microsoft.XMLHTTP');
        }

        xhr.open('POST', url, true);
        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 400) {
                if (xhr.status == 200 || xhr.status == 304) {
                    console.log(xhr.responseText);
                    fn.call(this, xhr.responseText);
                }
            }
        }
        xhr.send(data);
    }
}

// 添加cookie的函数
function addCookie(name, value, expireHours) {
    let cookieString = name + "=" + escape(value);
    //判断是否设置过期时间
    if (expireHours > 0) {
        let date = new Date();
        date.setTime(date.getTime + expireHours * 3600 * 1000);
        cookieString = cookieString + ";expire=" + date.toGMTString();
    }
    document.cookie = cookieString;
}

// 获取指定的cookie
function getCookie(name) {
    let strCookie = document.cookie;
    let arrCookie = strCookie.split(";");
    for (let i = 0; i < arrCookie.length; i++) {
        let arr = arrCookie[i].split("=");
        if (arr[0] == name)
            return arr[1];
    }
    return "";
}

// 改变指定的cookie
function changeCookie(name, value) {
    document.cookie(name + '=' + escape(value));
}