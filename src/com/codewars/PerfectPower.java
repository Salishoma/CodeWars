package com.codewars;

public class PerfectPower {
    public static int[] isPerfectPower(int n) {

        for(double i = 2; i < 31; i++){
            double root = Math.round(Math.pow(n, 1 / i) * 100000d) / 100000d ;
            if(root < 2) return null;
            if(n % root == 0){
                return new int[]{(int)root, (int)i};
            }
        }
        return null;
    }
}