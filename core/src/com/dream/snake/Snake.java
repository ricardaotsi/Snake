package com.dream.snake;

import java.util.ArrayList;

/**
 * Created by ti on 17/11/2016.
 */

public class Snake {
    public ArrayList<SnakeBody> position;

    public Snake(int w, int h){
        position = new ArrayList<SnakeBody>();
        position.add(new SnakeBody(w/2,h/2));
    }
}
