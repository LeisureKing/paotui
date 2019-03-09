package cn.dowalker.user;

import cn.dowalker.bean.Address;
import cn.dowalker.bean.User;

/**
 * User业务层
 * @author cxf
 *
 */
public class UserService {
	private UserDao userDao = new UserDao();
	
	public User login(User form ) throws UserException{
		User user=userDao.findByPhone(form.getPhone());
		
		if(user==null)throw new UserException("此号码尚未注册！");
		
		if (!user.getPassword().equals(form.getPassword())) throw new UserException("密码错误");
		
		
		return user;
	}
	
	/**
	 * 注册功能
	 * @param form
	 */
	public void regist(User form) throws UserException{
		
		// 校验用户名
		User user = userDao.findByPhone(form.getPhone());
		if(user != null) throw new UserException("此号码已被注册！");
		
		// 插入用户到数据库
		userDao.add(form);
	}
	
	
	
	public User findByUid(String uid) {
		return userDao.findByUid(uid);
	}

	public User checkUser(String phone) {
		return userDao.findByPhone(phone);
	}
	
	public Address findByAddressByUid(String uid){
		return userDao.findByAddressByUid(uid);
	}

	public void updatePassword(String password, String phone) {
		userDao.updatePassword(password,phone);
	}
}
