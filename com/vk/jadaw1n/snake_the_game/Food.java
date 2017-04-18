package com.vk.jadaw1n.snake_the_game;

class Food extends BodyBrick{

    Food(int x, int y){
        super(x, y);
    }

    void eat(){
        MainFrame.snake.food = new Food(randomize(), randomize());
        MainFrame.score++;
        MainFrame.main_frame.setTitle("Змейка | Счет: " + MainFrame.score);
        GameField.speed -=60;
    }

    static int randomize(){
        return ((int)(Math.random()*15))*32;
    }
}
