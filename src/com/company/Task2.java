package com.company;

class Task2 {

    /**
     * Главный метод иммитирующий работу гирлянды, состоящую из 32 лампочек. Каждая лампочка имеет два состояния - включена или выключена.
     * В начале работы программы случайным образом задано какие лампочки будут включены
     */
    static void workOfGarland() {
        int gar = -1431655766;
        int runGar = 1;

        System.out.println("Мигающая герлянда:");
        blinkGarland(gar, 5);

        System.out.println("Гирлянда в режиме бегущая строка:");
        runTickerMode(runGar, 31);

    }


    /**
     * Метод который распечатывает текущее состояние гирлянды
     * @param gar - гирлянда, аргумент типа Integer
     */
    private static void outputOfGarland(int gar) {
        System.out.printf("%32s%n", Integer.toBinaryString(gar));
    }

    /**
     * Метод, который мигает лампочками гирлянды заданное количество раз
     * @param gar - гирлянда, аргумент типа Integer
     * @param count - сколько раз нужно мигнуть
     */
    private static void blinkGarland(int gar, int count) {
        int blinkGar = gar;
        for (int i = 0; i < count; i++) {
            outputOfGarland(blinkGar);
            getStateFirstLamp(blinkGar);
            blinkGar = ~blinkGar;
        }
    }

    /**
     * Метод, который запускает гирлянду в режим бегущей строки
     * @param gar - гирлянда, аргумент типа Integer
     * @param count - количество шагов в бегущей строке
     */
    private static void runTickerMode(int gar, int count) {
        int runGar = gar;
        for (int i = 0; i < count; i++) {
            runGar = runGar << 1;
            outputOfGarland(runGar);
        }

        for (int i = 0; i < count; i++) {
            runGar = runGar >>>1;
            outputOfGarland(runGar);
        }
        getStateFirstLamp(runGar);
    }

    /**
     * Метод, который выясняет включена ли лампочки на первой позиции
     * @param gar - гирлянда, аргумент типа Integer
     */
    private static void getStateFirstLamp(int gar) {
        int firstLamp = 1;
        if ((gar & firstLamp) == 1) {
            System.out.println("Первая лампочка горит!");
        } else {
            System.out.println("Первая лампочка не горит!");
        }
    }

}
