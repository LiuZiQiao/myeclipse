package util;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class DBhelper {
	
	private static final String  driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/shopping";
	private static final String username = "root";
	private static final String password = "18729673011";
	private static Connection conn=null;
	
	static
	{
		
		try {
			
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws Exception
		{
			if (conn==null){
				conn =  (Connection) DriverManager.getConnection(url, username, password);
				return conn;
			}
				return conn;
		
		}
	
	
	public static void main(String[] args) {
		try {
			Connection connection = DBhelper.getConnection();
			if(connection!=null)
			{
				System.out.println("数据库连接正常");
			}
			else {
				System.out.println("数据库连接异常");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
