

package www.ascox.in;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ThersholdImage {
  
   
   
    public static BufferedImage testImage(String s) throws IOException {

      
      File file = new File("images\\gaborred.jpg");
      Image image = ImageIO.read(new File(s));

     
      BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
      Graphics g = bufferedImage.getGraphics();
      g.drawImage(image, 0, 0, null);

      
      ImageIO.write(new GaborFilter(16, new double[] {0, Math.PI/4, Math.PI}, 0, 0.5, 1, 3, 3).filter(bufferedImage, null), "jpg", file);
      
      BufferedImage bImages = ImageIO.read(file);
      return bImages;
      
    }
  
} 