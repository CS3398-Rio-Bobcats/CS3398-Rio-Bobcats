package ButtonPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.logging.Level;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import steganographer.Steganographer;

/**
 *
 * @author Ayisha Sowkathali
 */
public class ButtonActions {

    logger l = new logger();

    // Create content pane
    PanelComponents pc = new PanelComponents();

    // Needs work
    public void hideTextInImage() {
        JFrame frame = new JFrame("Hide text in an Image");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        pc.newPanel(frame.getContentPane());

        //Display the window.
        frame.setPreferredSize(new Dimension(1000, 150));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        logger.getLogger().log(Level.INFO, "User has entered 'Hide text in an Image'");
    }

    //Needs work
    public void hideImageInImage() {
        JFrame frame1 = new JFrame("Hide an image in another image");
        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //Set up the content pane.
        pc.newPanelDoubleImage(frame1.getContentPane());

        //Display the window.
        frame1.pack();
        frame1.setVisible(true);
        logger.getLogger().log(Level.INFO, "User opened up GUI option to hide an image in another image");
    }

    // Needs work
    public void revealTextFromImage() {
        JFrame frame1 = new JFrame("Reveal text from steganography image");
        JPanel searchpanel = new JPanel();
        JLabel stegField = new JLabel("Stego image:   ");
        JTextField stegName = new JTextField(50);
        JButton stegBrowse = new JButton("Browse");
        JLabel origField = new JLabel("Original image:");
        JTextField origName = new JTextField(50);
        JButton origBrowse = new JButton("Browse");
        JButton submit = new JButton("Submit");
        frame1.setContentPane(searchpanel);
        searchpanel.add(stegField);
        searchpanel.add(stegName);
        searchpanel.add(stegBrowse);
        searchpanel.add(origField);
        searchpanel.add(origName);
        searchpanel.add(origBrowse);
        searchpanel.add(submit);
        searchpanel.setVisible(true);
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                logger.getLogger().log(Level.INFO, "User submitted a file name and text to hide");
                Thread qThread = new Thread() {
                    public void run() {
                        File f = new File(origName.getText());
                        File f2 = new File(stegName.getText());
                        Steganographer steg = new Steganographer(f);
                        String result = steg.reveal(f2, "text");
                        JFrame frame = new JFrame();
                        JOptionPane.showMessageDialog(frame, "Hidden text: " + result);
                    }
                };
                qThread.start();
            }
        });
        stegBrowse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                logger.getLogger().log(Level.INFO, "User is searching for file");
                if (ev.getSource() == stegBrowse) {
                    JButton open = new JButton();
                    JFileChooser fc = new JFileChooser();
                    fc.setCurrentDirectory(new File(System.getenv("USERPROFILE") + "\\Desktop"));
                    fc.setDialogTitle("Select a File");
                    fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                    if (fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
                        stegName.setText(fc.getSelectedFile().toString());
                    }
                }
            }
        });
        origBrowse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                logger.getLogger().log(Level.INFO, "User is searching for file");
                if (ev.getSource() == origBrowse) {
                    JButton open = new JButton();
                    JFileChooser fc = new JFileChooser();
                    fc.setCurrentDirectory(new File(System.getenv("USERPROFILE") + "\\Desktop"));
                    fc.setDialogTitle("Select a File");
                    fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                    if (fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
                        origName.setText(fc.getSelectedFile().toString());
                    }
                }
            }
        });
        //Display the window.
        frame1.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame1.setPreferredSize(new Dimension(800, 150));
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
        searchpanel.setVisible(true);
        logger.getLogger().log(Level.INFO, "User opened up GUI option to reveal text from stego image");
    }

    //Needs work
    protected void revealImageFromImage() {
        JFrame frame1 = new JFrame("Reveal an image from a steganography image");
        JPanel searchpanel = new JPanel();
        JLabel searchfield = new JLabel("Enter file name of image  ");
        JTextField imageName = new JTextField(50);
        JButton browseButton = new JButton("Browse");
        JButton submit = new JButton("Submit");
        frame1.setContentPane(searchpanel);
        searchpanel.add(searchfield);
        searchpanel.add(imageName);
        searchpanel.add(browseButton);
        searchpanel.add(submit);
        searchpanel.setVisible(true);
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                logger.getLogger().log(Level.INFO, "User submitted a file name and text to hide");
                Thread qThread = new Thread() {
                    public void run() {
                    }
                };
                qThread.start();
            }
        });
        browseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                logger.getLogger().log(Level.INFO, "User is searching for file");
                if (ev.getSource() == browseButton) {
                    JButton open = new JButton();
                    JFileChooser fc = new JFileChooser();
                    fc.setCurrentDirectory(new File(System.getenv("USERPROFILE") + "\\Desktop"));
                    fc.setDialogTitle("Select a File");
                    fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                    if (fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
                        imageName.setText(fc.getSelectedFile().toString());
                    }
                }
            }
        });
        //Display the window.
        frame1.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame1.pack();
        frame1.setVisible(true);
        searchpanel.setVisible(true);
        logger.getLogger().log(Level.INFO, "User opened up GUI option reveal an image from stego image");
    }

    //should be working
    public void convertImage() {
        JFrame frame1 = new JFrame("Convert image to (ppm, jpg, jpeg, png, gif)");
        JPanel searchpanel = new JPanel();
        JLabel fileName = new JLabel("Enter file name of image  ");
        JTextField fileNameTF = new JTextField(50);
        JLabel typeText = new JLabel("Format to convert(ppm, jpg, jpeg, png, gif):");
        JTextField typeField = new JTextField(10);
        JButton browseButton = new JButton("Browse");
        JButton submit = new JButton("Submit");
        JTextField field = new JTextField(35);
        field.setText("STATUS: Waiting for user...");
        field.setEditable(false);
        frame1.setContentPane(searchpanel);
        searchpanel.add(fileName);
        searchpanel.add(fileNameTF);
        searchpanel.add(browseButton);
        searchpanel.add(typeText);
        searchpanel.add(typeField);
        searchpanel.add(submit);
        searchpanel.setVisible(true);
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Thread qThread;
                qThread = new Thread() {
                    public void run() {
                        String fileNameTP;
                        String typeTP = null;
                        boolean flag = false;
                        if (fileNameTF.getText().length() == 0) {
                            logger.getLogger().log(Level.WARNING, "User submitted an empty field text (File Name)");
                        }
                        fileNameTP = fileNameTF.getText();
                        if (typeField.getText().length() == 0) {
                            logger.getLogger().log(Level.WARNING, "User submitted an empty field text (Type Name)");
                        }
                        typeTP = typeField.getText();

                        String outputPath = DisplayMessages.convertImage(fileNameTP, typeTP, flag);
                        field.setText("STATUS: Successfully converted file!");
                        if (flag) {
                            JOptionPane.showMessageDialog(searchpanel, "Successfully converted file!");
                        }
                        JFrame frame = new JFrame();
                        JOptionPane.showMessageDialog(frame, "Created image: " + outputPath);
                    }
                };
                qThread.start();
            }
        });
        browseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                logger.getLogger().log(Level.INFO, "User is searching for file");
                if (ev.getSource() == browseButton) {
                    JButton open = new JButton();
                    JFileChooser fc = new JFileChooser();
                    fc.setCurrentDirectory(new File(System.getenv("USERPROFILE") + "\\Desktop")); //might need to change for your computer
                    fc.setDialogTitle("Select a File");
                    fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                    if (fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
                        fileNameTF.setText(fc.getSelectedFile().toString());
                    }
                }
            }
        });
        //Display the window.
        frame1.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame1.setPreferredSize(new Dimension(900, 150));
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
        searchpanel.setVisible(true);
    }

    /**
     * The function ClosesOP is designed to close out of the program, and save
     * the information that was changed or modified within the program into a
     * serializable file.
     *
     * @return returns value of 3 to close the program, this should never return
     * a value, if it does a SEVERE error has occurred.
     * @throws Exception The exception in this case is to handle if the closing
     * of the program fails and, allows the program to still run.
     */
    public int closeOP() throws Exception {
        try {
            //db.writeDatabase();
            logger.getLogger().log(Level.INFO, "User has closed the program via 'Exit' in main menu, exit successful!");
            System.exit(0);
            return JFrame.EXIT_ON_CLOSE;
        } catch (Exception e) {
            System.out.println("PROGRAM SHOULD NEVER REACH THIS POINT UNDERNEATH ANY CIRCUMSTANCE");
            logger.getLogger().log(Level.SEVERE, e.toString());
        }
        return JFrame.EXIT_ON_CLOSE;
    }

}
