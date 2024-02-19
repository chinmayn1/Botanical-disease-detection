/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package colour_detection;

/**
 *
 * @author AZURE
 */
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author maikon
 */
public class PaintPicture extends JPanel {
    
    Dimension dimFrame;
    File picture;
    
    public PaintPicture(Dimension d, File pic)
    {
        dimFrame = d;
        picture = pic;
    }
       
    public void paintComponent(Graphics g)
    {
        BufferedImage inputPicture = null;
        try {
            super.paintComponent(g);
            inputPicture = ImageIO.read(picture);
        } catch (IOException ex) {
            Logger.getLogger(PaintPicture.class.getName()).log(Level.SEVERE, null, ex);
        }
        g.drawImage(inputPicture, 0, 0,dimFrame.height, dimFrame.width, this);
                              
    }
    
}
