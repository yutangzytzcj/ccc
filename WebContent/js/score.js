// JavaScript Document
function add(){
    var score=document.getElementById('Score');
    var title=document.getElementById('Title');
    if(score.value==""||score.value.length==0||score.value==null){
        alert("考试不能为空！");
        score.focus();
    }
    else if(title.value==""||title.value.length==0||title.value==null){
        alert("成绩不能为空！");
        title.focus();
    }
    else{
        document.forms['form1'].submit();
    }
}