package guiattempt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.*;
import java.util.Scanner;
import java.util.*;
import javax.swing.JOptionPane;
import java.util.logging.*;
import java.io.*;
import java.util.logging.Formatter;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

/**
 * @author Zach Sotak (zs1046)
 * @version 1.0
 *
 */

public class MainAppGUI extends JFrame {

    private static final Logger logger = Logger.getLogger(MainAppGUI.class.getName());
    private static FileHandler fh;
    
    private static final String PANEL = "Select File";

    private final static int extraWindowWidth = 100;
    /**
     * Default Constructor for class MainAppGUI
     */

    MainAppGUI() {

    }

    /**
     * Class CustomFormatter overrides the format method of the superclass Formatter in order to format the
     * Logger output when writing to a file to a readable format (as opposed to the default XML format)
     */

    class CustomFormatter extends Formatter {
        private final DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SSS");

        /**
         * format() method overrides the superclass's method in order to obtain a much simpler output
         * @param record refers to the LogRecord to change
         * @return builder.toString(), the String which will be the new format for each log event
         */
        @Override
        public String format(LogRecord record) {
            StringBuilder builder = new StringBuilder(1000);
            builder.append(df.format(new Date(record.getMillis()))).append(" - ");
            builder.append("[").append(record.getSourceClassName()).append(".");
            builder.append(record.getSourceMethodName()).append("] :");
            builder.append("\n");
            builder.append("\t[").append(record.getLevel()).append("] - ");
            builder.append(formatMessage(record));
            builder.append("\n");
            return builder.toString();
        }
    }

    /**
     * initLogger() method initializes the Logger environment for the class upon call
     */
    private void initLogger() {
        logger.setUseParentHandlers(false);
        CustomFormatter formatter = new CustomFormatter();
        try {
            fh = new FileHandler("log.txt");
            fh.setFormatter(formatter);
            logger.addHandler(fh);
        }
        catch (IOException e) {
            logger.log(Level.SEVERE, "FileHandler threw IOException", e);
        }
    }

    /**
     * MainAppGUI is designed to set the information in each frame of the program, such as the title and the buttons
     * that are within the program.
     * @param title receives the name to set the window as.
     */

    private MainAppGUI(String title) {
        // Setting title information
        super(title);
        initLogger();

        // Creating a new panel to house the buttons within
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel buttonPanel = new JPanel(new GridLayout(6, 0));
        JLabel introText = new JLabel("\n\nPlease select an option below:");
        JTextField field = new JTextField(35);
        introText.setHorizontalAlignment(SwingConstants.CENTER);
        field.setText("STATUS: Waiting for user...");
        field.setEditable(false);

        // Hide text JButton
        JButton hideText = new JButton("Hide text in an image");
        hideText.setHorizontalAlignment(SwingConstants.LEFT);

        // Hide an image JButton
        JButton hideImage = new JButton("Hide an image in an image");
        hideImage.setHorizontalAlignment(SwingConstants.LEFT);

        // Reveal text JButton
        JButton revealText = new JButton("Reveal text from stego image");
        revealText.setHorizontalAlignment(SwingConstants.LEFT);

        // Reveal an image JButton
        JButton revealImage = new JButton("Reveal an image from a stego image");
        revealImage.setHorizontalAlignment(SwingConstants.LEFT);

        // Convert image JButton
        JButton convertImage = new JButton("Convert image to (ppm, jpg, jpeg, png, gif)");
        convertImage.setHorizontalAlignment(SwingConstants.LEFT);


        JButton exit = new JButton("Exit program");
        exit.setHorizontalAlignment(SwingConstants.LEFT);


        hideText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                logger.log(Level.INFO, "User pressed 'Hide text in an image'");
                field.setText("STATUS: selecting image...");
                Thread qThread = new Thread() {
                    public void run() {
                        hideTextInImage();
                    }
                };
                qThread.start();
            }
        });

        hideImage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                logger.log(Level.INFO, "Hide an image in an image");
                field.setText("STATUS: selecting images...");
                Thread qThread = new Thread() {
                    public void run() {
                        hideImageInImage();
                    }
                };
                qThread.start();
            }
        });

        revealText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                logger.log(Level.INFO, "Reveal text from stego image");
                field.setText("STATUS: Revealing text from image...");
                Thread qThread = new Thread() {
                    public void run() {
                        revealTextFromImage();
                    }
                };
                qThread.start();
            }
        });

        revealImage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                logger.log(Level.INFO, "Reveal an image from a stego image");
                field.setText("STATUS: Revaling image from image...");
                Thread qThread = new Thread() {
                    public void run() {
                        revealImageFromImage();
                    }
                };
                qThread.start();
            }
        });

        convertImage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                logger.log(Level.INFO, "Convert image to (ppm, jpg, jpeg, png, gif)");
                field.setText("STATUS: Converting image...");
                Thread qThread = new Thread() {
                    public void run() {
                        convertImage();
                    }
                };
                qThread.start();
            }
        });

        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                logger.log(Level.INFO, "User pressed 'Exit program'");
                Thread qThread = new Thread() {
                    public void run() {
                        try {
                            closeOP();
                        }catch (Exception e) {
                            logger.log(Level.SEVERE,e.toString());
                            System.exit(0);
                        }
                    }
                };
                qThread.start();
                field.setText("STATUS: Bye!");
            }
        });

        this.setContentPane(mainPanel);
        mainPanel.add(introText, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(field, BorderLayout.SOUTH);
        buttonPanel.add(hideText);
        buttonPanel.add(hideImage);
        buttonPanel.add(revealText);
        buttonPanel.add(revealImage);
        buttonPanel.add(convertImage);
        buttonPanel.add(exit);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null); // Centers Program
        this.setVisible(true);

        logger.log(Level.INFO, "User has loaded main menu of GUI");
    }
