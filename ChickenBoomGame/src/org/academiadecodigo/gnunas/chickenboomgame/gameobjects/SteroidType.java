package org.academiadecodigo.gnunas.chickenboomgame.gameobjects;

import org.academiadecodigo.simplegraphics.graphics.Color;

public enum SteroidType {

    CORN("resources/images/steroids/corn.png"),
    MUSHROOM("resources/images/steroids/mushroom.png"),
    ICE("resources/images/steroids/ice.png"),
    SKULL("resources/images/steroids/skull.png");

    private String directory;

    SteroidType(String directory){
        this.directory = directory;
    }

    public String getDirectory() {
        return directory;
    }
}
