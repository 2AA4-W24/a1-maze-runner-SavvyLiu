package ca.mcmaster.se2aa4.mazerunner;

public class Maze {

    private final Tile[][] grid;

    public Maze(int width, int height) {
        this.grid = new Tile[height][width];
    }
}
