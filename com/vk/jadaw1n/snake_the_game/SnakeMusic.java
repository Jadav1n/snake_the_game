package com.vk.jadaw1n.snake_the_game;

import javazoom.jl.player.AudioDevice;
import javazoom.jl.player.JavaSoundAudioDevice;
import javazoom.jl.player.advanced.AdvancedPlayer;
import java.io.FileInputStream;


public class SnakeMusic {

    public static boolean isPlaying;

    public static AdvancedPlayer explay;
    public static String audioPath = "src\\com\\vk\\jadaw1n\\snake_the_game\\sounds\\8_bit_music.mp3";


    public static void play() {
        try {
            FileInputStream f_stream = new FileInputStream(audioPath);
            AudioDevice auDev = new JavaSoundAudioDevice();
            explay = new AdvancedPlayer(f_stream, auDev);
            explay.play();
        } catch (Exception err) {
            err.printStackTrace();
        }

        isPlaying = true;
    }
}
