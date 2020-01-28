package books;

import java.text.SimpleDateFormat;
import java.util.Date;

public class p_MemberVo {
	String mId;
	String pwd;
	String mName;
	String birth;
	String rDate;
	String email;
	String phone;
	String state;
    String overdue;	
	public p_MemberVo() {
	}

	public p_MemberVo(String mId, String pwd, String mName, String birth, String rDate, String email, String phone,
			String state,String overdue) {
		this.mId = mId;
		this.pwd = pwd;
		this.mName = mName;
		this.birth = birth;
		this.rDate = rDate;
		this.email = email;
		this.phone = phone;
		this.state = state;
		this.overdue = overdue;
	}

	public String getOverdue() {
		return overdue;
	}

	public void setOverdue(String overdue) {
		this.overdue = overdue;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getrDate() {
		return rDate;
	}

	public void setrDate(String rDate) {
		this.rDate = rDate;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
