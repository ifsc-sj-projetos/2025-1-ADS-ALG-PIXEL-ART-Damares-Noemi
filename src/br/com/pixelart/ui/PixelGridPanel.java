package br.com.pixelart.ui;

import br.com.pixelart.model.Pixel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PixelGridPanel extends JPanel {
    private final Pixel[][] pixels;
    private final int rows, cols, pixelSize = 20;
    private Color selectedColor = Color.BLACK;

    public PixelGridPanel(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.pixels = new Pixel[rows][cols];

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                pixels[i][j] = new Pixel();

        setPreferredSize(new Dimension(cols * pixelSize, rows * pixelSize));

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                int x = e.getX() / pixelSize;
                int y = e.getY() / pixelSize;
                if (x >= 0 && x < cols && y >= 0 && y < rows) {
                    pixels[y][x].setColor(selectedColor);
                    repaint();
                }
            }
        });
    }

    public void setSelectedColor(Color color) {
        this.selectedColor = color;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int y = 0; y < rows; y++)
            for (int x = 0; x < cols; x++) {
                g.setColor(pixels[y][x].getColor());
                g.fillRect(x * pixelSize, y * pixelSize, pixelSize, pixelSize);
                g.setColor(Color.GRAY);
                g.drawRect(x * pixelSize, y * pixelSize, pixelSize, pixelSize);
            }
    }
}
