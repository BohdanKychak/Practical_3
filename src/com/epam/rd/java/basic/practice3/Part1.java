package com.epam.rd.java.basic.practice3;

import java.util.regex.*;

public class Part1 {

    public static void main(String[] args) {

        String input = Util.getInput("part1.txt");

        System.out.println(convert1(input));
        System.out.println();
        System.out.println(convert2(input));
        System.out.println();
        System.out.println(convert3(input));
        System.out.println();
        System.out.println(convert4(input));

    }

    public static String convert1(String input) {
        StringBuilder result = new StringBuilder();
        Pattern p = Pattern.compile(
                "(\\S+);(\\S+\\s\\S+);(\\S+@\\S+)"
        );
        Matcher m = p.matcher(input);

        while (m.find()) {
            result.append(m.group(1)).append(": ").append(m.group(3)).append("\n");
        }
//        result = new StringBuilder(result.substring(0, result.length() - 1));

        return result.toString();
    }

    public static String convert2(String input) {
        StringBuilder result = new StringBuilder();
        Pattern p = Pattern.compile(
                "(\\S+);(\\S+)\\s(\\S+);(\\S+@\\S+)"
        );
        Matcher m = p.matcher(input);

        while (m.find()) {
            result.append(m.group(3)).append("\s").append(m.group(2)).append(" (email: ").append(m.group(4)).append(")\n");
        }
        result = new StringBuilder(result.substring(0, result.length() - 1));

        return result.toString();
    }

    public static String convert3(String input) {
        String pointer = " ==> ";
        StringBuilder result1 = new StringBuilder("mail.com" + pointer);
        StringBuilder result2 = new StringBuilder("google.com" + pointer);

        Pattern p = Pattern.compile(
                "(\\S+)(;\\S+\\s\\S+;\\S+)(@\\S+)");
        Matcher m = p.matcher(input);

        while (m.find()) {
            if (m.group(3).equals("@mail.com")) {
                result1.append(m.group(1)).append(", ");
                continue;
            }
            if (m.group(3).equals("@google.com")) {
                result2.append(m.group(1)).append(", ");
            }
        }
        result1 = new StringBuilder(result1.substring(0, result1.length() - 2));
        result2 = new StringBuilder(result2.substring(0, result2.length() - 2));

        return result1 + "\n" + result2;
    }

    public static String convert4(String input) {
        StringBuilder result = new StringBuilder("Login;Name;Email;Password");

        Pattern p = Pattern.compile(
                "(\\S+);(\\S+\\s\\S+);(\\S+@\\S+)"
        );
        Matcher m = p.matcher(input);

        while (m.find()) {
            StringBuilder password = new StringBuilder(";");
            for (int i = 0; i < 4; i++) {
                password.append((int) (Math.random() * 10));
            }
            result.append("\n").append(m.group()).append(password);
        }

        return result.toString();
    }
}
