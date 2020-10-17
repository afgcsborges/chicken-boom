package org.academiadecodigo.gnunas.chickenboomgame;

import org.academiadecodigo.gnunas.chickenboomgame.gameobjects.Movement;
import org.academiadecodigo.gnunas.chickenboomgame.gameobjects.SteroidType;
import org.academiadecodigo.gnunas.chickenboomgame.players.BlackChicken;
import org.academiadecodigo.gnunas.chickenboomgame.gameobjects.Obstacle;
import org.academiadecodigo.gnunas.chickenboomgame.gameobjects.Steroid;
import org.academiadecodigo.gnunas.chickenboomgame.players.WhiteChicken;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        Field field = new Field();
        WhiteChicken player1 = new WhiteChicken(field);
        BlackChicken player2 = new BlackChicken(field);
        GameController gameController = new GameController(player1,player2);
        Obstacle obstacle = new Obstacle(Movement.RIGHT,0,450,20);
        Steroid mushroom = new Steroid(SteroidType.MUSHROOM);

        while(true){

            Thread.sleep(50);

            player1.move();
            player2.move();
            obstacle.move();



        }
    }
}
