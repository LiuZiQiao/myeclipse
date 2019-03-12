package dao;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import bean.Applying;
import bean.User;
import utils.C3P0Util;
import utils.DBUtil;

/**
 * ��������ݷ��ʲ�
 *
 */
public class ApplyingDao {

	/**
	 * ���������
	 * 
	 * @param applying
	 * @throws SQLException
	 */
	public void addApplying(Applying applying) throws SQLException {
		
		String sql = "INSERT INTO application ("
				+ "user_name,user_sex,user_bir, user_nation, user_idcard,user_politic, "
				+ "bank_card,user_institute, user_department, user_major,user_grade, "
				+ "user_class,user_phone,residence, fam_num,y_income, m_income,mavg_income,"
				+ "income, user_address,user_post,username01,userage01, userrelationship01, "
				+ "userwork01,username02,userage02, userrelationship02, userwork02,"
				+ "username03,userage03, userrelationship03, userwork03,"
				+ "username04,userage04, userrelationship04, userwork04,"
				+ "username05,userage05, userrelationship05, userwork05,stipend, burse,users_id_" + ")" + "VALUES('"
				+ applying.getUser_name() + "','" + applying.getUser_sex() + "','" + applying.getUser_bir() + "','"
				+ applying.getUser_nation() +"','"+ applying.getUser_idcard() + "','" + applying.getUser_politic() + "','"
				+ applying.getBank_card() +"','"+ applying.getUser_institute() + "','" + applying.getUser_department() + "','"
				+ applying.getUser_major() +"','"+ applying.getUser_grade() + "','" + applying.getUser_class() + "','"
				+ applying.getUser_phone() +"','"+ applying.getResidence() + "','" + applying.getFam_num() + "','"
				+ applying.getY_income() + "','" + applying.getM_income() +"','"+ applying.getMavg_income() + "','"
				+ applying.getIncome() + "','" + applying.getUser_address() +"','"+ applying.getUser_post() + "','"
				+ applying.getUsername01() + "','" + applying.getUserage01() +"','"+ applying.getUserrelationship01() + "','"
				+ applying.getUserwork01() + "','" + applying.getUsername02() +"','"+ applying.getUserage02() + "','"
				+ applying.getUserrelationship02() + "','" + applying.getUserwork02() +"','"+ applying.getUsername03() + "','"
				+ applying.getUserage03() + "','" + applying.getUserrelationship03() +"','"+ applying.getUserwork03() + "','"
				+ applying.getUsername04() + "','" + applying.getUserage04() +"','"+ applying.getUserrelationship04() + "','"
				+ applying.getUserwork04() + "','" + applying.getUsername05() +"','"+ applying.getUserage05() + "','"
				+ applying.getUserrelationship05() + "','" + applying.getUserwork05() + "','" + applying.getStipend() + "','"
				+ applying.getBurse() +"','"+applying.getUsers_id_()+ "')";
		System.out.println(sql);
		//��connection(ԭ�������ݿ������ļ�)������DBUtil.java
		Connection conn = DBUtil.getConnection();
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.execute(sql);
		DBUtil.close(null, pre, conn);
	}

	/**
	 * ��applying��װ��map���Է������wordת������
	 * 
	 * @param application_id
	 * @return
	 * @throws SQLException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public Map<String, Object> getMap(User user) throws Exception {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		Applying applying = qr.query("select * from application where users_id_ =? order by application_id desc",
				new BeanHandler<Applying>(Applying.class), user.getUser_id());
		
		Map<String, Object> map = checkMapNull(applying);
		return map;
	}
	
	/**
	 * ��applying beanת��Ϊmap
	 * @param applying
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public Map<String , Object> checkMapNull(Applying applying) throws IllegalArgumentException, IllegalAccessException{
		Map<String, Object> map = new HashMap<String, Object>();
		
		// 1���Ȼ�ȡbean��Clss���󣨼��ֽ����ļ���
		Class beanClass = applying.getClass();

		// 2��ͨ���ֽ����ļ���ȡbean�е������ֶ�
		Field[] fields = beanClass.getDeclaredFields();

		// 3���ֱ�ȡ���ֶε��ֶ������ֶ�ֵ���ֶ�����Ϊmap�е�key,�ֶ�ֵ��Ϊmap��value��
		for (Field field : fields) {
			field.setAccessible(true); // �������ԵĿɷ�����

			String fieldName = field.getName();// �õ�bean�е�������
			Object fieldValue = field.get(applying); // �õ�bean�ж�Ӧ������ֵ
			map.put(fieldName, fieldValue);
		}
		
		
		return map;
	}
	
	/**
	 * ���applying bean�е�δ����,��""ת��Ϊ"δ��д"
	 * @param applying
	 * @return
	 * @throws Exception 
	 */
	public Applying checkApplyingNull(Applying applying) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		
		// 1���Ȼ�ȡbean��Clss���󣨼��ֽ����ļ���
		Class beanClass = applying.getClass();
		
		// 2��ͨ���ֽ����ļ���ȡbean�е������ֶ�
		Field[] fields = beanClass.getDeclaredFields();
		
		// 3���ֱ�ȡ���ֶε��ֶ������ֶ�ֵ���ֶ�����Ϊmap�е�key,�ֶ�ֵ��Ϊmap��value��
		for (Field field : fields) {
			field.setAccessible(true); // �������ԵĿɷ�����
			
			String fieldName = field.getName();// �õ�bean�е�������
			Object fieldValue = field.get(applying); // �õ�bean�ж�Ӧ������ֵ
			if(fieldValue==""){
				fieldValue = "δ��д";
				System.out.println("+++++++++++++++++++++++++++++++++++++++++");
				
			}
			//���÷���˼���ȡ��Ա������set����
			PropertyDescriptor prop = new PropertyDescriptor(fieldName, Applying.class);

	        // ��ȡsetter���������丳ֵ
	        prop.getWriteMethod().invoke(applying, fieldValue);
		}
		return applying;
	}

}
