package org.academiadecodigo.gnunas.chickenboomgame.players;

import org.academiadecodigo.gnunas.chickenboomgame.Field;
import org.academiadecodigo.gnunas.chickenboomgame.gameobjects.Movement;
import org.academiadecodigo.gnunas.chickenboomgame.gameobjects.SteroidType;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class BlackChicken extends Player {

    private boolean moving ;
    private Movement direction;
    private SteroidType status;
    private int speed;

    public BlackChicken(Field field) {

        super(field, new Picture((field.getWidth()/3)*2,field.getHeight()/2,"resources/images/blackchicken/down/blackchickendown.png"));
        status = SteroidType.CORN;
        this.speed = 5;
        this.direction = Movement.DOWN;
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

    private void refreshImage(){
        switch (direction){
            case UP:
                getChicken().load("resources/images/blackchicken/up/blackchickenup.png");
                break;
            case DOWN:
                getChicken().load("resources/images/blackchicken/down/blackchickendown.png");
                break;
            case LEFT:
                getChicken().load("resources/images/blackchicken/left/blackchickenleft.png");
                break;
            case RIGHT:
                getChicken().load("resources/images/blackchicken/right/blackchickenright.png");
                break;
        }
    }

}
