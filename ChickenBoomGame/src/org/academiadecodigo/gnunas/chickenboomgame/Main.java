package org.academiadecodigo.gnunas.chickenboomgame;

import org.academiadecodigo.simplegraphics.graphics.Color;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        Field field = new Field();
        WhiteChicken player1 = new WhiteChicken(field);
        BlackChicken player2 = new BlackChicken(field);
        GameController gameController = new GameController(player1,player2);

        while(true){

            Thread.sleep(20);

            player1.move();
            player2.move();


        }
    }
}
