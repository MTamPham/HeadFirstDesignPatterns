package headfirst.templatemethod.simplebarista;

public class BeverageDriveTest {
    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        CaffeineBeverage coffee = new Coffee();
        CaffeineBeverage tea = new Tea();

        System.out.println("\nMaking coffee...");
        coffee.prepareRecipe();

        System.out.println("\nMaking tea...");
        tea.prepareRecipe();
    }
}
