package life;

import life.Board;
import life.Cell;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static life.Cell.*;
import static org.assertj.core.api.Assertions.assertThat;

class GameOfLifeTests {

    public static final int[][] DEAD_BOARD = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
    };
    public static final int[][] ONE_ALIVE_BOARD = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
    };

    @Nested
    class BoardTests {
        @Test
        @DisplayName("A board full of dead cells must remain dead after a tick")
        void returnsDeadBoardWhenAllCellsAreDead() {
            // Given
            Board allCellsDeadBoard = new Board(DEAD_BOARD);

            assertThat(allCellsDeadBoard.tick()).isEqualTo(DEAD_BOARD);
        }

        @Test
        @DisplayName("A cell without neighbours will die of underpopulation producing a dead board after a tick")
        void returnsDeadBoardWhenOnlyOneCellIsAlive() {
            // Given
            Board oneAliveBoard = new Board(ONE_ALIVE_BOARD);

            assertThat(oneAliveBoard.tick()).isEqualTo(DEAD_BOARD);
        }
    }

    @Nested
    class CellTests {

        @DisplayName("Any live cell with fewer than two live neighbours dies, as if by underpopulation")
        @Test
        void liveCellShouldBeDeadAfterATickByUnderpopulation() {

            Stream.of(alive(1),
                            alive(0))
                    .map(Cell::getNextState)
                    .forEach(state -> assertThat(state).isEqualTo(DEAD));

        }


        @DisplayName("Any live cell with more than three live neighbours dies, as if by overpopulation")
        @Test
        void liveCellsWithMoreThanThreeLiveNeighboursWillDie() {
            Stream.of(alive(4),
                            alive(5),
                            alive(6),
                            alive(7),
                            alive(8))
                    .map(Cell::getNextState)
                    .forEach(state -> assertThat(state).isEqualTo(DEAD));
        }

    }

}
