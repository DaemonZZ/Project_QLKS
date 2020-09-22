package the.View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import the.Control.*;
import the.Model.*;

import javax.swing.JTable;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JMenuItem;
import java.awt.FlowLayout;
import javax.swing.ScrollPaneConstants;

public class MainForm extends JFrame {
	public static MainForm m;
	private JTextField txtSum;
	private JTextField txtXSum;
	private JTable table;
	private JTextField txtTenKH;
	private JTextField txtCI;
	private JTextField txtCO;
	private JTextField txtPhong;
	private ArrayList<JButton> listRoombtn = new ArrayList<JButton>();
	
	private String selectedRoom="";
	private ArrayList<Phong> listPhong = new DatabaseConnection().getListPhong();
	private  ArrayList<QuanLyPhong> currentRoomInfo = new DatabaseConnection().getCurrentRoomInfo();
	private ArrayList<DongChungTu> listDongChungTu = new ArrayList<DongChungTu>();
	private DefaultTableModel roomInfoModel = new DefaultTableModel();
	float sum=0,xSum=0;
	
	
	MouseListener roomSelection = new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			table.setModel(new DefaultTableModel());
			selectedRoom=((RoomButton)e.getComponent()).getMaPhong();
			System.out.println(((RoomButton)e.getComponent()).getMaPhong());
			txtPhong.setText(selectedRoom);
			txtTenKH.setText("");
			txtCI.setText("");
			txtCO.setText("");
			
