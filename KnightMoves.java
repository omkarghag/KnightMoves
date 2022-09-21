import java.util.*;

class Cell {
    int posX, posY, dist; // each cell with x and y co-ordinates and distance 'dist' from the source.

    public Cell(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }
}

public class KnightMoves {
    // moves array contain the possible co-ordinates which determines where a knight can possibly land
    int[][] moves = new int[][]{{2, -1}, {2, 1}, {-2, -1}, {-2, 1}, // x ((moves 2 or -2) and (+1 or -1))
            {1, 2}, {1, -2}, {-1, -2}, {-1, 2}}; // y ((moves 2 or -2) and (+1 or -1))
    public int calculatePath(boolean[][] board, int source_x, int source_y, int dest_x, int dest_y) {

        // check if the x co-ordinates are valid and on the chess board.
        if (source_x < 0 || source_x >= board.length  || dest_x < 0 || dest_x >= board.length) {
            System.out.println("Input X co-ordinate(s) not found on the chess board");
            return -1;
        }
        // check if the y co-ordinates are valid and on the chess board.
        if (source_y < 0 || source_y >= board.length || dest_y < 0 || dest_y >= board.length) {
            System.out.println("Input Y co-ordinate(s) not found on the chess board");
            return -1;
        }
        // Following is an implementation of the bfs algorithm to determine the minimum path
        // a knight can take to reach from input source to input destination.
        Cell cell = new Cell(source_x, source_y);
        board[source_x][source_y] = true;
        Queue<Cell> visitedCells = new LinkedList<>();
        visitedCells.add(cell);
        while (!visitedCells.isEmpty()) {
            Cell currentCell = visitedCells.poll();
            // If the current cell is the destination cell, return the distance.
            if (currentCell.posX == dest_x && currentCell.posY == dest_y) {
                return currentCell.dist + 1;
            }
            // perform bfs
            for (int[] move: moves) {
                // new_x and new_y are the cell new co-ordinates when a knight moves to
                // 1 of it's 8 possible destinations
                int new_x = currentCell.posX + move[0];
                int new_y = currentCell.posY + move[1];

                // check if the new co-ordinates in within bounds and mark them as visited while
                // incrementing the distance by 1.
                if (new_x >= 0 && new_y >= 0 && new_x < board.length && new_y < board[0].length && !board[new_x][new_y]) {
                    Cell newCell = new Cell(new_x, new_y);
                    newCell.dist = currentCell.dist + 1;
                    visitedCells.add(newCell);
                    board[new_x][new_y] = true;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        boolean [][] chessBoard;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter chess board size");
        int size;
        int rows = -1;
        int columns = -1;
        int source_x = -1;
        int source_y = -1;
        int dest_x = -1;
        int dest_y = -1;
        try {
            size = Integer.parseInt(in.nextLine());
            if (size <= 0) {
                System.out.println("Board size must be positive");
                System.exit(0);
            }
            rows = size;
            columns = size;
        } catch (NumberFormatException e) {
            System.out.println("Board size must be a number, run the program again with valid input");
            System.exit(0);
        }
        System.out.println("Enter source x co-ordinate");
        try {
            source_x = Integer.parseInt(in.nextLine());
            if (source_x < 0) {
                System.out.println("Source x co-ordinate must be non-negative");
                System.exit(0);
            }
        } catch (NumberFormatException e) {
            System.out.println("Source x co-ordinate must be a number, run the program again with valid input");
            System.exit(0);
        }
        System.out.println("Enter source y co-ordinate");
        try {
            source_y = Integer.parseInt(in.nextLine());
            if (source_y < 0) {
                System.out.println("Source y co-ordinate must be non-negative");
                System.exit(0);
            }
        } catch (NumberFormatException e) {
            System.out.println("Source y co-ordinate must be a number, run the program again with valid input");
            System.exit(0);
        }
        System.out.println("Enter destination x co-ordinate");
        try {
            dest_x = Integer.parseInt(in.nextLine());
            if (dest_x < 0) {
                System.out.println("Destination x co-ordinate must be non-negative");
                System.exit(0);
            }
        } catch (NumberFormatException e) {
            System.out.println("Destination x co-ordinate must be a number, run the program again with valid input");
            System.exit(0);
        }
        System.out.println("Enter destination y co-ordinate");
        try {
            dest_y = Integer.parseInt(in.nextLine());
            if (dest_y < 0) {
                System.out.println("Destination y co-ordinate must be non-negative");
                System.exit(0);
            }
        } catch (NumberFormatException e) {
            System.out.println("Destination y co-ordinate must be a number, run the program again with valid input");
            System.exit(0);
        }
        // chessBoard is a boolean 2-D array so that whenever a cell is visited, it mark it true
        // and do not process it again during our bfs.
        chessBoard = new boolean[rows][columns];
        KnightMoves km = new KnightMoves();
        int result = km.calculatePath(chessBoard, source_x, source_y, dest_x, dest_y);
        System.out.println("Minimum path from source to destination: " + result);
        System.out.println("Exiting the program, please re-run if you want to try again");
    }
}
