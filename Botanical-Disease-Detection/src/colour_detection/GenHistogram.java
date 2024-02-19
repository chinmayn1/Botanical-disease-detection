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
import java.awt.GridLayout;
import java.io.File;
import javax.swing.JFrame;

/**
 *
 * @author maikon
 */
public class GenHistogram extends JFrame {
    
    //constructor
    public void GenHistogram1(String filename)
    {
       // super("Generating Histogram");
        
        File pic =new File(filename);
        setTitle("RGB Detection");
        //setting from the Frame
        setLayout(new GridLayout(2,2));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800,800);
        setVisible(true);
        
        
        //adding the picture
        Dimension d= getSize();
        d.height = d.height/2;
        d.width = d.width/2;
        //System.out.println( d.height+"height");
       // System.out.println(d.width +"Width");
        PaintPicture myPic = new PaintPicture(d,pic);
             
        //PaintPicture myPic2 = new PaintPicture(d);
        GetHistogram myPic2 = new GetHistogram(d,"red", pic);
        GetHistogram myPic3 = new GetHistogram(d,"green",pic);
       GetHistogram myPic4 = new GetHistogram(d,"blue",pic);
        
        add(myPic);
        
       add(myPic2);
        
        add(myPic3);
        add(myPic4);             
       // System.out.println(myPic3);

    
    }
    
         
    
    
   
    
}
