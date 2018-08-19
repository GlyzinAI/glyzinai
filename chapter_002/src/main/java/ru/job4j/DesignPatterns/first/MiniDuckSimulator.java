package ru.job4j.DesignPatterns.first;

public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        Duck decoyduck = new DecoyDuck();
        mallard.perfomQuack();
        mallard.perfomFly();
        System.out.println("-------------");
        Duck model = new ModelDuck();
        model.perfomFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.perfomFly();

    }
}
