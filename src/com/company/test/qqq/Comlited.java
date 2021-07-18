package com.company.test.qqq;

public class Comlited {

    public static void main(String[] args) {
        for (int i = 1; i <= 6; i++) {
            System.out.print(i);

            if (i == 3 || i == 4) {
                System.out.println("--------");
                continue;
            }
            System.out.println("complited");
        }
    }

}
