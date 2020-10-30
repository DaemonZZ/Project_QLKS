package the.View;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.color.ColorSpace;

import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;


public class RoomButton extends JPanel implements MouseListener{
	private String maPhong;
	private int trangThai;
	private int loai;
	private float Gia;
	private float sum;
	private JTextField color;
	
	Color _trangThai;
	String _loai,stt;
	
	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	public int getLoai() {
		return loai;
	}

	public void setLoai(int loai) {
		this.loai = loai;
	}

	public float getGia() {
		return Gia;
	}

	public void setGia(float gia) {
		Gia = gia;
	}

	public float getSum() {
		return sum;
	}

	public void setSum(float sum) {
		this.sum = sum;
	}

	public JTextField getColor() {
		return color;
	}

	public void setColor(JTextField color) {
		this.color = color;
	}

	public RoomButton(String maPhong, int trangThai, int loai, float gia, float sum) {
		
		super();
		
		switch (trangThai) {
		case 0: _trangThai=Color.YELLOW;
			
			break;
		case 1: _trangThai=Color.CYAN;
		
			break;
		case 2: _trangThai=Color.GREEN;
		
			break;
		case 3: _trangThai=Color.GRAY;
		
			break;
		case 4: _trangThai=Color.PINK;
		
			break;
		case 5: _trangThai=Color.RED;
		
			break;

		
		}
		
		switch (loai) {
		case 1: _loai="Double";
			
			break;
		case 2: _loai="Triple";
		
		break;
		case 3: _loai="Family";
		
		break;
		case 4: _loai="Double - VIP";
		
		break;
		case 5: _loai="Triple - VIP";
		
		break;
		case 6: _loai="Family - VIP";
		
		break;
		case 7: _loai="Working";
		
		break;
		case 8: _loai="Hall";
		
		break;

		default:
			break;
		}
		setBorder(new BevelBorder(BevelBorder.RAISED, null, null, Color.DARK_GRAY, null));
		//setSize(120,120);
		setBackground(SystemColor.info);
		this.maPhong = maPhong;
		this.trangThai = trangThai;
		this.loai = loai;
		Gia = gia;
		this.sum = sum;
		
		setSize(160,150);
		setLayout(null);
		
		JLabel lbMaPhong = new JLabel();
		lbMaPhong.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbMaPhong.setBounds(10, 11, 57, 19);
		add(lbMaPhong);
		lbMaPhong.setText(maPhong);
		
		color = new JTextField();
		color.setEditable(false);
		color.setBounds(77, 11, 31, 20);
		add(color);
		color.setColumns(10);
		
		JLabel lbThongTin = new JLabel("<html>Loại Phòng: "+_loai+"<br>Giá: "+gia+"<br>Trạng thái: 0</html>");
		lbThongTin.setBounds(10, 57, 101, 59);
		add(lbThongTin);
		
		JLabel lblNewLabel = new JLabel("______________");
		lblNewLabel.setBounds(0, 32, 126, 14);
		add(lblNewLabel);
		
		this.setToolTipText("Tổng tiền: "+sum+"đ");
		
		color.setBackground(_trangThai);
		
		setVisible(true);
		
		addMouseListener(this);
		
	}
	
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
		setBackground(SystemColor.info);
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
		setBackground(SystemColor.info);
		setBorder(new BevelBorder(BevelBorder.RAISED, null, null, Color.DARK_GRAY, null));
	}
	
}
