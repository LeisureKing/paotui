<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <li><img src="images/banner4.jpg"></li>
        <li><img src="images/banner2.jpg"></li>
        <li><img src="images/banner1.jpg"></li>


    </ul>
</div>
<div class="am-tabs qiehuan" data-am-tabs >
    <ul class="am-tabs-nav am-nav am-nav-tabs">
    </ul>
</div>



<div data-am-widget="intro" class="am-intro am-cf am-intro-default" id="normal">
	<c:if test="${empty orders}">
		<c:redirect url="/OrderServlet?method=findOrders"/>
	</c:if>
	<c:forEach items="${orders}" var="order">
	    <div class="am-g am-intro-bd">
	        <a href="content.html">
	            <div class="am-intro-left am-u-sm-3"><img src="images/boy.png"/></div>
	            <div class="am-intro-right am-u-sm-9">
	                <div class="text">
	                    <span style="float: left;color: black;font-size: 16px"><i>${order.id}</i></span>
	                    <span class="fr black" style="margin-right: 2%"><i>
	                    	<c:if test="${order.state == 0}">
	                    		待抢单
	                    	</c:if>
	                    	<c:if test="${order.state == 1}">
	                    		进行中
	                    	</c:if>
	                    	<c:if test="${order.state == 2}">
	                    		已完成
	                    	</c:if>
	                    </i></span>
	                    <span class="fr green" style="margin-right: 5%">${order.title}</span>
	                </div>
	                <p>${order.content}</p>
	                <div class="text">
	                    <span class="fl">${order.time}</span>
	                    <span class="fr"><i>赚</i><i class="price">${order.price}</i><i>元</i></span>
	                </div>
	            </div>
	        </a>
	    </div>
	</c:forEach>
</div>

<div class="communityPage-publish-btn cmn-theme-bgcolor" id="communityPage-publish-btn"><a id="down_order"
                                                                                           href="add_order.html"
                                                                                           style="color: white">下单</a>
</div>

<div class="h50"></div>
<div data-am-widget="navbar" class="am-navbar am-cf am-navbar-default footer " id="tab1">

</div>


</body>
</html>
