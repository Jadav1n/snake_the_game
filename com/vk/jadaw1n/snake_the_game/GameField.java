package com.vk.jadaw1n.snake_the_game;

import javax.swing.*;
import java.awt.*;

class GameField extends JPanel {

    static Snake snake;

    static final int FIELD_SIZE = 512;
    static int speed = 1000;

    GameField(Snake snake){
        this.snake = snake;
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

        g.drawImage(MainFrame.background, 0, 0, null);

        if(isGameOver()) {
            g.drawImage(MainFrame.snake_game_over, 97, 163, null);
            return;
        }

        if(snake.body.size() == snake.MAX_LEN){
            g.drawImage(MainFrame.on_win_msg, 97, 163, null);
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
