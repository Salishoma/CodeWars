package com.codewars;

import java.util.*;
public class TopWords {

    public static List<String> top3(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        String[] words = s.split("[^a-zA-Z']+");
        int first = 0, second = 0, third = 0;
        String firstWord = null, secondWord = null, thirdWord = null;
        for (String value : words) {
            String word = value.toLowerCase();
            boolean hasLetter = word.matches(".*[a-z]+.*");
            if(word.equals("")|| !hasLetter) continue;
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()){
            int num = entry.getValue();
            if(num > first){
                third = second;
                second = first;
                first = num;
                thirdWord = secondWord;
                secondWord = firstWord;
                firstWord = entry.getKey();
            }else if(num > second){
                third = second;
                second = num;
                thirdWord = secondWord;
                secondWord = entry.getKey();
            }else if(num > third){
                third = num;
                thirdWord = entry.getKey();
            }
        }

        String[] a = firstWord == null ? new String[]{} : secondWord == null ? new String[]{firstWord} : thirdWord == null ?
                new String[]{firstWord, secondWord} : new String[]{firstWord, secondWord, thirdWord};
        return Arrays.asList(a);
    }
}
