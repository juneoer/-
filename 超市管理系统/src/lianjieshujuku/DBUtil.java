package lianjieshujuku;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;

public class DBUtil {
	//���ݿ����ӳ�
		private static BasicDataSource ds;
		//Ϊ��ͬ�̹߳�������
		
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
		//��ʼ�����ӳ�
		ds=new BasicDataSource();
		//��������
		ds.setDriverClassName(prop.getProperty("driver"));
		//����url
		ds.setUrl(prop.getProperty("url"));
		//�������ݿ��û���
		ds.setUsername(prop.getProperty("user"));
		//�������ݿ�����
		ds.setPassword(prop.getProperty("pwd"));
		//��ʼ��������
		ds.setMinIdle(1);
		//�����������
		ds.setMaxIdle(2);
		//������С�����߳�����
		
		//�������ȴ�ʱ��
		
		
		tl= new ThreadLocal<Connection>();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws SQLException {
		/*
		 * ͨ�����ӳػ�ȡһ����������
		 */
		  Connection conn=ds.getConnection();
		  tl.set(conn);
		  return conn;
	}
	/**
	 * �ر����ݿ�����
	 */
	public static void closeConnection() {
		try {
			Connection conn=tl.get();
			if(conn !=null) {
				//�ָ�����Ϊ�Զ��ύ����
				
				conn.setAutoCommit(true);
				/**
				 * ͨ�����ӳػ�ȡ��connection��
				 * close����ʵ���ϲ�û�н�
				 * ���ӹرգ����ǽ������ӹ黹
				 */
				conn.close();
				tl.remove();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
