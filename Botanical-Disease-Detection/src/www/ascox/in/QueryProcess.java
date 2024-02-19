package www.ascox.in;

import colour_detection.GenHistogram;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import static test.ImageFlipTest.convertToARGB;
import static test.ImageFlipTest.createFlipped;
import static test.ImageFlipTest.createInverted;
import static test.ImageFlipTest.createRotated;

/**
 *
 * @author admin
 */
public class QueryProcess extends javax.swing.JInternalFrame {
    
    static BufferedImage canyin = null;
    public static String absPath = null;
public static InputStream in1,in2,in3; 
public static BufferedImage image;
    public QueryProcess() {
        initComponents();
        
        
                JScrollPane scr = new JScrollPane();

      // JInternalFrame frameToView = new JInternalFrame("Group IMage");
      //  frameToView.setLayout(new FlowLayout());

        EdgeRegionDetctor detector = new EdgeRegionDetctor();

        detector.setLowThreshold(0.5f);
        detector.setHighThreshold(1f);

        detector.setSourceImage(InsertImage.originalImage);
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
            Logger.getLogger(QueryProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            baos1.flush();
        } catch (IOException ex) {
            Logger.getLogger(QueryProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        byte[] imageInByte = baos1.toByteArray();
        try {
            baos1.close();
        } catch (IOException ex) {
            Logger.getLogger(QueryProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        in1 = new ByteArrayInputStream(imageInByte);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

        ThersholdImage gb = new ThersholdImage();
        try {
            BufferedImage gbOut = gb.testImage(InsertImage.absPath);
            jLabel4.setIcon(new ImageIcon(gbOut));
            jLabel4.setLocation(width, hieght);
            jScrollPane3.setViewportView(jLabel4);

            //  img2 = ImageIO.createImageInputStream(gbOut);
            // System.out.println(img2);

            ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
            ImageIO.write(gbOut, "jpg", baos2);
            baos2.flush();
            byte[] imageInByte1 = baos2.toByteArray();
            baos2.close();
            in2 = new ByteArrayInputStream(imageInByte1);
           // System.out.println(in2);

            //  img2 = (Image) jLabel3.getIcon();
        } catch (IOException ex) {
            Logger.getLogger(QueryProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
       // att();
        
        
        
        
        
        
        

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Images Process");
        setToolTipText("");
        setAutoscrolls(true);
        setDoubleBuffered(true);
        setFocusTraversalPolicyProvider(true);
        setMaximumSize(new java.awt.Dimension(886, 237));
        setMinimumSize(new java.awt.Dimension(886, 237));
        setOpaque(true);
        setPreferredSize(new java.awt.Dimension(1094, 286));
        setVisible(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setText("Grayscale Conversion");
        jButton2.setPreferredSize(new java.awt.Dimension(65, 30));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 40, 230, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(" Edge Detection Image"));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setViewportView(jLabel3);

        jPanel2.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 270, 340));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Thersholding Image"));
        jPanel3.setMinimumSize(new java.awt.Dimension(2147483647, 2147483647));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jScrollPane3.setViewportView(jLabel4);

        jPanel3.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 290, 340));

        jButton1.setText("RGB Detector");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 160, 230, 30));

        jButton3.setText("Image Segmaentation");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 270, 230, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed


        
        
        
        
        
        
        
        
        Grayscale gs = new Grayscale();
        try {
            Vector<BufferedImage> v = gs.colourAlgorithm("images//"+InsertImage.filename+".jpg");
            
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
            File select = new File("images//"+InsertImage.filename+".jpg");
        BufferedImage img = null;
        try {
             img = ImageIO.read(select);
           // System.out.println(img);
            
         int width = img.getWidth(null);
                    int hieght = img.getHeight(null);
                   
             j10.setIcon(new ImageIcon(img));
                    j10.setLocation(width, hieght);
                    
                   
                   // jScrollPane1.setViewportView(jLabel2);
        }catch(Exception e)
        {
            
        }
            
            
            JInternalFrame jf1 = new JInternalFrame("Attribute detection for Query Images ");
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
            jf1.moveToFront();
            jf1.show();
            jf1.setSize(getDesktopPane().getSize());
            //desktopIcon.add(jf);
            getDesktopPane().add(jf1);
            //moveToBack();
        } catch (IOException ex) {
            Logger.getLogger(TestingImageProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
        
        
        
      

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        
colour_detection.GenHistogram gen = new GenHistogram();
gen.GenHistogram1(InsertImage.absPath);

// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        
    
        
        
     
        JFrame frame = new JFrame();
        frame.setTitle("Press Face Region Detector");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(new GridLayout(1, 1));

      //  BufferedImage image = null;
      //  try
       // {
        //    image = convertToARGB(ImageIO.read(new File(www.azureinfo.in.InsertImage.absPath)));
      //  }
       // catch (IOException e1)
       // {
          //  e1.printStackTrace();
      //  }

        JPanel panel = new JPanel(new GridLayout(2,2));
        
        
        
        
        
       TensorFlowBasedDetector press = new TensorFlowBasedDetector();

        press.setLowThreshold(0.2f);
        press.setHighThreshold(3f);

        press.setSourceImage(image);
        press.process();
        BufferedImage image1 = press.getEdgesImage();

        int width1 = image1.getWidth(null);
        int hieght1 = image1.getHeight(null);
 panel.add(test.ImageFlipTest.createComponent("Original", image1));
  panel.add(test.ImageFlipTest.createComponent("Inverted Cluster1", createFlipped(image1)));
  panel.add(test.ImageFlipTest.createComponent("Inverted Cluster2", createRotated(image1)));
        panel.add(test.ImageFlipTest.createComponent("Leaf Disease Afficated Place", createInverted(image1)));
      //  jLabel5.setIcon(new ImageIcon(image1));

      //  jLabel5.setLocation(width, hieght);
       // jScrollPane4.setViewportView(jLabel5);

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
    in3 = new ByteArrayInputStream(imageInByte2);
        
        
        
        
        
       
        
        
        
        
        
        
        
       
        

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    
  
        
        try
        {
            String driverName = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/";
            String dbName = "image";
            String userName = "root";
            String password = "root";
            Connection con = null;
            Class.forName(driverName);
            con = DriverManager.getConnection(url + dbName, userName, password);
            Statement st = con.createStatement();

            // create a sql date object so we can use it in our INSERT statement

            // the mysql insert statement
            String query = " insert into test (test_image ,edge_region,threshold_image,pattern_image)"+ " values (?,?,?,?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query);

            File fl = new File(InsertImage.absPath);
            FileInputStream fis1 = new FileInputStream(fl);
            preparedStmt.setBinaryStream (1, fis1);
            preparedStmt.setBinaryStream(2, in1 );
            preparedStmt.setBinaryStream(3, in2);
             preparedStmt.setBinaryStream(4, in3);
            //  preparedStmt.setBlob (2, (Blob) imag);
            //    preparedStmt.setBlob (3, (Blob) img2);

                       JOptionPane.showMessageDialog(null, "Successfully inserted the histogram file into the database!");

            // execute the preparedstatement
            preparedStmt.execute();
           // System.out.println("hai");
            con.close();
        }
        catch (Exception ex)
        {
            Logger.getLogger(QueryProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
            
     
    


// TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables

  









}



