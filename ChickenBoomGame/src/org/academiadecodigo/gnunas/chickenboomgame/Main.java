package org.academiadecodigo.gnunas.chickenboomgame;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        Field field = new Field();
        WhiteChicken player1 = new WhiteChicken(field);
        BlackChicken player2 = new BlackChicken(field);
        GameController gameController = new GameController(player1,player2);
        Obstacles obstacle = new Obstacles(Movement.RIGHT,0,450,20);
        Steroids mushroom = new Steroids(SteroidType.MUSHROOM);

        while(true){

            Thread.sleep(50);

            player1.move();
            player2.move();
            obstacle.move();



        }
    }
}
