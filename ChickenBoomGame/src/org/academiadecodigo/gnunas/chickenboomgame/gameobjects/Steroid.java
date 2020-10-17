package org.academiadecodigo.gnunas.chickenboomgame.gameobjects;

import org.academiadecodigo.gnunas.chickenboomgame.players.GameObject;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;

public class Steroid extends GameObject {

    private SteroidType type;
    private Ellipse steroid;


    public Steroid(SteroidType type) {
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
