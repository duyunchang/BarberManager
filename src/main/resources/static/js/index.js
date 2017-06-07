(function ($) {
    "use strict";

    $(function (){
        loadBrand();
        showName();
        getTime();
        showBir();
    });

    //注销
    $("#logout").click(function () {
        logout();
    });

    /**
     * 获取服务器时间
     */
    function getTime(){
        $.ajax({
            type:"POST",
            url:"/user/serviceTime.do",
            success : function(time){
                timer(updateTime, +time);
            }
        });
    }
    /**
     * 客户端控制时间增加
     * @param updateTime   控制时间格式及输出的函数
     * @param startTime	   起始描述
     * @author hui.zhao
     */
    function timer(updateTime, startTime) {
        updateTime(new Date(startTime));
        setInterval(function() {
            var now = new Date(startTime+=1000);
            updateTime(now);
        },1000);
    }

//对获得的时间格式进行调整
    function  updateTime(now){
        var week = "日一二三四五六";
        var y = now.getFullYear();
        var m = now.getMonth() + 1;
        var d = now.getDate();
        var w = now.getDay();
        var hh = now.getHours();
        var mm = now.getMinutes();
        var ss = now.getSeconds();
        if (ss < 10)
            ss = "0" + ss;
        if (mm < 10)
            mm = "0" + mm;
        var str = y + "年" + m + "月" + d + "日 <font style='font-size:14px;'>" + hh + ":" + mm + ":" + ss + "</font>";

        $("#currentTime").html(str);
    }

    function loadBrand() {
        $.ajax({
            url : "/user/queryPop.do",
            type : "POST",
            dataType :"json" ,
            success : function(res) {
                var brand = "<ul class='nav navbar-nav'>";
                var data = res.data;
                for(var i = 0; i < data.length; i++){
                    if(data[i].LINK != null){
                        brand += "<li><a href='#'  onclick='changeLoad(\""+data[i].LINK+"\"); '>"+ data[i].PNAME +"</a></li>";
                    }else{
                        if(data[i].PNAME == "生日提醒"){
                            brand += " <li><a href='#' id='birTip' data-placement='bottom' role='button' data-toggle='popover' data-trigger='focus' >生日提醒 <span class='badge' id='getBir'></span></a></li>";
                        }
                    }
                }
                brand += "</ul>" ;
                $("#brand").html(brand);
            }
        });
    }


    function showName() {
        $.ajax({
            url : "/user/queryName.do",
            type : "POST",
            dataType :"json" ,
            success : function(res) {
                $("#userNm").html(res.name);
            }
        });
    }

    function showBir() {
        $.ajax({
            url : "/user/queryBir.do",
            type : "POST",
            dataType :"json" ,
            success : function(res) {
                if (res.result) {
                    var birList = "";
                    var birList = "<table class='table table-hover  '>"
                        + "<thead><tr>"
                        + "<td width='10%'>姓名</td>"
                        + "<td width='10%'>剩余天数</td>"
                        + "</tr></thead>"
                        + "<tbody>";
                    for (var i = 0; i < res.data.length; i++) {
                        var j = i + 1;
                        var data = res.data[i];
                        birList += "<tr>"
                            + "<td title='" + data.NM + "'>" + data.NM + "</td>"
                            + "<td title='" + data.DAYS + "'>" + data.DAYS + "</td>"
                            + "</tr>";
                    }
                    birList += "</tbody></table>";


                    $("#getBir").html(res.count);
                    $("#birTip").popover({
                        title :"生日提醒",
                        html: true,
                        content: "<div style='width: 200px' id='content'>"+birList +"</div>"
                    });
                }
            }
        });
    }

    function logout(){
        $.ajax({
            url : "/login/logout.index",
            type : "POST",
            dataType :"json" ,
            success : function(res) {
                if(res){
                    window.location.href="../login.html";
                }
            }
        });
    }

})(jQuery);
