<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="cn.dowalker.bean.User" %>
<!DOCTYPE html>
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
  		User user = (User)session.getAttribute("user");
  		if (user == null) {
  			request.getRequestDispatcher("/toMemberLogin.html").forward(request, response);
		}
%>
<body>
<style type="text/css">
@media only screen and (min-width: 1025px) {
    .o-con-img{
   	    float: left;
	    padding-top: 2%;
	    padding-bottom: 2%;
	    width: 8.5%;
	    height: 100%;
	    overflow: hidden;
	    margin-bottom: 0.5rem;
    }
}
</style>
<header data-am-widget="header" class="am-header am-header-default header">
    <div class="am-header-left am-header-nav">
        <a href="javascript:history.go(-1)" class="">
            <i class="am-header-icon am-icon-angle-left"></i>
        </a>
    </div>
    <h1 class="am-header-title">返回<a href="#title-link" class="" style="color: #333;">我的抢单</a></h1>
    <div class="am-header-right am-header-nav">
        <a href="#right-link" class=""> </a>
    </div>
</header>

<ul class="order-style">
    <li class="current"><a href="">全部</a></li>
</ul>
<c:forEach items="${orderItems}" var="orderItem">
	<div class="c-comment">
	    <span class="c-comment-num">订单编号：${fn:substring(orderItem.order.id, 0, 5)}</span>
	    <span class="c-comment-suc">
		    <c:if test="${orderItem.order.state == 0}">
		   		待抢单
		   	</c:if>
		   	<c:if test="${orderItem.order.state == 1}">
		   		进行中
		   	</c:if>
		   	<c:if test="${orderItem.order.state == 2}">
		   		已完成
		   	</c:if>
	    </span>
	</div>
	<div class="c-comment-list" style="border: 0;">
	    <a class="o-con" href="${pageContext.request.contextPath}/OrderServlet?method=findOrder&id=${orderItem.order.id}">
	        <div class="o-con-img"><img src="images/boy.png"></div>
	        <div class="o-con-txt">
	            <p>${orderItem.order.title}</p>
	            <p style="color: gray;margin-top: 2px;font-size: 12px">${orderItem.order.time}</p>
	            <span style="color: gray;margin-top: 2px;font-size: 12px">来自【河南许昌学院】</span>
	            <p class="price" style="font-size: 14px"> ${orderItem.order.content}</p>
	        </div>
	        <div class="o-con-much"><h4></h4></div>
	
	    </a>
	    <div class="c-com-money">
	        <span class="fr"><i>赚</i><i class="price">${orderItem.order.price}</i><i>元</i></span>
	    </div>
	
	</div>
	<div class="c-com-btn">
		<c:if test="${orderItem.order.state == 1}">
	   		<a href="${pageContext.request.contextPath}/OrderServlet?method=finishOrder&id=${order.id}">收款</a>
	   	</c:if>    
	    <a href="tel:${orderItem.phone }">联系客户</a>
	    <c:if test="${orderItem.order.state == 1}">
	   		<a href="${pageContext.request.contextPath}/OrderServlet?method=transferOrder&id=${orderItem.order.id}">转让订单</a>
	   	</c:if>
	</div>
	<div class="clear"></div>
</c:forEach>
<div class="clear"></div>
</body>
</html>
