import java.util.*;

/**
 * Created by bender on 24.04.2018.
 */
public class MyList<T> implements List<T> {

    private Object[] value;
    private int size = 0;
    private int capacity;

    public MyList() {
        capacity = 2;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int cursor=0;
            @Override
            public boolean hasNext() {
                return cursor<=size-1;
            }

            @Override
            public T next() {
                return (T)value[cursor++];
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        if (size != 0) {
            System.arraycopy(value, 0, result, 0, size);
        }
        return result;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return a;
    }

    @Override
    public boolean add(T t) {
        if ((capacity - this.size) >= 1) {
            this.value[size++] = t;

        } else {
            capacity *= 2;
            resize(capacity);
            this.value[size++] = t;
        }
        return true;
    }

    private void resize(int capacity) {
        Object[] newValue = new Object[capacity];
        if (size != 0) {
            System.arraycopy(value, 0, newValue, 0, size);
        }
        value = newValue;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        int size = c.size();
        int difference = this.size - size;
        Iterator<? extends T> iterator = c.iterator();
        if (difference < 0) {
            capacity = -difference * 2;
            resize(capacity);
        }
        while (iterator.hasNext()) {
            value[this.size++] = iterator.next();
        }
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return (T) this.value[index];
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {
        if (index < size) {
            capacity *= 1.5;
            resize(capacity);
            for (int i = size; i > index + 1; i--) {
                value[i] = value[i - 1];
            }
            value[index] = element;
        }
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return new ListIterator<T>() {
            private int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor <= size - 1;
            }

            @Override
            public T next() {
                return  (T)value[cursor++];
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }

            @Override
            public T previous() {
                return null;
            }

            @Override
            public int nextIndex() {
                return 0;
            }

            @Override
            public int previousIndex() {
                return 0;
            }

            @Override
            public void remove() {

            }

            @Override
            public void set(T t) {
                value[cursor-1] = t;
            }

            @Override
            public void add(T t) {

            }
        };
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
