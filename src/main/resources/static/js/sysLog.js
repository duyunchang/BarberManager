(function ($) {
    "use strict";
    var ITEMS_PER_PAGE = 10;
    $(function () {
        $('#queryDt').datetimepicker({
            format: 'yyyy-mm-dd',//日期的格式
            startDate:'1900-01-01',//选择器的开始日期
            autoclose:true,//日期选择完成后是否关闭选择框
            bootcssVer:3,//显示向左向右的箭头
            language:'zh-CN',//语言
            minView: "month"//表示日期选择的最小范围，默认是hour
        });
        setSelect();
        querySysLog(1, ITEMS_PER_PAGE);
    });

    //分页查询
    $("#query").click(function () {
        querySysLog(1, ITEMS_PER_PAGE);
    });

    function querySysLog(_page, _pageSize) {

        var nm = $("#queryNm").val();
        var dt = $("#queryDt").val();
        var type = $("#queryType").val();
        $.ajax({
            url: "/log/queryLogPage.do",
            type: "POST",
            data: {
                nm: nm,
                dt: dt,
                type: type,
                _page: _page,
                _pageSize: _pageSize
            },
            dataType: "json",
            success: function (res) {
                var medTable = "<table class='table table-hover table-striped '>"
                    + "<thead><tr>"
                    + "<td >序号</td>"
                    + "<td >姓名</td>"
                    + "<td >类型</td>"
                    + "<td >时间</td>"
                    + "<td >IP</td>"
                    + "<td >操作</td>"
                    + "</tr></thead>"
                    + "<tbody>";
                if (res.data.length > 0) {
                    for (var i = 0; i < res.data.length; i++) {
                        var j = i+1;
                        var data = res.data[i];
                        medTable += "<tr id='tr" + data.ID + "'>"
                            + "<td title='" + ((i+1)+(_page-1)*(_pageSize)) + "'>" + ((i+1)+(_page-1)*(_pageSize)) + "</td>"
                            + "<td title='" + data.NM + "'>" + data.NM + "</td>"
                            + "<td title='" + data.TYPE + "'>" + data.TYPE + "</td>"
                            + "<td title='" + data.DT + "'>" + data.DT + "</td>"
                            + "<td title='" + data.IP + "'>" + data.IP + "</td>"
                            + "<td><a  class='chaKanLog' data-id='"+data.ID+"'>查看</a></td>"
                            + "</tr>";
                    }
                }else{
                    medTable += "<tr><td colspan='15' align='center' style='height:40px; font-weight: 700;'>暂无数据!</td></tr>";
                }
                medTable += "</tbody></table>";
                $("#medTable").html(medTable);// 显示表格
                $(".chaKanLog").click(showChangeDiv);
                fenYe(_page, _pageSize, res.count);
            }
        });
    }

    //回显编辑框
    function showChangeDiv(e) {
        var id = e.target.dataset.id;
        $.ajax({
            url: "/log/queryLogById.do",
            type : "POST",
            data : {
                id : id
            },
            dataType : "json",
            success : function(res) {
                $("#getNm").val(res[0].NM);
                $("#getNr").val(res[0].NR);
                $('#myModal').modal();
            },error : function(request) {
                alert("读取失败");
            }
        });
    }




    function handlePageChange(e) {
        // e.preventDefault();
        querySysLog(e.target.dataset.page ,ITEMS_PER_PAGE);
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


    function setSelect() {
        $.ajax({
            url:"/log/getLx.do",
            type:"post",
            dataType:"json",
            success:function(res){
                for(var i=0;i<res.length;i++){
                    document.getElementById("queryType").options.add(new Option(res[i].TYPE,res[i].TYPE));
                }
            }
        });
    }

})(jQuery);
