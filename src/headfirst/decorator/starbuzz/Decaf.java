package headfirst.decorator.starbuzz;

public class Decaf extends Beverage {
    public Decaf() {
        // this instance variable is inherited from Beverage
        description = "Decaf Coffee";
    }

    @Override
    public double cost() {
        return 1.05;
    }
}
