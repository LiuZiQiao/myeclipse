package servlet;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.Test;

import bean.Applying;
import bean.User;
import dao.ApplyingDao;
import utils.C3P0Util;
import utils.Xwpfchange;

/**
 * ����word�ļ�
 *
 */
@WebServlet("/wordDownloadServlet")
public class WordDownloadServlet extends HttpServlet {

	@Test
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html,charset=UTF-8");
		User user = (User) request.getSession().getAttribute("user");
		if(user==null)
			
			System.out.println("userΪ����");
		System.out.println(user);
		XWPFDocument document;
		try {
			//����Id�õ�map����
			Map<String, Object> map = new ApplyingDao().getMap(user);
			//�õ�wordģ��·��
			String srcPath = request.getSession().getServletContext().getRealPath("/wordTemplate/����ʡ�ߵ�ѧУ������ѧ�������.docx");
			//��ʼwordת��
			System.out.println("++++++++++++++++++++++++++++++��ʼת��++++++++++++++++++++++++++");
			document = new Xwpfchange().testTemplateWrite(srcPath, map);
			response.setHeader("Content-disposition", "attachment;filename="+URLEncoder.encode("����ʡ�ߵ�ѧУ������ѧ�������","utf-8")+".docx");
			document.write(response.getOutputStream());
		} catch (Exception e) {
			response.getWriter().write("����ʧ��");
			e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
