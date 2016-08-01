package com.cool.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

public class CoolGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	ShapeRenderer shapeRenderer;
	private OrthographicCamera camera;
    private ExtendViewport extendViewport;
    static final int CELL_SIZE = 100;
    static final int WORLD_WIDTH = 50 * CELL_SIZE;
    static final int WORLD_HEIGHT = 50 * CELL_SIZE;

	@Override
	public void create () {
        batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
        img = new Texture("droplet.png");

        camera = new OrthographicCamera();
        extendViewport = new ExtendViewport(WORLD_WIDTH,WORLD_HEIGHT, camera);
    }

	@Override
	public void resize(int width, int height) {
		extendViewport.update(width, height);
	}

	@Override
	public void render () {
		camera.update();
		batch.setProjectionMatrix(camera.combined);

		Gdx.gl.glClearColor(0.1f, 0.4f, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);

		batch.end();
		shapeRenderer.setProjectionMatrix(camera.combined);
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		shapeRenderer.circle(0f, 0f, CELL_SIZE / 2);
		shapeRenderer.end();

	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		shapeRenderer.dispose();
	}
}
