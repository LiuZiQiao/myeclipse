package servlet;

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import bean.User;
import dao.UserDao;
/**
 * 用户注册
 */
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		User user = new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
			new UserDao().register(user);
			//request.setAttribute("message", "注册成功");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
