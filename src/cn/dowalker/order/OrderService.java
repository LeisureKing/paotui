package cn.dowalker.order;

import java.util.List;

import cn.dowalker.bean.Order;

public class OrderService {
	
	private OrderDao orderDao = new OrderDao();
	
	public void creatOrder(Order order) {
		orderDao.insertOrder(order);
	}
	
	public Order findOrder(String id) {
		return orderDao.findOrder(id);
	}
	
	public List<Order> findOrders() {
		return orderDao.getOrders();
	}
	
	public List<Order> findOrdersByRid(String reciveid){
		return orderDao.findOrderByRid(reciveid);
	}
	
	public List<Order> findOrdersByLid(String launchid) {
		return orderDao.findOrderByLid(launchid);
	}
	
	public void updateState(String id,int state) {
		orderDao.updateState(id, state);
	}
	
	public void updateReciveid(String id,String reciveid) {
		orderDao.updateReciveid(id, reciveid);
	}
	
	public void deleteReciveid(String id) {
		orderDao.deleteReciveid(id);
	}
}
