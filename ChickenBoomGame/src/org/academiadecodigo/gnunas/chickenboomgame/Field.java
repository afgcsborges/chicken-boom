package org.academiadecodigo.gnunas.chickenboomgame;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Field {

    private Rectangle field;

    public Field(){
        field = new Rectangle(0,0,1500,900);
        field.draw();
    }

    public int getCols(){
        return field.getWidth();
    }

    public int getWidth(){
        return field.getHeight();
    }


}
