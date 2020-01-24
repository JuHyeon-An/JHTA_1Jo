package books;

public class m_ManagerVo {
	String mId;
	String mPwd;
	
	public m_ManagerVo() {
	}
	
	public m_ManagerVo(String mId, String mPwd) {
		this.mId = mId;
		this.mPwd = mPwd;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getmPwd() {
		return mPwd;
	}

	public void setmPwd(String mPwd) {
		this.mPwd = mPwd;
	}
	
	
}
