package headfirst.proxy.virtualproxy;

import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ImageProxy implements Icon {
	ImageIcon imageIcon;
	URL imageURL;
	Thread retrievalThread;
	boolean retrieving = false;
     
	public ImageProxy(URL url) { imageURL = url; }
     
	public int getIconWidth() {
		if (imageIcon != null) {
            return imageIcon.getIconWidth();
        } else {
			return 800;
		}
	}
 
	public int getIconHeight() {
		if (imageIcon != null) {
            return imageIcon.getIconHeight();
        } else {
			return 600;
		}
	}
     
	public void paintIcon(final Component c, Graphics  g, int x,  int y) {
		if (imageIcon != null) {
		    // If we’ve got an icon already, we go ahead and tell it to paint itself.
			imageIcon.paintIcon(c, g, x, y);
		} else {
			g.drawString("Loading CD cover, please wait...", x+300, y+190);
			if (!retrieving) {
				retrieving = true;

				retrievalThread = new Thread(new Runnable() {
					public void run() {
						try {
						    // as ImageIcon will not return util the image is loaded, we manipulate this process to
                            // repaint when the image is ready
							imageIcon = new ImageIcon(imageURL, "CD Cover");
							c.repaint();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				retrievalThread.start();
			}
		}
	}
}