public void newPanel(Container pane) {
        JTabbedPane tabbedPane = new JTabbedPane();
        String imageFileName = "NULL";

        // Panel for selecting file and writing text
        JPanel card1 = new JPanel(new GridLayout(3,1,1,1)) {
            public Dimension getPreferredSize() {
                Dimension size = super.getPreferredSize();
                size.width += extraWindowWidth;
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
        
        


        JButton cSUBMIT = new JButton ("Submit");
        card1.add(cSUBMIT);
        JButton browseButton = new JButton("Browse");
        card1.add(browseButton);
        


        cSUBMIT.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                Thread qThread = new Thread() {
                    public void run() {
                        String fileNameTP, textToHideTP;
                        

                        if (fileNameTF.getText().length() == 0) {
                          
                            logger.log(Level.WARNING, "User submitted an empty field text (File Name)");
                        }

                        fileNameTP = fileNameTF.getText();


                        if (textToHideTF.getText().length() == 0) {
                        
                            logger.log(Level.WARNING, "User submitted an empty field (Last Name)");
                        }

                        textToHideTP = textToHideTF.getText();

                    }
                };
                qThread.start();
            }
        });

        browseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                logger.log(Level.INFO, "User is searching for file");
               if(ev.getSource() == browseButton){
	                	JButton open = new JButton();
	            		JFileChooser fc = new JFileChooser();
	            		fc.setCurrentDirectory(new java.io.File("C:/Users"));
	            		fc.setDialogTitle("Hello World");
	            		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
	            		if (fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
	            			fileNameTF.setText(fc.getSelectedFile().toString());
	            		}
                           
               }
            }
        });

        tabbedPane.addTab(PANEL, card1);

        pane.add(tabbedPane, BorderLayout.WEST);
    }

