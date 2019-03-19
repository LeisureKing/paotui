package cn.dowalker.notice;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.dowalker.bean.Notice;
import cn.dowalker.bean.Order;
import cn.dowalker.utils.DataSourceUtil;

public class NoticeDao {
	
	/**
	 * 添加通知
	 * @param notice
	 */
	public void insertNotice(Notice notice) {
		QueryRunner qr=new QueryRunner(DataSourceUtil.getDataSource());
		try {
			String sql="insert into notice values (?,?,?,?,?)";
			qr.update(sql,notice.getId(),notice.getUid(),notice.getDescription(),notice.getImage(),notice.getTime());
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 查找所有通知
	 * @return
	 */
	public List<Notice> getNotices() {
		QueryRunner qr=new QueryRunner(DataSourceUtil.getDataSource());
		try {
			String sql="select * from notice order by time desc";
			return qr.query(sql, new BeanListHandler<>(Notice.class));
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 查找单个通知
	 * @param id
	 * @return
	 */
	public Notice getNotice(String id) {
		QueryRunner qRunner=new QueryRunner(DataSourceUtil.getDataSource());
		try {
			String sql = "select * from notice where id=?";
			return qRunner.query(sql, new BeanHandler<Notice>(Notice.class), id );
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 删除通知
	 * @param id
	 */
	public void deleteNotice(String id) {
		QueryRunner qr=new QueryRunner(DataSourceUtil.getDataSource());
		try {
			String sql = "delete from notice where id=?";
			qr.update(sql, id);
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 查找我的通知
	 * @param uid
	 * @return
	 */
	public List<Notice> getMyNotices(String uid) {
		QueryRunner qr=new QueryRunner(DataSourceUtil.getDataSource());
		try {
			String sql="select * from notice where uid=? order by time desc";
			return qr.query(sql, new BeanListHandler<>(Notice.class),uid);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
