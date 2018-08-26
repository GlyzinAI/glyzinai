package ru.job4j.TestTask;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * CoffeeMachine - класс выдачи сдачи для автомата.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 26.08.2018.
 */

public class CoffeeMachine {

    /**
     * @param value - купюра, которой пользователь оплачивает товар(кофе).
     * @param price - цена товара(кофе).
     * @return arr - массив, который содержит сдачу(наименьшее количество монет).
     */

    int[] changes(int value, int price) {
        int delivery = value - price;
        int countTen = 0;
        int countFive = 0;
        int countTwo = 0;
        int countOne = 0;
        int count = 0;
        while (delivery != 0) {
            if (delivery >= 10) {
                delivery -= 10;
                countTen++;
            } else if (delivery >= 5) {
                delivery -= 5;
                countFive++;
            } else if (delivery >= 2) {
                delivery -= 2;
                countTwo++;
            } else {
                delivery -= 1;
                countOne++;
            }
            count++;
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < countTen; i++) {
            list.add(10);
        }

        for (int i = 0; i < countFive; i++) {
            list.add(5);
        }

        for (int i = 0; i < countTwo; i++) {
            list.add(2);
        }

        for (int i = 0; i < countOne; i++) {
            list.add(1);
        }

        Integer mas[] = new Integer[list.size()];
        list.toArray(mas);

        int[] arr = new int[mas.length];

        for (int i = 0; i < mas.length; i++) {
            arr[i] = mas[i].intValue();
        }

        System.out.println(Arrays.toString(arr));


        return arr;
    }
}



