package life;

public class Cell {

    public static final int ALIVE = 1;
    public static final int DEAD = 0;

    private int state;
    private long numberOfAliveNeighbours;

    private Cell() {
    }

    public Cell(final int state, final long numberOfAliveNeighbours) {

        if (state == 0) {
            this.state = DEAD;
        } else {
            this.state = ALIVE;
        }

        this.numberOfAliveNeighbours = numberOfAliveNeighbours;
    }

    public static Cell alive(int numberOfAliveNeighbours) {
        return new Cell(ALIVE, numberOfAliveNeighbours);
    }

    public static Cell dead(int numberOfAliveNeighbours) {
        return new Cell(DEAD, numberOfAliveNeighbours);
    }

    public boolean isAlive() {
        return ALIVE == state;
    }

    public boolean isDead(){
        return !isAlive();
    }

    public int getNextState() {


        if (isAlive() && (numberOfAliveNeighbours == 2 || numberOfAliveNeighbours == 3)) {
            return ALIVE;
        }

        if (isDead() && numberOfAliveNeighbours == 3) {
            return ALIVE;
        }

        return DEAD;
    }
}

