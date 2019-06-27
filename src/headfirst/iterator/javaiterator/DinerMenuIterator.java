package headfirst.iterator.javaiterator;

import java.util.Iterator;

/**
 * Diner simplecomposite is stored in a REAL array
 */
public class DinerMenuIterator implements Iterator {
    MenuItem[] items;
    int position = 0;

    public DinerMenuIterator(MenuItem[] items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        if (position >= items.length || items[position] == null) {
            return false;
        }
        return true;
    }

    @Override
    public Object next() {
        MenuItem item = items[position];
        position++;
        return item;
    }

    @Override
    public void remove() {
        if (position <= 0) {
            throw new IllegalStateException("You can't remove an item util you've done at least one next()");
        }
        if (items[position - 1] != null) {
            for (int i = position-1; i < items.length - 1; i++) {
                items[i] = items[i+1];
            }
            items[items.length - 1] = null;
        }
    }
}
