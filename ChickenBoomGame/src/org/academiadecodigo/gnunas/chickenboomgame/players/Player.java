package org.academiadecodigo.gnunas.chickenboomgame.players;

import org.academiadecodigo.gnunas.chickenboomgame.Field;
import org.academiadecodigo.gnunas.chickenboomgame.Positionable;
import org.academiadecodigo.gnunas.chickenboomgame.gameobjects.SteroidType;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Player implements Positionable {

    private Field field;
    private Picture chicken;
    private boolean crashed;
    private SteroidType steroidType;

    public Player(Field field, Picture chicken) {
        this.field = field;
        this.chicken = chicken;
        crashed = false;

    }

    public void show(){
        chicken.draw();
    }

    public void hide(){
        chicken.delete();
    }

    public Picture getChicken() {
        return chicken;
    }

    @Override
    public int getX() {
        return chicken.getX();
    }

    @Override
    public int getY() {
        return chicken.getY();
    }

    public int getWidth() {
        return chicken.getWidth();
    }

    public  int getHeight() {
        return chicken.getHeight();
    }

    @Override
    public int getXtoWidth() {
        return getX() + getWidth();
    }

    @Override
    public int getYtoHeight() {
        return getY() + getHeight();
    }

    public void setCrashed() {
        crashed = true;
    }

    public boolean isCrashed() {
        return crashed;
    }

    public Field getField(){
        return field;
    }

    public void setPicture(String imageFile) {
        Picture picture = new Picture(getX(), getY(), imageFile);
        hide();
        chicken = picture;
        show();
    }


}

