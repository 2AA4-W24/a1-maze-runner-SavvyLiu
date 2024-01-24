package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

public class Maze {
    private int x = 0;
    private int y = 0;
    ArrayList<String> cars = new ArrayList<String>();
    public Maze(){
        
    }

    public void goRight(){
        x++;
    }
    public void goDown(){
        y++;
    }
    public void fillMaze(){

    }
}
