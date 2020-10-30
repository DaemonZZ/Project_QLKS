package the.View.Control;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import the.DataTransfer.Lich;
import the.DataTransfer.NhanVien;
import the.Model.DatabaseConnection;

public class NVPanel extends JPanel {
	DatabaseConnection dbc = new DatabaseConnection();
	ArrayList<Lich> listLich = dbc.getlistLich();
	public NVPanel(NhanVien nv) {
		setBackground(Color.WHITE);
		setLayout(new FlowLayout(FlowLayout.LEFT, 1, 1));

		JLabel tbTen = new JLabel(nv.getTaiKhoan());
		tbTen.setHorizontalAlignment(SwingConstants.CENTER);
		tbTen.setFont(new Font("Tahoma", Font.BOLD, 12));
		tbTen.setPreferredSize(new Dimension(100,100));
		tbTen.setBorder(new LineBorder(Color.BLACK));
		add(tbTen);

		for (Lich lich : listLich) {
			NVButton btn = new NVButton(lich);
			if(lich.getId_NV()==nv.getiD()){
				add(btn);

			}

		}

	}

}
