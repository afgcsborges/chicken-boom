package org.academiadecodigo.gnunas.chickenboomgame.gameobjects;

public enum SteroidType {

    CORN("resources/images/steroids/corn.png"),
    MUSHROOM("resources/images/steroids/mushroom.png"),
    ICE("resources/images/steroids/ice.png"),
    SKULL("resources/images/steroids/skull.png");

    private final String directory;

    SteroidType(String directory){
        this.directory = directory;
    }

    public String getDirectory() {
        return directory;
    }
}
