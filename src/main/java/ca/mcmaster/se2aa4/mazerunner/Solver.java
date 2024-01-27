package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.Arrays;
public class Solver {
    public ArrayList<String> output = new ArrayList<String>();
    Maze toSolve;
    Explorer explorer;

    enum directions {
        R,
        L,
        F
      }

      

    public Solver(Maze toSolve) { 
        this.toSolve = toSolve;
        explorer = new Explorer();
    }

    public void solve(){
        explorer.place(toSolve.enterance(), 0);
        while (explorer.getX() != toSolve.xSize()){
            boolean[] surroundings = toSolve.surroundings(explorer.getY(), explorer.getX());
            if (surroundings[explorer.direction()]){
                System.out.println("F");
                explorer.move();
                recordMovement(directions.F);
            } else if (checkStright(surroundings)){
                // removes the exit from this coordinate that was 180 degrees from the direction currently facing.
                // This makes sure the explorer doesnt go backwards.
                surroundings[(explorer.direction()+2)%4] = false;
                while(!surroundings[explorer.direction()]){
                    explorer.turnRight();
                    System.out.println("R");
                    recordMovement(directions.R);
                }
            } else {
                explorer.turnRight();
                System.out.println("R");
                recordMovement(directions.R);
            }
        }

    }

    // This method counts the number of openings surrounding a coordinate. If it is less than or equal to 2, it returns true, which represents
    // the fact that there is only one choice to advance through that particular section. 
    public boolean checkStright(boolean[] in){
        int count = 0;
        for (Boolean b: in){
            if (b) {
                count++;
            }
        }
        if (count > 2){
            return false;
        }
        return true;
    }

    public void recordMovement(directions d){
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

    public void result(){
        for (int i = 0; i < output.size(); i++){
            System.out.print(output.get(i));
        }
        System.out.println();
    }
} 