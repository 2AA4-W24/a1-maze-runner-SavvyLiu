package ca.mcmaster.se2aa4.mazerunner;

public class Solver implements SolverGeneric{
    private Path output;
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
        this.output = new Path();
    }
    
    public void solve(){
        explorer.place(toSolve.leftEnterance(), 0);
        while (!toSolve.checkExit(explorer.getX())){

            boolean[] surroundings = toSolve.surroundings(explorer.getY(), explorer.getX());

            if (checkRight(surroundings)){
                explorer.turnRight();
                explorer.move();
                recordMovement(directions.R);
                recordMovement(directions.F);

            } else if (checkForward(surroundings)){
                explorer.move();
                recordMovement(directions.F);
                
            } 
            else if (checkLeft(surroundings)){
                explorer.turnLeft();
                explorer.move();
                recordMovement(directions.L);
                recordMovement(directions.F);

            } else {
                explorer.turnRight();
                explorer.turnRight();
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
                output.addOne('R');
                break;
            case L:
                output.addOne('L');
                break;
            case F:
                output.addOne('F');
                break;
        }
    }

    public void printPath(){
        output.printPath();
    }

    public void printFactorizedPath(){
        output.factorize();
    }

} 