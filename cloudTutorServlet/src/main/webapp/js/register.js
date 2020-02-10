function checkUsername() {
    let username = $("#username").val();
    let regUsername = /^\w{4,20}$/;
    let flag = regUsername.test(username);
    if (flag) {
        $("#username").css("border", "");
    } else {
        $("#username").css("border", "1px solid red");
    }
    return flag;
}

function checkPassword() {
    let password = $("#password").val();
    let reg_password = /^\w{8,20}$/;
    let flag = reg_password.test(password);
    if (flag) {
        $("#password").css("border", "");
    } else {
        $("#password").css("border", "1px solid red");
    }
    return flag;
}

function checkEmail() {
    let email = $("#email").val();
    let reg_email = /^\w+@\w+\.\w+$/;
    let flag = reg_email.test(email);
    if (flag) {
        $("#email").css("border", "");
    } else {
        $("#email").css("border", "1px solid red");
    }
    return flag;
}


function changeCheckCode() {
    $(this).attr('src', "checkCode?" + new Date().getTime());
}


$(function () {
    $("#registerButton").on({
        click: () => {
            if (checkUsername() && checkPassword() && checkEmail()) {
                $.post("register", $("#registerForm").serialize(), function (data) {
                    if (data["flag"] == "true") {
                        alert("注册成功，请注意查收邮件进行激活");
                    } else if (data["flag"] == "false") {
                        alert(data["errorMsg"]);
                    }
                });

            }
            return false;
        }
    });

    $("#checkCode").on({
        click: changeCheckCode
    });

    $("#username").on({
        blur: checkUsername
    });
    $("#password").on({
        blur: checkPassword
    });
    $("#email").on({
        blur: checkEmail
    });
});
