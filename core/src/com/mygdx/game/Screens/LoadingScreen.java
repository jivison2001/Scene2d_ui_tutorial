package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.mygdx.game.Main;

public class LoadingScreen implements Screen {

    private final Main app;
    private ShapeRenderer shapeRenderer;
    private float progress;


    public LoadingScreen(final Main app){
        this.app = app;
        this.shapeRenderer = new ShapeRenderer();
        queueAssets();
    }

    private void queueAssets() {
        //loads image as a texture class to assets
        app.assets.load("image.png", Texture.class);
        app.assets.load("badlogic.jpg", Texture.class);
        app.assets.load("ui/uiskin.atlas", TextureAtlas.class);
    }

    @Override
    public void show() {
        this.progress = 0f;
        queueAssets();
        System.out.println("LOADING");
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(.25f,.25f,.25f,1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        update(delta);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.BLACK);
        shapeRenderer.rect(32,app.camera.viewportWidth / 2 - 8,
                400, 16);
        shapeRenderer.setColor(Color.BLUE);
        shapeRenderer.rect(32,app.camera.viewportWidth / 2 - 8,
                progress*400, 16);
        shapeRenderer.end();


        app.batch.begin();
        app.font.draw(app.batch, "Screen: LOADING", 20, 20);
        app.batch.end();
    }

    private void update(float delta) {
        progress = MathUtils.lerp(progress,app.assets.getProgress(),0.1f);
        //keeps returning false until all the assets have finished loading
        if(app.assets.update() && progress > 0.9999f){
            app.setScreen(app.splashScreen);
        }
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
        shapeRenderer.dispose();
    }
}
