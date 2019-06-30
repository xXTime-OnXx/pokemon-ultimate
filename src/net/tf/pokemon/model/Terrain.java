package net.tf.pokemon.model;

import com.badlogic.gdx.graphics.Texture;

public enum Terrain {

    GRASS1(new Texture("res/graphics_unpacked/tiles/grass1.png")),
    GRASS2(new Texture("res/graphics_unpacked/tiles/grass2.png"));

    public Texture texture;

    private Terrain(Texture texture) {
        this.texture = texture;
    }


}
