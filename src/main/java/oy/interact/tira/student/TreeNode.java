package oy.interact.tira.student;

import java.util.concurrent.atomic.AtomicInteger;

import oy.interact.tira.util.Pair;

public class TreeNode<K extends Comparable<K>, V> {
    K key;
    V value;
    public static int addDepth;
    TreeNode<K, V> left;
    TreeNode<K, V> right;

    public TreeNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
    }

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

    public TreeNode<K, V> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<K, V> left) {
        this.left = left;
    }

    public TreeNode<K, V> getRight() {
        return right;
    }

    public void setRight(TreeNode<K, V> right) {
        this.right = right;
    }

    // Insert
    public boolean insert(K key, V value) {
        boolean result = false;
        // Tarkistetaan että eihän ole sama arvo kyseessä
        if (this.value.equals(value)) {
            this.key = key;
            this.value = value;
            return false;
        }

        // Vasempaan haaraan
        if (key.compareTo(this.key) <= 0) {
            // TARKISTETAAN: Jos left side on null, niin luodaan uusi solmu
            if (left == null) {
                left = new TreeNode<K, V>(key, value);
                addDepth++;
                result = true;
            } else {
                addDepth++;
                result = left.insert(key, value);
            }
            // Oikea haara
        } else {
            // TARKISTETAAN: Jos right side on null, niin luodaan uusi solmu
            if (right == null) {
                right = new TreeNode<K, V>(key, value);
                addDepth++;
                result = true;
            } else {
                addDepth++;
                result = right.insert(key, value);
            }
        }
        // PALAUTETAAN ARVO
        return result;
    }

    public V find(K key) {
        V result = null;
        // Lähdetään tarkastelemaan että onko key puussa
        if (this.key.equals(key)) {
            result = this.value;
            // Tarkastellaan ensin vasenta puolta
        } else if (key.compareTo(this.key) <= 0) {
            if (left != null) {
                result = left.find(key);
            }
            // Tarkastellaan oikeaa puolta
        } else {
            if (right != null) {
                result = right.find(key);
            }
        }
        return result;
    }

    public void toArray(Pair<K, V>[] array, AtomicInteger currentIndex) {
        if (left != null) {
            left.toArray(array, currentIndex);
        }
        array[currentIndex.getAndIncrement()] = new Pair<K, V>(key, value);
        if (right != null) {
            right.toArray(array, currentIndex);
        }
    }
}
