package cn.itcast.mybatis.test;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.dao.impl.UserDaoImpl;
import cn.itcast.mybatis.po.User;

public class ImplTest {
	SqlSessionFactory sqlSessionFactory = null;

	@Before
	public void test1() throws IOException {
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		sqlSessionFactory = builder.build(Resources.getResourceAsStream("sqlMapConfig.xml"));
	}

	@Test
	public void Test() {
		UserDaoImpl userDaoImpl = new UserDaoImpl(sqlSessionFactory);
		User user = userDaoImpl.getUsernameById(10);
		System.out.println("我是张三");
		System.out.println("再说一遍我是张三");
		System.out.println("张三你好，我是李四");
		System.out.println("我管你是谁");
		System.out.println("你是我儿子吗");
		System.out.println(user);
	}
	
	@Test
	public void Test1(){
		UserDaoImpl userDaoImpl = new UserDaoImpl(sqlSessionFactory);
		User user = new User();
		user.setUsername("aj");
		userDaoImpl.insertUser(user);
		System.out.println(user.getId());
	}
}
