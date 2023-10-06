package stacksonstacks.src.stacksonstacks;

import java.io.*;

public class MazeSolver {

    private static File exampleFile = new File("maze.txt");

    public static void solveMaze(Maze maze) {

    }


    public static void main(String... args) {
        //Maze maze = MazeUtil.importMazeFromFile(exampleFile);
        Maze maze = MazeUtil.importMaze(exampleFile);
        solveMaze(maze);
    }

}
