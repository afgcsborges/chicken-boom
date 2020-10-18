package org.academiadecodigo.gnunas.chickenboomgame.gameobjects;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public class Obstacle extends GameObject {

    private int speed;
    private Picture obstacle;

    public Obstacle(Movement direction, int x, int y, int speed, Spells spell) {
        super(new Picture(x,y,spell.finalDirectory(direction)),direction);
        this.speed = speed;
        obstacle = (Picture) getShape();
        show();
    }

    @Override
    public void move() {
        if (outOfBounds()){
            obstacle.delete();
            return;
        }
        if (isMoving()) {
            switch (getDirection()) {
                case LEFT:
                    obstacle.translate(-speed, 0);
                    break;
                case RIGHT:
                    obstacle.translate(speed, 0);
                    break;
                case DOWN:
                    obstacle.translate(0, speed);
                    break;
                case UP:
                    obstacle.translate(0, -speed);
                    break;

            }
        }
        if (outOfBounds()){
            obstacle.delete();
        }

    }

    @Override
    public void show() {
        obstacle.draw();
    }

    public boolean outOfBounds(){
        switch (getDirection()){
            case UP:
                return obstacle.getY() - speed < 0;
            case DOWN:
                return obstacle.getY() + obstacle.getHeight() + speed >= 900;
            case RIGHT:
                return obstacle.getX() + obstacle.getWidth() + speed >= 1500;
            case LEFT:
                return  obstacle.getX() - speed < 0;
        }
        return false;
    }
}
