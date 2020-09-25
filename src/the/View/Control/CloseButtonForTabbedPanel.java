package the.View.Control;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import java.awt.FlowLayout;

public class CloseButtonForTabbedPanel extends JPanel implements MouseListener {
	private JLabel lblNewLabel;
	public CloseButtonForTabbedPanel() {
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		setSize(20, 15); 
		
		 lblNewLabel = new JLabel("x");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 8));
		setBackground(new Color(200,221,242,50));
		add(lblNewLabel);
		setVisible(true);
		addMouseListener(this);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 8));
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		setBackground(new Color(175, 199, 200,50));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		setBackground(new Color(200,221,242,50));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
