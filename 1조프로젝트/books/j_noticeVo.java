package books;

public class j_noticeVo {

	String title;
	String writer;
	String contents;
	String regDate;
	int serial;
	
	public int getSerial() {
		return serial;
	}

	public void setSerial(int serial) {
		this.serial = serial;
	}

	j_noticeVo(){
		
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public j_noticeVo(String title, String writer, String contents, String regDate, int serial) {
		super();
		this.title = title;
		this.writer = writer;
		this.contents = contents;
		this.regDate = regDate;
		this.serial = serial;
	}
	
}
