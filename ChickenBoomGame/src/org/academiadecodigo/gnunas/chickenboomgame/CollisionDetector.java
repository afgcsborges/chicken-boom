package org.academiadecodigo.gnunas.chickenboomgame;

import org.academiadecodigo.gnunas.chickenboomgame.gameobjects.Obstacle;
import org.academiadecodigo.gnunas.chickenboomgame.gameobjects.GameObject;
import org.academiadecodigo.gnunas.chickenboomgame.gameobjects.Steroid;
import org.academiadecodigo.gnunas.chickenboomgame.gameobjects.SteroidType;
import org.academiadecodigo.gnunas.chickenboomgame.players.BlackChicken;
import org.academiadecodigo.gnunas.chickenboomgame.players.Player;
import org.academiadecodigo.gnunas.chickenboomgame.players.WhiteChicken;

import java.util.LinkedList;

public class CollisionDetector {

    private LinkedList<GameObject> objects;
    private Player[] players;

    public CollisionDetector(LinkedList<GameObject> objects, Player[] players) {

        this.objects = objects;
        this.players = players;
    }


    public boolean checkRange(Positionable object1, Positionable object2) {

        if ((object2.getX() >= object1.getX() && object2.getX() <= object1.getXtoWidth())
                || (object2.getXtoWidth() <= object1.getXtoWidth() && object2.getXtoWidth() >= object1.getX())) {

            return (object2.getY() >= object1.getY() && object2.getY() <= object1.getYtoHeight())
                    || (object2.getYtoHeight() <= object1.getYtoHeight() && object2.getYtoHeight() >= object1.getY());
        }

        if ((object2.getY() >= object1.getY() && object2.getY() <= object1.getYtoHeight())
                || (object2.getYtoHeight() <= object1.getYtoHeight() && object2.getYtoHeight() >= object1.getY())) {

            return (object2.getX() >= object1.getX() && object2.getX() <= object1.getXtoWidth())
                    || (object2.getXtoWidth() <= object1.getXtoWidth() && object2.getXtoWidth() >= object1.getX());
        }

        return false;

    }

    public void checkCollision(Player player) {

        for (GameObject object : objects) {

            if (object instanceof Steroid) {

                GameObject steroids = (Steroid) object;

                if(checkRange(steroids, player)) {

                    Steroid steroid = (Steroid) object;
                    if (steroid.isUsed()){
                        continue;
                    }
                    object.delete();


                    if (steroid.getType() == SteroidType.ICE || steroid.getType() == SteroidType.SKULL) {
                        if (player instanceof WhiteChicken) {
                            BlackChicken player2 = (BlackChicken) players[1];
                            player2.setStatus(steroid.getType());
                            continue;
                        }

                        WhiteChicken player1 = (WhiteChicken) players[0];
                        player1.setStatus(steroid.getType());
                        continue;
                    }

                    if (steroid.getType() == SteroidType.CORN || steroid.getType() == SteroidType.MUSHROOM) {
                        if (player instanceof WhiteChicken) {
                            WhiteChicken player1 = (WhiteChicken) players[0];
                            player1.setStatus(steroid.getType());
                            continue;
                        }

                        BlackChicken player2 = (BlackChicken) players[1];
                        player2.setStatus(steroid.getType());
                        continue;
                    }
                }
                continue;
            }

            GameObject obstacle = (Obstacle) object;

            if (checkRange(obstacle, player)) {

                player.setCrashed();
            }
        }
        if (players.length == 2 && checkRange(players[0], players[1])) {
            players[0].setCrashed();
            players[1].setCrashed();
        }
    }


}
