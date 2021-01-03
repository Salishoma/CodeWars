package com.codewars;

/*
* Write a function that accepts a square matrix (N x N 2D array) and returns the determinant of the matrix.

How to take the determinant of a matrix -- it is simplest to start with the smallest cases:

A 1x1 matrix |a| has determinant a.

A 2x2 matrix [ [a, b], [c, d] ] or

|a  b|
|c  d|
has determinant: a*d - b*c.

The determinant of an n x n sized matrix is calculated by reducing the problem to the calculation of the determinants of n matrices ofn-1 x n-1 size.

For the 3x3 case, [ [a, b, c], [d, e, f], [g, h, i] ] or

|a b c|
|d e f|
|g h i|
the determinant is: a * det(a_minor) - b * det(b_minor) + c * det(c_minor) where det(a_minor) refers to taking the determinant of the 2x2 matrix created by crossing out the row and column in which the element a occurs:

|- - -|
|- e f|
|- h i|
Note the alternation of signs.

The determinant of larger matrices are calculated analogously, e.g. if M is a 4x4 matrix with first row [a, b, c, d], then:

det(M) = a * det(a_minor) - b * det(b_minor) + c * det(c_minor) - d * det(d_minor)

*/

public class MatrixDeterminant {

    public static int determinant(int[][] matrix) {
        if(matrix.length == 1) return matrix[0][0];
        int sum = 0;
        for(int i = 0; i < matrix[0].length; i++){
            int[][] arr1 = new int[matrix.length - 1][matrix[0].length - 1];
            int m = 0;
            for(int j = 1; j < matrix.length; j++){
                int[] arr2 = new int[matrix[0].length - 1];
                int l = 0;
                for(int k = 0; k < matrix[0].length; k++){
                    if(k != i){
                        arr2[l] = matrix[j][k];
                        l++;
                    }
                }
                arr1[m] = arr2.clone();
                m++;
            }
            sum += (i % 2 == 0 ? 1 : -1) * matrix[0][i] * determinant(arr1);
        }
        return sum;
    }
}
