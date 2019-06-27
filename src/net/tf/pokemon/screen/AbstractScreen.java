package net.tf.pokemon.screen;

import com.badlogic.gdx.Screen;
import net.tf.pokemon.PokemonGame;

public abstract class AbstractScreen implements Screen {

    private PokemonGame pokemonGame;

    public AbstractScreen(PokemonGame pokemonGame) {
        this.pokemonGame = pokemonGame;
    }

    public PokemonGame getPokemonGame() {
        return pokemonGame;
    }
}
