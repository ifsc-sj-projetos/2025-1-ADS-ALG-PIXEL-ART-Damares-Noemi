package br.com.pixelart;

import br.com.pixelart.ui.PixelGridPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

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

            JButton eraserButton = new JButton("Borracha");
            eraserButton.addActionListener(e -> gridPanel.setSelectedColor(Color.WHITE));

            JButton saveButton = new JButton("Salvar imagem");
            saveButton.addActionListener(e -> {
                try {
                    BufferedImage image = gridPanel.exportToImage();
                    JFileChooser fileChooser = new JFileChooser();
                    if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
                        File file = fileChooser.getSelectedFile();
                        ImageIO.write(image, "png", new File(file.getAbsolutePath() + ".png"));
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Erro ao salvar imagem: " + ex.getMessage());
                }
            });

            controlPanel.add(colorButton);
            controlPanel.add(eraserButton);
            controlPanel.add(saveButton);

            frame.setLayout(new BorderLayout());
            frame.add(gridPanel, BorderLayout.CENTER);
            frame.add(controlPanel, BorderLayout.SOUTH);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
