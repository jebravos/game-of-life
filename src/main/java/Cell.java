public class Cell {

    private static final int ALIVE = 1;
    private static final int DEAD = 0;

    private int state;
    private int numberOfAliveNeighbours;

    private Cell() {
    }

    public Cell(final int state, final int numberOfAliveNeighbours) {
        this.state = state;
        this.numberOfAliveNeighbours = numberOfAliveNeighbours;
    }

    public boolean isAlive() {
        return ALIVE == state;
    }

    public int getNextState() {
        if (isAlive() && numberOfAliveNeighbours < 2) {
            return DEAD;
        }

        return ALIVE;

    }
}