package com.lxk.ChatRoom.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.lxk.ChatRoom.bean.User;
import com.lxk.ChatRoom.service.UserService;
import com.lxk.ChatRoom.utils.BaseServlet;

public class RegisterServlet extends BaseServlet {

	public String register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		Map<String, String[]> map = request.getParameterMap();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;utf-8");
		response.setCharacterEncoding("utf-8");
		String usernum = null ;
		String password = request.getParameter("password");
		int age = Integer.parseInt(request.getParameter("age"));
		String realname = request.getParameter("realname");
		String sex = request.getParameter("sex");
		String type = "user";
		UserService us = new UserService();
		String id = CreateId();

//		User(String username, String password, String realname, int age,String sex, String type)
		while(true){
			if(id.length() == 6 && !id.substring(0,1).equals('0') && !us.find(id)){
				usernum = id;
				System.out.println("id:"+id);
				break;
			}else{
				id = CreateId();
			}
		}
		try {
//			BeanUtils.populate(user, map);
			User user = new User(usernum,password,realname,age,sex,type);
			System.out.println("ע���û���"+user);
			int res = us.regist(user);
			System.out.println("res:"+res);
			if(res==0){
				
				request.setAttribute("msg", "ע��ʧ��");
				return request.getContextPath()+"/regist.jsp";
			}else{
				request.setAttribute("id",id);
				PrintWriter pw = response.getWriter();
				pw.write("<h3>ע��idΪ:</h3>"+id);
				pw.write("<br/><h4>5�����ת����½ҳ��</h4>");

				response.setHeader("refresh","5,/ChatRoom/index.jsp");
//				response.sendRedirect(request.getContextPath()+"/index.jsp");
				return null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static String CreateId() {
		//����user��id������һ��id
		Random r = new Random();
		int nextInt = r.nextInt(1000000);
		String id = String.valueOf(nextInt);
		return id;
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.register(request, response);
	}

}
