package org.academiadecodigo.gnunas.chickenboomgame.players;

import org.academiadecodigo.gnunas.chickenboomgame.Field;
import org.academiadecodigo.gnunas.chickenboomgame.gameobjects.Movement;
import org.academiadecodigo.gnunas.chickenboomgame.gameobjects.SteroidType;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class WhiteChicken extends Player {

    private boolean moving ;
    private Movement direction;
    private SteroidType status;
    private int speed;

    public WhiteChicken(Field field) {

        super(field, new Picture(field.getWidth()/3,field.getHeight()/2,"resources/images/whitechicken/down/whitechickendown.png"));
        status = SteroidType.CORN;
        this.speed = 10;
        this.direction = Movement.DOWN;
        show();
    }



    public void setStatus(SteroidType type) {
        status = type;
        switch (type) {
            case ICE:
                speed = (int) (speed * 0.5);
                break;

            case CORN:
                speed = (int) (speed * 1.5);
                break;

            case MUSHROOM:
                int random = (int) (Math.random()*2);
                if( random == 1) {
                    getChicken().grow(10, 10);
                    break;
                }
                getChicken().grow(-10,-10);
                break;
        }
    }

    public void move() {

        if(reachedEdge()){
            moving = false;
        }

        if(moving && status == SteroidType.SKULL) {
            switch (direction) {
                case LEFT:
                    getChicken().translate(speed, 0);
                    return;
                case RIGHT:
                    getChicken().translate(-speed, 0);
                    return;
                case DOWN:
                    getChicken().translate(0, -speed);
                    return;
                case UP:
                    getChicken().translate(0, speed);
                    return;

            }
        }

        if (moving) {
            switch (direction) {
                case LEFT:
                    getChicken().translate(-speed, 0);
                    return;
                case RIGHT:
                    getChicken().translate(speed, 0);
                    return;
                case DOWN:
                    getChicken().translate(0, speed);
                    return;
                case UP:
                    getChicken().translate(0, -speed);
                    return;

            }
        }
    }

    public void moveInDirection(Movement direction){
        this.direction = direction;
        refreshImage();
        moving = true;
    }

    public void stopMoving()
    {
        moving = false;
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

    private void refreshImage(){
        switch (direction){
            case UP:
                getChicken().load("resources/images/whitechicken/up/whitechickenup.png");
                break;
            case DOWN:
                getChicken().load("resources/images/whitechicken/down/whitechickendown.png");
                break;
            case LEFT:
                getChicken().load("resources/images/whitechicken/left/whitechickenleft.png");
                break;
            case RIGHT:
                getChicken().load("resources/images/whitechicken/right/whitechickenright.png");
                break;
        }
    }

}
