package com.company;

import java.util.Scanner;

class Task1 {
    /**
     * Программа, выводит на экран меньшее по модулю из трёх введённых пользователем вещественных чисел.
     * Для вычисления модуля используется тернарная условная операция.
     */
    static void minDoubleValue() {
        double x1, x2, x3;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input first double variable: > ");
        x1 = getDoubleValue(scanner);
        System.out.print("Input second double variable: > ");
        x2 = getDoubleValue(scanner);
        System.out.print("Input third double variable: > ");
        x3 = getDoubleValue(scanner);

        System.out.printf("\nМеньшее по модулю из трёх введённых вещественных чисел == %f\n", getMinVariable(getAbsVariable(x1), getMinVariable(getAbsVariable(x2), getAbsVariable(x3))));

    }

    /**
     * Вычисление модуля числа.
     * @param x - вещественное число, модуль которого необходимо получить
     * @return - модуль вещественного числа
     */
    private static double getAbsVariable(double x) {
        return x < 0 ? -x : x;
    }

    /**
     * Вычисление меньшего из двух чисел
     * @param x1 - первое аргумент для вычисления
     * @param x2 - второй аргумент для вычисления
     * @return - меньший из двух входящих аргументов
     */
    private static double getMinVariable(double x1, double x2) {
        return x1 < x2 ? x1 : x2;
    }

    /**
     * Считывание с консоли введенного числа пользователем
     * @param sc - аргумент типа Scanner
     * @return - введенное число пользователем
     */
    private static double getDoubleValue(Scanner sc) {
        double x;
        while (true) {
            if (sc.hasNextDouble()) {
                x = sc.nextDouble();
                break;
            } else {
                System.out.println("Value is not double!!! Try again!!!");
                sc.next();
            }
        }
        return x;
    }
}
