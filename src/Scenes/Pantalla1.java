package Scenes;

import Engine.Game;
import Engine.GameObject;
import Engine.Scene;
import Objects.*;
import Game.Config;

import java.awt.*;

public class Pantalla1 extends Scene {

    private Player player;

    public Pantalla1(Game game) {
        super(game);

        player = new Player(
                Config.GAME_WIDTH / 2f - Config.PLAYER_WIDTH / 2f,
                Config.GAME_HEIGHT - Config.PLAYER_Y_OFFSET,
                Config.PLAYER_WIDTH,
                Config.PLAYER_HEIGHT
        );
        this.addObject(player);

        Ball ball = new Ball(
                Config.GAME_WIDTH / 2f - Config.BALL_RADIUS / 2f,
                Config.GAME_HEIGHT / 2f + Config.BALL_Y_OFFSET,
                Config.BALL_RADIUS,
                player
        );
        this.addObject(ball);

        this.addObject(new DeadLine());

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                this.addObject(new Brick(
                        25 + (Config.BRICK_WIDTH + Config.BRICK_GAP_X) * i,
                        50 + (Config.BRICK_HEIGHT + Config.BRICK_GAP_Y) * j,
                        Config.BRICK_WIDTH,
                        Config.BRICK_HEIGHT
                ));
            }
        }

    }


    @Override
    public void render(Graphics2D g) {
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, Config.GAME_WIDTH, Config.GAME_HEIGHT);

        int y = Config.GAME_HEIGHT - Config.DEADLINE_HEIGHT;
        g.setColor(Color.RED);
        g.fillRect(0, y, Config.GAME_WIDTH, Config.DEADLINE_HEIGHT);

        super.render(g);
    }
}


