package books;

public class m_UserInfoVo {
	String mId;
	String mName;
	String mBirth;
	String mPwd;
	String mEmail;
	String mPhone;
	
	public m_UserInfoVo() {
	}
	public m_UserInfoVo(String mId, String mName, String mBirth, String mPwd, String mEmail, String mPhone) {
		this.mId = mId;
		this.mName = mName;
		this.mBirth = mBirth;
		this.mPwd = mPwd;
		this.mEmail = mEmail;
		this.mPhone = mPhone;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getmBirth() {
		return mBirth;
	}
	public void setmBirth(String mBirth) {
		this.mBirth = mBirth;
	}
	public String getmPwd() {
		return mPwd;
	}
	public void setmPwd(String mPwd) {
		this.mPwd = mPwd;
	}
	public String getmEmail() {
		return mEmail;
	}
	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}
	public String getmPhone() {
		return mPhone;
	}
	public void setmPhone(String mPhone) {
		this.mPhone = mPhone;
	}
	
	
}
