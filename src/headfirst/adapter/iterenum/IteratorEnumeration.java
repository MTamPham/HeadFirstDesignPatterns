package headfirst.adapter.iterenum;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * We are trying to convert Iterator interface to Enumeration interface
 */
public class IteratorEnumeration implements Enumeration {
    Iterator iterator;

    public IteratorEnumeration(Iterator iterator) {
        this.iterator = iterator;
    }

    @Override
    public boolean hasMoreElements() {
        return iterator.hasNext();
    }

    @Override
    public Object nextElement() {
        return iterator.next();
    }
}
