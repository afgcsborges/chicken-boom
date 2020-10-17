package org.academiadecodigo.gnunas.chickenboomgame.players;

import org.academiadecodigo.gnunas.chickenboomgame.Field;
import org.academiadecodigo.gnunas.chickenboomgame.gameobjects.Movement;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class WhiteChicken extends Player {

    private boolean moving ;
    private Movement direction;
    private boolean crashed;
    private int speed;

    public WhiteChicken(Field field) {
        super(field, new Picture(field.getWidth()/3,field.getHeight()/2,"resources/images/chickenStandingDown.png"));
        crashed = false;
        this.speed = 10;
        this.direction = Movement.DOWN;
        show();


    }

    public void move() {

        if(reachedEdge()){
            moving = false;
        }

        if (moving) {
            switch (direction) {
                case LEFT:
                    getChicken().translate(-speed, 0);
                    break;
                case RIGHT:
                    getChicken().translate(speed, 0);
                    break;
                case DOWN:
                    getChicken().translate(0, speed);
                    break;
                case UP:
                    getChicken().translate(0, -speed);
                    break;

            }
        }
    }

    public void moveInDirection(Movement direction){
        this.direction = direction;
        moving = true;
    }

    public void stopMoving()
    {
        moving = false;
    }


    public boolean isCrashed() {
        return crashed;
    }

    private boolean reachedEdge(){
        switch (direction){
            case RIGHT:
                if (getX()+getWidth()+speed >= getField().getWidth()-120){
                    getChicken().translate((getField().getWidth()-122)-(getX()+getWidth()),0);
                    return true;
                }
                return false;
            case LEFT:
                if (getX()-speed < 120){
                    getChicken().translate(120-getX(),0);
                    return true;
                }
                return false;
            case DOWN:
                if (getY()+getHeight()+speed >= getField().getHeight()-120){
                    getChicken().translate(0,(getField().getHeight()-122)-(getY()+getHeight()));
                    return true;
                }
                return false;
            case UP:
                if (getY()-speed < 120){
                    getChicken().translate(0,120-getY());
                    return true;
                }
                return false;
        }
        return false;
    }
}
