package headfirst.iterator.scratch;

import java.util.List;

/**
 * Pancake House simplecomposite is stored in an ArrayList
 */
public class PancakeHouseIterator implements Iterator {
    List<MenuItem> menuItems;
    int position = 0;

    public PancakeHouseIterator(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        if (position >= menuItems.size()) {
            return false;
        }
        return true;
    }

    @Override
    public Object next() {
        MenuItem item = menuItems.get(position);
        position++;
        return item;
    }
}
