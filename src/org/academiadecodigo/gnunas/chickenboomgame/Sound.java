package org.academiadecodigo.gnunas.chickenboomgame;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sound {

    private Clip clip;

    private File file;


    public Sound(String path) {

       file = new File(path);
       initClip();

    }

    public void play(boolean fromStart) {

        if(fromStart) {
            clip.setFramePosition(0);
        }
        clip.start();
    }

    public void stop() {

        clip.stop();
    }

    public void close() {
        clip.close();
    }

    public void setLoop(int times) {

        clip.loop(times);
    }

    private void initClip() {

        try {
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(file);

            clip = AudioSystem.getClip();
            clip.open(inputStream);
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
            System.err.println(ex.getMessage());
        }


    }


}
