package co.iyubinest.mystic_square;

interface Game extends Comparable<Game> {

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
  BaseGame move(BaseGame.Movement movement);

  boolean supports(BaseGame.Movement movement);

  double deviation();
}
