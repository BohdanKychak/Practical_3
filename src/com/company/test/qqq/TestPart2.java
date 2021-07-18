package com.company.test.qqq;


public class TestPart2 {
    public static String string = "When I was younger, so much younger than today\n" +
            "I never needed anybody's help in any way\n" +
            "But now these days are gone, I'm not so self-assured\n" +
            "Now I find I've changed my mind\n" +
            "I've opened up the doors\n";


    public static void main(String[] args) {
        System.out.print(convert(string));

    }

    public static String convert(String input) {
        String result = "";

        char[] chars = string.toCharArray();
        StringBuilder resultMax = new StringBuilder("max: ");
        StringBuilder resultMin = new StringBuilder("min: ");
        int max, indexMax, min, indexMin, count, index;
        for (int i = 0; i < chars.length; i++) {
            {
                max = 0;
                indexMax = 0;
                min = 100;
                indexMin = 0;
                count = 0;
            }

            if (i != 0) {
                resultMax.append(", ");
                resultMin.append(", ");
            }

            while (chars[i] != '\n') {
                index = i;
                while (chars[i] >= 'a' && chars[i] <= 'z' || chars[i] >= 'A' && chars[i] <= 'Z') {
                    count++;
                    i++;
                }
                if (count > max) {
                    max = count;
                    indexMax = index;
                }
                if (count < min && count != 0) {
                    min = count;
                    indexMin = index;
                }
                count = 0;
                if (chars[i] != '\n') {
                    i++;
                }
            }
            for (int j = indexMax; j < indexMax + max; j++) {
                resultMax.append(chars[j]);
            }
            for (int j = indexMin; j < indexMin + min; j++) {
                resultMin.append(chars[j]);
            }
        }

        result += resultMax + "\n" + resultMin;

        return result;
    }

}
