package com.vk.jadaw1n.snake_the_game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

class Snake {

    ArrayList<BodyBrick> body;
    Food food;

    final int MIN_LEN = 2;
    final int MAX_LEN = 16;
    final int START_X = 128;
    final int START_Y = 128;
    final int RIGHT = KeyEvent.VK_RIGHT;
    final int LEFT = KeyEvent.VK_LEFT;
    final int UP = KeyEvent.VK_UP;
    final int DOWN = KeyEvent.VK_DOWN;

    int len = MIN_LEN;
    int direction = RIGHT;

    Snake(){
        body = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            body.add(new BodyBrick(START_X - i*32, START_Y));
        }

        food = new Food(Food.randomize(), Food.randomize());
    }


    public void move(Graphics g){

        int x = body.get(0).x;
        int y = body.get(0).y;

        boolean isFood = (x == food.x && y == food.y);
        if( isFood ) food.eat();
        food.draw(g);

        switch(direction){
            case RIGHT:
                x += 32;
                break;
            case LEFT:
                x -= 32;
                break;
            case UP:
                y -= 32;
                break;
            case DOWN:
                y += 32;
                break;
            default:
                break;
        }

        body.add(0, new BodyBrick(x,y));
        if(!isFood) body.remove(body.size()-1);

        for (int i = 0; i < body.size(); i++) {
            body.get(i).draw(g);
        }
    }

    void setDirection(int arg){
        switch(arg){
            case RIGHT:
                if(direction != LEFT) direction = RIGHT;
                break;
            case LEFT:
                if(direction != RIGHT) direction = LEFT;
                break;
            case UP:
                if(direction != DOWN) direction = UP;
                break;
            case DOWN:
                if(direction != UP) direction = DOWN;
                break;
            default:
                break;
        }
    }
}
