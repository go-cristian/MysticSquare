package co.iyubinest.mystic_square;

import java.util.Objects;

final class BaseGame implements Game {

  static final BaseGame BASE = BaseGame.with(new Point(3, 3), new Board());

  private final Point center;

  private final Board board;

  static BaseGame with(Point center, Board board) {
    return new BaseGame(center, board);
  }

  private BaseGame(Point center, Board board) {
    this.center = center;
    this.board = board;
  }

  @Override public BaseGame move(Movement movement) {
    if (supports(movement)) {
      Point from = center;
      Point to = pointToMove(center, movement);
      Board swapped = board.swap(from, to);
      return new BaseGame(to, swapped);
    } else {
      return new BaseGame(center, board);
    }
  }

  @Override public boolean supports(Movement movement) {
    switch (movement) {
      case UP:
        return supports(center.x(), center.y() - 1);
      case RIGHT:
        return supports(center.x() + 1, center.y());
      case DOWN:
        return supports(center.x(), center.y() + 1);
      case LEFT:
        return supports(center.x() - 1, center.y());
      default:
        throw new IllegalArgumentException("not a valid movement");
    }
  }

  @Override public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    BaseGame game = (BaseGame) o;
    return Objects.equals(center, game.center) &&
        Objects.equals(board, game.board);
  }

  @Override public int hashCode() {
    return Objects.hash(center, board);
  }

  @Override public String toString() {
    return board.toString();
  }

  @Override public int compareTo(Game that) {
    return (int) (deviation() - that.deviation());
  }

  @Override public double deviation() {
    return board.deviation();
  }

  private boolean supports(int x, int y) {
    return x > 0 && y > 0 && x < 4 && y < 4;
  }

  private Point pointToMove(Point center, Movement movement) {
    switch (movement) {
      case UP:
        return new Point(center.x(), center.y() - 1);
      case RIGHT:
        return new Point(center.x() + 1, center.y());
      case DOWN:
        return new Point(center.x(), center.y() + 1);
      case LEFT:
        return new Point(center.x() - 1, center.y());
      default:
        throw new IllegalArgumentException("not a valid movement");
    }
  }
}
