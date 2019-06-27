package headfirst.decorator.starbuzz;

public class DarkRoast extends Beverage {
    public DarkRoast() {
        // this instance variable is inherited from Beverage
        description = "Dark Roast Coffee";
    }

    @Override
    public double cost() {
        return 0.99;
    }
}
