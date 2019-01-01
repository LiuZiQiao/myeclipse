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
 * 申请表数据访问层
 *
 */
public class ApplyingDao {

	/**
	 * 添加申请书
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
		//将connection(原来的数据库连接文件)换成了DBUtil.java
		Connection conn = DBUtil.getConnection();
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.execute(sql);
		DBUtil.close(null, pre, conn);
	}

	/**
	 * 把applying封装到map中以方便调用word转换函数
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
	 * 将applying bean转换为map
	 * @param applying
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public Map<String , Object> checkMapNull(Applying applying) throws IllegalArgumentException, IllegalAccessException{
		Map<String, Object> map = new HashMap<String, Object>();
		
		// 1、先获取bean的Clss对象（即字节码文件）
		Class beanClass = applying.getClass();

		// 2、通过字节码文件获取bean中的所有字段
		Field[] fields = beanClass.getDeclaredFields();

		// 3、分别取出字段的字段名和字段值（字段名作为map中的key,字段值作为map的value）
		for (Field field : fields) {
			field.setAccessible(true); // 设置属性的可访问行

			String fieldName = field.getName();// 得到bean中的属性名
			Object fieldValue = field.get(applying); // 得到bean中对应的属性值
			map.put(fieldName, fieldValue);
		}
		
		
		return map;
	}
	
	/**
	 * 检查applying bean中的未填项,由""转换为"未填写"
	 * @param applying
	 * @return
	 * @throws Exception 
	 */
	public Applying checkApplyingNull(Applying applying) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		
		// 1、先获取bean的Clss对象（即字节码文件）
		Class beanClass = applying.getClass();
		
		// 2、通过字节码文件获取bean中的所有字段
		Field[] fields = beanClass.getDeclaredFields();
		
		// 3、分别取出字段的字段名和字段值（字段名作为map中的key,字段值作为map的value）
		for (Field field : fields) {
			field.setAccessible(true); // 设置属性的可访问行
			
			String fieldName = field.getName();// 得到bean中的属性名
			Object fieldValue = field.get(applying); // 得到bean中对应的属性值
			if(fieldValue==""){
				fieldValue = "未填写";
				System.out.println("+++++++++++++++++++++++++++++++++++++++++");
				
			}
			//利用反射思想获取成员变量的set方法
			PropertyDescriptor prop = new PropertyDescriptor(fieldName, Applying.class);

	        // 获取setter方法，反射赋值
	        prop.getWriteMethod().invoke(applying, fieldValue);
		}
		return applying;
	}

}
