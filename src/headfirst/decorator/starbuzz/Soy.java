package headfirst.decorator.starbuzz;

public class Soy extends CondimentDecorator {
    private Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public int getSize() {
        return beverage.getSize();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    @Override
    public double cost() {
        // it is obsolete when the scheme expands to have size
        //return .15 + beverage.cost();

        // we re-write the code
        double cost = beverage.cost();
        if (getSize() == Beverage.TALL) {
            cost += .10;
        } else if (getSize() == Beverage.GANDE) {
            cost += .15;
        } else if (getSize() == Beverage.VENTI) {
            cost += 20;
        }
        return cost;
    }
}
