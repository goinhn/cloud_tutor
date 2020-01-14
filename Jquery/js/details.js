window.onload = function () {
    this.getInformation();
};


// 返回按钮响应事件
function returnTo(){
    window.history.back(-1);
}

function reservation(){
    alert('this is to do!');
}

// 传回的信息加载在页面之上
function information(data){
    let teacherName = document.getElementById('teacherName');
    let authentication = document.getElementById('authentication');
    let experience = document.getElementById('experience');
    let subject = document.getElementById('subject');
    let teacherTime = document.getElementById('teacherTime');
    let teacherCost = doucment.getElementById('teacherCost');
    let discount = doucment.getElementById('discount');
    let contact = document.getElementById('contact');
    let personInformation = document.getElementById('personInformation');

    teacherName.innerHTML = data.teacherName;
    authentication.innerHTML = data.authentication;
    experience.innerHTML = data.experience;
    subject.innerHTML = data.subject;
    teacherTime.innerHTML = data.teacherTime;
    teacherCost.innerHTML = data.teacherCost;
    discount.innerHTML = data.discount;
    contact.innerHTML = data.contact;
    personInformation.innerHTML = data.personInformation;
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

function getInformation(){
    let lookNumber = document.getElementById('lookNumber');
    let teacherName = documnet.getElementById('teacherName');
    url = " ================ ";
    let data = "teacherName="+teacherName+"?"+"lookNumber="+lookNumber; 

    ajax['post'](url, data, information);
}