package cn.itcast.mybatis.dao;

import static org.junit.Assert.*;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.po.User;

public class UserDaoImplTest {
	private SqlSessionFactory sqlSessionFactory;
	
	//此方法是执行执行testFindById之前执行
	@Before
	public void setUp() throws Exception {
		//创建sqlSessionFcatory
		//mybatis配置文件
		String resource = "config/SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		//创建会话工厂，传入mybatis的配置文件信息
		sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);
	}

	@Test
	public void testUserDaoImpl() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindUserById() throws Exception{
		fail("Not yet implemented");
		//创建UserDao的对象
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		
		//调用UserDao的方法
		User user = userDao.findUserById(1);
		
		System.out.println(user);
	}

	@Test
	public void testInsertUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteUser() {
		fail("Not yet implemented");
	}

}
