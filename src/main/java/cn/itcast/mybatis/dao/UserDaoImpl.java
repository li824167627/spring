package cn.itcast.mybatis.dao;

import org.apache.ibatis.session.*;


import cn.itcast.mybatis.po.User;

public class UserDaoImpl implements UserDao{
	
	private SqlSessionFactory sqlSessionFactory;
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	

	@Override
	public User findUserById(int id) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlsession = sqlSessionFactory.openSession();
		
		User user = sqlsession.selectOne("test.findUserById", id);
		
		sqlsession.close();
		
		return user;
	}

	@Override
	public void insertUser(User user) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlsession = sqlSessionFactory.openSession();
		
		sqlsession.insert("test.insertUser", user);
		
		sqlsession.commit();
		
		sqlsession.close();
		
	}

	@Override
	public void deleteUser(int id) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlsession = sqlSessionFactory.openSession();
		
		sqlsession.insert("test.deleteUser", id);
		
		sqlsession.commit();
		
		sqlsession.close();
	}
	
}
