package ca.mcmaster.se2aa4.mazerunner;

public class Path {
    private String output;
    private String factorized;
    public Path(){
        output = "";
        factorized = "";
    }

    public Path(String toVerify){
        for (int i = 0; i < toVerify.length(); i++){
            output += (toVerify.charAt(i));
            if (output.charAt(i) != output.charAt(i)){

            }
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

    public void factorize(){
        // repeats refers to the number of times the character shows up in a row. 
        // just one character would be considered to be repeated once.
        int repeats = 1;
        for (int i = 0; i < output.length(); i++){
            if (i == output.length() - 1 || output.charAt(i) == output.charAt(i+1)){
                repeats++;
            } else {
                // Only includes the number of repeats if it is greater than 1, since 1F is less compact than just F
                if (repeats > 1){
                    factorized += (repeats);
                }
                factorized += (output.charAt(i));
                repeats = 1;
            }
        }
        System.out.println(factorized);
    }
}
