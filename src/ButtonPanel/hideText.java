/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ButtonPanel;

import ImagePreview.ImagePreview;
import imageconverter.ImageConverter;
import java.awt.Color;
<<<<<<< HEAD
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
=======
import java.awt.Cursor;
import java.awt.Font;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
>>>>>>> master
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
<<<<<<< HEAD
=======
import javax.swing.JOptionPane;
>>>>>>> master
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

/**
<<<<<<< HEAD
 *
 * @author Ayisha Sowkathali
 */
public class hideText extends JPanel {
                        
=======
 * This class is responsible for the hiding text in an image function of this
 * application
 *
 * @author Ayisha Sowkathali
 * @author Zack Sotak
 */
public class hideText extends JPanel {

>>>>>>> master
    private JButton browse;
    private JLabel chIooseImgLbl;
    private JTextField chosenImage;
    private JLabel entTxtLbl;
    private JLabel hdrLbl;
    private JButton submit;
    private JTextField textEntered;

    public hideText() {
        initComponents();
    }
<<<<<<< HEAD
                       
=======

>>>>>>> master
    private void initComponents() {

        hdrLbl = new JLabel();
        entTxtLbl = new JLabel();
        textEntered = new JTextField();
        chIooseImgLbl = new JLabel();
        chosenImage = new JTextField();
        browse = new JButton();
        submit = new JButton();

<<<<<<< HEAD
        setBackground(new Color(190, 239, 237));
=======
        setBackground(new Color(231, 241, 248));
>>>>>>> master

        hdrLbl.setBackground(new Color(255, 255, 255));
        hdrLbl.setFont(new Font("Georgia", 0, 24)); // NOI18N
        hdrLbl.setText("Hide Text in an Image");

        entTxtLbl.setFont(new Font("Georgia", 0, 18)); // NOI18N
        entTxtLbl.setText("Enter text you wish to hide");

        textEntered.setFont(new Font("Century", 0, 14)); // NOI18N
        textEntered.setToolTipText("Enter text you wish to hide");
<<<<<<< HEAD
        textEntered.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        chIooseImgLbl.setFont(new Font("Georgia", 0, 18)); // NOI18N
        chIooseImgLbl.setText("Choose Image (.ppm)");

        browse.setFont(new Font("Verdana", 1, 18)); // NOI18N
        browse.setText("Browse");
        browse.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, 
                Color.darkGray, Color.lightGray, Color.darkGray, Color.lightGray));
        browse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                browseActionPerformed(evt);
            }
        });

        submit.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        submit.setText("Submit");
        submit.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, 
                Color.darkGray, Color.lightGray, Color.darkGray, Color.lightGray));
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                submitActionPerformed(evt);
            }
