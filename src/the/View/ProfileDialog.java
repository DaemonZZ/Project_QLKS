package the.View;

import the.DataTransfer.LoaiPhong;
import the.DataTransfer.Phong;
import the.DataTransfer.QuanLyPhong;
import the.Model.DatabaseConnection;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.QuadCurve2D;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProfileDialog extends JDialog {
    static int EDIT=1;
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTree tree1;
    private JTabbedPane tabbedPane1;
    private JButton btnapp;
    private JButton btnQl;
    private JPanel leftPane;
    private JTextField txtPhong;
    private JTextField txtLoai;
    private JTextField txtGia;
    private JTextField txtTrangthai;
    private JTextField txtTen;
    private JTextField txtCMND;
    private JTextField txtQuocTich;
    private JButton chỉnhSửaButton;
    private JCheckBox cbGen;
    private JTextField txtDonVi;
    private JButton btnQLKH;
    private JTextField txtCheckin;
    private JTextField txtMaDoan;
    private JLabel lbPhong;
    private JComboBox cbLoai;
    private DatabaseConnection dtb = new DatabaseConnection();
    private ArrayList<Phong> listPhong = dtb.getListPhong();
    private ArrayList<LoaiPhong> listLoai =dtb.getListLoaiPhong();
    private ArrayList<DefaultMutableTreeNode> listLeaf = new ArrayList<>();
    private ArrayList<QuanLyPhong> listRoomInfo = dtb.getCurrentRoomInfo();



    public ProfileDialog() {
        int tang = dtb.getSoTang();
        DefaultMutableTreeNode node = new DefaultMutableTreeNode("Danh Sách phòng");
        for(int i=0;i<=tang;i++){
            DefaultMutableTreeNode nodeTang = new DefaultMutableTreeNode("Tầng "+i);
            for (Phong p: listPhong
            ) {
                DefaultMutableTreeNode leaf = new DefaultMutableTreeNode("Phòng "+p.getMaPhong());
                if(p.getTang()==i) {
                    nodeTang.add(leaf);
                    listLeaf.add(leaf);
                }

            }
            node.add(nodeTang);
        }

        DefaultTreeModel treeModel = new DefaultTreeModel(node);
        tree1.setModel(treeModel);
        tree1.addTreeSelectionListener(tsl);
       initGUI();
    }
    public ProfileDialog(String maPhong,int edit){
        int tang = new DatabaseConnection().getSoTang();
        DefaultMutableTreeNode node = new DefaultMutableTreeNode("Danh Sách phòng");
        for(int i=0;i<=tang;i++){
            DefaultMutableTreeNode nodeTang = new DefaultMutableTreeNode("Tầng "+i);
            for (Phong p: listPhong
            ) {
                DefaultMutableTreeNode leaf = new DefaultMutableTreeNode("Phòng "+p.getMaPhong());
                if(p.getTang()==i) {
                    nodeTang.add(leaf);
                    listLeaf.add(leaf);
                }

            }
            node.add(nodeTang);
        }

        DefaultTreeModel treeModel = new DefaultTreeModel(node);
        tree1.setModel(treeModel);
        tree1.addTreeSelectionListener(tsl);
        for (DefaultMutableTreeNode n: listLeaf
             ) {
           String s =n.getUserObject().toString();
           if(s.contains(maPhong)){
               TreeNode[] nodes = treeModel.getPathToRoot(n);
               TreePath path = new TreePath(nodes);
               tree1.setExpandsSelectedPaths(true);
               tree1.setSelectionPath(path);
           }
        }
        initGUI();
    }

    public void initGUI(){
        setContentPane(contentPane);
        setModal(true);
        setTitle("Hồ sơ phòng");
        getRootPane().setDefaultButton(buttonOK);
        setSize(960,690);
        setResizable(false);
        setLocationRelativeTo(null);
        setPreferredSize(new Dimension(960,690));

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

        leftPane.setPreferredSize(new Dimension(200,500));



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

    private void onChinhSua(){

    }


    private TreeSelectionListener tsl = new TreeSelectionListener() {
        @Override
        public void valueChanged(TreeSelectionEvent e) {
            DefaultMutableTreeNode temp = (DefaultMutableTreeNode) tree1.getLastSelectedPathComponent();
            if(temp.isLeaf()){
                String maPhong = (temp+"").substring(6,9);
                System.out.println(maPhong);
                for (Phong p: listPhong
                ) {
                    if(maPhong.equals(p.getMaPhong())){
                        lbPhong.setText(maPhong);
                        txtPhong.setText(maPhong);
                        txtGia.setText(p.getDonGia()+"");
                        setTitle("Phòng "+maPhong+"-- Hồ sơ");
                        txtLoai.setText(loai(p.getLoai()));
                        txtTrangthai.setText(tragThai(p.getTrangThai()));
                    }
                }
            }

        }
    };

    public String loai(int s){
        String loai = "";
        for (LoaiPhong l: listLoai
             ) {
            if(l.getId()==s) loai=l.getTenLoai();
        }
        return loai;
    }

    public String tragThai(int s){
        String stat = "";
        switch (s){
            case 0: {
                stat="Trống";
                break;
            }
            case 1: {
                stat="Dơ";
                break;
            }
            case 2: {
                stat="Đặt trước";
                break;
            }
            case 3: {
                stat="Bảo trì";
                break;
            }
            case 4:{
                stat="Đang sử dụng";
                break;
            }
            case 5:{
                stat="Đoàn";
                break;
            }
        }
        return stat;
    }
    public static void main(String[] args) {
        new ProfileDialog("107",1);

    }
}
