package the.View.Control;

import the.DTO.DataStorage;
import the.Model.ChungTu;
import the.Model.DongChungTu;
import the.Model.KhachHang;
import the.Model.QuanLyPhong;
import the.DTO.DatabaseConnection;
import the.View.MainForm;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.util.ArrayList;

public class OrderDialog extends JDialog {
	
	private final JTextField txtPhong;
	private final JTextField txtMaKH;
	private final JTextField txtMaHD;
	private final JTextField txtTenKH;
	private final JTextField txtDonVi;
	private final JTextField txtCMND;
	private final JTextField txtNgayCap;
	private final JTextField txtNoiCap;
	private final JTextField txtQuocTich;
	private final JComboBox cbGen;
	private final JComboBox cbLoai;
	private final JTextField txtGia;
	private final int nextCT = DataStorage.loader.nextIdCt();
	private float gia =0;
	String maPhong;
	ArrayList<QuanLyPhong> currentRoomInfo =DataStorage.loader.getCurrentRoomInfo();
	public OrderDialog(String s) {
		maPhong=s;
		gia =DataStorage.loader.getGia(s);
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
		txtPhong.setBounds(51, 23, 46, 20);
		getContentPane().add(txtPhong);
		txtPhong.setColumns(10);
		txtPhong.setText(s);
		txtPhong.setEditable(false);
		
		JLabel lblNewLabel_1 = new JLabel("Giá");
		lblNewLabel_1.setBounds(101, 26, 34, 14);
		getContentPane().add(lblNewLabel_1);
		
		txtGia = new JTextField();
		txtGia.setEditable(false);
		txtGia.setBounds(128, 23, 81, 20); 
		getContentPane().add(txtGia);
		txtGia.setColumns(10);
		txtGia.setText(gia+"");
		
		JLabel MaKH = new JLabel("Mã KH"); 
		MaKH.setBounds(219, 26, 46, 14);
		getContentPane().add(MaKH);
		
		txtMaKH = new JTextField();
		txtMaKH.setText(DataStorage.loader.nextKH()+"");
		txtMaKH.setEditable(false);
		txtMaKH.setBounds(272, 23, 40, 20);
		getContentPane().add(txtMaKH);
		txtMaKH.setColumns(10);

		JLabel mahd = new JLabel("Mã HD");
		mahd.setBounds(322, 26, 46, 14);
		getContentPane().add(mahd);
		
		txtMaHD = new JTextField();
		txtMaHD.setBounds(378, 23, 40, 20);
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
		
		 cbGen = new JComboBox();
		cbGen.setModel(new DefaultComboBoxModel(new String[] {"Nữ","Nam"}));
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
		
		 cbLoai = new JComboBox();
		cbLoai.setModel(new DefaultComboBoxModel(new String[] {"Khách lẻ", "Công ty"}));
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
		btnCancel.addActionListener(btn);
		
		JButton btnGop = new JButton("Gộp HD");
		btnGop.setBounds(165, 227, 89, 23);
		getContentPane().add(btnGop);
		btnGop.addActionListener(btn);

		JButton btnOK = new JButton("Ok");
		btnOK.setBounds(297, 227, 89, 23);
		getContentPane().add(btnOK);
		btnOK.addActionListener(btn);

		setVisible(true);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				MainForm.m.setEnabled(true);
			}
		});
	}

	public ActionListener btn = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {

			if(e.getActionCommand().equals("Hủy")){
				MainForm.m.setEnabled(true);
				dispose();
			}
			if(e.getActionCommand().equals("Gộp HD")){

			}
			if(e.getActionCommand().equals("Ok")){
				checkIn();
			}
		}
	};

	public void checkIn(){
		KhachHang k = new KhachHang();
		k.setIdDoan(0);
		k.setId(Integer.parseInt(txtMaKH.getText()));
		k.setHoTen(txtTenKH.getText());
		k.setGioiTinh(cbGen.getSelectedIndex());
		k.setDonVi(txtDonVi.getText());
		k.setcMND(txtCMND.getText());
		k.setNgayCap(txtNgayCap.getText());
		k.setNoiCap(txtNoiCap.getText());
		k.setLoai(cbLoai.getSelectedIndex());
		k.setQuocTich(txtQuocTich.getText());

		DataStorage.loader.getListKH().add(k);

		QuanLyPhong q = new QuanLyPhong();
		q.setId(++MainForm.maxIdQL);
		q.setId_Dk(0);
		q.setHoTen(txtTenKH.getText());
		q.setId_KH(k.getId());
		q.setMaPhong(txtPhong.getText());
		q.setCI(LocalDate.now());
		q.setGia(0);
		q.setTrangThai(1);


		DataStorage.loader.getCurrentRoomInfo().add(q);

			if(k.getIdDoan()==0) {
				ChungTu c = new ChungTu();
				int nextCT = DataStorage.loader.nextIdCt();
				c.setSoCT(nextCT);
				c.setLoai(3);
				c.setId_KH(k.getId());
				c.setNoiDung(k.getHoTen());
				c.setId_QL(q.getId());

				DataStorage.loader.getListChungTu().add(c);

				DataStorage.loader.setSttPhong(q.getMaPhong(), 4);
				SoDoPane.s.reloadRoomList();
				JOptionPane.showMessageDialog(rootPane, "Check in complete!");

				currentRoomInfo = DataStorage.loader.getCurrentRoomInfo();
				MainForm.m.setSum(0);
				MainForm.m.getTable().setModel(new DefaultTableModel());
				MainForm.m.setSelectedRoom(q.getMaPhong());
				CustomerInfoPanel.t.getTxtPhong().setText(MainForm.m.getSelectedRoom());
				CustomerInfoPanel.t.getTxtTenKH().setText("");
				CustomerInfoPanel.t.getTxtCI().setText("");
				CustomerInfoPanel.t.getTxtCO().setText("");

				for (QuanLyPhong ql : currentRoomInfo) {
					if (ql.getMaPhong().equals(MainForm.m.getSelectedRoom())) {
						CustomerInfoPanel.t.getTxtTenKH().setText(ql.getHoTen());
						CustomerInfoPanel.t.getTxtCI().setText(ql.getCI() + "");
						//CustomerInfoPanel.t.getTxtCO().setText(ql.getCO() + "");
						MainForm.m.getTable().setModel(MainForm.m.getRoomInfoModel(ql.getId()));

					}
				}
				SumPanel.s.getTxtSum().setText(MainForm.m.getSum() + "");
				MainForm.m.setEnabled(true);
				SoDoPane.s.reloadRoomList();
				SoDoPane.s.repaint();
				dispose();

			}


		//Them dich vu phong vao hoa don
			DongChungTu newDvPhongInCt = new DongChungTu(DataStorage.loader.nextDongCT(), nextCT,11,"Phòng ở",1,gia,"",txtPhong.getText());
			DataStorage.loader.getListDongCT().add(newDvPhongInCt);



	}

}
