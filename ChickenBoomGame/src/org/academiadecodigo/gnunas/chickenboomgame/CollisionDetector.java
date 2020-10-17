package org.academiadecodigo.gnunas.chickenboomgame;

import org.academiadecodigo.gnunas.chickenboomgame.gameobjects.Obstacle;
import org.academiadecodigo.gnunas.chickenboomgame.gameobjects.GameObject;
import org.academiadecodigo.gnunas.chickenboomgame.players.Player;

import java.util.LinkedList;

public class CollisionDetector {

    private LinkedList<GameObject> objects;
    private Player[] players;

    public CollisionDetector(LinkedList<GameObject> objects, Player[] players) {

        this.objects = objects;
        this.players = players ;
    }

    /*public void checkCollision(Player chicken) {

        for (GameObject object: objects) {

            if (!(object instanceof Obstacle)) {
                continue;
            }

            GameObject obstacle = (Obstacle) object;

            if((chicken.getX()+chicken.getWidth()) > obstacle.getX() && < obstacle.getHeight() > )




        }

    }*/


}
