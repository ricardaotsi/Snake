package com.dream.snake;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.TimeUtils;
import java.util.Random;

/**
 * Created by ti on 21/11/2016.
 */

public class Food {
    public Rectangle foodpos;

    public Food(float w, float h){
        foodpos = new Rectangle(Rand(0,Math.round(w)), Rand(0, Math.round(h)), w/25, h/14);
    }

    private int Rand(int min, int max){
        long seed = TimeUtils.nanoTime();
        seed ^= (seed << 21);
        seed ^= (seed >>> 35);
        seed ^= (seed << 4);
        return new Random(seed).nextInt(max)+min;
    }
}
