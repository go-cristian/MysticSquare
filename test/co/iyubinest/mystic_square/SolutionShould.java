package co.iyubinest.mystic_square;

import org.junit.Test;

import static co.iyubinest.mystic_square.Game.Movement.LEFT;
import static co.iyubinest.mystic_square.Game.Movement.UP;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

public class SolutionShould {

  @Test public void solveIdentity() {
    Solution solution = Solution.of(BaseGame.BASE);
    String string = "{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,-}";
    assertThat(solution.result().toString(), is(string));
  }

  @Test public void solveOneMovement() {
    BaseGame unsolved = BaseGame.BASE.move(LEFT);
    Solution solution = Solution.of(unsolved);
    String origin = "{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,-,15}";
    String result = "{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,-}";
    assertThat(solution.origin().toString(), is(origin));
    assertThat(solution.result().toString(), is(result));
  }

  @Test public void findSolutionWithOneMovement() {
    BaseGame game = BaseGame.BASE.move(LEFT);
    assertThat(game, not(BaseGame.BASE));
    assertThat(Solution.of(game).result(), is(BaseGame.BASE));
  }

  @Test public void findSolutionWithTwoMovement() {
    BaseGame game = BaseGame.BASE.move(LEFT).move(UP);
    assertThat(Solution.of(game).result(), is(BaseGame.BASE));
  }

  @Test public void findSolutionWith2RandomMovements() {
    Game game = new RandomGame(2);
    assertThat(Solution.of(game).result(), is(BaseGame.BASE));
  }

  @Test public void findSolutionWith10RandomMovements() {
    Game game = new RandomGame(10);
    assertThat(Solution.of(game).result(), is(BaseGame.BASE));
  }

  @Test public void findSolutionWith100RandomMovements() {
    Game game = new RandomGame(100);
    assertThat(Solution.of(game).result(), is(BaseGame.BASE));
  }

  @Test public void findSolutionWith1000RandomMovements() {
    Game game = new RandomGame(1000);
    assertThat(Solution.of(game).result(), is(BaseGame.BASE));
  }

  @Test public void findSolutionWith10000RandomMovements() {
    Game game = new RandomGame(10000);
    assertThat(Solution.of(game).result(), is(BaseGame.BASE));
  }
}
