package org.example;


import java.util.*;

public class Calc {
    public static int run(String exp) {
        boolean needToMultifly = exp.contains("*");
        boolean needToPlus = exp.contains("+") || exp.contains("-");

        boolean needToCompound = needToMultifly && needToPlus;

        if ( needToCompound ) {
            String[] bits = exp.split(" \\+ ");

            return Integer.parseInt(bits[0]) + run(bits[1]);
        }
        else if ( needToPlus ) {
            exp = exp.replaceAll("- ", "+ -");

            String[] bits = exp.split(" \\+ ");

            int sum = 0;

            for (int i = 0; i < bits.length; i++) {
                sum += Integer.parseInt(bits[i]);
            }

            return sum;
        }
        else if ( needToMultifly ) {
            String[] bits = exp.split(" \\* ");

            int sum = 1;

            for (int i = 0; i < bits.length; i++) {
                sum *= Integer.parseInt(bits[i]);
            }

            return sum;
        }

        throw new RuntimeException("올바른 계산식이 아닙니다.");
    }
}