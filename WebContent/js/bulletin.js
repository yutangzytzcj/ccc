
function add(){
    var title=document.getElementById('Title');
    var content=document.getElementById('Content');
    
    if(title.value==""||title.value.length==0||title.value==null){
        alert("标题不能为空＄1�7");
        title.focus();
    }
    else if(content.value==""||content.value.length==0||content.value==null){
        alert("内容不能为空＄1�7");
        content.focus();
    }
    else{
        document.forms['form1'].submit();
    }
}


