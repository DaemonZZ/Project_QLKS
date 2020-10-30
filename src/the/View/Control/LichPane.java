package the.View.Control;

import the.DataTransfer.NhanVien;
import the.Model.DatabaseConnection;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LichPane extends JLayeredPane {
    private final JButton btnAdd;
    private final JTextField txtTimKiem;
    DatabaseConnection dbc = new DatabaseConnection();
    private final ArrayList<NhanVien> listNhanVien = dbc.getListNV();

    public LichPane() {
        setLayout(new BorderLayout(0, 0));

        btnAdd = new JButton("+");
        btnAdd.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnAdd.setBackground(Color.CYAN);
        btnAdd.setPreferredSize(new Dimension(20, -1));
        add(btnAdd, BorderLayout.EAST);

        JScrollPane scrollPane = new JScrollPane();
        add(scrollPane, BorderLayout.CENTER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        scrollPane.setViewportView(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JMenuBar menuBar_Sodo = new JMenuBar();
        menuBar_Sodo.setBackground(Color.WHITE);
        add(menuBar_Sodo, BorderLayout.NORTH);

        JLabel lblNewLabel_1 = new JLabel("Nhập tên: ");
        menuBar_Sodo.add(lblNewLabel_1);

        txtTimKiem = new JTextField();
        menuBar_Sodo.add(txtTimKiem);
        txtTimKiem.setColumns(10);

        JButton btnTim = new JButton("Tìm Kiếm");
        menuBar_Sodo.add(btnTim);

        JPanel filterPanel = new JPanel();
        filterPanel.setBackground(Color.WHITE);
        menuBar_Sodo.add(filterPanel);

        JLabel lblNewLabel = new JLabel("Lọc: ");
        lblNewLabel.setForeground(Color.RED);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        filterPanel.add(lblNewLabel);

        JLabel lb = new JLabel("Bộ phận:");
        filterPanel.add(lb);

        JComboBox ttCb = new JComboBox(new Object[]{});
        filterPanel.add(ttCb);

        for (NhanVien nv : listNhanVien) {
            if (nv.getLoai() != 0) {
                panel.add(new NVPanel(nv));
            }
        }
    }
}
