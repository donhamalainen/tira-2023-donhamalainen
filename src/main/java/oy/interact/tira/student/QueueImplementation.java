package oy.interact.tira.student;

import oy.interact.tira.util.QueueInterface;

public class QueueImplementation<E> implements QueueInterface<E> {

    // ******************
    // Attributes
    // ******************
    private static final int DEFAULT_STACK_SIZE = 10;
    private int capacity = DEFAULT_STACK_SIZE;

    private Object[] itemArray = new Object[capacity];

    // Tärkeimmät atribuutit
    private int head = 0;
    private int tail = 0;

    // ******************
    // Contructors
    // ******************
    public QueueImplementation() {
        this(DEFAULT_STACK_SIZE);
    }

    public QueueImplementation(int parameterCapacity) {
        capacity = parameterCapacity;
        itemArray = new Object[parameterCapacity];
    }

    // ******************
    // Methods
    // ******************

    // OMA: Reallokointi metodi.
    private void reallocate() {
        /*
         * Tuplataan ensin capacity, jonka jälkeen luodaan newArray joka saa taulukon
         * alustuksessa pituudeksi newCapacity. Tämä on tuplat edellisestä.
         */
        int newCapacity = capacity * 2;
        Object[] newArray = new Object[newCapacity];

    }

    @Override
    public int capacity() {
        // Palauttaa capacity:n
        return this.capacity;
    }

    // JATKA TÄSTÄ:::::::::
    @Override
    public void enqueue(E element) throws OutOfMemoryError, NullPointerException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'enqueue'");
    }

    @Override
    public E dequeue() throws IllegalStateException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dequeue'");
    }

    @Override
    public E element() throws IllegalStateException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'element'");
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clear'");
    }

}
