package books;

public class m_HopeBookVo {
	String mId;
	String bName;
	String bWriter;
	String publ;
	
	public m_HopeBookVo() {
	}
	public m_HopeBookVo(String mId, String bName, String bWriter, String publ) {
		this.mId = mId;
		this.bName = bName;
		this.bWriter = bWriter;
		this.publ = publ;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public String getbWriter() {
		return bWriter;
	}
	public void setbWriter(String bWriter) {
		this.bWriter = bWriter;
	}
	public String getPubl() {
		return publ;
	}
	public void setPubl(String publ) {
		this.publ = publ;
	}
}
