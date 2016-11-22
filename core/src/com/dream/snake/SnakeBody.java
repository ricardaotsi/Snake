package com.dream.snake;


import com.badlogic.gdx.math.Rectangle;

/**
 * Created by ti on 17/11/2016.
 */

public class SnakeBody {
    public Rectangle snakeBodypos;

    public SnakeBody(float w, float h){
        snakeBodypos = new Rectangle(w/2,h/2,w/25,h/14);
    }
}
