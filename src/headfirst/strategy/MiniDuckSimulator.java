package headfirst.strategy;

public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        ((MallardDuck) mallard).display();
        mallard.performFly();
        mallard.performQuack();

        Duck model = new ModelDuck();
        ((ModelDuck) model).display();
        // it delegates to the flyBehavior object set in the ModelDuck's constructor, which is a FlyNoWay instance
        model.performFly();
        // change the fly behavior to FlyRocketPowered instance
        model.setFlyBehavior(new FlyRocketPowered());
        // now, the model duck has rocket-powered flying capability
        model.performFly();
    }
}
