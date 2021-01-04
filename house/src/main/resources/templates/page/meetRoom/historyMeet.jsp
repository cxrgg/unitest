<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>--%>
<%--<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>会议室</title>
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
<body class="childrenBody">

<ul class="layui-timeline">
<%--    <div class="test"></div>--%>

    <c:forEach items="${his}" var="h">
        <li class="layui-timeline-item">
            <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
            <div class="layui-timeline-content layui-text">
                <br>
                <h3 > <p>申请人：${h.employee.name}<p></h3>
                <br>
                 <p>会议名称：${h.other}<p>
                <br>
                <p class="layui-timeline-title">
                  会议开始时间：<fmt:formatDate value="${h.b_time}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
                </p>
                <p class="layui-timeline-title">
                  会议结束时间：<fmt:formatDate value="${h.e_time}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
                </p>
                <p>
                   <br>申请日期：<fmt:formatDate value="${ h.c_time}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
                </p>
            </div>
        </li>
    </c:forEach>
</ul>
</body>
</html>