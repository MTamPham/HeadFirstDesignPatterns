package headfirst.decorator.starbuzz;

public class Espresso extends Beverage {
    public Espresso() {
        // this instance variable is inherited from Beverage
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
