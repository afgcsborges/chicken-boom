package org.academiadecodigo.gnunas.chickenboomgame.players;

import org.academiadecodigo.gnunas.chickenboomgame.Field;
import org.academiadecodigo.gnunas.chickenboomgame.gameobjects.Movement;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class BlackChicken extends Player {

    private boolean moving ;
    private Movement direction;


    public BlackChicken(Field field) {
        super(field, new Rectangle(990, 440, 20, 20), Color.GREEN);
        //setChicken(new Rectangle(490, 440, 20, 20));
        //getChicken().fill();
        show();
    }

    public void move(){
        if(moving) {
            switch (direction) {
                case LEFT:
                    getChicken().translate(-10, 0);
                    break;
                case RIGHT:
                    getChicken().translate(10, 0);
                    break;
                case DOWN:
                    getChicken().translate(0, 10);
                    break;
                case UP:
                    getChicken().translate(0, -10);
                    break;

            }
        }

    }

    public void moveInDirection(Movement direction){
        this.direction = direction;
        moving = true;
    }

    public void stopMoving(){
        moving = false;
    }

}
