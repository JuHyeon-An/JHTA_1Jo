package books;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogMessage extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel msg;
	String iconPath = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogMessage dialog = new DialogMessage();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public DialogMessage(String msg) {
		this();
		this.msg.setText(msg);
		setVisible(true);
		{
			JLabel icon = new JLabel("");
			icon.setIcon(new ImageIcon(DialogMessage.class.getResource(iconPath)));
			icon.setBounds(24, 15, 62, 47);
			contentPanel.add(icon);
		}
	}
	
	public DialogMessage() {
		setTitle("message");
		setBounds(100, 100, 394, 161);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(245, 255, 250));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getMsg());
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(DialogMessage.class.getResource("/iconBox/read (1).png")));
			lblNewLabel.setBounds(14, 0, 67, 74);
			contentPanel.add(lblNewLabel);
		}
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(245, 255, 250));
			buttonPane.setPreferredSize(new Dimension(10, 45));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(null);
			{
				JButton okButton = new JButton("\uD655\uC778");
				okButton.setBorder(null);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				okButton.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 15));
				okButton.setBackground(new Color(173, 216, 230));
				okButton.setBounds(148, 0, 89, 37);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
//				JButton cancelButton = new JButton("Cancel");
//				cancelButton.setBounds(159, 12, 77, 27);
//				cancelButton.setActionCommand("Cancel");
//				buttonPane.add(cancelButton);
				
			}
		}
	}
	public JLabel getMsg() {
		if (msg == null) {
			msg = new JLabel("\uBA54\uC2DC\uC9C0");
			msg.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 15));
			msg.setHorizontalAlignment(SwingConstants.LEFT);
			msg.setBounds(79, 12, 283, 47);
		}
		return msg;
	}
}

