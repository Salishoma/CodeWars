package com.codewars;

import java.util.*;

public class StripComments {

    public static String stripComments(String text, String[] commentSymbols) {
        HashSet<String> set = new HashSet<>(Arrays.asList(commentSymbols));
        String[] arr = text.split("\n");
        int length = arr.length;
        String res = "";
        for(int i = 0; i < arr.length; i++){
            boolean comment = false;
            String str = "";
            for(int j = 0; j < arr[i].length(); j++){
                if(set.contains(String.valueOf(arr[i].charAt(j)))){
                    comment = true;
                    if(j != arr[i].length() - 1) str = str.stripTrailing();
                    break;
                }
                str += arr[i].charAt(j);
            }
            if(!comment){
                str = str.stripTrailing();
            }
            res += str;
            if(i != length - 1){
                res += "\n";
            }
        }
        return res;
    }
}
