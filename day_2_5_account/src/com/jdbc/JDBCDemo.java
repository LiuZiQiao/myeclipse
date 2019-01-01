package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {

	public static void main(String[] args) {
		
	
		Connection conn = null;
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
			conn = DriverManager.getConnection("jdbc:mysql:///account", "root", "18729673011");
			
			//手动�?��事务
			conn.setAutoCommit(false);
			
			//3、获得执行平�?
			Statement stmt = conn.createStatement();
			
			//4、操作sql
			stmt.executeUpdate("update account set money=5000 where name='tom'");
			
			
			//提交事务
			conn.commit();
			
			stmt.close();
			conn.close();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		
		
		
	}
	
}
