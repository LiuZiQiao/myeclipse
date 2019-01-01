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
 * 下载word文件
 *
 */
@WebServlet("/wordDownloadServlet")
public class WordDownloadServlet extends HttpServlet {

	@Test
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html,charset=UTF-8");
		User user = (User) request.getSession().getAttribute("user");
		if(user==null)
			
			System.out.println("user为空了");
		System.out.println(user);
		XWPFDocument document;
		try {
			//根据Id得到map集合
			Map<String, Object> map = new ApplyingDao().getMap(user);
			//得到word模板路径
			String srcPath = request.getSession().getServletContext().getRealPath("/wordTemplate/陕西省高等学校国家助学金申请表.docx");
			//开始word转换
			System.out.println("++++++++++++++++++++++++++++++开始转换++++++++++++++++++++++++++");
			document = new Xwpfchange().testTemplateWrite(srcPath, map);
			response.setHeader("Content-disposition", "attachment;filename="+URLEncoder.encode("陕西省高等学校国家助学金申请表","utf-8")+".docx");
			document.write(response.getOutputStream());
		} catch (Exception e) {
			response.getWriter().write("下载失败");
			e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
