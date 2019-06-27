package headfirst.templatemethod.barista;

public class BeverageDriveTest {
    public static void main(String[] args) {
        CaffeineBeverage coffee = new Coffee();
        CaffeineBeverage tea = new Tea();

        System.out.println("\nMaking coffee...");
        coffee.prepareRecipe();

        System.out.println("\nMaking tea...");
        tea.prepareRecipe();

        CaffeineBeverageWithHook coffeeHook = new CoffeeWithHook();
        CaffeineBeverageWithHook teaHook = new TeaWithHook();

        System.out.println("\nMaking coffee...");
        coffeeHook.prepareRecipe();

        System.out.println("\nMaking tea...");
        teaHook.prepareRecipe();
    }
}
