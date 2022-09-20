package com.company;


import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первую строку ");
        String firstLine = scanner.nextLine();
        System.out.println("Введите вторую строчку");
        String secondLine = scanner.nextLine();
        createMoreLine(firstLine, secondLine);
    }
    
    public static void createMoreLine(String firstLine, String secondLine) {
        String line = firstLine + secondLine;
        char[] temp = line.toCharArray();
        int count = factorial(temp.length);
        System.out.println("Вариантов  " + count);
        for (String lol : getLine(temp, count)) {
            System.out.println(lol);
        }
    }

    private static String[] getLine(char[] temp, int count) {
        String[] line = new String[count];
        int max = temp.length - 1;
        int shift = max;
        char t;
        for (int i = 0; i < count; i++) {
            t = temp[shift];
            temp[shift] = temp[shift - 1];
            temp[shift - 1] = t;
            line[i] = Arrays.toString(temp);
            if (shift < 2) {
                shift = max;
            } else {
                shift--;
            }
        }
        return line;
    }


    public static int factorial(int number) {
        int result = 1;

        for (int factor = 2; factor <= number; factor++) {
            result *= factor;
        }

        return result;
    }
}
