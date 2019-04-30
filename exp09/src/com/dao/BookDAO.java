package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.BookBean;

public class BookDAO {
	private String driver = "com.mysql.jdbc.Driver";
	private String Url ="jdbc:mysql:///test";
	private	String username = "root";
	private String password = "123456";
	
	private Connection conn;
	
	public Connection getConnection()
	{
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(Url,username,password);
//			String sql = "select *from books";
//			PreparedStatement pstm = conn.prepareStatement(sql);
//			ResultSet rs = pstm.executeQuery();
//			while(rs.next()){
//				System.out.println(rs.getString(5)+"--"+rs.getString(1)+"--"+rs.getString(2)+"--"+rs.getString(3)+"--"+rs.getString(4));
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public BookBean find(String id) throws SQLException {
		BookBean book = new BookBean();
		if(getConnection() != null){
			String sql = "select *from books where id ="+id;
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			book.setBookId(rs.getString(1));
			book.setAuthor(rs.getString(2));
			book.setTitle(rs.getString(3));
			book.setPublisher(rs.getString(4));
			book.setPrice(rs.getFloat(5));
		}
		return book;
	}
}