			for (QuanLyPhong ql : currentRoomInfo) {
				if(ql.getMaPhong().equals(selectedRoom)) {
					txtPhong.setText(selectedRoom);
					txtTenKH.setText(ql.getHoTen());
					txtCI.setText(ql.getCI()+"");
					txtCO.setText(ql.getCO()+"");
					System.out.println(selectedRoom);
					table.setModel(getRoomInfoModel(ql.getId()));
					
				}
			}
			txtSum.setText(sum+"");
		}
	};
	
	public MainForm(int accessRight) {
		m=this;
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 11));
		setTitle("Quản lý Khách Sạn");
		setSize(1120, 665);
		getContentPane().setLayout(null);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1102, 22);
		getContentPane().add(menuBar);
		
		JMenu mnFile = new JMenu("Hệ thống");
		menuBar.add(mnFile);
		
		JMenu mnQuanLy = new JMenu("Quản Lý");
		menuBar.add(mnQuanLy);
		
		JMenuItem itemQLNV = new JMenuItem("Danh Sách Nhân Viên");
		itemQLNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StaffManagementForm();
				m.setEnabled(false);
			}
		});
		mnQuanLy.add(itemQLNV);
		
		JMenu mnThongKe = new JMenu("Thống Kê");
		menuBar.add(mnThongKe);
		
		JMenu mnBaoCao = new JMenu("Báo Cáo");
		menuBar.add(mnBaoCao);
		
		JMenu mnTienIch = new JMenu("Tiện Ích");
		menuBar.add(mnTienIch);
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		JButton btnDangXuat = new JButton("Đăng Xuất");
		btnDangXuat.setBounds(10, 33, 65, 65);
		btnDangXuat.setToolTipText("Đăng Xuất");
		getContentPane().add(btnDangXuat);
		
		JButton btnNewJButton_1 = new JButton("New JButton");
		btnNewJButton_1.setBounds(85, 33, 65, 65);
		getContentPane().add(btnNewJButton_1);
		
		JButton btnNewJButton_2 = new JButton("New JButton");
		btnNewJButton_2.setBounds(160, 33, 65, 65);
		getContentPane().add(btnNewJButton_2);
		
		JButton btnNewJButton_3 = new JButton("New JButton");
		btnNewJButton_3.setBounds(235, 33, 65, 65);
		getContentPane().add(btnNewJButton_3);
		
		JButton btnNewJButton_4 = new JButton("New JButton");
		btnNewJButton_4.setBounds(310, 33, 65, 65);
		getContentPane().add(btnNewJButton_4);
		
		JButton btnNewJButton_5 = new JButton("New JButton");
		btnNewJButton_5.setBounds(385, 33, 65, 65);
		getContentPane().add(btnNewJButton_5);
		
		JButton btnClose = new JButton("Đóng");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnClose.setBounds(460, 33, 65, 65);
		getContentPane().add(btnClose);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 109, 677, 480);
		getContentPane().add(tabbedPane);
		
		JLayeredPane sodoPane = new JLayeredPane();
		tabbedPane.addTab("Sơ Đồ", null, sodoPane, null);
		sodoPane.setLayout(null);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setBounds(0, 0, 101, 22);
		sodoPane.add(menuBar_1);
		
		JScrollPane scrollPaneSoDo = new JScrollPane();
		scrollPaneSoDo.setBounds(0, 23, 672, 429);
		sodoPane.add(scrollPaneSoDo);
		scrollPaneSoDo.getVerticalScrollBar().setUnitIncrement(20);
		
		JPanel panel_1 = new JPanel();
		scrollPaneSoDo.setViewportView(panel_1);
		panel_1.setSize(671	, 0);
		panel_1.setLayout(new GridLayout(listPhong.size()/5+1, 5, 5, 5));
		
		for (Phong phong : listPhong) {
			RoomButton btn = new RoomButton(phong.getMaPhong(), phong.getTrangThai(), phong.getLoai(), phong.getDonGia(), 0);
			btn.setPreferredSize(new Dimension(120,120));
			btn.addMouseListener(roomSelection);
			panel_1.add(btn);
		}
		
		
		JPanel panel = new JPanel();
		panel.setBounds(697, 33, 379, 132);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Tên KH");
		lblNewLabel_3.setBounds(24, 11, 46, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Check In");
		lblNewLabel_3_1.setBounds(24, 49, 57, 14);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Check out");
		lblNewLabel_3_2.setBounds(24, 89, 57, 14);
		panel.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Phòng");
		lblNewLabel_3_3.setBounds(243, 11, 46, 14);
		panel.add(lblNewLabel_3_3);
		
		txtTenKH = new JTextField();
		txtTenKH.setEditable(false);
		txtTenKH.setBounds(87, 8, 146, 20);
		panel.add(txtTenKH);
		txtTenKH.setColumns(10);
		
		txtCI = new JTextField();
		txtCI.setEditable(false);
		txtCI.setColumns(10);
		txtCI.setBounds(87, 46, 146, 20);
		panel.add(txtCI);
		
		txtCO = new JTextField();
		txtCO.setEditable(false);
		txtCO.setColumns(10);
		txtCO.setBounds(87, 86, 146, 20);
		panel.add(txtCO);
		
		txtPhong = new JTextField();
		txtPhong.setEditable(false);
		txtPhong.setColumns(10);
		txtPhong.setBounds(301, 8, 57, 20);
		panel.add(txtPhong);
		
		JButton btnChinhSua = new JButton("Chỉnh Sửa");
		btnChinhSua.setBounds(253, 45, 101, 76);
		panel.add(btnChinhSua);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(697, 187, 379, 328);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnTraPhong = new JButton("Trả phòng");
		btnTraPhong.setBounds(697, 523, 104, 23);
		getContentPane().add(btnTraPhong);
		
		JButton btnInHD = new JButton("In HĐ");
		btnInHD.setBounds(811, 523, 74, 23);
		btnInHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		getContentPane().add(btnInHD);
		
		JButton btnThemDV = new JButton("Thêm DV");
		btnThemDV.setBounds(895, 523, 89, 23);
		getContentPane().add(btnThemDV);
		
		JButton btnXoaDV = new JButton("Xóa DV");
		btnXoaDV.setBounds(994, 523, 82, 23);
		getContentPane().add(btnXoaDV);
		
		JLabel lblNewLabel_1 = new JLabel("Tổng phòng");
		lblNewLabel_1.setBounds(796, 557, 66, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tổng đoàn");
		lblNewLabel_2.setBounds(796, 582, 66, 14);
		getContentPane().add(lblNewLabel_2);
		
		txtSum = new JTextField();
		txtSum.setEditable(false);
		txtSum.setBounds(872, 554, 204, 20);
		getContentPane().add(txtSum);
		txtSum.setColumns(10);
		
		txtXSum = new JTextField();
		txtXSum.setEditable(false);
		txtXSum.setBounds(872, 579, 204, 20);
		txtXSum.setColumns(10);
		getContentPane().add(txtXSum);
		
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
		
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
		
	}
	
	public DefaultTableModel getRoomInfoModel(int id_ql) {
		listDongChungTu = new DatabaseConnection().getListDongChungTu(id_ql);
		roomInfoModel = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
			
		};
		sum=0;
		xSum=0;
		roomInfoModel.addColumn("Tên DV");
		roomInfoModel.addColumn("Đơn Giá");
		roomInfoModel.addColumn("Số lượng");
		roomInfoModel.addColumn("Thành tiền");
		
		for (DongChungTu item : listDongChungTu) {
			roomInfoModel.addRow(new String[] {item.getTenDV(),item.getDonGia()+"",item.getSoLuong()+"",(item.getDonGia()*item.getSoLuong())+"đ"});
			sum+=(item.getDonGia()*item.getSoLuong());
		}
		
		return roomInfoModel;
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainForm(0);
	}
}
