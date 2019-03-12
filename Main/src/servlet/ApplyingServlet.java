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
 * �ύ�����
 */
@WebServlet("/applyingServlet")
public class ApplyingServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		User user = (User) request.getSession().getAttribute("user");
		Applying applying = new Applying();
		try {

			// �������ֶκ�applying�е��ֶζ�Ӧ��װ����,���δ��д��Ϊ""(���ַ���)������null
			BeanUtils.populate(applying, request.getParameterMap());
			applying.setUsers_id_(user.getUser_id());
			// ����applying�е�δ��ֵ
			applying = new ApplyingDao().checkApplyingNull(applying);
			// ����dao����ӷ���
			new ApplyingDao().addApplying(applying);
		} catch (Exception e) {
			// ���쳣˵�����ʧ��
			e.printStackTrace();
		}
		request.setAttribute("message", "�ύ�ɹ�");
		//request.getSession().setAttribute("application_id", applying.getApplication_id());
		request.getRequestDispatcher("/download.jsp").forward(request, response);

	}

}
