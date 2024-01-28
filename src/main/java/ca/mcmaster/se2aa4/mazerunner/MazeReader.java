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

public class MazeReader{
    private static final Logger logger = LogManager.getLogger();
    Maze maze;
    String file_path;
    boolean verifyMode;
    String maze_path;
    public MazeReader(String[] args) throws Exception{
        Configurator.setAllLevels(LogManager.getRootLogger().getName(), Level.ALL);
        Options options = new Options();
        options.addOption("i", true, "Maze file path");
        options.addOption("p", true, "Verify mode");
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);
        this.file_path = cmd.getOptionValue("i");
        this.verifyMode = cmd.hasOption("p");
        this.maze_path = cmd.getOptionValue("p");
    }

    public Maze read() throws Exception{
        logger.info("**** Reading the maze from file " + file_path);
        BufferedReader reader = new BufferedReader(new FileReader(file_path));
        String line;

        int[] mazeDimension = dimensions(file_path);
        Maze maze = new Maze(mazeDimension[0], mazeDimension[1]); 
        while ((line = reader.readLine()) != null) {
            for (int idx = 0; idx < line.length(); idx++) {
                if (line.charAt(idx) == '#') {
                    maze.wall(true);
                } else if (line.charAt(idx) == ' ') {
                    maze.wall(false);
                }
                maze.buildRight();
            }
            maze.buildDown();
        }
        maze.print();
        reader.close();
        return maze;
    }

    public boolean mode(){
        return verifyMode;
    }

    public String getMazePath(){
        return maze_path;
    }
    // method to find dimensions of the maze in the provided file
    public static int[] dimensions(String path) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader(path));
        int x = 0;
        int y = 0;
        String line = reader.readLine();
        for (int i = 0; i < line.length(); i++){
            x++;
        }
        while((line = reader.readLine()) != null){
            y++;
        }
        // Adds 1 to y since the initial readline() call to retrieve and calculate length of a line advances the reader by one line
        int[] output = {y+1, x};
        reader.close();
        return output;
    }
}