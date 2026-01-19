package Objects;

import Engine.Collidable;
import Engine.GameObject;
import Game.Config;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Brick extends GameObject implements Collidable {

    private boolean destroyed = false;
    private final boolean special;

    // Constructor normal (ladrillo normal)
    public Brick(float x, float y, int width, int height) {
        this(x, y, width, height, false);
    }

    // Constructor con “special” (para la modificación de color y puntos dobles)
    public Brick(float x, float y, int width, int height, boolean special) {
        super(x, y, width, height);
        this.special = special;
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, width, height);
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void destroy() {
        destroyed = true;
    }

    public boolean isSpecial() {
        return special;
    }

    @Override
    public void onCollision(GameObject other) {
        // Lo dejaremos vacío si la colisión la gestionas desde Pantalla1.
        // Si tu motor llama automáticamente a onCollision, aquí podrías marcar destroy()
        // pero solo si "other" es Ball (lo hacemos luego si quieres).
    }

    @Override
    public void update(float delta) {
        // Ladrillo estático (no necesita update)
    }

    @Override
    public void render(Graphics2D g) {
        if (destroyed) return;

        // Color distinto para ladrillos especiales
        if (special) {
            g.setColor(Config.BRICK_SPECIAL_COLOR); // añade esta constante en Config
        } else {
            g.setColor(Config.BRICK_COLOR);
        }

        g.fillRect((int) x, (int) y, width, height);
    }
}
