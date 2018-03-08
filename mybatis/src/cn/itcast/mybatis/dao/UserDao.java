package cn.itcast.mybatis.dao;

import cn.itcast.mybatis.po.User;

public interface UserDao {
	public void insertUser(User user);
	public User getUsernameById(int id);
}
