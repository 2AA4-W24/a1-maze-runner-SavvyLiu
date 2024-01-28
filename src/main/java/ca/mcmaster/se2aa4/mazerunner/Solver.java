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
        explorer.place(0, toSolve.enterance());
        int count = 0;
        while (explorer.getX() != toSolve.xSize()){

            boolean[] surroundings = toSolve.surroundings(explorer.getY(), explorer.getX());
            System.out.println("dirction: " + explorer.direction());
            if (checkRight(surroundings)){
                explorer.turnRight();
                explorer.move();
                System.out.println("right");
                recordMovement(directions.R);
                recordMovement(directions.F);
                count++;
                if (count > 100){
                    break;
                }


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
                count++;
                if (count > 100){
                    break;
                }
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

    // This method counts the number of openings surrounding a coordinate. If it is equal to 2, it returns true, which represents
    // the fact that there is only one choice to advance through that particular section. 

    public boolean checkStright(boolean[] in){
        int count = 0;
        for (Boolean b: in){
            if (b) {
                count++;
            }
        }
        if (count == 2){
            return true;
        }
        return false;
    }

    public boolean checkDeadEnd(boolean[] surroundings){
        int count = 0;
        for (Boolean b: surroundings){
            if (b) {
                count++;
            }
        }
        if (count == 1){
            return true;
        }
        return false;
    }

    public boolean checkSplit(boolean[] surroundings){
        int count = 0;
        for (Boolean b: surroundings){
            if (b) {
                count++;
            }
        }
        if (count >= 3){
            return true;
        }
        return false;
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