package co.iyubinest.mystic_square;

import java.util.Objects;

final class Point {
  private final int x;
  private final int y;

  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  int x() {
    return x;
  }

  int y() {
    return y;
  }

  @Override public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Point point = (Point) o;
    return x == point.x &&
        y == point.y;
  }

  @Override public int hashCode() {
    return Objects.hash(x, y);
  }

  @Override public String toString() {
    return "Point{" +
        "x=" + x +
        ", y=" + y +
        '}';
  }
}
