package headfirst.decorator.starbuzz;

public class Mocha extends CondimentDecorator {
    // an instance variable to hold the beverage this instance is wrapping
    private Beverage beverage;

    // instantiate this instance with a reference to a beverage
    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    // we first delegate to the object this instance is decorating to get its description
    // then append this instance description
    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    // we first delegate the call to the object this instance is decorating to compute the cost
    // then add this instance cost to the result
    @Override
    public double cost() {
        return .20 + beverage.cost();
    }
}
