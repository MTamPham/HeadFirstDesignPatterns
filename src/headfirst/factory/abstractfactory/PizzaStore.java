package headfirst.factory.abstractfactory;

public abstract class PizzaStore {
 
	protected abstract Pizza createPizza(String item);

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
}
