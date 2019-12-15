package main.java.com.kata;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {
    /*Assumption:
     - if target is null or target is "", return null
     - if length of target is larger than length of grid, return null.
        Words will never "wrap" around the edges of the grid.
     - if grid is not square, print "Error: The grid is not a square"
     - if there is no target in the grid, return null
     - if there is more than one target in the grid, return the first one that be found
     */
    public String search(char[][] grid, String target) {
        if (grid.length != grid[0].length) {
            return "Error: The grid is not a square";
        }
        if (target == null || target.length() == 0 || target.length() > grid.length) {
            return null;
        }
        List<Coordinate> result = new ArrayList<>();
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == target.charAt(0) && (
                        findMatchedHorizontally(grid, target, result, i, j) ||
                        findMatchedHorizontallyBackward(grid, target, result, i, j) ||
                        findMatchedVertically(grid, target, result, i, j)) ||
                        findMatchedVerticallyBackward(grid, target, result, i, j) ||
                        findMatchedAscending(grid, target, result, i, j) ||
                        findMatchedAscendingBackward(grid, target, result, i, j) ||
                        findMatchedDescending(grid, target, result, i, j) ||
                        findMatchedDescendingBackward(grid, target, result, i, j)) {
                    return printListOfResult(result, target);
                }
            }
        }
        return null;
    }

    //Print result in required format
    private String printListOfResult(List<Coordinate> list, String target) {
        StringBuilder sb = new StringBuilder();
        sb.append(target);
        sb.append(": ");
        for (Coordinate c : list) {
            sb.append(c);
            sb.append(",");
        }
        // Delete the "," at the end of StringBuiler s
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private boolean findMatchedHorizontally(char[][] grid, String target, List<Coordinate> result, int x, int y) {
         for (int i = 0; i < target.length(); ++i) {
                if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == target.charAt(i)) {
                    result.add(new Coordinate(x, y));
                    y++;
                } else {
                    result.clear();
                    return false;
                }
            }
            return true;
    }

    private boolean findMatchedHorizontallyBackward(char[][] grid, String target, List<Coordinate> result, int x, int y) {
        for (int i = 0; i < target.length(); ++i) {
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == target.charAt(i)) {
                result.add(new Coordinate(x, y));
                y--;
            } else {
                result.clear();
                return false;
            }
        }
        return true;
    }

    private boolean findMatchedVertically(char[][] grid, String target, List<Coordinate> result, int x, int y) {
        for (int i = 0; i < target.length(); ++i) {
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == target.charAt(i)) {
                result.add(new Coordinate(x, y));
                x++;
            } else {
                result.clear();
                return false;
            }
        }
        return true;
    }

    private boolean findMatchedVerticallyBackward(char[][] grid, String target, List<Coordinate> result, int x, int y) {
        for (int i = 0; i < target.length(); ++i) {
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == target.charAt(i)) {
                result.add(new Coordinate(x, y));
                x--;
            } else {
                result.clear();
                return false;
            }
        }

        return true;
    }

    private boolean findMatchedAscending(char[][] grid, String target, List<Coordinate> result, int x, int y) {
        for (int i = 0; i < target.length(); ++i) {
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == target.charAt(i)) {
                result.add(new Coordinate(x, y));
                x--;
                y++;
            } else {
                result.clear();
                return false;
            }
        }
        return true;
    }

    private boolean findMatchedAscendingBackward(char[][] grid, String target, List<Coordinate> result, int x, int y) {
        for (int i = 0; i < target.length(); ++i) {
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == target.charAt(i)) {
                result.add(new Coordinate(x, y));
                x--;
                y--;
            } else {
                result.clear();
                return false;
            }
        }
        return true;
    }

    private boolean findMatchedDescending(char[][] grid, String target, List<Coordinate> result, int x, int y) {
        for (int i = 0; i < target.length(); ++i) {
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == target.charAt(i)) {
                result.add(new Coordinate(x, y));
                x++;
                y++;
            } else {
                result.clear();
                return false;
            }
        }
        return true;
    }

    private boolean findMatchedDescendingBackward(char[][] grid, String target, List<Coordinate> result, int x, int y) {
        for (int i = 0; i < target.length(); ++i) {
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == target.charAt(i)) {
                result.add(new Coordinate(x, y));
                x++;
                y--;
            } else {
                result.clear();
                return false;
            }
        }
        return true;
    }

    class Coordinate {
        int x;
        int y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + y + "," + x + ")";
        }
    }
}
