package cn.itcast.mybatis.test;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.po.User;

public class MyBatisTest {
	SqlSessionFactoryBuilder builder = null;
	SqlSessionFactory sqlSessionFactory = null;

	@Before
	public void test1() throws IOException {
		// 1.创建sqlsessionFactory
		builder = new SqlSessionFactoryBuilder();
		sqlSessionFactory = builder.build(Resources.getResourceAsStream("sqlMapConfig.xml"));
	}

	@Test
	public void test() throws IOException {
		// 2.获取sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 3.执行
		User user = sqlSession.selectOne("findUserById", 10);
		System.out.println(user);
		// 4.关闭资源
		sqlSession.close();
	}
	@Test
	public void findListTest(){
		// 2.获取sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<User> userList = sqlSession.selectList("findUserName", "张");
		for (User user : userList) {
			System.out.println(user);
		}
		sqlSession.close();
	}
	@Test
	public void insertUser(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = new User();
		user.setAddress("三里屯");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setUsername("一对男女");
		sqlSession.insert("insertUser", user);
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void insertUser1(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = new User();
		user.setAddress("家里面");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setUsername("cgx");
		sqlSession.insert("insertUser1", user);
		System.out.println(user.getId());
		sqlSession.commit();
		
		sqlSession.close();
	}
}
