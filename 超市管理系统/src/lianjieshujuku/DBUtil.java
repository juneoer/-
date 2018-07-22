package lianjieshujuku;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;

public class DBUtil {
	//数据库连接池
		private static BasicDataSource ds;
		//为不同线程管理连接
		
		private static ThreadLocal<Connection> tl;
	static {
		try {
			
		
		Properties prop=new Properties();
		InputStream is=DBUtil
				.class
				.getClassLoader()
				.getResourceAsStream("lianjieshujuku/config.properties.txt");
		prop.load(is);
		is.close();
		//初始化连接池
		ds=new BasicDataSource();
		//设置驱动
		ds.setDriverClassName(prop.getProperty("driver"));
		//设置url
		ds.setUrl(prop.getProperty("url"));
		//设置数据库用户名
		ds.setUsername(prop.getProperty("user"));
		//设置数据库密码
		ds.setPassword(prop.getProperty("pwd"));
		//初始连接数量
		ds.setMinIdle(1);
		//最多连接数量
		ds.setMaxIdle(2);
		//设置最小空闲线程数量
		
		//设置最大等待时间
		
		
		tl= new ThreadLocal<Connection>();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws SQLException {
		/*
		 * 通过连接池获取一个空闲连接
		 */
		  Connection conn=ds.getConnection();
		  tl.set(conn);
		  return conn;
	}
	/**
	 * 关闭数据库连接
	 */
	public static void closeConnection() {
		try {
			Connection conn=tl.get();
			if(conn !=null) {
				//恢复连接为自动提交事务
				
				conn.setAutoCommit(true);
				/**
				 * 通过连接池获取的connection的
				 * close方法实际上并没有将
				 * 连接关闭，而是将该连接归还
				 */
				conn.close();
				tl.remove();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
