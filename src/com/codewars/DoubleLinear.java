package com.codewars;

import java.util.ArrayList;

public class DoubleLinear {

    public static int dblLinear (int n) {
        int i = 0, j = 0, eq = 0;
        ArrayList<Integer> linear = new ArrayList<>();
        linear.add(1);
        while(i + j < n + eq){
            int two = 2 * linear.get(i) + 1;
            int three = 3 * linear.get(j) + 1;
            if(two < three){
                linear.add(two);
                i++;
            }else if(two > three){
                linear.add(three);
                j++;
            }else{
                linear.add(two);
                i++;
                j++;
                eq++;
            }
        }
        return linear.get(linear.size() - 1);
    }
}
