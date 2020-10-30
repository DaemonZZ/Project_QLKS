package the.View;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import the.DataTransfer.*;
import the.Model.*;
import the.View.Control.*;

import javax.swing.JTable;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JMenuItem;
import java.awt.FlowLayout;

import java.awt.Color;
import java.awt.Toolkit;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class MainForm extends JFrame {
	public static MainForm m;
	
	private final JTable table;

	private String selectedRoom="";
	private final ArrayList<Phong> listPhong = new DatabaseConnection().getListPhong();
	private final ArrayList<QuanLyPhong> currentRoomInfo = new DatabaseConnection().getCurrentRoomInfo();
	private ArrayList<DongChungTu> listDongChungTu = new ArrayList<DongChungTu>();
	private DefaultTableModel roomInfoModel = new DefaultTableModel();
	private JTabbedPane tabbedPane;
	private float sum=0,xSum=0;
	private QuanLyPhong ql;
	public static NhanVien nv;
	JPanel rightPanel = new JPanel();
	JPanel sumPanel = new SumPanel();
	JScrollPane scrollPane = new JScrollPane();
	JPanel CusInfoPanel = new CustomerInfoPanel();
	JPanel panelBtnEdit = new JPanel();
	JPanel panelCaLam = new JPanel();


	public MainForm(int accessRight) {
		m=this;
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\appicon.png"));
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
		
		rightPanel.setLayout(new BorderLayout());
		rightPanel.setPreferredSize(new Dimension(400,1000));
		
		
		JMenu mnFile = new JMenu("Hệ thống");
		menuBar.add(mnFile);
		
		JMenu mnQuanLy = new JMenu("Quản Lý");
		menuBar.add(mnQuanLy);
		
		JMenuItem itemQLNV = new JMenuItem("Danh Sách Nhân Viên");
		itemQLNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AccountManagementForm();
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
		
		LargeButton btnDangXuat = new LargeButton("logout.png","Log Out");
		btnDangXuat.setPreferredSize(new Dimension(70,80));
		btnDangXuat.setToolTipText("Đăng Xuất");
		largeBtnPanel.add(btnDangXuat);
		btnDangXuat.addMouseListener(largeBtnCliked);
		
		LargeButton btnSodo = new LargeButton("room.png", "Sơ đồ");
		btnSodo.setPreferredSize(new Dimension(70,80));
		btnSodo.setToolTipText("Sơ đồ phòng");
		largeBtnPanel.add(btnSodo);
		btnSodo.addMouseListener(largeBtnCliked);
		
		LargeButton btnlistDV	= new LargeButton("list.png", "QL DV");
		btnlistDV.setPreferredSize(new Dimension(70,80));
		btnlistDV.setToolTipText("Quản lý dịch vụ");
		largeBtnPanel.add(btnlistDV);
		btnlistDV.addMouseListener(largeBtnCliked);

		LargeButton btnRoomProfile = new LargeButton("profile.png","Hồ Sơ Phòng");
		btnRoomProfile.setPreferredSize(new Dimension(70,80));
		btnRoomProfile.setToolTipText("Hồ Sơ Phòng");
		largeBtnPanel.add(btnRoomProfile);
		btnRoomProfile.addMouseListener(largeBtnCliked);
		
		LargeButton btnCalendar = new LargeButton("calendar.png","Lịch Làm việc");
		btnCalendar.setPreferredSize(new Dimension(70,80));
		btnCalendar.setToolTipText("Lịch làm việc");
		largeBtnPanel.add(btnCalendar);
		btnCalendar.addMouseListener(largeBtnCliked);

		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
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
			}
		});
		
		tabbedPane.setBackground(Color.WHITE);
		centerPanel.add(tabbedPane,BorderLayout.CENTER);
		
		JLayeredPane sodoPane = new SoDoPane();
		tabbedPane.addTab("sodo", null, sodoPane, null);
		tabbedPane.setTabComponentAt(tabbedPane.indexOfComponent(sodoPane), getTitlePanel(tabbedPane, sodoPane, "Sơ Đồ"));
		
//		JLayeredPane lichPane = new LichPane();
//		tabbedPane.addTab("", null,lichPane,null);
//		tabbedPane.setTabComponentAt(tabbedPane.indexOfComponent(lichPane), getTitlePanel(tabbedPane, lichPane, "Lịch làm việc"));
		
		CusInfoPanel.setPreferredSize(new Dimension(379,132));
		
		table = new JTable();
		scrollPane.setViewportView(table);
	
		
		sumPanel.setPreferredSize(new Dimension(379, 110));
		
		
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
		mainPanel.add(rightPanel,BorderLayout.EAST);
		
		FlowLayout fl_panelBtnEdit = (FlowLayout) panelBtnEdit.getLayout();
		fl_panelBtnEdit.setAlignment(FlowLayout.RIGHT);
		
		
		JButton btnEdit = new JButton("Chỉnh sửa");
		btnEdit.setEnabled(false);
		panelBtnEdit.add(btnEdit);
		
		
		
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
		txtCa.setBounds(296, 178, 75, 20);
		panelCaLam.add(txtCa);
		txtCa.setColumns(10);
		
		cbCa = new JComboBox();
		cbCa.setEnabled(false);
		cbCa.setModel(new DefaultComboBoxModel(new String[] {"Hành chính", "1", "2", "3"}));
		cbCa.setSelectedIndex(0);
		cbCa.setBounds(296, 178, 94, 20);
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
		
		JTextArea txtGhiChu = new JTextArea();
		txtGhiChu.setEditable(false);
		txtGhiChu.setBounds(86, 320, 249, 106);
		panelCaLam.add(txtGhiChu);
		
		JLabel lblNewLabel_8 = new JLabel("Thông tin ca làm");
		lblNewLabel_8.setForeground(Color.RED);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_8.setBounds(96, 11, 210, 52);
		panelCaLam.add(lblNewLabel_8);
		
		
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
	//Thêm nút close cho tab
	 private static JPanel getTitlePanel(final JTabbedPane tabbedPane, final JLayeredPane panel, String title){
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
	 
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainForm(2);
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
	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}
	public void setTabbedPane(JTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
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
				
				if(btn.getName().equals("Lịch Làm việc")) {
					JLayeredPane lichPane = new LichPane();
					tabbedPane.addTab("lich", null, lichPane, null);
					tabbedPane.setTabComponentAt(tabbedPane.indexOfComponent(lichPane), getTitlePanel(tabbedPane, lichPane, "Lịch làm việc"));
					tabbedPane.setSelectedComponent(lichPane);
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
}
