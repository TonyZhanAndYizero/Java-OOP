import javax.swing.*;

public class Windowsdemo {
    public static void main(String[] args) {
        //1.创建一个窗口对象
        JFrame frame = new JFrame("window窗口演示");
        //2.指定窗口的位置，大小
        frame.setLocation(100,100);
        frame.setSize(500,300);
        //3.设置窗口对象可见
        frame.setVisible(true);
    }
}