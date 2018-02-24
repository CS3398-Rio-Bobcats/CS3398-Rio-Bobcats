package ImagePreview;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePreview extends JPanel{
    
    int longEdge, imgX, imgY;
    float percent;
    private BufferedImage bufImage;
/**
 * Display image preview at correct aspect ratio by passing an int 
 * with the longest desired edge for the preview.
 * 
 * @param  inFile   File variable to image to display in preview (jpg, png, gif)
 * @param  edge     Length of the longest edge to display preview with
 * @author Jon Pugh
 * 
 */
    public ImagePreview(File inFile, int edge) {
       try {                
            longEdge = edge;
            bufImage = ImageIO.read(new File(inFile.getAbsolutePath()));
            imgX = bufImage.getWidth();
            imgY = bufImage.getHeight();
            
            if (imgX > imgY)
            {
                percent = (float) imgY / imgX;
                imgX = longEdge;
                imgY = (int) Math.round(longEdge * percent);
            }
            else if (imgY > imgX)
            {
                percent = (float) imgX / imgY;
                imgY = longEdge;
                imgX = (int) Math.round(longEdge * percent);
            }
            else
            {
                imgX = imgY = longEdge;
            }
       }
       catch (IOException ex) {
            // handle exception...
       }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bufImage, 0, 0, imgX, imgY, null); // see javadoc for more info on the parameters            
    }

}