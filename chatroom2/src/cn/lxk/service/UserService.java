package cn.lxk.service;

import cn.lxk.dao.UserDao;
import cn.lxk.dao.UserDaoImple;
import cn.lxk.vo.User;

public class UserService {

	public User login(User user) {
		UserDao dao = new UserDaoImple();
		return dao.login(user);
	}
	
	
}
