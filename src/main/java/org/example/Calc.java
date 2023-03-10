package org.example;


public class Calc{
    public static int run(String exp) {
        exp = exp.replaceAll("- ","+ -");

        String[] bits = exp.split(" \\+ ");

        int result = 0;

        for (String s : bits) {
            result += Integer.parseInt(s);
        }

        return result;
    }
}