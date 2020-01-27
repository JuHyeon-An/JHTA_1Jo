package books;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
		// ��ü���� ��ȸ 
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
			
			model.addColumn("�����ȣ");
			model.addColumn("���̵�");
			model.addColumn("�̸�");
			model.addColumn("������");
			model.addColumn("��ü�ϼ�");
			model.addColumn("�ڵ�����ȣ");
			
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
		//���� ��� �˻� 
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
		//���� å �˻�
	
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
		//���� å �� ī��Ʈ 
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
			System.out.println("å"+r);
			return r;
		}
		
		
				
	}
	
	public int rent(String find) {
		//å������ rent_member ������ ���� 
		int r=0;
		int k=0;
		String sql = " insert into rent_member values "
				+ 	 " (seq_rent.nextval,?,?,sysdate,sysdate+14,greatest(trunc(sysdate-(sysdate+14)),0)) ";
		try {	
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, mVo.getmId());
			ps.setString(2, mVo.getBookCode());
			
			conn.setAutoCommit(false);
			
			k=memberStatus(find);
			if(k==1 && mVo.getbState().equals("1")) {			
				r = ps.executeUpdate();
				mVo.setbState("0"); //??
			
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
		//���� ����� �������0���� 
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
	
	public void bStatus() {
		//���� å�� ������� 0���� 
		int r=0;
		
	    try {  
			String sql = " update books set book_status=? where book_code=?";
		    
			PreparedStatement ps3 = conn.prepareStatement(sql);
			ps3.setString(1,"0");
			ps3.setString(2,mVo.getBookCode());
			
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
		//���� å ���� ��ȸ
		this.returnBook = returnBook;
		int r=0;
		try { // rent_date+14 ���߿� until_date�� �ٲ���� 
			String sql = " select r.serial,b.book_Name, r.rent_code, b.writer, b.publisher, greatest(trunc(sysdate-(until_date)),0) "
					    +" from rent_member r, books b "
					    +" where b.book_code = r.rent_code and r.member_id =?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, find);
			ResultSetMetaData meta = ps.getMetaData();
			DefaultTableModel model = new DefaultTableModel();
			
			int cnt  = meta.getColumnCount();
			model.addColumn("�뿩��ȣ");
			model.addColumn("������");
			model.addColumn("�����ڵ�");
			model.addColumn("����");
			model.addColumn("���ǻ�");
			model.addColumn("��ü�ϼ�");
			
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
		//�ݳ��� rent_member ������ ����
		String sql = " delete from rent_member where serial=?";
		int r=0;
	    try{
	    	PreparedStatement ps = conn.prepareStatement(sql);
	    	ps.setString(1, find);
	    	
	    	conn.setAutoCommit(false);
	    	r = ps.executeUpdate();
	    	
	    	if(r>0) {
	    		conn.commit();
	    	}else{
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
		//�ݳ��� å�� ������� 1�� 
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
		//�ݳ��� ��������� ������� 1�� 
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
		//�ݳ��ϴ� ����� ���� å �� ī��Ʈ 
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
		//�˻��� ȸ���� ��üå�� ī��Ʈ 
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
		//��üȸ�� ��ȸ 
		this.over=overdue;
		String sql = " select member_Id,member_name,phone,email,overdue_book "
				    + " from member where overdue_book>0 " ;
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSetMetaData meta = ps.getMetaData();
			DefaultTableModel model = new DefaultTableModel();
			
			int cnt = meta.getColumnCount();
			 model.addColumn("���̵�");
			 model.addColumn("�̸�");
			 model.addColumn("��ȭ��ȣ");
			 model.addColumn("�̸���");
			 model.addColumn("��ü���� å ��");
			 
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
		//��ü�� å �� ������Ʈ
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
	
	

}
