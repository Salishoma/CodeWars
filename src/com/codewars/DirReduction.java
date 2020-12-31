package com.codewars;

import java.util.*;
public class DirReduction {
    public static String[] dirReduc(String[] arr) {
        ArrayList<String> arrlist = new ArrayList<String>();
        for (String s : arr) {
            String last = arrlist.size() == 0 ? "" : arrlist.get(arrlist.size() - 1);
            switch (s) {
                case "NORTH":
                    if(last.equals("SOUTH")){
                        arrlist.remove(arrlist.size() - 1);
                    }else{
                        arrlist.add("NORTH");
                    }
                    break;
                case "SOUTH":
                    if(last.equals("NORTH")){
                        arrlist.remove(arrlist.size() - 1);
                    }else{
                        arrlist.add("SOUTH");
                    }
                    break;
                case "EAST":
                    if(last.equals("WEST")){
                        arrlist.remove(arrlist.size() - 1);
                    }else{
                        arrlist.add("EAST");
                    }
                    break;
                default:
                    if(last.equals("EAST")){
                        arrlist.remove(arrlist.size() - 1);
                    }else{
                        arrlist.add("WEST");
                    }
                    break;
            }
        }
        String[] res = new String[arrlist.size()];
        return arrlist.toArray(res);
    }
}