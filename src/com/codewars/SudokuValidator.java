package com.codewars;

/*

Sudoku Background
Sudoku is a game played on a 9x9 grid. The goal of the game is to fill all cells of the grid with digits from 1 to 9, so that each column, each row, and each of the nine 3x3 sub-grids (also known as blocks) contain all of the digits from 1 to 9.
(More info at: http://en.wikipedia.org/wiki/Sudoku)

Sudoku Solution Validator
Write a function validSolution/ValidateSolution/valid_solution() that accepts a 2D array representing a Sudoku board, and returns true if it is a valid solution, or false otherwise. The cells of the sudoku board may also contain 0's, which will represent empty cells. Boards containing one or more zeroes are considered to be invalid solutions.

The board is always 9 cells by 9 cells, and every cell only contains integers from 0 to 9.

Examples
validSolution([
  [5, 3, 4, 6, 7, 8, 9, 1, 2],
  [6, 7, 2, 1, 9, 5, 3, 4, 8],
  [1, 9, 8, 3, 4, 2, 5, 6, 7],
  [8, 5, 9, 7, 6, 1, 4, 2, 3],
  [4, 2, 6, 8, 5, 3, 7, 9, 1],
  [7, 1, 3, 9, 2, 4, 8, 5, 6],
  [9, 6, 1, 5, 3, 7, 2, 8, 4],
  [2, 8, 7, 4, 1, 9, 6, 3, 5],
  [3, 4, 5, 2, 8, 6, 1, 7, 9]
]); // => true
validSolution([
  [5, 3, 4, 6, 7, 8, 9, 1, 2],
  [6, 7, 2, 1, 9, 0, 3, 4, 8],
  [1, 0, 0, 3, 4, 2, 5, 6, 0],
  [8, 5, 9, 7, 6, 1, 0, 2, 0],
  [4, 2, 6, 8, 5, 3, 7, 9, 1],
  [7, 1, 3, 9, 2, 4, 8, 5, 6],
  [9, 0, 1, 5, 3, 7, 2, 1, 4],
  [2, 8, 7, 4, 1, 9, 6, 3, 5],
  [3, 0, 0, 4, 8, 1, 1, 7, 9]
]); // => false

 */


import java.util.*;

public class SudokuValidator {
    public static boolean check(int[][] sudoku) {

        int i = 0, j = 0;
        while(i < 9){
            HashSet<Integer> threes = new HashSet<>();
            if(
                !isValid(sudoku , i, j, threes) ||
                !isValid(sudoku , i, j + 1, threes) ||
                !isValid(sudoku , i, j + 2, threes) ||
                !isValid(sudoku , i + 1, j, threes) ||
                !isValid(sudoku , i + 1, j + 1, threes) ||
                !isValid(sudoku , i + 1, j + 2, threes) ||
                !isValid(sudoku , i + 2, j, threes) ||
                !isValid(sudoku , i + 2, j + 1, threes) ||
                !isValid(sudoku , i + 2, j + 2, threes)) return false;
            j += 3;
            if(j >= 9){
                j = 0;
                i += 3;
            }
        }

        for(i = 0; i < sudoku[0].length; i++){
            HashSet<Integer> h = new HashSet<>();
            if(
                !isValid(sudoku , i, 0, h) ||
                !isValid(sudoku , i, 1, h) ||
                !isValid(sudoku , i, 2, h) ||
                !isValid(sudoku , i, 3, h) ||
                !isValid(sudoku , i, 4, h) ||
                !isValid(sudoku , i, 5, h) ||
                !isValid(sudoku , i, 6, h) ||
                !isValid(sudoku , i, 7, h) ||
                !isValid(sudoku , i, 8, h)
            ) return false;
        }

        for(i = 0; i < sudoku.length; i++){
            HashSet<Integer> v = new HashSet<>();
            if(
                !isValid(sudoku , 0, i, v) ||
                !isValid(sudoku , 1, i, v) ||
                !isValid(sudoku , 2, i, v) ||
                !isValid(sudoku , 3, i, v) ||
                !isValid(sudoku , 4, i, v) ||
                !isValid(sudoku , 5, i, v) ||
                !isValid(sudoku , 6, i, v) ||
                !isValid(sudoku , 7, i, v) ||
                !isValid(sudoku , 8, i, v)
            ) return false;
        }
        return true;
    }

    public static boolean isValid(int[][] board, int x, int y, HashSet<Integer> threes){
        if(threes.contains(board[x][y]) || board[x][y] == 0) return false;
        threes.add(board[x][y]);
        return true;
    }
}
