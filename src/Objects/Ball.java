package Objects;

import Engine.Collidable;
import Engine.GameObject;
import Game.Config;
import java.awt.Rectangle;

import java.awt.*;

public class Ball extends GameObject implements Collidable {

    private int radius;
    private final Player player;


    /**
     * Constructor base para un objeto de juego.
     *
     * @param x      Posición inicial en el eje X.
     * @param y      Posición inicial en el eje Y.
     * @param radius Radio de la pelota.
     */
    public Ball(float x, float y, int radius, Player player) {
        super(x, y, radius, radius);
        this.radius = radius;
        this.player = player;
        speedX = speedY = 2;
    }
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, width, height);
    }


    @Override
    public void update(float delta) {
        if (x > Config.GAME_WIDTH - radius || x < 0) {
            speedX = -speedX;
        }
        if (y > Config.GAME_HEIGHT - radius || y < 0) {
            speedY = -speedY;
        }
        x += speedX * delta;
        y += speedY * delta;
    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(Config.BALL_COLOR);
        g.fillOval((int) x, (int) y, radius, radius);
        if (Config.DEBUG) {
            g.setColor(Config.DEBUG_COLOR);
            g.drawRect((int) x, (int) y, width, height);
        }
    }

    @Override
    public void onCollision(GameObject other) {

        // Colisión con el Player (ya la tenías, pero la dejamos clara)
        if (other instanceof Player) {
            y = other.getBounds().y - height;
            speedY = -Math.abs(speedY);
            return;
        }

        // Colisión con un Brick
        if (other instanceof Brick brick) {

            // Si ya está destruido, no hacemos nada
            if (brick.isDestroyed()) return;

            // Destruir ladrillo
            brick.destroy();

            // Rebote simple (vertical)
            speedY *= -1;
        }
    }

}