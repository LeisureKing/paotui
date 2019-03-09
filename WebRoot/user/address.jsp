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
    <h1 class="am-header-title"><a href="#title-link" class="" style="color: #333;">收货地址</a></h1>
    <div class="am-header-right am-header-nav">
        <a href="${pageContext.request.contextPath}/user/add_address.html" class="blue" style="color: #79bbff">添加</a>
    </div>
</header>
<a href="javascript:history.go(-1)">

    <ul class="address-list">
	<c:forEach items="${addresses}" var="address">
        <li class="curr">
        	<a href="javascript:history.go(-1)" onclick="address_click()">
        	<input type="hidden" id="addressid" value="${address.id}">
        	<input type="hidden" id="address" value="${address.address}">
            <p>收货人：${address.username }&nbsp;&nbsp;${address.phone }</p>
            <p class="order-add1">收货地址：${address.address }</p>
            <hr>
            </a>
            <div class="address-cz">
                <label class="am-radio am-warning">
                    <input type="radio" name="radio3" value="" data-am-ucheck="" checked=""
                           class="am-ucheck-radio"><span class="am-ucheck-icons"><i class="am-icon-unchecked"></i><i
                        class="am-icon-checked"></i></span> 设为默认
                </label>
                <a href="add_address.html"><img src="images/bj.png" style="width: 18px;">&nbsp;编辑</a>
                <a href="">删除</a>
            </div>
        </li>
	</c:forEach>
    </ul>
</a>
</body>
<script type="text/javascript">
    function address_click(){
            var address = $('#address').val();
            var addressid = $('#addressid').val();
            localStorage.setItem('address',address);
            localStorage.setItem('addressid',addressid);
        }
</script>
</html>
