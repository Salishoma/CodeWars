package com.codewars;

import java.util.HashMap;

public class Scramblies {

    public static boolean scramble(String str1, String str2) {

        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < str1.length(); i++){
            String s = String.valueOf(str1.charAt(i));
            map.put(s, map.getOrDefault(s, 0) + 1);
            int val = map.get(s);
        }
        for(int i = 0; i < str2.length(); i++){
            String s = String.valueOf(str2.charAt(i));
//            int val = map.get(s);
            if(map.containsKey(s)) {
                map.put(s, map.getOrDefault(s, 0) - 1) ;
                if(map.get(s) == 0){
                    map.remove(s);
                }
            }
            else return false;
        }
        return true;
    }
}
