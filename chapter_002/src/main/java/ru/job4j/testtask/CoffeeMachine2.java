package ru.job4j.testtask;

/**
 * CoffeeMachine - класс выдачи сдачи для автомата.
 *
 * @author Artur Glyzin.
 * @version 2.0.
 * @since 27.08.2018.
 */

public class CoffeeMachine2 {

    /**
     * @param value - купюра, которой пользователь оплачивает товар(кофе).
     * @param price - цена товара(кофе).
     * @return res - массив, который содержит сдачу(наименьшее количество монет).
     */

    public int[] changes(int value, int price) {
        int[] nominal = {10, 5, 2, 1};
        int delivery = value - price;
        int count = 0;

        // count - минимальное количество монет(размерность результирующего массива)
        while (delivery > 0) {
            for (int k : nominal) {
                count += delivery / k;
                delivery -= delivery / k * k;
            }
        }
        int[] res = new int[count];

        //change - сдача, которую необходимо вернуть
        int change = value - price;

        int index = 0;

        for (int i = 0; i < count; i++) {
            if (change / nominal[index] > 0) {
                res[i] = nominal[index];
                change -= nominal[index];
            } else {
                index++;
                i--;
            }
        }

        return res;
    }
}
