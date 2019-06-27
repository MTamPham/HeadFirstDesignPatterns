package headfirst.composite.compositewithiterator;

import java.util.Iterator;
import java.util.Stack;

public class CompositeIterator implements Iterator {
    Stack stack = new Stack();

    // store iterator in a stack data structure
    public CompositeIterator(Iterator iterator) {
        stack.push(iterator);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Alternating Diner Menu Iterator does not support remove()");
    }

    @Override
    public boolean hasNext() {
        if (stack.isEmpty()) {
            return false;
        } else {
            // get the current iterator off the top of the stack and see if it has a next element
            Iterator iterator = (Iterator) stack.peek();
            // if it doesn't, we pop it off the stack and call hasNext() recursively
            if (!iterator.hasNext()) {
                stack.pop();
                return hasNext();
            }
            return true;
        }
    }

    @Override
    public Object next() {
        // make sure there is a next element
        if (hasNext()) {
            // if there is one, we get the current iterator off the top of the stack and get its next element
            // peek gets the item at the top of the stack without removing it
            Iterator iterator = (Iterator) stack.peek();
            MenuComponent component = (MenuComponent) iterator.next();
            // if that element is a menu, we have another composite that needs to be included in the iteration
            if (component instanceof Menu) {
                stack.push(component.createIterator());
            }
            // otherwise, just return the component
            return component;
        }
        return null;
    }
}
