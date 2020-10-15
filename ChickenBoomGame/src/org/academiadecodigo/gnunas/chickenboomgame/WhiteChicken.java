package org.academiadecodigo.gnunas.chickenboomgame;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.w3c.dom.css.Rect;

public class WhiteChicken extends Player{

    private boolean moving ;
    private Movement direction;
    //private stauts ...

    public WhiteChicken(Field field) {
        super(field, new Rectangle(490, 440, 20, 20), Color.BLACK);
        //setChicken(new Rectangle(490, 440, 20, 20));

        //getChicken().fill();
        show();

    }

    public void move() {
        if (moving) {
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
