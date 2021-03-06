package com.mygdx.gravity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.Input.*;
public class MainMenuScreen extends ScreenAdapter {
	final MainGravity game;
	OrthographicCamera camera;
    	static int w = MainGravity.WIDTH;
    	static int h = MainGravity.HEIGHT;

	public MainMenuScreen(MainGravity game) {
		this.game = game;
		camera = new OrthographicCamera();
		camera.setToOrtho(false, w, h);
	}

	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.font.draw(game.batch, "Welcome to Gravity Jump", (w / 2) - 150, (h / 2) + 100);
        game.tutFont.draw(game.batch, "Move with left/right, flip your gravity with up/down, hit enemies with your foot to kill them.", 
            (w / 2) - 360,
            (h / 2) + 50);
        game.font.draw(game.batch, "CLICK ANYWHERE OR PRESS ENTER TO BEGIN", (w / 2) - 175, h / 2);
        game.batch.end();

        if (Gdx.input.isTouched() || Gdx.input.isKeyPressed(Keys.ENTER)) {
        	game.setScreen(new MainGameScreen(game));
        	dispose();
        }
	}
}
