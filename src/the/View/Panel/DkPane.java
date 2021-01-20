package the.View.Panel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import the.DTO.DataStorage;
import the.Model.*;
import the.View.MainForm;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class DkPane extends JLayeredPane {
    private JTable tb = new JTable();
    private JTextField txtTen;
    private JTextField txtNgaydat;
    private JTextField txtTuNgay;
    private JTextField txtDenNgay;
    private JTextField txtDoan;
    private JTextField txtCoc;
    private JTextField txtSoPhong;
    private JTextField txtSoNguoi;
    private JTextField txtNam;
    private JTextField txtNu;
    private JTextField txtTreEm;
    private JTable tbPhong;
    JLabel lbPhongDat;
    JPanel panelPhongdat;
    private ArrayList<Phong> listChon = new ArrayList<>();

    public DkPane() {
        setLayout(new BorderLayout(0, 0));

        JPanel panel_1 = new JPanel();
        add(panel_1, BorderLayout.CENTER);
        panel_1.setLayout(new BorderLayout(0, 0));

        JPanel panel_2 = new JPanel();
        panel_1.add(panel_2, BorderLayout.NORTH);

        JLabel lb = new JLabel("Thông tin chi tiết");
        lb.setFont(new Font("Tahoma", Font.BOLD, 16));
        lb.setForeground(Color.RED);
        panel_2.add(lb);

        JPanel panel_3 = new JPanel();
        panel_1.add(panel_3, BorderLayout.WEST);
        panel_3.setLayout(null);
        panel_3.setPreferredSize(new Dimension(500, 500));

        JLabel lblNewLabel = new JLabel("Tên Khách");
        lblNewLabel.setBounds(10, 23, 69, 14);
        panel_3.add(lblNewLabel);

        txtTen = new JTextField();
        txtTen.setEditable(false);
        txtTen.setBounds(77, 20, 132, 20);
        panel_3.add(txtTen);
        txtTen.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Ngày đặt");
        lblNewLabel_1.setBounds(221, 23, 56, 14);
        panel_3.add(lblNewLabel_1);

        txtNgaydat = new JTextField();
        txtNgaydat.setEditable(false);
        txtNgaydat.setBounds(287, 20, 132, 20);
        panel_3.add(txtNgaydat);
        txtNgaydat.setColumns(10);

        JLabel lblT = new JLabel("Từ ngày");
        lblT.setBounds(10, 66, 59, 14);
        panel_3.add(lblT);

        txtTuNgay = new JTextField();
        txtTuNgay.setEditable(false);
        txtTuNgay.setColumns(10);
        txtTuNgay.setBounds(77, 63, 132, 20);
        panel_3.add(txtTuNgay);

        JLabel lblNewLabel_1_1 = new JLabel("Đến ngày");
        lblNewLabel_1_1.setBounds(221, 66, 59, 14);
        panel_3.add(lblNewLabel_1_1);

        txtDenNgay = new JTextField();
        txtDenNgay.setEditable(false);
        txtDenNgay.setColumns(10);
        txtDenNgay.setBounds(287, 63, 132, 20);
        panel_3.add(txtDenNgay);

        JLabel lblNewLabel_3 = new JLabel("Đoàn");
        lblNewLabel_3.setBounds(10, 112, 46, 14);
        panel_3.add(lblNewLabel_3);

        txtDoan = new JTextField();
        txtDoan.setEditable(false);
        txtDoan.setBounds(77, 109, 132, 20);
        panel_3.add(txtDoan);
        txtDoan.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("Tiền cọc");
        lblNewLabel_4.setBounds(10, 155, 59, 14);
        panel_3.add(lblNewLabel_4);

        txtCoc = new JTextField();
        txtCoc.setEditable(false);
        txtCoc.setBounds(77, 152, 132, 20);
        panel_3.add(txtCoc);
        txtCoc.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("Số phòng");
        lblNewLabel_5.setBounds(221, 112, 56, 14);
        panel_3.add(lblNewLabel_5);

        txtSoPhong = new JTextField();
        txtSoPhong.setEditable(false);
        txtSoPhong.setBounds(287, 109, 59, 20);
        panel_3.add(txtSoPhong);
        txtSoPhong.setColumns(10);

        JLabel lblNewLabel_6 = new JLabel("Số người");
        lblNewLabel_6.setBounds(221, 155, 56, 14);
        panel_3.add(lblNewLabel_6);

        txtSoNguoi = new JTextField();
        txtSoNguoi.setEditable(false);
        txtSoNguoi.setBounds(287, 152, 59, 20);
        panel_3.add(txtSoNguoi);
        txtSoNguoi.setColumns(10);

        JLabel lblNewLabel_7 = new JLabel("Nam");
        lblNewLabel_7.setBounds(10, 191, 46, 14);
        panel_3.add(lblNewLabel_7);

        txtNam = new JTextField();
        txtNam.setEditable(false);
        txtNam.setBounds(77, 188, 59, 20);
        panel_3.add(txtNam);
        txtNam.setColumns(10);

        JLabel lblNewLabel_8 = new JLabel("Nữ");
        lblNewLabel_8.setBounds(153, 191, 46, 14);
        panel_3.add(lblNewLabel_8);

        txtNu = new JTextField();
        txtNu.setEditable(false);
        txtNu.setBounds(209, 188, 59, 20);
        panel_3.add(txtNu);
        txtNu.setColumns(10);

        JLabel lblNewLabel_9 = new JLabel("Trẻ em");
        lblNewLabel_9.setBounds(302, 191, 46, 14);
        panel_3.add(lblNewLabel_9);

        txtTreEm = new JTextField();
        txtTreEm.setEditable(false);
        txtTreEm.setBounds(354, 188, 59, 20);
        panel_3.add(txtTreEm);
        txtTreEm.setColumns(10);

        panelPhongdat = new JPanel();
        FlowLayout fl_panelPhongdat = (FlowLayout) panelPhongdat.getLayout();
        fl_panelPhongdat.setHgap(10);
        fl_panelPhongdat.setAlignment(FlowLayout.LEFT);
        panelPhongdat.setBounds(10, 216, 480, 20);
        panel_3.add(panelPhongdat);

        JLabel lblNewLabel_10 = new JLabel("Phòng đặt: ");
        panelPhongdat.add(lblNewLabel_10);

        lbPhongDat = new JLabel();
        lbPhongDat.setForeground(Color.GREEN);
        lbPhongDat.setFont(new Font("Tahoma", Font.BOLD, 11));
        panelPhongdat.add(lbPhongDat);

        JPanel panel_4 = new JPanel();
        panel_1.add(panel_4, BorderLayout.CENTER);
        panel_4.setLayout(new BorderLayout(0, 0));

        JLabel lblNewLabel_2 = new JLabel("Chọn Phòng");
        panel_4.add(lblNewLabel_2, BorderLayout.NORTH);

        JScrollPane scrollPane_1 = new JScrollPane();
        panel_4.add(scrollPane_1, BorderLayout.CENTER);

        tbPhong = new JTable();
        scrollPane_1.setViewportView(tbPhong);
        tbPhong.setModel(getModelPhongdat());

        JPanel panel_5 = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel_5.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        panel_4.add(panel_5, BorderLayout.SOUTH);

        JButton btnChon = new JButton("<<  Chọn ");
        btnChon.setActionCommand("Chon");
        panel_5.add(btnChon);
        btnChon.addActionListener(btn);

        JButton btnReset = new JButton("Reset");
        panel_5.add(btnReset);
        btnReset.addActionListener(btn);

        JPanel panel = new JPanel();
        add(panel, BorderLayout.SOUTH);

        JButton btnHuy = new JButton("Hủy đăng kí");
        panel.add(btnHuy);
        btnHuy.addActionListener(btn);

        JButton btnCheckin = new JButton("Check-in");
        panel.add(btnCheckin);
        btnCheckin.addActionListener(btn);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setPreferredSize(new Dimension(500, 150));
        add(scrollPane, BorderLayout.NORTH);
        scrollPane.setViewportView(tb);

        tb.setModel(getModelDK());
        tb.addMouseListener(infoPhong);

    }

    public DefaultTableModel getModelDK() {
        ArrayList<DangKy> listDK = DataStorage.loader.getListDangKy();
        DefaultTableModel dkModel = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                // TODO Auto-generated method stub
                return false;
            }

        };
        dkModel.addColumn("IDDK");
        dkModel.addColumn("Tên KH");
        dkModel.addColumn("Ngày vào");
        dkModel.addColumn("Số Phòng");
        dkModel.addColumn("Số người");
        dkModel.addColumn("Tiền cọc");


        for (DangKy item : listDK) {
            KhachHang k = DataStorage.loader.getKH(item.getId_kh());
            String date = item.getTuNgay().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            if (item.getId() != 0) {
                dkModel.addRow(new String[]{item.getId() + "", k.getHoTen(), date, item.getSoPhong() + "", item.getSoKhach() + "", item.getCoc() + ""});
            }
        }

        return dkModel;
    }

    public DefaultTableModel getModelPhongdat() {
        ArrayList<Phong> listP = DataStorage.loader.getListPhong();
        DefaultTableModel dkModel = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                // TODO Auto-generated method stub
                return false;
            }

        };

        dkModel.addColumn("Phòng");
        dkModel.addColumn("Loại Phòng");


        for (Phong item : listP) {
            if (item.getTrangThai() == 2) {
                String loai = DataStorage.loader.getTenLoai(item.getLoai());
                dkModel.addRow(new String[]{item.getMaPhong(), loai});
            }
        }

        return dkModel;
    }

    MouseListener infoPhong = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int iddk = Integer.parseInt(tb.getValueAt(tb.getSelectedRow(), 0).toString());
            DangKy dk = DataStorage.loader.getDangKy(iddk);
            KhachHang k = DataStorage.loader.getKH(dk.getId_kh());
            txtTen.setText(tb.getValueAt(tb.getSelectedRow(), 1).toString());
            txtNgaydat.setText(dk.getNgayDat().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            txtTuNgay.setText(dk.getTuNgay().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            if (dk.getToiNgay().isAfter(dk.getTuNgay()))
                txtDenNgay.setText(dk.getToiNgay().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            txtDoan.setText(DataStorage.loader.getTenDoan(k.getIdDoan()));
            txtSoPhong.setText(dk.getSoPhong() + "");
            txtSoNguoi.setText(dk.getSoKhach() + "");
            txtTreEm.setText(dk.getTreEm() + "");
            txtNam.setText(dk.getNam() + "");
            txtNu.setText(dk.getNu() + "");

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

    ActionListener btn = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Hủy đăng kí")) {
                int iddk = Integer.parseInt(tb.getValueAt(tb.getSelectedRow(), 0).toString());
                DangKy dk = DataStorage.loader.getDangKy(iddk);
                DataStorage.loader.getListDangKy().remove(dk);
                JOptionPane.showMessageDialog(getRootPane(), "Hủy thành công!");
                reload();
            }
            if (e.getActionCommand().equals("Check-in")) {
                int iddk = Integer.parseInt(tb.getValueAt(tb.getSelectedRow(), 0).toString());
                DangKy dk = DataStorage.loader.getDangKy(iddk);
                KhachHang k = DataStorage.loader.getKH(dk.getId_kh());
                for (Phong p : listChon
                ) {
                    QuanLyPhong ql = new QuanLyPhong(DataStorage.loader.nextIdQL(), iddk, k.getHoTen(), p.getMaPhong(), LocalDate.now(), null, 0, "", 1, k.getId());
                    System.out.println(ql.getId() + "''''''''''" + ql.getId_Dk());
                    DataStorage.loader.getCurrentRoomInfo().add(ql);
                    ChungTu ct = new ChungTu(DataStorage.loader.nextIdCt(), null, 3, k.getId(), MainForm.nv.getiD(), DataStorage.loader.getTenDoan(k.getIdDoan()), dk.getCoc(), 0, "", ql.getId());
                    DataStorage.loader.getListChungTu().add(ct);
                    DataStorage.loader.setSttPhong(p.getMaPhong(), 4);
                    DongChungTu newDvPhongInCt = new DongChungTu(DataStorage.loader.nextDongCT(), ct.getSoCT(), 11, "Phòng ở", 1, p.getDonGia(), "", p.getMaPhong());
                    DataStorage.loader.getListDongCT().add(newDvPhongInCt);
                }
                JOptionPane.showMessageDialog(getRootPane(), "Check-in thành công");
                SoDoPane.s.reloadRoomList();
            }
            if (e.getActionCommand().equals("Chon")) {
                int[] selectedRows = tbPhong.getSelectedRows();
                String dis = "";
                listChon.clear();
                for (int row : selectedRows
                ) {
                    String maPhong = tbPhong.getValueAt(row, 0).toString();
                    Phong p = DataStorage.loader.getPhong(maPhong);
                    listChon.add(p);
                    dis += (maPhong + "   ");
                }
                lbPhongDat.setText(dis);
            }
            if (e.getActionCommand().equals("Reset")) {
                reload();
            }
        }
    };

    public void reload() {
        tb.setModel(new DefaultTableModel());
        tbPhong.setModel(new DefaultTableModel());
        txtTen.setText("");
        txtNgaydat.setText("");
        txtTuNgay.setText("");
        txtDenNgay.setText("");
        txtDoan.setText("");
        txtSoPhong.setText("");
        txtSoNguoi.setText("");
        txtTreEm.setText("");
        txtNam.setText("");
        txtNu.setText("");
        tb.setModel(getModelDK());
        tbPhong.setModel(getModelPhongdat());
        lbPhongDat.setText("");
    }
}
