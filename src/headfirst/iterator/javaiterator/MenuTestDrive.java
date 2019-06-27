package headfirst.iterator.javaiterator;

import java.util.ArrayList;
import java.util.List;

public class MenuTestDrive {
    public static void main(String[] args) {
        Menu pancakeHouseMenu = new PancakeHouseMenu();
        Menu dinerMenu = new DinerMenu();
        Menu cafeMenu = new CafeMenu();

        List<Menu> menus = new ArrayList<>();
        menus.add(pancakeHouseMenu);
        menus.add(dinerMenu);
        menus.add(cafeMenu);

        Waitress waitress = new Waitress(menus);
        waitress.printMenu();
    }
}
