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
        explorer.place(toSolve.leftEnterance(), 0);
        while (!toSolve.checkExit(explorer.getX())){

            boolean[] surroundings = toSolve.surroundings(explorer.getY(), explorer.getX());
            System.out.println("dirction: " + explorer.direction());
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

    public boolean checkRight(boolean[] surroundings){
        return surroundings[(explorer.direction() + 1) % 4];
    }

    public boolean checkForward(boolean[] surroundings){
        return surroundings[(explorer.direction())];
    }

    public boolean checkLeft(boolean[] surroundings){
        return surroundings[(explorer.direction() + 3) % 4];
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