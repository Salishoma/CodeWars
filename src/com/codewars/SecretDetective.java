package com.codewars;

/*
* There is a secret string which is unknown to you. Given a collection of random triplets from the string, recover the original string.

A triplet here is defined as a sequence of three letters such that each letter occurs somewhere before the next in the given string. "whi" is a triplet for the string "whatisup".

As a simplification, you may assume that no letter occurs more than once in the secret string.

You can assume nothing about the triplets given to you other than that they are valid triplets and that they contain sufficient information to deduce the original string. In particular, this means that the secret string will never contain letters that do not occur in one of the triplets given to you.

* recoverSecret(new char[][]{
      {'t','u','p'},
      {'w','h','i'},
      {'t','s','u'},
      {'a','t','s'},
      {'h','a','p'},
      {'t','i','s'},
      {'w','h','s'}
    }
    should give "whatisup"
 */

import java.util.*;
import java.util.stream.Collectors;

public class SecretDetective {
    public HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
    public ArrayList<Character> str = new ArrayList<>();
    public HashSet<Character> set = new HashSet<>();
    public String recoverSecret(char[][] triplets) {
        for(int i = 0; i < triplets.length; i++){
            for(int j = 0; j < triplets[0].length; j++){
                ArrayList<Integer> indices = map.computeIfAbsent(triplets[i][j], k -> new ArrayList<Integer>());
                indices.add(i);
            }
        }
        for(int i = 0; i < triplets.length; i++){
            for(int j = 0; j < triplets[i].length; j++){
                if(!set.contains(triplets[i][j])){
                    str.add(triplets[i][j]);
                    traverse(triplets, triplets[i][j]);
                }
            }
        }
        return str.stream().map(String::valueOf).collect(Collectors.joining());
    }

    public void traverse(char[][] triplets, char el){
        if(set.contains(el)) return;
        set.add(el);
        ArrayList<Integer> indices = map.get(el);
        for (Integer index : indices) {
            char[] arr = triplets[index];
            int ind = String.valueOf(arr).indexOf(el);
            for(int i = ind; i >= 0; i--){
                if(!set.contains(triplets[index][i])){
                    str.add(str.indexOf(el), triplets[index][i]);
                    traverse(triplets, triplets[index][i]);
                }
            }
        }
    }
}