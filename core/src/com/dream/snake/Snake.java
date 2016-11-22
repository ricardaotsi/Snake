package com.dream.snake;

import java.util.ArrayList;

import static com.dream.snake.GameScreen.DOWN;
import static com.dream.snake.GameScreen.LEFT;
import static com.dream.snake.GameScreen.RIGHT;
import static com.dream.snake.GameScreen.UP;

/**
 * Created by ti on 17/11/2016.
 */

public class Snake {
    public ArrayList<SnakeBody> position;

    public Snake(int w, int h){
        position = new ArrayList<SnakeBody>();
        position.add(new SnakeBody(w,h));
    }

    public void Mover(int direction, float acc, float vel, float dt, float w, float h) {
        switch (direction){
            case UP:
                position.get(0).snakeBodypos.y -= acc * vel * dt;
                break;
            case DOWN:
                position.get(0).snakeBodypos.y += acc * vel * dt;
                break;
            case LEFT:
                position.get(0).snakeBodypos.x -= acc * vel * dt;
                break;
            case RIGHT:
                position.get(0).snakeBodypos.x += acc * vel * dt;
                break;
        }

        if (position.get(0).snakeBodypos.x+position.get(0).snakeBodypos.width<0)
            position.get(0).snakeBodypos.x = w;
        if (position.get(0).snakeBodypos.x>w)
            position.get(0).snakeBodypos.x = -position.get(0).snakeBodypos.width;
        if(position.get(0).snakeBodypos.y+position.get(0).snakeBodypos.height<0)
            position.get(0).snakeBodypos.y = h;
        if(position.get(0).snakeBodypos.y>h)
            position.get(0).snakeBodypos.y = -position.get(0).snakeBodypos.height;
    }
}