public void newPanelDoubleImage(Container pane) {
        JTabbedPane tabbedPane = new JTabbedPane();
        String imageFileName = "NULL";

        // Panel for selecting file and writing text
        JPanel card1 = new JPanel(new GridLayout(4,3,1,1)) {
            public Dimension getPreferredSize() {
                Dimension size = super.getPreferredSize();
                size.width += extraWindowWidth;
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
        JButton cSUBMIT = new JButton ("Submit");
        card1.add(cSUBMIT);
        


        cSUBMIT.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                Thread qThread = new Thread() {
                    public void run() {
                        String fileNameTP1, fileNameTP2;
                       
                        if (imageLargeTF.getText().length() == 0) {                      
                            logger.log(Level.WARNING, "User submitted an empty field text (File Name)");
                        }

                        fileNameTP1 = imageLargeTF.getText();


                        if (imageToHideTF.getText().length() == 0) {
                         
                            logger.log(Level.WARNING, "User submitted an empty field (Last Name)");
                        }

                        fileNameTP2 = imageToHideTF.getText();

                    }
                };
                qThread.start();
            }
        });

        browseButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                logger.log(Level.INFO, "User is searching for file");
               if(ev.getSource() == browseButton1){
	                	JButton open = new JButton();
	            		JFileChooser fc = new JFileChooser();
	            		fc.setCurrentDirectory(new java.io.File("C:/Users"));
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
                logger.log(Level.INFO, "User is searching for file");
               if(ev.getSource() == browseButton2){
	                	JButton open = new JButton();
	            		JFileChooser fc = new JFileChooser();
	            		fc.setCurrentDirectory(new java.io.File("C:/Users/Galapagos/Pictures"));
	            		fc.setDialogTitle("Hello World");
	            		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
	            		if (fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
	            			imageToHideTF.setText(fc.getSelectedFile().toString());
	            		}
                           
               }
            }
        });

        tabbedPane.addTab(PANEL, card1);

        pane.add(tabbedPane, BorderLayout.WEST);
    }

    public void hideTextInImage() {
        
       JFrame frame = new JFrame("Hide text in an Image");
       frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       
       //Create and set up the content pane.
       MainAppGUI x = new MainAppGUI();
       x.newPanel(frame.getContentPane());
       
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        logger.log(Level.INFO, "User has entered 'Hide text in an Image'");
       
}

    
    public void hideImageInImage() {

        JFrame frame1 = new JFrame("Hide an image in another image");
        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       
       //Create and set up the content pane.
        MainAppGUI x = new MainAppGUI();
        x.newPanelDoubleImage(frame1.getContentPane());
       
        //Display the window.
        frame1.pack();
        frame1.setVisible(true);
        
        logger.log(Level.INFO, "User opened up GUI option to hide an image in another image");
    }

    public void revealTextFromImage() {

        JFrame frame1 = new JFrame("Reveal text from steganography image");
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
                logger.log(Level.INFO, "User submitted a file name and text to hide");
                Thread qThread = new Thread(){
                public void run(){       
                }
                
                };
                qThread.start();
            }
        });
        
        browseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                logger.log(Level.INFO, "User is searching for file");
               if(ev.getSource() == browseButton){
	                	JButton open = new JButton();
	            		JFileChooser fc = new JFileChooser();
	            		fc.setCurrentDirectory(new java.io.File("C:/Users"));
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
        logger.log(Level.INFO, "User opened up GUI option to reveal text from stego image");
    }

    
    private void revealImageFromImage() {

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
                logger.log(Level.INFO, "User submitted a file name and text to hide");
                Thread qThread = new Thread(){
                public void run(){       
                }
                
                };
                qThread.start();
            }
        });
        
        browseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                logger.log(Level.INFO, "User is searching for file");
               if(ev.getSource() == browseButton){
	                	JButton open = new JButton();
	            		JFileChooser fc = new JFileChooser();
	            		fc.setCurrentDirectory(new java.io.File("C:/Users"));
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
        logger.log(Level.INFO, "User opened up GUI option reveal an image from stego image");
    }


    public void convertImage() {

        JFrame frame1 = new JFrame("Convert image to (ppm, jpg, jpeg, png, gif)");
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
                logger.log(Level.INFO, "User submitted a file name and text to hide");
                Thread qThread = new Thread(){
                public void run(){       
                }
                
                };
                qThread.start();
            }
        });
        
        browseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                logger.log(Level.INFO, "User is searching for file");
               if(ev.getSource() == browseButton){
	                	JButton open = new JButton();
	            		JFileChooser fc = new JFileChooser();
	            		fc.setCurrentDirectory(new java.io.File("C:/Users"));
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
    }
   
    
    /**
     * main() is the initializer and executes the GUI on an EDT as opposed to the main thread
     * @param args
     */
    public static void main (String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainAppGUI execute = new MainAppGUI("Steganography");
            execute.setVisible(true);
        });
    }

    /**
     * The function ClosesOP is designed to close out of the program, and save the information that was changed or
     * modified within the program into a serializable file.
     * @return returns value of 3 to close the program, this should never return a value, if it does a SEVERE error has
     * occurred.
     * @throws Exception The exception in this case is to handle if the closing of the program fails and, allows the
     * program to still run.
     */
    public int closeOP() throws Exception {
        try {
            //db.writeDatabase();
            logger.log(Level.INFO, "User has closed the program via 'Exit' in main menu, exit successful!");

            System.exit(0);
            return JFrame.EXIT_ON_CLOSE;
        } catch (Exception e){
            System.out.println("PROGRAM SHOULD NEVER REACH THIS POINT UNDERNEATH ANY CIRCUMSTANCE");
            logger.log(Level.SEVERE,e.toString());
        }
        return JFrame.EXIT_ON_CLOSE;
    }
}
