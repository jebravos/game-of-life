import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameOfLifeTests {

    public static final int[][] DEAD_BOARD = {
            {0,0,0},
            {0,0,0},
            {0,0,0}
    };
    public static final int[][] ONE_ALIVE = {
            {0,0,0},
            {0,1,0},
            {0,0,0}
    };

    @Test
    @DisplayName("A board full of dead cells must remain dead after a tick")
    void returnsDeadBoardWhenAllCellsAreDead(){
        // Given
        Board allCellsDeadBoard = new Board(DEAD_BOARD);

        assertThat(allCellsDeadBoard.tick()).isEqualTo(DEAD_BOARD);
    }

    @Test
    @DisplayName("A cell without neighbours will die of underpopulation producing a dead board after a tick")
    void returnsDeadBoardWhenOnlyOneCellIsAlive(){
        // Given
        Board oneAliveBoard = new Board(ONE_ALIVE);

        assertThat(oneAliveBoard.tick()).isEqualTo(DEAD_BOARD);
    }

}
