package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.Main;

public class MainMenuScreen implements Screen {

    private final Main app;
    private Stage stage;
    private TextButton buttonPlay, buttonExit;

    private Skin skin;
    private ShapeRenderer shapeRenderer;


    public MainMenuScreen(final Main app){
        this.app = app;
        this.stage = new Stage(new StretchViewport(Main.V_WIDTH, Main.V_WIDTH, app.camera));
        this.shapeRenderer = new ShapeRenderer();
        this.skin = new Skin();
    }

    @Override
    public void show() {
        System.out.println("MAIN MENU");
        Gdx.input.setInputProcessor(stage);

        this.skin.addRegions(app.assets.get("ui/uiskin.atlas", TextureAtlas.class));
        this.skin.add("default-font", app.font);
        this.skin.load(Gdx.files.internal("ui/uiskin.json"));

        initButtons();
    }

    private void initButtons() {
        buttonPlay = new TextButton("Play", skin, "default");
        buttonPlay.setPosition(110,260);
        buttonPlay.setSize(280,60);
        buttonPlay.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                app.setScreen(new LoadingScreen(app));
            }
        });
        buttonExit = new TextButton("Exit", skin, "default");
        buttonExit.setPosition(110,190);
        buttonExit.setSize(280,60);
        buttonExit.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                Gdx.app.exit();
            }
        });
        stage.addActor(buttonPlay);
        stage.addActor(buttonExit);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(.25f,.25f,.25f,1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        update(delta);

        app.batch.begin();
        app.font.draw(app.batch, "Screen: MAIN MENU", 20, 20);
        app.batch.end();
    }

    private void update(float delta) {
        stage.act();
        stage.draw();
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

    }

}
