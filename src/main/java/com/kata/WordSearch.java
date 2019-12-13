package main.java.com.kata;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {
    public List<Coordinate> search(char[][] grid, String target) {
        List<Coordinate> result = new ArrayList<>();
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == target.charAt(0) && (
                        findMatchedHorizontally(grid, target, result, i, j) ||
                        findMatchedHorizontallyBackward(grid, target, result, i, j))){
                    return result;
                }
            }
        }
        return result;
    }

    private boolean findMatchedHorizontally(char[][] grid, String target, List<Coordinate> result, int x, int y) {
            for (int i = 0; i < target.length(); ++i) {
                if (x < grid.length && y < grid[0].length && grid[x][y] == target.charAt(i)) {
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
            if (x < grid.length && y < grid[0].length && grid[x][y] == target.charAt(i)) {
                result.add(new Coordinate(x, y));
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
