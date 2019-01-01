package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBUtil {

	private static String driverClass;
	private static String url;
	private static String user;
	private static String password;
	private static Connection conn;

	static {
		url = "jdbc:MYSQL:///main";
		user = "root";
		password = "18729673011";
		driverClass = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driverClass);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static Connection getConnection() {
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void close(ResultSet res, Statement sta, Connection con) {
		if (res != null) {
			try {
				res.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (sta != null) {
			try {
				sta.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
