package br.com.pixelart;

import br.com.pixelart.ui.PixelGridPanel;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Pixel Art Game");
            PixelGridPanel gridPanel = new PixelGridPanel(16, 16);

            JPanel controlPanel = new JPanel();
            JButton colorButton = new JButton("Escolher cor");
            colorButton.addActionListener(e -> {
                Color selected = JColorChooser.showDialog(frame, "Escolha uma cor", Color.BLACK);
                if (selected != null) {
                    gridPanel.setSelectedColor(selected);
                }
            });
            controlPanel.add(colorButton);

            frame.setLayout(new BorderLayout());
            frame.add(gridPanel, BorderLayout.CENTER);
            frame.add(controlPanel, BorderLayout.SOUTH);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
