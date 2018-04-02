/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import ButtonPanel.revealImage;
import ButtonPanel.convertImage;
import ButtonPanel.revealText;
import ButtonPanel.hideText;
import ButtonPanel.hideImage;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.logging.Level;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
//import javax.swing.LayoutStyle;
import javax.swing.border.BevelBorder;

/**
 *
 * @author Ayisha Sowkathali
 */
public class guiComponents extends JFrame {

    private JPanel buttonPanel;
    private JButton convert;
    private JPanel dynamicPanel;
    private JButton exit;
    private JPanel headerPanel;
    private JButton homePanel;
    private JButton hideImage;
    private JButton hideText;
    private JPanel mainPanel;
    private JButton revealImage;
    private JButton revealText;
    private JLabel title;

    GridBagLayout gLayout = new GridBagLayout();
    hideText hT;
    hideImage hI;
    revealText rT;
    revealImage rI;
    convertImage cI;

    public guiComponents() {
        initComponents();

        hT = new hideText();
        hI = new hideImage();
        rT = new revealText();
        rI = new revealImage();
        cI = new convertImage();

        dynamicPanel.setLayout(gLayout);
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        dynamicPanel.add(hT, c);
        c.gridx = 0;
        c.gridy = 0;
        dynamicPanel.add(hI, c);
        c.gridx = 0;
        c.gridy = 0;
        dynamicPanel.add(rT, c);
        c.gridx = 0;
        c.gridy = 0;
        dynamicPanel.add(rI, c);
        c.gridx = 0;
        c.gridy = 0;
        dynamicPanel.add(cI, c);
        hT.setVisible(true);
        hI.setVisible(false);
        rT.setVisible(false);
        rI.setVisible(false);
        cI.setVisible(false);
    }

    private void initComponents() {

        mainPanel = new JPanel();
        headerPanel = new JPanel();
        title = new JLabel();
        buttonPanel = new JPanel();

        homePanel = new JButton();
        hideText = new JButton();
        hideImage = new JButton();
        revealText = new JButton();
        revealImage = new JButton();
        convert = new JButton();
        exit = new JButton();

        dynamicPanel = new JPanel();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new Dimension(900, 700));

        mainPanel.setBackground(new Color(102, 102, 102));
        mainPanel.setPreferredSize(new Dimension(800, 600));
        mainPanel.setSize(new Dimension(800, 600));

        headerPanel.setBackground(new Color(0, 102, 102));
        headerPanel.setPreferredSize(new Dimension(800, 100));
        headerPanel.setSize(new Dimension(800, 100));

        title.setBackground(new Color(0, 102, 102));
        title.setFont(new Font("PT Mono", 1, 24)); // NOI18N
        title.setForeground(new Color(255, 255, 255));
        title.setText("Steganographia");

