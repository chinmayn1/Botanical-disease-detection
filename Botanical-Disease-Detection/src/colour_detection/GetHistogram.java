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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author maikon
 */
public class GetHistogram extends JPanel {
    
    Dimension dimPic;
    BufferedImage picture;
    String colorReceived;
    int [] samples;
    public static  String[] sample;
    
    
    public GetHistogram(Dimension d, String color, File image)
    {
        try {
            //to dimension the picture
            dimPic = d;
            colorReceived = color;
            picture = ImageIO.read(image);
        } catch (IOException ex) {
            Logger.getLogger(GetHistogram.class.getName()).log(Level.SEVERE, null, ex);
        }
        getHistogram();  
    }
       
    public void getHistogram()
    {
        samples = new int[256];
        int maxNumSamples = 0;
        
        for(int i=0; i < 255; i++)
        {
            samples[i] = 0;
        }
        
        for(int w=0; w < ( picture.getWidth()); w++ )
        {
            for(int h=0; h < ( picture.getHeight()); h++ )
            {
                
                int alpha =  (0xff &(picture.getRGB(w, h)  >> 24));  
                int ired =  ( 0xff &(picture.getRGB(w, h)  >> 16)); 
                int igreen = (0xff &(picture.getRGB(w, h)  >> 8));
                int iblue =  (0xff & picture.getRGB(w, h));
                
                if("red".equals(colorReceived))
                {
                   samples[ired]++; 
                   if(samples[ired] > maxNumSamples)
                   {
                       maxNumSamples = samples[ired];
                   }
                  
                }
                else if("green".equals(colorReceived))
                {
                   samples[igreen]++; 
                   if(samples[igreen] > maxNumSamples)
                   {
                       maxNumSamples = samples[igreen];
                   }
                }
                else if("blue".equals(colorReceived))
                {
                    samples[iblue]++; 
                   if(samples[iblue] > maxNumSamples)
                   {
                       maxNumSamples = samples[iblue];
                   }
                }            
            } //h
        } //w
        //normalizing
                
        for(int i=0; i < 255; i++)
        {
            samples[i] = (int)((samples[i]*200)/(maxNumSamples));
        }      
    }//getH
    
    public void paintComponent(Graphics g)
    {
      
        if("red".equals(colorReceived))
        {
            g.setColor(Color.RED);
            //g.setColor(Color.GREEN);
             //g.setColor(Color.BLUE);
        }
        else if ("green".equals(colorReceived))
        {
            g.setColor(Color.GREEN);
        }
        else if ("blue".equals(colorReceived))
        {
            g.setColor(Color.BLUE);
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0; i < 255; i++)
        {
            g.drawLine(i, 0,  i, samples[i]);
            sb.append(samples[i]);
                 sb.append(" ");
        }
        
       // System.out.println(sb);
//        long sb1 = new Long(String.valueOf(sb));
        
         try {

            String gender = null;

            String driverName = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/";
            String dbName = "image";
            String userName = "root";
            String password = "root";
            Connection con1 = null;
            Class.forName(driverName);
            con1 = DriverManager.getConnection(url + dbName, userName, password);
            Statement st = con1.createStatement();

            PreparedStatement pre = con1.prepareStatement("insert into histogram(value) " + "values(?)");


            // pre.setString(4, "123456");
           pre.setString(1, String.valueOf(sb));
          // pre.setString(1, String.valueOf(sb));
            pre.executeUpdate();
            //System.out.println(uname + uid + mgen);
         // JOptionPane.showMessageDialog(null, "Successfully inserted the histogram file into the database!");
//System.out.println("Successfully inserted the file into the database!");
            pre.close();
            con1.close();

        } catch (Exception e1) {
            //System.out.println(e1.getMessage());
            JOptionPane.showMessageDialog(null, e1.getMessage());
        }
        
        
        
        
    }
    
    }
    
    
