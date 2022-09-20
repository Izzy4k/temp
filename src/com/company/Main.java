package com.company;


import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первую строку ");
        String firstLine = scanner.nextLine().trim();
        System.out.println("Введите вторую строчку");
        String secondLine = scanner.nextLine().trim();
        createMoreLine(firstLine, secondLine);
    }


    public static void createMoreLine(String firstLine, String secondLine) {
        String line = firstLine + secondLine;
        char[] temp = line.toCharArray();
        int factorial = (int) newFactorial(temp.length);
        int count;
        if (findToSimilar(temp) != 0) {
            count = (int) (factorial / findToSimilar(temp));
        } else {
            count = factorial;
        }
        System.out.println("Вариантов  " + count);
        createLine(temp, count);
    }

    private static void createLine(char[] temp, int count) {
        boolean isSimilar = true;
        int max = temp.length - 1;
        int shift = max;
        char t;
        String t2;
        for (int i = 0; i < count; i++) {
            t = temp[shift];
            temp[shift] = temp[shift - 1];
            temp[shift - 1] = t;
            t2 = Arrays.toString(temp);
            for (int k = 0; k < count; k++) {
                if (t2 == Arrays.toString(temp)) {
                    isSimilar = true;
                    break;
                } else {
                    isSimilar = false;
                }
            }
            if (!isSimilar) {
                System.out.println(t2);
            }
            if (shift < 2) {
                shift = max;
            } else {
                shift--;
            }
        }
        System.out.println("--------------------End------------------------");
    }

    private static long findToSimilar(char[] temp) {
        long t = 0;
        int max = temp.length - 1;
        for (int i = 0; i < max; i++) {
            char a = temp[i];
            for (int j = 0; j < max; j++) {
                if (i != j) {
                    if (a == temp[j]) {
                        t = t + 2;
                        break;
                    }
                }
            }
        }
        return t;
    }

    public static long newFactorial(long number) {
        if (number == 0) return 1;
        else return (number * newFactorial(number - 1));
    }
}
