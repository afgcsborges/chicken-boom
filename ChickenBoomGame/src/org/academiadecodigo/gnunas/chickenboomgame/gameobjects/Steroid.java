package org.academiadecodigo.gnunas.chickenboomgame.gameobjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Steroid extends GameObject {

    private final SteroidType type;
    private final Picture steroid;
    private boolean used;


    public Steroid(SteroidType type) {
        super(new Picture((int)((Math.random()*1160)+150),(int)((Math.random()*560)+150), type.getDirectory()));
        this.type = type;
        steroid = (Picture) getShape();
        steroid.draw();

    }

    @Override
    public void move() {
        return;
    }

    @Override
    public void show() {

    }

    public SteroidType getType() {
        return type;
    }

    public boolean isUsed() {
        return used;
    }

    @Override
    public void delete() {
        super.delete();
        used = true;
    }
}
