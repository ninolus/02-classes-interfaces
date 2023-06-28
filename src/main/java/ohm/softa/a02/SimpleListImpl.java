package ohm.softa.a02;

import java.util.Iterator;

/**
 * @author Peter Kurfer
 * Created on 10/6/17.
 */
public class SimpleListImpl<T> implements SimpleList<T>, Iterable<T> {
    // TODO: Implement the required methods.
    Element<T> root;

    @Override
    public Iterator<T> iterator() {
        return new SimpleListIterator();
    }

    @Override
    public void add(T o) {
        if (root == null) {
            root = new Element<>(o);
        } else {
            Element<T> current = root;
            Element<T> previous;
            do {
                previous = current;
                current = current.getNext();
            } while (current != null);
            previous.setNext(new Element<>(o));
        }
    }

    @Override
    public int size() {
        int size = 0;
        for (T t : this) {
            size++;
        }
        return size;
    }

    @Override
    public SimpleList<T> filter(SimpleFilter<T> filter) {
        SimpleList<T> result = new SimpleListImpl<>();
        Element<T> elem = root;
        while (elem != null) {
            if (filter.include(elem.getItem())) {
                result.add(elem.getItem());
            }
            elem = elem.getNext();
        }
        return result;
    }


    private class SimpleListIterator implements Iterator<T> {
        Element<T> current = root;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            Element<T> temp = current;
            current = current.getNext();
            return temp.getItem();
        }
    }

    private static class Element<T> {
        private final T item;
        private Element<T> next;

        public Element(T item) {
            this.item = item;
        }

        public T getItem() {
            return item;
        }

        public Element<T> getNext() {
            return next;
        }

        public void setNext(Element<T> next) {
            this.next = next;
        }
    }
}
