
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ButtonPanel;

import ButtonComponents.DisplayMessages;
import ImagePreview.ImagePreview;
import imageconverter.ImageConverter;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

/**
 *
 * @author Zach Sotak
 */
public class hideImage extends JPanel {

    private JLabel chooseImgLbl;
    private JLabel entFrmtLbl;
    private JTextField fmtEntFld;
    private JLabel headerLbl;
    private JButton imgBrsBtn;
    private JTextField imgChosenFld;
    private JButton submitBtn;

    public hideImage() {
        initComponents();
    }

    private void initComponents() {

        headerLbl = new JLabel();           // header Label 
        chooseImgLbl = new JLabel();        // Choose Image Label
        imgChosenFld = new JTextField();    // Image Chosen Field
        entFrmtLbl = new JLabel();          // Enter Format Label
        fmtEntFld = new JTextField();       // Format entered label
        imgBrsBtn = new JButton();          // image browse button
        submitBtn = new JButton();          // submit button

        setBackground(new Color(219, 237, 230));

        headerLbl.setBackground(new Color(255, 255, 255));
        headerLbl.setFont(new Font("Georgia", 0, 24)); 
        headerLbl.setText("Hide an Image");

        chooseImgLbl.setFont(new Font("Georgia", 0, 18)); 
        chooseImgLbl.setText("Choose Image to hide ");

        entFrmtLbl.setFont(new Font("Georgia", 0, 18)); 
        entFrmtLbl.setText("Enter Image to hide in, must be signifigantly bigger");

        imgBrsBtn.setFont(new Font("Verdana", 1, 18)); 
        imgBrsBtn.setText("Browse");
        imgBrsBtn.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, 
                Color.darkGray, Color.lightGray, 
                Color.darkGray, Color.lightGray));
        imgBrsBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                browseActionPerformed(evt);
            }
        });

        submitBtn.setFont(new Font("Verdana", 1, 18)); 
        submitBtn.setText("Submit");
        submitBtn.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, 
                Color.darkGray, java.awt.Color.lightGray, Color.darkGray, Color.lightGray));
        submitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, 
                                layout.createSequentialGroup()
                                .addContainerGap(428, Short.MAX_VALUE)
                                .addComponent(headerLbl)
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(imgBrsBtn, 
                                                GroupLayout.PREFERRED_SIZE, 100, 
                                                GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(fmtEntFld, 
                                                        GroupLayout.PREFERRED_SIZE, 451, 
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addComponent(entFrmtLbl)
                                                .addComponent(imgChosenFld, 
                                                        GroupLayout.PREFERRED_SIZE, 451, 
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addComponent(chooseImgLbl))
                                        .addComponent(submitBtn, 
                                                GroupLayout.PREFERRED_SIZE, 100, 
                                                GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(headerLbl)
                                .addGap(78, 78, 78)
                                .addComponent(chooseImgLbl)
                                .addGap(18, 18, 18)
                                .addComponent(imgChosenFld, 
                                        GroupLayout.PREFERRED_SIZE, 50, 
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(imgBrsBtn, 
                                        GroupLayout.PREFERRED_SIZE, 40, 
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(entFrmtLbl)
                                .addGap(18, 18, 18)
                                .addComponent(fmtEntFld, 
                                        GroupLayout.PREFERRED_SIZE, 50, 
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(submitBtn, 
                                        GroupLayout.PREFERRED_SIZE, 40, 
                                        GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(66, Short.MAX_VALUE))
        );
    }

    private void browseActionPerformed(java.awt.event.ActionEvent evt) {                                       

//      logger.getLogger().log(Level.INFO, "User is searching for file");
        if (evt.getSource() == imgBrsBtn) {
            JButton open = new JButton();
            JFileChooser fc = new JFileChooser();
            fc.setCurrentDirectory(new File(System.getenv("USERPROFILE") + "\\Desktop"));
            fc.setDialogTitle("Steganograpy");
            fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            
            if (fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
                imgChosenFld.setText(fc.getSelectedFile().toString());
                //System.out.println(fileNameTF.getText());
                try {
                    ImageConverter.convert(imgChosenFld.getText(), "jpg");
                } catch (Exception ex) {
//                    Logger.getLogger(ButtonPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                File img = new File(ImageConverter.getOutputPathFromInputPath(imgChosenFld.getText(), "jpg"));
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

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
        Thread qThread;
        qThread = new Thread() {
            public void run() {
                String fileChosen1;
                String fileChosen2;
                boolean flag = false;
                if (imgChosenFld.getText().length() == 0) {
//                            logger.getLogger().log(Level.WARNING, "User submitted an empty field text (File Name)");
                    System.out.println("User submitted an empty field text (File Name)");
                }
                fileChosen1 = imgChosenFld.getText();
                if (fmtEntFld.getText().length() == 0) {
//                            logger.getLogger().log(Level.WARNING, "User submitted an empty field (Last Name)");
                    System.out.println("User submitted an empty field text (File Name)");
                }
                fileChosen2 = fmtEntFld.getText();
                DisplayMessages.hideImage(fileChosen1, fileChosen2, flag);
                if (!flag) {
//                            JOptionPane.showMessageDialog(, "Successfully hidden text into file (stego-image.ppm)!");
                    System.out.println("Successfully hidden text into file (stego-image.ppm)!");
                }
            }
        };
        qThread.start();
    }                                                        
}