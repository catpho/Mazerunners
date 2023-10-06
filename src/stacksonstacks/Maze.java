package stacksonstacks.src.stacksonstacks;

public class Maze {

    private char[][] mazeArray;
    private int startCoordX;
    private int startCoordY;
    private int endCoordX;
    private int endCoordY;
    private int mazeWidth;
    private int mazeHeight;

    public char[][] getMazeArray() {
        return mazeArray;
    }

    public void setMazeArray(char[][] mazeArray) {
        this.mazeArray = mazeArray;
    }

    public int getStartCoordX() {
        return startCoordX;
    }

    public void setStartCoordX(int startCoordX) {
        this.startCoordX = startCoordX;
    }

    public int getStartCoordY() {
        return startCoordY;
    }

    public void setStartCoordY(int startCoordY) {
        this.startCoordY = startCoordY;
    }

    public int getEndCoordX() {
        return endCoordX;
    }

    public void setEndCoordX(int endCoordX) {
        this.endCoordX = endCoordX;
    }

    public int getEndCoordY() {
        return endCoordY;
    }

    public void setEndCoordY(int endCoordY) {
        this.endCoordY = endCoordY;
    }

    public int getMazeWidth() {
        return mazeWidth;
    }

    public void setMazeWidth(int mazeWidth) {
        this.mazeWidth = mazeWidth;
    }

    public int getMazeHeight() {
        return mazeHeight;
    }

    public void setMazeHeight(int mazeHeight) {
        this.mazeHeight = mazeHeight;
    }
}
