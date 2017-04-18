package com.vk.jadaw1n.snake_the_game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class MainFrame extends JFrame {

    static MainFrame main_frame;
    static GameField game_field;
    static Snake snake;

    static Image background;
    static Image brick;
    static Image snake_game_over;
    static Image on_win_msg;

    static int score = 0;

    private MainFrame(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(430,120);
        setSize(518,540);
        setResizable(false);

        getImages();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                snake.setDirection(e.getKeyCode());
            }
        });
    }

    public static void main(String[] args){
        main_frame = new MainFrame();
        main_frame.setTitle("Змейка | Счет: " + score);
        snake = new Snake();
        game_field = new GameField(snake);
        main_frame.add(game_field);
        main_frame.setVisible(true);
        //while(true) SnakeMusic.play();
    }

    private static void getImages() {

        try {
            background = ImageIO.read(GameField.class.getResourceAsStream("images\\background.jpg"));
            brick = ImageIO.read(GameField.class.getResourceAsStream("images\\brick.jpg"));
            snake_game_over = ImageIO.read(GameField.class.getResourceAsStream("images\\snake_game_over.jpg"));
            on_win_msg = ImageIO.read(GameField.class.getResourceAsStream("images\\on_win_msg.jpg"));
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
