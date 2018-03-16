package co.iyubinest.mystic_square;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

final class Board {

  static final Board ORDERED = new Board();

  private final Map<Point, Tile> map;

  Board() {
    this(defaultMap());
  }

  Board(Map<Point, Tile> map) {
    this.map = map;
  }

  Collection<Point> all() {
    return map.keySet();
  }

  Tile on(Point point) {
    return map.get(point);
  }

  void add(Point point, Tile tile) {
    map.put(point, tile);
  }

  @Override public String toString() {
    StringBuilder builder = new StringBuilder();
    for (Point point : map.keySet()) {
      if (point.x() == 0) {
        builder.append("{");
        builder.append(map.get(point).toString());
        builder.append(",");
      } else if (point.x() == 3) {
        builder.append(map.get(point).toString());
        builder.append("},");
      } else {
        builder.append(map.get(point).toString());
        builder.append(",");
      }
    }
    builder.delete(builder.length() - 1, builder.length());
    return builder.toString();
  }

  Board swap(Point from, Point to) {
    Map<Point, Tile> map = new LinkedHashMap<>(this.map);
    Tile fromTile = map.get(from);
    Tile toTile = map.get(to);
    map.put(from, toTile);
    map.put(to, fromTile);
    return new Board(map);
  }

  double deviation() {
    double deviation = 0;
    for (Point point : map.keySet()) {
      Tile original = ORDERED.map.get(point);
      Tile current = map.get(point);
      int x1 = current.x();
      int y1 = current.y();
      int x2 = original.x();
      int y2 = original.y();
      deviation += Math.sqrt((Math.pow(x2 - x1, 2)) + (Math.pow(y2 - y1, 2)));
    }
    return deviation;
  }

  private static Map<Point, Tile> defaultMap() {
    Map<Point, Tile> map = new LinkedHashMap<>();
    map.put(new Point(0, 0), Tile.ONE);
    map.put(new Point(1, 0), Tile.TWO);
    map.put(new Point(2, 0), Tile.THREE);
    map.put(new Point(3, 0), Tile.FOUR);
    map.put(new Point(0, 1), Tile.FIVE);
    map.put(new Point(1, 1), Tile.SIX);
    map.put(new Point(2, 1), Tile.SEVEN);
    map.put(new Point(3, 1), Tile.EIGHT);
    map.put(new Point(0, 2), Tile.NINE);
    map.put(new Point(1, 2), Tile.TEN);
    map.put(new Point(2, 2), Tile.ELEVEN);
    map.put(new Point(3, 2), Tile.TWELVE);
    map.put(new Point(0, 3), Tile.THIRTEEN);
    map.put(new Point(1, 3), Tile.FOURTEEN);
    map.put(new Point(2, 3), Tile.FIFTEEN);
    map.put(new Point(3, 3), Tile.SPACE);
    return map;
  }

  @Override public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Board board = (Board) o;
    return Objects.equals(map, board.map);
  }

  @Override public int hashCode() {
    return Objects.hash(map);
  }
}
