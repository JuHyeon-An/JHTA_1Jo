package books;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class h_RentOverdueM extends JPanel {
	private DialogMessage dm;
	private String msg = "";
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnNewButton;

	/**
	 * Create the panel.
	 */
	public h_RentOverdueM() {
		setBackground(new Color(240, 248, 255));
		setPreferredSize(new Dimension(810, 535));
		setLayout(null);
		add(getScrollPane());
		add(getBtnNewButton());
		setVisible(true);
		try {
			h_RentDao dao = new h_RentDao();
			dao.selectOverMember(this);
		}catch(IndexOutOfBoundsException ex) {
			msg = "메세지를 보낼 회원을 선택해 주세요";
			dm = new DialogMessage(msg);
			dm.setLocationRelativeTo(h_RentOverdueM.this);
		}

	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(17, 15, 776, 461);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	public JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 15));
			table.getTableHeader().setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 15));
			table.setBackground(Color.decode("#F7FAFC")); 
			table.getTableHeader().setBackground(Color.decode("#54B5BF")); 
			table.setRowHeight(25);
			
		}
		return table;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uBA54\uC138\uC9C0 \uBCF4\uB0B4\uAE30");
			btnNewButton.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 15));
			btnNewButton.setBackground(new Color(176, 224, 230));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
				
					String email = (String) table.getValueAt(table.getSelectedRow(), 3);
					String mName = (String) table.getValueAt(table.getSelectedRow(),1);
					System.out.println(email);
					// 메시지 전송 누르면 슝~
					j_BookDao dao = new j_BookDao();
					try {
						dao.sendEmail(email);
						msg = mName+"님에게 메일을 전송했습니다.";
						dm = new DialogMessage(msg);
						dm.setLocationRelativeTo(h_RentOverdueM.this);
						//JOptionPane.showMessageDialog(h_RentOverdueM.this,mName+"님에게 메일을 보냈습니다");
						
					} catch (Exception e1) {
					
						e1.printStackTrace();
					}
					
				}
			});
			btnNewButton.setBounds(646, 491, 147, 29);
		}
		return btnNewButton;
	}
}
