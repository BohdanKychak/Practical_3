package com.company.test.qqq;


import java.util.regex.*;

public class test3 {
    static String text = "when I was younger\n" +
            "I never needed\n";
    private static final String REGEX_FIRST_LETTER = "(?<=\\. |^)\\w";
    private static final String REGEX_NOT_FIRST_LETTER = "(?<!\\. |^)\\w";

    public static void main(String[] args) {
        System.out.print(convert(text));
        //        System.out.println(notFirstToLower(text));
    }

    public static String convert(String input) {
        Pattern p = Pattern.compile(
                "(?<!alpha)alpha+(?!alpha)".replace("alpha",
                        "[a-zA-Z\u0080-\u9fff]"), Pattern.UNICODE_CHARACTER_CLASS
        );
        Matcher m = p.matcher(input);

        while (m.find()) {
            if (m.group().charAt(0)>='A' && m.group().charAt(0)<='Z'){
                //             m.group().replaceFirst(m.group().charAt(0), );
            }
        }

        return null;
    }
    public static String notFirstToLower(String str) {
        str = str.toLowerCase();
        Matcher mtch = Pattern.compile("(?<=\\.|^)\\s*\\p{Lower}").matcher("");
        while (mtch.reset(str).find()) str = mtch.replaceFirst(mtch.group().toUpperCase());


        return str;
    }
}
