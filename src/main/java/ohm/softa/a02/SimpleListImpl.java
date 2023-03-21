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
            ListElement current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new ListElement(o);
        }
        this.size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public SimpleList filter(SimpleFilter filter) {
        SimpleListImpl list = new SimpleListImpl();
        for (Object o : this) {
            if (filter.include(o)) {
                list.add(o);
            }
        }
        return list;
    }

    @Override
    public Iterator<Object> iterator() {
        return new ListIterator();
    }

    private static class ListElement {
        private Object item;

        private ListElement next;

        public ListElement(Object item) {
            this.item = item;
        }

        public Object getItem() {
            return item;
        }

        public ListElement getNext() {
            return next;
        }

    }

    public class ListIterator implements Iterator<Object> {

        private ListElement current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Object next() {
            Object tmp = current.getItem();
            current = current.getNext();
            return tmp;

        }
    }

}
