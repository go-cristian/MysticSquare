package co.iyubinest.mystic_square;

enum Tile {
  SPACE,
  ONE,
  TWO,
  THREE,
  FOUR,
  FIVE,
  SIX,
  SEVEN,
  EIGHT,
  NINE,
  TEN,
  ELEVEN,
  TWELVE,
  THIRTEEN,
  FOURTEEN,
  FIFTEEN;

  @Override public String toString() {
    switch (this) {
      case SPACE:
        return "-";
      default:
        return String.valueOf(ordinal());
    }
  }

  int x() {
    switch (this) {
      case SPACE:
        return 3;
      default:
        return ((ordinal() - 1) - (y() * 4));
    }
  }

  int y() {
    switch (this) {
      case SPACE:
        return 3;
      default:
        return (ordinal() - 1) / 4;
    }
  }
}
