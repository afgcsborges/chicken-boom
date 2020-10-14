package org.academiadecodigo.gnunas.chickenboomgame;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.awt.*;

public abstract class Player implements KeyboardHandler{

    private Field field;
    private Rectangle chicken;
    private Color color;
    public Keyboard keyboard = new Keyboard(this);

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
}

