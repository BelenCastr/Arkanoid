package Game;

import Engine.Game;
import Scenes.Pantalla1;

public class MainArkanoid {
    public static void main(String[] args) {
        Game game = new Game(Config.GAME_WIDTH, Config.GAME_HEIGHT, "Arkanoid");
        game.setScene(new Pantalla1(game));
        game.start();
    }
}