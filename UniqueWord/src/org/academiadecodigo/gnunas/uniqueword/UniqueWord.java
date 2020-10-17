package org.academiadecodigo.gnunas.uniqueword;

import java.util.LinkedHashSet;

public class UniqueWord {

    private LinkedHashSet<String> wordsList;

    public UniqueWord() {

        wordsList = new LinkedHashSet<>();
    }

    public LinkedHashSet<String> getWordsList(){
        return wordsList;
    }

    public void addWords(String message) {

        String[] arr = message.split(" ");

        for (String string: arr) {

            wordsList.add(string);

        }


    }


}
