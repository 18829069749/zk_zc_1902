/**
 * Created by Administrator on 2019/5/28.
 */
var delId;
function delone(id){
    alert("delete"+id);
    delId = id;
    var url = "http://localhost:8080/del?id="+id;
    myAjax("GET",url,true,null,success);
}
function success(msg){
    alert("6666")
    if(msg =="success"){
        alert("删除成功！");
        //    局部更新列表
        var tb =  document.getElementById("tbody_one");
        var delTr = document.getElementById(delId);
        alert(delTr)
        tb.removeChild(delTr);//删除页面的行
    }else{
        alert("删除失败！");
    }

}

