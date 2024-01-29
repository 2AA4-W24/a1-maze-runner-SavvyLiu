package ca.mcmaster.se2aa4.mazerunner;

public class Path {
    private String output;
    public Path(){  }

    public Path(String toVerify){
        for (int i = 0; i < toVerify.length(); i++){
            output += (toVerify.charAt(i));
        }
    }
    public void addOne(char movement){
        output += movement;
    }

    public char movementAt(int i){
        return output.charAt(i);
    }

    public int size(){
        return output.length();
    }

    public void printPath(){
        for (int i = 0; i < output.length(); i++){
            System.out.print(output.charAt(i));
        }
        System.out.println();
    }
}
