package ohm.softa.a02;

import java.util.Iterator;

/**
 * @author Peter Kurfer
 * Created on 10/6/17.
 */
public class SimpleListImpl implements SimpleList, Iterable<Object> {

    private ListElement head;
    private int size;

    @Override
    public void add(Object o) {
        if (head == null) {
            head = new ListElement(o);
        } else {

        }

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public SimpleList filter(SimpleFilter filter) {
        return null;
    }

    @Override
    public Iterator<Object> iterator() {
        return new ListIterator();
    }

    private static class ListElement {
        private Object o;
        private ListElement next;

        public ListElement(Object o) {
            this.o = o;
        }

    }

    public class ListIterator implements Iterator<Object> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Object next() {
            return null;
        }
    }

}
