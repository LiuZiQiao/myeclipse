package com.daydayup.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.daydayup.dao.TransferDao;
import com.utils.MyDataSourceUtils;

public class TransferService {

	public boolean transfer(String out, String in, double money) {
		
		TransferDao dao = new TransferDao();
		
		boolean isTranferSuccess = true;
		//Connection conn = null;
		try {
			
			//��������
			//conn = DataSourceUtils.getConnection();
			//conn.setAutoCommit(false);
			
			//��������
			MyDataSourceUtils.startTransaction();
			
			//ת��Ǯ�ķ���  
			dao.out(out,money);
			//int i = 1/0;
			//ת��Ǯ�ķ���
			dao.in(in,money);
			
		} catch (Exception e) {
			isTranferSuccess = false;
			//�ع�����
			try {
				MyDataSourceUtils.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally{
			try {
				MyDataSourceUtils.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return isTranferSuccess;
		
	}

}
