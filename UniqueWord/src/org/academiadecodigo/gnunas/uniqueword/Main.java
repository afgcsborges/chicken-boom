package org.academiadecodigo.gnunas.uniqueword;

public class Main {

    public static void main(String[] args) {

        UniqueWord uniqueWord = new UniqueWord();

        uniqueWord.addWords("sim sim sim amarelo amarelo hotpink hotpink");

        for (String string: uniqueWord.getWordsList()) {

            System.out.println(string);

        }


    }
}
