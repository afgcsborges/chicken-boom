package org.academiadecodigo.gnunas.chickenboomgame;

import org.academiadecodigo.gnunas.chickenboomgame.gameobjects.GameObject;
import org.academiadecodigo.gnunas.chickenboomgame.gameobjects.GameObjectFactory;
import org.academiadecodigo.gnunas.chickenboomgame.players.BlackChicken;
import org.academiadecodigo.gnunas.chickenboomgame.players.Player;
import org.academiadecodigo.gnunas.chickenboomgame.players.WhiteChicken;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;

public class GameEngine {

    private Field field;
    private WhiteChicken player1;
    private BlackChicken player2;
    private final GameController gameController;
    private LinkedList<GameObject> gameObjects;
    private CollisionDetector collisionDetector;
    private Picture result;
    private Picture instructions;
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

        Picture arrow = new Picture(850, 270, "resources/images/menus/pointer.png");
        arrow.draw();
        SelectedKey currentKey = selectedKey;
        Sound menuSelection = new Sound("/resources/sound/selectmenusfx.wav");

        while (gameState != GameState.PLAYING) {

            if (currentKey != selectedKey) {
                if (selectedKey == SelectedKey.START) {
                    arrow.delete();
                    arrow = new Picture(850, 270, "resources/images/menus/pointer.png");
                    menuSelection.play(true);
                    arrow.draw();
                }
                if (selectedKey == SelectedKey.INSTRUCTION) {
                    arrow.delete();
                    arrow = new Picture(850, 410, "resources/images/menus/pointer.png");
                    menuSelection.play(true);

                    arrow.draw();
                }
                if (selectedKey == SelectedKey.EXIT) {
                    arrow.delete();
                    arrow = new Picture(850, 550, "resources/images/menus/pointer.png");
                    menuSelection.play(true);
                    arrow.draw();
                }
            }
            currentKey = selectedKey;

            if (gameState == GameState.INSTRUCTIONS) {
                showInstructions();
                while (gameState == GameState.INSTRUCTIONS){
                    Thread.sleep(50);
                }
                hideInstructions();
            }

            Thread.sleep(50);

        }
        arrow.delete();
    }

    public void start() throws InterruptedException{

        field.getField().load("resources/images/newgamearena.png");

        Sound battleBGM = new Sound("/resources/sound/chickenboombgm.wav");

        Thread.sleep(100);
        battleBGM.play(true);

        int levelController = 0;
        int currentLevel = 0;
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

        explode();

        gameState = GameState.GAMEOVER;

        showResult();
        new Sound("/resources/sound/deathsfx.wav").play(true);
        battleBGM.stop();

        while (gameState == GameState.GAMEOVER) {
            Thread.sleep(50);
        }
        if (gameState == GameState.PLAYING){

            battleBGM.stop();

            player1.hide();
            player2.hide();
            result.delete();
            player1 = new WhiteChicken(field);
            player2 = new BlackChicken(field);
            gameController.giveNewPlayers(player1,player2);
            clearAllObjects();
            start();
        }
        if (gameState == GameState.MAIN_MENU) {

            battleBGM.stop();

            player1.hide();
            player2.hide();
            result.delete();
            player1 = new WhiteChicken(field);
            player2 = new BlackChicken(field);
            gameController.giveNewPlayers(player1,player2);
            clearAllObjects();
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

    private void showInstructions() {
        if(instructions == null) {
            instructions = new Picture(0, 0, "resources/images/menus/instructionsmenu.png");
            instructions.draw();
        }
    }

    private void hideInstructions() {
        if(instructions != null) {
            instructions.delete();
            instructions = null;
        }
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

    public enum SelectedKey{
        START,
        INSTRUCTION,
        EXIT
    }

    public void exit() {
        System.exit(0);
    }

    private void clearAllObjects(){
        for ( GameObject o : gameObjects){
            o.delete();
        }
        gameObjects.clear();
    }

    public void explode() throws InterruptedException {

        new Sound("/resources/sound/explosionsfx.wav").play(true);

        if (player1.isCrashed() && player2.isCrashed()){

            Picture explosionP1 = new Picture(player1.getX()-25,player1.getY()-50,"resources/images/explosion/0.png");
            Picture explosionP2 = new Picture(player2.getX()-25,player2.getY()-50,"resources/images/explosion/0.png");
            explosionP1.draw();
            explosionP2.draw();

            for(int i = 1 ; i < 48 ; i++){
                explosionP1.load("resources/images/explosion/" + i + ".png");
                explosionP2.load("resources/images/explosion/" + i + ".png");
                if(i == 29) {
                    player2.hide();
                    player1.hide();
                }

                Thread.sleep(42);
            }
            explosionP1.delete();
            explosionP2.delete();
            return;
        }

        if(player1.isCrashed()){
            Picture explosionP1 = new Picture(player1.getX()-25,player1.getY()-50,"resources/images/explosion/0.png");
            explosionP1.draw();

            for(int i = 1 ; i < 48 ; i++){
                explosionP1.load("resources/images/explosion/" + i + ".png");

                if(i == 29) {
                    player1.hide();
                }

                Thread.sleep(42);
            }
            explosionP1.delete();
            return;
        }

        Picture explosionP2 = new Picture(player2.getX()-25,player2.getY()-50,"resources/images/explosion/0.png");
        explosionP2.draw();

        for(int i = 1 ; i < 48 ; i++){
            explosionP2.load("resources/images/explosion/" + i + ".png");

            if(i == 29) {

                player2.hide();
            }

            Thread.sleep(42);
        }
        explosionP2.delete();

    }

    public void playBokBok(){

        new Sound("/resources/sound/chosemenusfx.wav").play(true);
    }

}
