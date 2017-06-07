(function ($) {
    "use strict";
    $(function () {
        queryBir();
        querySex();
    });
    var birthday = echarts.init(document.getElementById('birthday'));
    var sex = echarts.init(document.getElementById('sex'));

    //生日表格回显
    function queryBir() {
        $.ajax({
            url: "/tongJi/queryBir.do",
            type : "POST",
            dataType : "json",
            success : function(res) {
                birthday.setOption({
                    title: {
                        text: '生日统计表'
                    },
                    tooltip: {},
                    legend: {
                        data:['人数']
                    },
                    xAxis: {
                        data:res.months
                    },
                    yAxis: {},
                    series: [
                        {
                            name: '人数',
                            type: 'bar',
                            data: res.sum
                        }
                        ]
                });
            },error : function(request) {
                alert("读取失败");
            }
        });
    }


    function querySex() {
        $.ajax({
            url: "/tongJi/querySex.do",
            type: "POST",
            dataType: "json",
            success: function (res) {

                // 显示标题，图例和空的坐标轴
                sex.setOption({
                    title : {
                        text: '性别统计',
                        x:'center'
                    },
                    tooltip : {
                        trigger: 'item',
                        formatter: "{a} <br/>{b} : {c} ({d}%)"
                    },
                    legend: {
                        orient: 'vertical',
                        left: 'left',
                        data:
                        res.sex
                    },
                    series : [
                        {
                            name: '访问来源',
                            type: 'pie',
                            radius : '55%',
                            center: ['50%', '60%'],
                            data: res.count,
                            itemStyle: {
                                emphasis: {
                                    shadowBlur: 10,
                                    shadowOffsetX: 0,
                                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                                }
                            }
                        }
                    ]
                });
            }, error: function (request) {
                alert("读取失败");
            }
        });
    }

})(jQuery);
