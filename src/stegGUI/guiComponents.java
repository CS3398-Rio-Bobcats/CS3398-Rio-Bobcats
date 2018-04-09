package stegGUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ButtonPanel.convertImage;
//import ButtonPanel.hideImage;
import ButtonPanel.revealText;
import ButtonPanel.hideText;
//import ButtonPanel.revealImage;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
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
//    private JButton hideImage;
    private JButton hideText;
    private JPanel mainPanel;
//    private JButton revealImage;
    private JButton revealText;
    private JLabel title;

    GridBagLayout gLayout = new GridBagLayout();
    convertImage cI;
    hideText hT;
//    hideImage hI;
    revealText rT;
//    revealImage rI;    

    public guiComponents() {
        initComponents();

        cI = new convertImage();
        hT = new hideText();
//        hI = new hideImage();
        rT = new revealText();
//        rI = new revealImage();

        dynamicPanel.setLayout(gLayout);
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;
        dynamicPanel.add(cI, c);

        c.gridx = 0;
        c.gridy = 0;
        dynamicPanel.add(hT, c);

//        c.gridx = 0;
//        c.gridy = 0;
//        dynamicPanel.add(hI, c);
        c.gridx = 0;
        c.gridy = 0;
        dynamicPanel.add(rT, c);

//        c.gridx = 0;
//        c.gridy = 0;
//        dynamicPanel.add(rI, c);
        cI.setVisible(true);
        hT.setVisible(false);
//        hI.setVisible(false);
        rT.setVisible(false);
//        rI.setVisible(false);
    }

    private void initComponents() {

        // window properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));

        if (System.getProperty("os.name").contains("Windows")
                || (System.getProperty("os.name").contains("Mac"))) {
            setResizable(false);
        }

        mainPanel = new JPanel();
        headerPanel = new JPanel();
        title = new JLabel();
        buttonPanel = new JPanel();
        dynamicPanel = new JPanel();

        homePanel = new JButton();
        hideText = new JButton();
//        hideImage = new JButton();
        revealText = new JButton();
//        revealImage = new JButton();
        convert = new JButton();
        exit = new JButton();

        // Panel properties
        mainPanel.setBackground(new Color(102, 102, 102));
        mainPanel.setPreferredSize(new Dimension(800, 600));
        mainPanel.setSize(new Dimension(800, 600));

        headerPanel.setBackground(new Color(0, 102, 102));
        headerPanel.setPreferredSize(new Dimension(800, 100));
        headerPanel.setSize(new Dimension(800, 100));

        title.setBackground(new Color(0, 102, 102));
        title.setFont(new Font("PT Mono", 1, 24));
        title.setForeground(new Color(255, 255, 255));
        title.setText("Steganographia");

        GroupLayout headerPanelLayout = new GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
                headerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(headerPanelLayout.createSequentialGroup()
                                .addGap(302, 302, 302)
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

        // button properties
        homePanel.setBackground(new Color(0, 102, 102));
        homePanel.setFont(new Font("Arial", 0, 18));
        homePanel.setForeground(new Color(255, 255, 255));
        homePanel.setText("Welcome");
        homePanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,
                new Color(0, 102, 102), new Color(0, 102, 102),
                new Color(0, 153, 153), new Color(0, 102, 102)));

        hideText.setBackground(new Color(0, 102, 102));
        hideText.setFont(new Font("Arial", 0, 18));
        hideText.setForeground(new Color(255, 255, 255));
        hideText.setText("Text in Image");
        hideText.setToolTipText("Hide text in an image");
        hideText.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,
                new Color(0, 102, 102), new Color(0, 102, 102),
                new Color(0, 153, 153), new Color(0, 102, 102)));
        hideText.addActionListener((ActionEvent evt) -> {
            hideTextActionPerformed(evt);
        });

//        hideImage.setBackground(new java.awt.Color(0, 102, 102));
//        hideImage.setFont(new java.awt.Font("Arial", 0, 18));
//        hideImage.setForeground(new java.awt.Color(255, 255, 255));
//        hideImage.setText("Image in Image");
//        hideImage.setToolTipText("Hide text in an image");
//        hideImage.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,
//                new Color(0, 102, 102), new Color(0, 102, 102),
//                new Color(0, 153, 153), new Color(0, 102, 102)));
//        hideImage.addActionListener((ActionEvent evt) -> {
//            hideImageActionPerformed(evt);
//        });
        revealText.setBackground(new Color(0, 102, 102));
        revealText.setFont(new Font("Arial", 0, 18));
        revealText.setForeground(new Color(255, 255, 255));
        revealText.setText("Reveal Text");
        revealText.setToolTipText("Hide text in an image");
        revealText.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,
                new Color(0, 102, 102), new Color(0, 102, 102),
                new Color(0, 153, 153), new Color(0, 102, 102)));
        revealText.addActionListener((ActionEvent evt) -> {
            revealTextActionPerformed(evt);
        });

