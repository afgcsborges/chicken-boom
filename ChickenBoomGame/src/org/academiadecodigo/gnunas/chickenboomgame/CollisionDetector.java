package org.academiadecodigo.gnunas.chickenboomgame;

import org.academiadecodigo.gnunas.chickenboomgame.gameobjects.Obstacle;
import org.academiadecodigo.gnunas.chickenboomgame.gameobjects.GameObject;
import org.academiadecodigo.gnunas.chickenboomgame.gameobjects.Steroid;
import org.academiadecodigo.gnunas.chickenboomgame.players.Player;

import java.util.LinkedList;

public class CollisionDetector {

    private LinkedList<GameObject> objects;
    private Player[] players;

    public CollisionDetector(LinkedList<GameObject> objects, Player[] players) {

        this.objects = objects;
        this.players = players;
    }


    public boolean checkRange(GameObject object, Player player) {

        if ((player.getX() >= object.getX() && player.getX() <= object.getXtoWith())
                || (player.getXtoWidth() <= object.getXtoWith() && player.getXtoWidth() >= object.getX())) {

            return (player.getY() >= object.getY() && player.getY() <= object.getYtoHeight())
                    || (player.getYtoHeight() <= object.getYtoHeight() && player.getYtoHeight() >= object.getY());
        }

        if ((player.getY() >= object.getY() && player.getY() <= object.getYtoHeight())
                || (player.getYtoHeight() <= object.getYtoHeight() && player.getYtoHeight() >= object.getY())) {

            return (player.getX() >= object.getX() && player.getX() <= object.getXtoWith())
                    || (player.getXtoWidth() <= object.getXtoWith() && player.getXtoWidth() >= object.getX());
        }

        return false;

    }

    public void checkCollision(Player player) {

        for (GameObject object : objects) {

            if (object instanceof Steroid) {

                GameObject steroid = (Steroid) object;

                continue;
                //checkRange(steroid, player)
                //implementar
            }

            GameObject obstacle = (Obstacle) object;

            if (checkRange(obstacle, player)) {

                player.setCrashed();
            }


        }

    }


}
