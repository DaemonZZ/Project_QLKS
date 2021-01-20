package the.View.Panel;

import javax.swing.*;
import java.awt.*;

public class QLKho extends JLayeredPane {
    private JTable table;

    public QLKho() {
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
        scrollPane.setViewportView(table);
    }

}
