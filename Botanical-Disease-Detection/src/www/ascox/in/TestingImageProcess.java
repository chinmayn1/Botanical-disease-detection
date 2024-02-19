package www.ascox.in;

import colour_detection.GenHistogram;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import static test.ImageFlipTest.createFlipped;
import static test.ImageFlipTest.createInverted;
import static test.ImageFlipTest.createRotated;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.highgui.Highgui;
import org.opencv.objdetect.CascadeClassifier;

/**
 *
 * @author admin
 */
public class TestingImageProcess extends javax.swing.JInternalFrame {
    public static String disleafname;
    BufferedImage canyin = null;
   public static String absPath ;
    public static InputStream in1,in2;  
    public static BufferedImage originalImage;
    public static BufferedImage gbOut,image;
    public static String filename;
    public static float out;
    public static float x;
    public TestingImageProcess() {
        initComponents();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Select Leaf Images");
        setToolTipText("");
        setAutoscrolls(true);
        setDoubleBuffered(true);
        setFocusTraversalPolicyProvider(true);
        setMaximumSize(new java.awt.Dimension(1200, 800));
        setMinimumSize(new java.awt.Dimension(1200, 800));
        setOpaque(true);
        setPreferredSize(new java.awt.Dimension(1094, 286));
        setVisible(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Browse");
        jButton1.setPreferredSize(new java.awt.Dimension(67, 30));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 100, -1));

