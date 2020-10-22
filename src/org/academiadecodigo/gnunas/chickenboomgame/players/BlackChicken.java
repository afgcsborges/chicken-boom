package org.academiadecodigo.gnunas.chickenboomgame.players;

import org.academiadecodigo.gnunas.chickenboomgame.Field;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class BlackChicken extends Player {

    public BlackChicken(Field field) {

        super(field, new Picture((field.getWidth()/3f)*2,field.getHeight()/2f,"resources/images/blackchicken/down/blackchickendown.png"));

    }

    protected void refreshImage(){
        switch (getDirection()){
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
