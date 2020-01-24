package books;

public class j_GroupVo {

	int gCode;
	String gName;
	
	public j_GroupVo() {
		
	}
	
	public j_GroupVo(int gCode, String gName) {
		super();
		this.gCode = gCode;
		this.gName = gName;
	}
	
	public int getgCode() {
		return gCode;
	}
	public void setgCode(int gCode) {
		this.gCode = gCode;
	}
	public String getgName() {
		return gName;
	}
	public void setgName(String gName) {
		this.gName = gName;
	}
	
	@Override
	public String toString() {
		String r = gCode+"";
		
		return r;
	}
	
	
}
