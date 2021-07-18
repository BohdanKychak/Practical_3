package com.epam.rd.java.basic.practice3;

import java.util.regex.*;

public class Part2 {

    public static void main(String[] args) {

        String input = Util.getInput("part2.txt");
        System.out.print(convert(input));

    }

    public static String convert(String input) {

        Pattern p = Pattern.compile(
                "(?iu)[a-zа-яёіїєэъґ]+"
        );
        Matcher m1 = p.matcher(input);
        String strShortWords = getShortWords(input, m1);

        Matcher m2 = p.matcher(input);
        String strLongWords = getLongWords(input, m2);

        return "Min: " + strShortWords + "Max: " + strLongWords;
    }

    private static String getLongWords(String input, Matcher m) {
        String longestWord = "";
        String[] arrayLongWords = new String[input.length()];
        int index = 0;

        while (m.find()) {

            if (m.group().length() > longestWord.length()) {
                arrayLongWords = new String[arrayLongWords.length];
                longestWord = m.group();
                index = 0;
                arrayLongWords[index] = m.group();
            } else if (m.group().length() == longestWord.length()) {
                boolean wordNotRepeated = true;

                for (String arrayLongWord : arrayLongWords) {
                    if (m.group().equals(arrayLongWord)) {
                        wordNotRepeated = false;
                        break;
                    }

                }
                if (wordNotRepeated) {
                    index++;
                    arrayLongWords[index] = m.group();
                }
            }
        }
        longestWord = getStringWords(longestWord, arrayLongWords);
        return longestWord;
    }

    private static String getShortWords(String input, Matcher m) {
        String shortestWord = "there should be a short word";
        String[] arrayShortWords = new String[input.length()];
        int index = 0;

        while (m.find()) {

            if (m.group().length() < shortestWord.length()) {
                arrayShortWords = new String[arrayShortWords.length];
                shortestWord = m.group();
                index = 0;
                arrayShortWords[index] = m.group();

            } else if (m.group().length() == shortestWord.length()) {
                boolean wordNotRepeated = true;

                for (String arrayShortWord : arrayShortWords) {
                    if (m.group().equals(arrayShortWord)) {
                        wordNotRepeated = false;
                        break;
                    }

                }
                if (wordNotRepeated) {
                    index++;
                    arrayShortWords[index] = m.group();
                }
            }
        }
        shortestWord = getStringWords(shortestWord, arrayShortWords);
        return shortestWord;
    }

    private static String getStringWords(String stringWords, String[] arrayWords) {
        StringBuilder stringWordsBuilder = new StringBuilder(stringWords);
        int j = 1;

        do {
            stringWordsBuilder.append(", ");
            stringWordsBuilder.append(arrayWords[j]);
        } while (arrayWords[++j] != null);

        stringWords = stringWordsBuilder.toString();
        return stringWords + "\n";
    }

}