package com.dream.snake;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

/**
 * Created by ti on 16/11/2016.
 */

public class GameScreen implements Screen {
    private enum gameState{RUNNING, PAUSED, GAMEOVER}

    private Game game;
    private gameState state;

    public GameScreen (Game g){
        game = g;
        state = gameState.RUNNING;
        Gdx.input.setInputProcessor(new InputAdapter());
    }

    private void updateRunning(){
        if (Gdx.input.isKeyPressed(Input.Keys.BACK)) {
           /* game.backpressed = true;
            game.setScreen(new MenuScreen(game));
            dispose();*/
            state = gameState.PAUSED;
        }
    }

    private void updatePaused(){

    }

    private void updateGameOver(){

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        switch (state) {
            case RUNNING:
                updateRunning();
                Gdx.gl.glClearColor(0.305f, 0.803f, 0.768f, 0);
                Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
                game.camera.update();
                break;
            case PAUSED:
                updatePaused();
                break;
            case GAMEOVER:
                updateGameOver();
                break;
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {
        state = gameState.PAUSED;
    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
