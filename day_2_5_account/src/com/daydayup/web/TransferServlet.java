package com.daydayup.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daydayup.service.TransferService;

public class TransferServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String out = request.getParameter("out");
		String in = request.getParameter("in");
		String moneyStr = request.getParameter("money");
		double money = Double.parseDouble(moneyStr);
		
		TransferService service = new TransferService();
		boolean isTransferSuccess = service.transfer(out,in,money);
		
		response.setContentType("text/heml;utf-8");
		if (isTransferSuccess) {
			response.getWriter().write("转账成功！");
		}else {
			response.getWriter().write("转账失败！");
		}
		
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		}
}
