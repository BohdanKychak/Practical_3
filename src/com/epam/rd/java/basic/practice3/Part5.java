package com.epam.rd.java.basic.practice3;

public class Part5 {
    static final int FIVE = 5;
    static final int FOUR = 4;
    static final int TEN = 10;
    static final int ZERO = 0;

    public static void main(String[] args) {
        String NEXT = " -> ";

        for (int i = 1; i <= 100; i++) {
            System.out.print(i + NEXT +
                    decimal2Roman(i) + NEXT +
                    roman2Decimal(decimal2Roman(i)));
            if (i != 100) {
                System.out.println();
            }
        }

    }

    public static String decimal2Roman(int dec) {
        String result = "";

        int digit;
        char oneInChar, fiveInChar, tenInChar;
        int numberOfIterations = 2;
        for (int i = 0; i < numberOfIterations; i++) {
            if (i == ZERO) {
                digit = dec / TEN;
                oneInChar = 'X';
                fiveInChar = 'L';
                tenInChar = 'C';
            } else {
                digit = dec % TEN;
                oneInChar = 'I';
                fiveInChar = 'V';
                tenInChar = 'X';
            }
            if (digit == ZERO) {
                continue;
            }
            result = getRomanNumber(result, digit, oneInChar, fiveInChar, tenInChar);

        }
        return result;
    }

    private static String getRomanNumber(String result, int digit, char oneInChar, char fiveInChar, char tenInChar) {
        if (digit % FIVE == FOUR) {
            result += oneInChar;
            digit++;
        }
        if (digit % FIVE == ZERO) {
            result += digit == FIVE ? fiveInChar : tenInChar;
            return result;
        }

        if (digit > FIVE) {
            result += fiveInChar;
        }
        for (int i = 0; i < digit % FIVE; i++) {
            result += oneInChar;
        }

        return result;
    }

    public static int roman2Decimal(String roman) {
        int result = 0;
        char[] chars = roman.toCharArray();
        int[] numbers = translationOfCharactersIntoNumbers(chars);

        for (int i = 0; i < numbers.length; i++) {

            if (i == numbers.length - 1 || numbers[i] >= numbers[i + 1]) {
                result += numbers[i];
                continue;
            }
            result += numbers[i + 1] - numbers[i];
            i++;
        }
        return result;
    }

    private static int[] translationOfCharactersIntoNumbers(char[] chars) {
        int[] numbers = new int[chars.length];

        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == 'C') {
                numbers[i] = 100;
            }
            if (chars[i] == 'L') {
                numbers[i] = 50;
            }
            if (chars[i] == 'X') {
                numbers[i] = 10;
            }
            if (chars[i] == 'V') {
                numbers[i] = 5;
            }
            if (chars[i] == 'I') {
                numbers[i] = 1;
            }
        }
        return numbers;
    }

}