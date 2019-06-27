package net.tf.pokemon;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import net.tf.pokemon.screen.GameScreen;

public class PokemonGame extends Game {

    private GameScreen gameScreen;

    @Override
    public void create() {
        gameScreen = new GameScreen(this);
        this.setScreen(gameScreen);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0f,0f,0f,1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        super.render();
    }
}
