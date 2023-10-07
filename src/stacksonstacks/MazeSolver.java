package stacksonstacks.src.stacksonstacks;

import java.io.*;

public class MazeSolver {

    private static File exampleFile = new File("maze tst 4.txt");

    public static void traverseMaze(Maze maze, char[][] grid ,int x, int y, CharStack stack) {

        int maxHeightIndex = maze.getMazeHeight() - 1;
        int maxWidthIndex = maze.getMazeWidth() - 1;

        grid[x][y] = 'x';
        stack.push( x + "," + y);
        if (x == maze.getEndCoordX() && y == maze.getEndCoordY()) {
                System.out.println("The maze has been solved!");
                System.out.println("Path back:");
                while (!stack.isEmpty()) {
                    System.out.println(stack.pop());
                }
        }
        try {
            if(y + 1 <= maxHeightIndex && grid[x][y+1] == '1'){
                //System.out.println("There is a path to the right: " + x + "," + (y+1));
                traverseMaze(maze, grid, x, y + 1, stack);

            }
            if(y - 1 >= 0 && grid[x][y-1] == '1'){
                //System.out.println("There is a path to the left: " + x + "," + (y-1));
                traverseMaze(maze, grid, x, y - 1, stack);
            }
            if(x - 1 >= 0 && grid[x-1][y] == '1'){
                //System.out.println("There is a path above: " + (x-1) + "," + y);
                traverseMaze(maze, grid, x - 1, y, stack);

            }
            if(x + 1 <= maxWidthIndex && grid[x+1][y] == '1'){
                //System.out.println("There is a path below: " + (x+1) + "," + y);
                traverseMaze(maze, grid, x + 1, y, stack);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }
        grid[x][y] = '1';
        if(!stack.isEmpty()) {
            stack.pop();
        }
    }

    public static boolean traverseMazeV2(Maze maze, char[][] grid ,int x, int y, CharStack solution, CharStack pathsAvailable) {

        int maxHeightIndex = maze.getMazeHeight() - 1;
        int maxWidthIndex = maze.getMazeWidth() - 1;

        grid[x][y] = 'x';
        solution.push( x + "," + y);
        if (x == maze.getEndCoordX() && y == maze.getEndCoordY()) {
            System.out.println("The maze has been solved!");
            System.out.println("Path back:");
            while (!solution.isEmpty()) {
                System.out.println(solution.pop());
            }

            System.out.println("Multiple Paths:");
            while (!pathsAvailable.isEmpty()) {
                System.out.println(pathsAvailable.pop());
            }

            System.out.println("Map:");
            for(int i = 0; i < maxHeightIndex + 1; i++ ) {
                for(int j = 0; j < maxWidthIndex + 1; j++ ) {
                    System.out.print(grid[i][j] + " ");
                }
                System.out.println();
            }
            return true;
        }
        try {
            // y + 1, y - 1
            if(y + 1 <= maxHeightIndex && grid[x][y+1] == '1' && y - 1 >= 0 && grid[x][y-1] == '1') {
                //System.out.println("Multiple paths!");
                pathsAvailable.push( x + "," + y);
            }

            // y + 1, x + 1
            if(y + 1 <= maxHeightIndex && grid[x][y+1] == '1' && x + 1 <= maxWidthIndex && grid[x+1][y] == '1') {
                //System.out.println("Multiple paths!");
                pathsAvailable.push( x + "," + y);
            }

            // y + 1, x - 1
            if(y + 1 <= maxHeightIndex && grid[x][y+1] == '1' && x - 1 >= 0 && grid[x-1][y] == '1') {
                //System.out.println("Multiple paths!");
                pathsAvailable.push( x + "," + y);
            }

            // y - 1, x + 1
            if(y - 1 >= 0 && grid[x][y-1] == '1' && x + 1 <= maxWidthIndex && grid[x+1][y] == '1') {
                //System.out.println("Multiple paths!");
                pathsAvailable.push( x + "," + y);
            }

            // y - 1, x - 1
            if(y - 1 >= 0 && grid[x][y-1] == '1' && x - 1 >= 0 && grid[x-1][y] == '1') {
                //System.out.println("Multiple paths!");
                pathsAvailable.push( x + "," + y);
            }

            // x - 1, x + 1
            if(x - 1 >= 0 && grid[x-1][y] == '1' && x + 1 <= maxWidthIndex && grid[x+1][y] == '1') {
                //System.out.println("Multiple paths!");
                pathsAvailable.push( x + "," + y);
            }


            if(y + 1 <= maxHeightIndex && grid[x][y+1] == '1' && traverseMazeV2(maze, grid, x, y + 1, solution, pathsAvailable)){
                //System.out.println("There is a path to the right: " + x + "," + (y+1));
                //traverseMazeV2(maze, grid, x, y + 1, stack);
                return true;

            }
            if(y - 1 >= 0 && grid[x][y-1] == '1' && traverseMazeV2(maze, grid, x, y - 1, solution, pathsAvailable)){
                //System.out.println("There is a path to the left: " + x + "," + (y-1));
                //traverseMazeV2(maze, grid, x, y - 1, stack);
                return true;
            }
            if(x - 1 >= 0 && grid[x-1][y] == '1' && traverseMazeV2(maze, grid, x - 1, y, solution, pathsAvailable)){
                //System.out.println("There is a path above: " + (x-1) + "," + y);
                //traverseMazeV2(maze, grid, x - 1, y, stack);
                return true;

            }
            if(x + 1 <= maxWidthIndex && grid[x+1][y] == '1' && traverseMazeV2(maze, grid, x + 1, y, solution, pathsAvailable)){
                //System.out.println("There is a path below: " + (x+1) + "," + y);
                //traverseMazeV2(maze, grid, x + 1, y, stack);
                return true;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }
        // If no path is found, it'll backtrack
        grid[x][y] = '1';
        if(!solution.isEmpty()) {
            solution.pop();
        }
        return false;
    }


    public static void main(String... args) {
        //Maze maze = MazeUtil.importMazeFromFile(exampleFile);
        Maze maze = MazeUtil.importMaze(exampleFile);
        CharStack mazeSolution = new CharStack();
        CharStack mazePaths = new CharStack();

        char[][] grid = maze.getMazeGrid();

         traverseMazeV2(maze, grid, maze.getStartCoordX(),maze.getStartCoordY(), mazeSolution, mazePaths);
    }

}
