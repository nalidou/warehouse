var _id = 0;
function addOne() {

    var context = $("#in_context");
    var tr = $("<tr id='_tr_"+_id+"'></tr>");
    tr.append("<td style='width: 100px'><input required=\"required\" id='name_"+_id+"'></td>");
    tr.append("<td style='width: 80px'><input required=\"required\" id='standard_"+_id+"'></td>");
    tr.append("<td style='width: 80px'><input required=\"required\" id='unit_"+_id+"'></td>");
    tr.append("<td style='width: 80px'><input required=\"required\" id='price_"+_id+"'></td>");
    tr.append("<td style='width: 100px'><input required=\"required\" id='producedate_"+_id+"'></td>");
    tr.append("<td style='width: 60px'><input required=\"required\" id='guaranteeperiod_"+_id+"'></td>");
    tr.append("<td style='width: 60px'><input required=\"required\" id='number_"+_id+"'></td>");
    tr.append("<td style='width: 100px'><input required=\"required\" id='posencode_"+_id+"'></td>");
    tr.append("<td style='width: 100px'>" +
            "<center><button class='btn btn-primary radius' onclick='delOne("+_id+")'>删除</button></center>" +
        "</td>");

    context.append(tr);
    _id ++ ;
}
function delOne(id) {
    $("#_tr_"+id).remove();

}

function save() {
    var param = "";
    $("#in_context").find("tr").each(function(){
        var tdArr = $(this).children();
        var name_ = tdArr.eq(0).find('input').val();//
        var standard_ = tdArr.eq(1).find('input').val();//
        var unit_ = tdArr.eq(2).find('input').val();//
        var price_ = tdArr.eq(3).find('input').val();//
        var producedate_ = tdArr.eq(4).find('input').val();//
        var guaranteeperiod_ = tdArr.eq(5).find('input').val();//
        var number_ = tdArr.eq(6).find('input').val();//
        var posencode_ = tdArr.eq(7).find('input').val();//
        if(name_ == ''){popup({type:'error',msg:"存在空值",delay:1000,bg:true,clickDomCancel:true});return false;}
        if(standard_ == ''){ popup({type:'error',msg:"存在空值",delay:1000,bg:true,clickDomCancel:true});return false;}
        if(unit_ == ''){popup({type:'error',msg:"存在空值",delay:1000,bg:true,clickDomCancel:true});return false;}
        if(producedate_ == ''){popup({type:'error',msg:"存在空值",delay:1000,bg:true,clickDomCancel:true});return false;}
        if(guaranteeperiod_ == ''){popup({type:'error',msg:"存在空值",delay:1000,bg:true,clickDomCancel:true});return false; }
        if(number_ == ''){popup({type:'error',msg:"存在空值",delay:1000,bg:true,clickDomCancel:true}); return false;}
        if(posencode_ == ''){popup({type:'error',msg:"存在空值",delay:1000,bg:true,clickDomCancel:true}); return false;}
        param += name_+":"+standard_+":"+unit_+":"+price_+":"+producedate_+":"
            +guaranteeperiod_+":"+number_+":"+posencode_+";";
    });

    $.ajax({
        url: "/food-remander/in-warehouse",
        type: "POST", //请求的方式
        dataType : 'json',
        data: {
            "param":param
        },
        error:function (data) {
            console.log("请求失败");
        },
        success:function (data) {
            if(data.state == 1){
                popup({type:'success',msg:"成功",delay:1000,callBack:function(){
                        $("#in_context").empty();
                    }});
            }else{
                popup({type:'error',msg:"失败",delay:1000,bg:true,clickDomCancel:true});
                return false;

            }
        }
    });


}

function uploadBash() {
    $("form").submit(function() {return false;});

    var formData = new FormData(document.getElementById("uploadForm"));
    $.ajax({
        url: "/food-remander/in-warehouse-bash",
        method: 'POST',
        data: formData,
        contentType: false,
        processData: false,
        success: function (resp) {
            popup({type:'success',msg:"成功",delay:1000,callBack:function(){
                    $("#file").empty();
                }});
            return false;
            }
        });
}


