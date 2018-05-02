package ru.job4j.converter;
/**
 * class Converter - Корвертор валюты.
 * @author Artur Glyzin.
 * @since 01.05.2018.
 * @version 1.0.
 */
public class Converter {

    /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return Евро.
     */
    public int rubleToEuro(int value) {
        int res1 = value / 70;
        return res1;
    }

    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return доллары.
     */
    public int rubleToDollar(int value) {
        int res2 = value / 60;
        return res2;
    }

    /**
     * Конвертируем доллары в рубли.
     * @param value доллары.
     * @return рубли.
     */
    public int DollarToRuble(int value) {
        int res3 = value * 60;
        return res3;
    }

    /**
     * Конвертируем евро в рубли.
     * @param value евро.
     * @return рубли.
     */
    public int EuroToRuble(int value) {
        int res4 = value * 70;
        return res4;
    }
}
