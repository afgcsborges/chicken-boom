package org.academiadecodigo.gnunas.chickenboomgame;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Field {

    private Rectangle field;

    public Field(){
        field = new Rectangle(0,0,1500,900);
        field.setColor(Color.GREEN);
        field.fill();
        Rectangle innerField = new Rectangle(120,120,1260,660);
        innerField.setColor(Color.GRAY);
        innerField.fill();
    }

    public int getCols(){
        return field.getWidth();
    }

    public int getWidth(){
        return field.getHeight();
    }


}
