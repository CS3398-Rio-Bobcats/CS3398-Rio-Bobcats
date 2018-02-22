package chooseFile;


import javax.swing.JFrame;

public class main {
public static void main(String args[]){
        JFrame frame = new JFrame("Steganography");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new browse());
        frame.pack();
        frame.setVisible(true);
        
        
}
}