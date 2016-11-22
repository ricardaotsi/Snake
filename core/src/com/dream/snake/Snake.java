package com.dream.snake;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import static com.dream.snake.GameScreen.DOWN;
import static com.dream.snake.GameScreen.LEFT;
import static com.dream.snake.GameScreen.RIGHT;
import static com.dream.snake.GameScreen.UP;

/**
 * Created by ti on 17/11/2016.
 */

public class Snake {
    public LinkedList<SnakeBody> position;

    public Snake(int x, int y){
        position = new LinkedList<SnakeBody>();
        position.add(new SnakeBody(x,y));
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

        if( position.size()>1) {
            for(int i=0; i<position.size()-1;i++){
                position.get(i+1).snakeBodypos.set(position.get(i).snakeBodypos.x,
                        position.get(i).snakeBodypos.y,
                        position.get(i).snakeBodypos.width,
                        position.get(i).snakeBodypos.height);
            }
        }
    }

    public void addBody(){
        position.add(new SnakeBody(position.getLast().snakeBodypos.x,position.getLast().snakeBodypos.y,position.getLast().snakeBodypos.width,position.getLast().snakeBodypos.height));
    }
}
