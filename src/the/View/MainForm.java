package the.View;

import javax.swing.BorderFactory;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
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

public class MainForm extends JFrame {
	public static MainForm m;
	
	private JTable table;

	private String selectedRoom="";
	private ArrayList<Phong> listPhong = new DatabaseConnection().getListPhong();
	private  ArrayList<QuanLyPhong> currentRoomInfo = new DatabaseConnection().getCurrentRoomInfo();
	private ArrayList<DongChungTu> listDongChungTu = new ArrayList<DongChungTu>();
	private DefaultTableModel roomInfoModel = new DefaultTableModel();
	private JTabbedPane tabbedPane;
	private float sum=0,xSum=0;
	private QuanLyPhong ql;


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
		
		LargeButton btnlistDV	= new LargeButton("list.png", "DS DV");
		btnlistDV.setPreferredSize(new Dimension(70,80));
		btnlistDV.setToolTipText("Bảng giá dịch vụ");
		largeBtnPanel.add(btnlistDV);
		btnlistDV.addMouseListener(largeBtnCliked);

		LargeButton btnRoomProfile = new LargeButton("profile.png","Hồ Sơ Phòng");
		btnRoomProfile.setPreferredSize(new Dimension(70,80));
		btnRoomProfile.setToolTipText("Hồ Sơ Phòng");
		largeBtnPanel.add(btnRoomProfile);
		btnRoomProfile.addMouseListener(largeBtnCliked);

		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		centerPanel.add(tabbedPane,BorderLayout.CENTER);
		
		JLayeredPane sodoPane = new SoDoPane();
		tabbedPane.addTab("", null, sodoPane, null);
		tabbedPane.setTabComponentAt(tabbedPane.indexOfComponent(sodoPane), getTitlePanel(tabbedPane, sodoPane, "Sơ Đồ"));
		
		JPanel panel = new CustomerInfoPanel();
		panel.setPreferredSize(new Dimension(379,132));
		rightPanel.add(panel,BorderLayout.NORTH);
		 JScrollPane scrollPane = new JScrollPane();
		 rightPanel.add(scrollPane,BorderLayout.CENTER);
		 
		
		table = new JTable();
		scrollPane.setViewportView(table);
	
		
		JPanel sumPanel = new SumPanel();
		sumPanel.setPreferredSize(new Dimension(379, 110));
		rightPanel.add(sumPanel,BorderLayout.SOUTH);
		
		
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
					tabbedPane.addTab("", null, sodoPane, null);
					tabbedPane.setTabComponentAt(tabbedPane.indexOfComponent(sodoPane), getTitlePanel(tabbedPane, sodoPane, "Sơ Đồ"));
					tabbedPane.setSelectedComponent(sodoPane);
				}

				if(btn.getName().equals("Hồ Sơ Phòng")) {
					m.setEnabled(false);
					new ProfileDialog();
				}
			}
	 };


}
