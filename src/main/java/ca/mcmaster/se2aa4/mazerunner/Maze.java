package ca.mcmaster.se2aa4.mazerunner;
import java.util.Arrays;
public class Maze {
    public int y = 0;
    public int x = 0;
    private String[][] grid;

    public Maze(int y, int x){
        grid = new String[y][x];
        for (int i = 0; i < y; i++){
            Arrays.fill(grid[i], " ");
        }
    }

    public void buildRight(){
        x++;
    }
    public void buildDown(){
        x = 0;
        y++;
    }

    public int xSize(){
        return grid[0].length;
    }

    public int ySize(){
        return grid.length;
    }
    

    // returns an array with Booleans, with index 0 representing whether or not there is an opening in the right direction, index 1 representing down,
    // index 2 representing left, and index 3 representing up. The indexes align with the Solver class's direction array indexes.
    public boolean[] surroundings(int y, int x){
        // boolean arrays default to false
        System.out.println("x" + x);
        System.out.println("y" + y);
        
        boolean[] output = new boolean[4];
        if (grid[y][Math.min(xSize()-1, x+1)].equals(" ")){
            output[0] = true;
        }
            
        if (grid[Math.min(ySize()-1, y+1)][x].equals(" ")){
            output[1] = true;
        }
            
        if (grid[y][Math.max(0, x-1)].equals(" ")){
            output[2] = true;
        }
            
        if (grid[Math.max(0, y-1)][x].equals(" ")){
            output[3] = true;
        }
        // left and right swapped, hits dead end and loops infinite, need to add turn around case
        return output;
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
} 

