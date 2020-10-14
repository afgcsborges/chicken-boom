package org.academiadecodigo.gnunas.chickenboomgame;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.w3c.dom.css.Rect;

public class WhiteChicken extends Player{

    Keyboard keyboard = super.keyboard;

    public WhiteChicken(Field field) {
        super(field, new Rectangle(490, 440, 20, 20), Color.BLACK);
        //setChicken(new Rectangle(490, 440, 20, 20));

        //getChicken().fill();
        show();
        KeyboardEvent keyboardEvent6 = new KeyboardEvent();
        keyboardEvent6.setKey(KeyboardEvent.KEY_S);
        keyboardEvent6.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEvent6);

        KeyboardEvent keyboardEvent7 = new KeyboardEvent();
        keyboardEvent7.setKey(KeyboardEvent.KEY_W);
        keyboardEvent7.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEvent7);

        KeyboardEvent keyboardEvent8 = new KeyboardEvent();
        keyboardEvent8.setKey(KeyboardEvent.KEY_D);
        keyboardEvent8.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEvent8);

        KeyboardEvent keyboardEvent9 = new KeyboardEvent();
        keyboardEvent9.setKey(KeyboardEvent.KEY_A);
        keyboardEvent9.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEvent9);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if ((keyboardEvent.getKey() == KeyboardEvent.KEY_S)){
            getChicken().translate(0,10);
        }
        if ((keyboardEvent.getKey() == KeyboardEvent.KEY_W)){
            getChicken().translate(0,-10);
        }
        if ((keyboardEvent.getKey() == KeyboardEvent.KEY_D)){
            getChicken().translate(10,0);
        }
        if ((keyboardEvent.getKey() == KeyboardEvent.KEY_A)){
            getChicken().translate(-10,0);
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
