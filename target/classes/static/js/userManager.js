(function ($) {
    "use strict";
    var ITEMS_PER_PAGE = 10;
    $(function () {
        $('#addBir').datetimepicker({
            format: 'yyyy-mm-dd',//日期的格式
            startDate: '1900-01-01',//选择器的开始日期
            autoclose: true,//日期选择完成后是否关闭选择框
            bootcssVer: 3,//显示向左向右的箭头
            language: 'zh-CN',//语言
            minView: "month"//表示日期选择的最小范围，默认是hour
        });
        query(1, ITEMS_PER_PAGE);
    });

    //分页查询
    $("#sub").click(function () {
        query(1, ITEMS_PER_PAGE);
    });

    //弹出添加框
    $("#tianjiaButton").click(function () {
        $('#addUserModal').modal();
    });

    //重置密码
    $("#rePas").click(function () {
        rePas();
    });

    //添加用户
    $("#addUser").click(function () {
        addUser();
    });

    function query(_page, _pageSize) {
        var query = {
            sex: $("#querySex").val(),
            nm: $("#queryNm").val(),
            type: $("#queryType").val(),
            del: $("#queryDel").val(),
            _page: _page,
            _pageSize: _pageSize
        };
        $.ajax({
            url: "/user/queryPage.do",
            type: "POST",
            data: query,
            dataType: "json",
            success: function (res) {
                var medTable = "<table class='table table-hover table-striped '>"
                    + "<thead><tr>"
                    + "<td width='5%'>序号</td>"
                    + "<td width='15%'>登录名</td>"
                    + "<td width='10%'>姓名</td>"
                    + "<td width='10%'>性别</td>"
                    + "<td width='10%'>类型</td>"
                    + "<td width='10%'>是否有效</td>"
                    + "<td width='10%'>生日</td>"
                    + "<td width='15%'>修改时间</td>"
                    + "<td width='20%'>操作</td>"
                    + "</tr></thead>"
                    + "<tbody>";
                for (var i = 0; i < res.data.length; i++) {
                    var j = i + 1;
                    var data = res.data[i];
                    medTable += "<tr id='tr" + data.UID + "'>"
                        + "<td title='" + ((i + 1) + (query._page - 1) * (query._pageSize)) + "'>" + ((i + 1) + (query._page - 1) * (query._pageSize)) + "</td>"
                        + "<td title='" + data.USER + "'>" + data.USER + "</td>"
                        + "<td title='" + data.NM + "'>" + data.NM + "</td>"
                        + "<td title='" + getSex(data.SEX) + "'>" + getSex(data.SEX) + "</td>"
                        + "<td title='" + getType(data.TYPE) + "'>" + getType(data.TYPE) + "</td>"
                        + "<td title='" + getDel(data.DEL) + "'>" + getDel(data.DEL) + "</td>"
                        + "<td title='" + data.BIRTHDAY + "'>" + data.BIRTHDAY + "</td>"
                        + "<td title='" + data.UPDT + "'>" + data.UPDT + "</td>"
                        + "<td><a  class='editUser' data-uid='" + data.UID + "'>管理</a>&nbsp;<a  class='editPop' data-name='" + data.NM + "' data-uid='" + data.UID + "'>权限</a>&nbsp;<a  class='rePas' data-uid='"+data.UID+"'>重置密码</a></td>"
                        + "</tr>";
                }
                medTable += "</tbody></table>";
                $("#medTable").html(medTable);// 显示表格
                $(".editUser").click(showChangeDiv);
                $(".rePas").click(showrePasDiv);
                $(".editPop").click(showrePopDiv);
                fenYe(_page, _pageSize, res.count);
            }
        });
    }


    function addUser() {
        var addUser = {
            user: $("#addLnm").val(),
            pas: $("#addPas").val(),
            sex: $("#addSex").val(),
            nm: $("#addNm").val(),
            birthday: $("#addBir").val(),
            type: $("#addType").val(),
            del: $("#addDel").val()
        };
        $.ajax({
            url: "/user/addUser.do",
            type: "POST",
            data: addUser,
            dataType: "json",
            success: function (res) {
                if (res.result) {
                    alert(res.message);
                    $('#addUserModal').modal('hide');
                    cleanUserModal();
                    query(1, ITEMS_PER_PAGE);
                } else {
                    alert(res.message);
                }
            }, error: function (xhr) {
                var res = xhr.responseJSON;
                alert(res.message);
            }
        });
    }

    function cleanUserModal() {
        $("#addLnm").val("");
        $("#addPas").val("");
        $("#addSex").val("");
        $("#addNm").val("");
        $("#addBir").val("");
        $("#addType").val("");
        $("#addDel").val("");
    }


    function getSex(sex) {
        if (sex == '1') {
            return '男'
        } else {
            return '女'
        }
    }

    function getType(type) {
        if (type == '1') {
            return '管理员'
        } else {
            return '普通用户'
        }
    }

    function getDel(del) {
        if (del == '1') {
            return '有效'
        } else {
            return '无效'
        }
    }

    function handlePageChange(e) {
        // e.preventDefault();
        query(e.target.dataset.page, ITEMS_PER_PAGE);
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
        var uid = e.target.dataset.uid;
        $.ajax({
            url: "/user/queryUserByUid.do",
            type: "POST",
            data: {
                uid: uid
            },
            dataType: "json",
            success: function (res) {
                $("#getUid").val(res.UID);
                $("#getLnm").html(res.USER);
                $("#getType").val(res.TYPE);
                $("#getDel").val(res.DEL);
                $('#myModal').modal();
            }, error: function (request) {
                alert("读取失败");
            }
        });
    }



    //弹出重置密码提醒
    function showrePasDiv(e) {
        $('#rePasUid').val(e.target.dataset.uid);
        $('#rePasModal').modal();
    }


    //清空权限回显
    function cleanPopModal() {
        $("#gl").prop("checked", false);
        $("#tj").prop("checked", false);
        $("#sysrz").prop("checked", false);
        $("#tx").prop("checked", false);
        $("#gg").prop("checked", false);
        $("#mysys").prop("checked", false);

    }

    //回显权限
    function showrePopDiv(e) {
        cleanPopModal();
        var uid = e.target.dataset.uid;
        $('#popUid').val(uid);
        $('#showpopUserNm').html(e.target.dataset.name);
        $.ajax({
            url: "/user/queryPopByUid.do",
            type: "POST",
            data: {
                uid: uid
            },
            dataType: "json",
            success: function (res) {
                var data = res.data;
                for(var i = 0; i<data.length; i++){
                    $(":checkbox[value='"+data[i].PID+"']").prop("checked", true);
                }
                $('#popModal').modal();
            }, error: function (request) {
                alert("读取失败");
            }
        });
    }


    //修改用户权限
    $("#popChange").click(function () {

        var pops = [];
        $("[name='chkId']:checked").each(function(index, element) {
            if('undefined' != typeof $(this).val()){
                pops.push( $(this).val());
            }
        });
        var popChange = {
            uid: $('#popUid').val(),
            pops : pops.toString()
        };
        $.ajax({
            url: "/user/editPopByUid.do",
            type: "POST",
            data: popChange,
            dataType: "json",
            success: function (res) {
                if (res.result) {
                    alert(res.message);
                    // query(1, ITEMS_PER_PAGE);
                    $('#popModal').modal('hide');
                    cleanPopModal();
                } else {
                    alert(res.message);
                    cleanPopModal();
                }
            }
        });

    });



    //重置密码
    function rePas() {
        var uid = $('#rePasUid').val();
        $.ajax({
            url: "/user/doRePas.do",
            type : "POST",
            data : {
                uid : uid
            },
            dataType : "json",
            success : function(res) {
                if(res.result){
                    alert(res.message);
                    $('#rePasModal').modal('hide');
                }else{
                    alert(res.message);
                }
            },error : function(request) {
                alert("读取失败");
            }
        });
    }

    //修改用户信息
    $("#subChange").click(function () {
        var subChange = {
            uid: $("#getUid").val(),
            type: $("#getType").val(),
            del: $("#getDel").val()
        };
        $.ajax({
            url: "/user/editUserByUid.do",
            type: "POST",
            data: subChange,
            dataType: "json",
            success: function (res) {
                if (res.result) {
                    alert(res.message);
                    query(1, ITEMS_PER_PAGE);
                    $('#myModal').modal('hide');
                } else {
                    alert(res.message);
                }
            }
        });

    });
})(jQuery);
