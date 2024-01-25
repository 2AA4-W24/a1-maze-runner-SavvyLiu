package ca.mcmaster.se2aa4.mazerunner;
import java.util.Arrays;
public class Maze {
    private int x = 0;
    private int y = 0;
    private String[][] grid;

    public Maze(int x, int y){
        grid = new String[y][x];
        for (int i = 0; i < y; i++){
            Arrays.fill(grid[i], " ");
        }
    }

    public void goRight(){
        x++;
    }
    public void goDown(){
        x = 0;
        y++;
    }

    public int xSize(){
        return grid[0].length;
    }

    public int ySize(){
        return grid.length;
    }

    public int enterance(){
        for (int i = 0; i < y; i++){
            if (grid[i][0] == null || grid[i][0].equals(" ")){
                return i;
            }
        }
        return 0;
    }

    public void wall(Boolean t){
        if (t){
            grid[y][x] = "#";
        } else {
            grid[y][x] = " ";
        }
    }

    public void print(){
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void fix(){
        
    }
}