package cn.dowalker.address;

import java.sql.SQLException;
import java.util.List;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.dowalker.bean.Address;
import cn.dowalker.bean.Order;
import cn.dowalker.utils.DataSourceUtil;

public class AddressDao {
	QueryRunner qr=new QueryRunner(DataSourceUtil.getDataSource());
	
	/**
	 * 添加地址
	 * @param address
	 */
	public void addAddress(Address address) {
		try {
			String sql = "insert into address values(?,?,?,?,?)";
			Object[] params = {address.getId(), address.getUid(), address.getUsername(),
					address.getPhone(),address.getAddress()};
			qr.update(sql, params);
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 按id查找地址
	 * @param id
	 * @return
	 */
	public Address findByAddressById(String id) {
		try {
			String sql = "select * from address where id=?";
			return qr.query(sql, new BeanHandler<Address>(Address.class), id);
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Address> finAllAddress(String uid) {
		try {
			String sql="select * from address where uid=?";
			return qr.query(sql, new BeanListHandler<>(Address.class),uid);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void deleteAddress(String id) {
		try {
			String sql = "delete from address where id =?";
			qr.update(sql, id);
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
