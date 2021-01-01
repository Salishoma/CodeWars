package com.codewars;

import java.util.Arrays;

public class NextSmallerElement {

    public static long nextSmaller(long n)
    {
        System.out.println(n);
        char[] num = Long.toString(n).toCharArray();
        int k = 0;
        int m = 0;
        long cur = 0;
        boolean swap = false;
        for(int i = num.length - 1; i > 0; i--){
            char[] newArr = Arrays.copyOf(Long.toString(n).toCharArray(), num.length);
            for(int j = i - 1; j >= 0; j--){
                if(newArr[i] < newArr[j]){
                    swapArray(newArr, i, j);
                    m = j + 1;
                    swap = true;
                    break;
                }
            }
            long newNum = Long.parseLong(new String(newArr));
            if(cur < newNum && newNum < n){
                cur = newNum;
                num = Arrays.copyOf(newArr, num.length);
                k = m;
            }
        }
        if(!swap || num[0] == '0' || cur == n){
            return -1;
        }
        int j = num.length - 1;
        while(k < j){
            int l = k;
            for(int i = k + 1; i <= j; i++){
                if(num[l] < num[i]){
                    swapArray(num, i, l);
                }
                l = i;
            }
            j--;
        }
        String str = new String(num);
        return Long.parseLong(str);
    }
    public static void swapArray(char[] arr, int x,int y){
        char temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
