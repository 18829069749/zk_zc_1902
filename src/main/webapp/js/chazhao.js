/**
 * Created by Administrator on 2019/5/30.
 */

function chazhao(){

        var onename=document.getElementById("chaxunone").value;
        var url = "http://localhost:8080/chaxun1?name="+onename;
        myAjax("GET",url,true,null,sucess);


}
function sucess(das){
    if(das !=null){
        // alert("成功+++！"+msg);
        //    局部更新列表
        var datas2 =  JSON.parse(das);
        // alert("成功！"+datas2.length);
        var tb =  document.getElementById("tbody_one");
        var arrone =new Array();
        var arrtwo =new Array();

        // for(var j =0;j<datas.length ;j++){
        for(var i=0;i<tb.rows.length;i++) {
            var idt = tb.rows[i].cells[2].innerText;
            arrone[i] =parseInt( idt);
            // alert(idt);
            // }

            for (var j = 0; j < datas2.length; j++) {
                // alert("===" + datas2[j].id);
                arrtwo[j] =datas2[j].id;

            }
        }
        console.log(arrone);
        console.log(arrtwo);

        for ( var x=0;x<arrone.length;x++){

            console.log(arrtwo.indexOf(arrone[x]));
            if(arrtwo.indexOf(arrone[x])==-1){
                document.getElementById(arrone[x]).style.display="none";

            }

        }


//                    var delTr = document.getElementById(delId);

    }else{
        alert("失败！");
    }

}

