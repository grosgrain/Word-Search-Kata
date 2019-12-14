package test.java.com.kata;

import main.java.com.kata.WordSearch;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordSearchTest {
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
    }

    @Test
    public void whenTargetExistHorizontallyReturnTheCoordinate(){
        assertEquals("[(0,5), (1,5), (2,5), (3,5), (4,5), (5,5)]",
                wordSearch.search(grid, "SCOTTY").toString());
    }

    @Test
    public void whenTargetExistHorizontallyBackwardReturnTheCoordinate(){
        assertEquals("[(4,7), (3,7), (2,7), (1,7)]",
                wordSearch.search(grid, "KIRK").toString());
    }

    @Test
    public void whenTargetExistVerticallyReturnTheCoordinate(){
        assertEquals("[(0,6), (0,7), (0,8), (0,9), (0,10)]",
                wordSearch.search(grid, "BONES").toString());
    }

    @Test
    public void whenTargetExistVerticallyBackwardReturnTheCoordinate(){
        assertEquals("[(5,9), (5,8), (5,7), (5,6)]",
                wordSearch.search(grid, "KHAN").toString());
    }
}
