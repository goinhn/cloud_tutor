window.onload = function () {
    if (this.getCookie('isLogin') === 'true') {
        // 跳转到index界面
    }
}


function index() {
    let url = '=====';
    ajax['get'](url, function () {

    });
}

function recruitment() {
    let url = '=====';
    ajax['get'](url, function () {

    });
}

function tutorInformation() {
    let url = '=====';
    ajax['get'](url, function () {

    });
}
function login() {
    window.location = '#';
}

function register() {
    let url = '=====';
    ajax['get'](url, function () {

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


function accountCheckBlur() {
    let username = document.getElementById('username');
    let prompt = document.getElementById('accountPrompt');
    console.log(username);
    if (username.value.length > 20) {
        alert('error account!');
        prompt.innerHTML = '账号的长度不超过20个字符';
    } else {
        prompt.innerHTML = '';
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

// 登录验证函数
function loginSubmit() {
    let userId = document.getElementById('username');
    let userPassword = document.getElementById('userPassword');

    // 后端响应处理函数

    if (true) {
        this.addCookie('isLogin', 'true', 24);
        // 跳转到index界面
    } else {
        alert('账号或者密码错误请重新输入');
    }
}