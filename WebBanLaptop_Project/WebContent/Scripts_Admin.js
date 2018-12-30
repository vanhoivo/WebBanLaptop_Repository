/*EXTERNAL JS*/

//GET TODAY
function ConvertToDate(datetime) {
    return datetime.getFullYear() + "-" + CheckTime(datetime.getMonth() + 1) + "-" + CheckTime(datetime.getDate());
}

//GET FULL WITH ZERO
function CheckTime(i) {
    if (i < 10) { i = "0" + i };
    return i;
}

//CLOCK
function StartTime() {
    var today = new Date();
    var h = today.getHours();
    var m = today.getMinutes();
    var s = today.getSeconds();
    var dd = today.getDate();
    var mm = today.getMonth() + 1; //from 0
    var yyyy = today.getFullYear();

    h = CheckTime(h);
    m = CheckTime(m);
    s = CheckTime(s);
    dd = CheckTime(dd);
    mm = CheckTime(mm);

    var weekday = new Array(7);
    weekday[0] = "Thứ 8";
    weekday[1] = "Thứ 2";
    weekday[2] = "Thứ 3";
    weekday[3] = "Thứ 4";
    weekday[4] = "Thứ 5";
    weekday[5] = "Thứ 6";
    weekday[6] = "Thứ 7";
    var th = weekday[today.getDay()];

    document.getElementById("Clock").innerHTML = h + ":" + m + ":" + s + " - " + th + ", " + dd + "/" + mm + "/" + yyyy;
    var t = setTimeout(StartTime, 500);
}

//LOAD IMAGE
function ReadFile(input, tag) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
            $(tag).attr('src', e.target.result);
        };
        reader.readAsDataURL(input.files[0]);
    }
}

//ADD CLASS
function newFunction() {
    $("footer").addClass("bg-dark");
}

function InsertClass() {
    var elements = document.getElementsByTagName("footer");
    for (var i = 0; i < elements.length; i++) {
        var el = elements[i];
        el.setAttribute("class", el.getAttribute("class") + " bg-dark");
    }
}

/*
let today = new Date().toISOString().substr(0, 10);
document.querySelector("#today").value = today;

document.querySelector("#today2").valueAsDate = new Date();
*/