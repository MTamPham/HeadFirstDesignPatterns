package headfirst.templatemethod.simplebarista;

public class Tea extends CaffeineBeverage {
    @Override
    void prepareRecipe() {
        boidWater();
        steepTeaBag();
        pourInCup();
        addLemon();
    }

    private void steepTeaBag() {
        System.out.println("Steeping the tea bag in hot water");
    }

    private void addLemon() {
        System.out.println("Adding Lemon");
    }
}
