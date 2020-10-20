package org.academiadecodigo.gnunas.chickenboomgame;

import org.academiadecodigo.gnunas.chickenboomgame.gameobjects.GameObject;
import org.academiadecodigo.gnunas.chickenboomgame.gameobjects.GameObjectFactory;
import org.academiadecodigo.gnunas.chickenboomgame.players.BlackChicken;
import org.academiadecodigo.gnunas.chickenboomgame.players.Player;
import org.academiadecodigo.gnunas.chickenboomgame.players.WhiteChicken;
import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;
import java.io.IOException;
import java.util.LinkedList;

public class GameEngine {

    private Field field;
    private WhiteChicken player1;
    private BlackChicken player2;
    private GameController gameController;
    private int levelController;
    private int currentLevel;
    private LinkedList<GameObject> gameObjects;
    private CollisionDetector collisionDetector;
    private Picture result;
    public GameState gameState;
    public SelectedKey selectedKey;


    public GameEngine() {
        field = new Field();
        player1 = new WhiteChicken(field);
        player2 = new BlackChicken(field);
        gameController = new GameController(player1, player2, this);
        gameState = GameState.MAIN_MENU;
        selectedKey = SelectedKey.START;
    }


    public void init() throws InterruptedException {



        Picture arrow = new Picture(850, 270, "resources/images/menus/menuselection.png");
        arrow.draw();
        SelectedKey currentKey = selectedKey;

        while (gameState != GameState.PLAYING) {

            if (currentKey != selectedKey) {
                if (selectedKey == SelectedKey.START) {
                    arrow.delete();
                    arrow = new Picture(850, 270, "resources/images/menus/menuselection.png");
                    arrow.draw();
                }
                if (selectedKey == SelectedKey.INSTRUCTION) {
                    arrow.delete();
                    arrow = new Picture(850, 401, "resources/images/menus/menuselection.png");
                    arrow.draw();
                }
                if (selectedKey == SelectedKey.EXIT) {
                    arrow.delete();
                    arrow = new Picture(850, 532, "resources/images/menus/menuselection.png");
                    arrow.draw();
                }
            }
            currentKey = selectedKey;

            Thread.sleep(50);

        }
        arrow.delete();
    }

    public void start() throws InterruptedException{

        field.getField().load("resources/images/newgamearena.png");

        levelController = 0;
        currentLevel = 0;
        gameObjects = new LinkedList<>();
        collisionDetector = new CollisionDetector(gameObjects, new Player[]{player1, player2});

        player1.show();
        player2.show();


        Thread.sleep(2000);
        long loopStart = System.currentTimeMillis();
        long loopEnd = System.currentTimeMillis();

        while (!gameOver()) {

            long elapsedLoopTime = loopEnd - loopStart;
            elapsedLoopTime = elapsedLoopTime > 25 ? 25 : elapsedLoopTime;

            Thread.sleep(25 - (elapsedLoopTime));
            loopStart = System.currentTimeMillis();
            player1.move();
            player2.move();
            if (levelController % 150 == 0) {

                currentLevel++;
                GameObjectFactory.generateObjects(currentLevel, gameObjects);
            }
            moveAllGameObjects();

            checkForPlayerCollision();

            levelController++;
            loopEnd = System.currentTimeMillis();

        }
        gameState = GameState.GAMEOVER;
        showResult();

        while (gameState == GameState.GAMEOVER) {
            Thread.sleep(50);
        }
        if (gameState == GameState.PLAYING){
            player1.hide();
            player2.hide();
            result.delete();
            player1 = new WhiteChicken(field);
            player2 = new BlackChicken(field);
            gameController.giveNewPlayers(player1,player2);
            gameObjects.clear();
            start();
        }
        if (gameState == GameState.MAIN_MENU) {
            player1.hide();
            player2.hide();
            result.delete();
            player1 = new WhiteChicken(field);
            player2 = new BlackChicken(field);
            gameObjects.clear();
            field.getField().delete();
            field = new Field();
            selectedKey = SelectedKey.START;
            init();
            start();
        }

    }

    private void showResult() {
        String roastedChickenPath = "resources/images/deadchicken/roastedchicken.png";
        if (player1.isCrashed()) {
           player1.setPicture(roastedChickenPath);
        }
        if (player2.isCrashed()) {
            player2.setPicture(roastedChickenPath);
        }

        String image = "tie.png";
        player1.hide();
        player2.hide();

        if(!player1.isCrashed()) {
            image = "whitechickenwin.png";
            player2.show();
        } else if (!player2.isCrashed()) {
            image = "blackchickenwin.png";
            player1.show();
        }
        result = new Picture(0, 0, "resources/images/matchresult/" + image);
        result.draw();

    }

    private void moveAllGameObjects(){
        for (GameObject object : gameObjects){
            object.move();
        }
    }

    private boolean gameOver(){
        return player1.isCrashed() || player2.isCrashed() ;
    }

    private void checkForPlayerCollision(){
        collisionDetector.checkCollision(player1);
        collisionDetector.checkCollision(player2);

    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public GameState getGameState() {
        return gameState;
    }

    public enum SelectedKey{
        START,
        INSTRUCTION,
        EXIT
    }

    public void setSelectedKey(SelectedKey selectedKey) {
        this.selectedKey = selectedKey;
    }

    public void exit() {
        System.exit(0);
    }
}
