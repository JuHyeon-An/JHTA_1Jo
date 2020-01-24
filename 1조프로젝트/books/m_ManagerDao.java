package books;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class m_ManagerDao {
	Connection conn=DBConn.getConn();
	
	public int login(m_ManagerVo vo) {
		String sql = "Select manager_pwd from manager where manager_id = ? ";
		int r = 0;
		try {
			PreparedStatement ps =conn.prepareStatement(sql);
			ps.setString(1, vo.getmId());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String pwd =rs.getString(1);
				if(vo.getmPwd().equals(pwd)) {
					r =1;
				} 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}

}
