package cn.dowalker.order;

import java.sql.SQLException;
import java.util.List;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.dowalker.bean.Order;
import cn.dowalker.utils.DataSourceUtil;

public class OrderDao {
	
	/**
	 * 添加订单
	 */
	public void insertOrder(Order order) {
		QueryRunner qr=new QueryRunner(DataSourceUtil.getDataSource());
		try {
			String sql="insert into `order` values (?,?,?,?,?,?,?,?,?,?)";
			qr.update(sql,order.getId(),order.getTitle(),order.getContent(),order.getExpecttime(),
					order.getTime(),order.getState(),order.getPrice(),order.getLaunchid(),order.getAddressid(),"");
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 查询所有订单
	 */
	public List<Order> getOrders() {
		QueryRunner qr=new QueryRunner(DataSourceUtil.getDataSource());
		try {
			String sql="select * from `order` where state<2";
			return qr.query(sql, new BeanListHandler<>(Order.class));
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 修改订单状态
	 */
	public void updateState(String id, int state) {
		QueryRunner qr=new QueryRunner(DataSourceUtil.getDataSource());
		try {
			String sql = "update `order` set state=? where id=?";
			qr.update(sql, state, id);
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 添加抢单人
	 * @param id
	 * @param reciveid
	 */
	public void updateReciveid(String id, String reciveid) {
		QueryRunner qr=new QueryRunner(DataSourceUtil.getDataSource());
		try {
			String sql = "update `order` set reciveid=? where id=?";
			qr.update(sql, reciveid, id);
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 删除抢单人
	 * @param id
	 */
	public void deleteReciveid(String id) {
		QueryRunner qr=new QueryRunner(DataSourceUtil.getDataSource());
		try {
			String sql = "update `order` set reciveid='' where id=?";
			qr.update(sql,id);
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	/**
	 * 查找单个订单
	 * @param id
	 * @return
	 */
	public Order findOrder(String id) {
		QueryRunner qRunner=new QueryRunner(DataSourceUtil.getDataSource());
		try {
			String sql = "select * from `order` where id=?";
			return qRunner.query(sql, new BeanHandler<Order>(Order.class), id );
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 查找我的抢单
	 * @param id
	 * @return
	 */
	public List<Order> findOrderByRid(String id) {
		QueryRunner qRunner=new QueryRunner(DataSourceUtil.getDataSource());
		try {
			String sql = "select * from `order` where reciveid=?";
			return qRunner.query(sql, new BeanListHandler<>(Order.class),id);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 查找我的下单
	 * @param id
	 * @return
	 */
	public List<Order> findOrderByLid(String id) {
		QueryRunner qRunner=new QueryRunner(DataSourceUtil.getDataSource());
		try {
			String sql = "select * from `order` where launchid=?";
			return qRunner.query(sql, new BeanListHandler<>(Order.class),id);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 查找已完成的订单数量
	 * @param uid
	 * @return
	 */
	public int getCount(String uid) {
		QueryRunner qr=new QueryRunner(DataSourceUtil.getDataSource());
		try {
			String sql="select count(id) from `order` where reciveid=? and state=2";
			Object obj = qr.query(sql, new ScalarHandler(),uid);
			return Integer.parseInt(obj.toString());
		}catch (SQLException e) {
		   e.printStackTrace();
		}
		return 0;
	}
}
