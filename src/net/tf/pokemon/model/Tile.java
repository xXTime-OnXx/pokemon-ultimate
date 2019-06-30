package net.tf.pokemon.model;

public class Tile {

    private Terrain terrain;
    private Actor actor;

    public Tile(Terrain terrain) {
        this.terrain = terrain;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }
}
