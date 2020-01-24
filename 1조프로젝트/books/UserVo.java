package books;



public class UserVo {
	String tmId;	
	String tpwd;
	
	public UserVo() {
	}

	public UserVo(String Id, String pwd) {
		this.tmId = Id;
		this.tpwd = pwd;		
	}

	
	public String getTmId() {
		return tmId;
	}
	
	public void setTmId(String tmId) {
		this.tmId = tmId;
	}

	public String getTpwd() {
		return tpwd;
	}

	public void setTpwd(String tpwd) {
		this.tpwd = tpwd;
	}
	
}
