package the.View.Control;

import org.codehaus.groovy.tools.shell.Main;
import the.DTO.DataStorage;
import the.Model.ChungTu;
import the.Model.DichVu;
import the.Model.QuanLyPhong;
import the.View.MainForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ChungTuPane extends JLayeredPane {
    private JTable tb;
    JPanel centerPanel, pnHoaDon, pnthietBi, pnDv, pnNhapXuat;
    JTextField txtTim;
    int cmdPn = 1;

    public ChungTuPane() {
        setLayout(new BorderLayout(0, 0));
        JButton btnKH = new JButton("QL Khách hàng");
        btnKH.addActionListener(btn);
        JButton btnHS = new JButton("Hồ sơ phòng");
        btnHS.addActionListener(btn);
        JPanel topMenu = new JPanel();
        FlowLayout fl = new FlowLayout();
        fl.setAlignment(FlowLayout.RIGHT);
        JLabel lb = new JLabel("Tìm: ");
        topMenu.add(lb);
        txtTim = new JTextField(25);
        topMenu.add(txtTim);
        JButton btnSearch = new JButton("Tìm kiếm");
        topMenu.add(btnSearch);
        btnSearch.addActionListener(btn);

        JPanel sideBar = new JPanel();
        add(sideBar, BorderLayout.WEST);
        GridBagLayout gbl_sideBar = new GridBagLayout();
        gbl_sideBar.columnWidths = new int[]{85, 0};
        gbl_sideBar.rowHeights = new int[]{21, 0, 0, 0, 0, 0, 0};
        gbl_sideBar.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gbl_sideBar.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        sideBar.setLayout(gbl_sideBar);

        JButton btnHD = new JButton("Hóa đơn thanh toán");
        btnHD.setBackground(SystemColor.text);
        btnHD.setHorizontalAlignment(SwingConstants.LEFT);
        btnHD.setMargin(new Insets(20, 14, 2, 14));
        btnHD.setIconTextGap(10);
        btnHD.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnHD.setBorder(new EmptyBorder(0, 10, 0, 0));
        btnHD.setAlignmentY(0.0f);
        btnHD.addActionListener(btn);
        GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
        gbc_btnNewButton_3.ipady = 15;
        gbc_btnNewButton_3.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnNewButton_3.gridx = 0;
        gbc_btnNewButton_3.gridy = 0;
        sideBar.add(btnHD, gbc_btnNewButton_3);

        JButton btnNhapXuat = new JButton("Nhập xuất hàng");
        btnNhapXuat.setBackground(SystemColor.inactiveCaptionBorder);
        btnNhapXuat.setHorizontalAlignment(SwingConstants.LEFT);
        btnNhapXuat.setMargin(new Insets(20, 14, 2, 14));
        btnNhapXuat.setIconTextGap(10);
        btnNhapXuat.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnNhapXuat.setBorder(new EmptyBorder(0, 10, 0, 0));
        btnNhapXuat.addActionListener(btn);
        GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
        gbc_btnNewButton_2.ipady = 15;
        gbc_btnNewButton_2.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnNewButton_2.gridx = 0;
        gbc_btnNewButton_2.gridy = 1;
        sideBar.add(btnNhapXuat, gbc_btnNewButton_2);

        JButton btnKhodv = new JButton("Kho dịch vụ");
        btnKhodv.setBackground(SystemColor.inactiveCaptionBorder);
        btnKhodv.setHorizontalAlignment(SwingConstants.LEFT);
        btnKhodv.setMargin(new Insets(20, 14, 2, 14));
        btnKhodv.setIconTextGap(10);
        btnKhodv.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnKhodv.setBorder(new EmptyBorder(0, 10, 0, 0));
        btnKhodv.addActionListener(btn);
        GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
        gbc_btnNewButton_4.ipady = 15;
        gbc_btnNewButton_4.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnNewButton_4.gridx = 0;
        gbc_btnNewButton_4.gridy = 2;
        sideBar.add(btnKhodv, gbc_btnNewButton_4);

        JButton btnKhoTB = new JButton("Kho thiết bị");
        btnKhoTB.setBackground(SystemColor.inactiveCaptionBorder);
        btnKhoTB.setHorizontalAlignment(SwingConstants.LEFT);
        btnKhoTB.setMargin(new Insets(20, 14, 2, 14));
        btnKhoTB.setIconTextGap(10);
        btnKhoTB.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnKhoTB.setBorder(new EmptyBorder(0, 10, 0, 0));
        btnKhoTB.addActionListener(btn);
        GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
        gbc_btnNewButton_5.ipady = 15;
        gbc_btnNewButton_5.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnNewButton_5.gridx = 0;
        gbc_btnNewButton_5.gridy = 3;
        sideBar.add(btnKhoTB, gbc_btnNewButton_5);

        centerPanel = new JPanel();
        add(centerPanel, BorderLayout.CENTER);
        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(topMenu, BorderLayout.NORTH);

        pnthietBi = new JPanel();
        centerPanel.add(pnthietBi, BorderLayout.CENTER);

        pnDv = new JPanel();
        centerPanel.add(pnDv, BorderLayout.CENTER);

        pnNhapXuat = new JPanel();
        centerPanel.add(pnNhapXuat, BorderLayout.CENTER);

        pnHoaDon = new JPanel();
        centerPanel.add(pnHoaDon, BorderLayout.CENTER);
        pnHoaDon.setLayout(new BorderLayout(0, 0));

        JPanel pnbot = new JPanel();
        pnHoaDon.add(pnbot, BorderLayout.SOUTH);

        pnbot.add(btnKH);
        pnbot.add(btnHS);

        JScrollPane scrollPane = new JScrollPane();
        pnHoaDon.add(scrollPane, BorderLayout.CENTER);

        tb = new JTable();
        scrollPane.setViewportView(tb);

        tb.setModel(getHDModel(""));
        tb.addMouseListener(tbClick);


    }

    public void reloadTable(QuanLyPhong ql) {
        MainForm.m.setSum(0);
        MainForm.m.getTable().setModel(new DefaultTableModel());

        CustomerInfoPanel.t.getTxtPhong().setText(MainForm.m.getSelectedRoom());
        CustomerInfoPanel.t.getTxtTenKH().setText("");
        CustomerInfoPanel.t.getTxtCI().setText("");
        CustomerInfoPanel.t.getTxtCO().setText("");

        CustomerInfoPanel.t.getTxtTenKH().setText(DataStorage.loader.getKH(ql.getId_KH()).getHoTen());
        CustomerInfoPanel.t.getTxtCI().setText(ql.getCI().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        CustomerInfoPanel.t.getTxtCO().setText(ql.getCO() + "");
        MainForm.m.getTable().setModel(MainForm.m.getRoomInfoModel(ql.getId()));
        SumPanel.s.getTxtSum().setText(ql.getGia() + "");

    }

     ActionListener btn = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Hóa đơn thanh toán")) {
                cmdPn=1;
                tb.setModel(getHDModel(""));
                MainForm.m.getRightPanel().removeAll();
                MainForm.m.getRightPanel().add(MainForm.m.getSumPanel(),BorderLayout.SOUTH);
                MainForm.m.getRightPanel().add(MainForm.m.getScrollPane(),BorderLayout.CENTER);
                MainForm.m.getRightPanel().add(MainForm.m.getCusInfoPanel(),BorderLayout.NORTH);
                MainForm.m.getRightPanel().repaint();
            }
            if (e.getActionCommand().equals("Nhập xuất hàng")) {
                cmdPn = 2;
                MainForm.m.getRightPanel().removeAll();
                MainForm.m.getRightPanel().repaint();
            }
            if (e.getActionCommand().equals("Kho dịch vụ")) {
                cmdPn = 3;
                MainForm.m.getRightPanel().removeAll();
                MainForm.m.getRightPanel().repaint();
            }
            if (e.getActionCommand().equals("Kho thiết bị")) {
                cmdPn = 4;
                tb.setModel(getTBModel(""));
                MainForm.m.getRightPanel().removeAll();
                MainForm.m.getRightPanel().repaint();
            }
            if(e.getActionCommand().equals("Tìm kiếm")){
                timkiem(cmdPn);
                txtTim.setText("");
            }
        }
    };

    private void timkiem(int cmdPn) {
        if(cmdPn==1){
            DefaultTableModel model = getHDModel(txtTim.getText());
            tb.setModel(model);

        }
        if(cmdPn == 2){
        }
        if(cmdPn == 3){
        }
        if(cmdPn==4){
            DefaultTableModel model = getTBModel(txtTim.getText());
            tb.setModel(model);
        }
    }

    MouseListener tbClick = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if(cmdPn==1){
                int soct = Integer.parseInt(tb.getValueAt(tb.getSelectedRow(), 0).toString());
                QuanLyPhong ql = new QuanLyPhong();
                for (ChungTu ct : DataStorage.loader.getListChungTu()
                ) {
                    if (ct.getSoCT() == soct) {
                        ql = DataStorage.loader.getQL(ct.getId_QL());
                    }
                }
                reloadTable(ql);
            }
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

    private DefaultTableModel getTBModel(String name) {
        ArrayList<DichVu> listTb = DataStorage.loader.getListTenTB();

        String[] row = new String[5];
        DefaultTableModel model = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                // TODO Auto-generated method stub
                return false;
            }

        };
        model.addColumn("Tên TB");
        model.addColumn("DVT");
        model.addColumn("Số lượng");
        model.addColumn("Đơn giá");
        model.addColumn("Ghi chú");

        for (DichVu c: listTb
             ) {
            if(c.getTenDV().contains(name)){
                row[0] = c.getTenDV();
                row[1]= c.getDonViTinh();
                row[2] = DataStorage.loader.getSoLuongTB(c.getiD())+"";
                row[3] = c.getDonGIa()+"";
                row[4] = c.getGhiChu();
                model.addRow(row);
            }
        }
        return model;
    }

    private DefaultTableModel getHDModel(String name) {
        ArrayList<ChungTu> listCT = DataStorage.loader.getListChungTu();
        String[] row = new String[4];
        DefaultTableModel model = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                // TODO Auto-generated method stub
                return false;
            }

        };
        model.addColumn("Số CT");
        model.addColumn("Khách hàng");
        model.addColumn("Nội dung");
        model.addColumn("Nhân viên");

        for (ChungTu c : listCT
        ) {
            String kh = DataStorage.loader.getKH(c.getId_KH()).getHoTen();
            if (c.getLoai() == 3 && kh.contains(name)) {
                String nv = DataStorage.loader.getNhanVien(c.getId_NV()).getHoTen();
                row[0] = c.getSoCT() + "";
                row[1] = kh;
                row[2] = c.getNoiDung();
                row[3] = nv;
                model.addRow(row);
            }
        }
        return model;
    }
}
