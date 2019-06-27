package headfirst.decorator.starbuzz;

public class StarbuzzCoffee {
    public static void main(String[] args) {
        // order up an espresso, no condiments
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        // make a DarkRoast object
        Beverage beverage2 = new DarkRoast();
        // wrap it with a mocha
        beverage2 = new Mocha(beverage2);
        // wrap it with a second mocha
        beverage2 = new Mocha(beverage2);
        // wrap it with whip
        beverage2 = new Whip(beverage2);
        // it now gives us a dark roast coffee with double shot of mocha and whip
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

        // make a HouseBlend object
        Beverage beverage3 = new HouseBlend();
        // wrap it with a soy
        beverage3 = new Soy(beverage3);
        // wrap it with a mocha
        beverage3 = new Mocha(beverage3);
        // wrap it with a whip
        beverage3 = new Whip(beverage3);
        // it now gives us a house blend coffee with mocha, soy and whip
        System.out.println(beverage3.getDescription() + " $" + beverage3.cost());
    }
}
