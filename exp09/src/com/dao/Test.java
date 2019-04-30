package com.dao;

import java.sql.Connection;

public class Test {
	
	public static void main(String[] args) {
		BookDAO bo = new BookDAO();
		 Connection conn = bo.getConnection();
		 System.out.println(conn);
	}
}
