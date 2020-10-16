package org.academiadecodigo.gnunas.chickenboomgame.gameobjects;

import org.academiadecodigo.gnunas.chickenboomgame.Movement;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Shape;

public abstract class GameObjects {

    private Shape shape;
    private Color color;
    private boolean moving = true;
    private Movement direction;

    public GameObjects(Shape shape, Color color, Movement direction){
        this.shape = shape;
        this.color = color;
        this.direction = direction;

    }

    public GameObjects(Shape shape,Color color){
        moving = false;
        this.shape = shape;
        this.color = color;
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
