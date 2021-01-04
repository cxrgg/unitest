<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/30
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>签到日历</title>
    <meta charset='utf-8'/>
    <link href='../packages/core/main.css' rel='stylesheet'/>
    <link href='../packages/daygrid/main.css' rel='stylesheet'/>
    <link href='../packages/timegrid/main.css' rel='stylesheet'/>
    <link href='../packages/list/main.css' rel='stylesheet'/>
    <link rel="stylesheet" href="layui/css/layui.css"/>
    <link rel="stylesheet" href="css/public.css"/>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script src='../packages/core/main.js'></script>
    <script src='../packages/core/locales-all.js'></script>
    <script src='../packages/interaction/main.js'></script>
    <script src='../packages/moment/main.js'></script>
    <script src='../packages/daygrid/main.js'></script>
    <script src='../packages/timegrid/main.js'></script>
    <script src='../packages/list/main.js'></script>
<script type="text/javascript" src="layui/layui.js"></script>
<script type="text/javascript">


    // function initView() {
    //
    //     layui.use(['layer', 'table', 'form'], function () {
    //         table = layui.table;
    //         form = layui.form;
    //         var edit = JSON.parse($("#edit").val());
    //         console.log(edit);
    //         form.val("calendarForm", edit);
    //         $("[name='id']").val(edit.id);
    //         console.log("当前会议室id=" + edit.id);
    //         console.log("$(\"[name='id']\").val=" + $("[name='id']").val());

            // var initialLocaleCode = 'zh-cn';调整语言 默认语言


        // })
        document.addEventListener('DOMContentLoaded', function () {
            var localeSelectorEl = document.getElementById('locale-selector');
            var calendarEl = document.getElementById('calendar');
            // console.log("$(\"[name='nid']\").val=" + $("[name='id']").val());
            $.get("api/playCard?op=playCardCalender", function (d) {
                console.log("这是传过来的json" + JSON.stringify(d));

                var calendar = new FullCalendar.Calendar(calendarEl, {
                    plugins: ['interaction', 'dayGrid', 'timeGrid', 'list'],
                    header: {
                        left: 'prev,next today',
                        center: 'title',
                        right: 'dayGridMonth,timeGridWeek,timeGridDay,listMonth'
                    },
                    // defaultDate: '2019-08-12',//默认日期
                    // locale: initialLocaleCode,
                    locale: 'zh-cn',//默认文字
                    buttonIcons: false, // 显示prev/next文本上一月下一月
                    weekNumbers: true, //这一周是今年的第几周
                    navLinks: true, // can click day/week names to navigate views
                    // eventOverlap: false,//是否允许时间线重叠，流批
                    // eventConstraint:'businessHours',//只允许拖到上班时间内 朝九晚五
                    // businessHours: {
                    //     dow: [1, 2, 3, 4], // 周一 - 周四
                    //
                    //     start: '10:00', // 上午10点开始
                    //     end: '18:00', // 下午18点结束
                    // },
                    // editable: true, //可移动拖拉标记事件
                    // eventLimit: true, //可以点击日/周名称来浏览视图吗
                     events: d,
                    //  events: [{"groupId":1,"title":"签到","start":"2019-11-28 08:26:15"},{"groupId":1,"title":"签退","start":"2019-11-28 17:26:29"},{"groupId":2,"title":"签到","start":"2019-11-29 09:31:36"},{"groupId":2,"title":"签退","end":"2019-11-29 18:27:36"},{"groupId":9,"title":"签到","start":"2019-11-30 08:40:41"},{"groupId":9,"title":"早退","end":"2019-11-30 15:40:43"}],

                    // eventDragStart: function (obj) {
                    //     //当事件开始拖动时触发：obj.event代表当前对象所有的值
                    //     console.log("您正在修改日历");
                    // },

                    // eventDragStop: function (obj) {
                    //     //拖动事件结束触发，obj.event代表旧的对象所有的值
                    // },
                    // eventDrop: function (obj) {
                    //     //拖动事件结束触发，obj.event代表新移动到的但前对象所有的值
                    //     //是拖动而不是调整事件大小
                    //     console.log("event" + obj.event.title);
                    //     var postData = [];
                    //     postData.push(obj.event.groupId);
                    //     postData.push(obj.event.start.getTime());
                    //     postData.push(obj.event.end.getTime());
                    //     postData = postData.join(',');
                    //     $.get("api/calender?op=calender&index=" + postData, function (d) {
                    //         if (d.code==200){
                    //             layer.msg("修改成功");
                    //         }else{
                    //             layer.msg(d.msg,{icon:2});
                    //             obj.revert();
                    //         }
                    //     })
                    //
                    // },

                    // eventResize: function (obj) {
                    //     //调整事件大小，也可以拖动，但只在日，周图生效
                    //     console.log("event" + obj.event.title);
                    //     var postData = [];
                    //     postData.push(obj.event.groupId);
                    //     postData.push(obj.event.start.getTime());
                    //     postData.push(obj.event.end.getTime());
                    //     postData = postData.join(',');
                    //     $.get("api/calender?op=calender&index=" + postData, function (d) {
                    //         if (d.code==200){
                    //             layer.msg("修改成功");
                    //         }else{
                    //             layer.msg(d.msg,{icon:2});
                    //             obj.revert();
                    //         }
                    //     })
                    // },
                    // eventMouseover: function (event, jsEvent, view) {
                    //     //鼠标移入事件
                    //     $(this).css('border-color', 'red');
                    // },
                    // eventClick: function (obj) {
                    //     //点击触发事件
                    //     var postData = [];
                    //     postData.push(obj.event.groupId);
                    //     postData.push(obj.event.start.getTime());
                    //     postData.push(obj.event.end.getTime());
                    //     postData = postData.join(',');
                    //
                    //     layer.open({
                    //         type: 1 //此处以iframe举例
                    //         ,title:"会议名称"
                    //         ,area: ['300px', '200px']
                    //         ,shade: 0
                    //         ,maxmin: true
                    //         ,content: obj.event.title
                    //     });
                    //     $(this).css('border-color', 'red');
                    // }
                });
                calendar.render();
            })

        })




</script>
<!--    浮动层最下面   -->
<style>
    .test {
        position: fixed;
        bottom: 0;
        left: 0;
        width: 100%;
        height: 30px;
        background-color: red;
    }
</style>
</head>
<body>
            <div id='calendar'></div>
</body>
</html>
