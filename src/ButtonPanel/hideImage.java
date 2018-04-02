
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ButtonPanel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Ayisha Sowkathali
 */
public class hideImage extends JPanel {
    
    private JLabel hdrLabel;

    public hideImage() {
        initComponents();
    }
                        
    private void initComponents() {

        hdrLabel = new JLabel();

        setBackground(new Color(255, 255, 204));

        hdrLabel.setFont(new Font("Georgia", 0, 24)); // NOI18N
        hdrLabel.setText("Hide Image in an Image");

        javax.swing.GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(328, Short.MAX_VALUE)
                .addComponent(hdrLabel)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hdrLabel)
                .addContainerGap(456, Short.MAX_VALUE))
        );
    }                                     
}

