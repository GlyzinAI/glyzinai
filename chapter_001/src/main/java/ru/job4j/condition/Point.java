package ru.job4j.condition;

/**
 * Программа для расчета расстояния между точками в системе координат
 *
 * @author Artur Glyzin (aglizin@yandex.ru)
 * @version 1.0
 * @since 01.05.2018
 */

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Point that) {
        Point a = this;
        Point b = that;
        return Math.sqrt(Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2));
    }

    public static void main(String[] args) {
        Point a = new Point(0, 1);
        Point b = new Point(2, 5);
        System.out.println("x1= " + a.x);
        System.out.println("x2= " + a.y);
        System.out.println("y1= " + b.x);
        System.out.println("y2= " + b.y);
        double result = a.distanceTo(b);

        System.out.println("Расстояние между точками равно " + result);

    }
}