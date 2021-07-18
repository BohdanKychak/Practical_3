package com.company.test.qqq;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

public class test6 {

    private static String text = "He play football every day. Every boy play football. Day is sun today. We will play today.";

    public static void main(String[] args) {

        Pattern p = Pattern.compile(
                "(?<!alpha)alpha+(?!alpha)".replace("alpha",
                        "[a-zA-Z\u0080-\u9fff]"), Pattern.UNICODE_CHARACTER_CLASS
        );
        Matcher m = p.matcher(text);
        Matcher m1 = p.matcher(text);

        String[] s = new String[text.length()];
        String[] rs = new String[text.length()];
        int indexS = 0,indexRS = 0, x=0;
        boolean b = true;
        while (m.find()) {
            b = true;
            for (int i = 0; i < text.length(); i++) {

                if (m.group().equalsIgnoreCase(s[i])) {
                    b = false;
                    break;
                }
            }
            if (b) {
                s[indexS] = m.group();
                indexS++;
            }
            if (!b){
                rs[indexRS]=m.group();
                indexRS++;
            }
        }
        //    System.out.print(Arrays.toString(rs));

        boolean b2=false;
        StringBuilder str = new StringBuilder();
        while (m1.find()){
            if(m1.hitEnd()){
                str.append(" ");
            }
            b2=false;
            for (int i = 0; i < rs.length; i++) {
                if (m1.group().equalsIgnoreCase(rs[i])) {
                    b2 = true;
                    break;
                }
            }
            if (b2){
                str.append("_").append(m1.group());
            } else {
                str.append(m1.group());
            }
        }
        System.out.print(str);

    }

}
