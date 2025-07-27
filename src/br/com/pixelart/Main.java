package br.com.pixelart;

import javax.swing.*;
import br.com.pixelart.ui.PixelBoardPanel;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Pixel Art Game");
            PixelBoardPanel board = new PixelBoardPanel();

            frame.add(board);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
