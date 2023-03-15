package life;

import java.util.stream.IntStream;

public class Board {

    private final int[][] board;

    public Board(final int[][] seed) {
        this.board = seed;
    }

    public int[][] tick() {

        int[][] nextState = newEmptyBoard();

        for (int rowIndex = 0; rowIndex < this.board.length; rowIndex++) {
            final int[] row = this.board[rowIndex];
            for (int columnIndex = 0, rowLength = row.length; columnIndex < rowLength; columnIndex++) {

                final long livingNeighbours = countAliveNeighbours(rowIndex, columnIndex);
                final Cell cell = new Cell(this.board[rowIndex][columnIndex], livingNeighbours);
                nextState[rowIndex][columnIndex] = cell.getNextState();

            }
        }

        return nextState;
    }

    private long countAliveNeighbours(final int rowIndex, final int columnIndex) {
        return IntStream.of(
                        getCellState(rowIndex - 1, columnIndex - 1),
                        getCellState(rowIndex - 1, columnIndex),
                        getCellState(rowIndex - 1, columnIndex + 1),
                        getCellState(rowIndex, columnIndex - 1),
                        getCellState(rowIndex, columnIndex + 1),
                        getCellState(rowIndex + 1, columnIndex - 1),
                        getCellState(rowIndex + 1, columnIndex),
                        getCellState(rowIndex + 1, columnIndex + 1)
                ).filter(state -> state != Cell.DEAD)
                .count();
    }

    private int[][] newEmptyBoard() {
        return new int[this.board.length][this.board[0].length];
    }

    public int getCellState(int rowIndex, int columnIndex) {
        try {
            return this.board[rowIndex][columnIndex];
        } catch (IndexOutOfBoundsException e) {
            return Cell.DEAD;
        }
    }

}
