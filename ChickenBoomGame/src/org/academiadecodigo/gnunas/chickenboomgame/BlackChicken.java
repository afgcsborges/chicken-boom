package org.academiadecodigo.gnunas.chickenboomgame;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

public class BlackChicken extends Player{

    Keyboard keyboard = super.keyboard;


    public BlackChicken(Field field) {
        super(field, new Rectangle(990, 440, 20, 20), Color.GREEN);
        //setChicken(new Rectangle(490, 440, 20, 20));
        //getChicken().fill();
        show();
        KeyboardEvent keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKey(KeyboardEvent.KEY_DOWN);
        keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEvent);

        KeyboardEvent keyboardEvent2 = new KeyboardEvent();
        keyboardEvent2.setKey(KeyboardEvent.KEY_UP);
        keyboardEvent2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEvent2);

        KeyboardEvent keyboardEvent3 = new KeyboardEvent();
        keyboardEvent3.setKey(KeyboardEvent.KEY_RIGHT);
        keyboardEvent3.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEvent3);

        KeyboardEvent keyboardEvent4 = new KeyboardEvent();
        keyboardEvent4.setKey(KeyboardEvent.KEY_LEFT);
        keyboardEvent4.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEvent4);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if ((keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN)){
            getChicken().translate(0,10);
        }
        if ((keyboardEvent.getKey() == KeyboardEvent.KEY_UP)){
            getChicken().translate(0,-10);
        }
        if ((keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT)){
            getChicken().translate(10,0);
        }
        if ((keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT)){
            getChicken().translate(-10,0);
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
