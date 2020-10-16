package org.academiadecodigo.gnunas.chickenboomgame.gameobjects;

import org.academiadecodigo.gnunas.chickenboomgame.*;

import java.util.LinkedList;

public class GameObjectFactory {

    public static void generateObjects(int gameLevel, LinkedList<GameObjects> gameObjectsList){

        if (gameLevel%5 == 0){
            for (GameObjects gameObjects : gameObjectsList){
                gameObjects.delete();
            }
            gameObjectsList.clear();
            gameObjectsList.add(generateRandomSteroid());
        }

        for(int i = 0 ; i < gameLevel ; i ++){
            gameObjectsList.add(generateRandomObstacle());
        }

    }

    public static Obstacles generateRandomObstacle(){
        Movement startLocation = Movement.values()[(int)(Math.random() * Movement.values().length)];
        switch (startLocation){
            case UP:
                return new Obstacles(Movement.DOWN,(int)((Math.random()*1260-40)+120),0,20);
            case DOWN:
                return new Obstacles(Movement.UP,(int)((Math.random()*1260-40)+120),900-120,20);
            case LEFT:
                return new Obstacles(Movement.RIGHT,0,(int)((Math.random()*660-40)+120),20);
            case RIGHT:
                return new Obstacles(Movement.LEFT,1499-120,(int)((Math.random()*660-40)+120),20);
        }
        return null;
    }

    public static Steroids generateRandomSteroid(){
        SteroidType random = SteroidType.values()[(int)(Math.random()*SteroidType.values().length)];
        switch (random){
            case ICE:
                return new Steroids(SteroidType.ICE);
            case CORN:
                return new Steroids(SteroidType.CORN);
            case MUSHROOM:
                return new Steroids(SteroidType.MUSHROOM);
            case SKULL:
                return new Steroids(SteroidType.SKULL);
        }
        return null;
    }

}
