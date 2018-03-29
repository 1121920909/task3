var hobbyArray = ["体育","音乐","旅游","游戏"];
var collegeArray = ["管理学院","机械学院"];
var majorArray = {0101:"信息管理与信息系统专业",0102:"电子商务",0201:"机械制造及其自动化",0202:"工业工程"};
function majorChange() {
    var select = $("#major")[0];
    var college = $("#college")[0];
    if (college.selectedIndex == 0) {
        select.innerHTML = "<option value='0101'>信息管理与信息系统</option>" +
            "<option value='0102'>电子商务</option>"
    }
    else if (college.selectedIndex == 1) {
        select.innerHTML = "<option value='0201'>机械制造及其自动化</option>" +
            "<option value='0202'>工业工程</option>"
    }
}

function addStudent() {
    var student = {};
    var name = $("#name");
    var age = $("#age");
    var sex = $("[name = 'sex']");
    var hobby = $("[name = 'hobby']");
    var college = $("#college");
    var major = $("#major");
    student.name = name[0].value;
    student.age = age[0].value;
    if (sex[0].checked) {
        student.sex = "男";
    }
    else {
        student.sex = "女";
    }
    for (var i = 0; i < hobby.length; i++){
        student.hobby  = "";
        if (hobby[i].checked) {
            student.hobby += hobbyArray[i];
        }
    }
    student.college = collegeArray[college[0].selectedIndex];
    student.major = majorArray[major[0].selectedOptions[0].value];
    $.ajax({
        type:"post",
        url:"./insert",
        data:{
            "studentJson": JSON.stringify(student)
        }
    })
}
function updateStudent() {
    var student = {};
    var name = $("#name");
    var age = $("#age");
    var sex = $("[name = 'sex']");
    var hobby = $("[name = 'hobby']");
    var college = $("#college");
    var major = $("#major");
    student.name = name.val();
    student.age = age.val();

    if (sex[0].checked) {
        student.sex = "男";
    }
    else {
        student.sex = "女";
    }
    for (var i = 0; i < hobby.length; i++){
        student.hobby  = "";
        if (hobby[i].checked) {
            student.hobby += hobby[i].val();
        }
    }

    student.college = college.val();
    student.major = major.val();
    $.ajax({
        type: "post",
        url: "./update",
        data: {
            "studentJson": JSON.stringify(student)
        },
        error: function () {
            alert("ERROR");
        }
    });
}
