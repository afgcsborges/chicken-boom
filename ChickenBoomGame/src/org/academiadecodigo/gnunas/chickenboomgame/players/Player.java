package org.academiadecodigo.gnunas.chickenboomgame.players;

import org.academiadecodigo.gnunas.chickenboomgame.Field;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.awt.*;

public abstract class Player {

    private Field field;
    private Rectangle chicken;
    private Color color;

    public Player(Field field,Rectangle chicken, Color color) {
        this.field = field;
        this.chicken = chicken;
        this.color = color;
        chicken.setColor(color);

    }

    public void show(){
        chicken.fill();
    }

    public void hide(){
        chicken.delete();
    }

    public Rectangle getChicken() {
        return chicken;
    }

    public int getX() {
        return chicken.getX();
    }

    public int getY() {
        return chicken.getY();
    }

    public int getWidth() {
        return chicken.getWidth();
    }

    public  int getHeight() {
        return chicken.getHeight();
    }

    public Field getField() {
        return field;
    }
}

