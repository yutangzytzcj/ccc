// JavaScript Document
function add(){
    var name=document.getElementById('Name');
    var clazz=document.getElementById('Clazz');
    var Sex=document.getElementById('Sex');
    var Mobile=document.getElementById('Mobile');
    var Password=document.getElementById('Password');
    if(name.value==""||name.value.length==0||name.value==null){
        alert("姓名不能为空！");
        name.focus();
    }
    else if(clazz.value==""||clazz.value.length==0||clazz.value==null){
        alert("班级不能为空！");
        clazz.focus();
    }
    else if(Sex.value==""||Sex.value.length==0||Sex.value==null){
        alert("性别不能为空！");
        Sex.focus();
    }
    else if(Mobile.value==""||Mobile.value.length==0||Mobile.value==null){
        alert("手机不能为空！");
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