//        revealImage.setBackground(new Color(0, 102, 102));
//        revealImage.setFont(new Font("Arial", 0, 18));
//        revealImage.setForeground(new Color(255, 255, 255));
//        revealImage.setText("Reveal Image");
//        revealImage.setToolTipText("Hide text in an image");
//        revealImage.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,
//                new Color(0, 102, 102), new Color(0, 102, 102),
//                new Color(0, 153, 153), new Color(0, 102, 102)));
//        revealImage.addActionListener((ActionEvent evt) -> {
//            revealImageActionPerformed(evt);
//        });
        convert.setBackground(new Color(0, 102, 102));
        convert.setFont(new Font("Arial", 0, 18));
        convert.setForeground(new Color(255, 255, 255));
        convert.setText("Convert Image");
        convert.setToolTipText("Hide text in an image");
        convert.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,
                new Color(0, 102, 102), new Color(0, 102, 102),
                new Color(0, 153, 153), new Color(0, 102, 102)));
        convert.addActionListener((ActionEvent evt) -> {
            convertActionPerformed(evt);
        });

        exit.setBackground(new Color(0, 102, 102));
        exit.setFont(new Font("Arial", 0, 18));
        exit.setForeground(new Color(255, 255, 255));
        exit.setText("Quit");
        exit.setToolTipText("Hide text in an image");
        exit.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,
                new Color(0, 102, 102), new Color(0, 102, 102),
                new Color(0, 153, 153), new Color(0, 102, 102)));
        exit.addActionListener((ActionEvent evt) -> {
            Thread execute = new Thread() {
                @Override
                public void run() {
                    try {
                        exitActionPerformed(evt);
                    } catch (Exception e) {
                        System.exit(0);
                    }
                }
            };
            execute.start();
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
                                        //                                        .addComponent(hideImage)
                                        .addGroup(buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(convert, GroupLayout.Alignment.LEADING)
                                                .addGroup(buttonPanelLayout.createSequentialGroup()
                                                        //                                                        .addComponent(revealImage)
                                                        .addGap(7, 7, 7)))
                                        .addComponent(revealText))
                                .addContainerGap(47, Short.MAX_VALUE))
        );
        buttonPanelLayout.setVerticalGroup(
                buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(buttonPanelLayout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(homePanel)
                                .addGap(25, 25, 25)
                                .addComponent(convert)
                                .addGap(25, 25, 25)
                                .addComponent(hideText)
                                .addGap(25, 25, 25)
                                //                                .addComponent(hideImage)
                                //                                .addGap(18, 18, 18)
                                .addComponent(revealText)
                                .addGap(25, 25, 25)
                                //                                .addComponent(revealImage)
                                //                                .addGap(18, 18, 18)
                                .addComponent(exit)
                                .addContainerGap(157, Short.MAX_VALUE))
        );

        dynamicPanel.setBackground(new Color(0, 102, 102));
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

        GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(headerPanel, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(GroupLayout.Alignment.LEADING,
                                mainPanelLayout.createSequentialGroup()
                                        .addComponent(buttonPanel, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dynamicPanel, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
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

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
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

    /**
     * The function hideTextActionPerformed is designed to display the "hide
     * text" panel which hides the entered text into an image chosen by the
     * user, while the other panels are set to be invisible.
     *
     * @param evt
     */
    private void hideTextActionPerformed(ActionEvent evt) {
        hT.setVisible(true);
//        hI.setVisible(false);
        rT.setVisible(false);
//        rI.setVisible(false);
        cI.setVisible(false);
    }

    /**
     * The function hideImageActionPerformed is designed to display the "hide
     * image" panel which hides one image into another image chosen by the user,
     * while the other panels are set to be invisible.
     *
     * @param evt
     */
//    private void hideImageActionPerformed(ActionEvent evt) {
//        hT.setVisible(false);
//        hI.setVisible(true);
//        rT.setVisible(false);
//        rI.setVisible(false);
//        cI.setVisible(false);
//    }
    /**
     * The function revealTextActionPerformed is designed to display the "reveal
     * text" panel which reveals the hidden text from an image while the other
     * panels are set to be invisible.
     *
     * @param evt
     */
    private void revealTextActionPerformed(ActionEvent evt) {
        hT.setVisible(false);
//        hI.setVisible(false);
        rT.setVisible(true);
//        rI.setVisible(false);
        cI.setVisible(false);
    }

    /**
     * The function revealImageActionPerformed is designed to display the
     * "reveal image" panel which reveals image from another image while the
     * other panels are set to be invisible.
     *
     * @param evt
     */
//    private void revealImageActionPerformed(ActionEvent evt) {
//        hT.setVisible(false);
//        hI.setVisible(false);
//        rT.setVisible(false);
//        rI.setVisible(true);
//        cI.setVisible(false);
//    }
    /**
     * The function convertActionPerformed is designed to display the convert
     * image panel while the other panels are set to be invisible.
     *
     * @param evt
     */
    private void convertActionPerformed(ActionEvent evt) {
        hT.setVisible(false);
//        hI.setVisible(false);
        rT.setVisible(false);
//        rI.setVisible(false);
        cI.setVisible(true);
    }

    /**
     * The function exitActionPerformed is designed to close out of the program,
     * and save the information that was changed or modified within the program
     * into a serializable file.
     *
     * @param evt
     * @return returns value of 3 to close the program, this should never return
     * a value, if it does, a SEVERE error has occurred.
     * @throws Exception The exception in this case is to handle if the closing
     * of the program fails and, allows the program to still run.
     */
    public int exitActionPerformed(ActionEvent evt) throws Exception {
        try {
            System.exit(0);
            return JFrame.EXIT_ON_CLOSE;
        } catch (Exception e) {
            System.out.println("!!Warning!!\nProgram reached beyond limit");
        }
        return JFrame.EXIT_ON_CLOSE;
    }
}
