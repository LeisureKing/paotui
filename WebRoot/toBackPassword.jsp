<!doctype html>
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
	<span class="fh left"><a href="javascript:history.back(1)">&nbsp;</a></span>  	找回密码
  	<span class="hd_right right">

</span>
</header>
<span id="login_errorMsg" style="padding:10px;"></span>
<div class="Login">

  <div> 
    <div class="Login_bottom" >
      <form id="registForm" action="/mobile/member/memberRegist.html" onSubmit="return checkRegForm()" method="post">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">

          <tr>
            <td height="60" align="left" valign="middle"><input type="text" value="" id="mobileRegNum" name="mobileRegNum" placeholder="手机号" class="login_wbk">
              <span id="mobileNumMsg"></span></td>
          </tr>
          <tr>
            <td height="60" align="left" valign="middle"><input type="password" id="passwordReg" name="passwordReg" placeholder="设置密码"  class="login_wbk"></td>
          </tr>
          <tr>
            <td height="60" align="left" valign="middle"><input type="password" id="repassword" name="repassword" placeholder="确认密码"  class="login_wbk"></td>
          </tr>
          <tr>
            <td height="60" align="left" valign="middle"><input type="text" id="captcha" name="captcha" placeholder="短信验证码"  class="login_wbk inputcheckbox" style=" width:49%;margin:0;">
              <A id="getCaptcha" name="getCaptcha" class="hqxzm inputcheckbox" style="cursor: pointer;width:39%; margin:0; margin-left:2%;" >获取验证码</A> </td>
          </tr>
      <!--    <tr>
            <td height="60" align="center" valign="middle"><Span>注册即同意<a href="agreement.html"><span style=" font-size:14px; text-decoration:underline;">海尔商城用户服务协议</span></a></Span></td>
          </tr>-->
          <tr>
            <td height="60" align="center" valign="middle">
			<a href="#" id="memberRegist" class="dl_login">立即找回</a>
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


</body>
</html>
