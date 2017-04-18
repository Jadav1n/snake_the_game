package com.vk.jadaw1n.snake_the_game;

import java.awt.Image;
import java.awt.Graphics;

class BodyBrick{

    int x;
    int y;

    BodyBrick(int x, int y){
        this.x = x;
        this.y = y;
    }

    void draw(Graphics g){
        g.drawImage(MainFrame.brick, x, y,null);
    }
}
