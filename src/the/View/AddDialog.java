package the.View;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import the.Model.*;
import the.DTO.*;

import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class AddDialog extends JDialog{
	private final JTextField txtID;
	private final JTextField txtDienThoai;
	private final JTextField txtHoTen;
	private final JTextField txtTaiKhoan;
	private final JPasswordField passwordField;
	public AddDialog(int id) {
		getContentPane().setLayout(null);
		setSize(431, 284);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Thêm");
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(10, 77, 46, 14);
		getContentPane().add(lblNewLabel);
		
		txtID = new JTextField();
		txtID.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		txtID.setForeground(Color.RED);
		txtID.setEnabled(false);
		txtID.setBounds(88, 74, 32, 20);
		getContentPane().add(txtID);
		txtID.setColumns(10);
		txtID.setText(id+"");
		
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
		lblHTn.setBounds(146, 77, 46, 14);
		getContentPane().add(lblHTn);
		
		txtHoTen = new JTextField();
		txtHoTen.setColumns(10);
		txtHoTen.setBounds(202, 74, 187, 20);
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
		
		JComboBox cbBoPhan = new JComboBox();
		cbBoPhan.setBounds(286, 157, 103, 22);
		cbBoPhan.setModel(new DefaultComboBoxModel(new String[] {"0.Quản Trị", "1.Lễ Tân", "2.Kinh Doanh", "3.Buồng Phòng", "4.Kế Toán"}));
		cbBoPhan.setSelectedIndex(-1);
		getContentPane().add(cbBoPhan);
		
		JButton btnClose = new JButton("Cancel");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccountManagementForm.s.setEnabled(true);
				dispose();
			}
		});
		btnClose.setBounds(88, 205, 89, 23);
		getContentPane().add(btnClose);
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
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
					n.setLoai(cbBoPhan.getSelectedIndex());

					DataStorage.loader.getListNV().add(n);

					JOptionPane.showMessageDialog(rootPane, "Đăng kí thành công");
					AccountManagementForm.s.setEnabled(true);
					AccountManagementForm.s.reload();
					dispose();

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
		
		setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				AccountManagementForm.s.setEnabled(true);
				dispose();
			}
			
		});
	}
}
