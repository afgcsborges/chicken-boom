package org.academiadecodigo.gnunas.chickenboomgame.gameobjects;

import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Steroids extends GameObjects {

    private SteroidType type;
    private Ellipse steroid;


    public Steroids(SteroidType type) {
        super(new Ellipse((int)((Math.random()*1260)+120-30),(int)((Math.random()*660)+120-30), 30,30), type.getColor());
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
}
