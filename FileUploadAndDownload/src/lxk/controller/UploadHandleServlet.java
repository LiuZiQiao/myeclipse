package lxk.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadHandleServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  savePath = this.getServletContext().getRealPath("WEB_INF/upload");
		File file = new File(savePath);
		if (!file.exists() && !file.isDirectory()) {
			System.out.println(savePath+"Ŀ¼�����ڣ���Ҫ����");
			file.mkdir();
		}
		
		String message ="";
		try {
			//ʹ��Apache�ļ��ϴ���������ļ��ϴ����裺
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setHeaderEncoding("UTF-8");//��ֹ�ϴ��ļ�������������
			if (!ServletFileUpload.isMultipartContent(request)) {
				return ;
			}
			
			/*
			 * ʹ��ServletFileUpload�����������ϴ����ݣ�����������ص���һ��List���ϣ�ÿһ��FileItem��Ӧһ��form����������
			 */
			List<FileItem> list = upload.parseRequest(request);
			for (FileItem item : list) {
				if (item.isFormField()) {
					String name = item.getFieldName();
					String value = item.getString("UTF-8");
					System.out.println(name+"="+value);
				}else{	//���fileitme �з�װ�����ϴ��ļ����õ��ϴ��ļ���
					String filename = item.getName();
					System.out.println(filename);
					if (filename ==null || filename.trim().equals("")) {
						continue;
					}
					
					filename = filename.substring(filename.lastIndexOf("\\")+1);
					InputStream in = item.getInputStream();
					FileOutputStream out = new FileOutputStream(savePath+"\\"+filename);
					byte buffer[] = new byte[1024];
					int len = 0;
					
					while((len = in.read(buffer))>0){
						out.write(buffer,0,len);
					}
					in.close();
					out.close();
					item.delete();
					message = "�ļ��ϴ��ɹ�";
					}
				}
		} catch (Exception e) {
			message = "�ļ��ϴ�ʧ��";
			e.printStackTrace();
		}
		request.setAttribute("message",message);
		request.getRequestDispatcher("/message.jsp").forward(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(request, response);
	}


}
