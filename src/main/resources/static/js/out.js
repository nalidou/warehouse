function getFoodList() {
    $.ajax({
        url: "/food-remander/get-list",
        type: "GET", //请求的方式
        dataType : 'json',
        data: {},
        error:function (data) {
           // alert("操作失败")
            //popup({type:'error',msg:"操作失败",delay:2000,bg:true,clickDomCancel:true});
        },
        success:function (data) {
            if(data.state == 1){
                var size = data.size;

                $("#food-list").empty();
                for(var i=0;i<size;i++){
                    id_list.push(data.list[i].fID);
                    var tr = $("<tr></tr>");
                    td_1 = "<td>"+data.list[i].fID+"</td>";
                    td_2 = "<td>"+data.list[i].name+"</td>";
                    td_3 = "<td>"+data.list[i].standard+"</td>";
                    td_4 = "<td>"+data.list[i].unit+"</td>";
                    td_5 = "<td>"+data.list[i].ennumber+"</td>";
                    td_6 = "<td>"+data.list[i].renumber+"</td>";
                    //td_7 = "<td>"+data.list[i].detailID+"</td>";
                    td_8 = "<td>"+data.list[i].price+"</td>";
                    td_9 = "<td>"+data.list[i].producedate+"</td>";
                    td_10 = "<td>"+data.list[i].guaranteeperiod+"</td>";
                    td_11 = "<td>"+data.list[i].posencode+"</td>";
                    //td_12 = "<td>"+data.list[i].enID+"</td>";
                    //td_13 = "<td>"+data.list[i].entrydate+"</td>";
                    td_14 = "<td>"+data.list[i].entryman+"</td>";
                    td_15 = "<input id=out_"+data.list[i].fID+"></input></td>";
                    tr.append(td_1);
                    tr.append(td_2);
                    tr.append(td_3);
                    tr.append(td_4);
                    tr.append(td_5);
                    tr.append(td_6);
                    //tr.append(td_7);
                    tr.append(td_8);
                    tr.append(td_9);
                    tr.append(td_10);
                    tr.append(td_11);
                    //tr.append(td_12);
                    //tr.append(td_13);
                    tr.append(td_14);
                    tr.append(td_15);
                    $("#food-list").append(tr);
                }


            }else{
                alert("获取数据失败")
                return false;
            }
        }
    });



}
var id_list = new Array();
function outFood() {
    var param = "";
    for(i in id_list){
        var v = $("#out_"+id_list[i]).val();
        if(v == "" || v == null){
            v = 0;
        }
        param +=id_list[i]+","+v+";";
    }
    $.ajax({
        url: "/food-remander/out-food",
        type: "GET", //请求的方式
        dataType : 'json',
        data: {
            "param":param
        },
        error:function (data) {
        },
        success:function (data) {
            if(data.state == 1){
                alert("success")
                location.assign("/");
            }
        }
    });
}