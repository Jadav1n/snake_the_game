package com.vk.jadaw1n.snake_the_game;

import javax.swing.*;
import java.awt.*;

class GameField extends JPanel {

    private static Snake snake;
    private static MainFrame main_frame;

    private static Image background;
    private static Image snake_game_over;

    private static final int FIELD_SIZE = 512;
    static int speed = 800;

    GameField(Snake snake, MainFrame main_frame){
        this.main_frame = main_frame;
        this.snake = snake;
        main_frame.setUpListeners();
        this.background = main_frame.background;
        this.snake_game_over = main_frame.snake_game_over;
    }

    @Override
    protected void paintComponent(Graphics g){

        super.paintComponent(g);

        try{
            Thread.sleep(speed);
        } catch (InterruptedException e) {  e.printStackTrace();    }

        onRepaint(g);
        repaint();
    }

    private void onRepaint(Graphics g) {

        g.drawImage(background, 0, 0, null);

        if(isGameOver()) {
            g.drawImage(snake_game_over, 97, 163, null);
            return;
        }

        if(snake.body.size() == snake.MAX_LEN){
            g.drawImage(main_frame.on_win_msg, 97, 163, null);
            return;
        }

        snake.move(g);
    }

    boolean isGameOver(){

        for (int i = 3; i <= snake.body.size()-1; i++) {
            if(snake.body.get(0).x == snake.body.get(i).x && snake.body.get(0).y == snake.body.get(i).y )
                return true;
        }

        return snake.body.get(0).x >= FIELD_SIZE ||
                snake.body.get(0).x < 0 ||
                snake.body.get(0).y < 0 ||
                snake.body.get(0).y >= FIELD_SIZE;
    }
}
