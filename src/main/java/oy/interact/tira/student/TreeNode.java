package oy.interact.tira.student;

import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;

import oy.interact.tira.util.Pair;

public class TreeNode<K extends Comparable<K>, V> {
    // ATTRIBUTES
    // ===============
    // TASK 7
    // ===============
    K key;
    V value;
    TreeNode<K, V> leftChild = null;
    TreeNode<K, V> rightChild = null;
    // LISÄATTRIBUUTIT
    int addDepth;

    // ===============
    // TASK 8
    // ===============
    private int hash = -1;
    Pair<K, V> keyValue;

    // CONSTRUCTORS
    public TreeNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    // METHODS
    // ===================================================
    // GETTERS & SETTERS
    // ===================================================
    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public TreeNode<K, V> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode<K, V> leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode<K, V> getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode<K, V> rightChild) {
        this.rightChild = rightChild;
    }
    // ===================================================
    // REAL METHODS
    // ===================================================

    // INSERT

    // Apumetodi solmujen lisäämiseksi
    public boolean insert(K key, V value, Comparator<K> comparator) {
        // Vertaillaan annettua avainta nykyiseen avaimeen.
        int compare = comparator.compare(key, this.key);
        // Tarkistetaan että eihän ole sama arvo kyseessä
        if (this.value.equals(value)) {
            this.key = key;
            this.value = value;
            return false;
        }
        // Vasempaan haara
        if (compare <= 0) {
            // Jos left side on null, niin luodaan uusi solmu
            if (leftChild == null) {
                leftChild = new TreeNode<K, V>(key, value);
                this.addDepth += 1; // Päivitetään solmun kokoa
                return true;
            } else {
                this.addDepth += 1; // Päivitetään solmun kokoa
                return leftChild.insert(key, value, comparator);
            }
            // Oikea haara
        } else {
            if (rightChild == null) {
                rightChild = new TreeNode<K, V>(key, value);
                this.addDepth += 1; // Päivitetään solmun kokoa
                return true;
            } else {
                this.addDepth += 1; // Päivitetään solmun kokoa
                return rightChild.insert(key, value, comparator);
            }
        }
    }

    // FIND
    public V find(K key, Comparator<K> comparator) {

        // Vertaillaan annettua avainta nykyiseen avaimeen.
        int compare = comparator.compare(key, this.key);

        // Tarkastellaan että key on puussa
        if (this.key.equals(key)) {
            return this.value;
            // Vasen haara
        } else if (compare <= 0 && leftChild != null) {
            return leftChild.find(key, comparator);
            // Oikea haara
        } else if (compare > 0 && rightChild != null) {
            return rightChild.find(key, comparator);
        }
        // EI LÖYTÄNYT
        return null;
    }

    // toArray
    public void toArray(Pair<K, V>[] array, AtomicInteger currentIndex) {
        if (leftChild != null) {
            leftChild.toArray(array, currentIndex);
        }
        array[currentIndex.getAndIncrement()] = new Pair<K, V>(key, value);
        if (rightChild != null) {
            rightChild.toArray(array, currentIndex);
        }
    }
}
