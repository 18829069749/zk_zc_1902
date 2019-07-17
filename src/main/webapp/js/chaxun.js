/**
 * Created by Administrator on 2019/5/28.
 */

window.onload=function (){
    var xhr;
    if(window.XMLHttpRequest){
        xhr = new  XMLHttpRequest();
    }else{//ie系列浏览器
        xhr = new ActiveXObject("Microsoft.XMLHttpRequest");
    }
//    2、设置回调函数
    xhr.onreadystatechange = huidiao;
//    3、设置请求的地址参数
    var url = "http://localhost:8080/cha";
    xhr.open("GET",url,true);
//    4、发送请求
    xhr.send(null);
//    5、在回调函数中使用dom模型更新页面（局部）
    function huidiao() {
        if( xhr.readyState == 4 && xhr.status == 200 ){
            // alert(xhr.responseText);

            var tb= document.getElementById("tbody_one");
            var datas =  JSON.parse(xhr.responseText);
            for(var i =0;i<datas.length ;i++){
                var tr =  document.createElement("tr");


                tr.id= datas[i].id;
                tr.className = "tbody_one_rsult";
                tr.innerHTML=
            "<td>"+(i+1)+"</td>"+
                "<td><input type='checkbox'></td>"+
                    "<td>"+datas[i].id+"</td>"+
                    "<td>"+datas[i].name+"</td>"+
                    "<td>"+datas[i].email+"</td>"+
                    '<td> <button type="button" class="btn btn-success btn-xs" onclick="guanli()" ><i class=" glyphicon glyphicon-check"></i></button> <button type="button" class="btn btn-primary btn-xs"onclick="updateone('+datas[i].id+')"><i class=" glyphicon glyphicon-pencil"></i></button> <button type="button" class="btn btn-danger btn-xs" onclick="delone('+datas[i].id+')"><i class=" glyphicon glyphicon-remove"></i></button></td>';
                tb.appendChild(tr);

            }

        }

    }


}