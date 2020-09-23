package the.View;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import the.DataTransfer.*;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import the.Model.*;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginForm extends JFrame{
	public static int accessRight;
	private JPasswordField passwordField;
	private ArrayList<NhanVien> listNV = new DatabaseConnection().getListNV();
	private DefaultComboBoxModel<String> md = loadCbLogin(1);
	public LoginForm() {
		getContentPane().setLayout(null);
		
		setTitle("Log In");
		setSize(300, 360);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		ImageIcon icon = new ImageIcon("img/login1.png");
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(210, 85, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon =new ImageIcon(newImg);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(83, 192, 163, 22);
		getContentPane().add(comboBox);
		comboBox.setModel(md);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				md=loadCbLogin(comboBox_1.getSelectedIndex());
				comboBox.setModel(md);
			}
		});
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Quản Trị", "Lễ Tân", "Kinh Doanh", "Buồng Phòng", "Kế Toán"}));
		comboBox_1.setSelectedIndex(1);
		comboBox_1.setBounds(83, 148, 163, 22);
		getContentPane().add(comboBox_1);
		
		
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnThoat.setBounds(29, 287, 89, 23);
		getContentPane().add(btnThoat);
		
		JLabel lblNewLabel = new JLabel("Mật Khẩu");
		lblNewLabel.setBounds(27, 237, 62, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nhân Viên");
		lblNewLabel_1.setBounds(27, 196, 62, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Vị Trí");
		lblNewLabel_2.setBounds(27, 152, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(83, 234, 163, 20);
		getContentPane().add(passwordField);
		
		JLabel iconLB = new JLabel();
		iconLB.setBounds(30, 11, 244, 102);
		getContentPane().add(iconLB);
		iconLB.setIcon(newIcon);
		
		JButton btnDangNhap = new JButton("Đăng Nhập");
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (NhanVien a : listNV) {
					if(comboBox.getSelectedItem().toString().equals(a.getHoTen())&&passwordField.getText().equals(a.getMatKhau())) {
						accessRight=comboBox_1.getSelectedIndex();
						new MainForm(accessRight);
						dispose();
					}
				}
			}
		});
		btnDangNhap.setBounds(146, 287, 100, 23);
		getContentPane().add(btnDangNhap);
		
		setVisible(true);
	}
	
	/*
	 * Load Combobox Nhân viên trong login form
	 */
		
	public DefaultComboBoxModel<String> loadCbLogin(int index){
		DefaultComboBoxModel<String> md = new DefaultComboBoxModel<String>();
		for (NhanVien n : listNV) {
			if(n.getLoai()==index) {
				md.addElement(n.getHoTen());
			}
		}
		return md;
	}
	public static void main(String[] args) {
		new LoginForm();
	}
}
