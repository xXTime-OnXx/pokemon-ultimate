package net.tf.pokemon.model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import net.tf.pokemon.Settings;

public class TileMap {

    private int width;
    private int height;

    private Tile[][] tiles;

    public TileMap(int width, int height) {
        this.width = width;
        this.height = height;
        tiles = new Tile[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (Math.random() > 0.5d) {
                    tiles[x][y] = new Tile(Terrain.GRASS1);
                } else {
                    tiles[x][y] = new Tile(Terrain.GRASS2);
                }
            }
        }
    }

    public Tile getTile(int x, int y) {
        return tiles[x][y];
    }

    public void draw(SpriteBatch spriteBatch) {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Tile tile = tiles[x][y];
                spriteBatch.draw(tile.getTerrain().texture,
                        Settings.WORLD_START_X + x * Settings.SCALED_TILE_SIZE,
                        Settings.WORLD_START_Y + y * Settings.SCALED_TILE_SIZE,
                        Settings.SCALED_TILE_SIZE,
                        Settings.SCALED_TILE_SIZE);
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
