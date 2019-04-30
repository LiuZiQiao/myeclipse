package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.BookBean;
import com.dao.BookDAO;

public class BookQueryServlet extends HttpServlet {

	private Connection conn;

	public void doGet(HttpServletRequest request, HttpServletResponse response, Connection conn)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		BookDAO bd = new BookDAO();
		conn = bd.getConnection();
		try {
			BookBean book = bd.find(id);
			request.setAttribute("book", book);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
