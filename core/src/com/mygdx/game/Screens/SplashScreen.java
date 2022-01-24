package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.game.Main;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

public class SplashScreen implements Screen {
    private final Main app;
    private Stage stage;

    private Image splashImg;

    private TextureAtlas atlas;
    private Skin skin;

    //called once
    public SplashScreen(final Main app){
        this.app = app;
        this.stage = new Stage(new FitViewport(Main.V_WIDTH,Main.V_HEIGHT,app.camera));
        Gdx.input.setInputProcessor(stage);

        Texture splashTex = new Texture(Gdx.files.internal("image.png"));
        splashImg = new Image(splashTex);

        splashImg.setPosition(stage.getWidth()/2 - 32,stage.getHeight()/2 - 32);
        splashImg.setOrigin(stage.getWidth()/2 - 32,stage.getHeight()/2 - 32);
        stage.addActor(splashImg);

    }

    //called whenever the game sets the screen to this object
    //called once every time
    @Override
    public void show() {
        System.out.println("Show");

        splashImg.setPosition(stage.getWidth() / 2 - 32, stage.getHeight() / 2 - 32);

        //this one line does what the two lines below does
        //splashImg.addAction(sequence(alpha(0.0f), fadeIn(1.0f)));
        /*
        splashImg.addAction(alpha(0f));
        splashImg.addAction(fadeIn(1.0f));
         */
        splashImg.addAction(sequence(alpha(0), scaleTo(0.1f,0.1f),
                parallel(fadeIn(2f, Interpolation.pow5),
                        scaleTo(2f,2f,2.5f, Interpolation.pow5),
                        moveTo(stage.getWidth()-64, stage.getHeight()-64,2f,Interpolation.swing)),
                delay(0.4f), fadeOut(0.5f)));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(.25f,.25f,.25f,1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();
        stage.draw();

        app.batch.begin();
        app.font.draw(app.batch, "Splashscreen!",120,120);
        app.batch.end();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width,height,false);
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
        stage.dispose();
    }
}
