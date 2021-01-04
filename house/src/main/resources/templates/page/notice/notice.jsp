<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/28
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>会议室公约</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="layui/css/layui.css" media="all" />
    <link rel="stylesheet" href="css/public.css" media="all" />
    <style>
        .test{ position:fixed; bottom:0; left:0;width:100%;height:30px;background-color:red;}
    </style>
    <script type="text/javascript" src="layui/layui.js"></script>

</head>
<body>
<div class="layui-collapse" lay-accordion>
<%--    <div class="layui-colla-item">--%>
<%--        <h2 class="layui-colla-title">会议室公约</h2>--%>
<%--    </div>--%>
    <% int i = 0;
        String[] num = {"一", "二", "三", "四", "五", "六", "七", "八", "九", "十"};
    %>

    <c:forEach items="${notice}" var="n">
        <div class="layui-colla-item">
            <h2 class="layui-colla-title">第<%=num[i] %>条<%i++; %></h2>
            <div class="layui-colla-content layui-show">${n.other}</div>
        </div>
    </c:forEach>

</div>
<script>
    layui.use(['element', 'layer'], function(){
        var element = layui.element;
        var layer = layui.layer;
        //监听折叠
        element.on('collapse(test)', function(data){
            layer.msg('展开状态：'+ data.show);
        });
    });
</script>

</body>
</html>
