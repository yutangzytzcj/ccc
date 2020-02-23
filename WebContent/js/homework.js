// JavaScript Document
function add(){
    var teachercourse=document.getElementById('TeachCourse');
    var student=document.getElementById('Student');
    var Title=document.getElementById('Title');
    if(teachercourse.value==""||teachercourse.value.length==0||teachercourse.value==null){
        alert("课程不能为空！");
        teachercourse.focus();
    }
    else if(student.value==""||student.value.length==0||student.value==null){
        alert("学生不能为空！");
        student.focus();
    }
    else if(Title.value==""||Title.value.length==0||Title.value==null){
        alert("作业不能为空！");
        Title.focus();
    }
    else{
        document.forms['form1'].submit();
    }
}