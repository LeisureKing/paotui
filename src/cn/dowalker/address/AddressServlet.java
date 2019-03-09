package cn.dowalker.address;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.dowalker.bean.Address;
import cn.dowalker.bean.AddressItem;
import cn.dowalker.bean.User;
import cn.dowalker.utils.BaseServlet;
import cn.dowalker.utils.UUIDUtils;

public class AddressServlet extends BaseServlet {
	
	//添加地址
	public String addAddress(HttpServletRequest request,HttpServletResponse response)throws Exception {
		AddressService addressService = new AddressService();
		User user = (User) request.getSession().getAttribute("user");
		//封装成bean
		Address address = new Address();
		BeanUtils.populate(address, request.getParameterMap());
		//补全信息
		address.setId(UUIDUtils.getId());
		address.setUid(user.getId());
		addressService.addAddress(address);
		//成功反馈
		response.sendRedirect(request.getContextPath()+"/AddressServlet?method=findAllAddress");
		return null;
	}
	
	
	//查找个人所有地址
	public String findAllAddress(HttpServletRequest request,HttpServletResponse response)throws Exception {
		User user = (User) request.getSession().getAttribute("user");
		
		if(user!=null){
			String uid = user.getId();
			
			AddressService addressService = new AddressService();
			List<Address> addresses = addressService.finAllAddress(uid);
			
			request.setAttribute("addresses", addresses);
		}else {
			response.sendRedirect(request.getContextPath()+"/toMemberLogin.html");
			return null;
		}
		return "/user/address.jsp";
	}
	
	//删除地址
	public String deleteAddress(HttpServletRequest request,HttpServletResponse response)throws Exception {
		String id = request.getParameter("id");
		
		AddressService addressService = new AddressService();
		addressService.deleteAddress(id);
		//成功反馈
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write( "<script>alert('删除成功！'); window.location='/paotui/user/address.jsp';window.close();</script>");
		response.getWriter().flush();
		return null;
	}
}
