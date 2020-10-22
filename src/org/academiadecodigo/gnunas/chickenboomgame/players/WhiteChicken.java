package org.academiadecodigo.gnunas.chickenboomgame.players;

import org.academiadecodigo.gnunas.chickenboomgame.Field;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class WhiteChicken extends Player {

    public WhiteChicken(Field field) {

        super(field, new Picture(field.getWidth()/3f,field.getHeight()/2f,"resources/images/whitechicken/down/whitechickendown.png"));
    }

    protected void refreshImage(){
        switch (getDirection()){
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
