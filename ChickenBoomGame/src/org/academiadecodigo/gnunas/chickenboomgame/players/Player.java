package org.academiadecodigo.gnunas.chickenboomgame.players;

import org.academiadecodigo.gnunas.chickenboomgame.Field;
import org.academiadecodigo.gnunas.chickenboomgame.Positionable;
import org.academiadecodigo.gnunas.chickenboomgame.gameobjects.Movement;
import org.academiadecodigo.gnunas.chickenboomgame.gameobjects.SteroidType;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Player implements Positionable {

    private Field field;
    private Picture chicken;
    private boolean crashed;
    private SteroidType steroidType;
    private SteroidType status;
    private int speed;
    private boolean moving ;
    private Movement direction;

    public Player(Field field, Picture chicken) {
        this.field = field;
        this.chicken = chicken;
        crashed = false;
        speed = 5;
        status = SteroidType.CORN;
        direction = Movement.DOWN;

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

        if (reachedEdge()) {
            moving = false;
        }
        if (moving) {
            if (status == SteroidType.SKULL) {
                getChicken().translate(direction.x * -speed, direction.y * -speed);
                return;
            }
            getChicken().translate(direction.x * speed, direction.y * speed);
        }
    }


    public void moveInDirection(Movement direction){
        this.direction = direction;
        refreshImage();
        moving = true;
    }

    protected Movement getDirection() {
        return direction;
    }

    public void stopMoving()
    {
        moving = false;
    }

    private boolean reachedEdge(){

        if(status == SteroidType.SKULL){
            int nextX = getChicken().getX()-direction.x*speed;
            int nextY = getChicken().getY()-direction.y*speed;
            return  !((nextX >=120 && nextX+getChicken().getWidth() < getField().getWidth()-120)
                    && (nextY >=120 && nextY+getChicken().getHeight() < getField().getHeight()-120));
        }
        int nextX = getChicken().getX()+direction.x*speed;
        int nextY = getChicken().getY()+direction.y*speed;
        return !((nextX >=120 && nextX+getChicken().getWidth() < getField().getWidth()-120)
                && (nextY >=120 && nextY+getChicken().getHeight() < getField().getHeight()-120));
    }

    protected abstract void refreshImage();
}

