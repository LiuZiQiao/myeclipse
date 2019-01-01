package servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import bean.Applying;
import bean.User;
import dao.ApplyingDao;

/**
 * 提交申请表
 */
@WebServlet("/applyingServlet")
public class ApplyingServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		User user = (User) request.getSession().getAttribute("user");
		Applying applying = new Applying();
		try {

			// 将表中字段和applying中的字段对应封装起来,如果未填写则为""(空字符串)而不是null
			BeanUtils.populate(applying, request.getParameterMap());
			applying.setUsers_id_(user.getUser_id());
			// 处理applying中的未填值
			applying = new ApplyingDao().checkApplyingNull(applying);
			// 调用dao的添加方法
			new ApplyingDao().addApplying(applying);
		} catch (Exception e) {
			// 有异常说明添加失败
			e.printStackTrace();
		}
		request.setAttribute("message", "提交成功");
		//request.getSession().setAttribute("application_id", applying.getApplication_id());
		request.getRequestDispatcher("/download.jsp").forward(request, response);

	}

}
