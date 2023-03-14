public class Cell {

    public static final int ALIVE = 1;
    public static final int DEAD = 0;

    private int state;
    private int numberOfAliveNeighbours;

    private Cell() {
    }

    public Cell(final int state, final int numberOfAliveNeighbours) {
        this.state = state;
        this.numberOfAliveNeighbours = numberOfAliveNeighbours;
    }

    public static Cell alive(int numberOfAliveNeighbours) {
        return new Cell(ALIVE, numberOfAliveNeighbours);
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
