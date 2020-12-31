package the.View.Control;

import the.DTO.DataStorage;
import the.Model.DichVu;
import the.View.MainForm;
import the.View.SuaMenuDv;

import javax.swing.JLayeredPane;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class QLDichVu extends JLayeredPane {
    private JTable table;

    public JTable getTable() {
        return table;
    }

    private DefaultTableModel model = getDvModel();
    public static QLDichVu q;

    public QLDichVu() {
        setLayout(new BorderLayout(0, 0));
        q = this;
        JPanel panel = new JPanel();
        add(panel, BorderLayout.EAST);
        panel.setLayout(new BorderLayout(0, 0));

        JPanel btnPanel = new JPanel();
        panel.add(btnPanel, BorderLayout.SOUTH);
        btnPanel.setLayout(new GridLayout(0, 1, 0, 4));

        JButton btnAdd = new JButton("Thêm DV");
        btnPanel.add(btnAdd);
        btnAdd.addActionListener(btn);

        JButton btnEdit = new JButton("Sửa DV");
        btnPanel.add(btnEdit);
        btnEdit.addActionListener(btn);

        JButton btnDel = new JButton("Xóa DV");
        btnPanel.add(btnDel);
        btnDel.addActionListener(btn);

        JScrollPane scrollPane = new JScrollPane();
        add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        scrollPane.setViewportView(table);
        table.setModel(model);
        table.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
    }

    public DefaultTableModel getDvModel() {
        ArrayList<DichVu> listDV = DataStorage.loader.getListDV();
        DefaultTableModel dvModel = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        dvModel.addColumn("Tên DV");
        dvModel.addColumn("Đv Tính");
        dvModel.addColumn("Đơn Giá");
        dvModel.addColumn("Ghi Chú");


        for (DichVu item : listDV) {
            dvModel.addRow(new String[]{item.getTenDV(), item.getDonViTinh(), item.getDonGIa() + "đ", item.getGhiChu()});
        }
        return dvModel;
    }

    private ActionListener btn = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Thêm DV")) {
                MainForm.m.setEnabled(false);
                new SuaMenuDv();
            }
            if (e.getActionCommand().equals("Sửa DV")) {
                String selected = table.getValueAt(table.getSelectedRow(), 0).toString();
                DichVu DV = new DichVu();
                for (DichVu d : DataStorage.loader.getListDV()
                ) {
                    if (d.getTenDV().equals(selected)) DV = d;
                }
                MainForm.m.setEnabled(false);
                new SuaMenuDv(DV);


            }
            if (e.getActionCommand().equals("Xóa DV")) {

            }
        }
    };

}
