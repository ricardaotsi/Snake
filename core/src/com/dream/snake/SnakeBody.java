package com.dream.snake;


import com.badlogic.gdx.math.Rectangle;

/**
 * Created by ti on 17/11/2016.
 */

public class SnakeBody {
    public Rectangle snakeBodypos;

    public SnakeBody(float x, float y){
        snakeBodypos = new Rectangle(x,y,100,100);
    }
}
