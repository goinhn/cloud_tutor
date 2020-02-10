function checkImage() {
    $(this).src = "checkCode?" + new Date().getTime();
}

$(function () {
    $("#loginButton").on({
        click: () => {
            $.post("login", $("#loginForm").serialize(), function (data) {
                if (data["flag"] == "true") {
                    alert("登录成功");
                } else if (data["flag"] == "false") {
                    alert(data["errorMsg"]);
                }
            });
            return false;
        }
    });

    $("#checkImage").on({
        click: checkImage
    });
});