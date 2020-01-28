package books;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {
	String sql;
	Connection conn;
	UserVo vo;

	
	public UserDao() {
		conn = DBConn.getConn();
	}
	
	public int insert(UserVo vo) {
		int r =0;
		String pwd=null;
		try {
			String sql = "select MEMBER_ID, MEMBER_PWD from member where MEMBER_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getTmId());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				pwd = rs.getString(2);
			}
			if(pwd.equals(vo.getTpwd())) {
				r=1;
			}		
			rs.close();
			ps.close();
			
			
		}catch(Exception ex) {
		//	ex.printStackTrace();
		}finally {
			return r;
		}	
	}
	
	
	
	
	
	
}