        GroupLayout headerPanelLayout = new GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
                headerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(headerPanelLayout.createSequentialGroup()
                                .addGap(237, 237, 237)
                                .addComponent(title)
                                .addContainerGap(280, Short.MAX_VALUE))
        );
        headerPanelLayout.setVerticalGroup(
                headerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(headerPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(title)
                                .addContainerGap(66, Short.MAX_VALUE))
        );

        buttonPanel.setBackground(new Color(0, 102, 102));
        buttonPanel.setMaximumSize(new Dimension(200, 500));
        buttonPanel.setPreferredSize(new Dimension(200, 500));
        buttonPanel.setSize(new Dimension(200, 500));

        homePanel.setBackground(new Color(0, 102, 102));
        homePanel.setFont(new Font("Arial", 0, 18)); 
        homePanel.setForeground(new Color(255, 255, 255));
        homePanel.setText("Welcome");
        homePanel.setToolTipText("Welcome : Drag and Drop item");
        homePanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,
                new Color(0, 102, 102), new Color(0, 102, 102),
                new Color(0, 153, 153), new Color(0, 102, 102)));
        homePanel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                homePanelActionPerformed(evt);
            }
        });

        hideText.setBackground(new Color(0, 102, 102));
        hideText.setFont(new Font("Arial", 0, 18)); 
        hideText.setForeground(new Color(255, 255, 255));
        hideText.setText("Text in Image");
        hideText.setToolTipText("Hide text in an image");
        hideText.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,
                new Color(0, 102, 102), new Color(0, 102, 102),
                new Color(0, 153, 153), new Color(0, 102, 102)));
        hideText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                hideTextActionPerformed(evt);
            }
        });

        hideImage.setBackground(new java.awt.Color(0, 102, 102));
        hideImage.setFont(new java.awt.Font("Arial", 0, 18)); 
        hideImage.setForeground(new java.awt.Color(255, 255, 255));
        hideImage.setText("Image in Image");
        hideImage.setToolTipText("Hide text in an image");
        hideImage.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, 
                new Color(0, 102, 102), new Color(0, 102, 102), 
                new Color(0, 153, 153), new Color(0, 102, 102)));
        hideImage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                hideImageActionPerformed(evt);
            }
        });

        revealText.setBackground(new Color(0, 102, 102));
        revealText.setFont(new Font("Arial", 0, 18)); 
        revealText.setForeground(new Color(255, 255, 255));
        revealText.setText("Reveal Text");
        revealText.setToolTipText("Hide text in an image");
        revealText.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, 
                new Color(0, 102, 102), new Color(0, 102, 102), 
                new Color(0, 153, 153), new Color(0, 102, 102)));
        revealText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                revealTextActionPerformed(evt);
            }
        });

        revealImage.setBackground(new Color(0, 102, 102));
        revealImage.setFont(new Font("Arial", 0, 18)); 
        revealImage.setForeground(new Color(255, 255, 255));
        revealImage.setText("Reveal Image");
        revealImage.setToolTipText("Hide text in an image");
        revealImage.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,
                new Color(0, 102, 102), new Color(0, 102, 102),
                new Color(0, 153, 153), new Color(0, 102, 102)));
        revealImage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                revealImageActionPerformed(evt);
            }
        });

        convert.setBackground(new Color(0, 102, 102));
        convert.setFont(new Font("Arial", 0, 18)); 
        convert.setForeground(new Color(255, 255, 255));
        convert.setText("Convert Image");
        convert.setToolTipText("Hide text in an image");
        convert.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,
                new Color(0, 102, 102), new Color(0, 102, 102),
                new Color(0, 153, 153), new Color(0, 102, 102)));
        convert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                convertActionPerformed(evt);
            }
        });

        exit.setBackground(new Color(0, 102, 102));
        exit.setFont(new Font("Arial", 0, 18)); 
        exit.setForeground(new Color(255, 255, 255));
        exit.setText("Quit");
        exit.setToolTipText("Hide text in an image");
        exit.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,
                new Color(0, 102, 102), new Color(0, 102, 102),
                new Color(0, 153, 153), new Color(0, 102, 102)));
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //                logger.getLogger().log(Level.INFO, "User pressed 'Exit program'");
                Thread qThread = new Thread() {
                    public void run() {
                        try {
//                            bA.closeOP();
                            exitActionPerformed(evt);
                        } catch (Exception e) {
//                            logger.getLogger().log(Level.SEVERE, e.toString());
                            System.exit(0);
                        }
                    }
                };
                qThread.start();