        jTextField1.setPreferredSize(new java.awt.Dimension(6, 30));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 160, -1));

        jButton2.setText("Submit");
        jButton2.setPreferredSize(new java.awt.Dimension(65, 30));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 90, -1));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setText("Image:");
        jLabel1.setPreferredSize(new java.awt.Dimension(34, 30));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 80, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Leaf Image"));
        jPanel1.setToolTipText("");
        jPanel1.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.setViewportView(jLabel2);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 210, 200));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Edge Detection Image"));
        jPanel2.setMinimumSize(new java.awt.Dimension(2147483647, 2147483647));
        jPanel2.setPreferredSize(new java.awt.Dimension(2147483647, 2147483647));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setViewportView(jLabel3);

        jPanel2.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, 220, 200));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("thersholding Image"));
        jPanel3.setMinimumSize(new java.awt.Dimension(2147483647, 2147483647));
        jPanel3.setPreferredSize(new java.awt.Dimension(2147483647, 2147483647));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jScrollPane3.setViewportView(jLabel4);

        jPanel3.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 20, 220, 200));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF IMAGES", "jpg", "png");
        fileChooser.addChoosableFileFilter(filter);
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
             filename = selectedFile.getName();
            jTextField1.setText(path);
            absPath = path;
            if (selectedFile != null) {
                try {
                    
                    BufferedImage originalImage = ImageIO.read(selectedFile);
                    canyin = originalImage;
                    
                    int width = originalImage.getWidth(null);
                    int hieght = originalImage.getHeight(null);
                    
                    jLabel2.setIcon(new ImageIcon(originalImage));
                    jLabel2.setLocation(width, hieght);
                    jScrollPane1.setViewportView(jLabel2);
                    
                } catch (IOException ex) {
                    Logger.getLogger(TestingImageProcess.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        
                
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        System.out.println("\nRunning Tensor Flow Detector");

        CascadeClassifier faceDetector = new CascadeClassifier("D:/haarcascade_frontalface_alt.xml");
        Mat image = Highgui.imread(absPath);

        MatOfRect faceDetections = new MatOfRect();
        faceDetector.detectMultiScale(image, faceDetections);

        System.out.println(String.format("Detected %s Leaf", faceDetections.toArray().length));
        
       

        for (Rect rect : faceDetections.toArray()) {
            Core.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
                    new Scalar(0, 255, 0));
        }

      
    Highgui.imwrite("images//"+filename+".jpg", image);
        
        
          
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        JScrollPane scr = new JScrollPane();
        
        JInternalFrame frameToView = new JInternalFrame("Testing Image From Database");
        frameToView.setLayout(new FlowLayout());
        
        EdgeRegionDetctor detector = new EdgeRegionDetctor();
        
        detector.setLowThreshold(0.5f);
        detector.setHighThreshold(1f);
        
        detector.setSourceImage(canyin);
        detector.process();
         image = detector.getEdgesImage();
        int width = image.getWidth(null);
        int hieght = image.getHeight(null);
        jLabel3.setIcon(new ImageIcon(image));
        jLabel3.setLocation(width, hieght);
        jScrollPane2.setViewportView(jLabel3);
            ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "jpg", baos1);
        } catch (IOException ex) {
            Logger.getLogger(TestingImageProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            baos1.flush();
        } catch (IOException ex) {
            Logger.getLogger(TestingImageProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
			byte[] imageInByte = baos1.toByteArray();
        try {
            baos1.close();
        } catch (IOException ex) {
            Logger.getLogger(TestingImageProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
                         in1 = new ByteArrayInputStream(imageInByte);
        ThersholdImage gb = new ThersholdImage();
        try {
             gbOut = gb.testImage(absPath);
            jLabel4.setIcon(new ImageIcon(gbOut));
            jLabel4.setLocation(width, hieght);
            jScrollPane3.setViewportView(jLabel4);
            ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
			ImageIO.write(gbOut, "jpg", baos2);
			baos2.flush();
			byte[] imageInByte1 = baos1.toByteArray();
			baos2.close();
                         in2 = new ByteArrayInputStream(imageInByte1);
                       //
                       //  System.out.println(in2);
            
        } catch (IOException ex) {
            Logger.getLogger(TestingImageProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/image", "root", "root");
        } catch (SQLException ex) {
            Logger.getLogger(TestingImageProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        Statement s = null;
        try {
            s = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(TestingImageProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ResultSet rs = null;
        try {
            rs = s.executeQuery( "SELECT * FROM leafcrop");
        } catch (SQLException ex) {
            Logger.getLogger(TestingImageProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        byte buff[] = new byte[1024];
        byte buff1[] = new byte[1024];
        
        try {
            while (rs.next()) {
                Blob ablob = rs.getBlob(2);
                Blob bblob = rs.getBlob(3);
                
                File afile = new File("images\\newimage.jpg");
                
                 InputStream is = ablob.getBinaryStream();
                
                FileOutputStream fos = null;
                try {
                    fos = new FileOutputStream(afile);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(TestingImageProcess.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    for (int b = is.read(buff); b != -1; b = is.read(buff)) {
                        fos.write(buff, 0, b);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(TestingImageProcess.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                try {
                    
                    File aimage = new File("images\\newimage.jpg");
                    
                    BufferedImage aCannyImages = ImageIO.read(aimage);
                    
                    EdgeRegionDetctor detector1 = new EdgeRegionDetctor();
                    
                    detector1.setLowThreshold(0.5f);
                    detector1.setHighThreshold(1f);
                    
                    detector1.setSourceImage(aCannyImages);
                    detector1.process();
                    BufferedImage databasecany = detector1.getEdgesImage();
                    
                     x = fileCaompare(image, databasecany);
                    System.out.println(x);
                    
                    if (x == 100) {
                        
                        File cropimage = new File("images\\image1.jpg");
                        
                        InputStream is1 = bblob.getBinaryStream();
                        
                        FileOutputStream fos1 = null;
                        try {
                            fos1 = new FileOutputStream(cropimage);
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(TestingImageProcess.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        try {
                            for (int b = is1.read(buff1); b != -1; b = is1.read(buff1)) {
                                fos1.write(buff1, 0, b);
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(TestingImageProcess.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        File bimage = new File("images\\image1.jpg");
                        
                        BufferedImage cropimages = ImageIO.read(bimage);
                        
                        try {
                            Class.forName("com.mysql.jdbc.Driver");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        Connection con2 = null;
                        try {
                            con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/image", "root", "root");
                        } catch (SQLException ex) {
                            Logger.getLogger(TestingImageProcess.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        Statement s2 = null;
                        try {
                            s2 = con2.createStatement();
                        } catch (SQLException ex) {
                            Logger.getLogger(TestingImageProcess.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        ResultSet rs2 = null;
                        try {
                            rs2 = s2.executeQuery("SELECT * FROM crop");
                        } catch (SQLException ex) {
                            Logger.getLogger(TestingImageProcess.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        byte buffout[] = new byte[1024];
                        byte bufffinalout[] = new byte[1024];
                        
                        while (rs2.next()) {
                            
                            Blob outblob = rs2.getBlob("leaf");
                            Blob finaloutblob = rs2.getBlob("leafdisese");
                            disleafname = rs2.getString("type");
                            File outfile = new File("images\\outimage.jpg");
                            
                            InputStream isout = outblob.getBinaryStream();
                            
                            FileOutputStream fosOut = null;
                            try {
                                fosOut = new FileOutputStream(outfile);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(TestingImageProcess.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            try {
                                for (int b = isout.read(buffout); b != -1; b = isout.read(buffout)) {
                                    fosOut.write(buffout, 0, b);
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(TestingImageProcess.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                            File outImage = new File("images\\outimage.jpg");
                            
                            BufferedImage outImages = ImageIO.read(outImage);
                            
                             out = fileCaompare(cropimages, outImages);
                            
                         //   System.out.println(out);
                            
                            if (out == 100) {
                                
                                File finaloutfile = new File("images\\finalimage.jpg");
                                
                                InputStream isfinalout = finaloutblob.getBinaryStream();
                                
                                FileOutputStream fosfinalOut = null;
                                try {
                                    fosfinalOut = new FileOutputStream(finaloutfile);
                                } catch (FileNotFoundException ex) {
                                    Logger.getLogger(TestingImageProcess.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                try {
                                    for (int b = isfinalout.read(bufffinalout); b != -1; b = isfinalout.read(bufffinalout)) {
                                        fosfinalOut.write(bufffinalout, 0, b);
                                    }
                                } catch (IOException ex) {
                                    Logger.getLogger(TestingImageProcess.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                
                                File finalImage = new File("images\\finalimage.jpg");
                                
                                BufferedImage finalImages = ImageIO.read(finalImage);
                                
                                ImageIcon im = new ImageIcon(finalImages);
                                System.out.println(finalImage.toString());
                               
                                  
                                JLabel jlm = new JLabel(im);
                                
                                
                                
                           
        
                                
                               
                                  
                              
//pack();
                            }
                            
                        }
                     
         
     
        Grayscale gs = new Grayscale();
        try {
            Vector<BufferedImage> v = gs.colourAlgorithm("images//"+TestingImageProcess.filename+".jpg");
            
            ImageIcon im1 = new ImageIcon(v.get(0));
            ImageIcon im2 = new ImageIcon(v.get(1));
            ImageIcon im3 = new ImageIcon(v.get(2));
            ImageIcon im4 = new ImageIcon(v.get(3));
            ImageIcon im5 = new ImageIcon(v.get(4));
            ImageIcon im6 = new ImageIcon(v.get(5));
            ImageIcon im7 = new ImageIcon(v.get(6));
            ImageIcon im8 = new ImageIcon(v.get(7));
            ImageIcon im9 = new ImageIcon(v.get(8));
            
            JLabel jl = new JLabel(im1);
            JLabel j2 = new JLabel(im2);
            JLabel j3 = new JLabel(im3);
            JLabel j4 = new JLabel(im4);
            JLabel j5 = new JLabel(im5);
            JLabel j6 = new JLabel(im6);
            JLabel j7 = new JLabel(im7);
            JLabel j8 = new JLabel(im8);
            JLabel j9 = new JLabel(im9);
            
                                JLabel j10 = new JLabel();

              File select = new File("images//"+TestingImageProcess.filename+".jpg");
        BufferedImage img = null;
        try {
             img = ImageIO.read(select);
           // System.out.println(img);
            
         int width2 = img.getWidth(null);
                    int hieght2 = img.getHeight(null);
                   
             j10.setIcon(new ImageIcon(img));
                    j10.setLocation(width, hieght);
                    
                  JFrame f2=new JFrame();  
    JOptionPane.showMessageDialog(f2,"Leaf Disease Analysis Process....."); 
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(TestingImageProcess.class.getName()).log(Level.SEVERE, null, ex);
                        }
     JFrame f3=new JFrame();  
    JOptionPane.showMessageDialog(f3,"Leaf  Disease Confrimed.....");
     JFrame f4=new JFrame();  
    JOptionPane.showMessageDialog(f4,"Disease Name....."+disleafname);
                   // jScrollPane1.setViewportView(jLabel2);
        }catch(Exception e)
        {
            Logger.getLogger(TestingImageProcess.class.getName()).log(Level.SEVERE, null, e);
        }
            
            
            
            JInternalFrame jf1 = new JInternalFrame("Grayscale detection for Test Images ");
            jf1.setLayout(new FlowLayout());
           
            jf1.add(j10);
            jf1.add(jl);
            jf1.add(j2);
            jf1.add(j3);
            jf1.add(j4);
            jf1.add(j5);
            jf1.add(j6);
            jf1.add(j7);
            jf1.add(j8);
            jf1.add(j9);
            jf1.setMaximizable(true);
            jf1.setIconifiable(true);
            jf1.setClosable(true);
            jf1.setResizable(true);
            //jf1.setMaximumSize(new Dimension(1000, 500));
            jf1.moveToFront();
            jf1.show();
            jf1.setSize(getDesktopPane().getSize());
            //desktopIcon.add(jf);
            getDesktopPane().add(jf1);
            //moveToBack();
        } catch (IOException ex) {
            Logger.getLogger(TestingImageProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
        
        
                
        JFrame frame = new JFrame();
        frame.setTitle("Pattern Detector");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(new GridLayout(1, 1));

        JPanel panel = new JPanel(new GridLayout(2,2));
        
        
       TensorFlowBasedDetector tensor = new TensorFlowBasedDetector();

        tensor.setLowThreshold(0.2f);
        tensor.setHighThreshold(3f);

        tensor.setSourceImage(image);
        tensor.process();
        BufferedImage image1 = tensor.getEdgesImage();

        int width1 = image1.getWidth(null);
        int hieght1 = image1.getHeight(null);
 panel.add(test.ImageFlipTest.createComponent("Original", image1));
  panel.add(test.ImageFlipTest.createComponent("Inverted Cluster1", createFlipped(image1)));
  panel.add(test.ImageFlipTest.createComponent("Inverted Cluster2", createRotated(image1)));
        panel.add(test.ImageFlipTest.createComponent("Leaf Disease Afficated Place", createInverted(image1)));
        
        ByteArrayOutputStream baos4 = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "jpg", baos4);
        } catch (IOException ex) {
            Logger.getLogger(QueryProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            baos4.flush();
        } catch (IOException ex) {
            Logger.getLogger(QueryProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        byte[] imageInByte2 = baos4.toByteArray();
        try {
            baos4.close();
        } catch (IOException ex) {
            Logger.getLogger(QueryProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
    //in3 = new ByteArrayInputStream(imageInByte2);
        
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
         
                    }else if(x>=100)
                    {
                   System.out.println("hai hello welcome"); 
                    }
                    
                  // System.exit(1);
                    
                
                    
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
           
            
        } catch (SQLException ex) {
            Logger.getLogger(TestingImageProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(out);
        System.out.println(x);
        if(out>=100 && x>=90)
        {
            System.out.println("Disese Confrmed.........");
       
        }else
        {
             colour_detection.GenHistogram gen = new GenHistogram();
         gen.GenHistogram1(absPath);
         System.out.println("hai hello "); 
                     JFrame f2=new JFrame();  
    JOptionPane.showMessageDialog(f2,"Leaf Disease Analysis Process....."); 
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(TestingImageProcess.class.getName()).log(Level.SEVERE, null, ex);
                        }
     JFrame f3=new JFrame();  
    JOptionPane.showMessageDialog(f3,"Leaf Non Disease.....");
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    private static float fileCaompare(BufferedImage image, BufferedImage images) throws IOException {
        
        long start = System.currentTimeMillis();
        //File file= new File("C:\\13.jpg");
        //BufferedImage image = ImageIO.read(file);
        int width = image.getWidth(null);
        int height = image.getHeight(null);
        int[][] clr = new int[width][height];
//File files= new File("C:\\20.jpg");

        //BufferedImage images = ImageIO.read(files);
        int widthe = images.getWidth(null);
        int heighte = images.getHeight(null);
        int[][] clre = new int[widthe][heighte];
        int smw = 0;
        int smh = 0;
        int p = 0;
//CALUCLATING THE SMALLEST VALUE AMONG WIDTH AND HEIGHT
        if (width > widthe) {
            smw = widthe;
        } else {
            smw = width;
        }
        if (height > heighte) {
            smh = heighte;
        } else {
            smh = height;
        }
//CHECKING NUMBER OF PIXELS SIMILARITY
        for (int a = 0; a < smw; a++) {
            for (int b = 0; b < smh; b++) {
                clre[a][b] = images.getRGB(a, b);
                clr[a][b] = image.getRGB(a, b);
                if (clr[a][b] == clre[a][b]) {
                    p = p + 1;
                }
            }
        }
        
        float w, h = 0;
        if (width > widthe) {
            w = width;
        } else {
            w = widthe;
        }
        if (height > heighte) {
            h = height;
        } else {
            h = heighte;
        }
        float s = (smw * smh);
        
        float x = (100 * p) / s;
       //  System.out.println("x value   " + x);
      


return x;
        
        
        
    }
    
}
