# KnightMoves

To solve this problem, I chose the Breadth First Search (BFS) algorithm. A knight can move 2 stepa in any it's cardinal positions and then 1 step to the left or to the right. At any given time, there are 8 potential cells (x,y) that a knight can land on provided that the cell is within the bounds of the chessboard. The idea behind using BFS is that we check all possible cells at any given level in the same pass. If we find the destination cell that we are looking for, the distance will always be the same at that level no matter which direction the cell is. As we go to the deeper levels, we keep incrementing the distance till the destination is found. If the destination cannot be found, which will be established since we will go out of the chess board bounds, we return -1 indicating that no path exists from the source to the destination.

To test the function, follow the steps below:

1) Clone the public repo. It is a simple Java program.
2) Open the project in the IDE of your choice.
3) Open the KnightMoves.java file.
4) Run the main function. Note that the program terminates after each execution. Please re-run the program to try with different input values.

Please note that I have added simple checks on each of the inputs. 
1) You need to specify a non-negative (>0) input for the chess board size. The chess board being a square will have the same number of rows and columns. 
2) You need to specify a postive value for each of source_x, source_y,destination_x and destination_y co-ordinate values.
3) If your postive co-ordinate values exceed any of the boundary conditions, the program will return a -1.
4) If your postivie co-ordinate values are within bounds and if a path exists, the program will return the minimum path. If not, it will return a -1.
