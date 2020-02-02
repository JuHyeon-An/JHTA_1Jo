package books;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class h_RentDao {
	Connection conn;
	h_RentOverdueB rent;
	h_RentOverdueM over;
	h_RentReturn returnBook;
	h_RentRentVo mVo = new h_RentRentVo();
	
	public h_RentDao() {
		conn= DBConn.getConn();
	}
	
	
	public h_RentDao(h_RentOverdueB rent) {
		conn= DBConn.getConn();
		this.rent = rent;
	}
	
	
	public void overdueSelect() {
		// 연체도서 조회 
		String sql = " select r.serial, r.member_id, m.member_name, b.book_name,trunc(sysdate-until_date), m.phone "
				   + " from rent_member r , books b, member m "
				   + " where r.member_id = m.member_id "
				   + " and r.rent_code = b.book_code "
				   + " and trunc(sysdate-until_date)>0 ";
		try{
			PreparedStatement ps =conn.prepareStatement(sql);
			ResultSetMetaData meta = ps.getMetaData();
			DefaultTableModel model = new DefaultTableModel();
			
			int cnt = meta.getColumnCount();
			
			model.addColumn("대출번호");
			model.addColumn("아이디");
			model.addColumn("이름");
			model.addColumn("도서명");
			model.addColumn("연체일수");
			model.addColumn("핸드폰번호");
			
			rent.getTable().setModel(model);
			rent.getTable().setRowSorter(new TableRowSorter(model));
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Vector row = new Vector();
				for(int i=1 ; i <=cnt ; i++) {
					row.add(rs.getString(i));
				}
				model.addRow(row);
			}
			
			rs.close();
			ps.close();
			conn.close();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	public h_RentRentVo selectId(String find) {
		//빌릴 사람 검색 
		String sql = " select member_id ,member_name, member_status, phone "
				    +" from member where member_id =?";
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,find);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
			    mVo.setmId(rs.getString("member_id"));
				mVo.setmName(rs.getString("member_name"));
				mVo.setPhone(rs.getString("phone"));
				mVo.setmState(rs.getString("member_status"));
			}
			
			rs.close();
			ps.close();
		
			
		}catch(Exception ex) {
			ex.printStackTrace();
	
		}
		return mVo;
	}
	public h_RentRentVo selectBook(String find) {
		//빌릴 책 검색
	
		String sql = " select book_name, publisher, group_code, writer, book_status, book_code "
				    +" from books where book_code=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, find);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				mVo.setBookName(rs.getString("book_name"));
				mVo.setPublisher(rs.getString("publisher"));
				mVo.setGenre(Integer.parseInt(rs.getString("group_code")));
				mVo.setWriter(rs.getString("writer"));
				mVo.setbState(rs.getString("book_status"));
				mVo.setBookCode(rs.getString("book_code"));
			}
			
			rs.close();
			ps.close();
			
			
		
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return mVo;
	}
	
	public int bookCount(String find) {
		//빌린 책 수 카운트 
		int r =0;
		String sql = "select count(member_id) countBook from rent_member where member_id=? ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,find);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
			r=Integer.parseInt(rs.getString("countbook"));
			}
			
			rs.close();
			ps.close();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
		
			return r;
		}
		
		
				
	}
	
	public int rent(String find,String bookstate) {
		//책빌리면 rent_member 데이터 생성 
		int r=0;
		int k=0;
		int b=0;
		String sql = " insert into rent_member values "
				+ 	 " (seq_rent.nextval,?,?,sysdate,sysdate+14) ";
		try {	
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, find);
			ps.setString(2, bookstate);
			
			conn.setAutoCommit(false);
			
			k=memberStatus(find);
			b=bookState(bookstate);
			if(k==1 && b==1) {			
				r = ps.executeUpdate();
			}
			if(r>0) {
				conn.commit();
			
			}else {
				conn.rollback();
			}
			
			
						
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
		return r;
	}
	
	public int memberStatus(String find) {
		//검색된 사람의 대출 상태 조회
		int r=0;
		String sql = " select member_status from member where member_id=? ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, find);
			
			ResultSet rs = ps.executeQuery();
		
			if(rs.next()) {
				r  =Integer.parseInt(rs.getString("member_status")); 
			}
			
			 
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return r;
	}
	
	public void mStatus(String find) {
		//빌린 사람의 대출상태0으로 
		int r=0;
		String sql = " update member set member_status=? where member_id=?";
	    try {  
			PreparedStatement ps2 = conn.prepareStatement(sql);
			ps2.setString(1,"0");
			ps2.setString(2,find);
		
		
			conn.setAutoCommit(false);
			r = ps2.executeUpdate();
			if(r>0) {
				conn.commit();
				System.out.println("123");
			}else {
				conn.rollback();
				
			}
			
			ps2.close();
		
			
	   }catch(Exception ex) {
		   ex.printStackTrace();
	   }
	}
	

	public void bStatus(String find) {
		//대출시 책의 대출상태 0로 
		int r=0;
		
	    try {  
			String sql = " update books set book_status=? where book_code=?";
		    
			PreparedStatement ps3 = conn.prepareStatement(sql);
			ps3.setString(1,"0");
			ps3.setString(2,find);
			
			conn.setAutoCommit(false);
	 		r = ps3.executeUpdate();
			if(r>0) {
				conn.commit();
			}else {
				conn.rollback();
			}
			ps3.close();
				
	   }catch(Exception ex) {
		   ex.printStackTrace();
	   }
	}
	
	public void selectRent(String find,h_RentReturn returnBook) {
		//빌린 책 정보 조회
		this.returnBook = returnBook;
		int r=0;
		try { // rent_date+14 나중에 until_date로 바꿔야함 
			String sql = " select r.serial,b.book_Name, r.rent_code, b.writer, b.publisher, greatest(trunc(sysdate-(until_date)),0) "
					    +" from rent_member r, books b "
					    +" where b.book_code = r.rent_code and r.member_id =?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, find);
			ResultSetMetaData meta = ps.getMetaData();
			DefaultTableModel model = new DefaultTableModel();
			
			int cnt  = meta.getColumnCount();
			model.addColumn("대여번호");
			model.addColumn("도서명");
			model.addColumn("도서코드");
			model.addColumn("저자");
			model.addColumn("출판사");
			model.addColumn("연체일수");
			
			returnBook.getTable().setModel(model);
			returnBook.getTable().setRowSorter(new TableRowSorter(model));
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Vector row = new Vector();
				for(int i=1; i<=cnt; i++) {
					row.add(rs.getString(i));
				}
				model.addRow(row);
				
				
			}
			
			ps.close();
			rs.close();
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public int deleteRent(String find) {
		//반납시 rent_member 데이터 삭제
		String sql = " delete from rent_member where serial=?";
		int r=0;
		int k=0;
	    try{
	    	PreparedStatement ps = conn.prepareStatement(sql);
	    	ps.setString(1, find);
	    	
	    	conn.setAutoCommit(false);
	    	k=bookState(find);
	    	if(k==0 || k==2) {
	    		r = ps.executeUpdate();
	    	}
	    	
	    	if(r>0) {
	    		conn.commit();
	    	}else if(r==0){
	    		conn.rollback();
	    	}
	    	
	    	ps.close();
	    	
	    	
	    }catch(Exception ex) {
	    	ex.printStackTrace();
	    }finally {
	    	return r;
	    }
	}
	public void bStatusBack(String find) {
		//반납시 책의 대출상태 1로 
		int r=0;
		
	    try {  
			String sql = " update books set book_status=? where book_code=?";
		    
			PreparedStatement ps3 = conn.prepareStatement(sql);
			ps3.setString(1,"1");
			ps3.setString(2,find);
			
			conn.setAutoCommit(false);
	 		r = ps3.executeUpdate();
			if(r>0) {
				conn.commit();
			}else {
				conn.rollback();
			}
			ps3.close();
		
			
	   }catch(Exception ex) {
		   ex.printStackTrace();
	   }
	}
	public void mStatusBack(String find) {
		//반납시 빌린사람의 대출상태 1로 
		int r=0;
		String sql = " update member set member_status=? where member_id=?";
	    try {  
			PreparedStatement ps2 = conn.prepareStatement(sql);
			ps2.setString(1,"1");
			ps2.setString(2,find);
		
			conn.setAutoCommit(false);
			r = ps2.executeUpdate();
			if(r>0) {
				conn.commit();
				
			}else {
				conn.rollback();
				
			}
			
			ps2.close();
		
			
	   }catch(Exception ex) {
		   ex.printStackTrace();
	   }
	}
	
	public int bookCountAtReturn(String find) {
		//반납하는 사람의 빌린 책 수 카운트 
		int r =0;
		int k =0;
		String sql = "select count(member_id) countBook from rent_member where member_id=? ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,find);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				k =Integer.parseInt(rs.getString("countbook")); 
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			return k;
		}	
				
	}
	
	public int overdueMember(String find) {
		//검색된 회원의 연체책수 카운트 
		int cnt=0;
		String sql = " select count(member_Id) overdue from rent_member "
				   + " where greatest(trunc(sysdate-until_date),0)>0 and member_Id=?";
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, find);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt("overdue");
			};
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return cnt;
	}
	
	public void selectOverMember(h_RentOverdueM overdue) {
		//연체회원 조회 
		this.over=overdue;
		String sql = " select member_Id,member_name,phone,email,overdue_book "
				    + " from member where overdue_book>0 " ;
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSetMetaData meta = ps.getMetaData();
			DefaultTableModel model = new DefaultTableModel();
			
			int cnt = meta.getColumnCount();
			 model.addColumn("아이디");
			 model.addColumn("이름");
			 model.addColumn("전화번호");
			 model.addColumn("이메일");
			 model.addColumn("연체중인 책 수");
			 
			 overdue.getTable().setModel(model);
			 overdue.getTable().setRowSorter(new TableRowSorter(model));
			 
			 ResultSet rs = ps.executeQuery();
			 while(rs.next()) {
				 Vector row = new Vector();
				 for(int i=1; i<=cnt; i++) {
					 row.add(rs.getString(i));
				 }
				 model.addRow(row);
			 }
			 
			 rs.close();
			 ps.close();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	public int updateOverdueBook(String find) {
		//연체된 책 수 업데이트
		int r=0;
		String sql =" update member set overdue_book =(select count(member_id) "
				  + " from rent_member where greatest(trunc(sysdate-until_Date),0)>0 and member_id=?) "
				  + " where member_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,find);
			ps.setString(2,find);
			
			conn.setAutoCommit(false);
		    r = ps.executeUpdate();
		    if(r>0) {
		    	conn.commit();
		    }else {
		    	conn.rollback();
		    }
			
		    ps.close();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			return r;
		}
		
	}
	
	public int idCheck(String find) {
		//아이디 있는지없는지 확인
		int r=0;
		String sql = " select member_id from member where member_id = ? ";
		try{
			PreparedStatement ps =  conn.prepareStatement(sql);
			ps.setString(1, find);
			ResultSet rs = ps.executeQuery();
			if(rs.next()==true) {
				r=1;
			}else {
				r=0;
			}
			rs.close();
			ps.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return r;
	}
	
	public int bookCheck(String find) {
		//책 있는지 없는지 확인
		int r=0;
		String sql = " select book_code from books where book_code=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, find);
			ResultSet rs = ps.executeQuery();
			if(rs.next()==true) {
				r=1;
			}else {
				r=0;
			}
			rs.close();
			ps.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return r;
	}
	
	public int bookState(String find) {
		//검색된 책의 상태 확인
		int r=0;
		String sql = " select book_status from books where book_code = ? ";
	    try {
	    	PreparedStatement ps = conn.prepareStatement(sql);
	    	ps.setString(1,find);
	    	ResultSet rs  = ps.executeQuery();
	    	if(rs.next()==true) {
	    		r = Integer.parseInt(rs.getString("book_status"));  	
	    	}
	    	
	    	ps.close();
	    	rs.close();
	    }catch(Exception ex) {
	    	ex.printStackTrace();
	    }
	    return r;	
	}
	
	public String getReserve(String bCode) {
		//예약한 책의 예약한 사람id 찾기 
		String r = "";
		try {
			String sql = "select member_id from RESERVE_BOOK where book_code = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bCode);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				r = rs.getString("member_id");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return r;
	}
	public String getReservebook(String bCode) {
		//예약한 사람의 예약한 책 찾기
		String r = "";
		try {
			String sql = "select book_code from RESERVE_BOOK where member_id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bCode);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				r = rs.getString("book_code");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return r;
	}
	
	public int getReserveIs(String id) {
		//검색된사람이 예약된 책이 있는지 없는지 
		int r=0;
		try {
			String sql = "select member_id from reserve_book where member_Id=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()==true) {
				r = 1;
			}else {
				r = 0;
			}
			rs.close();
			ps.close();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return r;
	}
	public String[] getUpToDateBook() {
		String[] book = new String[300];
		String sql= "select book_name from books where enroll_date > sysdate-7";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			int i=0;
			while(rs.next()) {
				book[i] = rs.getString("book_name");
				i++;
			}
			
			rs.close();
			ps.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return book;
		
	
	}
	
	public int deleteReserve(String id,String book) {
		String sql = " delete from reserve_book where member_id =?";
		int r=0;
		int k=0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,id);
			
			conn.setAutoCommit(false);
			k=bookState(book);
			if(k==2) {
				r= ps.executeUpdate();
			}
			if(r>0) {
				conn.commit();
			}else if(r==0) {
				conn.rollback();
			}
			
			ps.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return r;	
	}
	
	public int rentBookIs(String code) {
		int r=0;
		try {
			String sql = "select rent_code from rent_member where rent_code=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, code);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()==true) {
				r = 1;
			}else {
				r = 0;
			}
			rs.close();
			ps.close();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return r;
		
	}
	

	
	
	
	

}
