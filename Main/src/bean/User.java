package bean;

public class User {
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_password=" + user_password
				+ ", user_sex=" + user_phone + ", user_power=" + user_power + "]";
	}
	private int user_id;
	private String user_name;
	private	 String user_password;
	private String user_phone;
	private String user_power;

	public User() {
	}
	public User(int user_id, String user_name, String user_password, String user_phone, String user_power) {
//		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_password = user_password;
		this.user_phone = user_phone;
		this.user_power = user_power;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_sex(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_power() {
		return user_power;
	}
	public void setUser_power(String user_power) {
		this.user_power = user_power;
	}
	
	
	

	
}
