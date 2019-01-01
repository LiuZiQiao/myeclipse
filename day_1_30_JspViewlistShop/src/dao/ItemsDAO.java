package dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import util.DBhelper;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import entity.Items;

public class ItemsDAO {

	public ArrayList<Items> getAllItems() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Items> list = new ArrayList<Items>();
		try {

			conn = DBhelper.getConnection();
			String sql = "select *from Items;";
			stmt = (PreparedStatement) conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Items items = new Items();
				items.setId(rs.getInt("id"));
				items.setName(rs.getString("name"));
				items.setCity(rs.getString("city"));
				items.setNumber(rs.getInt("number"));
				items.setPrice(rs.getInt("price"));
				items.setPicture(rs.getString("picture"));
				list.add(items);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			try {
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}

	// 根据商品编号获得商品资料
	public Items getItemsById(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			conn = DBhelper.getConnection();
			String sql = "select *from Items where id=?";
			stmt = (PreparedStatement) conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				Items items = new Items();
				items.setId(rs.getInt("id"));
				items.setName(rs.getString("name"));
				items.setCity(rs.getString("city"));
				items.setNumber(rs.getInt("number"));
				items.setPrice(rs.getInt("price"));
				items.setPicture(rs.getString("picture"));
				return items;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			try {
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
//	public ArrayList<Items> getViewList(String list)
//	{
//		ArrayList<Items>  itemslist = new  ArrayList<Items>();	
//		int iCount = 5;
//		if(list!=null&&list.length()>0)
//		{
//			String [] arr= list.split(",");
//			if (arr.length>=5) {
//				for (int i = arr.length-1;i>=arr.length-5-1; i--)
//				{
//					itemslist.add(getItemsById(i));
//				}
//			}
//			else {
//				for (int i = arr.length-1;i>0; i--)
//				{
//					itemslist.add(getItemsById(i));
//				}	
//			}
//			for (String s:arr)
//			{
//			int id	= Integer.parseInt(s);
//				itemslist.add(getItemsById(id));
//			}
//			return itemslist;
//		}
//		else {
//			return null;
//		}
//	
//	}
//	
	//获取最近浏览的前五条商品信息
	public ArrayList<Items> getViewList(String list)
	{
		System.out.println("list:"+list);
		ArrayList<Items> itemlist = new ArrayList<Items>();
		int iCount=5; //每次返回前五条记录
		if(list!=null&&list.length()>0)
		{
		    String[] arr = list.split(",");
		    System.out.println("arr.length="+arr.length);
		    //如果商品记录大于等于5条
		    if(arr.length>=5)
		    {
		       for(int i=arr.length-1;i>=arr.length-iCount;i--)
		       {
		    	  itemlist.add(getItemsById(Integer.parseInt(arr[i])));  
		       }
		    }
		    else
		    {
		    	for(int i=arr.length-1;i>=0;i--)
		    	{
		    		itemlist.add(getItemsById(Integer.parseInt(arr[i])));
		    	}
		    }
		    return itemlist;
		}
		else
		{
			return null;
		}
		
	}
	
}
