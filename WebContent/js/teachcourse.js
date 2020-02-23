// JavaScript Document
function add(){
    var Name=document.getElementById('Name');
    
    if(Name.value==""||Name.value.length==0||Name.value==null){
        alert("名称不能为空！");
        Name.focus();
    }
    else{
        document.forms['form1'].submit();
    }
}