package com.company;

class Task3 {

    /**
     * Вычисляет среднее значение трех вещественных чисел передаваемых на вход программы в качестве аргументов
     * @param args - массив вещественных чисел формата String
     */
    static void getAverageValue(String args[]) {
        double[] x = new double[args.length];
        double sum = 0;

        for (int i = 0; i < args.length; i++) {
            x[i] = Double.parseDouble(args[i]);
        }

        for (double element : x) {
            sum += element;
        }

        System.out.println("Given variables:");
        for (String element : args ) {
            System.out.println(element);
        }
        System.out.printf("\nAverage value from %d variable \"double\" type == %f", x.length, sum/x.length);
    }
}
