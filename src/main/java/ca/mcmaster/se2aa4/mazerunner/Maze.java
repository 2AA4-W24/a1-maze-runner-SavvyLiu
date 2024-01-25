package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

public class Maze {
    int x = 0;
    int y = 0;
    String[][] grid;
    public Maze(int x, int y){
        grid = new String[x][y];
    }

    public void goRight(){
        x++;
    }
    public void goDown(){
        x = 0;
        y++;
    }
    public void wall(Boolean t){
        if (t){
            grid[y][x] = "#";
        } else {
            grid[y][x] = " ";
        }
    }

    public void print(){
        for (int i = 0; i < grid[0].length; i++){
            for (int j = 0; j < grid.length; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
