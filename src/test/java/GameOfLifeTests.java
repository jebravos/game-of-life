import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

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
        void cellShouldBeDeadAfterATick() {

            Stream.of(Cell.alive(1),
                            Cell.alive(0))
                    .map(Cell::getNextState)
                    .forEach(state -> assertThat(state).isEqualTo(0));

        }

    }

}
