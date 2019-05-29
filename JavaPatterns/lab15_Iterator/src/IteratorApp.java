class IteratorApp {
    public static void main(String[] args) {
        ConcreteCollection c = new ConcreteCollection();

        Iterator it = c.getIterator();

        while(it.hasMore()) {
            System.out.println((String)it.getNext());
        }
    }
}

interface Iterator {
    boolean hasMore();
    Object getNext();
}

interface IterableCollection {
    Iterator getIterator();
}

class ConcreteCollection implements IterableCollection {
    String[] tasks = {"Jacobs", "Nescafe", "MacCoffe"};

    @Override
    public Iterator getIterator() {
        return new ConcreteIterator();
    }

    private class ConcreteIterator implements Iterator {
        int index = 0;

        @Override
        public boolean hasMore() {
            if(index<tasks.length) {return true;} else {return false;}
        }

        @Override
        public Object getNext() {
            return tasks[index++];
        }
    }
}