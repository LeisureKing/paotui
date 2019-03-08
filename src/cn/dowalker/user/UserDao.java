package cn.dowalker.user;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.dowalker.bean.User;
import cn.dowalker.utils.DataSourceUtil;

/**
 * User持久层
 * @author
 *
 */
public class UserDao {
	QueryRunner qr=new QueryRunner(DataSourceUtil.getDataSource());
	
	
	/**
	 * 按uid查询
	 * @param username
	 * @return
	 */
	public User findByUid(String uid) {
		try {
			String sql = "select * from user where id=?";
			return qr.query(sql, new BeanHandler<User>(User.class), uid);
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 按电话查询
	 * @param phone
	 * @return
	 */
	public User findByPhone(String phone) {
		try {
			String sql = "select * from user where phone=?";
			return qr.query(sql, new BeanHandler<User>(User.class), phone);
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	/**
	 * 插入User
	 * @param user
	 */
	public void add(User user) {
		try {
			String sql = "insert into user values(?,?,?,?)";
			Object[] params = {user.getId(), user.getUsername(), 
					user.getPassword(),user.getPhone()};
			qr.update(sql, params);
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	/**
	 * 修改指定用户的指定状态
	 * @param uid
	 * @param state
	 */
	public void updateState(String uid, boolean state) {
		try {
			String sql = "update user set state=? where uid=?";
			qr.update(sql, state, uid);
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
