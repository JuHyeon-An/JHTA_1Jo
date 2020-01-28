package books;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.MalformedURLException;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class AddPanelImage extends JPanel {
	Image image;
	
	AddPanelImage(String imagePath) throws MalformedURLException {
		image = Toolkit.getDefaultToolkit().createImage(imagePath);  
	    
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(image != null) {
			Dimension d = getSize();
			g.drawImage(image, 0, 0, d.width, d.height, this);
			
		}
		
//		ImageIcon image = new ImageIcon("img/aa2.gif");
	}
}
