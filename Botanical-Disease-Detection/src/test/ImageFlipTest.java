/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

/**
 *
 * @author AZURE
 */
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ByteLookupTable;
import java.awt.image.LookupOp;
import java.awt.image.LookupTable;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import www.ascox.in.TensorFlowBasedDetector;
import www.ascox.in.QueryProcess;
import static www.ascox.in.QueryProcess.image;
import static www.ascox.in.QueryProcess.in3;

public class ImageFlipTest
{
  

   
    public static BufferedImage convertToARGB(BufferedImage image)
    {
        BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(),BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = newImage.createGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return newImage;
    }    

    public static BufferedImage createFlipped(BufferedImage image)
    {
        AffineTransform at = new AffineTransform();
        at.concatenate(AffineTransform.getScaleInstance(1, -1));
        at.concatenate(AffineTransform.getTranslateInstance(0, -image.getHeight()));
        return createTransformed(image, at);
    }

    public static BufferedImage createRotated(BufferedImage image)
    {
        AffineTransform at = AffineTransform.getRotateInstance(
            Math.PI, image.getWidth()/2, image.getHeight()/2.0);
        return createTransformed(image, at);
    }

    public static BufferedImage createTransformed(BufferedImage image, AffineTransform at)
    {
        BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(),BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = newImage.createGraphics();
        g.transform(at);
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return newImage;
    }

    public static BufferedImage createInverted(BufferedImage image)
    {
        if (image.getType() != BufferedImage.TYPE_INT_ARGB)
        {
            image = convertToARGB(image);
        }
        LookupTable lookup = new LookupTable(0, 4)
        {
            @Override
            public int[] lookupPixel(int[] src, int[] dest)
            {
                dest[0] = (int)(255-src[0]);
                dest[1] = (int)(255-src[1]);
                dest[2] = (int)(255-src[2]);
                return dest;
            }
        };
        LookupOp op = new LookupOp(lookup, new RenderingHints(null));
        return op.filter(image, null);
    }

    public static Component createComponent(String title, BufferedImage image)
    {
        JLabel label = new JLabel(new ImageIcon(image));
        JPanel panel = new JPanel(new GridLayout(1,1));
        panel.add(label);
        panel.setBorder(BorderFactory.createTitledBorder(title));
        return panel;
    }
}