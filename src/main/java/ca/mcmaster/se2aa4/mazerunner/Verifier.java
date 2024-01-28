package ca.mcmaster.se2aa4.mazerunner;

import ca.mcmaster.se2aa4.mazerunner.Maze;

public class Verifier {

    private Maze toVerify;
    private String path;

    public Verifier(Maze toVerify, String path){
        this.toVerify = toVerify;
        this.path = path;
    }
    public Boolean verifyLeftToRight(){
        Explorer explorer = new Explorer();
        explorer.place(toVerify.leftEnterance(), 0);
        for (int i = 0; i < path.length(); i++){
            if (explorer.getY() >= toVerify.ySize() || explorer.getX() >= toVerify.xSize()){
                return false;
            }
            if (!toVerify.isOpen(explorer.getY(), explorer.getX())){
                return false;
            }
            switch (path.charAt(i)){
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

    public Boolean verifyRightToLeft(){
        Explorer explorer = new Explorer();
        explorer.place(toVerify.rightEnterance(), 0);
        // turns explorer around from facing right to facing left
        explorer.turnRight();
        explorer.turnRight();
        for (int i = 0; i < path.length(); i++){
            if (explorer.getY() >= toVerify.ySize() || explorer.getX() >= toVerify.xSize()){
                return false;
            }
            if (!toVerify.isOpen(explorer.getY(), explorer.getX())){
                return false;
            }
            switch (path.charAt(i)){
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
