import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameOfLifeTests {

    public static final int[][] DEAD_BOARD = {
            {0,0,0},
            {0,0,0},
            {0,0,0}
    };

    @Test
    @DisplayName("A board full of dead cells must remain dead after a tick")
    void deadBoardRemainsDead(){
        // Given
        Board allCellsDeadBoard = new Board(DEAD_BOARD);

        assertThat(allCellsDeadBoard.tick()).isEqualTo(DEAD_BOARD);
    }

}
