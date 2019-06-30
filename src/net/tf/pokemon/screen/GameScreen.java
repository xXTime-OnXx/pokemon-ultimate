package net.tf.pokemon.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import net.tf.pokemon.PokemonGame;
import net.tf.pokemon.controller.ActorController;
import net.tf.pokemon.model.Actor;
import net.tf.pokemon.model.TileMap;

public class GameScreen extends AbstractScreen {

    private SpriteBatch spriteBatch;
    private TileMap tileMap;
    private Actor actor;
    private ActorController actorController;

    public GameScreen(PokemonGame pokemonGame) {
        super(pokemonGame);
        this.spriteBatch = new SpriteBatch();
        this.tileMap = new TileMap(10, 10);
        this.actor = new Actor(0, 0, new Texture("res/graphics_unpacked/tiles/brendan_stand_south.png"), tileMap);
        this.actorController = new ActorController(actor);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(actorController);
    }

    @Override
    public void render(float delta) {
        spriteBatch.begin();

        tileMap.draw(spriteBatch);
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
