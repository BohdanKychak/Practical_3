package com.company.test.qqq;

import java.util.Arrays;

public class Test2 {

    public static void main(String[] args) {
        int[] c = new int[10];
        c[7]=3;

        c = new int[c.length];
        c[1]=2;
        System.out.println(Arrays.toString(c));
    }

}
