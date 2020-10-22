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
    GameEngine gameEngine;

    public GameController(WhiteChicken player1, BlackChicken player2, GameEngine gameEngine){
        this.gameEngine = gameEngine;
        this.player1 = player1;
        this.player2 = player2;

        gameController = new Keyboard(this);

        int[] keyCodes = new int[]{KeyboardEvent.KEY_ENTER, KeyboardEvent.KEY_ESC, KeyboardEvent.KEY_S,
                KeyboardEvent.KEY_W, KeyboardEvent.KEY_D, KeyboardEvent.KEY_A, KeyboardEvent.KEY_DOWN,
                KeyboardEvent.KEY_UP, KeyboardEvent.KEY_RIGHT, KeyboardEvent.KEY_LEFT, KeyboardEvent.KEY_Q,
                KeyboardEvent.KEY_SHIFT};

        for (int keyCode : keyCodes) {

            KeyboardEvent event = new KeyboardEvent();
            event.setKey(keyCode);
            event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            gameController.addEventListener(event);

        }

    }



    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (gameEngine.gameState == GameState.PLAYING) {
            if (player1.isCrashed() || player2.isCrashed()) {
                return;
            }
            if ((keyboardEvent.getKey() == KeyboardEvent.KEY_S)) {
                player1.moveInDirection(Movement.DOWN);
            }
            if ((keyboardEvent.getKey() == KeyboardEvent.KEY_W)) {
                player1.moveInDirection(Movement.UP);
            }
            if ((keyboardEvent.getKey() == KeyboardEvent.KEY_D)) {
                player1.moveInDirection(Movement.RIGHT);
            }
            if ((keyboardEvent.getKey() == KeyboardEvent.KEY_A)) {
                player1.moveInDirection(Movement.LEFT);
            }
            if ((keyboardEvent.getKey() == KeyboardEvent.KEY_Q)) {
                player1.stopMoving();
            }

            if ((keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN)) {
                player2.moveInDirection(Movement.DOWN);
            }
            if ((keyboardEvent.getKey() == KeyboardEvent.KEY_UP)) {
                player2.moveInDirection(Movement.UP);
            }
            if ((keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT)) {
                player2.moveInDirection(Movement.RIGHT);
            }
            if ((keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT)) {
                player2.moveInDirection(Movement.LEFT);
            }
            if ((keyboardEvent.getKey() == KeyboardEvent.KEY_SHIFT)) {
                player2.stopMoving();
            }
        }
        if (gameEngine.gameState == GameState.GAMEOVER) {
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_ENTER) {
                gameEngine.playBokBok();
                gameEngine.gameState = GameState.PLAYING;
            }

            if (keyboardEvent.getKey() == KeyboardEvent.KEY_ESC) {
                gameEngine.playBokBok();
                gameEngine.gameState = GameState.MAIN_MENU;
            }
        }
        if (gameEngine.gameState == GameState.MAIN_MENU) {

            if ((keyboardEvent.getKey() == KeyboardEvent.KEY_ENTER)) {

                gameEngine.playBokBok();

                if (gameEngine.selectedKey == GameEngine.SelectedKey.START) {
                    gameEngine.gameState = GameState.PLAYING;
                }
                if (gameEngine.selectedKey == GameEngine.SelectedKey.INSTRUCTION) {
                    gameEngine.gameState = GameState.INSTRUCTIONS;
                }
                if (gameEngine.selectedKey == GameEngine.SelectedKey.EXIT) {
                    gameEngine.exit();
                }
            }
            if ((keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN)) {
                gameEngine.selectedKey = gameEngine.selectedKey == GameEngine.SelectedKey.START ? GameEngine.SelectedKey.INSTRUCTION : GameEngine.SelectedKey.EXIT;
            }
            if ((keyboardEvent.getKey() == KeyboardEvent.KEY_UP)) {
                gameEngine.selectedKey = gameEngine.selectedKey == GameEngine.SelectedKey.EXIT ? GameEngine.SelectedKey.INSTRUCTION : GameEngine.SelectedKey.START;
            }
        }
        if (gameEngine.gameState == GameState.INSTRUCTIONS) {

            gameEngine.playBokBok();

            if (keyboardEvent.getKey() == KeyboardEvent.KEY_ESC ) {
                gameEngine.gameState = GameState.MAIN_MENU;
                gameEngine.selectedKey = GameEngine.SelectedKey.INSTRUCTION;
            }

        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public void giveNewPlayers(WhiteChicken p1, BlackChicken p2){
        player1 = p1;
        player2 = p2;
    }
}
