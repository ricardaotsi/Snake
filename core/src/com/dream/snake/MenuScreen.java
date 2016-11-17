package com.dream.snake;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.freetype.*;

/**
 * Created by ti on 16/11/2016.
 */

public class MenuScreen implements Screen{
    private Game game;
    private boolean start;
    private BitmapFont font;
    private GlyphLayout glyphLayout;

    public MenuScreen(Game g){
        game = g;
        start = false;
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("Amatic.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = game.width/8;
        font = generator.generateFont(parameter);
        generator.dispose();
        glyphLayout = new GlyphLayout();
        Gdx.input.setInputProcessor(new InputAdapter(){
            @Override
            public boolean touchDown (int x, int y, int pointer, int button) {
                if(!start){
                    start=true;
                    return true;
                }
                return false;
            }
            @Override
            public boolean touchUp (int x, int y, int pointer, int button) {
                if(start) {
                    game.gameover = false;
                    game.setScreen(new GameScreen(game));
                    dispose();
                    return true;
                }
                return false;
            }
        });
    }

    private void Update (){
        if (Gdx.input.isKeyPressed(Input.Keys.BACK)){
            Gdx.app.exit();
        }
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Update();
        Gdx.gl.glClearColor(1, 0.419f, 0.419f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.camera.update();
        game.batch.begin();
        glyphLayout.setText(font,"Press anywhere to start");
        //font.setColor(0.780f,0.956f,0.392f,1);
        font.setColor(0.768f,0.301f,0.345f,1);
        font.draw(game.batch,"Press anywhere to start",game.width/2-glyphLayout.width/2,game.height/2+glyphLayout.height/2);
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        font.dispose();
    }
}
