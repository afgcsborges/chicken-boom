package org.academiadecodigo.gnunas.chickenboomgame;

import org.academiadecodigo.simplegraphics.graphics.Color;

public enum SteroidType {

    CORN(Color.YELLOW),
    MUSHROOM(Color.RED),
    ICE(Color.CYAN);

    private Color color;

    SteroidType(Color color){
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
