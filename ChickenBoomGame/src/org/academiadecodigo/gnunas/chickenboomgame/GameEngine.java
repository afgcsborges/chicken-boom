package org.academiadecodigo.gnunas.chickenboomgame;

import org.academiadecodigo.gnunas.chickenboomgame.gameobjects.GameObject;
import org.academiadecodigo.gnunas.chickenboomgame.gameobjects.GameObjectFactory;
import org.academiadecodigo.gnunas.chickenboomgame.players.BlackChicken;
import org.academiadecodigo.gnunas.chickenboomgame.players.Player;
import org.academiadecodigo.gnunas.chickenboomgame.players.WhiteChicken;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

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



    public GameEngine(){
        field = new Field();
        player1 = new WhiteChicken(field);
        player2 = new BlackChicken(field);
        gameController = new GameController(player1,player2);
        levelController = 0;
        currentLevel = 0;
        gameObjects = new LinkedList<>();
        collisionDetector = new CollisionDetector(gameObjects,new Player[] {player1,player2});

    }




    public void init() throws  InterruptedException{

        Thread.sleep(2000);

        while(!gameOver()) {

            Thread.sleep(50);

            if (levelController % 75 == 0){

                currentLevel++;
                GameObjectFactory.generateObjects(currentLevel,gameObjects);
            }

            player1.move();
            player2.move();
            moveAllGameObjects();

            checkForPlayerCollision();

            levelController ++;

        }

        showResult();
    }

    private void showResult() {
        Rectangle winner = new Rectangle(200, 200 , 80, 80);
        winner.setColor(Color.RED);
        if(!player1.isCrashed()) {
           //player1 wins!
            winner.setColor(Color.BLACK);
        } else if (!player2.isCrashed()) {
           //player2 wins!
            winner.setColor(Color.WHITE);
        }
        winner.draw();
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
}
