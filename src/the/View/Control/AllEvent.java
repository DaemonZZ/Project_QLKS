package the.View.Control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import the.DataTransfer.QuanLyPhong;
import the.Model.DatabaseConnection;
import the.View.LoginForm;
import the.View.MainForm;
import the.View.RoomButton;

public class  AllEvent {
	public static AllEvent ev;
	private  static ArrayList<QuanLyPhong> currentRoomInfo = new DatabaseConnection().getCurrentRoomInfo();
	
	
	 public AllEvent() {
		// TODO Auto-generated constructor stub
		 ev=this;
	}
	 
	 
		
	 /**
	  * Event thanh button chính
	  */
	 
	 public static MouseListener largeBtnCliked = new MouseListener() {
			
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
					MainForm.m.dispose();
				}
			}
	 };

	 /**
	  * Event btn chọn phòng
	  * Hiển thị thông tin KH lên CustomInfoPanel
	  * Hiển thị bảng dịch vụ phòng đó
	  * Hiển thị tổng vào txtSum của SumPanel
	  */
	 public static MouseListener roomSelection = new MouseListener() {
			
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
				MainForm.m.setSum(0);
				MainForm.m.getTable().setModel(new DefaultTableModel());
				MainForm.m.setSelectedRoom(((RoomButton)e.getComponent()).getMaPhong());
				CustomerInfoPanel.t.getTxtPhong().setText(MainForm.m.getSelectedRoom());
				CustomerInfoPanel.t.getTxtTenKH().setText("");
				CustomerInfoPanel.t.getTxtCI().setText("");
				CustomerInfoPanel.t.getTxtCO().setText("");
				
				for (QuanLyPhong ql : currentRoomInfo) {
					if(ql.getMaPhong().equals(MainForm.m.getSelectedRoom())) {
						CustomerInfoPanel.t.getTxtTenKH().setText(ql.getHoTen());
						CustomerInfoPanel.t.getTxtCI().setText(ql.getCI()+"");
						CustomerInfoPanel.t.getTxtCO().setText(ql.getCO()+"");
						MainForm.m.getTable().setModel(MainForm.m.getRoomInfoModel(ql.getId()));
						
					}
				}
				SumPanel.s.getTxtSum().setText(MainForm.m.getSum()+"");
				
			}
		};
}
