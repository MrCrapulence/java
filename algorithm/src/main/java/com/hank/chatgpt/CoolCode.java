package com.hank.chatgpt;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

/**
 * 以下是"写一段酷炫的Java代码"的回复
 */
public class CoolCode extends JPanel {
    // 图像数据
    private BufferedImage image;

    public CoolCode() {
        // 创建图像
        int width = 640;
        int height = 480;
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // 绘制图像
        Graphics g = image.getGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 36));
        g.drawString("Cool Code", 200, 200);

        // 添加鼠标事件监听器
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // 获取鼠标点击位置
                int x = e.getX();
                int y = e.getY();

                // 修改图像颜色
                image.setRGB(x, y, Color.RED.getRGB());

                // 重新绘制图像
                repaint();
            }
        });
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(image.getWidth(), image.getHeight());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // 创建窗口
            JFrame frame = new JFrame("Cool Code");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // 添加面板
            CoolCode panel = new CoolCode();
            frame.add(panel);

            // 显示窗口
            frame.pack();
            frame.setVisible(true);
        });

    }
}