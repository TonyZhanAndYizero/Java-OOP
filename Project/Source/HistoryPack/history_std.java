/*
 * Created by JFormDesigner on Thu Nov 23 17:50:16 CST 2023
 */

package Source.HistoryPack;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author tonyzhan0514
 */
public class history_std extends JPanel {
    public history_std() {
        initComponents();
    }

    private void button1MousePressed(MouseEvent e) {
        // TODO add your code here

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        button1 = new JButton();

        //======== this ========
        setLayout(null);

        //---- button1 ----
        button1.setText("text");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button1MousePressed(e);
            }
        });
        add(button1);
        button1.setBounds(45, 45, 80, 60);

        setPreferredSize(new Dimension(400, 300));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
