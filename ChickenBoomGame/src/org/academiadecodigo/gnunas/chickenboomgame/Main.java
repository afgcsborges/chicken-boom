package org.academiadecodigo.gnunas.chickenboomgame;

import org.academiadecodigo.simplegraphics.graphics.Color;

public class Main {
    public static void main(String[] args) {
        Field field = new Field();
        Player chicken = new WhiteChicken(field);
        Player chicken2 = new BlackChicken(field);
    }
}
