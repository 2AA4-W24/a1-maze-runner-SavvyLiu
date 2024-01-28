package ca.mcmaster.se2aa4.mazerunner;

public class Explorer {
    private int x;
    private int y;
    // direction is implemented as an int mod 4, where direction mod 4 = 0 represents right, direction mod 4 = 1 represents down, 
    // direction mod 4 = 2 represents left, and direction mod 4 = 3 represents up. In this way, incrementing direction has the effect
    // of turning right, and decrementing has the effect of turning left.
    private int direction;
    public Explorer(){
        x = 0;
        y = 0;
        direction = 0;
    }

    public void place(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public void turnRight(){
        direction = (direction + 1)%4;
    }

    public void turnLeft(){
        direction = (direction + 3)%4;
    }

    public int direction(){
        return direction;
    }


    public void move(){
        switch (direction){
            case(0):
                x++;
                break;
            case(1):
                y++;
                break;
            case(2):
                x--;
                break;
            case(3):
                y--;
                break;
        }
    }
}
