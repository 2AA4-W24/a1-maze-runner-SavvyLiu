package ca.mcmaster.se2aa4.mazerunner;

import ca.mcmaster.se2aa4.mazerunner.Maze;

public class Verifier {

    private Maze toVerify;
    private Path path;

    public Verifier(Maze toVerify, String inputPath){
        this.toVerify = toVerify;
        this.path = new Path(inputPath);
    }
    private Boolean verifyLeftToRight(){
        Explorer explorer = new Explorer();
        explorer.place(toVerify.leftEnterance(), 0);
        for (int i = 0; i < path.size(); i++){
            if (explorer.getY() >= toVerify.ySize() || explorer.getX() >= toVerify.xSize()){
                return false;
            }
            if (!toVerify.isOpen(explorer.getY(), explorer.getX())){
                return false;
            }
            switch (path.movementAt(i)){
                case('R'):{
                    explorer.turnRight();
                    break;
                }
                case('F'):{
                    explorer.move();
                    break;
                }
                case('L'):{
                    explorer.turnLeft();
                    break;
                }
            }
        }
        if (toVerify.checkExit(explorer.getX())){
            return true;
        }
        return false;
    }

    private Boolean verifyRightToLeft(){
        Explorer explorer = new Explorer();
        explorer.place(toVerify.rightEnterance(), 0);
        // turns explorer around from facing right to facing left
        explorer.turnRight();
        explorer.turnRight();
        for (int i = 0; i < path.size(); i++){
            if (explorer.getY() >= toVerify.ySize() || explorer.getX() >= toVerify.xSize()){
                return false;
            }
            if (!toVerify.isOpen(explorer.getY(), explorer.getX())){
                return false;
            }
            switch (path.movementAt(i)){
                case('R'):{
                    explorer.turnRight();
                    break;
                }
                case('F'):{
                    explorer.move();
                    break;
                }
                case('L'):{
                    explorer.turnLeft();
                    break;
                }
            }
        }
        if (toVerify.checkExit(explorer.getX())){
            return true;
        }
        return false;
    }

    public boolean verify(){
        return (verifyLeftToRight() || verifyRightToLeft());
    }
}
