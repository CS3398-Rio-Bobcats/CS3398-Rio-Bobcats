/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ButtonPanel;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle;

/**
 *
 * @author Ayisha Sowkathali
 */
public class homePanel extends JPanel {

    private JLabel img1;
    private JLabel text1;
    private JLabel text2;
    private JLabel text3;

    public homePanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    private void initComponents() {

        text1 = new JLabel();
        img1 = new JLabel();
        text2 = new JLabel();
        text3 = new JLabel();

        setBackground(new Color(238, 253, 253));
        setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        text1.setFont(new Font("PT Mono", 1, 48)); // NOI18N
        text1.setText("Welcome");

        img1.setIcon(new ImageIcon(getClass().getResource("/OtherResources/stgIcon.png"))); // NOI18N

        text2.setFont(new Font("PT Mono", 0, 48)); // NOI18N
        text2.setText("to");

        text3.setFont(new Font("PT Mono", 1, 48)); // NOI18N
        text3.setText("Steganography");

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(text1, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 140, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(img1)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(text2)
                                                .addComponent(text3)))
                                .addGap(71, 71, 71))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(text1, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(text2)
                                .addGap(18, 18, 18)
                                .addComponent(text3)
                                .addGap(44, 44, 44)
                                .addComponent(img1, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(77, Short.MAX_VALUE))
        );
    }
}
