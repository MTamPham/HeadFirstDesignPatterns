package headfirst.factory.abstractfactory;

// we see that NYStyleCheesePizza and ChicacoStyleCheesePizza only differs to each other on the ingredients,
// others (dough, sauce, cheese) are same
// so we really don't need to create two different classes for each pizza
public class CheesePizza extends Pizza {
	PizzaIngredientFactory ingredientFactory;

	// to make a pizze, we need a factory to provide ingredients
	public CheesePizza(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}

	void prepare() {
		System.out.println("Preparing " + name);
		dough = ingredientFactory.createDough();
		sauce = ingredientFactory.createSauce();
		cheese = ingredientFactory.createCheese();
	}
}
