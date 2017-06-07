(function ($) {
    "use strict";
    var LX = "2";
    var ITEMS_PER_PAGE = 10;
    $(function () {
        queryButton();
        $('#queryDt').datetimepicker({
            format: 'yyyy-mm-dd',//日期的格式
            startDate:'1900-01-01',//选择器的开始日期
            autoclose:true,//日期选择完成后是否关闭选择框
            bootcssVer:3,//显示向左向右的箭头
            language:'zh-CN',//语言
            minView: "month"//表示日期选择的最小范围，默认是hour
        });
        queryNotice(1, ITEMS_PER_PAGE);
    });

    //分页查询
    $("#query").click(function () {
        queryNotice(1, ITEMS_PER_PAGE);
    });

    //发布公告
    $("#fabu").click(function () {
        fabu();
    });

    //删除公告
    $("#del").click(function () {
        del();
    });

    function queryNotice(_page, _pageSize) {

        var cnm = $("#queryFnm").val();
        var vdt = $("#queryDt").val();
        var bt = $("#queryBt").val();
        $.ajax({
            url: "/gongGao/queryGongGaoPage.do",
            type: "POST",
            data: {
                cnm: cnm,
                vdt: vdt,
                bt: bt,
                _page: _page,
                _pageSize: _pageSize
            },
            dataType: "json",
            success: function (res) {
                var medTable = "<table class='table table-hover table-striped '>"
                    + "<thead><tr>"
                    + "<td width='10%'>序号</td>"
                    + "<td width='19%'>标题</td>"
                    + "<td width='19%'>发送人</td>"
                    + "<td width='24%'>发布时间</td>"
                    + "<td width='9%'>阅读人数</td>"
                    + "<td width='19%'>操作</td>"
                    + "</tr></thead>"
                    + "<tbody>";
                if (res.data.length > 0) {
                    for (var i = 0; i < res.data.length; i++) {
                        var j = i+1;
                        var data = res.data[i];
                        medTable += "<tr id='tr" + data.NID + "'>"
                            + "<td title='" + ((i + 1) + (_page - 1) * (_pageSize)) + "'>" + ((i + 1) + (_page - 1) * (_pageSize)) + "</td>"
                            + "<td title='" + data.BT + "'>" + data.BT + "</td>"
                            + "<td title='" + data.NM + "'>" + data.NM + "</td>"
                            + "<td title='" + data.INDT + "'>" + data.INDT + "</td>"
                            + "<td title='" + data.COUNT + "'>" + data.COUNT + "</td>"
                            +  caozuo(data.NID)
                            + "</tr>";
                    }
                }else{
                    medTable += "<tr><td colspan='15' align='center' style='height:40px; font-weight: 700;'>暂无公告!</td></tr>";

                }
                medTable += "</tbody></table>";
                $("#medTable").html(medTable);// 显示表格
                $(".chaKanNotice").click(showChangeDiv);
                $(".delNotice").click(showDel);
                fenYe(_page, _pageSize, res.count);
            }
        });
    }

    function caozuo(nid) {
        if(LX == "1"){
            return "<td><a  class='chaKanNotice' data-nid='"+nid+"'>查看</a>&nbsp;<a  class='delNotice' data-nid='"+nid+"'>删除</a></td>";
        }else{
            return "<td><a  class='chaKanNotice' data-nid='"+nid+"'>查看</a></td>";
        }

    }


    //根据返回值确定是否显示发布按钮
    function queryButton() {
        $.ajax({
            url: "/gongGao/queryButton.do",
            type: "POST",
            dataType: "json",
            success: function (res) {
                if(res.result){
                    var button = "<button type='button' class='btn btn-primary' onclick='fabuModal()';>发布公告</button>";
                    LX = "1";
                    $("#getFabu").html(button);// 显示表格
                }else{
                }
            }
        });
    }





    //发布公告
    function fabu() {
        var addGonggao = {
            bt: htmlEncodeByRegExp($("#addBt").val()) ,
            nr: htmlEncodeByRegExp($("#addNr").val())
        };
        $.ajax({
            url: "/gongGao/sendGongGao.do",
            type: "POST",
            data: addGonggao,
            dataType: "json",
            success: function (res) {
                if(res.result){
                    alert(res.message);
                    queryNotice(1, ITEMS_PER_PAGE);
                    $('#fabuModal').modal('hide');
                    cleanFabuModal();
                }else{
                    alert(res.message);
                }
            }, error: function (xhr) {
                var res = xhr.responseJSON;
                alert(res.message);
            }
        });
    }

    //发布成功之后，清楚modal
    function cleanFabuModal() {
        $("#addBt").val("");
        $("#addNr").val("");
    }

    //弹出删除公告
    function showDel(e) {
        $('#delNid').val(e.target.dataset.nid);
        $('#delModal').modal();
    }

    //删除公告
    function del(e) {
        var nid = $('#delNid').val();
        $.ajax({
            url: "/gongGao/delByNid.do",
            type : "POST",
            data : {
                nid : nid
            },
            dataType : "json",
            success : function(res) {
                if(res.result){
                    alert(res.message);
                    queryNotice(1, ITEMS_PER_PAGE);
                    $('#delModal').modal('hide');
                }else{
                    alert(res.message);
                }
            },error : function(request) {
                alert("读取失败");
            }
        });
    }


    function handlePageChange(e) {
        // e.preventDefault();
        query(e.target.dataset.page ,ITEMS_PER_PAGE);
    }

    function fenYe(page, pageSize, totalItmes) {
        var pageSize = pageSize;
        var pageNav = "<nav> <ul class='pagination navbar-right'>";
        var count = Math.ceil(totalItmes / pageSize);
        for (var i = 1; i <= count; i++) {
            pageNav += "<li><a href='javascript:' id='ye" + i + "' data-page='" + i + "'>" + i + "</a></li>";
        }
        pageNav += "</ul></nav>";
        $("#fenYe").html(pageNav);
        $(".pagination").click(handlePageChange);
    }

    //回显编辑框
    function showChangeDiv(e) {
        var nid = e.target.dataset.nid;
        $.ajax({
            url: "/gongGao/gongGaoByNid.do",
            type : "POST",
            data : {
                nid : nid
            },
            dataType : "json",
            success : function(res) {
                $("#getBt").val(htmlDecodeByRegExp(res.BT));
                $("#getNr").val(htmlDecodeByRegExp(res.NR));
                $('#myModal').modal();
            },error : function(request) {
                alert("读取失败");
            }
        });
    }


    /*1.用正则表达式实现html转码*/
    function htmlEncodeByRegExp (str){
        var s = "";
        if(str.length == 0) return "";
        s = str.replace(/&/g,"&amp;");
        s = s.replace(/</g,"&lt;");
        s = s.replace(/>/g,"&gt;");
        s = s.replace(/ /g,"&nbsp;");
        s = s.replace(/\'/g,"&#39;");
        s = s.replace(/\"/g,"&quot;");
        return s;
    }
    /*2.用正则表达式实现html解码*/
    function htmlDecodeByRegExp (str){
        var s = "";
        if(str.length == 0) return "";
        s = str.replace(/&amp;/g,"&");
        s = s.replace(/&lt;/g,"<");
        s = s.replace(/&gt;/g,">");
        s = s.replace(/&nbsp;/g," ");
        s = s.replace(/&#39;/g,"\'");
        s = s.replace(/&quot;/g,"\"");
        return s;
    }

})(jQuery);
