package com.lxk.ChatRoom.utils;

import java.util.Random;

import com.lxk.ChatRoom.bean.User;
import com.lxk.ChatRoom.dao.UserDao;
import com.lxk.ChatRoom.dao.UserDaoImpl;

public class Test {
	public static void main(String[] args) {
		UserDao ud = new UserDaoImpl();
		User user = new User();
		user.setUsernum("lxk");
		user.setPassword("123");
		System.out.println(ud.login(user));
		
//		String id = CreateId();
//		System.out.println(id);
//		while(true){
//			if(id.length() == 6 && !id.substring(0,1).equals('0') ){
////				user.setUsername(id);
//				System.out.println("id:"+id);
//				break;
//			}else{
//				id = CreateId();
//			}
//		}
	}
	
	public static String CreateId() {
		//����user��id������һ��id
		Random r = new Random();
		int nextInt = r.nextInt(1000000);
		String id = String.valueOf(nextInt);
		return id;
	}
}
