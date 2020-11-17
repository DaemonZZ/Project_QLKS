package the.View.Control;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
import org.codehaus.groovy.tools.shell.Main;
import the.DTO.DataStorage;
import the.DTO.DatabaseConnection;
import the.Model.DongChungTu;
import the.View.AddServiceDialog;
import the.View.MainForm;
import the.View.ProfileDialog;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

import javax.swing.*;


public class SumPanel extends JPanel {
	
	private JTextField txtSum;
	private JTextField txtXSum;
	public static SumPanel s;
	private JButton btnTraPhong,btnThemDV,btnXoaDV;
	
	public JTextField getTxtSum() {
		return txtSum;
	}


	public JTextField getTxtXSum() {
		return txtXSum;
	}


	private final ActionListener btn = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("Thay đổi DV")){
				if(MainForm.m.getSelectedRoom()!="" && MainForm.m.getQl()!=null){
					MainForm.m.setEnabled(false);
					new AddServiceDialog();
				}
				else{
					JOptionPane.showMessageDialog(getRootPane(),"Không thể thêm dịch vụ vào phòng hiện tại. Chọn phòng đang được sử dụng và thử lại!");
				}
			}
			if(e.getActionCommand().equals("Trả phòng")){
				MainForm.m.setEnabled(false);
				String selected = MainForm.m.getSelectedRoom();
				if(selected!=""){
					new ProfileDialog(selected,0);
				}
				else{
					new ProfileDialog();
				}
			}
			if(e.getActionCommand().equals("In HĐ")){
				xuatHoaDon(1,500000f);
//				System.out.println(System.getProperty("java.class.path").replace(':','\n'));
			}

			if(e.getActionCommand().equals("Xóa DV")){
				int id = MainForm.m.getQl().getId();
				int selectedRow = MainForm.m.getTable().getSelectedRow();
				DongChungTu del = new DongChungTu();
				String tenDV ="";
				ArrayList<DongChungTu> listDongChungTu = DataStorage.loader.getListDongCT(id);
				if(selectedRow!=-1)  {
					tenDV = MainForm.m.getTable().getValueAt(selectedRow,0)+"";
					for (DongChungTu d: listDongChungTu
						 ) {
						if(tenDV.equals(d.getTenDV())) del=d;
					}
					DataStorage.loader.getListDongCT().remove(del);
					SoDoPane.s.reloadTable();
				}
			}
		}
	};


	public JButton getBtnTraPhong() {
		return btnTraPhong;
	}

	public JButton getBtnThemDV() {
		return btnThemDV;
	}

	public JButton getBtnXoaDV() {
		return btnXoaDV;
	}

	public SumPanel() {
		s=this;
		setBackground(Color.WHITE);
		setBounds(685, 514, 417, 96);

		setLayout(null);
		
		btnTraPhong = new JButton("Trả phòng");
		btnTraPhong.setBounds(41, 11, 104, 23);
		add(btnTraPhong);
		btnTraPhong.addActionListener(btn);
		btnTraPhong.setEnabled(false);
		
		btnThemDV = new JButton("Thay đổi DV");
		btnThemDV.setBounds(170, 11, 112, 23);
		add(btnThemDV);
		btnThemDV.addActionListener(btn);
		btnThemDV.setEnabled(false);
		
		btnXoaDV = new JButton("Xóa DV");
		btnXoaDV.setBounds(307, 11, 82, 23);
		add(btnXoaDV);
		btnXoaDV.addActionListener(btn);
		btnXoaDV.setEnabled(false);
		
		txtSum = new JTextField();
		txtSum.setBackground(Color.WHITE);
		txtSum.setBounds(185, 42, 204, 20);
		add(txtSum);
		txtSum.setEditable(false);
		txtSum.setColumns(10);
		
		
		txtXSum = new JTextField();
		txtXSum.setBackground(Color.WHITE);
		txtXSum.setBounds(185, 67, 204, 20);
		add(txtXSum);
		txtXSum.setEditable(false);
		txtXSum.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Tổng phòng");
		lblNewLabel_1.setBounds(109, 45, 66, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tổng đoàn");
		lblNewLabel_2.setBounds(109, 70, 66, 14);
		add(lblNewLabel_2);
		
	}

	public void xuatHoaDon(int soct,float tong){
		String path = "D:\\Workspace\\Java\\Project_QLKS_java\\src\\the\\Report\\HoaDon.jrxml";
		Connection conn = new DatabaseConnection().getConn();
		Hashtable<String,Object> map = new Hashtable();
		map.put("soct",soct);
		map.put("sum",tong);
		try {
			JasperReport rp = JasperCompileManager.compileReport(path);
			JasperPrint pr = JasperFillManager.fillReport(rp,map,conn);
			JasperViewer.viewReport(pr,false);
		} catch (JRException e) {
			e.printStackTrace();
		}
	}

}
