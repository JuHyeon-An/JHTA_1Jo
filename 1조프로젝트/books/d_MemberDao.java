package books;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;



public class d_MemberDao {
	Connection conn;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public d_MemberDao() {
		conn = DBConn.getConn();
	}
	
	public int idCheck(String id) {
		int r =0;
		
		String sql = " select member_id from member where member_id = ? ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs  = ps.executeQuery();			
			if(rs.next()==true) {
				r=0;
			}else {
				r=1;
			}
			rs.close();
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return r;
	}
	
	public int cJoin(d_MemberVo vo) {
		int r = 0;
		
		try {
			String sql = "insert into member values(?, ?, ?, ?, ?, ?, sysdate, 1,0)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getmId());
			ps.setString(2, vo.getmPwd());
			ps.setString(3, vo.getmName());
			ps.setString(4, vo.getmBirth() );
			ps.setString(5, vo.getmPhone() );			
			ps.setString(6, vo.getmEmail() );			
			
			conn.setAutoCommit(false);
			r = ps.executeUpdate();			
			if(r>0) conn.commit();
			else    conn.rollback();		
			
			ps.close();
			conn.close();
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			return r;
		}
	}
	
	public boolean emailCheck(String email) {
		String sql = "select email from member where email = ? ";
		try {
			PreparedStatement ps =conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs =ps.executeQuery();
			while(rs.next()==true) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean phoneCheck(String phone) {
		String sql = "select phone from member where phone = ? ";
		try {
			PreparedStatement ps =conn.prepareStatement(sql);
			ps.setString(1, phone);
			ResultSet rs =ps.executeQuery();
			while(rs.next()==true) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
