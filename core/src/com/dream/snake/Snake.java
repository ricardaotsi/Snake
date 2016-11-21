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
                position.get(0).posY -= acc * vel * dt;
                break;
            case DOWN:
                position.get(0).posY += acc * vel * dt;
                break;
            case LEFT:
                position.get(0).posX -= acc * vel * dt;
                break;
            case RIGHT:
                position.get(0).posX += acc * vel * dt;
                break;
        }

        if (position.get(0).posX+position.get(0).width<0)
            position.get(0).posX = w;
        if (position.get(0).posX>w)
            position.get(0).posX = -position.get(0).width;
        if(position.get(0).posY+position.get(0).height<0)
            position.get(0).posY = h;
        if(position.get(0).posY>h)
            position.get(0).posY = -position.get(0).height;
    }
}
