package com.codewars;

/*
 Snail Sort
Given an n x n array, return the array elements arranged from outermost elements to the middle element, traveling clockwise.

array = [[1,2,3],
         [4,5,6],
         [7,8,9]]
snail(array) #=> [1,2,3,6,9,8,7,4,5]
For better understanding, please follow the numbers of the next array consecutively:

array = [[1,2,3],
         [8,9,4],
         [7,6,5]]
snail(array) #=> [1,2,3,4,5,6,7,8,9]
This image will illustrate things more clearly:

 */

public class Snail {

    public static int[] snail(int[][] array) {
        if(array[0].length == 0) return new int[]{};
        if(array.length == 1) return new int[]{array[0][0]};
        int length = array.length;
        int[] res = new int[length * length];
        int ind = 0;
        int i = 0, j = 0, k = length - 1, l = length - 1;
        while(ind < length * length){
            for(int m = i; m <= k; m++){
                res[ind++] = array[j][m];
            }
            j++;
            for(int m = j; m <= l; m++){
                res[ind++] = array[m][k];
            }
            k--;
            for(int m = k; m >= i; m--){
                res[ind++] = array[l][m];
            }
            l--;
            for(int m = l; m >= j; m--){
                res[ind++] = array[m][i];
            }
            i++;
        }
        return res;
    }
}