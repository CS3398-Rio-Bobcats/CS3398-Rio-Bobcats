/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 * @author Zach Sotak (zs1046)
 * @version 1.0
 *
 */
public class ButtonPanel extends PanelComponents  {



    /**
     * Default Constructor for class ButtonPanel
     */

    ButtonPanel() {
    }

    /**
     * MainAppGUI is designed to set the information in each frame of the
     * program, such as the title and the buttons that are within the program.
     *
     * @param title receives the name to set the PanelComponents as.
     */
    ButtonPanel(String title) {
        // Setting title information
        super(title);
        initLogger();

        // Creating a new panel to house the buttons within
        JPanel mainPanel = new JPanel(new BorderLayout());

        Border line = new LineBorder(Color.black, 1);
        Font font1 = new Font("Times New Roman", Font.BOLD, 32);
        JLabel header = new JLabel("STEGANOGRAPHY", JLabel.CENTER);
        // add set properties and add panel to JFrame
        header.setOpaque(true);
        header.setForeground(Color.black);
        header.setBackground(Color.white);
        header.setBorder(line);
        header.setFont(font1);

        JPanel buttonPanel = new JPanel(new GridLayout(6, 0));
        buttonPanel.setBackground(Color.LIGHT_GRAY);
        Font font2 = new Font("Times New Roman", Font.BOLD, 14);
        JLabel introText = new JLabel("\n\nPlease select an option below:");
        introText.setFont(font2);
        introText.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField field = new JTextField(35);
        field.setText("STATUS: Waiting for user...");
        field.setEditable(false);

        // Hide text JButton
        JButton hideText = new JButton("Hide text in an image");
        hideText.setBounds(15, 20, 20, 20);
        hideText.setHorizontalAlignment(SwingConstants.LEFT);

        // Hide an image JButton
        JButton hideImage = new JButton("Hide an image in an image");
        hideImage.setHorizontalAlignment(SwingConstants.LEFT);
        //hideImage.setEnabled(false);

        // Reveal text JButton
        JButton revealText = new JButton("Reveal text from stego image");
        revealText.setHorizontalAlignment(SwingConstants.LEFT);

        // Reveal an image JButton
        JButton revealImage = new JButton("Reveal an image from a stego image");
        revealImage.setHorizontalAlignment(SwingConstants.LEFT);
        //revealImage.setEnabled(false);

        // Convert image JButton
        JButton convertImage = new JButton("Convert image to (ppm, jpg, jpeg, png, gif)");
        convertImage.setHorizontalAlignment(SwingConstants.LEFT);

        JButton exit = new JButton("Exit program");
        exit.setHorizontalAlignment(SwingConstants.LEFT);

        hideText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                getLogger().log(Level.INFO, "User pressed 'Hide text in an image'");
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
                getLogger().log(Level.INFO, "Hide an image in an image");
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
                getLogger().log(Level.INFO, "Reveal text from stego image");
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
                getLogger().log(Level.INFO, "Reveal an image from a stego image");
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
                getLogger().log(Level.INFO, "Convert image to (ppm, jpg, jpeg, png, gif)");
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
                getLogger().log(Level.INFO, "User pressed 'Exit program'");
                Thread qThread = new Thread() {
                    public void run() {
                        try {
                            closeOP();
                        } catch (Exception e) {
                            getLogger().log(Level.SEVERE, e.toString());
                            System.exit(0);
                        }
                    }
                };
                qThread.start();
                field.setText("STATUS: Bye!");
            }
        });

        this.setContentPane(mainPanel);
        mainPanel.setBorder(line);
        mainPanel.add(header, BorderLayout.NORTH);
        mainPanel.add(introText, BorderLayout.LINE_START);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(field, BorderLayout.SOUTH);
        buttonPanel.setBorder(line);
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



}
