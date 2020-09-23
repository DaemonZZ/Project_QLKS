package the.View;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import the.DataTransfer.*;
import the.Model.*;

import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class EditNVDialog extends JDialog{
	private JTextField txtID;
	private JTextField txtDienThoai;
	private JTextField txtHoTen;
	private JTextField txtTaiKhoan;
	private JPasswordField passwordField;
	JComboBox cbLoai;
	private int id;
	public EditNVDialog(int index) {
		id=index;
		getContentPane().setLayout(null);
		setTitle("Sửa");
		setSize(431, 284);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(10, 77, 46, 14);
		getContentPane().add(lblNewLabel);
		
		txtID = new JTextField();
		txtID.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		txtID.setForeground(Color.RED);
		txtID.setEnabled(false);
		txtID.setBounds(88, 71, 32, 20);
		getContentPane().add(txtID);
		txtID.setColumns(10);
		
		JLabel lblinThoi = new JLabel("Điện thoại");
		lblinThoi.setBounds(10, 119, 68, 14);
		getContentPane().add(lblinThoi);
		
		txtDienThoai = new JTextField();
		txtDienThoai.setColumns(10);
		txtDienThoai.setBounds(88, 113, 102, 20);
		getContentPane().add(txtDienThoai);
		
		JLabel lblMtKhu = new JLabel("Mật khẩu");
		lblMtKhu.setBounds(10, 161, 68, 14);
		getContentPane().add(lblMtKhu);
		
		JLabel lblHTn = new JLabel("Họ tên");
		lblHTn.setBounds(219, 80, 46, 14);
		getContentPane().add(lblHTn);
		
		txtHoTen = new JTextField();
		txtHoTen.setColumns(10);
		txtHoTen.setBounds(286, 77, 103, 20);
		getContentPane().add(txtHoTen);
		
		JLabel lblTiKhon = new JLabel("Tài Khoản");
		lblTiKhon.setBounds(219, 116, 57, 14);
		getContentPane().add(lblTiKhon);
		
		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setColumns(10);
		txtTaiKhoan.setBounds(286, 113, 103, 20);
		getContentPane().add(txtTaiKhoan);
		
		JLabel lblLoi = new JLabel("Loại");
		lblLoi.setBounds(219, 158, 46, 14);
		getContentPane().add(lblLoi);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(88, 155, 102, 20);
		getContentPane().add(passwordField);
		
		 cbLoai = new JComboBox();
		 cbLoai.setModel(new DefaultComboBoxModel(new String[] {"0.Quản Trị", "1.Lễ Tân", "2.Kinh Doanh", "3.Buồng Phòng", "4.Kế Toán"}));
		cbLoai.setBounds(286, 157, 103, 22);
		getContentPane().add(cbLoai);
		
		JButton btnClose = new JButton("Cancel");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StaffManagementForm.s.setEnabled(true);
				dispose();
			}
		});
		btnClose.setBounds(88, 205, 89, 23);
		getContentPane().add(btnClose);
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean b=false;
				NhanVien n = new NhanVien();
				
				if(txtHoTen.getText().equals("")) {
					JOptionPane.showMessageDialog(rootPane, "Tên không được để trống");
				} else if(passwordField.getText().equals("")) {
					JOptionPane.showMessageDialog(rootPane, "Mật khẩu không được để trống");
				} else {
					n.setiD(Integer.parseInt(txtID.getText()));
					n.setHoTen(txtHoTen.getText());
					n.setSoDT(txtDienThoai.getText());
					n.setTaiKhoan(txtTaiKhoan.getText());
					n.setMatKhau(passwordField.getText());
					n.setLoai(cbLoai.getSelectedIndex());
					
					try {
						b= new DatabaseConnection().suaNV(n);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						
					if(b) {
						JOptionPane.showMessageDialog(rootPane, "Sửa thành công");
						StaffManagementForm.s.setEnabled(true);
						StaffManagementForm.s.reload();
						dispose();
					} else {
						JOptionPane.showMessageDialog(rootPane, "Sửa thất bại");
					}
				}
			}
		});
		btnOK.setBounds(252, 205, 89, 23);
		getContentPane().add(btnOK);
		
		JLabel lblNewLabel_1 = new JLabel("Thông Tin Nhân Viên");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_1.setBounds(66, 11, 295, 42);
		getContentPane().add(lblNewLabel_1);
		loadInfo();
		
		setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				StaffManagementForm.s.setEnabled(true);
				dispose();
			}
			
		});
	}
	
	public void loadInfo() {
		ArrayList<NhanVien> list = new DatabaseConnection().getListNV();
		NhanVien A = new NhanVien();
		for (NhanVien nv : list) {
			if(nv.getiD()==id) {
				A=nv;
			}
		}
		txtID.setText(A.getiD()+"");
		txtHoTen.setText(A.getHoTen());
		txtDienThoai.setText(A.getSoDT());
		txtTaiKhoan.setText(A.getTaiKhoan());
		passwordField.setText(A.getMatKhau());
		cbLoai.setSelectedIndex(A.getLoai());
	}
}
