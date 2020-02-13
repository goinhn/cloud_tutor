function checkImage() {
    $(this).attr("src", "user/checkCode?" + new Date().getTime());
}

$(function () {
    $("#loginButton").on({
        click: () => {
            $.post("user/login", $("#loginForm").serialize(), function (data) {
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