package org.academiadecodigo.gnunas.chickenboomgame;

import org.academiadecodigo.gnunas.chickenboomgame.gameobjects.Movement;
import org.academiadecodigo.gnunas.chickenboomgame.players.BlackChicken;
import org.academiadecodigo.gnunas.chickenboomgame.players.WhiteChicken;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class GameController implements KeyboardHandler {

    Keyboard gameController;
    WhiteChicken player1;
    BlackChicken player2;

    public GameController(WhiteChicken player1, BlackChicken player2){

        this.player1 = player1;
        this.player2 = player2;

        gameController = new Keyboard(this);

        KeyboardEvent moveP1Down = new KeyboardEvent();
        moveP1Down.setKey(KeyboardEvent.KEY_S);
        moveP1Down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        gameController.addEventListener(moveP1Down);

        KeyboardEvent moveP1Up = new KeyboardEvent();
        moveP1Up.setKey(KeyboardEvent.KEY_W);
        moveP1Up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        gameController.addEventListener(moveP1Up);

        KeyboardEvent moveP1Right = new KeyboardEvent();
        moveP1Right.setKey(KeyboardEvent.KEY_D);
        moveP1Right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        gameController.addEventListener(moveP1Right);

        KeyboardEvent moveP1Left = new KeyboardEvent();
        moveP1Left.setKey(KeyboardEvent.KEY_A);
        moveP1Left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        gameController.addEventListener(moveP1Left);

        KeyboardEvent moveP2Down = new KeyboardEvent();
        moveP2Down.setKey(KeyboardEvent.KEY_DOWN);
        moveP2Down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        gameController.addEventListener(moveP2Down);

        KeyboardEvent moveP2Up = new KeyboardEvent();
        moveP2Up.setKey(KeyboardEvent.KEY_UP);
        moveP2Up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        gameController.addEventListener(moveP2Up);

        KeyboardEvent moveP2Right = new KeyboardEvent();
        moveP2Right.setKey(KeyboardEvent.KEY_RIGHT);
        moveP2Right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        gameController.addEventListener(moveP2Right);

        KeyboardEvent moveP2Left = new KeyboardEvent();
        moveP2Left.setKey(KeyboardEvent.KEY_LEFT);
        moveP2Left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        gameController.addEventListener(moveP2Left);

        KeyboardEvent moveP1Stop = new KeyboardEvent();
        moveP1Stop.setKey(KeyboardEvent.KEY_Q);
        moveP1Stop.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        gameController.addEventListener(moveP1Stop);

        KeyboardEvent moveP2Stop = new KeyboardEvent();
        moveP2Stop.setKey(KeyboardEvent.KEY_SHIFT);
        moveP2Stop.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        gameController.addEventListener(moveP2Stop);

    }



    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (player1.isCrashed() || player2.isCrashed()) {
            return;
        }
        if ((keyboardEvent.getKey() == KeyboardEvent.KEY_S)){
            player1.moveInDirection(Movement.DOWN);
        }
        if ((keyboardEvent.getKey() == KeyboardEvent.KEY_W)){
            player1.moveInDirection(Movement.UP);
        }
        if ((keyboardEvent.getKey() == KeyboardEvent.KEY_D)){
            player1.moveInDirection(Movement.RIGHT);
        }
        if ((keyboardEvent.getKey() == KeyboardEvent.KEY_A)){
            player1.moveInDirection(Movement.LEFT);
        }
        if ((keyboardEvent.getKey() == KeyboardEvent.KEY_Q)){
            player1.stopMoving();
        }

        if ((keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN)){
            player2.moveInDirection(Movement.DOWN);
        }
        if ((keyboardEvent.getKey() == KeyboardEvent.KEY_UP)){
            player2.moveInDirection(Movement.UP);
        }
        if ((keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT)){
            player2.moveInDirection(Movement.RIGHT);
        }
        if ((keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT)){
            player2.moveInDirection(Movement.LEFT);
        }
        if ((keyboardEvent.getKey() == KeyboardEvent.KEY_SHIFT)){
            player2.stopMoving();
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
