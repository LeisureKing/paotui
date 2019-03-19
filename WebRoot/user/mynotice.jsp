<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="cn.dowalker.bean.User" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>校园跑腿</title>
    <meta name="description" content="校园跑腿"/>
    <meta name="keywords" content="校园跑腿"/>
    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/amazeui.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/amazeui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/application.js"></script>

</head>
<%
  		User user=(User)session.getAttribute("user");
  		if(user==null){
  			request.getRequestDispatcher("/toMemberLogin.html").forward(request, response);
		}
%>
<body>
</style>
<header data-am-widget="header" class="am-header am-header-default header">
    <div class="am-header-left am-header-nav">
        <a href="javascript:history.go(-1)" class="">
            <i class="am-header-icon am-icon-angle-left"></i>
        </a>
    </div>
    <h1 class="am-header-title"><a href="#title-link" class="" style="color: #333;">我的通知发布</a></h1>
    <div class="am-header-right am-header-nav">
        <a href="${pageContext.request.contextPath}/user/addnotice.html" class="blue" style="color: #79bbff">添加</a>
    </div>
</header>
<ul data-am-widget="gallery" style="margin-top: 2px"
    class="am-gallery am-avg-sm-2 am-avg-md-3 am-avg-lg-4 am-gallery-default product">
    
    <c:forEach items="${notices}" var="notice">
	    <li>
	        <a href="${pageContext.request.contextPath}/NoticeServlet?method=noticeDetail&id=${notice.id}" class="">
	            <h4 style="float: left;margin-right: 10px">最新发布</h4><span class="gray" style="font-size: 12px">${notice.time }</span>
	            <h5 class="gray">${fn:substring(notice.description,0,25)}</h5>
	            <img class="am-gallery-item">
	            <img src="${notice.image }"/>
	        </a>
	    </li>
	</c:forEach>
  
</ul>
</body>
</html>