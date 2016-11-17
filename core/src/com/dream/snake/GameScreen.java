package com.dream.snake;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by ti on 16/11/2016.
 */

public class GameScreen implements Screen {
    static final int READY = 0;
    static final int RUNNING = 1;
    static final int PAUSED = 2;
    static final int GAMEOVER = 3;

    private Game game;
    private int state;
    private BitmapFont font;
    private ShapeRenderer shapeRenderer;
    private Snake snake;

    public GameScreen (Game g){
        game = g;
        state = RUNNING;
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("Amatic.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = game.width/12;
        font = generator.generateFont(parameter);
        generator.dispose();
        shapeRenderer = new ShapeRenderer();
        snake = new Snake(game.width, game.height);
        Gdx.input.setInputProcessor(new InputAdapter());
    }

    private void updateReady(){
        if (Gdx.input.justTouched())
            state = RUNNING;
    }

    private void updateRunning(float dt){
        if (Gdx.input.isKeyPressed(Input.Keys.BACK)) {
            state = PAUSED;
        }

        if(Math.abs(Gdx.input.getAccelerometerX())>3f)
            snake.position.get(0).posY -= Gdx.input.getAccelerometerX() * 100 * dt;
        if(Math.abs(Gdx.input.getAccelerometerX())<-3f)
            snake.position.get(0).posY += Gdx.input.getAccelerometerX() * 100 * dt;
        if(Math.abs(Gdx.input.getAccelerometerY())>3f)
            snake.position.get(0).posX += Gdx.input.getAccelerometerY() * 100 * dt;
        if (Math.abs(Gdx.input.getAccelerometerY())<-3f)
            snake.position.get(0).posX -= Gdx.input.getAccelerometerY() * 100 * dt;

        if (snake.position.get(0).posX+snake.position.get(0).width<0)
            snake.position.get(0).posX = game.width;
        if (snake.position.get(0).posX>game.width)
            snake.position.get(0).posX = -snake.position.get(0).width;
        if(snake.position.get(0).posY+snake.position.get(0).height<0)
            snake.position.get(0).posY = game.height;
        if(snake.position.get(0).posY>game.height)
            snake.position.get(0).posY = -snake.position.get(0).height;
    }

    private void updatePaused(){

    }

    private void updateGameOver(){
        game.gameover = true;
        game.setScreen(new MenuScreen(game));
        dispose();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.305f, 0.803f, 0.768f, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.camera.update();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(0.780f,0.956f,0.392f,1);
        shapeRenderer.rect(snake.position.get(0).posX,snake.position.get(0).posY,snake.position.get(0).width,snake.position.get(0).height);
        shapeRenderer.end();
        game.batch.begin();
        font.setColor(0.780f,0.956f,0.392f,1);
        switch (state) {
            case READY:
                updateReady();
                font.draw(game.batch,"Press to play",game.width/2,game.height/2);
                break;
            case RUNNING:
                updateRunning(delta);
                font.draw(game.batch, Float.toString(Math.abs(Gdx.input.getAccelerometerX())),game.width/2,game.height/2);
                break;
            case PAUSED:
                font.draw(game.batch,"Paused",game.width/2,game.height/2);
                updatePaused();
                break;
            case GAMEOVER:
                updateGameOver();
                break;
        }
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {
        state = PAUSED;
    }

    @Override
    public void resume() {
        state = READY;
    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        font.dispose();
        shapeRenderer.dispose();
    }
}
