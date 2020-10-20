package org.academiadecodigo.gnunas.chickenboomgame;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Field {

    private Picture field;

    public Field(){
        field = new Picture(0,0,"resources/images/menus/mainmenu.png");
        field.draw();

    }

    public int getWidth(){
        return field.getWidth();
    }

    public int getHeight(){
        return field.getHeight();
    }

    public Picture getField() {
        return field;
    }
}
