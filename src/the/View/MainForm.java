package the.View;

import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

import the.Model.*;
import the.DTO.*;
import the.View.Control.*;

import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Dimension;

import java.awt.FlowLayout;

import java.awt.Color;
import java.awt.Toolkit;

public class MainForm extends JFrame {
	public static MainForm m;
	private final JTable table;

	private String selectedRoom="";


	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	private JTabbedPane tabbedPane;
	private float sum=0,xSum=0;
	private QuanLyPhong ql;
	public static NhanVien nv;
	JPanel rightPanel = new JPanel();
	SumPanel sumPanel = new SumPanel();
	JScrollPane scrollPane = new JScrollPane();
	JPanel CusInfoPanel = new CustomerInfoPanel();
	JPanel panelBtnEdit = new JPanel();
	JPanel panelCaLam = new JPanel();
	JPanel largeBtnPanel;
	public static int maxIdQL = new DatabaseConnection().nextId_QL()-1;
	private LichPane lichPane;
	private JComboBox cbCI;
	private JTextField txtSum;

	public JComboBox getCbCI() {
		return cbCI;
	}

	public JTextField getTxtSum() {
		return txtSum;
	}

	public JTextField getTxtCO() {
		return txtCO;
	}

	public JTextField getTxtTen() {
		return txtTen;
	}



	private JTextField txtCO;
	private JTextField txtTen;
	private JPanel pnBound;
	private JPanel pnel;

	public JTable getTbDichVu() {
		return tbDichVu;
	}

	private JTable tbDichVu;

	public JTextField getTxtPhong() {
		return txtPhong;
	}

	private JTextField txtPhong;

