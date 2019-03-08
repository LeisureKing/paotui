<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
	
    <meta charset="utf-8" />
	<meta name="author" content="m.ehaier.com">
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" name="viewport"  />
	<meta name="format-detection" content="telephone=no" />
	<meta content="yes" name="apple-mobile-web-app-capable" />
	<meta content="black" name="apple-mobile-web-app-status-bar-style" />
	<meta content="telephone=no" name="format-detection" />
	<meta content="false" id="twcClient" name="twcClient" />
	<link type="text/css" rel="stylesheet" href="css/v2/style.css">
	<link rel="apple-touch-icon-precomposed" href="../../images/ehaier-icon.png"/>	
	<link rel="shortcut icon" type="image/x-icon" href="../../images/ehaier-icon.png"/>  
	<title>校园跑腿</title>
<link type="text/css" rel="stylesheet" href="css/v2/member.css">
</head>
<body id="page">
<header class="header"> 
	<span class="fh left"><a href="javascript:history.back(1)">&nbsp;</a></span>  	注册
  	<span class="hd_right right">
<!--	<a class="gwc" href="../cart/myCart.html"><span id="count">0 </span>&nbsp;</a>
	<a class="right_but" href="../common/navigate.html">&nbsp;</a>-->
</span>
</header>
<span id="login_errorMsg" style="padding:10px;"></span>
<div class="Login">
  <div class="Login_top">
    <ul>
      <li><A href="toMemberLogin.html">登录</A></li>
      <li class="cur"><A href="toMemberRegist.jsp">注册</A></li>
    </ul>
  </div>
  <div> 
    <div class="Login_bottom" >
      <form id="registForm" action="/paotui/UserServlet?method=regist" onSubmit="return checkRegForm()" method="post">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="60" align="left" valign="middle"><input type="text" value="" id="mobileRegNum" name="username" placeholder="用户名" class="login_wbk">
              <span id="mobileNumMsg"></span></td>
          </tr>
			
          <tr>
            <td height="60" align="left" valign="middle"><input type="text" value="" id="mobileRegNum" name="phone" placeholder="手机号" class="login_wbk">
              <span id="mobileNumMsg"></span></td>
          </tr>
          <tr>
            <td height="60" align="left" valign="middle"><input type="password" id="password" name="password" placeholder="设置密码"  class="login_wbk"></td>
          </tr>
          <tr>
            <td height="60" align="left" valign="middle"><input type="password" id="repassword" name="repassword" placeholder="确认密码"  class="login_wbk"></td>
          </tr>
          <tr>
            <td height="60" align="left" valign="middle"><input type="text" id="captcha" name="verifyCode" placeholder="短信验证码"  class="login_wbk inputcheckbox" style=" width:49%;margin:0;">
           
          	<input type="button" id="btn" value="免费获取验证码" onclick="settime(this)" class="sendVerifyCode"/> 
          </tr>
      <!--    <tr>
            <td height="60" align="center" valign="middle"><Span>注册即同意<a href="agreement.html"><span style=" font-size:14px; text-decoration:underline;">海尔商城用户服务协议</span></a></Span></td>
          </tr>-->
          <tr>
            <td height="60" align="center" valign="middle">
			<input type="submit" onclick="check()" id="memberRegist" class="dl_login"></input>
			</td>
          </tr>
          <tr>
            <td height="30" >&nbsp;</td>
          </tr>
        </table>
      </form>
    </div>
   </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.3.1.js"></script>
<script type="text/javascript">
function check() {
        var pass1 = document.getElementById("password");
        var pass2 = document.getElementById("repassword");
 
        if (pass1.value != pass2.value)
            pass2.setCustomValidity("两次输入的密码不匹配");
        else
            pass2.setCustomValidity("");
    }


</script>

<script type="text/javascript"> 
var countdown=60; 
function settime(obj) { 
    if (countdown == 0) { 
        obj.removeAttribute("disabled");    
        obj.value="免费获取验证码"; 
        countdown = 60;
        $.ajax({
            type: "get", //用GET方式传输
            dataType: "json", //数据格式:JSON
            url: "${pageContext.request.contextPath}/UserServlet?method=getCode&phone=" + $('#mobileRegNum').val(), //目标地址
            success: function (data) {
                if(data.code=='fail'){
                    alert("发送验证码失败");
                }
            }
        });
        return;
    } else { 
        obj.setAttribute("disabled", true); 
        obj.value="重新发送(" + countdown + ")"; 
        countdown--; 
    } 
	setTimeout(function() { settime(obj) },1000) 
}


  
</script>

<!--<footer class="footer">
	&lt;!&ndash;<div id="footer" class="ft_top">
				<a href="toMemberLogin.html">登录</a>|<a href="toMemberRegist.html">注册</a>
			</div>&ndash;&gt;
 &lt;!&ndash; 	<p><a href="javascript:scroll(0,0)">返回顶部</a>|<a href="../../default.htm">返回首页</a>|<a href="../common/suggestInfos.html">意见反馈</a> </p>
  	<p>Copyright©2016</p>&ndash;&gt;
</footer>-->

</body>
</html>