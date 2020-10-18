package org.academiadecodigo.gnunas.chickenboomgame.gameobjects;

import org.academiadecodigo.gnunas.chickenboomgame.gameobjects.Movement;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Shape;

public abstract class GameObject {

    private Shape shape;
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

    public int getX(){
        return shape.getX();
    }

    public int getY(){
        return  shape.getY();
    }

    public int getHeight(){
        return shape.getHeight();
    }

    public int getWidth(){
        return shape.getWidth();
    }

    public int getXtoWith() {
        return getX() + getWidth();
    }

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
