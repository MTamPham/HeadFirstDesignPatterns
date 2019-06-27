package headfirst.composite.simplecomposite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This is Menu class
 */
public class Menu extends MenuComponent {
    List<MenuComponent> menuComponents = new ArrayList<>();
    String name;
    String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(int i) {
        return menuComponents.get(i);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void print() {
        System.out.print("\n" + getName());
        System.out.println(", " + getDescription());
        System.out.println("---------------------");

        // we use Iterator to iterate through all the Menu's components... those could be other Menus, or they could be MenuItems
        // both Menus and MenuItems implement print(), we just call print() and the rest is up to them
        // NOTE: if, during this iteration, we encounter another Menu object, its print() method will start another iteration, and so on
        Iterator iterator = menuComponents.iterator();
        while (iterator.hasNext()) {
            MenuComponent menuComponent = (MenuComponent) iterator.next();
            menuComponent.print();
        }
    }
}
