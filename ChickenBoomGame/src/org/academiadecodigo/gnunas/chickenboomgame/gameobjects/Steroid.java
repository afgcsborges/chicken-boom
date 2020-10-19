package org.academiadecodigo.gnunas.chickenboomgame.gameobjects;

import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Steroid extends GameObject {

    private SteroidType type;
    private Picture steroid;
    private boolean used;


    public Steroid(SteroidType type) {
        super(new Picture((int)((Math.random()*1260)+120-30),(int)((Math.random()*660)+120-30), type.getDirectory()));
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
