package the.View.Control;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.border.Border;

public class LargeButton extends JPanel implements MouseListener{
	private String pathIcon;
	private String name;
	
	public String getPathIcon() {
		return pathIcon;
	}

	public void setPathIcon(String pathIcon) {
		this.pathIcon = pathIcon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	/**
	 *  Tạo và resize icon từ ảnh bất kì
	 * @param linkImage : Duong dan anh
	 * @param Chieu dai
	 * @param Chieu cao
	 * @return Icon
	 */
	public Icon loadIco(String linkImage, int k, int m) {
	    try {
	        BufferedImage image = ImageIO.read(new File(linkImage));
	 
	        int x = k;
	        int y = m;
	        int ix = image.getWidth();
	        int iy = image.getHeight();
	        int dx = 0, dy = 0;
	 
	        if (x / y > ix / iy) {
	            dy = y;
	            dx = dy * ix / iy;
	        } else {
	            dx = x;
	            dy = dx * iy / ix;
	        }
	 
	        return new ImageIcon(image.getScaledInstance(dx, dy,
                    Image.SCALE_SMOOTH));
	 
	    } catch (IOException e) {
	 
	        e.printStackTrace();
	    }
	 
	    return null;
	}
	/**
	 * Tạo 1 Button trên bảng Menu chính
	 * @param path  : Đường dẫn ảnh làm Icon
	 * @param name : label của btn
	 */
	public LargeButton(String path, String name) {
		setBorder(new RoundedBorder(15));
		setBackground(Color.WHITE);
		this.pathIcon="img\\"+path;
		this.name = name;
		setSize(80, 100);
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		Icon ico = loadIco(pathIcon, 40, 40);
		JLabel lbIco = new JLabel(ico);
		this.add(lbIco);
		
		JLabel lbName = new JLabel(name);
		lbName.setBackground(SystemColor.info);
		lbName.setFont(new Font("Tahoma", Font.BOLD, 10));
		this.add(lbName);
		this.setVisible(true);
		addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		setBackground(new Color(106, 176, 131));
		setBorder(new RoundedBorder(12));
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		setBackground(new Color(201, 240, 215));
		setBorder(new RoundedBorder(15));
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		setBackground(new Color(201, 240, 215));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		setBackground(Color.WHITE);
	}
	
	
	
}

class RoundedBorder implements Border {

    private final int radius;


    RoundedBorder(int radius) {
        this.radius = radius;
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius+1, this.radius+1, this.radius+1, this.radius);
    }


    public boolean isBorderOpaque() {
        return true;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
    }


	
}

