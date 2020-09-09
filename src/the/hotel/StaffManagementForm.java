package the.hotel;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class StaffManagementForm extends JFrame {
	private JTextField textField;
	private JTable table;
	public StaffManagementForm() {
        getContentPane().setLayout(null);
        
        setTitle("Quản Lý Nhân Viên");
        setSize(565, 480);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        ImageIcon icon = new ImageIcon("img/qlnv.jpg");
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(305, 67, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon =new ImageIcon(newImg);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(109, 11, 429, 82);
		getContentPane().add(lblNewLabel);
		lblNewLabel.setIcon(newIcon);
		
		JLabel lblNewLabel_1 = new JLabel("Nhập Tên");
		lblNewLabel_1.setBounds(10, 103, 57, 14);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(65, 100, 204, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Bộ Phận");
		lblNewLabel_2.setBounds(291, 102, 57, 14);
		getContentPane().add(lblNewLabel_2);
		
		JComboBox cbBoPhan = new JComboBox();
		cbBoPhan.setModel(new DefaultComboBoxModel(new String[] {"Quản Trị", "Lễ Tân", "Kinh Doanh", "Buồng Phòng", "Kế Toán", "Tất cả"}));
		cbBoPhan.setSelectedIndex(5);
		cbBoPhan.setBounds(347, 98, 82, 22);
		getContentPane().add(cbBoPhan);
		
		JButton btnTim = new JButton("Tìm Kiếm");
		btnTim.setBounds(449, 99, 89, 23);
		getContentPane().add(btnTim);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 128, 429, 298);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnDong = new JButton("Đóng");
		btnDong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                MainForm.m.setEnabled(true);
                dispose();
			}
		});
		btnDong.setBounds(449, 403, 89, 23);
		getContentPane().add(btnDong);
		
		JButton btnLog = new JButton("Log");
		btnLog.setToolTipText("Lịch Sử Hoạt Động");
		btnLog.setBounds(449, 324, 89, 23);
		getContentPane().add(btnLog);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBounds(449, 290, 89, 23);
		getContentPane().add(btnXoa);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setBounds(449, 256, 89, 23);
		getContentPane().add(btnSua);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setBounds(449, 222, 89, 23);
        getContentPane().add(btnThem);
        
        setVisible(true);

        this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
                MainForm.m.setEnabled(true);
				dispose();
			}
        	
		});
	}
}
