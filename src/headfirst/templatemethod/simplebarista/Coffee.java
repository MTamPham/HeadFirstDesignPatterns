package headfirst.templatemethod.simplebarista;

public class Coffee extends CaffeineBeverage {
    @Override
    void prepareRecipe() {
        boidWater();
        brewCoffeeGrinds();
        pourInCup();
        addMilkAndSugar();
    }

    private void brewCoffeeGrinds() {
        System.out.println("Brewing coffee grinds");
    }

    private void addMilkAndSugar() {
        System.out.println("Adding milk and sugar");
    }
}
