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
		System.out.println("��������");
		System.out.println("��˵һ����������");
		System.out.println("������ã���������");
		System.out.println("�ҹ�����˭");
		System.out.println("�����Ҷ�����");
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
