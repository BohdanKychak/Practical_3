package com.epam.rd.java.basic.practice3;

import java.util.regex.*;

public class Part6 {

    public static void main(String[] args) {

        String input = Util.getInput("part6.txt");
        System.out.print(convert(input));

    }

    public static String convert(String input) {
        String str = "";

        Pattern p = Pattern.compile("(?iu)[a-zа-яёіїєэъґ]+");
        StringBuffer answer = new StringBuffer();

        String[] wordsRepeated = getArrayOfRepetitiveWords(input, p);

        Matcher m2 = p.matcher(input);
        while (m2.find()) {
            boolean b = true;
            String word = m2.group();
            for (String s : wordsRepeated) {
                if (word.equals(s)) {
                    b = false;
                    break;
                }
            }
            if (!b) {
                m2.appendReplacement(answer, "_" + word);
            }
        }
        m2.appendTail(answer);

        return str + answer;
    }

    private static String[] getArrayOfRepetitiveWords(String input, Pattern p) {
        Matcher m1 = p.matcher(input);
        String[] newWords = new String[p.flags()];
        String[] wordsRepeated = new String[p.flags()];
        int index1 = 0, index2 = 0;
        while (m1.find()) {
            boolean notRepeated = true;
            for (String s : newWords) {
                if (m1.group().equals(s)) {
                    notRepeated = false;
                    break;
                }
            }
            if (notRepeated) {
                newWords[index1] = m1.group();
                index1++;
            } else {
                wordsRepeated[index2] = m1.group();
                index2++;
            }
        }
        return wordsRepeated;
    }
}
