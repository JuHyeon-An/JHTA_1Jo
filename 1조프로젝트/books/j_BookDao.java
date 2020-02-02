package books;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
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
	 * �ۼ� : ���� ���� ���� ���� �Է� : BookInsert���� ���
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
	 * �ۼ� : ���� j_BookManagement, jh_HopeBookList table �����ڿ��� ��� flag�� 0�̸� �����˻� ȭ�鿡��
	 * ��ü ������ ���̺� ����, 1�̸� ���������û ����Ʈ ��ȸ 2�� �з��ڵ� ��ȸ
	 */

	public DefaultTableModel TableSetting(JTable table, int flag) {

		DefaultTableModel model = new DefaultTableModel();

		switch (flag) {
		case 0:
			sql = "select book_code, book_name, publisher, writer,"
					+ " book_date, price, page, group_code, to_char(enroll_date, 'rrrr-mm-dd'), s.IsAvailable"
					+ " from books b join status_table s" + " on b.book_status = s.book_status";

			model.addColumn("û����ȣ");
			model.addColumn("����");
			model.addColumn("���ǻ�");
			model.addColumn("����");
			model.addColumn("���ǳ⵵");
			model.addColumn("����");
			model.addColumn("��������");
			model.addColumn("�з���ȣ");
			model.addColumn("�������");
			model.addColumn("���Ⱑ�ɿ���");
			break;

		case 1:
			sql = "select * from hope_book";
			model.addColumn("��ȣ");
			model.addColumn("��û�� ID");
			model.addColumn("����");
			model.addColumn("����");
			model.addColumn("���ǻ�");
			model.addColumn("��û����");
			break;

		default:
			sql = "select * from book_group";
			model.addColumn("�з��ڵ�");
			model.addColumn("�з�");

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
			table.setRowSorter(new TableRowSorter(model)); // ���� ����

			rs.close();
			ps.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			return model;
		}
	}

	/*
	 * �ۼ� : ���� ������ ȭ�鿡�� �������� (�˻�)
	 */

	public DefaultTableModel bookSearch(String find) {

		sql = "select * from books"
				+ " where book_name like ? or publisher like ? or writer like ? or Book_code like ?";

		DefaultTableModel model = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSetMetaData meta = ps.getMetaData();
			model = new DefaultTableModel();

			model.addColumn("û����ȣ");
			model.addColumn("����");
			model.addColumn("���ǻ�");
			model.addColumn("����");
			model.addColumn("���Ⱑ�ɿ���");
			model.addColumn("���ǳ⵵");
			model.addColumn("����");
			model.addColumn("��������");
			model.addColumn("�з���ȣ");
			model.addColumn("�������");

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
	 * �ۼ� : ���� ������ ȭ�鿡�� �������� (�˻�, ����, ����) j_BookDetail ���� ��ư���� ���
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
	 * �ۼ� : ���� ������ ȭ�鿡�� �������� (����) j_BookDetail ���� ��ư���� ���
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
	 * �ۼ� : ���� ������ ��� count BookDetail �����ڿ��� ���
	 */

	public String getReserveId(String bCode) {
		String r = "";
		try {
			sql = "select member_id from RESERVE_BOOK where book_code = ?";

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

	//////////// ��ȣ �߰�////////////////////
	// ���� ��û ���
	public int rentRequest(String bCode, String keyId) {
		int r = 0;
		boolean b1 = rentAble(keyId); // ������ ���̵� ������ �� ��ȯ
		boolean b2 = bookRentAble(bCode); // ������ å�ڵ尡 ������ �� ��ȯ

		if (b1 && b2) {
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
			}
		}
		return r;

	}

	/*
	 * �ۼ� : ��ȣ
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
			model.addColumn("å �̸�");
			model.addColumn("����");
			model.addColumn("���ǻ�");
			model.addColumn("å �ڵ�");
			model.addColumn("�ݳ���");

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
	 * �ۼ� : ��ȣ
	 */
	// �ݳ���¥ ����
	public int addDate(String bCode) { // ������ å�ڵ带 ���޹���
		int r = 0; // ����Ǹ� 1�̻� ��ȯ, ���� �ȵǸ� 0 ��ȯ

		sql = "select until_date, rent_date+20 from rent_member where Rent_code = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bCode);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				// å�� ������ 14���� �ݳ��ؾߵǰ� ������ �ϸ� +7���� �߰��� ������,
				// ������ å�� �ݳ���¥�� ������¥+21(�ִ�)���� ���ؼ� ��
				// // �ݳ���¥�� ������¥+21(�ִ�)�� ��
				if (rs.getString(1).compareTo(rs.getString(2)) > 0) {
					r = 0;
				} else {
					sql = " update rent_member set until_date = until_date+7 where Rent_code = ?";
					ps = conn.prepareStatement(sql);
					ps.setString(1, bCode);
					conn.setAutoCommit(false);
					r = ps.executeUpdate();
					if (r > 0) {
						conn.commit();
					} else {
						conn.rollback();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;

	}

	/*
	 * �ۼ� : ��ȣ
	 */
	public int hopeBookInsert(m_HopeBookVo vo, String keyId) {
		int r = 0;
		// member_id ���� ������Ʈ
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
	 * �ۼ� : ��ȣ ����ڰ� �����˻����� �˻� ��ư ������ �˻���� ���̺� ���� �޺��ڽ����� ���õ� �ε����� �˻�
	 */
	public DefaultTableModel rent(int selectIndex, String rent) {
		DefaultTableModel model = null;
		PreparedStatement ps = null;
		ResultSetMetaData meta = null;
		String sql = null;

		if (selectIndex == 0) {
			sql = "select Book_Code, book_name, publisher, writer, booK_status " + " from books where book_name like ?";
			try {
				ps = conn.prepareStatement(sql);
				meta = ps.getMetaData();
				model = new DefaultTableModel();
				int cnt = meta.getColumnCount();

				model.addColumn("å �ڵ�");
				model.addColumn("å �̸�");
				model.addColumn("���ǻ�");
				model.addColumn("����");
				model.addColumn("����");

				ps.setString(1, "%" + rent + "%");

				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Vector row = new Vector<>();
					for (int i = 1; i <= cnt - 1; i++) {
						row.add(rs.getString(i));
					}
					if (Integer.parseInt(rs.getString(5)) == 1 || Integer.parseInt(rs.getString(5)) == 0) { // 1�̸� �̹�
																											// ������
						row.add("���� ����");
					} else if (Integer.parseInt(rs.getString(5)) == 2) {
						row.add("������");
					}
					model.addRow(row);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			return model;
		} else if (selectIndex == 1) {
			sql = "select Book_Code, book_name, publisher, writer, booK_status " + " from books where writer like ?";
			try {
				ps = conn.prepareStatement(sql);
				meta = ps.getMetaData();
				model = new DefaultTableModel();
				int cnt = meta.getColumnCount();

				model.addColumn("å �ڵ�");
				model.addColumn("å �̸�");
				model.addColumn("���ǻ�");
				model.addColumn("����");
				model.addColumn("����");

				ps.setString(1, "%" + rent + "%");

				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Vector row = new Vector<>();
					for (int i = 1; i <= cnt - 1; i++) {
						row.add(rs.getString(i));
					}
					if (Integer.parseInt(rs.getString(5)) == 1 || Integer.parseInt(rs.getString(5)) == 0) { // 1�̸� �̹�
																											// ������
						row.add("���� ����");
					} else if (Integer.parseInt(rs.getString(5)) == 2) {
						row.add("������");
					}
					model.addRow(row);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return model;
		} else {
			sql = "select Book_Code, book_name, publisher, writer, booK_status  from books where publisher like ?";
			try {
				ps = conn.prepareStatement(sql);
				meta = ps.getMetaData();
				model = new DefaultTableModel();
				int cnt = meta.getColumnCount();

				model.addColumn("å �ڵ�");
				model.addColumn("å �̸�");
				model.addColumn("���ǻ�");
				model.addColumn("����");
				model.addColumn("����");

				ps.setString(1, "%" + rent + "%");

				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Vector row = new Vector<>();
					for (int i = 1; i <= cnt - 1; i++) {
						row.add(rs.getString(i));
					}
					if (Integer.parseInt(rs.getString(5)) == 1 || Integer.parseInt(rs.getString(5)) == 0) { // 1�̸� �̹�
																											// ������
						row.add("���� ����");
					} else if (Integer.parseInt(rs.getString(5)) == 2) {
						row.add("������");
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
	 * �ۼ� : ���� BookDetail �����ڿ��� ������ ��� ���̵�, �ݳ����� �ҷ����� �޼ҵ� �������� �ƴ϶� ������ ������ "��������"
	 * ���
	 */
	public String getRentMember(String bCode, char flag) {
		String r = "";
		try {
			sql = "select member_id, to_char(until_date, 'rrrr-mm-dd') from rent_member" + " where rent_code = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bCode);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				r = flag == '0' ? rs.getString(1) : rs.getString(2);
			} else {
				r = "��������";
			}

			rs.close();
			ps.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			return r;
		}
	}

	/*
	 * �ۼ� : ���� BookManagement���� ������ å �˻� 0 : ��ü, 1 : û����ȣ, 2 : ����, 3 : ����, 4 : ���ǻ�
	 */

	public DefaultTableModel bookSearch(String find, int selectedIndex) {
		j_BookManagement bm = new j_BookManagement();
		DefaultTableModel model = new DefaultTableModel();
		PreparedStatement ps = null;
		ResultSetMetaData meta;

		try {
			switch (selectedIndex) {
			case 0: // ��ü
				sql = "select book_code, book_name, publisher, writer, book_date, "
						+ "price, page, group_code, to_char(enroll_date, 'rrrr-mm-dd'), IsAvailable"
						+ " from books b join status_table s" + " on b.book_status = s.book_status"
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

			case 1: // û����ȣ

				sql = "select book_code, book_name, publisher, writer, book_date, "
						+ "price, page, group_code, to_char(enroll_date, 'rrrr-mm-dd'), IsAvailable"
						+ " from books b join status_table s" + " on b.book_status = s.book_status"
						+ " where book_code like ?";

				ps = conn.prepareStatement(sql);

				ps.setString(1, "%" + find + "%");

				break;

			case 2: // ����
				sql = "select book_code, book_name, publisher, writer, book_date, "
						+ "price, page, group_code, to_char(enroll_date, 'rrrr-mm-dd'), IsAvailable"
						+ " from books b join status_table s" + " on b.book_status = s.book_status"
						+ " where book_name like ?";

				ps = conn.prepareStatement(sql);

				ps.setString(1, "%" + find + "%");
				break;

			case 3: // ����

				sql = "select book_code, book_name, publisher, writer, book_date, "
						+ "price, page, group_code, to_char(enroll_date, 'rrrr-mm-dd'), IsAvailable"
						+ " from books b join status_table s" + " on b.book_status = s.book_status"
						+ " where writer like ?";

				ps = conn.prepareStatement(sql);
				ps.setString(1, "%" + find + "%");

				break;

			case 4: // ���ǻ�
				sql = "select book_code, book_name, publisher, writer, book_date, "
						+ "price, page, group_code, to_char(enroll_date, 'rrrr-mm-dd'), IsAvailable"
						+ " from books b join status_table s" + " on b.book_status = s.book_status"
						+ " where publisher like ?";

				ps = conn.prepareStatement(sql);
				ps.setString(1, "%" + find + "%");

				break;
			}
			model.addColumn("û����ȣ");
			model.addColumn("����");
			model.addColumn("���ǻ�");
			model.addColumn("����");
			model.addColumn("���ǳ⵵");
			model.addColumn("����");
			model.addColumn("��������");
			model.addColumn("�з���ȣ");
			model.addColumn("�������");
			model.addColumn("���Ⱑ�ɿ���");

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

			while (rs.next()) {
				list.add(new j_GroupVo(rs.getInt(1), rs.getString(2)));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			return list;
		}

	}

	/*
	 * �ۼ� : ���� ���ڵ带 üũ�ؼ� boolean ��ȯ bookInsert - �ߺ�Ȯ�� ��ư false : �ߺ� X true : �ߺ�
	 */

	public boolean bookCodeCheck(String bCode) {

		boolean r = false;

		try {

			sql = "select book_code from books where book_code = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bCode);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				r = true; // �̹� ���ڵ尡 ����
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			return r;
		}

	}

	public void sendEmail(String toMember) throws Exception {
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
			System.out.println("������ . . .");

			transport.connect(SendEmail.HOST, SendEmail.SMTP_USERNAME, SendEmail.SMTP_PASSWORD);
			transport.sendMessage(msg, msg.getAllRecipients());

			System.out.println("�̸��� ������ �Ϸ�Ǿ����ϴ�.");
		} catch (Exception ex) {
			ex.printStackTrace();

		} finally {
			transport.close();
		}
	}

	// ��й�ȣ �̸��Ϸ� ����
	public void sendEmail_Pwd(String toMember, String pwd) throws Exception {
		Properties props = System.getProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.port", SendEmail.PORT);
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(props);

		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(SendEmail.FROM, SendEmail.FROMNAME));
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress(toMember));
		msg.setSubject("[JHTA������] ��й�ȣ �ȳ�");
		msg.setContent(SendEmail.BODY_sendPwd(pwd), "text/html;charset=euc-kr");

		Transport transport = session.getTransport();

		try {
			System.out.println("������ . . .");

			transport.connect(SendEmail.HOST, SendEmail.SMTP_USERNAME, SendEmail.SMTP_PASSWORD);
			transport.sendMessage(msg, msg.getAllRecipients());

			System.out.println("�̸��� ������ �Ϸ�Ǿ����ϴ�.");
		} catch (Exception ex) {
			ex.printStackTrace();

		} finally {
			transport.close();
		}
	}

	// ��ȣ (å ������ �ϸ� books ���¸� ���������� ����)
	public int bookStatusRent(String bCode) {
		int r = 0;

		String sql = "update books set book_status = 2 where book_code = ? ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bCode);
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

	public j_noticeVo notice(int no) {
		j_noticeVo vo = new j_noticeVo();
		sql = "select serial_no, title, board_writer, contents, to_char(reg_date, 'rrrr-mm-dd') from notice_board where serial_no = ?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("board_writer"));
				vo.setRegDate(rs.getString(5));
				vo.setContents(rs.getString("contents"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return vo;
		}
	}

	public boolean bookRentAble(String bCode) {
		boolean b = false;
		String sql = "select count(book_code) from RESERVE_BOOK where book_code = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bCode);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) { //book_code�� �����Ͱ� ������
				if(rs.getInt(1)==0) {
					b=true;
				}
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;

	}

	// �ֱ� �԰�� å
	public DefaultTableModel recentBook() {

		DefaultTableModel model = null;
		PreparedStatement ps = null;
		ResultSetMetaData meta = null;
		String sql = null;

		sql = " SELECT book_name, WRITER" + " FROM "
				+ " (   SELECT book_name, WRITER	  FROM books   ORDER BY enroll_date DESC	 )"
				+ " WHERE ROWNUM <= 5";

		try {
			ps = conn.prepareStatement(sql);
			meta = ps.getMetaData();
			model = new DefaultTableModel();
			int cnt = meta.getColumnCount();

			model.addColumn("å �̸�");
			model.addColumn("����");

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

	public boolean rentAble(String keyId) {
		boolean b = false;
		//reserve_book ���̺� member_id ������ ã��
		String sql = "select count(member_id) from reserve_book where member_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, keyId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) { //member_id�� �����Ͱ� ������
				if(rs.getInt(1)==0) {
					b=true;
				}
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	/*
	 * �ۼ� : ��ȣ 
	 */
	//����ڰ� �����˻����� �˻� ��ư ������ �˻���� ���̺� ���� �޺��ڽ����� ���õ� �ε����� �˻�
	public DefaultTableModel rentSearch(int selectIndex, String rent) {
		DefaultTableModel model = null;
		PreparedStatement ps = null;
		ResultSetMetaData meta = null;
		String sql = null;

		if (selectIndex == 0) { // 0 = å �̸�
			sql = "select Book_Code, book_name, publisher, writer, booK_status " + " from books where book_name like ?";

			try {
				ps = conn.prepareStatement(sql);
				meta = ps.getMetaData(); // metadata �޾ƿ���
				int cnt = meta.getColumnCount(); // �÷��� �޾ƿ���
				model = new DefaultTableModel();

				model.addColumn("å �ڵ�");
				model.addColumn("å �̸�");
				model.addColumn("���ǻ�");
				model.addColumn("����");
				model.addColumn("����");

				ps.setString(1, "%" + rent + "%"); // �˻�� sql���� �ְ�
				ResultSet rs = ps.executeQuery(); // ���� ����

				while (rs.next()) {
					Vector row = new Vector<>(); // ���� ����
					for (int i = 1; i <= cnt - 1; i++) { // å�ڵ� ~ ���� ������ ���� ���Ϳ� ����
						row.add(rs.getString(i));
					} // 0�̸� �������ΰ� 1�̸� ���� ���� 2 �������ΰ�
					if (Integer.parseInt(rs.getString(5)) == 2) { //book_State�� 2�̸�(2�� �������� å)
						row.add("������"); // ���Ϳ� "������" �߰�
					} else { // 0(���Ⱑ��),1(������) �̸� ���Ϳ� "���� ����"�߰�
						row.add("���� ����"); 
					}
					model.addRow(row); // ���̺�𵨿� �� �߰�
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return model;
		} else if (selectIndex == 1) {
			sql = "select Book_Code, book_name, publisher, writer, booK_status " + " from books where writer like ?";
			try {
				ps = conn.prepareStatement(sql);
				meta = ps.getMetaData();
				model = new DefaultTableModel();
				int cnt = meta.getColumnCount();

				model.addColumn("å �ڵ�");
				model.addColumn("å �̸�");
				model.addColumn("���ǻ�");
				model.addColumn("����");
				model.addColumn("����");

				ps.setString(1, "%" + rent + "%");

				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Vector row = new Vector<>(); // ���� ����
					for (int i = 1; i <= cnt - 1; i++) { // å�ڵ� ~ ���� ������ ���� ���Ϳ� ����
						row.add(rs.getString(i));
					} // 0�̸� �������ΰ� 1�̸� ���� ���� 2 �������ΰ�
					if (Integer.parseInt(rs.getString(5)) == 2) { //book_State�� 2�̸�(2�� �������� å)
						row.add("������"); // ���Ϳ� "������" �߰�
					} else { // 0(���Ⱑ��),1(������) �̸� ���Ϳ� "���� ����"�߰�
						row.add("���� ����"); 
					}
					model.addRow(row); // ���̺�𵨿� �� �߰�
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return model;
		} else {
			sql = "select Book_Code, book_name, publisher, writer, booK_status  from books where publisher like ?";
			try {
				ps = conn.prepareStatement(sql);
				meta = ps.getMetaData();
				model = new DefaultTableModel();
				int cnt = meta.getColumnCount();

				model.addColumn("å �ڵ�");
				model.addColumn("å �̸�");
				model.addColumn("���ǻ�");
				model.addColumn("����");
				model.addColumn("����");

				ps.setString(1, "%" + rent + "%");

				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Vector row = new Vector<>(); // ���� ����
					for (int i = 1; i <= cnt - 1; i++) { // å�ڵ� ~ ���� ������ ���� ���Ϳ� ����
						row.add(rs.getString(i));
					} // 0�̸� �������ΰ� 1�̸� ���� ���� 2 �������ΰ�
					if (Integer.parseInt(rs.getString(5)) == 2) { //book_State�� 2�̸�(2�� �������� å)
						row.add("������"); // ���Ϳ� "������" �߰�
					} else { // 0(���Ⱑ��),1(������) �̸� ���Ϳ� "���� ����"�߰�
						row.add("���� ����"); 
					}
					model.addRow(row); // ���̺�𵨿� �� �߰�
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return model;
		}
	}
}
