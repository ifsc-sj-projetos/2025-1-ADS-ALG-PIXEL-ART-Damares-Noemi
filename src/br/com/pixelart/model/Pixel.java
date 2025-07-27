package br.com.pixelart.model;

import java.awt.Color;

public class Pixel {
    private Color color;

    public Pixel() {
        this.color = Color.WHITE;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
