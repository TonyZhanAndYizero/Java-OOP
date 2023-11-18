import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
/*
 * Created by JFormDesigner on Sat Nov 18 15:30:39 CST 2023
 */



/**
 * @author tonyzhan0514
 */
public class Calculator extends JFrame {
    public Calculator() {
        initComponents();
        ImageIcon icon=new ImageIcon("src/icon.png"); //图片和项目同一路径，故不用图片的路径
        this.setIconImage(icon.getImage());
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem2 = new JMenuItem();

        //======== this ========
        setTitle("Calculator");
        var contentPane = getContentPane();
        contentPane.setLayout(null);


        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("\u6587\u4ef6");

                //---- menuItem1 ----
                menuItem1.setText("\u6253\u5f00\u6587\u4ef6");
                menu1.add(menuItem1);

                //---- menuItem2 ----
                menuItem2.setText("\u4fdd\u5b58\u6587\u4ef6");
                menu1.add(menuItem2);
            }
            menuBar1.add(menu1);
        }
        setJMenuBar(menuBar1);

        contentPane.setPreferredSize(new Dimension(480, 360));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public static void main(String[] args) {
        new Calculator().setVisible(true);
    }
}
