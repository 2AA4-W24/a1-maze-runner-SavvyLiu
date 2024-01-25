package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

public class Solver {
    public ArrayList<String> output = new ArrayList<String>();
    Maze toSolve;

    enum directions {
        RIGHT,
        LEFT,
        UP,
        DOWN
      }


    public Solver(Maze toSolve) { 
        this.toSolve = toSolve;
    }

    public void solve(){
        for (int i = 0; i < toSolve.xSize(); i ++){
            toSolve.goRight();
            recordMovement(directions.RIGHT);
        }
    }

    public void recordMovement(directions d){
        switch (d){
            case RIGHT:
                output.add("R");
                break;
            case LEFT:
                output.add("L");
                break;
            case UP:
                output.add("U");
                break;
            case DOWN:
                output.add("D");
                break;
        }
    }

    public void result(){
        for (int i = 0; i < output.size(); i++){
            System.out.print(output.get(i));
        }
        System.out.println();
    }
}