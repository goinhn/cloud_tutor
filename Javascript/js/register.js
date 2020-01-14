window.onload = function () {

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
    let url = '=====';
    ajax['get'](url, function () {

    });
}

function register() {
    window.location = '#';
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
                if (xhr.status == 200 | xhr.status == 304) {
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
                if (xhr.status == 200 | xhr.status == 304) {
                    console.log(xhr.responseText);
                    fn.call(this, xhr.responseText);
                }
            }
        }
        xhr.send(data);
    }
}


function accountCheckFocus() {
    let checkAccount = document.getElementById('checkAccount');
    checkAccount.innerHTML = '请输入账号在4-20个字符之间';
}

function accountCheckBlur() {
    let userId = document.getElementById('userId');
    let checkAccount = document.getElementById('checkAccount');

    if (userId.value.length < 4 || userId.value.length > 20) {
        checkAccount.innerHTML = '输入账号不符合要求';
    } else {
        checkAccount.innerHTML = '';
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

function rePasswordCheckBlur() {
    let userPassword = document.getElementById('userPassword');
    let userRePassword = document.getElementById('userRePassword');
    let checkRePassword = document.getElementById('checkRePassword');

    if (userPassword.value === userRePassword.value) {
        checkRePassword.innerHTML = '';
    } else {
        checkRePassword.innerHTML = '两次密码输入的不一致';
    }
}

function submit() {
    let userId = document.getElementById('userId');
    let username = document.getElementById('username');
    let userPassword = document.getElementById('userPassword');
    let userRePassword = document.getElementById('userRePassword');

}