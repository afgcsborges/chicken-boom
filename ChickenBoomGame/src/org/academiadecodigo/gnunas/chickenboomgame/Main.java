package org.academiadecodigo.gnunas.chickenboomgame;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;

public class Main {
    public static void main(String[] args) throws InterruptedException{

        GameEngine game = new GameEngine();


        Thread.sleep(500);

        game.init();
    }
}