=======
        textEntered.setCursor(new Cursor(Cursor.TEXT_CURSOR));

        chIooseImgLbl.setFont(new Font("Georgia", 0, 18)); // NOI18N
        chIooseImgLbl.setText("Choose Image");

        // Drag and Drop Image
        chosenImage.setDropTarget(new DropTarget() {
            public synchronized void drop(DropTargetDropEvent evt) {
                try {
                    evt.acceptDrop(DnDConstants.ACTION_COPY);
                    List<File> droppedFiles = (List<File>) evt
                            .getTransferable().getTransferData(
                                    DataFlavor.javaFileListFlavor);
                    for (File file : droppedFiles) {
                        chosenImage.setText(file.getAbsolutePath());
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        browse.setFont(new Font("Verdana", 1, 18)); // NOI18N
        browse.setText("Browse");
        browse.setBorder(new SoftBevelBorder(BevelBorder.LOWERED,
                Color.darkGray, Color.lightGray,
                Color.darkGray, Color.lightGray));
        browse.addActionListener((ActionEvent evt) -> {
            browseActionPerformed(evt);
        });

        submit.setFont(new Font("Verdana", 1, 18)); // NOI18N
        submit.setText("Submit");
        submit.setBorder(new SoftBevelBorder(BevelBorder.LOWERED,
                Color.darkGray, Color.lightGray,
                Color.darkGray, Color.lightGray));
        submit.addActionListener((ActionEvent evt) -> {
            submitActionPerformed(evt);
>>>>>>> master
        });

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
<<<<<<< HEAD
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(entTxtLbl)
                    .addComponent(textEntered, GroupLayout.PREFERRED_SIZE, 500, 
                            GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, 
                            layout.createSequentialGroup()
                        .addComponent(hdrLbl)
                        .addContainerGap())
                    .addGroup(GroupLayout.Alignment.TRAILING, 
                            layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(
                                GroupLayout.Alignment.TRAILING)
                            .addComponent(chosenImage, 
                                    GroupLayout.Alignment.LEADING, 
                                    GroupLayout.PREFERRED_SIZE, 500, 
                                    GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(browse, 
                                        GroupLayout.PREFERRED_SIZE, 100, 
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(submit, 
                                        GroupLayout.PREFERRED_SIZE, 100, 
                                        GroupLayout.PREFERRED_SIZE))
                            .addComponent(chIooseImgLbl, 
                                    GroupLayout.Alignment.LEADING))
                        .addGap(49, 49, 49))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hdrLbl)
                .addGap(52, 52, 52)
                .addComponent(entTxtLbl)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textEntered, GroupLayout.PREFERRED_SIZE, 130, 
                        GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 42, 
                        Short.MAX_VALUE)
                .addComponent(chIooseImgLbl)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chosenImage, GroupLayout.PREFERRED_SIZE, 45, 
                        GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(browse, GroupLayout.PREFERRED_SIZE, 40, 
                            GroupLayout.PREFERRED_SIZE)
                    .addComponent(submit, GroupLayout.PREFERRED_SIZE, 40, 
                            GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );
    }// </editor-fold>                        

    private void browseActionPerformed(java.awt.event.ActionEvent evt) {                                       

//      logger.getLogger().log(Level.INFO, "User is searching for file");
=======
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(hdrLbl)
                                                .addContainerGap())
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(browse, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(50, 50, 50)
                                                                .addComponent(submit, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(entTxtLbl)
                                                                .addComponent(textEntered, GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                                                                .addComponent(chIooseImgLbl)
                                                                .addComponent(chosenImage, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                .addGap(50, 50, 50))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(hdrLbl)
                                .addGap(52, 52, 52)
                                .addComponent(entTxtLbl)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textEntered, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                                .addComponent(chIooseImgLbl)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(chosenImage, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                                .addGap(132, 132, 132))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(browse, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(submit, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                                .addGap(65, 65, 65))))
        );
    }

    /**
     * This is the action taken when the browse button is pushed and the file
     * chooser will make a pop-up window of your files and allow you to select a
     * file.
     *
     * @param evt
     */
    private void browseActionPerformed(ActionEvent evt) {
>>>>>>> master
        if (evt.getSource() == browse) {
            JButton open = new JButton();
            JFileChooser fc = new JFileChooser();
            fc.setCurrentDirectory(new File(System.getenv("USERPROFILE") + "\\Desktop"));
            fc.setDialogTitle("Steganograpy");
            fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
<<<<<<< HEAD
            
=======

>>>>>>> master
            if (fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
                chosenImage.setText(fc.getSelectedFile().toString());
                //System.out.println(fileNameTF.getText());
                try {
                    ImageConverter.convert(chosenImage.getText(), "jpg");
                } catch (Exception ex) {
//                    Logger.getLogger(ButtonPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
<<<<<<< HEAD
=======

                String ext = ImageConverter.getFileExtensionFromPath(chosenImage.getText());

                switch (ext) {
                    case "jpeg":
                    case "jpg":
                    case "gif":
                    case "png":
                        try {
                            ImageConverter.convert(chosenImage.getText(), "ppm");
                            chosenImage.setText(ImageConverter.getOutputPathFromInputPath(chosenImage.getText(), "ppm"));
                        } catch (Exception ex) {
                            //Logger.getLogger(ButtonPanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    case "ppm":
                        break;
                    default:
                        chosenImage.setText("");
                        JFrame frame = new JFrame();
                        JOptionPane.showMessageDialog(frame, "Please select a valid image file.");
                        return;
                }

>>>>>>> master
                File img = new File(ImageConverter.getOutputPathFromInputPath(chosenImage.getText(), "jpg"));
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
<<<<<<< HEAD
    }                                      

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
        Thread qThread;
        qThread = new Thread() {
=======
    }

    /**
     * This is the action taken when the submit button is pushed and the file
     * chosen and text to hide will be handled by the DisplayMessages.hideText
     * function.
     *
     * @param evt
     */
    private void submitActionPerformed(ActionEvent evt) {
        Thread execute;
        execute = new Thread() {
            @Override
>>>>>>> master
            public void run() {
                String enteredText;
                String fileChosen;
                boolean flag = false;
                if (chosenImage.getText().length() == 0) {
//                            logger.getLogger().log(Level.WARNING, "User submitted an empty field text (File Name)");
                    System.out.println("User submitted an empty field text (File Name)");
                }
                fileChosen = chosenImage.getText();
                if (textEntered.getText().length() == 0) {
//                            logger.getLogger().log(Level.WARNING, "User submitted an empty field (Last Name)");
                    System.out.println("User submitted an empty field text (File Name)");
                }
                enteredText = textEntered.getText();
                DisplayMessages.hideText(fileChosen, enteredText, flag);
<<<<<<< HEAD
                if (!flag) {
//                            JOptionPane.showMessageDialog(, "Successfully hidden text into file (stego-image.ppm)!");
                    System.out.println("Successfully hidden text into file (stego-image.ppm)!");
                }
            }
        };
        qThread.start();
    }                                                        
}
=======
                try {
                    String outPPM = fileChosen.substring(0, fileChosen.lastIndexOf(File.separator)) + "\\stego-image.ppm";
                    ImageConverter.convert(outPPM, "jpg");
                } catch (Exception ex) {
                    // Logger.getLogger(ButtonPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (!flag) {
//                            JOptionPane.showMessageDialog(, "Successfully hidden text into file (stego-image.ppm)!");
                    String outJPG = fileChosen.substring(0, fileChosen.lastIndexOf(File.separator)) + "\\stego-image.jpg";
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "Successfully hidden text into file: " + outJPG);
                    //System.out.println("Successfully hidden text into file (stego-image.ppm)!");
                }
            }
        };
        execute.start();
    }
}
>>>>>>> master
