package Bean;

import java.io.Serializable;

public class CustomerBean implements Serializable {
	private String custName;
	private String email;
	private String phone;
	private boolean valid;
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	@Override
	public String toString() {
		return "CustomerBean [custName=" + custName + ", email=" + email
				+ ", phone=" + phone + ", valid=" + valid + "]";
	}
	

}
