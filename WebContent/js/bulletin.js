
function add(){
    var title=document.getElementById('Title');
    var content=document.getElementById('Content');
    
    if(title.value==""||title.value.length==0||title.value==null){
        alert("鏍囬涓嶈兘涓虹┖锛�");
        title.focus();
    }
    else if(content.value==""||content.value.length==0||content.value==null){
        alert("鍐呭涓嶈兘涓虹┖锛�");
        content.focus();
    }
    else{
        document.forms['form1'].submit();
    }
}


