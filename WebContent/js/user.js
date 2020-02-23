// JavaScript Document
//验证用户登录
function login(){
    var uname=document.getElementById('username');
    var upwd=document.getElementById('password');
    if(uname.value==""||uname.value.length==0||uname==null){
        alert("用户名不能为空！");
        uname.focus();
    }
    else if(upwd.value==""||upwd.value.length==0||upwd.value==null){
        alert("用户密码不能为空！");
        upwd.focus();
    }
    else{
        document.forms['form1'].submit();
    }
}

//验证添加管理员/验证编辑管理员信息
function add(){
    var name=document.getElementById('Name');
    var password=document.getElementById('Password');
    if(name.value==""||name.value==null||name.value.length==0){
        alert("名称不能为空！");
        name.focus();
    }
    else if(password.value==""||password.value==null||password.value.length==0){
        alert("密码不能为空！");
        password.focus();
    }else{
        document.forms['form1'].submit();
    }
    
}
