package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.Arrays;
public class Solver implements SolverGeneric{
    private ArrayList<String> output;
    private Maze toSolve;
    private Explorer explorer;

    private enum directions {
        R,
        L,
        F
      }

    public Solver(Maze toSolve) { 
        this.toSolve = toSolve;
        this.explorer = new Explorer();
        this.output = new ArrayList<String>();
    }
    
    public void solve(){
        explorer.place(toSolve.leftEnterance(), 0);
        while (!toSolve.checkExit(explorer.getX())){

            boolean[] surroundings = toSolve.surroundings(explorer.getY(), explorer.getX());

            if (checkRight(surroundings)){
                explorer.turnRight();
                explorer.move();
                System.out.println("right");
                recordMovement(directions.R);
                recordMovement(directions.F);

            } else if (checkForward(surroundings)){
                explorer.move();
                System.out.println("forward");
                recordMovement(directions.F);
                
            } 
            else if (checkLeft(surroundings)){
                explorer.turnLeft();
                explorer.move();
                System.out.println("turning left");
                recordMovement(directions.L);
                recordMovement(directions.F);

            } else {
                explorer.turnRight();
                explorer.turnRight();
                System.out.println("turn around");
                explorer.move();
                recordMovement(directions.R);
                recordMovement(directions.R);
                recordMovement(directions.F);
            }
        }

    }

    private boolean checkRight(boolean[] surroundings){
        return surroundings[(explorer.direction() + 1) % 4];
    }

    private boolean checkForward(boolean[] surroundings){
        return surroundings[(explorer.direction())];
    }

    private boolean checkLeft(boolean[] surroundings){
        return surroundings[(explorer.direction() + 3) % 4];
    }




    private void recordMovement(directions d){
        switch (d){
            case R:
                output.add("R");
                break;
            case L:
                output.add("L");
                break;
            case F:
                output.add("F");
                break;
        }
    }

    public ArrayList<String> outputPath(){
        return output;
    }

    public void printPath(){
        for (int i = 0; i < output.size(); i++){
            System.out.print(output.get(i));
        }
        System.out.println();
    }
} 