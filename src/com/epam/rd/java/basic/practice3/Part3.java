package com.epam.rd.java.basic.practice3;

import java.util.regex.*;

public class Part3 {

    public static void main(String[] args) {

        String input = Util.getInput("part3.txt");
        System.out.print(convert(input));

    }

    public static String convert(String input) {
        String str = "";
        Pattern p = Pattern.compile("((?iu)[a-zа-яёіїєэъґ])(\\S\\S+)");
        Matcher m = p.matcher(input);

        StringBuffer answer = new StringBuffer();
        while (m.find()) {
            String word = "";
            if (m.group(1).equals(m.group(1).toLowerCase())) {
                word = m.group(1).toUpperCase() + m.group(2);
            }
            if (m.group(1).equals(m.group(1).toUpperCase())) {
                word = m.group(1).toLowerCase() + m.group(2);
            }
            m.appendReplacement(answer, word);
        }
        m.appendTail(answer);

        return str + answer;
    }
}
