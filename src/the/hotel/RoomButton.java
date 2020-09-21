package the.hotel;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RoomButton extends JPanel implements ActionListener{
	private String maPhong;
	private int trangThai;
	private int loai;
	private float Gia;
	private float sum;
	private JTextField color;
	public RoomButton(String maPhong, int trangThai, int loai, float gia, float sum) {
		super();
		this.maPhong = maPhong;
		this.trangThai = trangThai;
		this.loai = loai;
		Gia = gia;
		this.sum = sum;
		
		String thongTinPhong = "<html>Loại Phòng: "+loai+"<br>Giá: "+gia+"<br>Trạng thái: "+trangThai+"</html>";
		setSize(200,200);
		setLayout(null);
		
		JLabel lbMaPhong = new JLabel();
		lbMaPhong.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbMaPhong.setBounds(10, 11, 57, 19);
		add(lbMaPhong);
		lbMaPhong.setText(maPhong);
		
		color = new JTextField();
		color.setEditable(false);
		color.setBounds(159, 11, 31, 20);
		add(color);
		color.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 41, 180, 130);
		add(panel);
		panel.setLayout(null);
		panel.setToolTipText("Tổng tiền hiện tại: "+sum);
		
		JLabel lbThongTin = new JLabel("New label");
		lbThongTin.setBounds(10, 11, 160, 59);
		panel.add(lbThongTin);
		lbThongTin.setText(thongTinPhong);
		
		this.setVisible(true);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
