package cn.itcast.mybatis.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*通过单独的JDBC程序来总结其中的问题
1.数据库连接，使用时就创建，不适用立即释放，对数据库进行频繁连接开启和关闭，造成数据库资源浪费，影响数据库性能。
解决方案：使用数据库连接池管理数据库连接
2.讲SQl语句硬编码到JAVA代码中，如果SQl语句修改，需要重新编码JAVA代码，不利于系统维护。
设想：讲SQL语句配置在XML文件中，即使SQl变化，不需要对JAVA代码进行重新编译。
3.向preparedStatement中设置参数，对占位符位置和设置参数值，硬编码在java中，不利于系统维护。
设想：将SQl语句及占位符和参数全部配置在XML中。
4.从resultSet中便利结果集数据时，存在硬编码，景获取表的字段进行硬编码，不利于系统维护。
设想：将查询的结果集，自动映射成JAVA对象。
*/
public class JdbcTest {
	public static void main(String[] args) {
		//数据库连接
		Connection connection = null;
		//预编译的Statement，预编译提高数据库的性能
		PreparedStatement preparedStatement = null;
		//结果集
		ResultSet resultSet = null;
		
		try {
			//加载数据库驱动
//			Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.jdbc.Driver");
			
			//通过驱动管理类获取数据库连接
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop?","root", "77585241");
			//定义sql语句？表示占位符
			String sql = "select * from user where username = ?";
			//获取预处理statement
			preparedStatement = connection.prepareStatement(sql);
			//设置参数，第一个参数为sql语句中参数的序号（从1开始），第二个参数为设置的参数值
			preparedStatement.setString(1,"bbb");
			//向数据库发出sql执行查询，查询出结果集
			 resultSet = preparedStatement.executeQuery();
			 //遍历结果集
			 while(resultSet.next()) {
				 System.out.println(resultSet.getString("name")+" "+resultSet.getString("username"));
			 }
			 System.out.println("over");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			//释放资源
			if(resultSet!=null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			if(preparedStatement!=null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
	}
}
