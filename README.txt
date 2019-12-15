**************************************************
Author: Guyuan Guo
Email: guyuanguo@gmail.com
Date: 12/15/2019
***************************************************

Word Search Kata

This project is to solve word search problem.

Given a text file consisting of a list of words, and a series of rows of single-character lists representing the word search grid, this program should search for the words in the grid and return a set of x,y coordinates for each word found.

-----------------------------------------------------

File Location:

1. WordSearch class implements a search algorithm to return coordinate of a target if it exists in a given grid

../kata/src/main/java/com/kata/WordSearch.java

2. WordSearchTest class implements a Junit test to practice TDD

../kata/src/test/java/com/kata/WordSearchTest.java

-------------------------------------------------------

Assumptions:

     - if target is null or target is "", return null
     - if target length is less than 2, return "Error: Word must be at least 2 letters long"
     - All characters in target must be upper- case letters
     - if length of target is larger than length of grid, return null.
        Words will never "wrap" around the edges of the grid.
     - if grid is not square, print "Error: The grid is not a square"
     - if there is no target in the grid, return null
     - if there is more than one target in the grid, return the first one that be found