function list_godownentry() {

    var table;
    function attendQuery() {
        table.ajax.reload();
    }
    $(function () {
        //提示信息
        $.fn.dataTable.ext.errMode = 'none';
        var lang = {
            "sProcessing": "处理中...",
            "sLengthMenu": "每页 _MENU_ 项",
            "sZeroRecords": "没有匹配结果",
            "sInfo": "当前显示第 _START_ 至 _END_ 项，共 _TOTAL_ 项。",
            "sInfoEmpty": "当前显示第 0 至 0 项，共 0 项",
            "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
            "sInfoPostFix": "",
            "sSearch": "搜索:",
            "sUrl": "",
            "sEmptyTable": "表中数据为空",
            "sLoadingRecords": "载入中...",
            "sInfoThousands": ",",
            "oPaginate": {
                "sFirst": "首页",
                "sPrevious": "上页",
                "sNext": "下页",
                "sLast": "末页",
                "sJump": "跳转"
            },
            "oAria": {
                "sSortAscending": ": 以升序排列此列",
                "sSortDescending": ": 以降序排列此列"
            }
        };
        //初始化表格
        table = $("#warehouse-search-table").on('error.dt', function (e, settings, techNote, message) {
            console.warn(message)
        }).dataTable({
            language: lang, //提示信息
            autoWidth: false, //禁用自动调整列宽
            stripeClasses: ["odd", "even"], //为奇偶行加上样式，兼容不支持CSS伪类的场合
            processing: true, //隐藏加载提示,自行处理
            serverSide: false, //启用服务器端分页
            searching: false, //禁用原生搜索
            orderMulti: false, //启用多列排序
            order: [], //取消默认排序查询,否则复选框一列会出现小箭头
            renderer: "bootstrap", //渲染样式：Bootstrap和jquery-ui
            pagingType: "simple_numbers", //分页样式：simple,simple_numbers,full,full_numbers
            destroy:true,//解决不能重新初始化的问题
            columnDefs: [{
                "targets": 'nosort', //列的样式名
                "orderable": false //包含上样式名‘nosort'的禁止排序
            }],
            ajax: function (data, callback, settings) {
                //封装请求参数
                var param = {
                    "start":$("#start").val(),
                    "end":$("#end").val(),
                    "entry_order_number":$("#key").val()
                };
                param.pageSize = data.length;//页面显示记录条数，在页面显示每页显示多少项的时候
                param.start = data.start;//开始的记录序号
                param.currentPage = (data.start / data.length) + 1;//当前页码
                //console.log(param);
                //ajax请求数据
                $.ajax({
                    type: "post",
                    url: "/food-remander/list-godownentry",
                    cache: false, //禁用缓存
                    data: param, //传入组装的参数
                    dataType: "json",
                    success: function (result) {
                        var returnData = {};
                        returnData.draw = data.startRow;//这里直接自行返回了draw计数器,应该由后台返回
                        returnData.recordsTotal = result.totalRows;//返回数据全部记录
                        returnData.recordsFiltered = result.totalRows;//后台不实现过滤功能，每次查询均视作全部结果
                        returnData.data = result.items;//返回的数据列表
                        //此时的数据需确保正确无误，异常判断应在执行此回调前自行处理完毕
                        callback(returnData);
                    }
                });
            },
            "columns": [

                {'data': 'id',render:function (data, type, full) {
                        return "<center>"+full.id+"</center>";
                    }},
                {'data': 'id',render:function (data, type, full) {
                        return "<center><a onclick=\"write_entry_order_number('"+full.entry_order_number+"')\" " +
                        "href=\"in-warehouse-detail.html\">"+full.entry_order_number+"</a></center>";
                    }},
                {'data': 'id',render:function (data, type, full) {
                        return "<center>"+full.entrydateStr+"</center>";
                    }},
                {'data': 'id',render:function (data, type, full) {
                        return "<center>"+full.entryman+"</center>";
                    }}
            ]
        }).api();

    });
}

