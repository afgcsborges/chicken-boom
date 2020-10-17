package org.academiadecodigo.gnunas.chickenboomgame;

import org.academiadecodigo.gnunas.chickenboomgame.gameobjects.Obstacle;
import org.academiadecodigo.gnunas.chickenboomgame.players.GameObject;
import org.academiadecodigo.gnunas.chickenboomgame.players.Player;

public class CollisionDetector {

    private GameObject[] objects;
    private Player[] chicken;

    public CollisionDetector(GameObject[] objects, Player[] chicken) {

        this.objects = objects;
        this.chicken = chicken;
    }

    public void checkCollision(Player chicken) {

        for (GameObject object: objects) {

            if (!(object instanceof Obstacle)) {
                continue;
            }

            GameObject obstacle = (Obstacle) object;

            if((chicken.getX()+chicken.getWidth()) > obstacle.getX() && < obstacle.getHeight() > )




        }

    }


}
