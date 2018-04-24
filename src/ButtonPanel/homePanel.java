/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ButtonPanel;

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

        setBackground(new Color(0, 102, 102));

        text1.setFont(new Font("PT Mono", 1, 48)); // NOI18N
        text1.setForeground(new Color(204, 255, 255));
        text1.setText("Welcome");

        img1.setIcon(new ImageIcon(getClass().getResource("/OtherResources/stgIcon.png"))); // NOI18N

        text2.setBackground(new Color(204, 204, 204));
        text2.setFont(new Font("PT Mono", 0, 48)); // NOI18N
        text2.setForeground(new Color(204, 204, 204));
        text2.setText("to");

        text3.setFont(new Font("PT Mono", 1, 48)); // NOI18N
        text3.setForeground(new Color(229, 255, 255));
        text3.setText("Steganography");

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(img1, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(text3)
                            .addComponent(text1, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(text2)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(img1, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(text1, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(text2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(text3)))
                .addContainerGap(259, Short.MAX_VALUE))
        );
    }
}
