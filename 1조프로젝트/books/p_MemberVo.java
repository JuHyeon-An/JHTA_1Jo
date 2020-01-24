package books;

import java.text.SimpleDateFormat;
import java.util.Date;

public class p_MemberVo {
	String mId;
	int pwd;
	String mName;
	Date birth;
	Date rDate;
	String email;
	String phone;
	String state;

	public p_MemberVo() {
	}

	public p_MemberVo(String mId, int pwd, String mName, Date birth, Date rDate, String email, String phone,
			String state) {
		this.mId = mId;
		this.pwd = pwd;
		this.mName = mName;
		this.birth = birth;
		this.rDate = rDate;
		this.email = email;
		this.phone = phone;
		this.state = state;
	}

	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E)");
		String d = sdf.format(rDate);
		String date = sdf.format(birth);

		String tmep = String.format("%10s\t%15s\t%15s\t%15s\t%10s\t%10s\t%5s\tn", mId, mName, date, d, email, phone,
				state);

		return tmep;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public int getPwd() {
		return pwd;
	}

	public void setPwd(int pwd) {
		this.pwd = pwd;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Date getrDate() {
		return rDate;
	}

	public void setrDate(Date rDate) {
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
