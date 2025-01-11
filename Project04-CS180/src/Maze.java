/**
 * Java class Maze.java creates and stores data representing a Maze.
 *
 * <p>Purdue University -- CS18000 -- Spring 2024</p>
 *
 * @author Jiauxn Li
 * @version April 08, 2024
 */
public class Maze {
    /**
     * Field for the end square of this Maze.
     */
    private final int[] end;
    /**
     * Field for the char grid representation of this Maze.
     */
    private final char[][] grid;
    /**
     * Field for the Maze's name.
     */
    private final String name;
    /**
     * Field for the array of moves required to solve this Maze.
     */
    private int[][] path;
    /**
     * Field for the start square of this Maze.
     */
    private final int[] start;

    /**
     * Constructs a newly allocated Maze object using the provided arguments.
     * The path field should be set to null.
     *
     * @param name  The name of the Maze
     * @param grid  The char grid representation of the Maze
     * @param start The start square of the Maze
     * @param end   The end square of the Maze
     */
    public Maze(String name, char[][] grid, int[] start, int[] end) {
        this.name = name;
        this.grid = grid;
        this.start = start;
        this.end = end;
        this.path = null;
    }

    /**
     * Getter method for this Maze's end square.
     *
     * @return The int array for the end square where end[0] = row and end[1] = column.
     */
    public int[] getEnd() {
        return end;
    }

    /**
     * Getter method for this Maze's char grid representation.
     *
     * @return a 2-dimensional char array representing the maze squares.
     */
    public char[][] getGrid() {
        return grid;
    }

    /**
     * Getter method for this Maze's name.
     *
     * @return The name of the Maze
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method to get the path solution for this Maze.
     *
     * @return The int array representing the moves required to exit the maze.
     */
    public int[][] getPath() {
        return path;
    }

    /**
     * Getter method for this Maze's start square.
     *
     * @return The int array for the start square where start[0] = row and start[1] = column.
     */
    public int[] getStart() {
        return start;
    }

    /**
     * This method returns the String representing the Maze solution.
     * The first line should be the Maze name.
     * The second line should be "Moves: " followed by the number of moves. Example: "Moves: 48" The next line should be "Start"
     * The next N lines should be the moves required to solve the maze. Example "6-0"
     * The first and last moves should be the start and end squares respectively.
     * After all moves are printed the last line should be "End".
     * A full example is provided in the handout.
     *
     * @return The String representing the Maze's solution.
     */
    public String pathString() {
        if (path == null) {
            return "No path found";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(name).append("\n");
            sb.append("Moves: ").append(path.length).append("\n");
            sb.append("Start").append("\n");
            for (int[] pos : path) {
                sb.append(pos[0]).append("-").append(pos[1]).append("\n");
            }
            sb.append("End");
            return sb.toString();
        }
    }

    /**
     * Setter method for the path field.
     *
     * @param path a 2 dimensional array representing the moves to solve the maze.
     */
    public void setPath(int[][] path) {
        this.path = path;
    }

    /**
     * Returns the String representation of this Maze.
     * The format is the same as the input file format.
     * The first line is the name of the maze.
     * The second line is "Start: " followed by the row-col of the start square. Example "Start: 6-0"
     * The third line is the "End: " followed by the row-col of the end square. Example "End: 1-10"
     * The next N rows are the maze grid divided by commas.
     * There should not be a comma at the end of a line. full example can be found in the handout and in StarterMaze.txt.
     *
     * @return The String representing the Maze, same format as the read from file.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name);
        sb.append("\n");
        sb.append("Start: ").append(start[0]).append("-").append(start[1]).append("\n");
        sb.append("End: ").append(end[0]).append("-").append(end[1]).append("\n");
        for (char[] row : grid) {
            for (int i = 0; i < row.length; i++) {
                sb.append(row[i]);
                if (i != row.length - 1) {
                    sb.append(",");
                } else {
                    sb.append("\n");
                }
            }
        }
        return sb.toString();
    }
}

