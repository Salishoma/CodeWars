package com.codewars;

public class IpAddress {

    public static String longToIP(long ip) {
        if(ip == 0) return "0.0.0.0";
        int count = 0;
        String res = "";
        double sum = 0;
        int dot = 0;
        while(ip > 0){
            sum += (ip % 2) * Math.pow(2, count);
            ip /= 2;
            count++;
            if(count == 8 && ip > 0){
                count = 0;
                res = (int)sum + (res.equals("") ?  res :  "." + res);
                dot++;
                sum = 0;
            }
        }
        if(sum != 0) res = (int)sum + (res.equals("") ?  res :  "." + res);
        dot++;
        while(dot <= 3){
            res = "0." + res;
            dot++;
        }
        return res;
    }
}
