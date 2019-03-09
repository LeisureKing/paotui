<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
  		User user=(User)session.getAttribute("user");
  		if(user==null){
  			request.getRequestDispatcher("/toMemberLogin.html").forward(request, response);
		}
%>
<body>
<header data-am-widget="header" class="am-header am-header-default header">
    <div class="am-header-left am-header-nav">
        <a href="javascript:history.go(-1)" class="">
            <i class="am-header-icon am-icon-angle-left"></i>
        </a>
    </div>
    <h1 class="am-header-title"><a href="#title-link" class="" style="color: #333;">账户管理</a></h1>
    <div class="am-header-right am-header-nav">
        <a href="javascript:history.go(-1) " >注销</a>
    </div>
</header>
<ul class="member-nav" style="margin-top: 2px">
    <a href="add_card.html"><li><i class="am-icon-credit-card"></i><span>实名认证</span></li></a>
    <a href="../toBackPassword.html"><li><i class="am-icon-cart-arrow-down"></i><span>找回密码</span></li></a>

</ul>


</body>
</html>
