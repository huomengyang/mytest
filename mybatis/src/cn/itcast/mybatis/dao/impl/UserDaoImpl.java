package cn.itcast.mybatis.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.itcast.mybatis.dao.UserDao;
import cn.itcast.mybatis.po.User;
/**
 * 保证使用的是同一个连接工厂
 * 采用注入的方式，添加有参构造,参数为sqlSessionFactory
 * 
 * @author Administrator
 *
 */
public class UserDaoImpl implements UserDao {
	private SqlSessionFactory sqlSessionFactory;
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory){
		this.sqlSessionFactory = sqlSessionFactory;
	}
	@Override
	public void insertUser(User user) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("insertUser1", user);
		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public User getUsernameById(int id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = sqlSession.selectOne("findUserById", id);
		sqlSession.close();
		return user;
	}

}
