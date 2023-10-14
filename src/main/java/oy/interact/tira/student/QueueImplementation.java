package oy.interact.tira.student;

import oy.interact.tira.util.QueueInterface;

public class QueueImplementation<E> implements QueueInterface<E> {

    /*
     * capacity(): O(1). (DONE)
     * 
     * enqueue(): O(1) paitsi kun/jos joudutaan reallokoimaan taulukkoratkaisussa:
     * O(n).
     * 
     * dequeue(): O(1).
     * 
     * element(): O(1).
     * 
     * size(): O(1).
     * 
     * isEmpty(): O(1).
     * 
     * clear(): O(1).
     * 
     * toString(): O(n).
     */

    // ******************
    // Attributes
    // ******************
    private static final int DEFAULT_STACK_SIZE = 10;
    private int capacity = DEFAULT_STACK_SIZE;
    private int count = 0;

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

        // Siirretään vanhan taulukon elementit uuteen
        for (int alkio = 0; alkio < capacity; alkio++) {
            newArray[alkio] = itemArray[head + alkio];
        }
        head = 0;
        tail = capacity;
        itemArray = newArray;
        capacity = newCapacity;
    }

    @Override
    public int capacity() {
        // Palauttaa capacity:n
        return this.capacity;
    }

    // TAIL
    @Override
    public void enqueue(E element) throws OutOfMemoryError, NullPointerException {
        if (element == null) {
            throw new NullPointerException("Element cannot be null");
        }
        if (size() == capacity) {
            reallocate();
        }
        // Tarkista tämä kohta TAIL JA HEAD

        // Lisätään elementti taulukkoon.
        if (tail == capacity) {
            tail = 0;
        }
        itemArray[tail++] = element;
        count++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E dequeue() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("Empty queue");
        }
        E item = (E) itemArray[head];
        itemArray[head] = null;
        head = (head + 1) % capacity;
        count--;
        return item;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E element() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("Element cannot be null");
        }

        // Palautetaan
        return (E) itemArray[head];
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void clear() {
        capacity = DEFAULT_STACK_SIZE;
        tail = 0;
        head = 0;
        Object[] newArray = new Object[capacity];
        itemArray = newArray;
    }

}
