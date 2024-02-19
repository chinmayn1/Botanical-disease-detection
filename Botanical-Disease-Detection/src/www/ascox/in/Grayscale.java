/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package www.ascox.in;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ColorConvertOp;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class Grayscale {

    private static BufferedImage original, grayscale;

    //public static void main(String[] args) throws IOException {

        public Vector<BufferedImage> colourAlgorithm(String ss)  throws IOException{
        //String ss = "C:\\Users\\azure\\Desktop\\New Folder\\sac\\s6.jpg";

            //Browse br = new Browse();
       // String ss = br.absPath;
       // System.out.println("ss  " + ss);
        File original_f = new File(ss);
        String output_f = ss + "_bw";
        original = ImageIO.read(original_f);
        grayscale = avg(original);
        BufferedImage im1 = writeImage(output_f + "_1_avg");
        grayscale = luminosity(original);
        BufferedImage im2 = writeImage(output_f + "_2_lum");
        grayscale = desaturation(original);
        BufferedImage im3 = writeImage(output_f + "_3_lig");
        grayscale = decompMin(original);
        BufferedImage im4 = writeImage(output_f + "_4_decmin");
        grayscale = decompMax(original);
        BufferedImage im5 = writeImage(output_f + "_5_decmax");
        grayscale = rgb(original, 0);
        BufferedImage im6 = writeImage(output_f + "_6_1r");
        grayscale = rgb(original, 1);
        BufferedImage im7 = writeImage(output_f + "_6_2g");
        grayscale = rgb(original, 2);
        BufferedImage im8 = writeImage(output_f + "_6_3b");
        grayscale = javaWay(original);
        BufferedImage im9 = writeImage(output_f + "_7_java");
        Vector<BufferedImage> v = new Vector<BufferedImage>();
       v.add(im1);
       v.add(im2);
       v.add(im3);
       v.add(im4);
       v.add(im5);
       v.add(im6);
       v.add(im7);
       v.add(im8);
       v.add(im9);
       
       /*
        ImageIcon ic = new ImageIcon(im1);
        ImageIcon ic2 = new ImageIcon(im2);

        JLabel jl = new JLabel(ic);
        JLabel jl2 = new JLabel(ic2);

        JFrame jf = new JFrame();
        jf.setLayout(new FlowLayout());
        jf.add(jl);
        jf.add(jl2);
        jf.setVisible(true);
       */
       return v;
    }

    private static BufferedImage writeImage(String output) throws IOException {
        File file = new File(output + ".jpg");
    //ImageIO.write(grayscale, "jpg", file);

        return grayscale;

    }

    // The average grayscale method
    private static BufferedImage avg(BufferedImage original) {

        int alpha, red, green, blue;
        int newPixel;

        BufferedImage avg_gray = new BufferedImage(original.getWidth(), original.getHeight(), original.getType());
        int[] avgLUT = new int[766];
        for (int i = 0; i < avgLUT.length; i++) {
            avgLUT[i] = (int) (i / 3);
        }

        for (int i = 0; i < original.getWidth(); i++) {
            for (int j = 0; j < original.getHeight(); j++) {

                // Get pixels by R, G, B
                alpha = new Color(original.getRGB(i, j)).getAlpha();
                red = new Color(original.getRGB(i, j)).getRed();
                green = new Color(original.getRGB(i, j)).getGreen();
                blue = new Color(original.getRGB(i, j)).getBlue();

                newPixel = red + green + blue;
                newPixel = avgLUT[newPixel];
                // Return back to original format
                newPixel = colorToRGB(alpha, newPixel, newPixel, newPixel);

                // Write pixels into image
                avg_gray.setRGB(i, j, newPixel);

            }
        }

        return avg_gray;

    }

    // The luminance method
    private static BufferedImage luminosity(BufferedImage original) {

        int alpha, red, green, blue;
        int newPixel;

        BufferedImage lum = new BufferedImage(original.getWidth(), original.getHeight(), original.getType());

        for (int i = 0; i < original.getWidth(); i++) {
            for (int j = 0; j < original.getHeight(); j++) {

                // Get pixels by R, G, B
                alpha = new Color(original.getRGB(i, j)).getAlpha();
                red = new Color(original.getRGB(i, j)).getRed();
                green = new Color(original.getRGB(i, j)).getGreen();
                blue = new Color(original.getRGB(i, j)).getBlue();

                red = (int) (0.21 * red + 0.71 * green + 0.07 * blue);
                // Return back to original format
                newPixel = colorToRGB(alpha, red, red, red);

                // Write pixels into image
                lum.setRGB(i, j, newPixel);

            }
        }

        return lum;

    }

    // The desaturation method
    private static BufferedImage desaturation(BufferedImage original) {

        int alpha, red, green, blue;
        int newPixel;

        int[] pixel = new int[3];

        BufferedImage des = new BufferedImage(original.getWidth(), original.getHeight(), original.getType());
        int[] desLUT = new int[511];
        for (int i = 0; i < desLUT.length; i++) {
            desLUT[i] = (int) (i / 2);
        }

        for (int i = 0; i < original.getWidth(); i++) {
            for (int j = 0; j < original.getHeight(); j++) {

                // Get pixels by R, G, B
                alpha = new Color(original.getRGB(i, j)).getAlpha();
                red = new Color(original.getRGB(i, j)).getRed();
                green = new Color(original.getRGB(i, j)).getGreen();
                blue = new Color(original.getRGB(i, j)).getBlue();

                pixel[0] = red;
                pixel[1] = green;
                pixel[2] = blue;

                int newval = (int) (findMax(pixel) + findMin(pixel));
                newval = desLUT[newval];

                // Return back to original format
                newPixel = colorToRGB(alpha, newval, newval, newval);

                // Write pixels into image
                des.setRGB(i, j, newPixel);

            }
        }

        return des;

    }

    // The minimal decomposition method
    private static BufferedImage decompMin(BufferedImage original) {

        int alpha, red, green, blue;
        int newPixel;

        int[] pixel = new int[3];

        BufferedImage decomp = new BufferedImage(original.getWidth(), original.getHeight(), original.getType());

        for (int i = 0; i < original.getWidth(); i++) {
            for (int j = 0; j < original.getHeight(); j++) {

                // Get pixels by R, G, B
                alpha = new Color(original.getRGB(i, j)).getAlpha();
                red = new Color(original.getRGB(i, j)).getRed();
                green = new Color(original.getRGB(i, j)).getGreen();
                blue = new Color(original.getRGB(i, j)).getBlue();

                pixel[0] = red;
                pixel[1] = green;
                pixel[2] = blue;

                int newval = findMin(pixel);

                // Return back to original format
                newPixel = colorToRGB(alpha, newval, newval, newval);

                // Write pixels into image
                decomp.setRGB(i, j, newPixel);

            }
        }

        return decomp;

    }

    // The maximum decomposition method
    private static BufferedImage decompMax(BufferedImage original) {

        int alpha, red, green, blue;
        int newPixel;

        int[] pixel = new int[3];

        BufferedImage decomp = new BufferedImage(original.getWidth(), original.getHeight(), original.getType());

        for (int i = 0; i < original.getWidth(); i++) {
            for (int j = 0; j < original.getHeight(); j++) {

                // Get pixels by R, G, B
                alpha = new Color(original.getRGB(i, j)).getAlpha();
                red = new Color(original.getRGB(i, j)).getRed();
                green = new Color(original.getRGB(i, j)).getGreen();
                blue = new Color(original.getRGB(i, j)).getBlue();

                pixel[0] = red;
                pixel[1] = green;
                pixel[2] = blue;

                int newval = findMax(pixel);

                // Return back to original format
                newPixel = colorToRGB(alpha, newval, newval, newval);

                // Write pixels into image
                decomp.setRGB(i, j, newPixel);

            }

        }

        return decomp;

    }

    // The "pick the color" method
    private static BufferedImage rgb(BufferedImage original, int color) {

        int alpha, red, green, blue;
        int newPixel;

        int[] pixel = new int[3];

        BufferedImage rgb = new BufferedImage(original.getWidth(), original.getHeight(), original.getType());

        for (int i = 0; i < original.getWidth(); i++) {
            for (int j = 0; j < original.getHeight(); j++) {

                // Get pixels by R, G, B
                alpha = new Color(original.getRGB(i, j)).getAlpha();
                red = new Color(original.getRGB(i, j)).getRed();
                green = new Color(original.getRGB(i, j)).getGreen();
                blue = new Color(original.getRGB(i, j)).getBlue();

                pixel[0] = red;
                pixel[1] = green;
                pixel[2] = blue;

                int newval = pixel[color];

                // Return back to original format
                newPixel = colorToRGB(alpha, newval, newval, newval);

                // Write pixels into image
                rgb.setRGB(i, j, newPixel);

            }

        }

        return rgb;

    }

    // The simplest way to convert in Java
    public static BufferedImage javaWay(BufferedImage source) {
        BufferedImageOp op = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
        return op.filter(source, null);
    }

    // Convert R, G, B, Alpha to standard 8 bit
    private static int colorToRGB(int alpha, int red, int green, int blue) {

        int newPixel = 0;
        newPixel += alpha;
        newPixel = newPixel << 8;
        newPixel += red;
        newPixel = newPixel << 8;
        newPixel += green;
        newPixel = newPixel << 8;
        newPixel += blue;

        return newPixel;

    }

    private static int findMin(int[] pixel) {

        int min = pixel[0];

        for (int i = 0; i < pixel.length; i++) {
            if (pixel[i] < min) {
                min = pixel[i];
            }
        }

        return min;

    }

    private static int findMax(int[] pixel) {

        int max = pixel[0];

        for (int i = 0; i < pixel.length; i++) {
            if (pixel[i] > max) {
                max = pixel[i];
            }
        }

        return max;

    }

}
