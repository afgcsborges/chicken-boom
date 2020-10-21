package org.academiadecodigo.gnunas.chickenboomgame;

public class Main {
    public static void main(String[] args) throws InterruptedException{

        GameEngine game = new GameEngine();

        game.init();

        game.start();
    }
}
