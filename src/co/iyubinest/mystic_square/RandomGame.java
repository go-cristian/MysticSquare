package co.iyubinest.mystic_square;

import java.util.Random;

final class RandomGame implements Game {

  private final Game game;
  private final int iterations;

  RandomGame(int iterations) {
    this.iterations = iterations;
    this.game = random(BaseGame.BASE);
  }

  @Override public BaseGame move(BaseGame.Movement movement) {
    return game.move(movement);
  }

  @Override public boolean supports(BaseGame.Movement movement) {
    return game.supports(movement);
  }

  @Override public int compareTo(Game o) {
    return game.compareTo(o);
  }

  @Override public double deviation() {
    return game.deviation();
  }

  private Game random(BaseGame base) {
    Game random = base;
    Random generator = new Random();
    for (int index = 0; index < iterations; index++) {
      int number = generator.nextInt(BaseGame.Movement.values().length);
      BaseGame.Movement movement = BaseGame.Movement.from(number);
      random = random.move(movement);
    }
    return random;
  }
}
