package utils;

import java.io.File;
import java.io.IOException;

import javax.servlet.jsp.JspWriter;

public class IteratorDir {
	
	/**
	 * ����һ���ļ��������е��ļ�
	 * @param file  	·��
	 * @param depth		�����Ĳ���
	 * @param out		jsp������������������Ӧ����ҳ��
	 */
	public void find(File file,int depth,JspWriter out) {
		try {
			if(depth==5)
				return;			
			if(file.exists()){
				String path = "";
				path = "--"+file.getName();
				String size = "";
				if(file.isFile()){
					Double totalSpace = (file.length()*1.0/1024/1024);
					if(totalSpace>500) {
						size = totalSpace/1024 + "";
						size = size.substring(0,size.indexOf(".")+3)+"G";
					}else{
						size = totalSpace + "";
						size = size.substring(0,size.indexOf(".")+1)+"M";
					}
					for (int i = 0; i < depth; i++) {
						path = "&nbsp;&nbsp;&nbsp;&nbsp;"+path;
					}
					//style="width:100px;height:100px;background:red;"
					
					//path = "<span><a href=/upload_download/1.jsp?filepath="+file.getAbsolutePath()+">"+path+"</a></span>";
					path = "<span><a href=/upload_download/servlet/download?filepath="+file.getAbsolutePath()+">"+path+"</a></span>";
					path += "&nbsp;";
					path += size+"<br>";
				}else{
					for (int i = 0; i < depth; i++) {
						path = "&nbsp;&nbsp;&nbsp;&nbsp;"+path;
					}
					//style="width:100px;height:100px;background:red;"
					path = "<span class='dir'>"+path+"</span>";
					path += "&nbsp;";
					path += size+"<br>";
				}
					
				
				out.print(path);
				if(file.isDirectory()){
					File[] lists = file.listFiles();
					if(lists!=null){
						for (int i = 0; i < lists.length; i++) {
							find(lists[i], depth+1, out);
							//System.out.println(new File(file,lists[i]));
						}
					}
				}
			}else 
				out.print("·�������ڣ�");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
