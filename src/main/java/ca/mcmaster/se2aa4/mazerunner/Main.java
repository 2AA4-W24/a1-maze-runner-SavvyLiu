package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.Level;

public class Main {

    private static final Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");
        logger.info("Here goes the business code");
        try{
            
            MazeReader reader = new MazeReader(args);
            Maze maze = reader.read();
            if (reader.mode()){
                Verifier verifier = new Verifier(maze, reader.getMazePath());
                System.out.println("Is correct path: " + verifier.verify());
            } else {
                Solver solver = new Solver(maze);
                solver.solve();
                solver.printPath();
            }

        } catch(Exception e){
            logger.error("/!\\ An error has occured /!\\" + e);
            e.printStackTrace();
        }

        logger.info("**** Computing path");
        logger.info("** End of MazeRunner");
    }
}