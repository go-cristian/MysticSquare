package co.iyubinest.mystic_square;

import co.iyubinest.mystic_square.Game.Movement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

import static co.iyubinest.mystic_square.Game.Movement.DOWN;
import static co.iyubinest.mystic_square.Game.Movement.LEFT;
import static co.iyubinest.mystic_square.Game.Movement.RIGHT;
import static co.iyubinest.mystic_square.Game.Movement.UP;

final class Solution {

  static Solution of(Game game) {
    return new Solution(game);
  }

  private final Game game;

  private Solution(Game game) {
    this.game = game;
  }

  Game origin() {
    return game;
  }

  Game result() {
    PriorityQueue<Game> queue = new PriorityQueue<>(10, new GameComparator());
    Set<Game> discarted = new HashSet<>();
    queue.add(game);
    while (!queue.isEmpty()) {
      Game current = queue.poll();
      if (current.equals(Game.ORDERED)) {
        return current;
      } else if (!discarted.contains(current)) {
        Collection<Game> games = allMoves(current);
        queue.addAll(games);
        discarted.add(current);
      }
    }
    throw new IllegalArgumentException("No solutions found");
  }

  private Collection<Game> allMoves(Game current) {
    Collection<Game> games = new ArrayList<>(4);
    add(games, current, UP);
    add(games, current, RIGHT);
    add(games, current, DOWN);
    add(games, current, LEFT);
    return games;
  }

  private void add(Collection<Game> games, Game game, Movement movement) {
    if (game.allows(movement)) {
      games.add(game.move(movement));
    }
  }

  private class GameComparator implements Comparator<Game> {
    @Override public int compare(Game o1, Game o2) {
      return o1.compareTo(o2);
    }
  }
}
