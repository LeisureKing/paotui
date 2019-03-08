package cn.dowalker.order;

import java.util.Date;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import cn.dowalker.bean.Order;
import cn.dowalker.bean.User;
import cn.dowalker.utils.BaseServlet;
import cn.dowalker.utils.UUIDUtils;

public class OrderServlet extends BaseServlet {
	private OrderService orderService = new OrderService();
	public String creatOrder(HttpServletRequest request,HttpServletResponse response)throws Exception {
		//获取表单数据,封装成bean
		Order form = new Order();
		BeanUtils.populate(form, request.getParameterMap());
		//补全id
		form.setId(UUIDUtils.getId());
		//写入时间
		form.setTime(new Date());
		//写入数据库
		orderService.creatOrder(form);
		return null;
	}
	
	public String findOrders(HttpServletRequest request,HttpServletResponse response)throws Exception {
		List<Order> orders = orderService.findOrders();
		request.setAttribute("orders", orders);
		return "/run_pool.jsp";
	}
	
	public String findOrder(HttpServletRequest request,HttpServletResponse response)throws Exception {
		String id = request.getParameter("id");
		Order order = orderService.findOrder(id);
		request.setAttribute("order", order);
		return null;
	}
	/**
	 * 查找我的下单
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public String findOrdersByLid(HttpServletRequest request,HttpServletResponse response)throws Exception {
		String launchid = request.getParameter("launchid");
		List<Order> orders = orderService.findOrdersByLid(launchid);
		request.setAttribute("orders", orders);
		return null;
	}
	/**
	 * 查找我的接单
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public String findOrdersByRid(HttpServletRequest request,HttpServletResponse response)throws Exception {
		String reciveid = request.getParameter("reciveid");
		List<Order> orders = orderService.findOrdersByRid(reciveid);
		request.setAttribute("orders", orders);
		return null;
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
		return null;
	}
}
