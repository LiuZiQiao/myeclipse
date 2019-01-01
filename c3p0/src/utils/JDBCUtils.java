package utils;

import java.sql.Connection;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {

	private static ComboPooledDataSource dataSource = new ComboPooledDataSource("chatroom");

	public DataSource getDataSource()
	{
		return dataSource;
	}
	
	public static Connection getConnection(){
		try {
			return dataSource.getConnection();
		} catch (Exception e) {
			System.out.println("faild");
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn  = JDBCUtils.getConnection();
		System.out.println(conn);
	}

}
