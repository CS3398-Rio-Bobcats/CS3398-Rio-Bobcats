/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ButtonPanel;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

/**
 *
 * @author Ayisha Sowkathali
 */
public class convertImage extends JPanel {

    private JLabel chooseImgLbl;
    private JLabel entFrmtLbl;
    private JTextField fmtEntFld;
    private JLabel headerLbl;
    private JButton imgBrsBtn;
    private JTextField imgChosenFld;
    private JButton submitBtn;

    public convertImage() {
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
        headerLbl.setText("Convert Image");

        chooseImgLbl.setFont(new Font("Georgia", 0, 18)); 
        chooseImgLbl.setText("Choose Image ");
     //Drag and Drop Image
        imgChosenFld.setDropTarget(new DropTarget() {
                    public synchronized void drop(DropTargetDropEvent evt) {
            try {
                evt.acceptDrop(DnDConstants.ACTION_COPY);
                List<File> droppedFiles = (List<File>) evt
                        .getTransferable().getTransferData(
                                DataFlavor.javaFileListFlavor);
                for (File file : droppedFiles) {
                    /*
                     * NOTE:
                     *  When I change this to a println,
                     *  it prints the correct path
                     */
                    imgChosenFld.setText(file.getAbsolutePath());
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        });


        entFrmtLbl.setFont(new Font("Georgia", 0, 18)); 
        entFrmtLbl.setText("Enter Image format to convert (ppm, jpg, jpeg, png, gif)");

        imgBrsBtn.setFont(new Font("Verdana", 1, 18)); 
        imgBrsBtn.setText("Browse");
        imgBrsBtn.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, 
                Color.darkGray, Color.lightGray, 
                Color.darkGray, Color.lightGray));
        imgBrsBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                imgBrsBtnActionPerformed(evt);
            }
        });

        submitBtn.setFont(new Font("Verdana", 1, 18)); 
        submitBtn.setText("Submit");
        submitBtn.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, 
                Color.darkGray, java.awt.Color.lightGray, Color.darkGray, Color.lightGray));
        submitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                submitBtnActionPerformed(evt);
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

    private void imgBrsBtnActionPerformed(java.awt.event.ActionEvent evt) {
//        logger.getLogger().log(Level.INFO, "User is searching for file");
        if (evt.getSource() == imgBrsBtn) {
            JButton open = new JButton();
            JFileChooser fc = new JFileChooser();
            fc.setCurrentDirectory(new File(System.getenv("USERPROFILE") + "\\Desktop")); //might need to change for your computer
            fc.setDialogTitle("Select a File");
            fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            if (fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
                imgChosenFld.setText(fc.getSelectedFile().toString());
            }
        }
    }

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {
        JFrame frame = new JFrame();
        Thread qThread;
        qThread = new Thread() {
            public void run() {
                String fileNameTP;
                String typeTP = null;
                boolean flag = false;
                if (imgChosenFld.getText().length() == 0) {
//                    logger.getLogger().log(Level.WARNING, "User submitted an empty field text (File Name)");
                }
                fileNameTP = imgChosenFld.getText();
                if (fmtEntFld.getText().length() == 0) {
//                    logger.getLogger().log(Level.WARNING, "User submitted an empty field text (Type Name)");
                }
                typeTP = fmtEntFld.getText();

                String outputPath = DisplayMessages.convertImage(fileNameTP, typeTP, flag);
//                    field.setText("STATUS: Successfully converted file!");
                if (flag) {
                    JOptionPane.showMessageDialog(frame, "Successfully converted file!");
                }
                JOptionPane.showMessageDialog(frame, "Created image: " + outputPath);
            }
        };
        qThread.start();
    }
}
