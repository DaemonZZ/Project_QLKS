package the.View.Control;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


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

	public SumPanel() {
		s=this;
		setBackground(Color.WHITE);
		setBounds(685, 514, 417, 96);
		
		
		setLayout(null);
		
		JButton btnTraPhong = new JButton("Trả phòng");
		btnTraPhong.setBounds(10, 11, 104, 23);
		add(btnTraPhong);
		
		JButton btnInHD = new JButton("In HĐ");
		btnInHD.setBounds(124, 11, 74, 23);
		add(btnInHD);
		
		JButton btnThemDV = new JButton("Thêm DV");
		btnThemDV.setBounds(208, 11, 89, 23);
		add(btnThemDV);
		
		JButton btnXoaDV = new JButton("Xóa DV");
		btnXoaDV.setBounds(307, 11, 82, 23);
		add(btnXoaDV);
		
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
