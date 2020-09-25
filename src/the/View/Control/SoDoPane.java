package the.View.Control;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import the.DataTransfer.Phong;
import the.Model.DatabaseConnection;
import the.View.RoomButton;

public class SoDoPane extends JLayeredPane {
	private ArrayList<Phong> listPhong = new DatabaseConnection().getListPhong();
	public SoDoPane() {
		setLayout(new BorderLayout());
		JMenuBar menuBar_Sodo = new JMenuBar();
		menuBar_Sodo.setBackground(Color.WHITE);
		add(menuBar_Sodo,BorderLayout.NORTH);
		
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
		add(scrollPaneSoDo,BorderLayout.CENTER);
		scrollPaneSoDo.getVerticalScrollBar().setUnitIncrement(20);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		scrollPaneSoDo.setViewportView(panel_1);
		panel_1.setPreferredSize(new Dimension(130*5+25,(listPhong.size()+1)*130/5+listPhong.size()+100));
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
		
		for (Phong phong : listPhong) {
			RoomButton btn = new RoomButton(phong.getMaPhong(), phong.getTrangThai(), phong.getLoai(), phong.getDonGia(), 0);
			btn.setPreferredSize(new Dimension(130,130));
			btn.addMouseListener(AllEvent.ev.roomSelection);
			panel_1.add(btn);
		}
		
		setVisible(true);
	}

}
