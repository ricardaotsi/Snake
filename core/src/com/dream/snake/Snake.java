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
    private float x;
    private float y;

    public Snake(int x, int y){
        position = new LinkedList<SnakeBody>();
        position.add(new SnakeBody(x,y));
    }

    public void Mover(int direction, float acc, float vel, float dt, float w, float h) {

        switch (direction){
            case UP:/*
                x=position.getLast().snakeBodypos.x;
                y=position.getLast().snakeBodypos.y-100;*/
                position.getFirst().snakeBodypos.y += acc* vel * dt;
                break;
            case DOWN:
                /*x=position.getLast().snakeBodypos.x;
                y=position.getLast().snakeBodypos.y+100;*/
                position.getFirst().snakeBodypos.y -=  acc* vel * dt;
                break;
            case LEFT:
                /*x=position.getLast().snakeBodypos.x+100;
                y=position.getLast().snakeBodypos.y;*/
                position.getFirst().snakeBodypos.x -=  acc * vel * dt;
                break;
            case RIGHT:
                /*x=position.getLast().snakeBodypos.x-100;
                y=position.getLast().snakeBodypos.y;*/
                position.getFirst().snakeBodypos.x +=  acc * vel * dt;
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

        for (int i=1;i<=position.size()-1;i++){
            SnakeBody partBefore = position.get(i-1);
            float xChange = partBefore.snakeBodypos.x - position.get(i).snakeBodypos.x;
            float yChange = partBefore.snakeBodypos.y - position.get(i).snakeBodypos.y;
            float angle = (float)Math.atan2(yChange, xChange);
            position.get(i).snakeBodypos.x=partBefore.snakeBodypos.x - (float)Math.cos(angle) * 10;
            position.get(i).snakeBodypos.y = partBefore.snakeBodypos.y - (float)Math.sin(angle) * 10;
        }



    }

    public void addBody(){
        position.add(new SnakeBody(position.getLast().snakeBodypos.x,position.getLast().snakeBodypos.y));
    }
}
