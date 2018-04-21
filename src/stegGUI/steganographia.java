package stegGUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.SwingUtilities;

/**
 *
 * @author Ayisha Sowkathali
 */
public class steganographia {    
    /**
     * main() is the initializer and executes the GUI on an EDT as opposed to
     * the main thread
     *
     * @param args
     */
    public static void main(String args[]) {       
        SwingUtilities.invokeLater(() -> {
            new guiFrontend().setVisible(true);
        });
    }
}
