package the.hotel;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class BlankForm extends JFrame {
	private JTextField textField;
	private JTable table;
	public BlankForm() {
        getContentPane().setLayout(null);
        
        setTitle("title");
        setSize(565, 480);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(10, 11, 528, 67);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(10, 103, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(65, 100, 204, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(291, 102, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(347, 98, 82, 22);
		getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(449, 99, 89, 23);
		getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 128, 429, 298);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnDong = new JButton("Đóng");
		btnDong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                MainForm.m.setEnabled(true);
                dispose();
			}
		});
		btnDong.setBounds(449, 403, 89, 23);
		getContentPane().add(btnDong);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(449, 324, 89, 23);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(449, 290, 89, 23);
		getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setBounds(449, 256, 89, 23);
		getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("New button");
		btnNewButton_5.setBounds(449, 222, 89, 23);
        getContentPane().add(btnNewButton_5);
        
        setVisible(true);

        this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
                MainForm.m.setEnabled(true);
				dispose();
			}
        	
		});
	}
}
