<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>校园跑腿</title>
    <meta name="description" content="校园跑腿"/>
    <meta name="keywords" content="校园跑腿"/>
    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <link rel="stylesheet" href="css/amazeui.min.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/amazeui.min.js"></script>
    <script type="text/javascript" src="js/application.js"></script>

</head>
<body>
<div data-am-widget="slider" class="am-slider am-slider-default" data-am-slider='{}'>
    <ul class="am-slides">
        <li><img src="images/banner1.jpg"></li>
        <li><img src="images/banner4.jpg"></li>
        <li><img src="images/banner2.jpg"></li>

    </ul>
</div>
<!--	<a href="add_order.html" class="search">
        开启你的美食之旅...
    </a>-->
<ul class="nav">
    <li>
        <a href="/paotui/user/add_order.jsp">
            <img src="images/icon.jpg"/>
            <p>取快递</p>
        </a>
    </li>
    <li>
        <a href="/paotui/user/add_order.jsp">
            <img src="images/icon1.jpg"/>
            <p>求带饭</p>
        </a>
    </li>
    <li>
        <a href="/paotui/user/add_order.jsp">
            <img src="images/icon2.jpg"/>
            <p>求帮忙</p>
        </a>
    </li>
    <li>
        <a href="/paotui/user/add_order.jsp">
            <img src="images/icon3.jpg"/>
            <p>求陪跑</p>
        </a>
    </li>
</ul>

<div data-am-widget="titlebar" class="am-titlebar am-titlebar-default title">
    <h2 class="am-titlebar-title "> 最新通知 </h2>
    <nav class="am-titlebar-nav">
        <a href="${pageContext.request.contextPath}/NoticeServlet?method=allNotices" class="">more &raquo;</a>
    </nav>
</div>
<c:if test="${empty showNotices}">
		<c:redirect url="/NoticeServlet?method=showNoticesInIndex"/>
</c:if>
<ul data-am-widget="gallery" class="am-gallery am-avg-sm-2 am-avg-md-3 am-avg-lg-4 am-gallery-default product">
	<c:forEach items="${showNotices}" var="notice">
	    <li>
	        <a href="${pageContext.request.contextPath}/NoticeServlet?method=noticeDetail&id=${notice.id}" class="">
	            <h4 style="float: left;margin-right: 10px">发布最新</h4><span class="gray" style="font-size: 12px">${notice.time }</span>
	            <h5 class="gray">${fn:substring(notice.description,0,8)}</h5>
	            <img class="am-gallery-item">
	            <img src="${notice.image }"/>
	        </a>
	    </li>
	</c:forEach>
</ul>
<div class="h50"></div>
<div data-am-widget="navbar" class="am-navbar am-cf am-navbar-default footer " id="tab">

</div>

</body>
</html>
