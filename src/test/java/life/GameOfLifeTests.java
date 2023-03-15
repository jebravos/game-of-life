package life;

import org.assertj.core.api.Int2DArrayAssert;
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

            Board allCellsDeadBoard = new Board(DEAD_BOARD);
            assertThat(allCellsDeadBoard.tick()).isEqualTo(DEAD_BOARD);
        }

        @Test
        @DisplayName("A cell without neighbours will die of underpopulation producing a dead board after a tick")
        void returnsDeadBoardWhenOnlyOneCellIsAlive() {

            Board oneAliveBoard = new Board(ONE_ALIVE_BOARD);
            assertThat(oneAliveBoard.tick()).isEqualTo(DEAD_BOARD);
        }
        @Test
        @DisplayName("should produce the expected next state board")
        void shouldProduceTheExpectedNextStateWithMoreComplexSeed1() {

            int[][] seed = {
                    {1, 0, 0},
                    {0, 1, 0},
                    {0, 0, 1}
            };

            int[][] expectedNextState = {
                    {0, 0, 0},
                    {0, 1, 0},
                    {0, 0, 0}
            };

            Board sampleBoard = new Board(seed);
            assertThat(sampleBoard.tick()).isEqualTo(expectedNextState);
        }

        @Test
        @DisplayName("should produce the expected next state board")
        void shouldProduceTheExpectedNextStateWithMoreComplexSeed2() {

            int[][] seed = {
                    {1, 0, 1},
                    {0, 1, 0},
                    {1, 0, 1}
            };

            int[][] expectedNextState = {
                    {0, 1, 0},
                    {1, 0, 1},
                    {0, 1, 0}
            };

            Board sampleBoard = new Board(seed);
            assertThat(sampleBoard.tick()).isEqualTo(expectedNextState);
        }

        @Test
        @DisplayName("should produce the expected next state board")
        void shouldProduceTheExpectedNextStateWithMoreComplexSeed3() {

            int[][] seed = {
                    {1, 0, 1},
                    {1, 0, 0},
                    {0, 1, 1}
            };

            int[][] expectedNextState = {
                    {0, 1, 0},
                    {1, 0, 1},
                    {0, 1, 0}
            };

            Board sampleBoard = new Board(seed);
            assertThat(sampleBoard.tick()).isEqualTo(expectedNextState);
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
                    .forEach(nextState -> assertThat(nextState).isEqualTo(DEAD));
        }

        @DisplayName("Any live cell with two or three live neighbours lives on to the next generation")
        @Test
        void liveCellsWithTwoOrThreeLiveNeighboursWillSurvive() {
            Stream.of(alive(2),
                            alive(3))
                    .map(Cell::getNextState)
                    .forEach(state -> assertThat(state).isEqualTo(ALIVE));
        }


        @DisplayName("Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction")
        @Test
        void deadCellsWithThreeLiveNeighboursWillBecomeAlive() {
            assertThat(dead(3).getNextState()).isEqualTo(ALIVE);
        }
    }

}
