package the.View;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import the.Control.*;
import the.Model.*;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.ListSelectionModel;

public class StaffManagementForm extends JFrame {
	private JTextField textField;
	private JTable table;
	private DatabaseConnection databaseConnection = new DatabaseConnection();
	DefaultTableModel model = new DefaultTableModel() {

		@Override
		public boolean isCellEditable(int row, int column) {
			// TODO Auto-generated method stub
			return false;
		}
		
	};
	public static StaffManagementForm s;
	public StaffManagementForm() {
		s=this;
        getContentPane().setLayout(null);
        
        setTitle("Quản Lý Nhân Viên");
        setSize(740, 480);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        ImageIcon icon = new ImageIcon("img/qlnv.jpg");
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(305, 67, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon =new ImageIcon(newImg);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(183, 11, 429, 82);
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
		cbBoPhan.setModel(new DefaultComboBoxModel(new String[] {"0.Quản Trị", "1.Lễ Tân", "2.Kinh Doanh", "3.Buồng Phòng", "4.Kế Toán", "5.Tất cả"}));
		cbBoPhan.setSelectedIndex(5);
		cbBoPhan.setBounds(347, 98, 117, 22);
		getContentPane().add(cbBoPhan);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 128, 590, 298);
		getContentPane().add(scrollPane);
		
		model.addColumn("ID");
		model.addColumn("Họ tên");
		model.addColumn("Điện Thoại");
		model.addColumn("Tài Khoản");
		model.addColumn("Mật Khẩu");
		model.addColumn("Bộ Phận");
		model=getSearchModelForStaffForm(5,"");
		
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		table.getColumnModel().getColumn(1).setPreferredWidth(165);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);

		JButton btnTim = new JButton("Tìm Kiếm");
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model=getSearchModelForStaffForm(cbBoPhan.getSelectedIndex(), textField.getText());
				table.setModel(model);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				table.getColumnModel().getColumn(0).setPreferredWidth(20);
				table.getColumnModel().getColumn(1).setPreferredWidth(170);
				table.getColumnModel().getColumn(2).setPreferredWidth(100);
				table.getColumnModel().getColumn(3).setPreferredWidth(100);
				table.getColumnModel().getColumn(4).setPreferredWidth(100);
				table.getColumnModel().getColumn(5).setPreferredWidth(100);
			}
		});
		btnTim.setBounds(474, 99, 89, 23);
		getContentPane().add(btnTim);
		
		JButton btnDong = new JButton("Đóng");
		btnDong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                MainForm.m.setEnabled(true);
                dispose();
			}
		});
		btnDong.setBounds(621, 403, 89, 23);
		getContentPane().add(btnDong);
		
		JButton btnLog = new JButton("Log");
		btnLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(rootPane, "Chọn thông tin trước");
				} 
				else {
					String nv = (String) table.getValueAt(table.getSelectedRow(), 0);
					int id = Integer.parseInt(nv);
					new LogDialog(id);
					setEnabled(false);
				}
				
			}
		});
		btnLog.setToolTipText("Lịch Sử Hoạt Động");
		btnLog.setBounds(621, 324, 89, 23);
		getContentPane().add(btnLog);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(rootPane, "Chọn thông tin cần xóa trước");
				} else {
					String nv = (String) table.getValueAt(table.getSelectedRow(), 0);
					int id = Integer.parseInt(nv);
					boolean b=databaseConnection.xoaNV(id);
					if(b) {
						model.removeRow(table.getSelectedRow());
						table.setModel(model);
						JOptionPane.showMessageDialog(rootPane, "Đã xóa thành công");
					}
					else {
						JOptionPane.showMessageDialog(rootPane, "Thất bại");
					}
				}
			}
		});
		btnXoa.setBounds(621, 290, 89, 23);
		getContentPane().add(btnXoa);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(rootPane, "Chọn thông tin cần sửa trước");
				} else {
					String nv = (String) table.getValueAt(table.getSelectedRow(), 0);
					int id = Integer.parseInt(nv);
					new EditNVDialog(id);
					setEnabled(false);
					
				}
			}
		});
		btnSua.setBounds(621, 256, 89, 23);
		getContentPane().add(btnSua);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idMax = 0;
				ArrayList<NhanVien> list = databaseConnection.getListNV();
				for (NhanVien vn : list) {
					if(vn.getiD()>idMax) idMax=vn.getiD();
				}
				
				
				new AddDialog(idMax+1);
				setEnabled(false);
			}
		});
		btnThem.setBounds(621, 222, 89, 23);
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
	public void reload() {
		model=new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
			
		};
		model.addColumn("ID");
		model.addColumn("Họ tên");
		model.addColumn("Điện Thoại");
		model.addColumn("Tài Khoản");
		model.addColumn("Mật Khẩu");
		model.addColumn("Bộ Phận");
		model=getSearchModelForStaffForm(5,"");
		
		table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		table.getColumnModel().getColumn(1).setPreferredWidth(170);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		
	}
	public DefaultTableModel getSearchModelForStaffForm(int index,String name) {
		
		ArrayList<NhanVien> list = databaseConnection.getListNV();
		ArrayList<NhanVien> resultList = new ArrayList<NhanVien>();
		String boPhan = "";
		model = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
			
		};
		model.addColumn("ID");
		model.addColumn("Họ tên");
		model.addColumn("Điện Thoại");
		model.addColumn("Tài Khoản");
		model.addColumn("Mật Khẩu");
		model.addColumn("Bộ Phận");
		if(index==5){
			for (NhanVien nVien : list) {
				switch (nVien.getLoai()) {
					case 0:boPhan="Quản Lý";
						break;
					case 1:boPhan="Lễ tân";
						break;
					case 2:boPhan="Kinh Doanh";
						break;
					case 3:boPhan = "Buồng Phòng";
						break;
					case 4:boPhan = "Kế Toán";
						break;
					default:boPhan="Tất cả";
						break;
				}
				if(nVien.getHoTen().toLowerCase().contains(name.toLowerCase())){
					model.addRow(new String[]{nVien.getiD()+"",nVien.getHoTen(),nVien.getSoDT(),nVien.getTaiKhoan(),"########",boPhan});
				}
			}
		}else{
			for (NhanVien nVien : list) {
				switch (nVien.getLoai()) {
					case 0:boPhan="Quản Lý";
						break;
					case 1:boPhan="Lễ tân";
						break;
					case 2:boPhan="Kinh Doanh";
						break;
					case 3:boPhan = "Buồng Phòng";
						break;
					case 4:boPhan = "Kế Toán";
						break;
					default:boPhan="Tất cả";
						break;
				}
				if(nVien.getHoTen().toLowerCase().contains(name.toLowerCase()) && nVien.getLoai()==index){
					model.addRow(new String[]{nVien.getiD()+"",nVien.getHoTen(),nVien.getSoDT(),nVien.getTaiKhoan(),"########",boPhan});
				}
			}
		}
		
		return model;
	}
}
