public class Board {

    private int[][] cells;

    public Board(final int[][] cells) {
        this.cells = cells;
    }

    public int[][] tick() {
        return new int[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
    }

}
