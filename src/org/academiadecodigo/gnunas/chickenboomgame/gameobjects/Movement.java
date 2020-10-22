package org.academiadecodigo.gnunas.chickenboomgame.gameobjects;

public enum Movement {
    UP(0,-1),
    DOWN(0,1),
    RIGHT(1,0),
    LEFT(-1,0);

    public final int x;
    public final int y;

    Movement(int x, int y){
        this.x = x;
        this.y = y;
    }
}
