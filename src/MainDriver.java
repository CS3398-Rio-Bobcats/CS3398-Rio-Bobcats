import javax.swing.SwingUtilities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ayisha Sowkathali
 */
public class MainDriver {
    
//    public static void createAndShowGUI() {
//        JFrame frame = new JFrame("Steganography");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setBounds(100, 100, 400, 400);
//        frame.add(new LeftPanel());
//        frame.add(new RightPanel());
//        frame.setVisible(true);
//    }
    /**
     * main() is the initializer and executes the GUI on an EDT as opposed to
     * the main thread
     *
     * @param args
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ButtonPanel execute = new ButtonPanel("Steganography");
            execute.setVisible(true);
//            createAndShowGUI();
        });
    }
}
