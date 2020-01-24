package books;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class m_UserDao {
	Connection conn = DBConn.getConn();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public int update(m_UserInfoVo vo) {
		int r = 0;
		try {
			String sql = "update member set Member_pwd=? , email = ?, phone = ? where Member_id =? ";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, vo.getmPwd());
			ps.setString(2, vo.getmEmail());
			ps.setString(3, vo.getmPhone());
			ps.setString(4, vo.getmId());

			conn.setAutoCommit(false);
			r = ps.executeUpdate();

			if (r > 0)
				conn.commit();
			else
				conn.rollback();

			ps.close();
			conn.close();
		} catch (Exception e) {
		} finally {
			return r;
		}
	}

	public m_UserInfoVo search(String keyId) {

		m_UserInfoVo vo = new m_UserInfoVo();
		String sql = "Select member_name, birth, member_pwd, "
				+ " email, phone, Member_id from member where member_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, keyId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				vo.setmName(rs.getString(1));
				vo.setmBirth(sdf.format(rs.getDate(2)));
				vo.setmPwd(rs.getString(3));
				vo.setmEmail(rs.getString(4));
				vo.setmPhone(rs.getString(5));
				vo.setmId(rs.getString(6));
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

	public int delect(String keyId) {
		int r = 0;

		String sql = "delete from Rent_member where Member_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, keyId);
			r = ps.executeUpdate();

			sql = "delete from reserve_book where member_id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, keyId);
			r = ps.executeUpdate();

			sql = "delete from hope_book where member_id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, keyId);
			r = ps.executeUpdate();

			sql = "delete from member where member_id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, keyId);
			conn.setAutoCommit(false);
			r = ps.executeUpdate();
			if (r > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return r;
		}
	}
}
