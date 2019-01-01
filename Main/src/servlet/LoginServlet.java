package servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import bean.User;
import dao.UserDao;

/**
 * 用户登录
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		User user = new User();
		
		
		try {
			BeanUtils.populate(user, request.getParameterMap());
			user = new UserDao().login(user);
			if( user == null){//登录失败
				request.setAttribute("message", "登录失败，请重新登录。");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}else {		//登录成功
				
				
				//判断是否记住密码
				String auto_login = request.getParameter("remember");
				String nameAndPassword =user.getUser_name()+"-"+user.getUser_password();
				Cookie cookie1 = new Cookie("auto_login", URLEncoder.encode(nameAndPassword,"utf-8"));
				cookie1.setPath("/");
				if(auto_login!=null){
					cookie1.setMaxAge(60*60*24*7);
				}else {
					cookie1.setMaxAge(0);
				}
				response.addCookie(cookie1);
				
				//存入user
				session.setAttribute("user", user);
				//老师
				if("admin".equals(user.getUser_power())) {
					request.getRequestDispatcher("/transfer.jsp").forward(request, response);
				}
				//学生
				else {
					request.getRequestDispatcher("/apply.jsp").forward(request, response);
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
