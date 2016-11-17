package com.dream.snake;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game extends com.badlogic.gdx.Game {
	public int width;
	public int height;
	public float density;
	public boolean backpressed;
	public boolean gameover;
	public OrthographicCamera camera;
	public SpriteBatch batch;

	@Override
	public void create () {
		width = Gdx.graphics.getWidth();
		height = Gdx.graphics.getHeight();
		density = Gdx.graphics.getWidth()/width;
		backpressed = false;
		gameover = false;
		camera = new OrthographicCamera();
		camera.setToOrtho(false,width,height);
		batch = new SpriteBatch();
		Gdx.input.setCatchBackKey(true);
		this.setScreen(new MenuScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}

	@Override
	public void pause(){
		this.getScreen().pause();
	}

	@Override
	public void resume(){
		this.getScreen().resume();
	}

	@Override
	public void dispose () {
		batch.dispose();
		this.getScreen().dispose();
	}
}