//                field.setText("STATUS: Bye!");

            }
        });

        GroupLayout buttonPanelLayout = new GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
                buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(buttonPanelLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(homePanel)
                                        .addComponent(exit)
                                        .addComponent(hideText)
                                        .addComponent(hideImage)
                                        .addGroup(buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(convert, GroupLayout.Alignment.LEADING)
                                                .addGroup(buttonPanelLayout.createSequentialGroup()
                                                        .addComponent(revealImage)
                                                        .addGap(7, 7, 7)))
                                        .addComponent(revealText))
                                .addContainerGap(47, Short.MAX_VALUE))
        );
        buttonPanelLayout.setVerticalGroup(
                buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(buttonPanelLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(homePanel)
                                .addGap(18, 18, 18)
                                .addComponent(hideText)
                                .addGap(18, 18, 18)
                                .addComponent(hideImage)
                                .addGap(18, 18, 18)
                                .addComponent(revealText)
                                .addGap(18, 18, 18)
                                .addComponent(revealImage)
                                .addGap(18, 18, 18)
                                .addComponent(convert)
                                .addGap(18, 18, 18)
                                .addComponent(exit)
                                .addContainerGap(157, Short.MAX_VALUE))
        );

        dynamicPanel.setBackground(new Color(204, 204, 204));
        dynamicPanel.setSize(new Dimension(600, 500));

        GroupLayout dynamicPanelLayout = new GroupLayout(dynamicPanel);
        dynamicPanel.setLayout(dynamicPanelLayout);
        dynamicPanelLayout.setHorizontalGroup(
                dynamicPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 590, Short.MAX_VALUE)
        );
        dynamicPanelLayout.setVerticalGroup(
                dynamicPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(headerPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(GroupLayout.Alignment.LEADING, mainPanelLayout.createSequentialGroup()
                                .addComponent(buttonPanel, 
                                        GroupLayout.PREFERRED_SIZE, 
                                        GroupLayout.DEFAULT_SIZE, 
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dynamicPanel, GroupLayout.DEFAULT_SIZE, 
                                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(headerPanel, 
                                        GroupLayout.PREFERRED_SIZE, 
                                        GroupLayout.DEFAULT_SIZE, 
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(buttonPanel, 
                                                GroupLayout.PREFERRED_SIZE, 494, 
                                                Short.MAX_VALUE)
                                        .addComponent(dynamicPanel, 
                                                GroupLayout.DEFAULT_SIZE, 
                                                GroupLayout.DEFAULT_SIZE, 
                                                Short.MAX_VALUE)))
        );

        headerPanel.getAccessibleContext().setAccessibleParent(this);

        javax.swing.GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, 
                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, 
                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void homePanelActionPerformed(ActionEvent evt) {
        // Drag and drop file panel
    }

    private void hideTextActionPerformed(ActionEvent evt) {
        hT.setVisible(true);
        hI.setVisible(false);
        rT.setVisible(false);
        rI.setVisible(false);
        cI.setVisible(false);
    }

    private void hideImageActionPerformed(ActionEvent evt) {
        hT.setVisible(false);
        hI.setVisible(true);
        rT.setVisible(false);
        rI.setVisible(false);
        cI.setVisible(false);
    }

    private void revealTextActionPerformed(ActionEvent evt) {
        hT.setVisible(false);
        hI.setVisible(false);
        rT.setVisible(true);
        rI.setVisible(false);
        cI.setVisible(false);
    }

    private void revealImageActionPerformed(ActionEvent evt) {
        hT.setVisible(false);
        hI.setVisible(false);
        rT.setVisible(false);
        rI.setVisible(true);
        cI.setVisible(false);
    }

    private void convertActionPerformed(ActionEvent evt) {

        hT.setVisible(false);
        hI.setVisible(false);
        rT.setVisible(false);
        rI.setVisible(false);
        cI.setVisible(true);
    }

    /**
     * The function ClosesOP is designed to close out of the program, and save
     * the information that was changed or modified within the program into a
     * serializable file.
     *
     * @param evt
     * @return returns value of 3 to close the program, this should never return
     * a value, if it does a SEVERE error has occurred.
     * @throws Exception The exception in this case is to handle if the closing
     * of the program fails and, allows the program to still run.
     */
    public int exitActionPerformed(ActionEvent evt) throws Exception {
        try {
            //db.writeDatabase();
//            logger.getLogger().log(Level.INFO, "User has closed the program via 'Exit' in main menu, exit successful!");
            System.exit(0);
            return JFrame.EXIT_ON_CLOSE;
        } catch (Exception e) {
            System.out.println("PROGRAM SHOULD NEVER REACH THIS POINT UNDERNEATH ANY CIRCUMSTANCE");
//            logger.getLogger().log(Level.SEVERE, e.toString());
        }
        return JFrame.EXIT_ON_CLOSE;
    }
}
