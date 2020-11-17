package the.View.Control;

import the.View.MainForm;
import the.View.ProfileDialog;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class CustomerInfoPanel extends JPanel {
	private  static JTextField txtTenKH;
	private  static JTextField txtCI;
	private  static JTextField txtCO;
	private  static JTextField txtPhong;
	
	public static CustomerInfoPanel t =new CustomerInfoPanel();
	

	public CustomerInfoPanel() {
		
		
		setLayout(null);
		setBackground(Color.WHITE);
		JLabel lblNewLabel_3 = new JLabel("Tên KH");
		lblNewLabel_3.setBounds(24, 11, 46, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Check In");
		lblNewLabel_3_1.setBounds(24, 49, 57, 14);
		add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Check out");
		lblNewLabel_3_2.setBounds(24, 89, 57, 14);
		add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Phòng");
		lblNewLabel_3_3.setBounds(243, 11, 46, 14);
		add(lblNewLabel_3_3);
		
		txtTenKH = new JTextField();
		txtTenKH.setEditable(false);
		txtTenKH.setBackground(Color.WHITE);
		txtTenKH.setBounds(87, 8, 146, 20);
		add(txtTenKH);
		txtTenKH.setColumns(10);
		
		txtCI = new JTextField();
		txtCI.setBackground(Color.WHITE);
		txtCI.setEditable(false);
		txtCI.setColumns(10);
		txtCI.setBounds(87, 46, 146, 20);
		add(txtCI);
		
		txtCO = new JTextField();
		txtCO.setBackground(Color.WHITE);
		txtCO.setEditable(false);
		txtCO.setColumns(10);
		txtCO.setBounds(87, 86, 146, 20);
		add(txtCO);
		
		txtPhong = new JTextField();
		txtPhong.setEditable(false);
		txtPhong.setBackground(Color.WHITE);
		txtPhong.setColumns(10);
		txtPhong.setBounds(301, 8, 57, 20);
		this.add(txtPhong);
		
		JButton btnChinhSua = new JButton("Chỉnh Sửa");
		btnChinhSua.setBounds(253, 45, 101, 76);
		add(btnChinhSua);
		btnChinhSua.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(MainForm.m.getSelectedRoom()!="" && MainForm.m.getQl()!=null) {
					new ProfileDialog(MainForm.m.getSelectedRoom(),ProfileDialog.EDIT);
				}
			}
		});
		setVisible(true);
		
	}
	public JTextField getTxtTenKH() {
		return txtTenKH;
	}
	public void setTxtTenKH(JTextField txtTenKH) {
		CustomerInfoPanel.txtTenKH = txtTenKH;
	}
	public JTextField getTxtCI() {
		return txtCI;
	}
	public void setTxtCI(JTextField txtCI) {
		CustomerInfoPanel.txtCI = txtCI;
	}
	public JTextField getTxtCO() {
		return txtCO;
	}
	public void setTxtCO(JTextField txtCO) {
		CustomerInfoPanel.txtCO = txtCO;
	}
	public JTextField getTxtPhong() {
		return txtPhong;
	}
	public void setTxtPhong(JTextField txtPhong) {
		CustomerInfoPanel.txtPhong = txtPhong;
	}

	
}
