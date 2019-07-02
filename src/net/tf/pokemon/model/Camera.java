package net.tf.pokemon.model;

public class Camera {

    private float cameraX;
    private float cameraY;

    public void update(float cameraX, float cameraY) {
        this.cameraX = cameraX;
        this.cameraY = cameraY;
    }

    public float getCameraX() {
        return cameraX;
    }

    public float getCameraY() {
        return cameraY;
    }
}
