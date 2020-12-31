package the.View.Control;

import the.DTO.DataStorage;
import the.Model.DichVu;
import the.Model.Phong;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class QLPhong extends JLayeredPane {
    private JTable table;

    public QLPhong() {
        setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        add(panel, BorderLayout.EAST);
        panel.setLayout(new BorderLayout(0, 0));

        JPanel btnPanel = new JPanel();
        panel.add(btnPanel, BorderLayout.SOUTH);
        btnPanel.setLayout(new GridLayout(0, 1, 0, 4));

        JButton btnAdd = new JButton("Thêm");
        btnPanel.add(btnAdd);

        JButton btnEdit = new JButton("Sửa");
        btnPanel.add(btnEdit);

        JButton btnDel = new JButton("Xóa");
        btnPanel.add(btnDel);

        JScrollPane scrollPane = new JScrollPane();
        add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        table.setModel(getModelPhong());
        scrollPane.setViewportView(table);
    }

    public DefaultTableModel getModelPhong() {
        ArrayList<Phong> listPhong = DataStorage.loader.getListPhong();
        DefaultTableModel dvModel = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        dvModel.addColumn("Mã Phòng");
        dvModel.addColumn("Tầng");
        dvModel.addColumn("Loại phòng");
        dvModel.addColumn("Đơn giá");
        dvModel.addColumn("Trạng thái");
        dvModel.addColumn("Phone");
        dvModel.addColumn("Giường");
        dvModel.addColumn("Số Người");

        for (Phong item : listPhong) {
            String loai = DataStorage.loader.getTenLoai(item.getLoai());
            dvModel.addRow(new String[]{item.getMaPhong(), item.getTang() + "", loai, item.getDonGia() + "", item.getPhone(), item.getSoGiuong() + "", item.getSoNguoi() + ""});
        }
        return dvModel;
    }

}
