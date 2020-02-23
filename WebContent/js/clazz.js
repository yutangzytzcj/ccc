// JavaScript Document
function add(){
    var name=document.getElementById('Name');
    var master=document.getElementById('Master');
    if(name.value==""||name.value.length==0||name.value==null){
        alert("名称不能为空！");
        name.focus();
    }
    else if(master.value==""||master.value.length==0||master.value==null){
        alert("班主任不能为空！");
    }
    else{
        document.forms['form1'].submit();
    }
}