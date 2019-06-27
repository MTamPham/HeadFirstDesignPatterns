package headfirst.factory.factorymethod;

public abstract class PizzaStore {
    @SuppressWarnings("Duplicates")
    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        System.out.println("--- Making a " + pizza.getName() + " ---");
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    // a factory method handles object creation and encapsulates it in a subclass
    // this decouples the client code in the superclass from the object creation code in the subclass
    // a factory method is abstract so the subclasses are counted on to handle object creation
    protected abstract Pizza createPizza(String type);
}
