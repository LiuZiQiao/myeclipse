package filter;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.UserDao;


public class AutoLoginFilter implements Filter {

	public void destroy() {
	}

	/**
	 * 1���鿴session����ľ��user���Ƿ��Ѿ���¼��
	 * 		�ǣ�ֱ�ӷ���
	 * 		������һ��
	 * 2���Ƿ�������login.jsp
	 * 		�ǣ�ֱ�ӷ���
	 * 		��ִ���Զ���¼(��cookies�в���user)
	 */
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		String URI = request.getRequestURI();
		String contextPath = request.getContextPath();
		URI = URI.substring(contextPath.length());
		
		
		User user = (User) request.getSession().getAttribute("user");
		if(user==null){//��ʱδ��¼
			if(!("/login.jsp".equals(URI)||"/loginServlet".equals(URI))){
			
				Cookie[] cookies = request.getCookies();
				if(cookies!=null){
					for (Cookie cookie : cookies) {						
						if("auto_login".equals(cookie.getName())){
							String auto_login=  URLDecoder.decode(cookie.getValue(),"utf-8");
							System.out.println(auto_login);
							String[] up = auto_login.split("-");
							String username = up[0];
							String password = up[1];
							user = new User();
							user.setUser_name(username);
							user.setUser_password(password);
							
								try {
									user = new UserDao().login(user);
									if(user!=null){
										
										request.getSession().setAttribute("user", user);
										System.out.println("�Զ���¼�ɹ�");
									}
										
								} catch (ClassNotFoundException e) {
									e.printStackTrace();
								}
						
						}
					}
					
				}
			}
		}
		chain.doFilter(arg0, arg1);
	}

	public void init(FilterConfig arg0) throws ServletException {
	}

}
