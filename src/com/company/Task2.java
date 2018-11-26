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

        System.out.println("\nГирлянда в режиме бегущая строка:");
        runTickerMode(runGar, 31);

    }


    /**
     * Метод который распечатывает текущее состояние гирлянды
     * @param gar - гирлянда, аргумент типа Integer
     */
    private static void outputOfGarland(int gar) {
        String str;
        char lampSwitchOff = 0x2591;
        char lampSwitchOn = 0x2593;
        char[] masStr = new char[32];
        char[] chArray = Integer.toBinaryString(gar).toCharArray();
        int lenGar = chArray.length - 1;

    //-------------------------------------------- Fill masStr massive -------------------------------------------------
        for (int i = 0; i < 32; i++) {
            masStr[i] = 0x2591;
        }

        int j = 31;
        for (int i = lenGar; i >= 0; i--) {
            masStr[j] = chArray[i];
            j--;
        }

    //--------------------------------------- Change '0' to ░ symbol and '1' to ▓ symbol ------------------------------
        str = String.valueOf(masStr);
        str = str.replace('0', lampSwitchOff);
        str = str.replace('1', lampSwitchOn);

        System.out.println(str);

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
