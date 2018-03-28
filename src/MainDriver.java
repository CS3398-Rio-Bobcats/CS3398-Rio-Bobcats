/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import ButtonPanel.ButtonPanel;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
/**
 *
 * @author Ayisha Sowkathali
 */
public class MainDriver {
    
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        
        JFrame frame = new JFrame("Steganography");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setBounds(300, 300, 700, 400); 
        
        frame.setContentPane(new ButtonPanel());
        
        frame.setVisible(true);
    }
    /**
     * main() is the initializer and executes the GUI on an EDT as opposed to
     * the main thread
     *
     * @param args
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
//            ButtonPanel execute = new ButtonPanel("Steganography");
//            execute.setVisible(true);
            createAndShowGUI();
        });
    }
}
