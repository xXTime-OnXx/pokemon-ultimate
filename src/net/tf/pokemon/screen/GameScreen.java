package net.tf.pokemon.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import net.tf.pokemon.PokemonGame;
import net.tf.pokemon.controller.ActorController;
import net.tf.pokemon.model.Actor;

public class GameScreen extends AbstractScreen {

    private SpriteBatch spriteBatch;
    private Actor actor;
    private ActorController actorController;

    public GameScreen(PokemonGame pokemonGame) {
        super(pokemonGame);
        this.spriteBatch = new SpriteBatch();
        this.actor = new Actor(0, 0, new Texture("res/graphics_unpacked/tiles/brendan_stand_south.png"));
        this.actorController = new ActorController(actor);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(actorController);
    }

    @Override
    public void render(float delta) {
        spriteBatch.begin();

        actor.draw(spriteBatch);

        spriteBatch.end();
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
