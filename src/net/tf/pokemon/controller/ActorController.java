package net.tf.pokemon.controller;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import net.tf.pokemon.model.Actor;

public class ActorController extends InputAdapter {

    private Actor actor;

    public ActorController(Actor actor) {
        this.actor = actor;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Keys.UP) {
            actor.move(0, 1);
        }
        if (keycode == Keys.DOWN) {
            actor.move(0, -1);
        }
        if (keycode == Keys.LEFT) {
            actor.move(-1, 0);
        }
        if (keycode == Keys.RIGHT) {
            actor.move(1, 0);
        }

        return false;
    }
}
