package the.View;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
import the.DTO.DataStorage;
import the.Model.*;
import the.DTO.DatabaseConnection;
import the.View.Control.QLKhachHang;
import the.View.Control.SoDoPane;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Hashtable;

public class ProfileDialog extends JDialog {
    public static int EDIT = 1;
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTree tree1;
    private JTabbedPane tabbedPane1;
    private JButton btnQl;
    private JPanel leftPane;
    private JTextField txtPhong;
    private JTextField txtLoai;
    private JTextField txtGia;
    private JTextField txtTrangthai;
    private JTextField txtTen;
    private JTextField txtCMND;
    private JTextField txtQuocTich;
    private JButton btnEdit;
    private JCheckBox cbGen;
    private JTextField txtDonVi;
    private JButton btnQLKH;
    private JTextField txtCheckin;
    private JTextField txtMaDoan;
    private JComboBox cbLoai;
    private JButton btnThem;
    private JButton btnCheckout;
    private JButton btnInHD;
    private JTable table1;

    public JTable getTable1() {
        return table1;
    }

    private JButton btnHuyEdit;
    private JButton btnOk;
    private ArrayList<Phong> listPhong = DataStorage.loader.getListPhong();
    private ArrayList<LoaiPhong> listLoai = DataStorage.loader.getListLoaiPhong();
    private ArrayList<DefaultMutableTreeNode> listLeaf = new ArrayList<>();
    private ArrayList<QuanLyPhong> listRoomInfo = DataStorage.loader.getCurrentRoomInfo();
    private String selectedRoom = "";
    private int current_idQL = 0;
    public static float VAT = 1.1f;
    public static ProfileDialog p;

    public String getSelectedRoom() {
        return selectedRoom;
    }

    public void setSelectedRoom(String selectedRoom) {
        this.selectedRoom = selectedRoom;
    }


    public ProfileDialog() {
        p = this;
        int tang = DataStorage.loader.getSoTang();
        DefaultMutableTreeNode node = new DefaultMutableTreeNode("Danh Sách phòng");
        for (int i = 0; i <= tang; i++) {
            DefaultMutableTreeNode nodeTang = new DefaultMutableTreeNode("Tầng " + i);
            for (Phong p : listPhong
            ) {
                DefaultMutableTreeNode leaf = new DefaultMutableTreeNode("Phòng " + p.getMaPhong());
                if (p.getTang() == i) {
                    nodeTang.add(leaf);
                    listLeaf.add(leaf);
                }
            }
            node.add(nodeTang);
        }

        DefaultTreeModel treeModel = new DefaultTreeModel(node);
        tree1.setModel(treeModel);
        tree1.addTreeSelectionListener(tsl);
        btnOk.setVisible(false);
        btnHuyEdit.setVisible(false);

        initGUI();
    }

    public ProfileDialog(String maPhong, int edit) {
        int tang = new DatabaseConnection().getSoTang();
        DefaultMutableTreeNode node = new DefaultMutableTreeNode("Danh Sách phòng");
        for (int i = 0; i <= tang; i++) {
            DefaultMutableTreeNode nodeTang = new DefaultMutableTreeNode("Tầng " + i);
            for (Phong p : listPhong
            ) {
                DefaultMutableTreeNode leaf = new DefaultMutableTreeNode("Phòng " + p.getMaPhong());
                if (p.getTang() == i) {
                    nodeTang.add(leaf);
                    listLeaf.add(leaf);
                }

            }
            node.add(nodeTang);
        }

        DefaultTreeModel treeModel = new DefaultTreeModel(node);
        tree1.setModel(treeModel);
        tree1.addTreeSelectionListener(tsl);
        for (DefaultMutableTreeNode n : listLeaf
        ) {
            String s = n.getUserObject().toString();
            if (s.contains(maPhong)) {
                TreeNode[] nodes = treeModel.getPathToRoot(n);
                TreePath path = new TreePath(nodes);
                tree1.setExpandsSelectedPaths(true);
                tree1.setSelectionPath(path);
            }
        }
        txtTen.setEditable(true);
        txtCheckin.setEditable(true);
        txtCMND.setEditable(true);
        txtDonVi.setEditable(true);
        txtMaDoan.setEditable(true);
        txtQuocTich.setEditable(true);
        cbLoai.setEnabled(true);
        btnEdit.setVisible(false);
        btnOk.setVisible(true);
        btnHuyEdit.setVisible(true);
        cbGen.setEnabled(true);
        initGUI();
    }

