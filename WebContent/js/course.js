// JavaScript Document
function add(){
    var name=document.getElementById('Name');
    if(name.value==""||name.value.length==0||name.value==null){
        alert("名称不能为空！");
    }
    else{
        document.forms['form1'].submit();
    }
}