	public MainForm(int accessRight) {
		m=this;
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\appicon.png"));
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 11));

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
		
		 largeBtnPanel = new JPanel();
		largeBtnPanel.setBackground(Color.WHITE);
		largeBtnPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		centerPanel.add(largeBtnPanel,BorderLayout.NORTH);
		
		rightPanel.setLayout(new BorderLayout());
		rightPanel.setPreferredSize(new Dimension(400,1000));

		
		
		JMenu mnFile = new JMenu("Hệ thống");
		menuBar.add(mnFile);
		
		JMenuItem itemLogOut = new JMenuItem("Chuyển tài khoản");
		mnFile.add(itemLogOut);
		itemLogOut.addActionListener(menuItemClicked);
		
		JMenuItem itemClose = new JMenuItem("Đóng");
		mnFile.add(itemClose);
		itemClose.addActionListener(menuItemClicked);
		
		JMenu mnQuanLy = new JMenu("Quản Lý");
		menuBar.add(mnQuanLy);
		mnQuanLy.setEnabled(false);
		
		JMenuItem itemQLNV = new JMenuItem("Quản lý Đăng Nhập");
		itemQLNV.addActionListener(menuItemClicked);

		JMenuItem itemQLDV = new JMenuItem("Quản lý dịch vụ");
		itemQLDV.addActionListener(menuItemClicked);
		mnQuanLy.add(itemQLNV);
		mnQuanLy.add(itemQLDV);
		
		JMenuItem itemQLPhong = new JMenuItem("Quản lý Phòng");
		mnQuanLy.add(itemQLPhong);
		itemQLPhong.addActionListener(menuItemClicked);
		
		JMenuItem itemQLKH = new JMenuItem("Quản lý Khách Hàng");
		mnQuanLy.add(itemQLKH);
		itemQLKH.addActionListener(menuItemClicked);
		
		JMenuItem itemKho = new JMenuItem("Quản lý Kho");
		mnQuanLy.add(itemKho);
		itemKho.addActionListener(menuItemClicked);
		
		JMenu mnThongKe = new JMenu("Thống Kê");
		menuBar.add(mnThongKe);
		
		JMenuItem itemChamCong = new JMenuItem("Bảng chấm công");
		mnThongKe.add(itemChamCong);
		itemChamCong.addActionListener(menuItemClicked);
		
		JMenuItem itemHoSoPhong = new JMenuItem("Hồ sơ phòng");
		mnThongKe.add(itemHoSoPhong);
		itemHoSoPhong.addActionListener(menuItemClicked);
		
		JMenuItem itemDoanhThu = new JMenuItem("Thống kê doanh thu");
		mnThongKe.add(itemDoanhThu);
		itemDoanhThu.setEnabled(false);
		itemDoanhThu.addActionListener(menuItemClicked);
		
		JMenu mnBaoCao = new JMenu("Báo Cáo");
		menuBar.add(mnBaoCao);

		JMenuItem itemBaoCao = new JMenuItem("Lịch sử báo cáo");
		mnBaoCao.add(itemBaoCao);
		itemBaoCao.addActionListener(menuItemClicked);
		
		JMenu mnTienIch = new JMenu("Tiện Ích");
		menuBar.add(mnTienIch);
		
		JMenuItem itemDanhBa = new JMenuItem("Danh Bạ điện thoại");
		mnTienIch.add(itemDanhBa);
		itemDanhBa.addActionListener(menuItemClicked);
		
		JMenuItem itemClock = new JMenuItem("Giờ thế giới");
		mnTienIch.add(itemClock);
		itemClock.addActionListener(menuItemClicked);
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		JMenuItem itemHelp = new JMenuItem("Hướng dãn sử dụng");
		mnAbout.add(itemHelp);
		itemHelp.addActionListener(menuItemClicked);
		
		JMenuItem itemAbout = new JMenuItem("Thông tin phần mềm");
		mnAbout.add(itemAbout);
		itemAbout.addActionListener(menuItemClicked);
		
		LargeButton btnDangXuat = new LargeButton("logout.png","Log Out");
		btnDangXuat.setPreferredSize(new Dimension(70,80));
		btnDangXuat.setToolTipText("Đăng Xuất");
		largeBtnPanel.add(btnDangXuat);
		btnDangXuat.addMouseListener(largeBtnCliked);
		
		LargeButton btnSodo = new LargeButton("room.png", "Sơ đồ");
		btnSodo.setPreferredSize(new Dimension(70,80));
		btnSodo.setToolTipText("Sơ đồ phòng");
		btnSodo.addMouseListener(largeBtnCliked);
		
		LargeButton btnlistDV	= new LargeButton("list.png", "QL DV");
		btnlistDV.setPreferredSize(new Dimension(70,80));
		btnlistDV.setToolTipText("Quản lý dịch vụ");
		btnlistDV.addMouseListener(largeBtnCliked);

		LargeButton btnRoomProfile = new LargeButton("profile.png","Hồ Sơ Phòng");
		btnRoomProfile.setPreferredSize(new Dimension(70,80));
		btnRoomProfile.setToolTipText("Hồ Sơ Phòng");
		btnRoomProfile.addMouseListener(largeBtnCliked);
		
		LargeButton btnCalendar = new LargeButton("calendar.png","Lịch Làm việc");
		btnCalendar.setPreferredSize(new Dimension(70,80));
		btnCalendar.setToolTipText("Lịch làm việc");
		btnCalendar.addMouseListener(largeBtnCliked);

		LargeButton btnChamCong = new LargeButton("chamcong.png","C.Công");
		btnChamCong.setPreferredSize(new Dimension(70,80));
		btnChamCong.setToolTipText("Chấm công");
		btnChamCong.addMouseListener(largeBtnCliked);

		LargeButton btnReport = new LargeButton("baocao.png","Báo Cáo");
		btnReport.setPreferredSize(new Dimension(70,80));
		btnReport.setToolTipText("Báo cáo ca làm việc");
		btnReport.addMouseListener(largeBtnCliked);

		LargeButton btnDatPhong = new LargeButton("booking.png","Đ.Phòng");
		btnDatPhong.setPreferredSize(new Dimension(70,80));
		btnDatPhong.setToolTipText("Danh sách phòng đặt");
		btnDatPhong.addMouseListener(largeBtnCliked);

		LargeButton btnQLKH = new LargeButton("khachhang.png","QLKH");
		btnQLKH.setPreferredSize(new Dimension(70,80));
		btnQLKH.setToolTipText("Quản lý Khách Hàng");
		btnQLKH.addMouseListener(largeBtnCliked);

		LargeButton btnDoanhThu = new LargeButton("chart.png","Doanh Thu");
		btnDoanhThu.setPreferredSize(new Dimension(70,80));
		btnDoanhThu.setToolTipText("Báo cáo tài chính");
		btnDoanhThu.addMouseListener(largeBtnCliked);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addChangeListener(e -> {
			changeTabEvent();
		});
		
		tabbedPane.setBackground(Color.WHITE);
		centerPanel.add(tabbedPane,BorderLayout.CENTER);

		CusInfoPanel.setPreferredSize(new Dimension(379,132));
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		sumPanel.setPreferredSize(new Dimension(379, 110));
		
		
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				DataSynchronizer.synchronizer.syncAllData();
				System.exit(0);
			}
			
		});
		mainPanel.add(rightPanel,BorderLayout.EAST);
		
		FlowLayout fl_panelBtnEdit = (FlowLayout) panelBtnEdit.getLayout();
		fl_panelBtnEdit.setAlignment(FlowLayout.RIGHT);
		
		
		JButton btnEdit = new JButton("Chỉnh sửa");
		JButton btnOkEdit = new JButton("OK");
		btnOkEdit.setVisible(false);
		JButton btnCancelEdit = new JButton("Cancel");
		btnCancelEdit.setVisible(false);
		btnEdit.setEnabled(false);
		ActionListener editCaLam = e -> {
			if(e.getActionCommand().equals("Chỉnh sửa")){
				btnOkEdit.setVisible(true);
				btnCancelEdit.setVisible(true);
				btnEdit.setVisible(false);
				txtCa.setVisible(false);
				cbCa.setEnabled(true);
				txtGhiChu.setEditable(true);
				txtTangCa.setEnabled(true);
				txtTangCa.setEditable(true);
			}
			if(e.getActionCommand().equals("OK")){
				int id = currentLich.getId();
				int ca = cbCa.getSelectedIndex();
				int tangca = Integer.parseInt(txtTangCa.getText());
				String ghichu = txtGhiChu.getText();
				DataStorage.loader.updateLich(id,ca,tangca,ghichu);
				txtCa.setText(cbCa.getSelectedItem().toString());
				txtCa.setVisible(true);
				cbCa.setEnabled(false);
				txtGhiChu.setEditable(false);
				txtTangCa.setEnabled(false);
				btnOkEdit.setVisible(false);
				btnCancelEdit.setVisible(false);
				btnEdit.setVisible(true);
				lichPane.reloadLichPane();

			}
			if(e.getActionCommand().equals("Cancel")){
				txtCa.setVisible(true);
				cbCa.setEnabled(false);
				txtGhiChu.setEditable(false);
				txtTangCa.setEnabled(false);
				btnOkEdit.setVisible(false);
				btnCancelEdit.setVisible(false);
				btnEdit.setVisible(true);
			}
		};
		btnEdit.addActionListener(editCaLam);
		btnCancelEdit.addActionListener(editCaLam);
		btnOkEdit.addActionListener(editCaLam);
		panelBtnEdit.add(btnEdit);
		panelBtnEdit.add(btnOkEdit);
		panelBtnEdit.add(btnCancelEdit);

		panelCaLam.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tên NV");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 94, 61, 14);
		panelCaLam.add(lblNewLabel);
		
		txtTenNV = new JTextField();
		txtTenNV.setEditable(false);
		txtTenNV.setBounds(81, 92, 182, 20);
		panelCaLam.add(txtTenNV);
		txtTenNV.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Bộ Phận");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 135, 61, 14);
		panelCaLam.add(lblNewLabel_1);
		
		txtBoPhan = new JTextField();
		txtBoPhan.setEditable(false);
		txtBoPhan.setBounds(81, 133, 182, 20);
		panelCaLam.add(txtBoPhan);
		txtBoPhan.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Ngày");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 180, 71, 14);
		panelCaLam.add(lblNewLabel_2);
		
		txtNgayLam = new JTextField();
		txtNgayLam.setEditable(false);
		txtNgayLam.setBounds(81, 178, 182, 20);
		panelCaLam.add(txtNgayLam);
		txtNgayLam.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Ca");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(269, 180, 46, 14);
		panelCaLam.add(lblNewLabel_3);
		
		txtCa = new JTextField();
		txtCa.setEditable(false);
		txtCa.setBounds(286, 178, 85, 20);
		panelCaLam.add(txtCa);
		txtCa.setColumns(10);
		
		cbCa = new JComboBox();
		cbCa.setEnabled(false);
		cbCa.setModel(new DefaultComboBoxModel(new String[] {"Hành chính", "1", "2", "3","Off"}));
		cbCa.setSelectedIndex(0);
		cbCa.setBounds(286, 178, 104, 20);
		panelCaLam.add(cbCa);
		
		JLabel lblNewLabel_4 = new JLabel("Từ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(10, 226, 61, 14);
		panelCaLam.add(lblNewLabel_4);
		
		txtTu = new JTextField();
		txtTu.setEditable(false);
		txtTu.setBounds(81, 224, 110, 20);
		panelCaLam.add(txtTu);
		txtTu.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Đến");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(201, 226, 62, 14);
		panelCaLam.add(lblNewLabel_5);
		
		txtDen = new JTextField();
		txtDen.setEditable(false);
		txtDen.setBounds(280, 224, 110, 20);
		panelCaLam.add(txtDen);
		txtDen.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Tăng ca");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(10, 273, 61, 14);
		panelCaLam.add(lblNewLabel_6);
		
		txtTangCa = new JTextField();
		txtTangCa.setEditable(false);
		txtTangCa.setBounds(81, 271, 110, 20);
		panelCaLam.add(txtTangCa);
		txtTangCa.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Ghi Chú");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7.setBounds(10, 324, 61, 14);
		panelCaLam.add(lblNewLabel_7);
		
		 txtGhiChu = new JTextArea();
		txtGhiChu.setEditable(false);
		txtGhiChu.setBounds(86, 320, 249, 106);
		panelCaLam.add(txtGhiChu);
		
		JLabel lblNewLabel_8 = new JLabel("Thông tin ca làm");
		lblNewLabel_8.setForeground(Color.RED);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_8.setBounds(96, 11, 210, 52);
		panelCaLam.add(lblNewLabel_8);

		StatusPanel sttPn = new StatusPanel();
		getContentPane().add(sttPn,BorderLayout.SOUTH);
		
		setLocationRelativeTo(null);
		setVisible(true);
		DataStorage.ld.setVisible(false);
		if(accessRight==0){
			setTitle("Quản lý Khách Sạn - ADMIN");
			lichPane = new LichPane();
			tabbedPane.addTab("lich", null, lichPane, null);
			tabbedPane.setTabComponentAt(tabbedPane.indexOfComponent(lichPane), getTitlePanel(tabbedPane, lichPane, "Lịch làm việc"));
			tabbedPane.setSelectedComponent(lichPane);
			lichPane.getBtnAdd().setEnabled(true);
			btnEdit.setEnabled(true);

			LargeButton btnQLPhong = new LargeButton("qlphong.png","QL Phòng");
			btnQLPhong.setPreferredSize(new Dimension(70,80));
			btnQLPhong.setToolTipText("Quản lý phòng");
			btnQLPhong.addMouseListener(largeBtnCliked);

			largeBtnPanel.add(btnCalendar);
			largeBtnPanel.add(btnlistDV);
			largeBtnPanel.add(btnRoomProfile);
			largeBtnPanel.add(btnQLKH);
			largeBtnPanel.add(btnQLPhong);
			largeBtnPanel.add(btnDoanhThu);

			mnQuanLy.setEnabled(true);
			itemDoanhThu.setEnabled(true);


		}
		if(accessRight==1){
			setTitle("Quản lý Khách Sạn - Lễ tân");
			JLayeredPane sodoPane = new SoDoPane();
			tabbedPane.addTab("sodo", null, sodoPane, null);
			tabbedPane.setTabComponentAt(tabbedPane.indexOfComponent(sodoPane), getTitlePanel(tabbedPane, sodoPane, "Sơ Đồ"));
			tabbedPane.setSelectedComponent(sodoPane);

			largeBtnPanel.add(btnSodo);
			largeBtnPanel.add(btnlistDV);
			largeBtnPanel.add(btnDatPhong);
			largeBtnPanel.add(btnRoomProfile);
			largeBtnPanel.add(btnCalendar);
			largeBtnPanel.add(btnChamCong);
			largeBtnPanel.add(btnReport);
			sumPanel.getBtnThemDV().setEnabled(true);
			sumPanel.getBtnTraPhong().setEnabled(true);
			sumPanel.getBtnXoaDV().setEnabled(true);
		}

		if(accessRight==3){
			JLayeredPane sodoPane = new SoDoPane();
			tabbedPane.addTab("sodo", null, sodoPane, null);
			tabbedPane.setTabComponentAt(tabbedPane.indexOfComponent(sodoPane), getTitlePanel(tabbedPane, sodoPane, "Sơ Đồ"));
			tabbedPane.setSelectedComponent(sodoPane);

			largeBtnPanel.add(btnCalendar);
			largeBtnPanel.add(btnSodo);
			largeBtnPanel.add(btnRoomProfile);
			largeBtnPanel.add(btnChamCong);
		}

		if(accessRight==2){
			JLayeredPane sodoPane = new SoDoPane();
			tabbedPane.addTab("sodo", null, sodoPane, null);
			tabbedPane.setTabComponentAt(tabbedPane.indexOfComponent(sodoPane), getTitlePanel(tabbedPane, sodoPane, "Sơ Đồ"));
			tabbedPane.setSelectedComponent(sodoPane);

			largeBtnPanel.add(btnChamCong);
			largeBtnPanel.add(btnDatPhong);
			largeBtnPanel.add(btnQLKH);
		}

	}

	private void changeTabEvent() {
		int a = tabbedPane.getSelectedIndex();
		String tit = tabbedPane.getTitleAt(a);
		System.out.println(tabbedPane.getTitleAt(a));
		if(tit.equals("lich")) {
			rightPanel.removeAll();
			rightPanel.add(panelCaLam, BorderLayout.CENTER);
			rightPanel.add(panelBtnEdit, BorderLayout.SOUTH);
			rightPanel.repaint();
		}
		if(tit.equals("sodo")) {
			rightPanel.removeAll();
			rightPanel.repaint();
			rightPanel.add(sumPanel,BorderLayout.SOUTH);
			rightPanel.add(scrollPane,BorderLayout.CENTER);
			rightPanel.add(CusInfoPanel,BorderLayout.NORTH);
			rightPanel.repaint();
		}
		if(tit.equals("qlkh")){
			rightPanel.removeAll();
			rightPanel.add(pnel,BorderLayout.CENTER);
			rightPanel.repaint();
		}
		if(tit.equals("dk")){
			rightPanel.removeAll();
		}
	}


	public DefaultTableModel getRoomInfoModel(int id_ql) {
		ArrayList<DongChungTu> listDongChungTu = DataStorage.loader.getListDongCT(id_ql);
		DefaultTableModel roomInfoModel = new DefaultTableModel() {

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
	//Thêm nút close cho tab
	 public static JPanel getTitlePanel(final JTabbedPane tabbedPane, final JLayeredPane panel, String title){
		  JPanel titlePanel = new JPanel(new BorderLayout());
		  titlePanel.setOpaque(false);
		  JLabel titleLbl = new JLabel(title);
		  
		  titleLbl.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
		  titlePanel.add(titleLbl,BorderLayout.CENTER);
		  CloseButtonForTabbedPanel closeButton = new CloseButtonForTabbedPanel();

		  closeButton.addMouseListener(new MouseAdapter()
		  {
			  @Override
			  public void mouseClicked(MouseEvent e){
				  tabbedPane.remove(panel);
			  }
		  });
		  closeButton.setPreferredSize(new Dimension(15,15));
		  titlePanel.add(closeButton,BorderLayout.EAST);

	  return titlePanel;
	 }

	public String getSelectedRoom() {
		return selectedRoom;
	}
	public void setSelectedRoom(String selectedRoom) {
		this.selectedRoom = selectedRoom;
	}
	public float getSum() {
		return sum;
	}
	public void setSum(float sum) {
		this.sum = sum;
	}
	public float getxSum() {
		return xSum;
	}
	public void setxSum(float xSum) {
		this.xSum = xSum;
	}
	public JTable getTable() {
		return table;
	}
	public QuanLyPhong getQl() {
		return ql;
	}
	public void setQl(QuanLyPhong ql) {
		this.ql = ql;
	}

	private ActionListener menuItemClicked = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("Quản lý dịch vụ")){
				QLDichVu dvPane = new QLDichVu();
				tabbedPane.addTab("qldv", null, dvPane, null);
				tabbedPane.setTabComponentAt(tabbedPane.indexOfComponent(dvPane), getTitlePanel(tabbedPane, dvPane, "Quản lý DV"));
				tabbedPane.setSelectedComponent(dvPane);
			}
			if(e.getActionCommand().equals("Quản lý Đăng Nhập")){
				new AccountManagementForm();
				m.setEnabled(false);
			}
			if(e.getActionCommand().equals("Chuyển tài khoản")){
				DataSynchronizer.synchronizer.stop();
				DataSynchronizer.synchronizer.syncAllData();
				DataStorage.loader=null;
				new LoginForm();
				dispose();
			}
			if(e.getActionCommand().equals("Đóng")){
				System.exit(0);
			}
			if(e.getActionCommand().equals("Hồ sơ phòng")){
				MainForm.m.setEnabled(false);
				String selected = MainForm.m.getSelectedRoom();
				if(selected!=""){
					new ProfileDialog(selected,0);
				}
				else{
					new ProfileDialog();
				}
			}
			if(e.getActionCommand().equals("Quản lý Khách Hàng")){
				QLKhachHang khPane = new QLKhachHang();
				tabbedPane.addTab("qlkh", null, khPane, null);
				tabbedPane.setTabComponentAt(tabbedPane.indexOfComponent(khPane), getTitlePanel(tabbedPane, khPane, "Quản lý Khách hàng"));
				tabbedPane.setSelectedComponent(khPane);
			}
		}
	};

	public  MouseListener largeBtnCliked = new MouseListener() {
			
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
				LargeButton btn = (LargeButton) e.getComponent();
				if(btn.getName().equals("Log Out")) {
					DataSynchronizer.synchronizer.stop();
					DataSynchronizer.synchronizer.syncAllData();
					DataStorage.loader=null;
					new LoginForm();
					dispose();
				}
				
				if(btn.getName().equals("Sơ đồ")) {
					JLayeredPane sodoPane = new SoDoPane();
					tabbedPane.addTab("sodo", null, sodoPane, null);
					tabbedPane.setTabComponentAt(tabbedPane.indexOfComponent(sodoPane), getTitlePanel(tabbedPane, sodoPane, "Sơ Đồ"));
					tabbedPane.setSelectedComponent(sodoPane);
				}

				if(btn.getName().equals("Hồ Sơ Phòng")) {
					m.setEnabled(false);
					new ProfileDialog();
				}
				if(btn.getName().equals("Đ.Phòng")){
					DkPane dkPane = new DkPane();

					tabbedPane.addTab("dk", null, dkPane, null);
					tabbedPane.setTabComponentAt(tabbedPane.indexOfComponent(dkPane), getTitlePanel(tabbedPane, dkPane, "Danh sách phòng đặt"));
					tabbedPane.setSelectedComponent(dkPane);
				}
				
				if(btn.getName().equals("Lịch Làm việc")) {
					lichPane = new LichPane();
					tabbedPane.addTab("lich", null, lichPane, null);
					tabbedPane.setTabComponentAt(tabbedPane.indexOfComponent(lichPane), getTitlePanel(tabbedPane, lichPane, "Lịch làm việc"));
					tabbedPane.setSelectedComponent(lichPane);
				}
				if(btn.getName().equals("C.Công")){
					Lich lich = new Lich();
					for (Lich l : DataStorage.loader.getListLich()
							 ) {
						if(l.getId_Ca()!=3){
							if(l.getId_NV()==nv.getiD()&&l.getNgay().equals(LocalDate.now())) {
								lich=l;
							}
						} else if(LocalTime.now().isBefore(LocalTime.parse("12:00"))){
							System.out.println(l.getId_NV()==nv.getiD()&&l.getNgay().equals(LocalDate.now().minusDays(1)));
							if(l.getId_NV()==nv.getiD()&&l.getNgay().equals(LocalDate.now().minusDays(1))) {
								lich=l;
							}
						} else if(LocalTime.now().isAfter(LocalTime.parse("12:00"))){
							if(l.getId_NV()==nv.getiD()&&l.getNgay().equals(LocalDate.now())) {
								lich=l;
							}
						}
					}
					
					new TimeKeepingDialog(lich);
				}
				if(btn.getName().equals("QL DV")){
					QLDichVu dvPane = new QLDichVu();
					tabbedPane.addTab("qldv", null, dvPane, null);
					tabbedPane.setTabComponentAt(tabbedPane.indexOfComponent(dvPane), getTitlePanel(tabbedPane, dvPane, "Quản lý DV"));
					tabbedPane.setSelectedComponent(dvPane);
				}
				if(btn.getName().equals("QLKH")){
					QLKhachHang khPane = new QLKhachHang();
					tabbedPane.addTab("qlkh", null, khPane, null);
					tabbedPane.setTabComponentAt(tabbedPane.indexOfComponent(khPane), getTitlePanel(tabbedPane, khPane, "Quản lý Khách hàng"));
					tabbedPane.setSelectedComponent(khPane);
				}

				if(btn.getName().equals("QL Phòng")){
					QLPhong qlpPane = new QLPhong();
					tabbedPane.addTab("qlphong", null, qlpPane, null);
					tabbedPane.setTabComponentAt(tabbedPane.indexOfComponent(qlpPane), getTitlePanel(tabbedPane, qlpPane, "Quản ly Phòng"));
					tabbedPane.setSelectedComponent(qlpPane);
				}
			}
	 };
	private JTextField txtTenNV;
	private JTextField txtBoPhan;
	private JTextField txtNgayLam;
	private JComboBox cbCa;
	private JTextField txtTu;
	private JTextField txtDen;
	private JTextField txtTangCa;
	private JTextField txtCa;
	private  Lich currentLich;

	public Lich getCurrentLich() {
		return currentLich;
	}

	public void setCurrentLich(Lich currentLich) {
		this.currentLich = currentLich;
	}

	public JTextArea getTxtGhiChu() {
		return txtGhiChu;
	}

	public void setTxtGhiChu(JTextArea txtGhiChu) {
		this.txtGhiChu = txtGhiChu;
	}

	private JTextArea txtGhiChu;

	public JTextField getTxtTenNV() {
		return txtTenNV;
	}

	public void setTxtTenNV(JTextField txtTenNV) {
		this.txtTenNV = txtTenNV;
	}

	public JTextField getTxtBoPhan() {
		return txtBoPhan;
	}

	public void setTxtBoPhan(JTextField txtBoPhan) {
		this.txtBoPhan = txtBoPhan;
	}

	public JTextField getTxtNgayLam() {
		return txtNgayLam;
	}

	public void setTxtNgayLam(JTextField txtNgayLam) {
		this.txtNgayLam = txtNgayLam;
	}

	public JComboBox getCbCa() {
		return cbCa;
	}

	public void setCbCa(JComboBox cbCa) {
		this.cbCa = cbCa;
	}

	public JTextField getTxtTu() {
		return txtTu;
	}

	public void setTxtTu(JTextField txtTu) {
		this.txtTu = txtTu;
	}

	public JTextField getTxtDen() {
		return txtDen;
	}

	public void setTxtDen(JTextField txtDen) {
		this.txtDen = txtDen;
	}

	public JTextField getTxtTangCa() {
		return txtTangCa;
	}

	public void setTxtTangCa(JTextField txtTangCa) {
		this.txtTangCa = txtTangCa;
	}

	public JTextField getTxtCa() {
		return txtCa;
	}

	public void setTxtCa(JTextField txtCa) {
		this.txtCa = txtCa;
	}




}
