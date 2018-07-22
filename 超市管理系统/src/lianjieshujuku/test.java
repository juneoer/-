package lianjieshujuku;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class test {
	public static void main(String[] args) {
		Connection nn=null;
		try {
			nn=DBUtil.getConnection();
			String sql="insert into zdgl (zdnumber,zdname,gys,zdje,fukuan,time)  " + 
					"values('pro-code-002','1451','黄冈市五得利面粉厂','2241','未付款',"
					+ "to_date('2018-11-15','YYYY-mm-DD'))";
			PreparedStatement ps=nn.prepareStatement(sql);
			int flat=ps.executeUpdate();
			if(flat>0) {
				System.out.println("插入数据成功");
			}else {
				System.out.println("插入数据失败");
			}
			DBUtil.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}
	}
}
