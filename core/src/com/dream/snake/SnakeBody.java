package com.dream.snake;

/**
 * Created by ti on 17/11/2016.
 */

public class SnakeBody {
    public float posX;
    public float posY;
    public float width;
    public float height;

    public SnakeBody(float w, float h){
        posX = w/2;
        posY = h/2;
        width = w/25.6f;
        height = h/14.4f;
    }
}
