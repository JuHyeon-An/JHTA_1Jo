package books;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class j_BookDao {

	String sql;
	Connection conn;
	j_BookVo vo;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public j_BookDao() {
		conn = DBConn.getConn();
	}
	/*
	 * 작성 : 주현 새로 들어온 도서 입력 : BookInsert에서 사용
	 */
	

	public int insert(j_BookVo vo) {
		int r = 0;
		try {
			sql = "insert into books values(? ,?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, vo.bCode);
			ps.setString(2, vo.bName);
			ps.setString(3, vo.publisher);
			ps.setString(4, vo.writer);
			ps.setString(5, vo.status);
			ps.setInt(6, vo.bDate);
			ps.setInt(7, vo.price);
			ps.setInt(8, vo.pages);
			ps.setInt(9, vo.bGroup);
			ps.setString(10, sdf.format(new Date()));
			conn.setAutoCommit(false);

			r = ps.executeUpdate();

			if (r > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}

			ps.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			return r;

		}

	}

	/*
	 * 작성 : 주현 j_BookManagement, jh_HopeBookList table 생성자에서 사용 flag가 0이면 도서검색 화면에서
	 * 전체 데이터 테이블에 띄우고, 1이면 희망도서신청 리스트 조회 2는 분류코드 조회
	 */

	public DefaultTableModel TableSetting(JTable table, int flag) {

		DefaultTableModel model = new DefaultTableModel();

		switch (flag) {
		case 0:
			sql = "select book_code, book_name, publisher, writer,"
					+ " book_date, price, page, group_code, to_char(enroll_date, 'rrrr-mm-dd'), s.IsAvailable"
					+ " from books b join status_table s"
					+ " on b.book_status = s.book_status";
			
			model.addColumn("청구기호");
			model.addColumn("서명");
			model.addColumn("출판사");
			model.addColumn("저자");
			model.addColumn("출판년도");
			model.addColumn("가격");
			model.addColumn("페이지수");
			model.addColumn("분류기호");
			model.addColumn("등록일자");
			model.addColumn("대출가능여부");
			break;

		case 1:
			sql = "select * from hope_book";
			model.addColumn("번호");
			model.addColumn("신청자 ID");
			model.addColumn("저자");
			model.addColumn("서명");
			model.addColumn("출판사");
			model.addColumn("신청일자");
			break;

		default:
			sql = "select * from book_group";
			model.addColumn("분류코드");
			model.addColumn("분류");

			break;
		}

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSetMetaData meta = ps.getMetaData();

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Vector row = new Vector();
				int cnt = meta.getColumnCount();
				for (int i = 1; i <= cnt; i++) {
					row.add(rs.getString(i));
				}
				model.addRow(row);
				
			}

			table.setModel(model);
			table.setRowHeight(25);
			table.setRowSorter(new TableRowSorter(model)); // 정렬 ㅅㅂ
			
			rs.close();
			ps.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			return model;
		}
	}

	/*
	 * 작성 : 주현 관리자 화면에서 도서관리 (검색)
	 */

	public DefaultTableModel bookSearch(String find) {

		sql = "select * from books"
				+ " where book_name like ? or publisher like ? or writer like ? or Book_code like ?";

		DefaultTableModel model = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSetMetaData meta = ps.getMetaData();
			model = new DefaultTableModel();

			model.addColumn("청구기호");
			model.addColumn("서명");
			model.addColumn("출판사");
			model.addColumn("저자");
			model.addColumn("대출가능여부");
			model.addColumn("출판년도");
			model.addColumn("가격");
			model.addColumn("페이지수");
			model.addColumn("분류기호");
			model.addColumn("등록일자");

			ps.setString(1, "%" + find + "%");
			ps.setString(2, "%" + find + "%");
			ps.setString(3, "%" + find + "%");
			ps.setString(4, "%" + find + "%");

			ResultSet rs = ps.executeQuery();

			int cnt = meta.getColumnCount();
			while (rs.next()) {
				Vector row = new Vector<>();
				for (int i = 1; i <= cnt; i++) {
					row.add(rs.getString(i));
				}
				model.addRow(row);
			}
			
			rs.close();
			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	/*
	 * 작성 : 주현 관리자 화면에서 도서관리 (검색, 수정, 삭제) j_BookDetail 수정 버튼에서 사용
	 */

	public int bookModify(j_BookVo vo) {
		int r = 0;

		try {
			sql = "update books set book_name = ?, writer = ?, publisher = ?, "
					+ "book_date = ?, price = ?, group_code = ?, page = ? where book_code = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getbName());
			ps.setString(2, vo.getWriter());
			ps.setString(3, vo.getPublisher());
			ps.setInt(4, vo.getbDate());
			ps.setInt(5, vo.getPrice());
			ps.setInt(6, vo.getbGroup());
			ps.setInt(7, vo.getPages());
			ps.setString(8, vo.getbCode());

			conn.setAutoCommit(false);
			r = ps.executeUpdate();
			if (r > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}

			ps.close();

		} catch (Exception ex) {

		} finally {
			return r;

		}

	}

	/*
	 * 작성 : 주현 관리자 화면에서 도서관리 (삭제) j_BookDetail 삭제 버튼에서 사용
	 */

	public int bookDelete(String mId) {
		int r = 0;

		try {
			sql = "delete from books where book_code = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, mId);

			conn.setAutoCommit(false);
			r = ps.executeUpdate();
			if (r > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}

			ps.close();

		} catch (Exception ex) {

		} finally {
			return r;

		}

	}


	public int CategoryInsert(j_GroupVo vo) {
		int r = 0;

		try {
			sql = "insert into book_group (group_code, group_name) values(?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, vo.getgCode());
			ps.setString(2, vo.getgName());

			r = ps.executeUpdate();
			conn.setAutoCommit(false);

			if (r > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}

		} catch (Exception ex) {

		}

		return r;
	}

	/*
	 * 작성 : 주현 예약한 사람 count BookDetail 생성자에서 사용
	 */

	public String getReserveCnt(String bCode) {
		String r = "";
		try {
			sql = "select count(book_code) from RESERVE_BOOK where book_code = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bCode);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				r = rs.getInt("count(book_code)") + "";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return r;
	}

////////////민호 추가////////////////////
	// Reserve_book 테이블에 데이터 넣기
	public int rentRequest(String bCode, String keyId) {
		int r = 0;
		String sql = "insert into reserve_book values(seq_reserve.nextval, ?, ?,sysdate)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bCode);
			
			ps.setString(2, keyId);

			conn.setAutoCommit(false);
			r = ps.executeUpdate();
			if (r > 0)
				conn.commit();
			else
				conn.rollback();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return r;
		}

	}

	/*
	 * 작성 : 민호
	 */
	public DefaultTableModel rentBookSearch(String keyId) {
		DefaultTableModel model = null;
		String sql = "select  b.BOOK_NAME, b.WRITER, b.PUBLISHER, b.BOOK_CODE, r.until_date "
				+ " from books b join RENT_MEMBER r " + " on b.BOOK_CODE = r.RENT_CODE " + " where r.MEMBER_ID=? ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSetMetaData meta = ps.getMetaData();
			model = new DefaultTableModel();
			int cnt = meta.getColumnCount();
			
			ps.setString(1, keyId);
			
			model.addColumn("책 이름");
			model.addColumn("저자");
			model.addColumn("출판사");
			model.addColumn("책 코드");
			model.addColumn("반납일");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Vector row = new Vector<>();
				for (int i = 1; i <= cnt; i++) {
					row.add(rs.getString(i));
				}
				model.addRow(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	/*
	 * 작성 : 민호
	 */
	public int addDate(String bCode, String keyId) {
		int r = 0;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		sql = "select until_date, rent_date+20 from rent_member where Rent_code = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bCode);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getString(1).compareTo(rs.getString(2)) > 0) {
					return r = 0;
				} else {
					r = 1;
				}
			}
			String sql = " update rent_member set until_date = until_date+7 where Rent_code = ?";

			ps = conn.prepareStatement(sql);
			ps.setString(1, bCode); // 차후 업데이트
			conn.setAutoCommit(false);
			r = ps.executeUpdate();
			if (r > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;

	}

	/*
	 * 작성 : 민호
	 */
	public int hopeBookInsert(m_HopeBookVo vo, String keyId) {
		int r = 0;
		// member_id 차후 업데이트
		String sql = "insert into Hope_book values(seq_hope_book.nextval,?,?,?,?,sysdate)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, keyId);
			ps.setString(2, vo.getbWriter());
			ps.setString(3, vo.getPubl());
			ps.setString(4, vo.getbName());

			conn.setAutoCommit(false);
			r = ps.executeUpdate();
			if (r > 0)
				conn.commit();
			else
				conn.rollback();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}

	/*
	 * 작성 : 민호
	 * 사용자가 도서검색에서 검색 버튼 누르면 검색어로 테이블 띄우기 콤보박스에서 선택된 인덱스로 검색
	 */
	public DefaultTableModel rent(int selectIndex, String rent) {
		DefaultTableModel model = null;
		PreparedStatement ps = null;
		ResultSetMetaData meta = null;
		String sql = null;
		
		if (selectIndex == 0) {
			sql = "select Book_Code, book_name, publisher, writer, booK_status "
					+ " from books where book_name like ?";
			try {
				ps = conn.prepareStatement(sql);
				meta = ps.getMetaData();
				model = new DefaultTableModel();
				int cnt = meta.getColumnCount();

				model.addColumn("책 코드");
				model.addColumn("책 이름");
				model.addColumn("출판사");
				model.addColumn("저자");
				model.addColumn("상태");

				ps.setString(1, "%" + rent + "%");
				

				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Vector row = new Vector<>();
					for (int i = 1; i <= cnt - 1; i++) {
						row.add(rs.getString(i));
					}
					if (Integer.parseInt(rs.getString(5)) == 1) {  // 1이면 이미 빌린거
						row.add("예약 가능");
					} else if(Integer.parseInt(rs.getString(5)) == 0){
						row.add("예약 불가능");
					}else if(Integer.parseInt(rs.getString(5)) == 2){
						row.add("예약중");
					}
					model.addRow(row);
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return model;
		} else if (selectIndex == 1) {
			sql = "select Book_Code, book_name, publisher, writer, booK_status "
					+ " from books where writer like ?";
			try {
				ps = conn.prepareStatement(sql);
				meta = ps.getMetaData();
				model = new DefaultTableModel();
				int cnt = meta.getColumnCount();

				model.addColumn("책 코드");
				model.addColumn("책 이름");
				model.addColumn("출판사");
				model.addColumn("저자");
				model.addColumn("상태");

				ps.setString(1, "%" + rent + "%");
				

				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Vector row = new Vector<>();
					for (int i = 1; i <= cnt - 1; i++) {
						row.add(rs.getString(i));
					}
					if (Integer.parseInt(rs.getString(5)) == 1) {  // 1이면 이미 빌린거
						row.add("예약 가능");
					} else if(Integer.parseInt(rs.getString(5)) == 0){
						row.add("예약 불가능");
					}else if(Integer.parseInt(rs.getString(5)) == 2){
						row.add("예약중");
					}
					model.addRow(row);
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return model;
		} else{
			sql = "select Book_Code, book_name, publisher, writer, booK_status  from books where publisher like ?";
			try {
				ps = conn.prepareStatement(sql);
				meta = ps.getMetaData();
				model = new DefaultTableModel();
				int cnt = meta.getColumnCount();

				model.addColumn("책 코드");
				model.addColumn("책 이름");
				model.addColumn("출판사");
				model.addColumn("저자");
				model.addColumn("상태");

				ps.setString(1, "%" + rent + "%");
				

				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Vector row = new Vector<>();
					for (int i = 1; i <= cnt - 1; i++) {
						row.add(rs.getString(i));
					}
					if (Integer.parseInt(rs.getString(5)) == 1) {  // 1이면 이미 빌린거
						row.add("예약 가능");
					} else if(Integer.parseInt(rs.getString(5)) == 0){
						row.add("예약 불가능");
					}else if(Integer.parseInt(rs.getString(5)) == 2){
						row.add("예약중");
					}
					model.addRow(row);
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return model;
		}
	}

	
	/*
	 * 작성 : 주현
	 * BookDetail 생성자에서
	 * 대출한 사람 아이디, 반납기한 불러오는 메소드
	 * 대출중이 아니라서 정보가 없으면 "정보없음" 출력
	 */
	public String getRentMember(String bCode, char flag) {
		String r = "";
		try {
			sql = "select member_id, to_char(until_date, 'rrrr-mm-dd') from rent_member"
					+ " where rent_code = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bCode);

			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				r = flag == '0' ? rs.getString(1) : rs.getString(2);
			}else {
				r = "정보없음";
			}
			
			rs.close();
			ps.close();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			return r;
		}
	}

	/*
	 * 작성 : 주현
	 * BookManagement에서 관리할 책 검색
	 * 0 : 전체, 1 : 청구기호, 2 : 서명, 3 : 저자, 4 : 출판사
	 */

	public DefaultTableModel bookSearch(String find, int selectedIndex) {
		j_BookManagement bm = new j_BookManagement();
		DefaultTableModel model = new DefaultTableModel();
		PreparedStatement ps = null;
		ResultSetMetaData meta;
		
		try {
			switch (selectedIndex) {
			case 0: //전체
				sql = "select book_code, book_name, publisher, writer, book_date, "
						+ "price, page, group_code, to_char(enroll_date, 'rrrr-mm-dd'), IsAvailable" 
						+ " from books b join status_table s"
						+ " on b.book_status = s.book_status"
						+ " where book_code like ? or book_name like ? or publisher like ?"
						+ " or writer like ? or book_date like ? or price like ? or page like ? or"
						+ " group_code like ? or enroll_date like ? or IsAvailable like ?";

				ps = conn.prepareStatement(sql);

				ps.setString(1, "%" + find + "%");
				ps.setString(2, "%" + find + "%");
				ps.setString(3, "%" + find + "%");
				ps.setString(4, "%" + find + "%");
				ps.setString(5, "%" + find + "%");
				ps.setString(6, "%" + find + "%");
				ps.setString(7, "%" + find + "%");
				ps.setString(8, "%" + find + "%");
				ps.setString(9, "%" + find + "%");
				ps.setString(10, "%" + find + "%");
				
				break;

		case 1: // 청구기호
			
			sql = "select book_code, book_name, publisher, writer, book_date, "
					+ "price, page, group_code, to_char(enroll_date, 'rrrr-mm-dd'), IsAvailable" 
					+ " from books b join status_table s"
					+ " on b.book_status = s.book_status"
					+ " where book_code like ?";

			ps = conn.prepareStatement(sql);

			ps.setString(1, "%" + find + "%");
			
			break;

		case 2: // 서명
			sql = "select book_code, book_name, publisher, writer, book_date, "
					+ "price, page, group_code, to_char(enroll_date, 'rrrr-mm-dd'), IsAvailable" 
					+ " from books b join status_table s"
					+ " on b.book_status = s.book_status"
					+ " where book_name like ?";

			ps = conn.prepareStatement(sql);

			ps.setString(1, "%" + find + "%");
			break;

			
		case 3: // 저자
			
			sql = "select book_code, book_name, publisher, writer, book_date, "
					+ "price, page, group_code, to_char(enroll_date, 'rrrr-mm-dd'), IsAvailable" 
					+ " from books b join status_table s"
					+ " on b.book_status = s.book_status"
					+ " where writer like ?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + find + "%");
			
			break;
			
		case 4: // 출판사
			sql = "select book_code, book_name, publisher, writer, book_date, "
					+ "price, page, group_code, to_char(enroll_date, 'rrrr-mm-dd'), IsAvailable" 
					+ " from books b join status_table s"
					+ " on b.book_status = s.book_status"
					+ " where publisher like ?";

			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + find + "%");
			
			break;
		}
			model.addColumn("청구기호");
			model.addColumn("서명");
			model.addColumn("출판사");
			model.addColumn("저자");
			model.addColumn("출판년도");
			model.addColumn("가격");
			model.addColumn("페이지수");
			model.addColumn("분류기호");
			model.addColumn("등록일자");
			model.addColumn("대출가능여부");
			
			ResultSet rs = ps.executeQuery();
			
			meta = ps.getMetaData();
			int cnt = meta.getColumnCount();

			while (rs.next()) {
				Vector row = new Vector<>();
				for (int i = 1; i <= cnt; i++) {
					row.add(rs.getString(i));
				}
				model.addRow(row);
			}

			rs.close();
			ps.close();

			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	public List<j_GroupVo> getGroupList() {
		
		List<j_GroupVo> list = new ArrayList<j_GroupVo>();
		
		try {
		sql = "select * from book_group";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			list.add(new j_GroupVo(rs.getInt(1), rs.getString(2)));
		}
		
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			return list;
		}
		
	}

	
	/* 작성 : 주현
	 * 북코드를 체크해서 boolean 반환
	 * bookInsert - 중복확인 버튼
	 * false : 중복 X
	 * true : 중복
	 */
	
	public boolean bookCodeCheck(String bCode) {
		
		boolean r = false;
		
		try {
		
		sql = "select book_code from books where book_code = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, bCode);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			r=true; // 이미 북코드가 존재
		}
		
		} catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			return r;
		}
		
	}
	
	
	
	
	public void sendEmail(String toMember)
			throws Exception {
		Properties props = System.getProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.port", SendEmail.PORT); 
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
 
        Session session = Session.getDefaultInstance(props);
 
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(SendEmail.FROM, SendEmail.FROMNAME));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(toMember));
        msg.setSubject(SendEmail.SUBJECT);
        msg.setContent(SendEmail.BODY, "text/html;charset=euc-kr");
        
        Transport transport = session.getTransport();
 
        try {
            System.out.println("전송중 . . .");
            
            transport.connect(SendEmail.HOST, SendEmail.SMTP_USERNAME, SendEmail.SMTP_PASSWORD);
            transport.sendMessage(msg, msg.getAllRecipients());
 
            System.out.println("이메일 전송이 완료되었습니다.");
        } catch (Exception ex) {
            ex.printStackTrace();
 
        } finally {
            transport.close();
        }
	}
	// 비밀번호 이메일로 전송
	public void sendEmail_Pwd(String toMember,String pwd)
			throws Exception {
		Properties props = System.getProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.port", SendEmail.PORT); 
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
 
        Session session = Session.getDefaultInstance(props);
 
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(SendEmail.FROM, SendEmail.FROMNAME));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(toMember));
        msg.setSubject(SendEmail.SUBJECT);
        msg.setContent(SendEmail.BODY_sendPwd(pwd), "text/html;charset=euc-kr");
        
        Transport transport = session.getTransport();
 
        try {
            System.out.println("전송중 . . .");
            
            transport.connect(SendEmail.HOST, SendEmail.SMTP_USERNAME, SendEmail.SMTP_PASSWORD);
            transport.sendMessage(msg, msg.getAllRecipients());
 
            System.out.println("이메일 전송이 완료되었습니다.");
        } catch (Exception ex) {
            ex.printStackTrace();
 
        } finally {
            transport.close();
        }
	}
	
	
	// 민호 (책 예약을 하면 books 상태를 예약중으로 변경)
	public int bookStatusRent(String bCode) {
		int a = 0;
		
		String sql = "update books set book_status = 2 where book_code = ? ";
		try {
			PreparedStatement ps =conn.prepareStatement(sql);
			ps.setString(1, bCode);
			conn.setAutoCommit(false);
			a = ps.executeUpdate();
			if(a>0) {
				conn.commit();
			}else {
				conn.rollback();
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return a;
	}
	
	
	
	
}

	

