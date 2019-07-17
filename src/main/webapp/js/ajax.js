/**
 * Created by Administrator on 2019/5/28.
 */
function myAjax(method,url,sync,data,mySuccess) {
//    1、创建XmlHttpRequest对象
    var xhr;
    if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest();
    } else {//ie系列浏览器
        xhr = new ActiveXObject("Microsoft.XMLHttpRequest");
    }

//    2、设置回调函数
    xhr.onreadystatechange = function(){
        if( xhr.readyState == 4 && xhr.status == 200 ){
            mySuccess(xhr.responseText);//传引用参数执行外部函数
        }
    }
//    3、设置请求的地址参数
//     var url = "http://localhost:8080/bmi?action=list";
    xhr.open("GET", url, true);
//    4、发送请求
    xhr.send(data);
}