package co.iyubinest.mystic_square;

public interface Game extends Comparable<Game> {

  public static Game ORDERED = BaseGame.with(new Point(3, 3), new Board());

  enum Movement {
    RIGHT, DOWN, LEFT, UP;

    public static Movement from(int number) {
      for (Movement movement : values()) {
        if (movement.ordinal() == number) {
          return movement;
        }
      }
      throw new IllegalArgumentException("Not valid movement");
    }

  }

  Game move(Game.Movement movement);

  boolean allows(Game.Movement movement);

  double deviation();
}
