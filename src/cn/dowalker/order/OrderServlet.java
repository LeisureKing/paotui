package cn.dowalker.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.jms.Session;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

import cn.dowalker.address.AddressService;
import cn.dowalker.bean.Order;
import cn.dowalker.bean.OrderItem;
import cn.dowalker.bean.User;
import cn.dowalker.user.UserService;
import cn.dowalker.utils.BaseServlet;
import cn.dowalker.utils.MyConvert;
import cn.dowalker.utils.UUIDUtils;

public class OrderServlet extends BaseServlet {
	private OrderService orderService = new OrderService();
	public String creatOrder(HttpServletRequest request,HttpServletResponse response)throws Exception {
		//获取表单数据,封装成bean
		Order form = new Order();
		ConvertUtils.register(new MyConvert(), Date.class);
		BeanUtils.populate(form, request.getParameterMap());
		//补全state
		form.setState(0);
		//补全launchid
		form.setTime(new Date());
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		form.setLaunchid(user.getId());
		//补全id
		form.setId(UUIDUtils.getId());
		//写入数据库
		orderService.creatOrder(form);
		response.sendRedirect(request.getContextPath()+"/OrderServlet?method=findOrdersByLid");
		return null;
	}
	//查询所有订单
	public String findOrders(HttpServletRequest request,HttpServletResponse response)throws Exception {
		UserService userService = new UserService();
		List<Order> orders = orderService.findOrders();
		//将取得的所有订单包装，按下单人id找到用户名，添加到orderItem中。
		List<OrderItem> orderItems =new ArrayList<>();
		if (orders!=null) {
			for (Order order : orders) {
				String id = order.getLaunchid();
				String username = userService.findByUid(id).getUsername();
				OrderItem orderItem = new OrderItem();
				orderItem.setOrder(order);
				orderItem.setUsername(username);
				orderItems.add(orderItem);
			}
		}
		request.setAttribute("orders", orderItems);
		return "/run_pool.jsp";
	}
	//订单详情
	public String findOrder(HttpServletRequest request,HttpServletResponse response)throws Exception {
		UserService userService = new UserService();
		AddressService addressService = new AddressService();
		String id = request.getParameter("id");
		Order order = orderService.findOrder(id);
		//根据订单取得下单人信息。用户名和地址。
		String username = userService.findByUid(order.getLaunchid()).getUsername();
		String address = addressService.findByAddressById(order.getAddressid()).getAddress();
		OrderItem orderItem = new OrderItem(order,username,address);
		request.setAttribute("order", orderItem);
		return "/content.jsp";
	}
	/**
	 * 查找我的下单
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public String findOrdersByLid(HttpServletRequest request,HttpServletResponse response)throws Exception {
		User user = (User) request.getSession().getAttribute("user");
		if(user!=null){
			String launchid = user.getId();
			List<Order> orders = orderService.findOrdersByLid(launchid);
			request.setAttribute("orders", orders);
		}else {
			response.sendRedirect(request.getContextPath()+"/toMemberLogin.html");
			return null;
		}
		
		return "/user/order.jsp";
	}
	/**
	 * 查找我的接单
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public String findOrdersByRid(HttpServletRequest request,HttpServletResponse response)throws Exception {
		User user = (User) request.getSession().getAttribute("user");
		AddressService addressService = new AddressService();
		if(user!=null){
			String reciveid = user.getId();
			List<Order> orders = orderService.findOrdersByRid(reciveid);
			List<OrderItem> orderItems = new ArrayList<OrderItem>();
			for (Order order : orders) {
				OrderItem orderItem = new OrderItem();
				orderItem.setOrder(order);
				orderItem.setPhone(addressService.findByAddressById(order.getAddressid()).getPhone());
				orderItems.add(orderItem);
			}
			request.setAttribute("orderItems", orderItems);
		}else {
			response.sendRedirect(request.getContextPath()+"/toMemberLogin.html");
			return null;
		}
		return "/user/run_order.jsp";
	}
	/**
	 * 接单，添加接单人id，同时将订单状态改为1.
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public String reciveOrder(HttpServletRequest request,HttpServletResponse response)throws Exception {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");//取得用户对象
		String orderId = request.getParameter("id");
		orderService.updateReciveid(orderId, user.getId());//将下单人id填入。
		orderService.updateState(orderId, 1);
		response.sendRedirect(request.getContextPath()+"/OrderServlet?method=findOrdersByRid");
		return null;
	}
	/**
	 * 转让订单，将原来的接单人id清除，将订单状态变为0。
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public String transferOrder(HttpServletRequest request,HttpServletResponse response)throws Exception {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String orderId = request.getParameter("id");
		orderService.deleteReciveid(orderId);
		orderService.updateState(orderId, 0);
		response.sendRedirect(request.getContextPath()+"/OrderServlet?method=findOrdersByRid");
		return null;
	}
	
	/**
	 * 完成订单，状态变为2
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public String finishOrder(HttpServletRequest request,HttpServletResponse response)throws Exception {
		String orderId = request.getParameter("id");
		orderService.updateState(orderId, 2);
		response.sendRedirect(request.getContextPath()+"/OrderServlet?method=findOrdersByRid");
		return null;
	}
	
	/**
	 * 取消订单，状态变为3
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public String deleteOrder(HttpServletRequest request,HttpServletResponse response)throws Exception {
		String orderId = request.getParameter("id");
		orderService.updateState(orderId, 3);
		response.sendRedirect(request.getContextPath()+"/OrderServlet?method=findOrdersByLid");
		return null;
	}
}
