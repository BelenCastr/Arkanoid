package Objects;

import Engine.Game;
import Engine.InputHandler;

public class MobileBrick extends Brick {

    private float speed;

    public MobileBrick(float x, float y, int width, int height) {
        super(x, y, width, height);
    }

    public MobileBrick(float x, float y, int width, int height, boolean special) {
        super(x, y, width, height, special);
    }

    @Override
    public void update(float delta) {
        InputHandler input = Game.getInput();
        if (input.left) {
            this.x -= speed * delta;
        }
        if (input.right) {
            this.x += speed * delta;
        }

    }
}