    public void initGUI() {
        setContentPane(contentPane);
        setModal(false);
        setTitle("Hồ sơ phòng");
        getRootPane().setDefaultButton(buttonOK);
        setSize(960, 690);
        setResizable(false);
        setLocationRelativeTo(null);
        setPreferredSize(new Dimension(960, 690));
        btnQLKH.addActionListener(btn);
        btnQl.addActionListener(btn);
        if(LoginForm.accessRight!=0){
            btnQl.setEnabled(false);
            btnQLKH.setEnabled(false);
        }

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        leftPane.setPreferredSize(new Dimension(200, 500));
        tabbedPane1.setSelectedIndex(3);


        btnCheckout.addActionListener(btn);
        btnThem.addActionListener(btn);
        btnEdit.addActionListener(btn);
        btnOk.addActionListener(btn);
        btnHuyEdit.addActionListener(btn);
        btnInHD.addActionListener(btn);
        pack();
        setVisible(true);
    }

    private void onOK() {
        MainForm.m.setEnabled(true);
        dispose();
    }

    private void onCancel() {
        MainForm.m.setEnabled(true);
        dispose();
    }


    public void reload() {
        table1.setModel(new DefaultTableModel());
        txtTen.setText("");
        txtCheckin.setText("");
        txtCMND.setText("");
        txtDonVi.setText("");
        txtQuocTich.setText("");
        txtMaDoan.setText("");
        txtPhong.setText("");
        txtGia.setText("");
        setTitle("Hồ sơ phòng");
        txtLoai.setText("");
        txtTrangthai.setText("");
    }

