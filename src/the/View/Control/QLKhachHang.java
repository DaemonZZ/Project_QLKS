package the.View.Control;

import org.codehaus.groovy.tools.groovydoc.Main;
import the.DTO.DataStorage;
import the.Model.DichVu;
import the.Model.KhachHang;
import the.Model.QuanLyPhong;
import the.View.MainForm;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class QLKhachHang extends JLayeredPane {
    private JTable table;
    private JTextField txtID;
    private JTextField txtTen;
    private JComboBox cbGen;
    private JTextField txtDonVi;
    private JTextField txtCMND;
    private JTextField txtNgayCap;
    private JTextField txtNoiCap;
    private JComboBox cbLoai;
    private JTextField txtQuocTich;
    private JPanel panel;
    private JButton btnOK;
    private JButton btnCancel;
    private KhachHang selectedKH;
    private JFrame input;

    public QLKhachHang() {
        setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        add(panel, BorderLayout.EAST);
        panel.setLayout(new BorderLayout(0, 0));

        JPanel btnPanel = new JPanel();
        panel.add(btnPanel, BorderLayout.SOUTH);
        btnPanel.setLayout(new GridLayout(0, 1, 0, 4));

        JButton btnAdd = new JButton("Thêm KH");
        btnPanel.add(btnAdd);
        btnAdd.addActionListener(btn);

        JButton btnEdit = new JButton("Sửa KH");
        btnPanel.add(btnEdit);
        btnEdit.addActionListener(btn);

        JButton btnDel = new JButton("Xóa KH");
        btnPanel.add(btnDel);
        btnDel.addActionListener(btn);

        JScrollPane scrollPane = new JScrollPane();
        add(scrollPane, BorderLayout.CENTER);
        MainForm.m.getCbCI().addItemListener(listenerForCbCI);

        table = new JTable();
        scrollPane.setViewportView(table);
        table.setModel(getKhModel());
        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MainForm.m.getTbDichVu().setModel(new DefaultTableModel());
                int idkh = Integer.parseInt((String)table.getValueAt(table.getSelectedRow(),0));
                DefaultComboBoxModel<QuanLyPhong> model = new DefaultComboBoxModel();
                for (QuanLyPhong q: DataStorage.loader.getListAllQLP()
                     ) {
                    if(q.getId_KH()==idkh) {
                        model.addElement(q);
                    }
                }

                MainForm.m.getCbCI().setModel(model);
                MainForm.m.getTxtTen().setText(table.getValueAt(table.getSelectedRow(),1).toString());
                QuanLyPhong ql =(QuanLyPhong) MainForm.m.getCbCI().getSelectedItem();
                MainForm.m.getTxtCO().setText(ql.getCO().toString());
                MainForm.m.getTxtSum().setText(ql.getGia()+"");
                MainForm.m.getTxtPhong().setText(ql.getMaPhong());
                MainForm.m.getTbDichVu().setModel(MainForm.m.getRoomInfoModel(ql.getId()));
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
        });

        btnCancel.addActionListener(btn);
        btnOK.addActionListener(btn);
    }

    public DefaultTableModel getKhModel(){
        ArrayList<KhachHang> listKH = DataStorage.loader.getListKH();
        DefaultTableModel khModel = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        khModel.addColumn("ID");
        khModel.addColumn("Họ và tên");
        khModel.addColumn("Giới tính");
        khModel.addColumn("Đơn vị");
        khModel.addColumn("CMND");
        khModel.addColumn("Ngày cấp");
        khModel.addColumn("Nơi cấp");
        khModel.addColumn("Loại");
        khModel.addColumn("Quốc tịch");


        for (KhachHang item : listKH) {
            khModel.addRow(new String[] {item.getId()+"",item.getHoTen(), item.getGioiTinh()==0?"Nữ":"Nam",
                    item.getDonVi(),item.getcMND(),item.getNgayCap(),item.getNoiCap(),
                    item.getLoai()==0?"Khách lẻ":(item.getLoai()==1?"Khách Công ty":"Nhà cung cấp"),item.getQuocTich()});
        }
        return khModel;
    }
    private ItemListener listenerForCbCI = new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent e) {
            QuanLyPhong ql = (QuanLyPhong)e.getItem();
            if(ql.getCO()!=null) MainForm.m.getTxtCO().setText(ql.getCO().toString());
            MainForm.m.getTxtPhong().setText(ql.getMaPhong());
            MainForm.m.getTxtSum().setText(ql.getGia()+"");

        }
    };
    public void editKHForm(){
        input = new JFrame();
        input.add(panel);
        input.pack();
        input.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                MainForm.m.setEnabled(true);
                input.dispose();
            }
        });
        input.setLocationRelativeTo(null);
        input.setVisible(true);
    }
    private ActionListener btn = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Thêm KH")){
                txtID.setText(DataStorage.loader.nextKH()+"");
                MainForm.m.setEnabled(false);
                editKHForm();
            }
            if(e.getActionCommand().equals("Sửa KH")){
                int idkh = Integer.parseInt((String)table.getValueAt(table.getSelectedRow(),0));
                KhachHang old = new KhachHang();
                for (KhachHang k: DataStorage.loader.getListKH()
                     ) {
                    if(k.getId()==idkh) old = k;
                }
                selectedKH=old;
                txtID.setText(old.getId()+"");
                txtTen.setText(old.getHoTen());
                cbGen.setSelectedIndex(old.getGioiTinh());
                txtCMND.setText(old.getcMND());
                txtNoiCap.setText(old.getNgayCap());
                txtNgayCap.setText(old.getNgayCap());
                cbLoai.setSelectedIndex(old.getLoai());
                txtDonVi.setText(old.getDonVi());
                txtQuocTich.setText(old.getQuocTich());
                MainForm.m.setEnabled(false);
                editKHForm();
            }
            if(e.getActionCommand().equals("Xóa KH")){
                int idkh = Integer.parseInt((String)table.getValueAt(table.getSelectedRow(),0));
                KhachHang old = new KhachHang();
                for (KhachHang k: DataStorage.loader.getListKH()
                ) {
                    if(k.getId()==idkh) old = k;
                }
                DataStorage.loader.getListKH().remove(old);
                table.setModel(new DefaultTableModel());
                table.setModel(getKhModel());
            }

            if(e.getActionCommand().equals("OK")){
                if(txtTen.getText()!=""){
                    int max = DataStorage.loader.nextKH() -1;
                    KhachHang k = new KhachHang();
                    k.setId(Integer.parseInt(txtID.getText()));
                    k.setHoTen(txtTen.getText());
                    k.setGioiTinh(cbGen.getSelectedIndex());
                    k.setcMND(txtCMND.getText());
                    k.setNgayCap(txtNgayCap.getText());
                    k.setNoiCap(txtNoiCap.getText());
                    k.setLoai(cbLoai.getSelectedIndex());
                    k.setQuocTich(txtQuocTich.getText());
                    if(k.getId()>max) DataStorage.loader.getListKH().add(k);
                    else{
                        DataStorage.loader.getListKH().remove(selectedKH);
                        DataStorage.loader.getListKH().add(k);
                    }
                    table.setModel(new DefaultTableModel());
                    table.setModel(getKhModel());
                    MainForm.m.setEnabled(true);
                    input.dispose();
                } else {
                    JOptionPane.showMessageDialog(getRootPane(),"Tên khách hàng trống");
                }

            }
            if(e.getActionCommand().equals("Cancel")){
                MainForm.m.setEnabled(true);
                input.dispose();
            }
        }
    };
}
