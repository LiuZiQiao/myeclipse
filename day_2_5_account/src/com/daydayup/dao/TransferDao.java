package com.daydayup.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.utils.MyDataSourceUtils;

public class TransferDao {

	public void out(String out, double money) throws SQLException {
		QueryRunner runner = new QueryRunner();
		Connection conn = MyDataSourceUtils.getCurrentConnection();
		String sql = "update account_table set money=money-? where name=?";
		runner.update(conn, sql, money,out);
	}

	public void in(String in, double money) throws SQLException {
		QueryRunner runner = new QueryRunner();
		Connection conn = MyDataSourceUtils.getCurrentConnection();
		String sql = "update account_table set money=money+? where name=?";
		runner.update(conn, sql, money,in);
	}

}
