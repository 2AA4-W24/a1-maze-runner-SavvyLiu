package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.nio.file.Files;
import java.io.FileReader;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.Level;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    private static Maze ReadMaze(String[] args) throws Exception{
        Configurator.setAllLevels(LogManager.getRootLogger().getName(), Level.ALL);
        Options options = new Options();
        options.addOption("i", true, "Maze file path");
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);
        String file_path = cmd.getOptionValue("i");
        logger.info("**** Reading the maze from file " + file_path);
        BufferedReader reader = new BufferedReader(new FileReader(file_path));
        String line;
        Maze toSolve = new Maze(); 
        while ((line = reader.readLine()) != null) {
            for (int idx = 0; idx < line.length(); idx++) {
                if (line.charAt(idx) == '#') {
                    System.out.print("WALL ");
                } else if (line.charAt(idx) == ' ') {
                    System.out.print("PASS ");
                }
                System.out.print(System.lineSeparator());
            }
        }
        return toSolve;
    }

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");
        logger.info("Here goes the business code");
        try{
            Maze toSolve = ReadMaze(args);
            Solver solver = new Solver(toSolve);
        } catch(Exception e){
            logger.error("/!\\ An error has occured /!\\");
        }

        logger.info("**** Computing path");
        logger.info("** End of MazeRunner");
    }
}
