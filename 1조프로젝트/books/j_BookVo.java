package books;

import java.util.Date;

public class j_BookVo {

	String bName;
	String writer;
	String publisher;
	int bDate;
	int price;
	String bCode;
	int bGroup;
	int pages;
	String status;
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public j_BookVo(String bName, String writer, String publisher, int bDate, int price, String bCode, int bGroup,
			int pages, String status) {
		super();
		this.bName = bName;
		this.writer = writer;
		this.publisher = publisher;
		this.bDate = bDate;
		this.price = price;
		this.bCode = bCode;
		this.bGroup = bGroup;
		this.pages = pages;
		this.status = status;
	}
	
	public j_BookVo() {
		
	}
	
	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getbDate() {
		return bDate;
	}

	public void setbDate(int bDate) {
		this.bDate = bDate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getbCode() {
		return bCode;
	}

	public void setbCode(String bCode) {
		this.bCode = bCode;
	}

	public int getbGroup() {
		return bGroup;
	}

	public void setbGroup(int bGroup) {
		this.bGroup = bGroup;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	
}
