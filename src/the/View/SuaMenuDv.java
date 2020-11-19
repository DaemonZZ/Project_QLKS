package the.View;

import the.DTO.DataStorage;
import the.Model.DichVu;
import the.View.Control.QLDichVu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class SuaMenuDv extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtTenDV;
    private JTextField txtDVT;
    private JTextField txtDonGia;
    private JTextField txtGhiChu;
    private JTextField txtID;
    private boolean edit = false;
    public SuaMenuDv() {
        txtID.setText( DataStorage.loader.nextDichVu()+"");
        initGUI();
    }
    public SuaMenuDv(DichVu dichVu){
        txtID.setText(dichVu.getiD()+"");
        txtTenDV.setText(dichVu.getTenDV());
        txtDVT.setText(dichVu.getDonViTinh());
        txtGhiChu.setText(dichVu.getGhiChu());
        txtDonGia.setText(dichVu.getDonGIa()+"");
        edit=true;
        initGUI();
    }

    public void initGUI(){
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

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
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }


    private void onOK() {
        boolean b =true;
        if(edit){
            DichVu old =new DichVu();
            DichVu dv = new DichVu(Integer.parseInt(txtID.getText()),txtTenDV.getText(),txtDVT.getText(),Float.parseFloat(txtDonGia.getText()),txtGhiChu.getText(),3,0,0);
            for (DichVu d: DataStorage.loader.getListDV()
                 ) {
                if(d.getiD()==dv.getiD()) old=d;
                }
            DataStorage.loader.getListDV().remove(old);
            for (DichVu d: DataStorage.loader.getListDV()
            ) {
                if(dv.getTenDV()==""||d.getTenDV().equals(dv.getTenDV())){
                    b=false;
                    JOptionPane.showMessageDialog(getRootPane(),"Tên Dv đã tồn tại hoặc không hợp lệ");
                }
            }

            if(b){
                DataStorage.loader.getListDV().add(dv);
                QLDichVu.q.getTable().setModel(new DefaultTableModel());
                QLDichVu.q.getTable().setModel(QLDichVu.q.getDvModel());
            }
            MainForm.m.setEnabled(true);
            dispose();

        }
        else {
            DichVu dv = new DichVu(Integer.parseInt(txtID.getText()),txtTenDV.getText(),txtDVT.getText(),Float.parseFloat(txtDonGia.getText()),txtGhiChu.getText(),3,0,0);
            for (DichVu d: DataStorage.loader.getListDV()
                 ) {
                if(dv.getTenDV()==""||d.getTenDV().equals(dv.getTenDV())){
                    b=false;
                    JOptionPane.showMessageDialog(getRootPane(),"Tên Dv đã tồn tại hoặc không hợp lệ");
                }
            }

            if(b){
                DataStorage.loader.getListDV().add(dv);
                QLDichVu.q.getTable().setModel(new DefaultTableModel());
                QLDichVu.q.getTable().setModel(QLDichVu.q.getDvModel());
            }

        }
        MainForm.m.setEnabled(true);
        dispose();
    }

    private void onCancel() {
        MainForm.m.setEnabled(true);
        dispose();
    }
}
