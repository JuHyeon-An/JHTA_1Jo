package books;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class p_MemberDao {
 Connection conn;
 public p_MemberDao() {
	 conn = DBConn.getConn();
 }
 public p_MemberVo search(String find) {
	 System.out.println("1");
	 p_MemberVo vo = new p_MemberVo();
	 String sql = " select * from member " + " where member_id = ? ";
	 try {
	 PreparedStatement ps = conn.prepareStatement(sql);
	 ps.setString(1,find);
	 ResultSet rs = ps.executeQuery();
	 while(rs.next()) {
	 vo.setmId(rs.getString("member_id"));
	 vo.setPwd(rs.getString("member_pwd"));
	 vo.setmName(rs.getString("member_name"));
	 vo.setBirth(rs.getString("birth"));
	 vo.setPhone(rs.getString("phone"));
	 vo.setEmail(rs.getString("email"));
	 vo.setrDate(rs.getString("enroll_date"));
	 vo.setState(rs.getString("member_status"));
	 vo.setOverdue(rs.getString("overdue_book"));
	 System.out.println("2");
	 }
	 rs.close();
	 ps.close();
	 conn.close();
	 
	 }catch(Exception ex){
     ex.printStackTrace();
	 }finally {
	 return vo;
		 
	  }
	 }
 public int update(p_MemberVo vo) {
	 int r = 0;
	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	 try {
		 String sql = "update member set member_pwd = ? , member_name = ? ,birth = ?  , phone = ? , email = ? ,enroll_date = ?, Member_status = ? " 
                 + " where member_Id = ? ";
		 PreparedStatement ps =conn.prepareStatement(sql);
		 System.out.println("업데이트1");
		 ps.setString(1, vo.getPwd());
		 ps.setString(2, vo.getmName());
		 ps.setString(3, vo.getBirth());
		 ps.setString(4, vo.getPhone());
		 ps.setString(5, vo.getEmail());
		 ps.setString(6, vo.getrDate());
		 ps.setString(7, vo.getState());
		 ps.setString(8, vo.getmId());
		 conn.setAutoCommit(false);
		 
		 r = ps.executeUpdate();
		
		 if(r>0) {
			 conn.commit();
		 } else {
			 conn.rollback();
		 }
		 ps.close();
		 conn.close();
	 }catch(Exception ex) {
		 ex.printStackTrace();
	 }finally {
		 return r;
	 }
 }
  	public int delete(String mId) {
  		int r = 0;

  		try {
  		String sql = " delete from rent_member where member_id = ? ";
  	  	PreparedStatement ps = conn.prepareStatement(sql);
  	 	ps.setString(1, mId);
  	  		
  	  	r = ps.executeUpdate();
  	  	
  	  sql = " delete from RESERVE_BOOK where member_id = ? ";
	    ps = conn.prepareStatement(sql);
		ps.setString(1, mId);
  	  	
  	  	r = ps.executeUpdate();
  	  	
  	  sql = " delete from HOPE_BOOK  where member_id = ? ";
	    ps = conn.prepareStatement(sql);
		ps.setString(1, mId);
	  	
	  	r = ps.executeUpdate();
  	  	
  	  	
  			
  		sql = " delete from member where member_id = ? ";
  	    ps = conn.prepareStatement(sql);
  		ps.setString(1, mId);
  		 
  		conn.setAutoCommit(false);
  		
  		r = ps.executeUpdate(); 
  		if(r>0) { 
  		conn.commit();
  		} else {
  		conn.rollback();
  		}
  		 

  		}catch(Exception ex) {
  			ex.printStackTrace();
  		}finally {
  			return r;
  		}
  		 
  	}
	public DefaultTableModel select(String find) {
		//j테이블에 뿌려주는 작업을 처리하는곳
		String sql = " select MEMBER_ID, MEMBER_NAME, PHONE,to_char(ENROLL_DATE,'rrrr-mm-dd'), MEMBER_STATUS" 
	                  + " from member where member_id like ? or member_name like ?  ";
		DefaultTableModel model = null;
		try {
	    PreparedStatement ps = conn.prepareStatement(sql);
	    ResultSetMetaData meta = ps.getMetaData();
	    model = new DefaultTableModel();
	    int cnt = meta.getColumnCount();
	    model.addColumn("아이디");
	    model.addColumn("이름");
	    model.addColumn("번호");
	    model.addColumn("가입일");
	    model.addColumn("대출여부");
	    ps.setString(1, "%" + find + "%");
	    ps.setString(2, "%" + find + "%");
	    
	    ResultSet rs = ps.executeQuery();
	    while(rs.next()) {
	    	Vector row = new Vector<>();
	    	for(int i = 1; i<=(cnt-1); i++) {
	    		row.add(rs.getString(i));
	    	}
	    	if(rs.getString(cnt).equals("1")) {
	    		row.add("대출가능");
	    	}else {
	    		row.add("대출불가능");
	    	}
	    	model.addRow(row);
	    	
	    }
	    
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			return model;
		}
	}
}
