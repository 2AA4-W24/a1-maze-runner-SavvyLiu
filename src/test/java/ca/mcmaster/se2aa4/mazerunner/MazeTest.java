package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class MazeTest {

    private Maze m = new Maze(3, 3);
    @Test
    void size() {
        assertEquals(m.xSize(), 3);
        assertEquals(m.ySize(), 3);
    }
    
    @Test
    void placeAndCheckWalls(){
        m.wall(true);
        m.buildRight();
        m.wall(true);
        m.buildRight();
        m.wall(true);
        m.buildDown();
        m.wall(false);
        m.buildRight();
        m.wall(false);
        m.buildRight();
        m.wall(false);
        m.buildDown();
        m.wall(true);
        m.buildRight();
        m.wall(true);
        m.buildRight();
        m.wall(true);

        assertEquals(true, m.isOpen(1,1));
        assertEquals(false, m.isOpen(0,1));
    }

}
