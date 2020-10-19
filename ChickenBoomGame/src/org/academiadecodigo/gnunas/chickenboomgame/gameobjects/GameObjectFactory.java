package org.academiadecodigo.gnunas.chickenboomgame.gameobjects;

import org.academiadecodigo.gnunas.chickenboomgame.*;

import java.util.LinkedList;

public class GameObjectFactory {

    public static void generateObjects(int gameLevel, LinkedList<GameObject> gameObjectsList){

        if (gameLevel%3 == 0){
            for (GameObject gameObjects : gameObjectsList){
                gameObjects.delete();
            }
            gameObjectsList.clear();
            gameObjectsList.add(generateRandomSteroid());
        }

        for(int i = 0 ; i < gameLevel ; i ++){
            gameObjectsList.add(generateRandomObstacle());
        }

    }

    public static Obstacle generateRandomObstacle(){


        Movement startLocation = Movement.values()[(int)(Math.random() * Movement.values().length)];
        Spells randomSpell = Spells.values()[(int) (Math.random() * Spells.values().length)];

        switch (startLocation){
            case UP:
                return new Obstacle(Movement.DOWN,(int)((Math.random()*1260-40)+120),0,10, randomSpell);
            case DOWN:
                return new Obstacle(Movement.UP,(int)((Math.random()*1260-40)+120),900-120,10, randomSpell);
            case LEFT:
                return new Obstacle(Movement.RIGHT,0,(int)((Math.random()*660-40)+120),10, randomSpell);
            case RIGHT:
                return new Obstacle(Movement.LEFT,1499-120,(int)((Math.random()*660-40)+120),10, randomSpell);
        }
        return null;
    }

    public static Steroid generateRandomSteroid(){
        SteroidType random = SteroidType.values()[(int)(Math.random()*SteroidType.values().length)];
        switch (random){
            case ICE:
                return new Steroid(SteroidType.ICE);
            case CORN:
                return new Steroid(SteroidType.CORN);
            case MUSHROOM:
                return new Steroid(SteroidType.MUSHROOM);
            case SKULL:
                return new Steroid(SteroidType.SKULL);
        }
        return null;
    }

}
