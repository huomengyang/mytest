package cn.itcast.mybatis.dao;

import java.util.List;

import cn.itcast.mybatis.po.User;

public interface UserMapper {
	public User findUserById(int id);
	public void insertUser1(User user);
	public List<User> findByUsername(String username);
}
