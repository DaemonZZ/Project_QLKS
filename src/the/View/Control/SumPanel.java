package the.View.Control;

import the.View.AddServiceDialog;
import the.View.MainForm;
import the.View.ProfileDialog;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class SumPanel extends JPanel {
	
	private JTextField txtSum;
	private JTextField txtXSum;
	public static SumPanel s;
	
	public JTextField getTxtSum() {
		return txtSum;
	}

	public void setTxtSum(JTextField txtSum) {
		this.txtSum = txtSum;
	}

	public JTextField getTxtXSum() {
		return txtXSum;
	}

	public void setTxtXSum(JTextField txtXSum) {
		this.txtXSum = txtXSum;
	}

	private final ActionListener btn = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("Thêm DV")){
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
		}
	};


	public SumPanel() {
		s=this;
		setBackground(Color.WHITE);
		setBounds(685, 514, 417, 96);
		
		
		setLayout(null);
		
		JButton btnTraPhong = new JButton("Trả phòng");
		btnTraPhong.setBounds(10, 11, 104, 23);
		add(btnTraPhong);
		btnTraPhong.addActionListener(btn);
		
		JButton btnInHD = new JButton("In HĐ");
		btnInHD.setBounds(124, 11, 74, 23);
		add(btnInHD);
		btnInHD.addActionListener(btn);
		
		JButton btnThemDV = new JButton("Thêm DV");
		btnThemDV.setBounds(208, 11, 89, 23);
		add(btnThemDV);
		btnThemDV.addActionListener(btn);
		
		JButton btnXoaDV = new JButton("Xóa DV");
		btnXoaDV.setBounds(307, 11, 82, 23);
		add(btnXoaDV);
		btnXoaDV.addActionListener(btn);
		
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

}
