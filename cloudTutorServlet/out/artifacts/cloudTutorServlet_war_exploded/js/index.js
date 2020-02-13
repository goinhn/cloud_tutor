const recruitment = () => {
    if (judgeLogin === 'true') {
        // 跳转到recruitiment界面进行登录
    } else if (judgeLogin === 'false') {
        alert('请先登录！');
    }
};

const tutorInformation = () => {
    if (judgeLogin === 'true') {
        // 跳转到tutorInformation界面进行登录
    } else if (judgeLogin === 'false') {
        alert('请先登录！');
    }
};

const login = () => {
    if (judgeLogin === 'true') {
        window.location = '#';
    }
};

const register = () => {
    let url = '=====';
    ajax['get'](url, function () {

    });
};


$('#talentMan').on({
    click: alertToDo
});

$('#helpCenter').on({
    click: alertToDo
});

$('#contactUs').on({
    click: alertToDo
})



