package cn.dowalker.user;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.alibaba.fastjson.JSONObject;
import com.zhenzi.sms.ZhenziSmsClient;

import cn.dowalker.bean.User;
import cn.dowalker.utils.BaseServlet;
import cn.dowalker.utils.UUIDUtils;
/**
* User表述层
*/
public class UserServlet extends BaseServlet {
	private UserService userService = new UserService();
	/**
	 * 登录功能
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	public String login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, IllegalAccessException, InvocationTargetException {
		
		User form = new User();
		BeanUtils.populate(form, request.getParameterMap());
		
		try {
			User user=userService.login(form);
			request.getSession().setAttribute("user", user);
			return "/index.html";
		} catch (UserException e) {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write( "<script>alert('"+e.getMessage()+"'); window.location='/toMemberLogin.html';window.close();</script>");
			response.getWriter().flush();
			return null;
		}
			
	}
	
	/**
	 * 退出功能
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String quit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().invalidate();
		return "r:/index.jsp";
	}
	
	/**
	 * 发送短信
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String getCode(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			String phone = request.getParameter("phone");
			JSONObject json = null;
			String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);
			HttpSession session=request.getSession();
			session.setAttribute("verifyCode", verifyCode);
			//发送短信
			ZhenziSmsClient client = new ZhenziSmsClient("https://sms_developer.zhenzikj.com", "100937", 
					"0689e4db-363c-4db6-9ec7-c17ce463c8f4");
			String result = client.send(phone, "您的验证码为:" + verifyCode + "，该码有效期为5分钟.");
			System.out.println("发送短信。。。。。。");
			json = JSONObject.parseObject(result);
			if(json.getIntValue("code") != 0){//发送短信失败
				response.setContentType("text/plain;charset=UTF-8");
				response.getWriter().write("fail");
				return null; 
			}
			response.getWriter().write("success");	
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return null;
	}
	
	
	
	public String regist(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String msg="";
		User user=new User();
		//注册自定义转化器
		//ConvertUtils.register(new MyConvert(), Date.class);
		
		BeanUtils.populate(user, request.getParameterMap());
		 //添加用户uid
		user.setId(UUIDUtils.getId());
		UserService userService=new UserService();
		if(userService.checkUser(request.getParameter("phone"))!=null){
			msg = "此号码已使用，请重新输入！";
		}else {
			userService.regist(user);
			msg = "注册成功！";
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write( "<script>alert('"+msg+"'); window.location='/toMemberLogin.html';window.close();</script>");
			response.getWriter().flush();
			return null;
		}
		System.out.println(msg);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write( "<script>alert('"+msg+"'); window.location='/toMemberRegist.html';window.close();</script>");
		response.getWriter().flush();
		return null;
	}
	
	
}
