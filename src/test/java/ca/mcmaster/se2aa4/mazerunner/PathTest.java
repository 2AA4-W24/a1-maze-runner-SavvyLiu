package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PathTest {
    @Test
    void getCanonicalForm() {
        Path path = new Path("FLFFFFFRFFRFFLFFFFFFRFFFFLF");
        assertEquals("FLFFFFFRFFRFFLFFFFFFRFFFFLF", path.getCanonicalForm());
    }

    @Test
    void getFactorizedForm() {
        Path path = new Path("FLFFFFFRFFRFFLFFFFFFRFFFFLF");
        path.factorize();
        System.out.println(path);
        assertEquals("FL5FR2FR2FL6FR4FLF", path.getFactorizedForm());
    }

}