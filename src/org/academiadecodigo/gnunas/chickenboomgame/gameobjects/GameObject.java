package org.academiadecodigo.gnunas.chickenboomgame.gameobjects;

import org.academiadecodigo.gnunas.chickenboomgame.Positionable;
import org.academiadecodigo.simplegraphics.graphics.Shape;

public abstract class GameObject implements Positionable {

    private final Shape shape;
    private boolean moving = true;
    private Movement direction;

    public GameObject(Shape shape, Movement direction){
        this.shape = shape;
        this.direction = direction;

    }

    public GameObject(Shape shape){
        moving = false;
        this.shape = shape;
    }

    public abstract void move();

    public abstract void show();

    public void delete(){
        shape.delete();
    }

    @Override
    public int getX(){
        return shape.getX();
    }

    @Override
    public int getY(){
        return  shape.getY();
    }

    public int getHeight(){
        return shape.getHeight();
    }

    public int getWidth(){
        return shape.getWidth();
    }

    @Override
    public int getXtoWidth() {
        return getX() + getWidth();
    }

    @Override
    public int getYtoHeight() {
        return getY() + getHeight();
    }

    public boolean isMoving() {
        return moving;
    }

    public Movement getDirection() {
        return direction;
    }

    public Shape getShape() {
        return shape;
    }
}