    private final TreeSelectionListener tsl = new TreeSelectionListener() {
        @Override
        public void valueChanged(TreeSelectionEvent e) {
            reload();
            DefaultMutableTreeNode temp = (DefaultMutableTreeNode) tree1.getLastSelectedPathComponent();

            if (temp.isLeaf()) {
                String maPhong = (temp + "").substring(6, 9);
                selectedRoom = maPhong;
                for (Phong p : listPhong
                ) {
                    if (maPhong.equals(p.getMaPhong())) {
                        txtPhong.setText(maPhong);
                        txtGia.setText(p.getDonGia() + "");
                        setTitle("Phòng " + maPhong + "-- Hồ sơ");
                        txtLoai.setText(loai(p.getLoai()));
                        txtTrangthai.setText(tragThai(p.getTrangThai()));
                    }
                }
                for (QuanLyPhong ql : listRoomInfo) {
                    if (ql.getMaPhong().equals(maPhong)) {
                        KhachHang kh = DataStorage.loader.getKH(ql.getId_KH());
                        table1.setModel(MainForm.m.getRoomInfoModel(ql.getId()));
                        txtTen.setText(ql.getHoTen());
                        txtCheckin.setText(ql.getCI().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                        txtCMND.setText(kh.getcMND());
                        txtDonVi.setText(kh.getDonVi());
                        txtQuocTich.setText(kh.getQuocTich());
                        txtMaDoan.setText(kh.getIdDoan() + "");
                        current_idQL = ql.getId();
                        break;
                    }
                    current_idQL = 0;
                }
                System.out.println(current_idQL);
            }

        }
    };

    public String loai(int s) {
        String loai = "";
        for (LoaiPhong l : listLoai
        ) {
            if (l.getId() == s) loai = l.getTenLoai();
        }
        return loai;
    }

    public String tragThai(int s) {
        String stat = "";
        switch (s) {
            case 0: {
                stat = "Trống";
                break;
            }
            case 1: {
                stat = "Dơ";
                break;
            }
            case 2: {
                stat = "Đặt trước";
                break;
            }
            case 3: {
                stat = "Bảo trì";
                break;
            }
            case 4: {
                stat = "Đang sử dụng";
                break;
            }
            case 5: {
                stat = "Đoàn";
                break;
            }
        }
        return stat;
    }

    private final ActionListener btn = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Chỉnh sửa")) {
                txtTen.setEditable(true);
                txtCheckin.setEditable(true);
                txtCMND.setEditable(true);
                txtDonVi.setEditable(true);
                txtMaDoan.setEditable(true);
                txtQuocTich.setEditable(true);
                cbLoai.setEnabled(true);
                btnEdit.setVisible(false);
                btnOk.setVisible(true);
                btnHuyEdit.setVisible(true);
                cbGen.setEnabled(true);
            }
            if (e.getActionCommand().equals("Ok")) {

                String checkDate = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
                for (QuanLyPhong ql : DataStorage.loader.getCurrentRoomInfo()) {
                    if (ql.getMaPhong().equals(selectedRoom)) {
                        if (txtCheckin.getText().matches(checkDate)) {
                            ql.setCI(LocalDate.parse(txtCheckin.getText(), DateTimeFormatter.ofPattern("d/M/yyyy")));
                            for (KhachHang k : DataStorage.loader.getListKH()
                            ) {
                                if (k.getId() == ql.getId_KH()) {
                                    k.setHoTen(txtTen.getText());
                                    k.setGioiTinh(cbGen.isSelected() ? 1 : 0);
                                    k.setcMND(txtCMND.getText());
                                    k.setDonVi(txtDonVi.getText());
                                    k.setIdDoan(Integer.parseInt(txtMaDoan.getText()));
                                    k.setLoai(cbLoai.getSelectedIndex());
                                    k.setQuocTich(txtQuocTich.getText());
                                    System.out.println(k.getHoTen());
                                }
                            }
                            txtTen.setEditable(false);
                            txtCheckin.setEditable(false);
                            txtCMND.setEditable(false);
                            txtDonVi.setEditable(false);
                            txtMaDoan.setEditable(false);
                            txtQuocTich.setEditable(false);
                            cbLoai.setEnabled(false);
                            btnEdit.setVisible(true);
                            btnOk.setVisible(false);
                            btnHuyEdit.setVisible(false);
                            cbGen.setEnabled(false);
                        } else {
                            JOptionPane.showMessageDialog(getRootPane(), "Nhập ngày theo định dạng d/M/yyyy");
                        }

                    }
                }

            }
            if (e.getActionCommand().equals("Hủy")) {
                txtTen.setEditable(false);
                txtCheckin.setEditable(false);
                txtCMND.setEditable(false);
                txtDonVi.setEditable(false);
                txtMaDoan.setEditable(false);
                txtQuocTich.setEditable(false);
                cbLoai.setEnabled(false);
                btnEdit.setVisible(true);
                btnOk.setVisible(false);
                btnHuyEdit.setVisible(false);
                cbGen.setEnabled(false);


                for (QuanLyPhong ql : listRoomInfo) {
                    if (ql.getMaPhong().equals(selectedRoom)) {
                        KhachHang kh = DataStorage.loader.getKH(ql.getId_KH());
                        txtTen.setText(ql.getHoTen());
                        txtCheckin.setText(ql.getCI().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                        txtCMND.setText(kh.getcMND());
                        txtDonVi.setText(kh.getDonVi());
                        txtQuocTich.setText(kh.getQuocTich());
                        txtMaDoan.setText(kh.getIdDoan() + "");
                        current_idQL = ql.getId();
                    }
                }
            }
            if (e.getActionCommand().equals("Thêm DV")) {
                new AddServiceDialog(current_idQL);
            }
            if (e.getActionCommand().equals("CheckOut")) {
                if (DataStorage.loader.checkSttPhong(selectedRoom) == 4 || DataStorage.loader.checkSttPhong(selectedRoom) == 5) {
                    ArrayList<DongChungTu> listDongChungTu = DataStorage.loader.getListDongCT(current_idQL);
                    float sum = 0;
                    for (DongChungTu item : listDongChungTu) {
                        sum += (item.getDonGia() * item.getSoLuong());
                    }
                    int rs = JOptionPane.showConfirmDialog(getRootPane(), "Tổng tiền phòng (Chưa VAT): " + sum + "đ\nBạn có muốn xuất hóa đơn?", "Confirm", JOptionPane.YES_NO_OPTION);
                    if (rs == 1) {
                        DataStorage.loader.setCheckoutInfo(current_idQL, sum);
                        DataStorage.loader.setSttPhong(selectedRoom, 1);
                        SoDoPane.s.reloadRoomList();
                    } else {
                        DataStorage.loader.setCheckoutInfo(current_idQL, sum * VAT);
                        DataStorage.loader.setSttPhong(selectedRoom, 1);
                        SoDoPane.s.reloadRoomList();
                        xuatHoaDon(1, 500000f);

                    }

                }
            }
            if (e.getActionCommand().equals("In HD")) {
                if (DataStorage.loader.checkSttPhong(selectedRoom) == 4 || DataStorage.loader.checkSttPhong(selectedRoom) == 5) {
                    xuatHoaDon(1, 500000f);
                }
//				System.out.println(System.getProperty("java.class.path").replace(':','\n'));
            }
            if(e.getActionCommand().equals("Quản lý Khách Hàng")){
                QLKhachHang khPane = new QLKhachHang();
                MainForm.m.getTabbedPane().addTab("qlkh", null, khPane, null);
                MainForm.m.getTabbedPane().setTabComponentAt(MainForm.m.getTabbedPane().indexOfComponent(khPane), MainForm.m.getTitlePanel(MainForm.m.getTabbedPane(), khPane, "Quản lý Khách hàng"));
                MainForm.m.getTabbedPane().setSelectedComponent(khPane);
                MainForm.m.setEnabled(true);
                dispose();
            }
        }
    };

    public void xuatHoaDon(int soct, float tong) {
        String path = "D:\\Workspace\\Java\\Project_QLKS_java\\src\\the\\Report\\HoaDon.jrxml";
        Connection conn = new DatabaseConnection().getConn();
        Hashtable<String, Object> map = new Hashtable();
        map.put("soct", soct);
        map.put("sum", tong);
        try {
            JasperReport rp = JasperCompileManager.compileReport(path);
            JasperPrint pr = JasperFillManager.fillReport(rp, map, conn);
            JasperViewer viewer = new JasperViewer(pr, false);
            //JasperViewer.viewReport(pr,false);
            viewer.setVisible(true);
            viewer.toFront();
            viewer.setEnabled(true);
        } catch (JRException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ProfileDialog("107", 1);

    }

}
