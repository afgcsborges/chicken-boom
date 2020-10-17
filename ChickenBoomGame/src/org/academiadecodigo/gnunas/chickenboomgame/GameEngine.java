package org.academiadecodigo.gnunas.chickenboomgame;

import org.academiadecodigo.gnunas.chickenboomgame.gameobjects.GameObjectFactory;
import org.academiadecodigo.gnunas.chickenboomgame.gameobjects.GameObjects;
import org.academiadecodigo.gnunas.chickenboomgame.players.BlackChicken;
import org.academiadecodigo.gnunas.chickenboomgame.players.WhiteChicken;

import java.util.LinkedList;

public class GameEngine {

    private Field field;
    private WhiteChicken player1;
    private BlackChicken player2;
    private GameController gameController;
    private int levelController;
    private int currentLevel;
    private LinkedList<GameObjects> gameObjects;



    public GameEngine(){
        field = new Field();
        player1 = new WhiteChicken(field);
        player2 = new BlackChicken(field);
        gameController = new GameController(player1,player2);
        levelController = 0;
        currentLevel = 0;
        gameObjects = new LinkedList<>();

    }




    public void init() throws  InterruptedException{
        while(true) {

            Thread.sleep(50);

            if (levelController % 75 == 0){

                currentLevel++;
                GameObjectFactory.generateObjects(currentLevel,gameObjects);
            }

            player1.move();
            player2.move();
            moveAllGameObjects();

            levelController ++;



        }
    }

    private void moveAllGameObjects(){
        for (GameObjects object : gameObjects){
            object.move();
        }
    }
}
