import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Java class MazeSolver.java reads a maze from a file,
 * stores the maze in a maze object, solves the maze, and writes the solution to a file.
 *
 * <p>Purdue University -- CS18000 -- Spring 2024</p>
 *
 * @author Jiauxn Li
 * @version April 08, 2024
 */
public class MazeSolver {
    /**
     * A field to store the Maze.
     */
    private Maze maze;

    /**
     * This method should solve the Maze maze of this MazeSolver.
     * It should set the path field of Maze maze with the solution to the maze.
     * This method should always terminate and throw no errors.
     * Crashes and infinite loops will result in a loss of points.
     */
    public void solveMaze() {
        if (maze == null) {
            System.out.println("Maze not loaded");
            return;
        }
        // use BFS to find the shortest path
        int[] start = maze.getStart();
        int[] end = maze.getEnd();
        char[][] grid = maze.getGrid();
        int rows = grid.length;
        int cols = grid[0].length;

        // visited and predecessor arrays
        boolean[][] visited = new boolean[rows][cols];
        int[][][] predecessor = new int[rows][cols][2];

        // directions
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // BFS
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            // end
            if (cur[0] == end[0] && cur[1] == end[1]) {
                // reconstruct path
                ArrayList<int[]> pathList = new ArrayList<>();
                int[] curPos = end;
                while (curPos[0] != start[0] || curPos[1] != start[1]) {
                    pathList.add(0, curPos);
                    curPos = predecessor[curPos[0]][curPos[1]];
                }
                pathList.add(0, start);
                this.maze.setPath(pathList.toArray(new int[0][0]));
                return;
            }

            // check all directions
            for (int[] dir : directions) {
                int newRow = cur[0] + dir[0];
                int newCol = cur[1] + dir[1];
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] != 'W'
                        && !visited[newRow][newCol]) {
                    queue.add(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;
                    predecessor[newRow][newCol] = cur;
                }
            }
        }

        // no solution
        System.out.println("No path found");
    }

    /**
     * This method writes the solution to the given filename.
     * The correct format for the solution is detailed in Maze.java pathString().
     * The format should match the example given in the handout.
     * This method should not encounter any IOExceptions.
     * For this assignment you should use e.printStackTrace in your catch block.
     * It is bad coding practice to have empty catch blocks.
     *
     * @param filename The name of the file to write the solution to.
     */
    public void writeSolution(String filename) {
        if (maze == null) {
            System.out.println("Maze not loaded");
            return;
        }
        try {
            java.io.PrintWriter writer = new java.io.PrintWriter(filename);
            writer.println(maze.pathString());
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * Reads from the designated file and initializes the Maze maze field of this MazeSolver with its contents.
     * If the Maze does not have a name then it is invalid.
     * If the Maze is not rectangular (squares are rectangles) then the Maze is invalid.
     * If the Maze does not have a start or an end it is invalid.
     * If the start or end values are non-integer the Maze is invalid.
     * If the start or end values are not within the grid then the Maze is invalid.
     * If the start or end square is not a P then the Maze is invalid.
     * If the Maze contains square that are not a W or P then it is invalid.
     * All invalid Mazes should throw an InvalidMazeException.
     * Throws an IOException on any file related error.
     * File format is the same as Maze.java toString() method. An example is included in the handout.
     *
     * @param filename The name of the file to be read.
     * @throws InvalidMazeException If the file does not contain a valid maze throws an InvalidMazeException
     * @throws IOException          If the file can not be read or does not exist throws a new IOException
     */
    public void readMaze(String filename) throws InvalidMazeException, IOException {
        Scanner scanner = new Scanner(new java.io.File(filename));
        String name = scanner.nextLine();

        // Start: row-col
        int[] start = new int[2];
        String[] startLine = scanner.nextLine().split(" ");
        if (startLine.length != 2) {
            throw new InvalidMazeException("Invalid start position");
        } else {
            String[] startArr = startLine[1].split("-");
            start[0] = Integer.parseInt(startArr[0]);
            start[1] = Integer.parseInt(startArr[1]);
        }

        // End: row-col
        int[] end = new int[2];
        String[] endLine = scanner.nextLine().split(" ");
        if (endLine.length != 2) {
            throw new InvalidMazeException("Invalid end position");
        } else {
            String[] endArr = endLine[1].split("-");
            end[0] = Integer.parseInt(endArr[0]);
            end[1] = Integer.parseInt(endArr[1]);
        }

        // grid
        int rows = -1;
        int cols = -1;
        ArrayList<String[]> grid = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String[] tokens = scanner.nextLine().split(",");
            if (rows == -1) {
                cols = tokens.length;
            } else if (tokens.length != cols) {
                throw new InvalidMazeException("Inconsistent column length");
            }
            grid.add(tokens);
            rows++;
        }
        if (rows == -1) {
            throw new InvalidMazeException("Empty maze");
        }
        char[][] gridArr = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                String token = grid.get(i)[j];
                if (token.equals("P")) {
                    gridArr[i][j] = 'P';
                } else if (token.equals("W")) {
                    gridArr[i][j] = 'W';
                } else {
                    throw new InvalidMazeException("Invalid token in maze");
                }
            }
        }

        // check consistency
        // 0. start and end must be within bounds
        if (start[0] < 0 || start[0] >= rows || start[1] < 0 || start[1] >= cols) {
            throw new InvalidMazeException("Start position out of bounds");
        }

        // 1. start and end must not be walls
        if (gridArr[start[0]][start[1]] == 'W') {
            throw new InvalidMazeException("Start position is a wall");
        }
        if (gridArr[end[0]][end[1]] == 'W') {
            throw new InvalidMazeException("End position is a wall");
        }

        // 2. start and end must not be the same
        if (start[0] == end[0] && start[1] == end[1]) {
            throw new InvalidMazeException("Start and end positions are the same");
        }

        // valid maze, create Maze object
        this.maze = new Maze(name, gridArr, start, end);
    }
}

