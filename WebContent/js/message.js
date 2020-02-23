// JavaScript Document
function add(){
    var content=document.getElementById('Content');
    if(content.value==""||content.value.length==0||content.value==null){
        alert("留言内容不能为空！");
        content.focus();
    }
    else{
        document.forms['form1'].submit();
    }
}