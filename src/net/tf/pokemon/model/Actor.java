package net.tf.pokemon.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import net.tf.pokemon.Settings;

public class Actor {

    private int x;
    private int y;
    private Texture texture;
    private TileMap tileMap;

    public Actor(int x, int y, Texture texture, TileMap tileMap) {
        this.x = x;
        this.y = y;
        this.texture = texture;
        this.tileMap = tileMap;
        tileMap.getTile(x, y).setActor(this);
    }

    public void draw(SpriteBatch spriteBatch) {
        spriteBatch.draw(texture,
                x * Settings.SCALED_TILE_SIZE,
                y * Settings.SCALED_TILE_SIZE,
                Settings.SCALED_ACTOR_WIDTH,
                Settings.SCALED_ACTOR_HEIGHT);
    }

    public boolean move(int dx, int dy) {
        int newX = x + dx;
        int newY = y + dy;
        if (newX >= tileMap.getWidth() || newX < 0 || newY >= tileMap.getHeight() || newY < 0) {
            return false;
        }
        if (tileMap.getTile(newX, newY).getActor() != null) {
            return false;
        }
        tileMap.getTile(x, y).setActor(null);
        this.x = newX;
        this.y = newY;
        tileMap.getTile(x, y).setActor(this);

        return true;
    }
}
