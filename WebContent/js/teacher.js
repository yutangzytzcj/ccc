// JavaScript Document
function add(){
    var Name=document.getElementById('Name');
    var Sex=document.getElementById('Sex');
    var Mobile=document.getElementById('Mobile');
    var Password=document.getElementById('Password');
    if(Name.value==""||Name.value.length==0||Name.value==null){
        alert("姓名不能为空！");
        Name.focus();
    }
    else if(Sex.value==""||Sex.value.length==0||Sex.value==null){
        alert("性别不能为空！");
        Sex.focus();
    }
    else if(Mobile.value==""||Mobile.value.length==0||Mobile.value==null){
        alert("性别不能为空！");
        Mobile.focus();
    }
    else if(Password.value==""||Password.value.length==0||Password.value==null){
        alert("密码不能为空！");
        Password.focus();
    }
    else{
        document.forms['form1'].submit();
    }
}