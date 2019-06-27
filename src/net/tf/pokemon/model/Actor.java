package net.tf.pokemon.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import net.tf.pokemon.Settings;

public class Actor {

    private int x;
    private int y;
    private Texture texture;

    public Actor(int x, int y, Texture texture) {
        this.x = x;
        this.y = y;
        this.texture = texture;
    }

    public void draw(SpriteBatch spriteBatch) {
        spriteBatch.draw(texture,
                x * Settings.SCALED_TILE_SIZE,
                y * Settings.SCALED_TILE_SIZE,
                Settings.SCALED_ACTOR_WIDTH,
                Settings.SCALED_ACTOR_HEIGHT);
    }

    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

}
