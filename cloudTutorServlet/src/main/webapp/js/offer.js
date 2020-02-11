$(function () {
    var offerId = getParameter("offerId");
    var searchName = getParameter("searCh");
    if (searchName) {
        searchName = window.decodeURIComponent(searchName);
    }

    load(offerId, null, searchName);
});

//截取搜索框的搜索内容
function getParameter(name) {
    let reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    let r = location.search.substr(1).match(reg);
    let temp = r.split("&");
    temp = temp[0].split("=");
    if (r != null) return (temp[1]);
    return null;
}

function load(cid, currentPage, rname) {
    //发送ajax请求，请求route/pageQuery,传递cid
    $.get("offer/pageQuery", {currentPage: currentPage, searchName: searchName}, function (data) {
        $("#totalPage").html(data.totalPage);
        $("#totalCount").html(data.totalCount);

        let lis = "";
        let firstPage = '<li onclick="javascipt:load(' + cid + ',1,\'' + rname + '\')"><a href="javascript:void(0)">首页</a></li>';
        
        let beforeNum = data.currentPage - 1;
        if (beforeNum <= 0) {
            beforeNum = 1;
        }
        let beforePage = '<li  onclick="javascipt:load(' + cid + ',' + beforeNum + ',\'' + rname + '\')" class="threeword"><a href="javascript:void(0)">上一页</a></li>';

        lis += firstPage;
        lis += beforePage;
        
        let begin; 
        let end; 
        
        if (data.totalPage < 10) {
            begin = 1;
            end = data.totalPage;
        } else {
            begin = data.currentPage - 5;
            end = data.currentPage + 4;

            //2.如果前边不够5个，后边补齐10个
            if (begin < 1) {
                begin = 1;
                end = begin + 9;
            }

            //3.如果后边不足4个，前边补齐10个
            if (end > data.totalPage) {
                end = data.totalPage;
                begin = end - 9;
            }
        }


        for (let i = begin; i <= end; i++) {
            let li;
            //判断当前页码是否等于i
            if (data.currentPage == i) {

                li = '<li class="curPage" onclick="javascipt:load(' + cid + ',' + i + ',\'' + rname + '\')"><a href="javascript:void(0)">' + i + '</a></li>';

            } else {
                //创建页码的li
                li = '<li onclick="javascipt:load(' + cid + ',' + i + ',\'' + rname + '\')"><a href="javascript:void(0)">' + i + '</a></li>';
            }
            //拼接字符串
            lis += li;
        }

        let lastPage = '<li class="threeword"><a href="javascript:;">末页</a></li>';
        let nextPage = '<li class="threeword"><a href="javascript:;">下一页</a></li>';

        lis += nextPage;
        lis += lastPage;
        $("#pageNum").html(lis);


        let offer_list = "";
        for (let i = 0; i < data.list.length; i++) {
            let offer = data.list[i];

            let div =
                '<div class="tutor">' +
                '<div class="tutor-line"></div>' +
                '<div class="tutor-time" id="time">' + offer.time + '</div>' +
                '<div class="tutor-job">' +
                '<div class="job-title">认证信息：</div>' +
                '<div class="job-content" id="certification">' + data.certification + '</div>' +
                '</div>' +
                '<div class="tutor-job">' +
                '<div class="job-title">性别：</div>' +
                '<div class="job-content" id="sex">' + data.sex + '</div>' +
                '</div>' +
                '<div class="tutor-job">' +
                '<div class="job-title">具体要求：</div>' +
                '<div class="job-content" id="claim">' + data.claim +  '</div>' +
                '</div>' +
                '<div class="tutor-job">' +
                '<div class="job-title">费用：</div>' +
                '<div class="job-content" id="fee">' + data.fee + '</div>' +
                '</div>' +
                '<div class="tutor-job">' +
                '<div class="job-title">地址：</div>' +
                '<div class="job-content" id="address">' + data.address + '</div>' +
                '</div>' +

                '<button class="tutor-button" name="' + data.offerId +'" id="apply">点击应聘</button>' +
                '</div>';

            offer_list += div;
        }
        $("#offerContent").html(offer_list);

        window.scrollTo(0, 0);
    });
}