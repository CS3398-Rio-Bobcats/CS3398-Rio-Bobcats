/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImagePreview;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Jon Pugh
 */
public class ImagePreview extends JPanel{
    

    private BufferedImage bufImage;

    public ImagePreview(File inFile) {
       try {                
          bufImage = ImageIO.read(new File(inFile.getAbsolutePath()));
       } catch (IOException ex) {
            // handle exception...
       }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bufImage, 0, 0, this); // see javadoc for more info on the parameters            
    }

}