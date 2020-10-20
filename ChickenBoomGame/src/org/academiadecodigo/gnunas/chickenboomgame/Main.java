package org.academiadecodigo.gnunas.chickenboomgame;

import org.academiadecodigo.gnunas.chickenboomgame.gameobjects.Movement;
import org.academiadecodigo.gnunas.chickenboomgame.gameobjects.SteroidType;
import org.academiadecodigo.gnunas.chickenboomgame.players.BlackChicken;
import org.academiadecodigo.gnunas.chickenboomgame.gameobjects.Obstacle;
import org.academiadecodigo.gnunas.chickenboomgame.gameobjects.Steroid;
import org.academiadecodigo.gnunas.chickenboomgame.players.WhiteChicken;

public class Main {
    public static void main(String[] args) throws InterruptedException{

        GameEngine game = new GameEngine();


        Thread.sleep(500);

        game.init();

        game.start();
    }
}
