package stacksonstacks;

import java.util.Random;

	public class mazeGen {
	    public static void main(String[] args) {
	        int rows = 10;
	        int columns = 10;

	        char[][] maze = generateMaze(rows, columns);
	        printMaze(maze);
	    }

	    // Function to generate a random maze
	    private static char[][] generateMaze(int rows, int columns) {
	        char[][] maze = new char[rows][columns];
	        Random random = new Random();

	        // Initialize maze with walls
	        for (int i = 0; i < rows; i++) {
	            for (int j = 0; j < columns; j++) {
	                maze[i][j] = '0';
	            }
	        }

	        // Create open paths in the maze
	        for (int i = 1; i < rows - 1; i += 2) {
	            for (int j = 1; j < columns - 1; j += 2) {
	                maze[i][j] = '1';
	            }
	        }

	        // Randomly add additional paths
	        for (int i = 0; i < rows; i += 2) {
	            for (int j = 0; j < columns; j += 2) {
	                if (random.nextBoolean()) {
	                    maze[i][j + 1] = '1';
	                } else {
	                    maze[i + 1][j] = '1';
	                }
	            }
	        }

	        // Set entrance and exit
	        maze[0][1] = '1';
	        maze[rows - 1][columns - 2] = '1';

	        return maze;
	    }

	    // Function to print the maze
	    private static void printMaze(char[][] maze) {
	        for (int i = 0; i < maze.length; i++) {
	            for (int j = 0; j < maze[i].length; j++) {
	                System.out.print(maze[i][j] + " ");
	            }
	            System.out.println();
	        }
	    }
	}

