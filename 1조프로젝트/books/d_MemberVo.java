package books;

import java.util.Date;

public class d_MemberVo {

	String mId;
	String mPwd;
	String mPwdCheck;
	String  mBirth;
	String mPhone;
	String mEmail;
	String mName;
	
	public d_MemberVo() {}
	public d_MemberVo(String id, String pwd, String pwdCh,String name, String bir, String phone, String email) {
		this.mId = id;
		this.mPwd = pwd;
		this.mPwdCheck = pwdCh;
		this.mName=name;
		this.mBirth = bir;
		this.mPhone = phone;
		this.mEmail = email;
	}
	
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	/**
	 * @return the mId
	 */
	public String getmId() {
		return mId;
	}
	public String getmPwd() {
		return mPwd;
	}
	public void setmPwd(String mPwd) {
		this.mPwd = mPwd;
	}
	public String getmPwdCheck() {
		return mPwdCheck;
	}
	public void setmPwdCheck(String mPwdCheck) {
		this.mPwdCheck = mPwdCheck;
	}
	public String getmBirth() {
		return mBirth;
	}
	public void setmBirth(String mBirth) {
		this.mBirth = mBirth;
	}
	public String getmPhone() {
		return mPhone;
	}
	public void setmPhone(String mPhone) {
		this.mPhone = mPhone;
	}
	public String getmEmail() {
		return mEmail;
	}
	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	
	
}
