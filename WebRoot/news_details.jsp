<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <script type="text/javascript" src="js/application.js" ></script>

</head>
<style type="text/css">
@media only screen and (min-width: 1025px) {
    .am-avg-lg-4 > li {
    	width: 100%;
	}
}
</style>
<body>
<header data-am-widget="header" class="am-header am-header-default header">
    <div class="am-header-left am-header-nav">
        <a href="javascript:history.go(-1)" class="">
            <i class="am-header-icon am-icon-angle-left"></i>
        </a>
    </div>
    <h1 class="am-header-title"><a href="#title-link" class="" style="color: #333;">详情</a></h1>
    <div class="am-header-right am-header-nav">
        <a href="#right-link" class=""> </a>
    </div>
</header>
<ul data-am-widget="gallery" style="margin-top: 2px"
    class="am-gallery am-avg-sm-2 am-avg-md-3 am-avg-lg-4 am-gallery-default product">  
	    <li>
	        <a href="${pageContext.request.contextPath}/NoticeServlet?method=noticeDetail&id=${notice.id}" class="">
	            <h4 style="float: left;margin-right: 10px">发布最新</h4><span class="gray" style="font-size: 12px">${notice.time }</span>
	            <h5 class="gray">${notice.description}</h5>
	            <img class="am-gallery-item">
	            <img src="${notice.image }"/>
	        </a>
	    </li>
</ul>


</body>
</html>
