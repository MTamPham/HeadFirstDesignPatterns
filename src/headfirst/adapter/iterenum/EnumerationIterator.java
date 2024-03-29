package headfirst.adapter.iterenum;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * We are trying to convert Enumeration interface to Iterator interface
 * i.e. adapting an Enumeration to an Iterator
 */
public class EnumerationIterator implements Iterator {
    private Enumeration enumeration;

    public EnumerationIterator(Enumeration enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public Object next() {
        return enumeration.nextElement();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
