package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Screens.LoadingScreen;
import com.mygdx.game.Screens.MainMenuScreen;
import com.mygdx.game.Screens.SplashScreen;

public class Main extends Game {
	public static final String TITLE = "Slide2";
	public static final float VERSION = 0.1f;
	public static final int V_WIDTH = 480;
	public static final int V_HEIGHT = 420;

	public OrthographicCamera camera;
	public SpriteBatch batch;

	public BitmapFont font;

	public AssetManager assets;

	public LoadingScreen loadingScreen;
	public SplashScreen splashScreen;
	public MainMenuScreen mainMenuScreen;

	@Override
	public void create () {
		assets = new AssetManager();
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 480,720);
		font = new BitmapFont();
		font.setColor(Color.BLACK);

		loadingScreen = new LoadingScreen(this);
		splashScreen = new SplashScreen(this);
		mainMenuScreen = new MainMenuScreen(this);

		this.setScreen(loadingScreen);
	}

	@Override
	public void render () {
		//calls render method of the screen
		super.render();
	}
	
	@Override
	public void dispose () {
		font.dispose();
		batch.dispose();
		assets.dispose();
		this.getScreen().dispose();
	}
}
