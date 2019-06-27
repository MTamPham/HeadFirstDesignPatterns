package headfirst.templatemethod.simplebarista;

public abstract class CaffeineBeverage {
    abstract void prepareRecipe();

    void boidWater() {
        System.out.println("Boiling water");
    }

    void pourInCup() {
        System.out.println("Pouring into cup");
    }
}
