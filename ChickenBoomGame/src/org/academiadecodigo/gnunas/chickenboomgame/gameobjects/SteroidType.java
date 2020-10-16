package org.academiadecodigo.gnunas.chickenboomgame.gameobjects;

import org.academiadecodigo.simplegraphics.graphics.Color;

public enum SteroidType {

    CORN(Color.YELLOW),
    MUSHROOM(Color.RED),
    ICE(Color.CYAN),
    SKULL(Color.GREEN);

    private Color color;

    SteroidType(Color color){
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
