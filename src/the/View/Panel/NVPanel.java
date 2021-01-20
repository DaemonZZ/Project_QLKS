package the.View.Panel;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import the.DTO.DataStorage;
import the.Model.CaLamViec;
import the.Model.Lich;
import the.Model.NhanVien;
import the.View.MainForm;

public class NVPanel extends JPanel {
    ArrayList<Lich> listLich = DataStorage.loader.getListLich();

    public NVPanel(NhanVien nv) {
        setBackground(Color.WHITE);
        setLayout(new FlowLayout(FlowLayout.LEFT, 1, 1));

        JLabel tbTen = new JLabel(nv.getTaiKhoan());
        tbTen.setHorizontalAlignment(SwingConstants.CENTER);
        tbTen.setFont(new Font("Tahoma", Font.BOLD, 12));
        tbTen.setPreferredSize(new Dimension(100, 100));
        tbTen.setBorder(new LineBorder(Color.BLACK));
        add(tbTen);

        for (Lich lich : listLich) {
            NVButton btn = new NVButton(lich);
            if (lich.getId_NV() == nv.getiD()) {
                btn.addMouseListener(mouseListener);
                add(btn);
            }

        }
    }

    MouseListener mouseListener = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            NVButton src = (NVButton) e.getComponent();
            Lich lich = src.getLich();
            CaLamViec ca = DataStorage.loader.getCaLam(lich.getId_Ca());
            int bp = (DataStorage.loader.getNhanVien(lich.getId_NV()).getLoai());
            String tenbp = "";
            if (bp == 1) tenbp = "Lễ tân";
            if (bp == 2) tenbp = "Kinh Doanh";
            if (bp == 3) tenbp = "Buồng Phòng";
            if (bp == 4) tenbp = "Kế toán";
            MainForm.m.getTxtTenNV().setText(DataStorage.loader.getNhanVien(lich.getId_NV()).getHoTen());
            MainForm.m.getTxtBoPhan().setText(tenbp);
            MainForm.m.getTxtCa().setText(ca.getTenCa());
            MainForm.m.getTxtNgayLam().setText(lich.getNgay().toString());
            MainForm.m.getTxtTu().setText(ca.getTu().toString());
            MainForm.m.getTxtDen().setText(ca.getDen().toString());
            MainForm.m.getTxtTangCa().setText(lich.getTangCa() + "");
            MainForm.m.getTxtGhiChu().setText(lich.getGhiChu());
            MainForm.m.setCurrentLich(lich);

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    };

}
