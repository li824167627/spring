package cn.itcast.mybatis.dao;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.mapper.UserMapper;
import cn.itcast.mybatis.po.User;
import cn.itcast.mybatis.po.UserCustom;
import cn.itcast.mybatis.po.UserQueryVo;

public class UserMapperTest {

	private SqlSessionFactory sqlSessionFactory;


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
	public void testFindUserById() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建USerMapper的对象,Mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		//调用userMapper的方法
		
		User user = userMapper.findUserById(1);
		
		System.out.println(user);
	}
	@Test
	public void testFindUserList() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建USerMapper的对象,Mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		//创建包装对象，设置查询条件
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setid(5);
		userCustom.setUsername("王小军");
		userQueryVo.setUserCustom(userCustom);
		//调用userMapper的方法
		
		List<UserCustom> list = userMapper.findUserList(userQueryVo);
		
		System.out.println(list);
		
		
	}
	
	@Test
	public void testFindUserByIdResultMap() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建USerMapper的对象,Mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		//调用userMapper的方法
		
		User user = userMapper.findUserByIdResultMap(1);
		
		System.out.println(user);
	}
}
