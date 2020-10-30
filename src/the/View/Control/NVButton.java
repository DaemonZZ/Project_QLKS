package the.View.Control;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import the.DataTransfer.Lich;

public class NVButton extends JPanel{
	LocalDate date;
	public NVButton(Lich lich) {
		
		setBorder(new BevelBorder(BevelBorder.RAISED, null, null, Color.DARK_GRAY, null));
		setPreferredSize(new Dimension(100,100));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("______________");
		lblNewLabel.setBounds(10, 30, 126, 14);
		add(lblNewLabel);
		
		
		setVisible(true);

		JLabel lbThu = new JLabel("New label");
		lbThu.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbThu.setBounds(10, 7, 70, 14);
		add(lbThu);
		
		JLabel lbNgay = new JLabel("New label");
		lbNgay.setBounds(10, 23, 100, 14);
		add(lbNgay);
		
		JLabel lbCa = new JLabel("");
		lbCa.setBounds(10, 48, 82, 14);
		add(lbCa);
		
		JLabel lbTangCa = new JLabel("");
		lbTangCa.setBounds(10, 67, 70, 14);
		add(lbTangCa);
		
		date=lich.getNgay();
		String thu = date.getDayOfWeek().toString();
		String ngay = date.toString();
		String ca = "";
		
		if(lich.getId_Ca()==4) {
			ca = "hành chính.";
		}
		else {
			ca=lich.getId_Ca()+".";
		}
		lbThu.setText(thu);
		lbNgay.setText(ngay);
		lbCa.setText("Ca: "+ca);
		lbTangCa.setText("Tăng ca: "+lich.getTangCa()+".");

		if(lich.getId_Ca()==0) {
			addMouseListener(lsn0);
			setBackground(Color.RED);
		}
		if(lich.getId_Ca()==1) {
			setBackground(Color.PINK);
			addMouseListener(lsn1);
		}
		if(lich.getId_Ca()==2) {
			addMouseListener(lsn2);
			setBackground(Color.YELLOW);

		}

		if(lich.getId_Ca()==3) {
			addMouseListener(lsn3);
			setBackground(Color.cyan);
		}
	}
	private MouseListener lsn0 = new MouseListener() {
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			setBackground(new Color(233, 235, 148));
			setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.ORANGE, null));

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			setBackground(Color.RED);
			setBorder(new BevelBorder(BevelBorder.RAISED, null, null, Color.DARK_GRAY, null));
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			setBackground(new Color(233, 235, 148));
			setBorder(new BevelBorder(BevelBorder.RAISED, null, null, Color.RED, null));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			setBackground(Color.RED);
			setBorder(new BevelBorder(BevelBorder.RAISED, null, null, Color.DARK_GRAY, null));
		}
	};

	private MouseListener lsn1 = new MouseListener() {
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			setBackground(new Color(233, 235, 148));
			setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.ORANGE, null));

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			setBackground(Color.PINK);
			setBorder(new BevelBorder(BevelBorder.RAISED, null, null, Color.DARK_GRAY, null));
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			setBackground(new Color(233, 235, 148));
			setBorder(new BevelBorder(BevelBorder.RAISED, null, null, Color.RED, null));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			setBackground(Color.PINK);
			setBorder(new BevelBorder(BevelBorder.RAISED, null, null, Color.DARK_GRAY, null));
		}
	};

	private MouseListener lsn2 = new MouseListener() {
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			setBackground(new Color(233, 235, 148));
			setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.ORANGE, null));

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			setBackground(Color.YELLOW);
			setBorder(new BevelBorder(BevelBorder.RAISED, null, null, Color.DARK_GRAY, null));
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			setBackground(new Color(233, 235, 148));
			setBorder(new BevelBorder(BevelBorder.RAISED, null, null, Color.RED, null));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			setBackground(Color.YELLOW);
			setBorder(new BevelBorder(BevelBorder.RAISED, null, null, Color.DARK_GRAY, null));
		}
	};
	private MouseListener lsn3 = new MouseListener() {
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			setBackground(new Color(233, 235, 148));
			setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.ORANGE, null));

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			setBackground(Color.CYAN);
			setBorder(new BevelBorder(BevelBorder.RAISED, null, null, Color.DARK_GRAY, null));
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			setBackground(new Color(233, 235, 148));
			setBorder(new BevelBorder(BevelBorder.RAISED, null, null, Color.RED, null));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			setBackground(Color.CYAN);
			setBorder(new BevelBorder(BevelBorder.RAISED, null, null, Color.DARK_GRAY, null));
		}
	};

}
