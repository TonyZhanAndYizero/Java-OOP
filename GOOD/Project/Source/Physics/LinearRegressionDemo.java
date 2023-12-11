package Source.Physics;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;


/**
 * a Linear Regression demonstration
 *
 * @author TonyZhan
 */
public class LinearRegressionDemo extends JFrame {
    private final LinearRegression linearRegression;
    private JButton button;
    private DrawPanel drawPanel;

    // 构造方法，初始化窗口
    public LinearRegressionDemo(LinearRegression linearRegression) {
        super("  LinearRegression Demonstration"); // 设置窗口的标题
        this.linearRegression = linearRegression;
        this.drawPanel = new DrawPanel();
        initButton();
        setSize(1000, 1000); // 设置窗口的大小
        setLocationRelativeTo(null); // 设置窗口的位置为居中
        setResizable(true); // 设置窗口的大小可调节
        add(drawPanel); // 将绘图面板添加到窗口中
        setVisible(true); // 设置窗口的可见性为真
    }

    private void initButton() {
        button = new JButton();
        button.setText("保存图片");
        button.setFont(button.getFont().deriveFont(button.getFont().getStyle() | Font.BOLD, button.getFont().getSize() + 4f));
        button.setFocusable(false);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button1MousePressed(e);
            }
        });
        add(button);
        button.setBounds(10, 10, 110, 40);
    }

    private void button1MousePressed(MouseEvent e) {
        // TODO add your code here
        if (e.getButton() == 1) {
            String userDir = System.getProperty("user.home");
            JFileChooser fileChooser = new JFileChooser(userDir + "/Desktop");
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.setFileFilter(new FileNameExtensionFilter("图片文件(*.png)", "png"));//文件过滤器
            int state = fileChooser.showSaveDialog(null);
            if (state == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                String filepath = file.getPath();
                if (!filepath.endsWith(".png")) {
                    filepath = filepath + ".png";
                    file = new File(filepath);
                    saveImage(file);
                }
            }
        }
    }

    private void saveImage(File file) {
        BufferedImage image = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_ARGB);
        // 从BufferedImage对象中获取一个Graphics2D对象
        Graphics2D g = image.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setBackground(Color.WHITE);
        g.clearRect(0, 0, 1000, 1000);
        draw(g,drawPanel);
        // 创建一个File对象，指定要保存的文件名和路径
        try {
            // 使用ImageIO类的write方法，将BufferedImage对象保存为png文件
            ImageIO.write(image, "png", file);
        } catch (IOException e) {
            // 处理异常
            e.printStackTrace();
        }
    }

    private void draw(Graphics g,JPanel jPanel) {
        // 设置背景颜色为白色
        jPanel.setBackground(Color.WHITE);

        BasicStroke stokeLine = new BasicStroke(0.5f);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(stokeLine);
        g.setColor(Color.LIGHT_GRAY);
        for (int i = 1; i < 21; i++) {
            g.drawLine(150 + i * 35, 900, 150 + i * 35, 50);
            g.drawLine(150, 600 - i * 25, 900, 600 - i * 25);
            if (i <= 10) {
                g.drawLine(150, 600 + i * 25, 900, 600 + i * 25);
            }
        }

        stokeLine = new BasicStroke(2.0f);
        g2.setStroke(stokeLine);
        // 设置画笔颜色为黑色
        g.setColor(Color.BLACK);
        g.setFont(new Font("Times New Roman", Font.BOLD, 18));
        // 绘制坐标轴
        g.drawLine(150, 50, 150, 900);//y
        g.drawLine(150, 600, 900, 600);//x
        // 绘制坐标轴的箭头
        g.drawLine(150, 50, 145, 60);
        g.drawLine(150, 50, 155, 60);
        g.drawLine(900, 600, 890, 595);
        g.drawLine(900, 600, 890, 605);


        BigDecimal xEnd = getMax(linearRegression.XNums).multiply(new BigDecimal("1.1")).setScale(0, RoundingMode.CEILING),
                yEnd = getMax(linearRegression.YNums).multiply(new BigDecimal("1.1")).setScale(0, RoundingMode.CEILING);
        BigDecimal xDis = xEnd.divide(new BigDecimal(10), 2, RoundingMode.HALF_UP),
                yDis = yEnd.divide(new BigDecimal(10), 2, RoundingMode.HALF_UP);
        BigDecimal temp;
        // 绘制坐标轴的刻度和标签
        for (int i = 0; i < 11; i++) {
            temp = new BigDecimal(i);
            // x轴的刻度和标签
            if (i != 0) {
                g.drawLine(150 + i * 70, 600, 150 + i * 70, 605);
                g.drawString(temp.multiply(xDis).toPlainString(), 130 + i * 70, 625);
            }// y轴的刻度和标签
            g.drawLine(150, 600 - i * 50, 145, 600 - i * 50);
            g.drawString(temp.multiply(yDis).toPlainString(), 75, 605 - i * 50);
            if (i > 0 && i <= 5) {
                g.drawLine(150, 600 + i * 50, 145, 600 + i * 50);
                g.drawString(temp.multiply(yDis).multiply(new BigDecimal(-1)).toPlainString(), 68, 605 + i * 50);
            }
        }
        // 绘制坐标轴的名称
        g.drawString("x", 910, 615);
        g.drawString("y", 135, 45);


        int n = linearRegression.XNums.size();
        BigDecimal xPixel = new BigDecimal(700).divide(xEnd, 5, RoundingMode.HALF_UP),
                yPixel = new BigDecimal(500).divide(yEnd, 5, RoundingMode.HALF_UP);

        // 绘制数据点
        g.setColor(Color.RED); // 设置画笔颜色为红色
        for (int i = 0; i < n; i++) {
            // 将数据点转换为像素点
            int px = 150 + (int) Double.parseDouble(linearRegression.XNums.get(i).multiply(xPixel).toPlainString());
            int py = 600 - (int) Double.parseDouble(linearRegression.YNums.get(i).multiply(yPixel).toPlainString());
            // 绘制一个半径为4的圆点
            g.fillOval(px - 4, py - 4, 8, 8);
        }
        // 绘制回归线
        stokeLine = new BasicStroke(1.5f);
        g2.setStroke(stokeLine);
        g.setColor(Color.BLUE); // 设置画笔颜色为蓝色
        // 计算回归线的起点和终点的像素坐标
        BigDecimal startY = linearRegression.a,
                endY = linearRegression.a.add(linearRegression.b.multiply(xEnd));
        int x1 = 150;
        int y1 = 600 - (int) Double.parseDouble(startY.multiply(yPixel).toPlainString());
        int x2 = 850;
        int y2 = 600 - (int) Double.parseDouble(endY.multiply(yPixel).toPlainString());
        // 绘制一条直线
        g.drawLine(x1, y1, x2, y2);
        // 绘制回归方程
        g.setColor(Color.BLACK); // 设置画笔颜色为黑色
        // 格式化方程中的小数
        String sb = String.format("%.2f", linearRegression.b);
        String sa = String.format("%.2f", linearRegression.a);
        // 绘制方程的字符串
        g.setFont(new Font("Times New Roman", Font.BOLD, 24));
        g.drawString("y = " + sb + "x + " + sa, 200, 80);
    }

    /**
     * inner class to draw
     *
     * @author TonyZhan
     */
    class DrawPanel extends JPanel {
        // 重写paintComponent方法，实现绘图逻辑
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            draw(g,this);
        }
    }

    /**
     * find the max data
     *
     * @param a the data set
     * @return the max data
     */
    private BigDecimal getMax(ArrayList<BigDecimal> a) {
        BigDecimal temp = a.get(0);
        for (BigDecimal bd : a) {
            if (bd.compareTo(temp) > 0) {
                temp = bd;
            }
        }
        return temp;
    }
}
