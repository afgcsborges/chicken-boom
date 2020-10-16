package org.academiadecodigo.gnunas.chickenboomgame.gameobjects;

import org.academiadecodigo.gnunas.chickenboomgame.Movement;
import org.academiadecodigo.gnunas.chickenboomgame.gameobjects.GameObjects;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Obstacles extends GameObjects {

    private int speed;
    private Rectangle obstacle;

    public Obstacles(Movement direction, int x, int y, int speed) {
        super(new Rectangle(x,y,(int)((Math.random()*80)+40),(int)((Math.random()*80)+40)), Color.DARK_GRAY, direction);
        this.speed = speed;
        obstacle = (Rectangle) getShape();
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
        obstacle.fill();
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
