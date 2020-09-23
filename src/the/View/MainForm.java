package the.View;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import the.DataTransfer.*;
import the.Model.*;

import javax.swing.JTable;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JMenuItem;
import java.awt.FlowLayout;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.JToggleButton;

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
			sum=0;
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
		getContentPane().setLayout(new BorderLayout());
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		menuBar.setBounds(0, 0, 1102, 22);
		getContentPane().add(menuBar,BorderLayout.NORTH);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setLayout(new BorderLayout(10,5));
		getContentPane().add(mainPanel,BorderLayout.CENTER);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setBackground(Color.WHITE);
		centerPanel.setLayout(new BorderLayout(0,10));
		mainPanel.add(centerPanel,BorderLayout.CENTER);
		
		JPanel largeBtnPanel = new JPanel();
		largeBtnPanel.setBackground(Color.WHITE);
		largeBtnPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		centerPanel.add(largeBtnPanel,BorderLayout.NORTH);
		
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new BorderLayout());
		rightPanel.setPreferredSize(new Dimension(400,1000));
		
		
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
		
//		JButton btnDangXuat = new JButton("Đăng Xuất");
//		btnDangXuat.setBounds(10, 33, 65, 65);
//		btnDangXuat.setPreferredSize(new Dimension(80,80));
//		btnDangXuat.setToolTipText("Đăng Xuất");
//		largeBtnPanel.add(btnDangXuat);
//		
//		JButton btnPhong = new JButton("Danh Mục Phòng");
//		btnPhong.setBounds(85, 33, 65, 65);
//		btnPhong.setPreferredSize(new Dimension(80,80));
//		largeBtnPanel.add(btnPhong);
//		
//		JButton btnNewJButton_2 = new JButton("Phiếu ĐP");
//		btnNewJButton_2.setPreferredSize(new Dimension(80,80));
//		largeBtnPanel.add(btnNewJButton_2);
//		
//		JButton btnNewJButton_3 = new JButton("New JButton");
//		btnNewJButton_3.setPreferredSize(new Dimension(80,80));
//		largeBtnPanel.add(btnNewJButton_3);
//		
//		JButton btnNewJButton_4 = new JButton("New JButton");
//		btnNewJButton_4.setPreferredSize(new Dimension(80,80));
//		largeBtnPanel.add(btnNewJButton_4);
//		
//		JButton btnNewJButton_5 = new JButton("New JButton");
//		btnNewJButton_5.setPreferredSize(new Dimension(80,80));
//		largeBtnPanel.add(btnNewJButton_5);
//		
//		JButton btnClose = new JButton("Đóng");
//		btnClose.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				System.exit(0);
//			}
//		});
//		btnClose.setPreferredSize(new Dimension(80,80));
//		largeBtnPanel.add(btnClose);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		centerPanel.add(tabbedPane,BorderLayout.CENTER);
		
		JLayeredPane sodoPane = new JLayeredPane();
		//tabbedPane.addTab("Sơ Đồ", null, sodoPane, null);
		sodoPane.setLayout(new BorderLayout());
		
		JMenuBar menuBar_Sodo = new JMenuBar();
		menuBar_Sodo.setBackground(Color.WHITE);
		sodoPane.add(menuBar_Sodo,BorderLayout.NORTH);
		
		JButton btnDV = new JButton("Danh mục Dịch vụ");
		menuBar_Sodo.add(btnDV);
		
		JButton btnConSum = new JButton("Vật tư tiêu hao");
		menuBar_Sodo.add(btnConSum);
		
		JButton btnNhom = new JButton("Nhóm");
		menuBar_Sodo.add(btnNhom);
		
		JButton btnDat = new JButton("Đặt phòng");
		menuBar_Sodo.add(btnDat);
		
		JPanel filterPanel = new JPanel();
		filterPanel.setBackground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) filterPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		flowLayout.setHgap(10);
		menuBar_Sodo.add(filterPanel);
		
		JLabel lblNewLabel = new JLabel("Lọc: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setForeground(Color.RED);
		filterPanel.add(lblNewLabel);
		
		JComboBox cbLoai = new JComboBox();
		cbLoai.setModel(new DefaultComboBoxModel(new String[] {"Double", "Triple", "Family", "Double - VIP", "Triple - VIP", "Family - VIP", "Working", "Hall", "Tất cả"}));
		cbLoai.setSelectedIndex(8);
		filterPanel.add(cbLoai);
		
		JComboBox ttCb = new JComboBox(new String[] {"Trống","Dơ","Đã Đặt","Bảo Trì","Đang Sử Dụng","Nhóm"});
		ttCb.setModel(new DefaultComboBoxModel(new String[] {"Trống", "Dơ", "Đã Đặt", "Bảo Trì", "Đang Sử Dụng", "Nhóm", "Tất cả"}));
		ttCb.setSelectedIndex(6);
		filterPanel.add(ttCb);
		
		JScrollPane scrollPaneSoDo = new JScrollPane();
		sodoPane.add(scrollPaneSoDo,BorderLayout.CENTER);
		scrollPaneSoDo.getVerticalScrollBar().setUnitIncrement(20);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		scrollPaneSoDo.setViewportView(panel_1);
		panel_1.setPreferredSize(new Dimension(130*5+25,(listPhong.size()+1)*130/5+listPhong.size()+100));
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
		
		for (Phong phong : listPhong) {
			RoomButton btn = new RoomButton(phong.getMaPhong(), phong.getTrangThai(), phong.getLoai(), phong.getDonGia(), 0);
			btn.setPreferredSize(new Dimension(130,130));
			btn.addMouseListener(roomSelection);
			panel_1.add(btn);
		}
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(697, 33, 379, 132);
		panel.setPreferredSize(new Dimension(379,132));
		//rightPanel.add(panel,BorderLayout.NORTH);
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
		txtTenKH.setBackground(Color.WHITE);
		txtTenKH.setEditable(false);
		txtTenKH.setBounds(87, 8, 146, 20);
		panel.add(txtTenKH);
		txtTenKH.setColumns(10);
		
		txtCI = new JTextField();
		txtCI.setBackground(Color.WHITE);
		txtCI.setEditable(false);
		txtCI.setColumns(10);
		txtCI.setBounds(87, 46, 146, 20);
		panel.add(txtCI);
		
		txtCO = new JTextField();
		txtCO.setBackground(Color.WHITE);
		txtCO.setEditable(false);
		txtCO.setColumns(10);
		txtCO.setBounds(87, 86, 146, 20);
		panel.add(txtCO);
		
		txtPhong = new JTextField();
		txtPhong.setBackground(Color.WHITE);
		txtPhong.setEditable(false);
		txtPhong.setColumns(10);
		txtPhong.setBounds(301, 8, 57, 20);
		panel.add(txtPhong);
		
		JButton btnChinhSua = new JButton("Chỉnh Sửa");
		btnChinhSua.setBounds(253, 45, 101, 76);
		panel.add(btnChinhSua);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(697, 187, 379, 328);
		rightPanel.add(scrollPane,BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(685, 514, 417, 96);
		panel_2.setPreferredSize(new Dimension(379, 110));
		//rightPanel.add(panel_2,BorderLayout.SOUTH);
		panel_2.setLayout(null);
		
		JButton btnTraPhong = new JButton("Trả phòng");
		btnTraPhong.setBounds(10, 11, 104, 23);
		panel_2.add(btnTraPhong);
		
		JButton btnInHD = new JButton("In HĐ");
		btnInHD.setBounds(124, 11, 74, 23);
		panel_2.add(btnInHD);
		
		JButton btnThemDV = new JButton("Thêm DV");
		btnThemDV.setBounds(208, 11, 89, 23);
		panel_2.add(btnThemDV);
		
		JButton btnXoaDV = new JButton("Xóa DV");
		btnXoaDV.setBounds(307, 11, 82, 23);
		panel_2.add(btnXoaDV);
		
		txtSum = new JTextField();
		txtSum.setBackground(Color.WHITE);
		txtSum.setBounds(185, 42, 204, 20);
		panel_2.add(txtSum);
		txtSum.setEditable(false);
		txtSum.setColumns(10);
		
		txtXSum = new JTextField();
		txtXSum.setBackground(Color.WHITE);
		txtXSum.setBounds(185, 67, 204, 20);
		panel_2.add(txtXSum);
		txtXSum.setEditable(false);
		txtXSum.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Tổng phòng");
		lblNewLabel_1.setBounds(109, 45, 66, 14);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tổng đoàn");
		lblNewLabel_2.setBounds(109, 70, 66, 14);
		panel_2.add(lblNewLabel_2);
		btnInHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
		mainPanel.add(rightPanel,BorderLayout.EAST);
		
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
