package oy.interact.tira.student;

import java.util.function.Predicate;

import oy.interact.tira.util.Pair;
import oy.interact.tira.util.TIRAKeyedContainer;

public class HashTableContainer<K extends Comparable<K>, V> implements TIRAKeyedContainer<K, V> {

    /////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////
    private Pair<K, V>[] array;
    // Counting variables
    private int count = 0;
    private int reallocateCount = 0;
    private int crushCount = 0;
    private int pairUpdateCount = 0;
    private int exploringCount = 0;

    // static variables
    private static final int DEFAULT_TABLE_SIZE = 10;
    private static final double LOAD_FACTOR = 1.65;

    /////////////////////////////////////////////
    // CONSTRUCTORS
    /////////////////////////////////////////////
    @SuppressWarnings("unchecked")
    public HashTableContainer() {
        array = (Pair<K, V>[]) new Pair[DEFAULT_TABLE_SIZE];

    }

    /////////////////////////////////////////////
    // METHODS
    /////////////////////////////////////////////
    @Override
    public void add(K key, V value) throws OutOfMemoryError, IllegalArgumentException {

        // Null arvojen tarkistus
        if (key == null || value == null) {
            throw new IllegalArgumentException("Key & Value cannot be null");
        }

        // Alustus
        boolean added = false;
        int hash = key.hashCode();
        int collisionModifier = 0;
        boolean collisionOccurred = false;
        // Jos kapasiteetistä on käytetty 65 % niin reallokoi
        // Koska LOAD_FACTOR on 1.65 eli 65% niin vähennetään siitä 1.
        if ((double) count / capacity() >= (LOAD_FACTOR - 1)) {
            reallocate();
        }
        do {
            int index = indexFor(hash, collisionModifier);
            if (array[index] == null) {
                array[index] = new Pair<K, V>(key, value);
                count++; // Lisätään laskentaa
                added = true;
                // System.out.format("LISÄTTIIN %s INDEX %d%n", value, index);
            } else if (array[index].getKey().equals(key)) {
                array[index].setValue(value);
                pairUpdateCount++;
                added = true;
                // System.out.format("PÄIVITETTIIN %s INDEX %d%n", value, index);
            } else {
                if (!collisionOccurred) {
                    crushCount++;
                    collisionOccurred = true;
                }
                exploringCount++;
                collisionModifier++;
                // System.out.format("TÖRMÄYS %s INDEX %d, collisionMod: %d%n", value, index,
                // collisionModifier);
            }
        } while (!added && collisionModifier <= capacity());

    }

    @Override
    public V get(K key) throws IllegalArgumentException {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        int hash = key.hashCode();
        int collisionModifier = 0;
        while (collisionModifier < capacity()) {
            int index = indexFor(hash, collisionModifier);
            Pair<K, V> pair = array[index];
            // if(pair != null && !pair.isRemoved())
            if (pair != null) {
                if (key.equals(pair.getKey())) {
                    return pair.getValue(); // Avain löytyi
                }
            }
            collisionModifier++;
        }
        return null; // Avainta ei löytynyt
    }

    // VALINNAINEN TOTEUTUS
    @Override
    public V remove(K key) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public V find(Predicate<V> searcher) {
        if (searcher == null) {
            throw new IllegalArgumentException("Search predicate cannot be null");
        }
        // Käydään läpi kaikki taulukon elementit
        for (Pair<K, V> pair : array) {
            // if(pair != null && !pair.isRemoved())
            if (pair != null) {
                V value = pair.getValue();
                if (searcher.test(value)) {
                    return value; // Palautetaan ensimmäinen löytynyt elementti
                }
            }
        }
        return null; // Ei löytynyt.
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public int capacity() {
        return this.array.length;
    }

    @Override
    public void ensureCapacity(int capacity) throws OutOfMemoryError, IllegalArgumentException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ensureCapacity'");
    }

    @Override
    @SuppressWarnings("unchecked")
    public void clear() {
        array = (Pair<K, V>[]) new Pair[DEFAULT_TABLE_SIZE];
        this.count = 0;
        this.crushCount = 0;
        this.exploringCount = 0;
        this.reallocateCount = 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Pair<K, V>[] toArray() throws Exception {

        Pair<K, V>[] arrayTwo = (Pair<K, V>[]) new Pair[count];
        int tempIndex = 0;
        System.out.println("Rellakointi: " + reallocateCount);
        System.out.println("Törmäys: " + crushCount);
        System.out.println("Luotaus: " + exploringCount);
        System.out.println("Paripäivitykset: " + pairUpdateCount);
        for (int index = 0; index < capacity(); index++) {
            // if(array[index] != null && !array[index].isRemoved()) {
            if (array[index] != null) {
                arrayTwo[tempIndex++] = array[index];
            }
        }
        return arrayTwo;
    }

    ////////////////////////////////////////////////////////////////
    // Reallakointi & IndexFor
    ////////////////////////////////////////////////////////////////

    private int indexFor(int hash, int collisionModifier) {
        final int c1 = 4;
        final int c2 = 17;
        return ((hash + c1 * collisionModifier + c2 * (collisionModifier * collisionModifier) & 0x7FFFFFFF)
                % capacity());
    }

    // Reallakointi, kun siirretään elementit vanhasta taulukosta uuteen, niin
    // niille pitää laskea uusi INDEKSI!! Kun reallakointi tehdään, niin mikä on
    // uuden taulukon koko? 1.60x
    @SuppressWarnings("unchecked")
    private void reallocate() {
        int newCapacity = (int) (capacity() * LOAD_FACTOR);
        Pair<K, V>[] oldArray = array;
        array = (Pair<K, V>[]) new Pair[newCapacity];

        // Nollataan laskurit
        count = 0;
        crushCount = 0;
        exploringCount = 0;
        // Siirretään elementit uuteen taulukkoon
        for (Pair<K, V> pair : oldArray) {
            // if(pair != null && !pari.isRemove())
            if (pair != null) {
                // Sijoitetaan elementti taulukkoon
                add(pair.getKey(), pair.getValue());
            }
        }
        // Lisätään reallocate + 1
        reallocateCount++;
    }
}
