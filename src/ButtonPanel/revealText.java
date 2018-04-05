/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ButtonPanel;

import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import steganographer.Steganographer;

/**
 *
 * @author Ayisha Sowkathali
 */
public class revealText extends javax.swing.JPanel {
    
    private JLabel headerLbl;
    private JButton orgBrsBtn;
    private JTextField orgFld;
    private JLabel orgLbl;
    private JButton stegBrsBtn;
    private JTextField stgFld;
    private JLabel stgLbl;
    private JButton submitBtn;  

    public revealText() {
        initComponents();
    }
                          
    private void initComponents() {

        headerLbl = new JLabel();
        stgLbl = new JLabel();
        stgFld = new JTextField();
        orgLbl = new JLabel();
        orgFld = new JTextField();
        submitBtn = new JButton();
        stegBrsBtn = new JButton();
        orgBrsBtn = new JButton();

        setBackground(new Color(231, 241, 248));

        headerLbl.setBackground(new Color(255, 255, 255));
        headerLbl.setFont(new Font("Georgia", 0, 24)); 
        headerLbl.setText("Reveal Text from an Image");

        stgLbl.setFont(new Font("Georgia", 0, 18)); 
        stgLbl.setText("Choose Stegano Image");

        stgFld.setMinimumSize(new Dimension(50, 20));
        stgFld.setSize(new Dimension(50, 20));
// Drag and Drop Image        
        stgFld.setDropTarget(new DropTarget() {
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
                    stgFld.setText(file.getAbsolutePath());
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        });

        orgLbl.setFont(new Font("Georgia", 0, 18)); 
        orgLbl.setText("Choose Original Image");
// Drag and Drop Image 
        orgFld.setDropTarget(new DropTarget() {
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
                    orgFld.setText(file.getAbsolutePath());
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        });


        submitBtn.setFont(new Font("Verdana", 1, 18)); 
        submitBtn.setText("Submit");
        submitBtn.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, 
                Color.darkGray, Color.lightGray, 
                Color.darkGray, Color.lightGray));
        submitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });

        stegBrsBtn.setFont(new Font("Verdana", 1, 18)); // NOI18N
        stegBrsBtn.setText("Browse");
        stegBrsBtn.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, 
                Color.darkGray, Color.lightGray, 
                Color.darkGray, Color.lightGray));
        stegBrsBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                stegBrsBtnActionPerformed(evt);
            }
        });

        orgBrsBtn.setFont(new Font("Verdana", 1, 18)); // NOI18N
        orgBrsBtn.setText("Browse");
        orgBrsBtn.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, 
                Color.darkGray, Color.lightGray, 
                Color.darkGray, Color.lightGray));
        orgBrsBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                orgBrsBtnActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(headerLbl))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(orgLbl)
                                    .addComponent(orgBrsBtn, 
                                            GroupLayout.Alignment.TRAILING, 
                                            GroupLayout.PREFERRED_SIZE, 100, 
                                            GroupLayout.PREFERRED_SIZE)
                                    .addComponent(orgFld, 
                                            GroupLayout.PREFERRED_SIZE, 464, 
                                            GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(stegBrsBtn, 
                                            GroupLayout.PREFERRED_SIZE, 100, 
                                            GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(stgFld, 
                                                GroupLayout.PREFERRED_SIZE, 464, 
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(stgLbl))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(233, 233, 233)
                                .addComponent(submitBtn, 
                                        GroupLayout.PREFERRED_SIZE, 100, 
                                        GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 60, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerLbl)
                .addGap(72, 72, 72)
                .addComponent(stgLbl)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stgFld, GroupLayout.PREFERRED_SIZE, 50, 
                        GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(stegBrsBtn, GroupLayout.PREFERRED_SIZE, 40, 
                        GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(orgLbl)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(orgFld, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(orgBrsBtn, GroupLayout.PREFERRED_SIZE, 40, 
                        GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(submitBtn, GroupLayout.PREFERRED_SIZE, 40, 
                        GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
    }                                                            

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {                                          
//        logger.getLogger().log(Level.INFO, "User submitted a file name and text to hide");
        Thread qThread = new Thread() {
            public void run() {
                File f1 = new File(orgFld.getText());
                File f2 = new File(stgFld.getText());
                Steganographer steg = new Steganographer(f1);
                String result = steg.reveal(f2, "text");
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, "Hidden text: " + result);
            }
        };
        qThread.start();
    }                                         

    private void stegBrsBtnActionPerformed(java.awt.event.ActionEvent evt) {                                           
//        logger.getLogger().log(Level.INFO, "User is searching for file");
        if (evt.getSource() == stegBrsBtn) {
            JButton open = new JButton();
            JFileChooser fc = new JFileChooser();
            fc.setCurrentDirectory(new File(System.getenv("USERPROFILE") + "\\Desktop"));
            fc.setDialogTitle("Select a File");
            fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            if (fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
                stgFld.setText(fc.getSelectedFile().toString());
            }
        }
    }                                          

    private void orgBrsBtnActionPerformed(java.awt.event.ActionEvent evt) {                                          
//        logger.getLogger().log(Level.INFO, "User is searching for file");
        if (evt.getSource() == orgBrsBtn) {
            JButton open = new JButton();
            JFileChooser fc = new JFileChooser();
            fc.setCurrentDirectory(new File(System.getenv("USERPROFILE") + "\\Desktop"));
            fc.setDialogTitle("Select a File");
            fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            if (fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
                orgFld.setText(fc.getSelectedFile().toString());
            }
        }
    }                                                        
}
