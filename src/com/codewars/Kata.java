package com.codewars;

public class Kata {
    public static String addLetters(String... letters) {
        char sum = 'a' - 1;
        for(int i = 0; i < letters.length; i++){
            sum += letters[i].charAt(0) - 'a' + 1;
            if(sum > 'z'){
                sum -= ('z' - 'a' + 1);
            }
        }
        return Character. toString(sum);
    }
}
