package cn.itcast.mybatis.test;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.dao.UserMapper;
import cn.itcast.mybatis.po.User;

public class InterTest {
	
	SqlSessionFactoryBuilder builder = null;
	SqlSessionFactory sqlSessionFactory = null;

	@Before
	public void test1() throws IOException {
		builder = new SqlSessionFactoryBuilder();
		sqlSessionFactory = builder.build(Resources.getResourceAsStream("sqlMapConfig.xml"));
	}
	
	@Test
	public void test(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = mapper.findUserById(10);
		System.out.println(user);
		
	}
	@Test
	public void test2(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
	}
}
