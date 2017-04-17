package com.vk.jadaw1n.snake_the_game;

import java.awt.*;
import java.util.ArrayList;

class Snake {

    MainFrame main_frame;

    ArrayList<BodyBrick> body;

    private Image snake_brick;
    private Image food_brick;

    final int MIN_LEN = 2;
    final int MAX_LEN = 16;
    int len = MIN_LEN + 2;
    final int RIGHT = 0;
    final int LEFT = 1;
    final int UP = 2;
    final int DOWN = 3;
    int direction = RIGHT;

    final int START_X = 128;
    final int START_Y = 128;

    Food food;

    Snake(MainFrame main_frame){
        this.main_frame = main_frame;
        this.snake_brick = main_frame.snake_brick;
        this.food_brick = main_frame.food_brick;

        body = new ArrayList<BodyBrick>();
        for (int i = 0; i < len; i++) {
            body.add(new BodyBrick(START_X - i*32, START_Y));
        }

        food = new Food(randomize(), randomize());
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

    class BodyBrick{
        int x;
        int y;

        BodyBrick(int x, int y){
            this.x = x;
            this.y = y;
        }

        void draw(Graphics g){
            g.drawImage(snake_brick, x, y,null);
        }
    }

    class Food extends BodyBrick{
        Food(int x, int y){
            super(x, y);
        }

        @Override
        void draw(Graphics g){
            g.drawImage(food_brick, x, y, null);
        }

        void eat(){
            food = new Food(randomize(), randomize());
            main_frame.score++;
            main_frame.setTitle("Змейка | Счет: " + main_frame.score);
            GameField.speed -=60;
        }
    }

    int randomize(){
        return ((int)(Math.random()*15))*32;
    }
}
