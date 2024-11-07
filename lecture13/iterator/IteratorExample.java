package lecture13.iterator;

// Client class
public class IteratorExample {
    public static void main(String[] args) {
        NameCollection nameCollection = new NameCollection(new String[]{"Alice", "Bob", "Charlie", "Diana"});
        Iterator<String> iterator = nameCollection.createIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

// Iterator interface
interface Iterator<T> {
    boolean hasNext();

    T next();
}

// Aggregate interface
interface Aggregate<T> {
    Iterator<T> createIterator();
}

// Concrete collection class
class NameCollection implements Aggregate<String> {
    private final String[] names;

    public NameCollection(String[] names) {
        this.names = names;
    }

    @Override
    public Iterator<String> createIterator() {
        return new NameIterator(this);
    }

    public String[] getNames() {
        return names;
    }
}

// Concrete iterator class
class NameIterator implements Iterator<String> {
    private final NameCollection nameCollection;
    int index = 0;

    public NameIterator(NameCollection nameCollection) {
        this.nameCollection = nameCollection;
    }

    @Override
    public boolean hasNext() {
        return index < nameCollection.getNames().length;
    }

    @Override
    public String next() {
        if (this.hasNext()) {
            return nameCollection.getNames()[index++];
        }
        return null;
    }
}

