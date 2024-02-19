package www.ascox.in;

import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
public class Background extends JPanel {
    private static final long serialVersionUID = 1L;
    private BufferedImage image;
    private Ellipse2D.Double ball;
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (image == null) {
            initImage();
        }
        g2.drawImage(image, 0, 0, this);
        g2.setPaint(Color.red);
        g2.fill(ball);
    }
    private void initImage() {
        int w = getWidth();
        int h = getHeight();
        int type = BufferedImage.TYPE_INT_RGB;
        image = new BufferedImage(w, h, type);
        Graphics2D g2 = image.createGraphics();
        GradientPaint gradient = new GradientPaint(0, 0, Color.white, w, h, Color.darkGray);
        g2.setPaint(gradient);
        g2.fillRect(0, 0, w, h);
        g2.dispose();
        int d = Math.min(w, h) / 4; // initialize ball
        ball = new Ellipse2D.Double(w / 3, h / 4, d, d);
    }
   /* public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(new Background());
        f.setSize(400, 400);
        f.setLocation(200, 200);
        f.setVisible(true);
    }*/
}