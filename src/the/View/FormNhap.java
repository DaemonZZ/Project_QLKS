package the.View;

import the.DTO.DataStorage;
import the.Model.DichVu;
import the.Model.KhachHang;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class FormNhap extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox cbLoai;
    private JTable tb;
    private JComboBox cbTen;
    private JTextField txtDiaChi;
    private JTextField txtMatHang;
    private JButton btnNewKH;
    private JButton btnAdd;
    private ArrayList<DichVu> listNhap;

    public JTable getTb() {
        return tb;
    }

    public JComboBox getCbTen() {
        return cbTen;
    }

    public ArrayList<DichVu> getListNhap() {
        return listNhap;
    }

    public FormNhap() {
        setContentPane(contentPane);
        setModal(false);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Nhập hàng");

        cbTen.setModel(getCbModel());
        cbTen.setSelectedIndex(-1);
        cbTen.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                KhachHang k = (KhachHang) e.getItem();
                txtDiaChi.setText(k.getDonVi());
                txtMatHang.setText(k.getQuocTich());
            }
        });

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

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FormHH();
            }
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public DefaultComboBoxModel<KhachHang> getCbModel(){
        DefaultComboBoxModel<KhachHang> cbModel = new DefaultComboBoxModel<>();
        for (KhachHang k: DataStorage.loader.getListKH()
             ) {
            if(k.getLoai()==2) cbModel.addElement(k);
        }

        return cbModel;
    }

    public static void main(String[] args) {
        new DataStorage(0);
        new FormNhap();
    }


}
