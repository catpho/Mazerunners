package stacksonstacks.src.stacksonstacks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MazeUtil {

    public static Maze importMazeFromFile(File file) {
        Maze maze = new Maze();
        char[][] mazeGrid;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            // Initializing
            int lineNumber = 1;
            int arrayRow = 0;
            String[] stringArray;
            String line;

            // Reading line 1 and creating charArray of defined size
            line = reader.readLine();
            stringArray = line.split(" ");

            maze.setMazeWidth(Integer.parseInt(stringArray[0]));
            maze.setMazeHeight(Integer.parseInt(stringArray[1]));
            //System.out.println("Maze Size: " + maze.getMazeWidth() + " x " + maze.getMazeHeight());
            mazeGrid = new char[maze.getMazeWidth()][maze.getMazeHeight()];

            lineNumber++;

            // Lines 2+

            while ((line = reader.readLine()) != null && !line.equals("")) {

                    if (lineNumber == 2) {
                        stringArray = line.split(" ");

                        maze.setStartCoordX(Integer.parseInt(stringArray[0]));
                        maze.setStartCoordY(Integer.parseInt(stringArray[1]));

                        System.out.println("Start Coordinates: " + maze.getStartCoordX() + ", " + maze.getStartCoordY());
                    } else if (lineNumber == 3) {
                        stringArray = line.split(" ");

                        maze.setEndCoordX(Integer.parseInt(stringArray[0]));
                        maze.setEndCoordY(Integer.parseInt(stringArray[1]));

                        System.out.println("End Coordinates: " + maze.getEndCoordX() + ", " + maze.getEndCoordY());
                    } else {
                        stringArray = line.split(" ");

                        System.out.print("Raw Line Data: " + line + " | ");
                        System.out.print("Array Line Data: ");
                        for (int i = 0; i < stringArray.length; i++) {
                            mazeGrid[arrayRow][i] = stringArray[i].charAt(0);
                            System.out.print(mazeGrid[arrayRow][i] + " ");
                        }
                        arrayRow++;
                        System.out.println();
                    }
                    lineNumber++;
                }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("There is an issue with your maze text file. Check that it meets the criteria of the file.");
            return null;
        }

        return maze;
    }

    public static Maze importMaze(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            Maze maze = new Maze();

            String line = reader.readLine();
            setMazeDimensions(maze, line);
            System.out.println("Maze Size: " + maze.getMazeWidth() + " x " + maze.getMazeHeight());

            line = reader.readLine();
            setStartCoordinates(maze, line);
            System.out.println("Start Coordinates: " + maze.getStartCoordX() + ", " + maze.getStartCoordY());

            line = reader.readLine();
            setEndCoordinates(maze, line);
            System.out.println("End Coordinates: " + maze.getEndCoordX() + ", " + maze.getEndCoordY());

            buildMazeGrid(maze, reader);

            return maze;
        } catch (IOException e) {
            System.out.println("Error reading maze file");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format in maze file");
        }
        return null;
    }

    private static void setMazeDimensions(Maze maze, String line) {
        String[] dimensions = line.split(" ");
        maze.setMazeWidth(Integer.parseInt(dimensions[0]));
        maze.setMazeHeight(Integer.parseInt(dimensions[1]));
    }

    private static void setStartCoordinates(Maze maze, String line) {
        String[] coordinates = line.split(" ");
        maze.setStartCoordX(Integer.parseInt(coordinates[0]));
        maze.setStartCoordY(Integer.parseInt(coordinates[1]));
    }

    private static void setEndCoordinates(Maze maze, String line) {
        String[] coordinates = line.split(" ");
        maze.setEndCoordX(Integer.parseInt(coordinates[0]));
        maze.setEndCoordY(Integer.parseInt(coordinates[1]));
    }

    private static void buildMazeGrid(Maze maze, BufferedReader reader) throws IOException {
        char[][] grid = new char[maze.getMazeWidth()][maze.getMazeHeight()];
        String line;
        String[] stringArray;
        int row = 0;

        while ((line = reader.readLine()) != null && !line.equals("")) {
            stringArray = line.split(" ");
            for (int i = 0; i < stringArray.length; i++) {
                grid[row][i] = stringArray[i].charAt(0);
                System.out.print(grid[row][i] + " ");
            }
            System.out.println();
            row++;
        }

        maze.setMazeArray(grid);
    }
}
