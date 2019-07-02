package net.tf.pokemon.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Interpolation;
import net.tf.pokemon.Settings;

public class Actor {

    private int x;
    private int y;
    private Texture texture;
    private TileMap tileMap;
    private ActorState actorState;

    private float worldX, worldY;

    private int srcX, srcY;
    private int destX, destY;

    private float animTimer;
    private float ANIM_TIME = 0.5f;

    public Actor(int x, int y, Texture texture, TileMap tileMap) {
        this.x = x;
        this.y = y;
        this.worldX = x;
        this.worldY = y;
        this.texture = texture;
        this.tileMap = tileMap;
        tileMap.getTile(x, y).setActor(this);
        this.actorState = ActorState.STANDING;
    }

    public void draw(SpriteBatch spriteBatch) {
        spriteBatch.draw(texture,
                Settings.WORLD_START_X + worldX * Settings.SCALED_TILE_SIZE,
                Settings.WORLD_START_Y + worldY * Settings.SCALED_TILE_SIZE,
                Settings.SCALED_ACTOR_WIDTH,
                Settings.SCALED_ACTOR_HEIGHT);
    }

    public boolean move(int dx, int dy) {
        int newX = x + dx;
        int newY = y + dy;
        if (actorState != ActorState.STANDING) {
            return false;
        }
        if (newX >= tileMap.getWidth() || newX < 0 || newY >= tileMap.getHeight() || newY < 0) {
            return false;
        }
        if (tileMap.getTile(newX, newY).getActor() != null) {
            return false;
        }
        initializeAnimation(x, y, dx, dy);
        tileMap.getTile(x, y).setActor(null);
        this.x = newX;
        this.y = newY;
        tileMap.getTile(x, y).setActor(this);

        return true;
    }

    public void update(float delta) {
        if (actorState == ActorState.WALKING) {
            animTimer += delta;
            worldX = Interpolation.linear.apply(srcX, destX, animTimer / ANIM_TIME);
            worldY = Interpolation.linear.apply(srcY, destY, animTimer / ANIM_TIME);
            if (animTimer > ANIM_TIME) {
                finishAnimation();
            }
        }
    }

    public void initializeAnimation(int oldX, int oldY, int dx, int dy) {
        this.srcX = oldX;
        this.srcY = oldY;
        this.destX = oldX + dx;
        this.destY = oldY + dy;
        this.worldX = oldX;
        this.worldY = oldY;
        animTimer = 0f;
        actorState = ActorState.WALKING;
    }

    public void finishAnimation() {
        actorState = ActorState.STANDING;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public float getWorldX() {
        return worldX;
    }

    public float getWorldY() {
        return worldY;
    }

    public enum ActorState {
        WALKING,
        STANDING
    }
}
