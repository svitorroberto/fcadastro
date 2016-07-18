package aditional;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class RodarImagem {
	
	public BufferedImage rotateImage(BufferedImage img, double angle) {
		double radangle = Math.toRadians(angle);
		           

		    
		    Graphics2D g = img.createGraphics();
		    
		    g.rotate(radangle);
		    g.drawRenderedImage(img, null);

		    return img;

}
}
