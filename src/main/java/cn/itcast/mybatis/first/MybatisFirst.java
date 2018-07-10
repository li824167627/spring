package cn.itcast.mybatis.first;


import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.itcast.mybatis.po.User;

public class MybatisFirst {
	//根据id查询用户信息，得到一条记录信息
	//用selectone
	@Test
	
	public void findUserByIdTest() throws IOException{
		
	
		//mybatis配置文件
		String resource = "config/SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		//创建会话工厂，传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//创建工厂得到SqlSession
		SqlSession sqlsession = sqlSessionFactory.openSession();
		
		//通过SqlSession操作数据库
		User user = sqlsession.selectOne("test.findUserById",1);
		
		System.out.println(user);
		//释放资源
		sqlsession.close();
	}
		//根据用户名称模糊查询用户列表
		//用selectlist
		@Test
		public void findUserByNameTest() throws IOException{
			
			
			//mybatis配置文件
			String resource = "config/SqlMapConfig.xml";
			//得到配置文件流
			InputStream inputStream = Resources.getResourceAsStream(resource);
			
			//创建会话工厂，传入mybatis的配置文件信息
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
			//创建工厂得到SqlSession
			SqlSession sqlsession = sqlSessionFactory.openSession();
			
			//通过SqlSession操作数据库
			List<User> list = sqlsession.selectList("test.findUserByName","李");
			
			System.out.println(list);
			//释放资源
			sqlsession.close();
			
	}
	//更新用户信息
		@Test
		public void updateUserTest() throws IOException{
			
			
			//mybatis配置文件
			String resource = "config/SqlMapConfig.xml";
			//得到配置文件流
			InputStream inputStream = Resources.getResourceAsStream(resource);
			
			//创建会话工厂，传入mybatis的配置文件信息
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
			//创建工厂得到SqlSession
			SqlSession sqlsession = sqlSessionFactory.openSession();
			User user = new User();
			user.setid(5);
			user.setUsername("王大军");
			user.setSex("男");
			user.setBirthday(new Date());
			user.setAddress("河南");
			
			//通过SqlSession操作数据库
			sqlsession.selectList("test.updateUser",user);
			//提交事务
			sqlsession.commit();
			//释放资源
			sqlsession.close();
			
	}
		//删除用户信息
				@Test
				public void deleteUserTest() throws IOException{
					
					
					//mybatis配置文件
					String resource = "config/SqlMapConfig.xml";
					//得到配置文件流
					InputStream inputStream = Resources.getResourceAsStream(resource);
					
					//创建会话工厂，传入mybatis的配置文件信息
					SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
					
					//创建工厂得到SqlSession
					SqlSession sqlsession = sqlSessionFactory.openSession();
					
					//传入id删除用户
					//通过SqlSession操作数据库
					sqlsession.selectList("test.deleteUser","4");
					//提交事务
					sqlsession.commit();
					//获取用户信息主键
					//释放资源
					sqlsession.close();
					
			}	
		
		
}

