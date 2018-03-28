import ImagePreview.ImagePreview;
import imageconverter.ImageConverter;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ayisha Sowkathali
 */
public class PanelComponents extends ButtonActions {
    
    protected static String PANEL = " ";
    protected static int extraWindowWidth = 100;

    /**
     * @return the PANEL
     */
    public static String getPANEL() {
        return PANEL;
    }

    /**
     * @param aPANEL the PANEL to set
     */
    public static void setPANEL(String aPANEL) {
        PANEL = aPANEL;
    }

    /**
     * @return the extraWindowWidth
     */
    public static int getExtraWindowWidth() {
        return extraWindowWidth;
    }

    /**
     * @param aExtraWindowWidth the extraWindowWidth to set
     */
    public static void setExtraWindowWidth(int aExtraWindowWidth) {
        extraWindowWidth = aExtraWindowWidth;
    }

    public PanelComponents() {
    }

    public PanelComponents(String title) {
        super(title);
    }

    public void newPanel(Container pane) {
        JTabbedPane tabbedPane = new JTabbedPane();
        String imageFileName = "NULL";
        // Panel for selecting file and writing text
        JPanel card1;
        card1 = new JPanel(new GridLayout(3, 1, 1, 1)) {
            @Override
            public Dimension getPreferredSize() {
                Dimension size = super.getPreferredSize();
                size.width += getExtraWindowWidth();
                return size;
            }
        };
        JLabel textToHide = new JLabel("Enter text you wish to hide");
        JTextField textToHideTF = new JTextField("", 20);
        card1.add(textToHide);
        card1.add(textToHideTF);
        JLabel fileName = new JLabel("Enter file name of picture. (Must be .ppm)");
        JTextField fileNameTF = new JTextField("", 40);
        card1.add(fileName);
        card1.add(fileNameTF);
        JButton cSUBMIT = new JButton("Submit");
        card1.add(cSUBMIT);
        JButton browseButton = new JButton("Browse");
        card1.add(browseButton);
        cSUBMIT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread qThread;
                qThread = new Thread() {
                    public void run() {
                        String textToHideTP;
                        String fileNameTP;
                        boolean flag = false;
                        if (fileNameTF.getText().length() == 0) {
                            getLogger().log(Level.WARNING, "User submitted an empty field text (File Name)");
                        }
                        fileNameTP = fileNameTF.getText();
                        if (textToHideTF.getText().length() == 0) {
                            getLogger().log(Level.WARNING, "User submitted an empty field (Last Name)");
                        }
                        textToHideTP = textToHideTF.getText();
                        DisplayMessages.hideText(fileNameTP, textToHideTP, flag);
                        if (!flag) {
                            JOptionPane.showMessageDialog(tabbedPane, "Successfully hidden text into file (stego-image.ppm)!");
                        }
                    }
                };
                qThread.start();
            }
        });
        browseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                getLogger().log(Level.INFO, "User is searching for file");
                if (ev.getSource() == browseButton) {
                    JButton open = new JButton();
                    JFileChooser fc = new JFileChooser();
                    fc.setCurrentDirectory(new File(System.getenv("USERPROFILE") + "\\Desktop"));
                    fc.setDialogTitle("Steganograpy");
                    fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                    if (fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
                        fileNameTF.setText(fc.getSelectedFile().toString());
                        //System.out.println(fileNameTF.getText());
                        try {
                            ImageConverter.convert(fileNameTF.getText(), "jpg");
                        } catch (Exception ex) {
                            Logger.getLogger(ButtonPanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        File img = new File(ImageConverter.getOutputPathFromInputPath(fileNameTF.getText(), "jpg"));
                        ImagePreview ip = new ImagePreview(img, 200);
                        JFrame frame = new JFrame();
                        //card1.add(ip);
                        frame.add(ip);
                        frame.setSize(200, 240);
                        //frame.setDefaultCloseOperation(JFrame.);
                        frame.setVisible(true);
                        /*      //Code used for ImagePreview test
                        File img = new File("tux.jpg");
                        ImagePreview ip = new ImagePreview(img, 150);
                        JFrame frame = new JFrame();
                        frame.add(ip);
                        frame.setSize(400,400);
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.setVisible(true);
                         */
                    }
                }
            }
        });
        tabbedPane.addTab(getPANEL(), card1);
        pane.add(tabbedPane, BorderLayout.WEST);
    }

    //needs work
    public void newPanelDoubleImage(Container pane) {
        JTabbedPane tabbedPane = new JTabbedPane();
        String imageFileName = "NULL";
        // Panel for selecting file and writing text
        JPanel card1 = new JPanel(new GridLayout(4, 3, 1, 1)) {
            public Dimension getPreferredSize() {
                Dimension size = super.getPreferredSize();
                size.width += getExtraWindowWidth();
                return size;
            }
        };
        JLabel imageLarge = new JLabel("File name to hide the image (must be substantially larger than the image to hide)");
        JTextField imageLargeTF = new JTextField("", 50);
        card1.add(imageLarge);
        card1.add(imageLargeTF);
        JLabel imageToHide = new JLabel("Enter file name to hide");
        JTextField imageToHideTF = new JTextField("", 50);
        card1.add(imageToHide);
        card1.add(imageToHideTF);
        JButton browseButton1 = new JButton("1st Browse");
        card1.add(browseButton1);
        JButton browseButton2 = new JButton("2nd Browse");
        card1.add(browseButton2);
        JButton cSUBMIT = new JButton("Submit");
        card1.add(cSUBMIT);
        cSUBMIT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Thread qThread = new Thread() {
                    public void run() {
                        String fileNameTP1;
                        String fileNameTP2;
                        if (imageLargeTF.getText().length() == 0) {
                            getLogger().log(Level.WARNING, "User submitted an empty field text (File Name)");
                        }
                        fileNameTP1 = imageLargeTF.getText();
                        if (imageToHideTF.getText().length() == 0) {
                            getLogger().log(Level.WARNING, "User submitted an empty field (Last Name)");
                        }
                        fileNameTP2 = imageToHideTF.getText();
                    }
                };
                qThread.start();
            }
        });
        browseButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                getLogger().log(Level.INFO, "User is searching for file");
                if (ev.getSource() == browseButton1) {
                    JButton open = new JButton();
                    JFileChooser fc = new JFileChooser();
                    fc.setCurrentDirectory(new File(System.getenv("USERPROFILE") + "\\Desktop"));
                    fc.setDialogTitle("Select a File");
                    fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                    if (fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
                        imageLargeTF.setText(fc.getSelectedFile().toString());
                    }
                }
            }
        });
        browseButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                getLogger().log(Level.INFO, "User is searching for file");
                if (ev.getSource() == browseButton2) {
                    JButton open = new JButton();
                    JFileChooser fc = new JFileChooser();
                    fc.setCurrentDirectory(new File("C:/Users/Galapagos/Pictures"));
                    fc.setDialogTitle("Hello World");
                    fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                    if (fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
                        imageToHideTF.setText(fc.getSelectedFile().toString());
                    }
                }
            }
        });
        tabbedPane.addTab(getPANEL(), card1);
        pane.add(tabbedPane, BorderLayout.WEST);
    }
    
}
