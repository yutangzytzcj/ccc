// JavaScript Document
function add(){
    var Result=document.getElementById('Result');
    if(Result.value==""||Result.value.length==0||Result==null){
        alert("考勤情况不能为空！");
    }
    else{
        document.forms['form1'].submit();
    }
}