package ca.mcmaster.se2aa4.mazerunner;

import ca.mcmaster.se2aa4.mazerunner.Maze;

public class Verifier {
    enum directions {
        R,
        L,
        U,
        D
      }

    private Maze toVerify;
    private String path;
    private int[] explorer = new int[1];
    private directions direction = directions.R;
    public Verifier(Maze toVerify, String path){
        this.toVerify = toVerify;
        this.path = path;
        explorer[0] = toVerify.enterance();
        explorer[1] = 0;
    }

    public Boolean verify(){
        for (int i = 0; i < path.length(); i++){
            switch (path.charAt(i)){
                case('R'):
                    break;
            }
        }
        return true;
    }


}
