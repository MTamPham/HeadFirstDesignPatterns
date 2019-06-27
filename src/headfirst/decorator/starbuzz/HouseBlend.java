package headfirst.decorator.starbuzz;

public class HouseBlend extends Beverage {

    public HouseBlend() {
        // this instance variable is inherited from Beverage
        description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return .89;
    }
}