function get_entry_order_detail() {

    var table;
    function attendQuery() {
        table.ajax.reload();
    }
    $(function () {
        //提示信息
        $.fn.dataTable.ext.errMode = 'none';
        var lang = {
            "sProcessing": "处理中...",
            "sLengthMenu": "每页 _MENU_ 项",
            "sZeroRecords": "没有匹配结果",
            "sInfo": "当前显示第 _START_ 至 _END_ 项，共 _TOTAL_ 项。",
            "sInfoEmpty": "当前显示第 0 至 0 项，共 0 项",
            "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
            "sInfoPostFix": "",
            "sSearch": "搜索:",
            "sUrl": "",
            "sEmptyTable": "表中数据为空",
            "sLoadingRecords": "载入中...",
            "sInfoThousands": ",",
            "oPaginate": {
                "sFirst": "首页",
                "sPrevious": "上页",
                "sNext": "下页",
                "sLast": "末页",
                "sJump": "跳转"
            },
            "oAria": {
                "sSortAscending": ": 以升序排列此列",
                "sSortDescending": ": 以降序排列此列"
            }
        };
        //初始化表格
        table = $("#list-detail-table").on('error.dt', function (e, settings, techNote, message) {
            console.warn(message)
        }).dataTable({
            language: lang, //提示信息
            autoWidth: false, //禁用自动调整列宽
            stripeClasses: ["odd", "even"], //为奇偶行加上样式，兼容不支持CSS伪类的场合
            processing: true, //隐藏加载提示,自行处理
            serverSide: false, //启用服务器端分页
            searching: false, //禁用原生搜索
            orderMulti: false, //启用多列排序
            order: [], //取消默认排序查询,否则复选框一列会出现小箭头
            renderer: "bootstrap", //渲染样式：Bootstrap和jquery-ui
            pagingType: "simple_numbers", //分页样式：simple,simple_numbers,full,full_numbers
            destroy:true,//解决不能重新初始化的问题
            columnDefs: [{
                "targets": 'nosort', //列的样式名
                "orderable": false //包含上样式名‘nosort'的禁止排序
            }],
            ajax: function (data, callback, settings) {
                //封装请求参数
                var param = {

                };
                param.pageSize = data.length;//页面显示记录条数，在页面显示每页显示多少项的时候
                param.start = data.start;//开始的记录序号
                param.currentPage = (data.start / data.length) + 1;//当前页码
                //console.log(param);
                //ajax请求数据
                $.ajax({
                    type: "post",
                    url: "/food-remander/get-entry-order-detail",
                    cache: false, //禁用缓存
                    data: param, //传入组装的参数
                    dataType: "json",
                    success: function (result) {
                        var returnData = {};
                        returnData.draw = data.startRow;//这里直接自行返回了draw计数器,应该由后台返回
                        returnData.recordsTotal = result.totalRows;//返回数据全部记录
                        returnData.recordsFiltered = result.totalRows;//后台不实现过滤功能，每次查询均视作全部结果
                        returnData.data = result.items;//返回的数据列表

                        $("#entryNum1").text(result.map.entryNum);
                        $("#entryNum2").text(result.map.entryNum);
                        $("#kuguan").text(result.map.entryMan);
                        //此时的数据需确保正确无误，异常判断应在执行此回调前自行处理完毕
                        callback(returnData);
                    }
                });
            },
            "columns": [

                {'data': 'id',render:function (data, type, full) {
                        return "<center>"+full.fID+"</center>";
                    }},
                {'data': 'id',render:function (data, type, full) {
                        return "<center>"+full.name+"</center>";
                    }},
                {'data': 'id',render:function (data, type, full) {
                        return "<center>"+full.standard+"</center>";
                    }},
                {'data': 'id',render:function (data, type, full) {
                        return "<center>"+full.unit+"</center>";
                    }},
                {'data': 'id',render:function (data, type, full) {
                        return "<center>"+full.ennumber+"</center>";
                    }},
                {'data': 'id',render:function (data, type, full) {
                        return "<center>"+full.price+"</center>";
                    }},
                {'data': 'id',render:function (data, type, full) {
                        return "<center>"+full.producedate+"</center>";
                    }},
                {'data': 'id',render:function (data, type, full) {
                        return "<center>"+full.guaranteeperiod+"</center>";
                    }},
                {'data': 'id',render:function (data, type, full) {
                        return "<center>"+full.posencode+"</center>";
                    }},
                {'data': 'id',render:function (data, type, full) {
                        return "<center>"+full.entrydateStr+"</center>";
                    }},
                {'data': 'id',render:function (data, type, full) {
                        return "<center>"+full.entryman+"</center>";
                    }}

            ]
        }).api();

    });
}

function write_entry_order_number(num) {

    $.ajax({
        url: "/food-remander/write-entry-order-number",
        type: "POST",
        dataType : 'json',
        data: {
            "num":num
        },
        error:function (data) {
            console.log("请求失败");
        },
        success:function (data) {

        }
    });
}

