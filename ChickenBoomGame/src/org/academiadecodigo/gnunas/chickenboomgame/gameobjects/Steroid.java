package org.academiadecodigo.gnunas.chickenboomgame.gameobjects;

import org.academiadecodigo.simplegraphics.graphics.Ellipse;

public class Steroid extends GameObject {

    private SteroidType type;
    private Ellipse steroid;
    private boolean used;


    public Steroid(SteroidType type) {
        super(new Ellipse((int)((Math.random()*1260)+120-30),(int)((Math.random()*660)+120-30), 30,30));
        this.type = type;
        steroid = (Ellipse) getShape();
        steroid.setColor(type.getColor());
        steroid.fill();

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
