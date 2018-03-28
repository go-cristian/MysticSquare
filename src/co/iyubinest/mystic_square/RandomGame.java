package co.iyubinest.mystic_square;

import co.iyubinest.mystic_square.game.Game;
import java.util.Random;

final class RandomGame implements Game {

  private final Game game;
  private final int iterations;

  RandomGame(int iterations) {
    this.iterations = iterations;
    this.game = random(Game.ORDERED);
  }

  @Override public Game move(Game.Movement movement) {
    return game.move(movement);
  }

  @Override public boolean supports(Game.Movement movement) {
    return game.supports(movement);
  }

  @Override public int compareTo(Game o) {
    return game.compareTo(o);
  }

  @Override public double deviation() {
    return game.deviation();
  }

  private Game random(Game base) {
    Game random = base;
    Random generator = new Random();
    for (int index = 0; index < iterations; index++) {
      int number = generator.nextInt(Game.Movement.values().length);
      Game.Movement movement = Game.Movement.from(number);
      random = random.move(movement);
    }
    return random;
  }
}
