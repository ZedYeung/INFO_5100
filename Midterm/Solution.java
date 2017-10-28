import java.util.*;

public class Solution {
public static ArrayList<Cell> findPath(int[][] maze){
        int m = maze.length;
        int n = maze[0].length;
        ArrayList<Cell> path = new ArrayList();

        int i=0;
        int j=0;

        path.add(new Cell(0,0));

        while (i<m-1 || j<n-1) {
                Cell current = new Cell(i, j);
                Cell last = path.get(path.size() - 1);

                if (i != m-1 && j != n-1) {
                        if (maze[i][j+1] == 1) {
                                j++;
                                if (last.x != current.x || last.y != current.y) {
                                        path.add(current);
                                }

                        }  else if (maze[i+1][j] == 1) {
                                i++;
                                if (last.x != current.x || last.y != current.y) {
                                        path.add(current);
                                }
                        } else {
                                path.remove(path.size() - 1);
                                maze[i][j] = 0;
                                i = last.x;
                                j = last.y;
                        }
                } else if (i==m-1) {
                        if (maze[i][j+1] == 1) {
                                j++;
                                if (last.x != current.x || last.y != current.y) {
                                        path.add(current);
                                }
                        } else {
                                path.remove(path.size() - 1);
                                maze[i][j] = 0;
                                i = last.x;
                                j = last.y;
                        }
                } else {
                        if (maze[i+1][j] == 1) {
                                i++;
                                if (last.x != current.x || last.y != current.y) {
                                        path.add(current);
                                }
                        } else {
                                path.remove(path.size() - 1);
                                maze[i][j] = 0;
                                i = last.x;
                                j = last.y;
                        }
                }
                if (path.isEmpty()) {
                  return path;
                }
        }
        path.add(new Cell(m-1, n-1));
        return path;
}

public static void main(String[] args) {
        int[][] matrix = {{1, 0, 0, 0},
                          {1, 1, 1, 1},
                          {0, 1, 0, 0},
                          {1, 1, 1, 1}};
          int[][] dead =   {{1, 0, 0, 0},
                            {1, 1, 1, 1},
                            {0, 1, 0, 0},
                            {1, 1, 0, 1}};
        System.out.println(findPath(matrix));
        System.out.println(findPath(dead));
}
}
