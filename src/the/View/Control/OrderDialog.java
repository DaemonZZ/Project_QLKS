package the.View.Control;

import the.Model.DatabaseConnection;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;

public class OrderDialog extends JDialog {
	
	private JTextField txtPhong;
	private JTextField txtMaKH;
	private JTextField txtMaHD;
	private JTextField txtTenKH;
	private JTextField txtDonVi;
	private JTextField txtCMND;
	private JTextField txtNgayCap;
	private JTextField txtNoiCap;
	private JTextField txtQuocTich;
	int nextKH =new DatabaseConnection().nextKH();
	int nextCT = new DatabaseConnection().nextCT();
	public OrderDialog(String s) {
		getContentPane().setLayout(null);
		
		setTitle("Check in");
		setSize(450,305);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Phòng"); 
		lblNewLabel.setBounds(10, 26, 46, 14);
		getContentPane().add(lblNewLabel);
		
		txtPhong = new JTextField();
		txtPhong.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11)); 
		txtPhong.setBounds(68, 23, 46, 20);
		getContentPane().add(txtPhong);
		txtPhong.setColumns(10);
		txtPhong.setText(s);
		txtPhong.setEditable(false);
		
		JLabel MaKH = new JLabel("Mã KH"); 
		MaKH.setBounds(124, 26, 46, 14);
		getContentPane().add(MaKH);
		
		txtMaKH = new JTextField();
		txtMaKH.setText(nextKH+"");
		txtMaKH.setEditable(false);
		txtMaKH.setBounds(180, 23, 86, 20);
		getContentPane().add(txtMaKH);
		txtMaKH.setColumns(10);

		JLabel mahd = new JLabel("Mã HD");
		mahd.setBounds(276, 26, 46, 14);
		getContentPane().add(mahd);
		
		txtMaHD = new JTextField();
		txtMaHD.setBounds(332, 23, 86, 20);
		getContentPane().add(txtMaHD);
		txtMaHD.setColumns(10);
		txtMaHD.setText(nextCT+"");
		txtMaHD.setEditable(false);
		
		JLabel ten = new JLabel("Tên KH");
		ten.setBounds(10, 65, 46, 14);
		getContentPane().add(ten);
		
		txtTenKH = new JTextField();
		txtTenKH.setBounds(68, 62, 186, 20);
		getContentPane().add(txtTenKH);
		txtTenKH.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Giới Tính");
		lblNewLabel_4.setBounds(276, 65, 66, 14);
		getContentPane().add(lblNewLabel_4);
		
		JComboBox cbGen = new JComboBox();
		cbGen.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
		cbGen.setBounds(342, 61, 54, 22);
		getContentPane().add(cbGen);
		
		JLabel lblNewLabel_5 = new JLabel("Đơn vị/Đc");
		lblNewLabel_5.setBounds(10, 100, 59, 14);
		getContentPane().add(lblNewLabel_5);
		
		txtDonVi = new JTextField();
		txtDonVi.setBounds(68, 97, 158, 20);
		getContentPane().add(txtDonVi);
		txtDonVi.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("CMND/HC");
		lblNewLabel_6.setBounds(10, 138, 59, 14);
		getContentPane().add(lblNewLabel_6);
		
		txtCMND = new JTextField();
		txtCMND.setBounds(68, 135, 102, 20);
		getContentPane().add(txtCMND);
		txtCMND.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Ngày cấp");
		lblNewLabel_7.setBounds(192, 138, 74, 14);
		getContentPane().add(lblNewLabel_7);
		
		txtNgayCap = new JTextField();
		txtNgayCap.setBounds(264, 135, 107, 20);
		getContentPane().add(txtNgayCap);
		txtNgayCap.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Nơi cấp");
		lblNewLabel_8.setBounds(192, 178, 74, 14);
		getContentPane().add(lblNewLabel_8);
		
		txtNoiCap = new JTextField();
		txtNoiCap.setBounds(264, 175, 107, 20);
		getContentPane().add(txtNoiCap);
		txtNoiCap.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Loại KH");
		lblNewLabel_9.setBounds(10, 178, 46, 14);
		getContentPane().add(lblNewLabel_9);
		
		JComboBox cbLoai = new JComboBox();
		cbLoai.setModel(new DefaultComboBoxModel(new String[] {"Khách lẻ", "Công ty", "Nhà cung cấp"}));
		cbLoai.setBounds(68, 174, 102, 22);
		getContentPane().add(cbLoai);
		
		JLabel lblNewLabel_10 = new JLabel("Quốc tịch");
		lblNewLabel_10.setBounds(254, 100, 54, 14);
		getContentPane().add(lblNewLabel_10);
		
		txtQuocTich = new JTextField();
		txtQuocTich.setBounds(316, 97, 102, 20);
		getContentPane().add(txtQuocTich);
		txtQuocTich.setColumns(10);
		
		JButton btnCancel = new JButton("Hủy");
		btnCancel.setBounds(34, 227, 89, 23);
		getContentPane().add(btnCancel);
		
		JButton btnGop = new JButton("Gộp HD");
		btnGop.setBounds(165, 227, 89, 23);
		getContentPane().add(btnGop);
		
		JButton btnOK = new JButton("Ok");
		btnOK.setBounds(297, 227, 89, 23);
		getContentPane().add(btnOK);
		
		setVisible(true);
	}
}
