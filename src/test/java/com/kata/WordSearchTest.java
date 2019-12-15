package test.java.com.kata;

import main.java.com.kata.WordSearch;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class WordSearchTest {
    private static final int MAXSIZEOFGRID = 100;
    private static final int MINSIZEOFGRID = 2;
    WordSearch wordSearch;
    char[][] grid;

    @Before
    public void setTest(){
        wordSearch = new WordSearch();
        grid = new char[][]{{'U', 'M', 'K', 'H', 'U', 'L', 'K', 'I', 'N', 'V', 'J', 'O', 'C', 'W', 'E'},
                {'L', 'L', 'S', 'H', 'K', 'Z', 'Z', 'W', 'Z', 'C', 'G', 'J', 'U', 'Y', 'G'},
                {'H', 'S', 'U', 'P', 'J', 'P', 'R', 'J', 'D', 'H', 'S', 'B', 'X', 'T', 'G'},
                {'B', 'R', 'J', 'S', 'O', 'E', 'Q', 'E', 'T', 'I', 'K', 'K', 'G', 'L', 'E'},
                {'A', 'Y', 'O', 'A', 'G', 'C', 'I', 'R', 'D', 'Q', 'H', 'R', 'T', 'C', 'D'},
                {'S', 'C', 'O', 'T', 'T', 'Y', 'K', 'Z', 'R', 'E', 'P', 'P', 'X', 'P', 'F'},
                {'B', 'L', 'Q', 'S', 'L', 'N', 'E', 'E', 'E', 'V', 'U', 'L', 'F', 'M', 'Z'},
                {'O', 'K', 'R', 'I', 'K', 'A', 'M', 'M', 'R', 'M', 'F', 'B', 'A', 'P', 'P'},
                {'N', 'U', 'I', 'I', 'Y', 'H', 'Q', 'M', 'E', 'M', 'Q', 'R', 'Y', 'F', 'S'},
                {'E', 'Y', 'Z', 'Y', 'G', 'K', 'Q', 'J', 'P', 'C', 'Q', 'W', 'Y', 'A', 'K'},
                {'S', 'J', 'F', 'Z', 'M', 'Q', 'I', 'B', 'D', 'B', 'E', 'M', 'K', 'W', 'D'},
                {'T', 'G', 'L', 'B', 'H', 'C', 'B', 'E', 'C', 'H', 'T', 'O', 'Y', 'I', 'K'},
                {'O', 'J', 'Y', 'E', 'U', 'L', 'N', 'C', 'C', 'L', 'Y', 'B', 'Z', 'U', 'H'},
                {'W', 'Z', 'M', 'I', 'S', 'U', 'K', 'U', 'R', 'B', 'I', 'D', 'U', 'X', 'S'},
                {'K', 'Y', 'L', 'B', 'Q', 'Q', 'P', 'M', 'D', 'F', 'C', 'K', 'E', 'A', 'B'}};
        //grid = generateRandomGrid();
    }

    // Randomly Generate a n * n grid, n >= 2
    private char[][] generateRandomGrid(){
        Random r = new Random();
        int n = MINSIZEOFGRID + r.nextInt(MAXSIZEOFGRID - MINSIZEOFGRID);
        char[][] grid = new char[n][n];
        char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
                'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                grid[i][j] = letters[r.nextInt(letters.length)];
            }
        }
        return grid;
    }

    @Test
    public void whenTargetExistHorizontallyReturnTheCoordinate(){
        assertNull(wordSearch.search(grid, ""));
        assertNull(null, wordSearch.search(grid, "ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
        assertEquals("SCOTTY: (0,5),(1,5),(2,5),(3,5),(4,5),(5,5)",
                wordSearch.search(grid, "SCOTTY"));
    }

    @Test
    public void whenTargetExistHorizontallyBackwardReturnTheCoordinate(){
        assertNull(wordSearch.search(grid, ""));
        assertNull(null, wordSearch.search(grid, "ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
        assertEquals("KIRK: (4,7),(3,7),(2,7),(1,7)",
                wordSearch.search(grid, "KIRK").toString());
    }

    @Test
    public void whenTargetExistVerticallyReturnTheCoordinate(){
        assertNull(wordSearch.search(grid, ""));
        assertNull(null, wordSearch.search(grid, "ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
        assertEquals("BONES: (0,6),(0,7),(0,8),(0,9),(0,10)",
                wordSearch.search(grid, "BONES").toString());
    }

    @Test
    public void whenTargetExistVerticallyBackwardReturnTheCoordinate(){
        assertNull(wordSearch.search(grid, ""));
        assertNull(null, wordSearch.search(grid, "ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
        assertEquals("KHAN: (5,9),(5,8),(5,7),(5,6)",
                wordSearch.search(grid, "KHAN").toString());
    }

    @Test
    public void whenTargetExistAscendingReturnTheCoordinate(){
        assertNull(wordSearch.search(grid, ""));
        assertNull(null, wordSearch.search(grid, "ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
        assertEquals("LM: (0,1),(1,0)",
                wordSearch.search(grid, "LM").toString());
    }

    @Test
    public void whenTargetExistAscendingBackwardReturnTheCoordinate(){
        assertNull(wordSearch.search(grid, ""));
        assertNull(null, wordSearch.search(grid, "ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
        assertEquals("SULU: (3,3),(2,2),(1,1),(0,0)",
                wordSearch.search(grid, "SULU").toString());
    }

    @Test
    public void whenTargetExistDescendingReturnTheCoordinate(){
        assertNull(wordSearch.search(grid, ""));
        assertNull(null, wordSearch.search(grid, "ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
        assertEquals("SPOCK: (2,1),(3,2),(4,3),(5,4),(6,5)",
                wordSearch.search(grid, "SPOCK").toString());
    }

    @Test
    public void whenTargetExistDescendingBackwardReturnTheCoordinate(){
        assertNull(wordSearch.search(grid, ""));
        assertNull(null, wordSearch.search(grid, "ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
        assertEquals("UHURA: (4,0),(3,1),(2,2),(1,3),(0,4)",
                wordSearch.search(grid, "UHURA").toString());
    }
}
