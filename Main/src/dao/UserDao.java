package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.User;
import utils.DBUtil;

/**
 * User数据访问层
 *
 */
public class UserDao {

	/**
	 * 用户登录
	 * 
	 * @param user_name  用户名
	 * @param user_password  密码
	 * @return
	 * @throws ClassNotFoundException
	 */
	public User login(User user) throws ClassNotFoundException {
		User u = null;
		String sql = "SELECT * FROM users where user_name='" + user.getUser_name() + "' and user_password='"
				+ user.getUser_password() + "' ";
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			System.out.println("cuo");
			PreparedStatement pre = conn.prepareStatement(sql);
			rs = pre.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt(1);
				String name = rs.getString(2);
				String password = rs.getString(3);
				String phone = rs.getString(4);
				String power = rs.getString(5);
				u = new User(id, name, password, phone, power);
			}
			return u;
		} catch (SQLException e) {

		} finally {
			DBUtil.close(rs, null, conn);
		}

		return null;
	}

	/**
	 * 用户注册
	 * @param user
	 * @throws SQLException
	 */
	public void register(User user) throws SQLException {

		String sql = "INSERT INTO `users` (`user_name`, `user_password`,  `user_phone`,  `user_power`) " + "VALUES ('"
				+ user.getUser_name() + "', '" + user.getUser_password() + "', '" + user.getUser_phone() + "', '"
				+ user.getUser_power() + "')";

		Connection conn = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.execute(sql);
	}

}
