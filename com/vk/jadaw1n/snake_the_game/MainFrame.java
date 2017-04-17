package com.vk.jadaw1n.snake_the_game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class MainFrame extends JFrame {

    private static MainFrame main_frame;
    private static GameField game_field;

    private static Snake snake;
    private static int counter = 1;
    static int score = 0;

    static Image background;
    static Image snake_brick;
    static Image food_brick;
    static Image snake_game_over;
    static Image on_win_msg;

    private MainFrame(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(430,120);
        setSize(518,540);
        setResizable(false);
        getImages();
    }

    public static void main(String[] args){
        main_frame = new MainFrame();
        main_frame.setTitle("Змейка | Счет: " + score);
        snake = new Snake(main_frame);
        game_field = new GameField(snake, main_frame);
        main_frame.add(game_field);
        main_frame.setVisible(true);
        //while(true) SnakeMusic.play();
    }

    void setUpListeners(){
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("Сменили direction " + counter++ +" раз");
                int key = e.getKeyCode();
                switch(key){
                    case KeyEvent.VK_LEFT:
                        snake.direction = snake.LEFT;
                        //snake.move(game_field.getGraphics());
                        break;
                    case KeyEvent.VK_RIGHT:
                        snake.direction = snake.RIGHT;
                        //snake.move(game_field.getGraphics());
                        break;
                    case KeyEvent.VK_UP:
                        snake.direction = snake.UP;
                        //snake.move(game_field.getGraphics());
                        break;
                    case KeyEvent.VK_DOWN:
                        snake.direction = snake.DOWN;
                        //snake.move(game_field.getGraphics());
                        break;
                    default:
                        break;
                }
            }
        });
    }

    private void getImages() {

        try {
            background = ImageIO.read(GameField.class.getResourceAsStream("images\\background.jpg"));
            snake_brick = ImageIO.read(GameField.class.getResourceAsStream("images\\snake_brick.jpg"));
            food_brick = ImageIO.read(GameField.class.getResourceAsStream("images\\food_brick.jpg"));
            snake_game_over = ImageIO.read(GameField.class.getResourceAsStream("images\\snake_game_over.jpg"));
            on_win_msg = ImageIO.read(GameField.class.getResourceAsStream("images\\on_win_msg.jpg"));
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
