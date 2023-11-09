package oy.interact.tira.student;

import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import oy.interact.tira.util.Pair;
import oy.interact.tira.util.StackInterface;
import oy.interact.tira.util.TIRAKeyedOrderedContainer;
import oy.interact.tira.util.Visitor;

public class BinarySearchTreeContainer<K extends Comparable<K>, V> implements TIRAKeyedOrderedContainer<K, V> {
    ////////////////////////////////
    // * ATTRIBUUTIT
    ////////////////////////////////

    private Comparator<K> comparator; // The comparator used to determine if new node will go to left or right
                                      // subtree.

    private TreeNode<K, V> root; // Root node of the tree, your private little helper class.
    private int maxDepth = 0; // Puun suurin syvyys
    private int count = 0; // Puun elementtien määrä

    ////////////////////////////////
    // * KONSTRUKTORIT
    ////////////////////////////////

    public BinarySearchTreeContainer(Comparator<K> comparator) {
        this.comparator = comparator;

    }

    ////////////////////////////////
    // * METODIT
    ////////////////////////////////

    @Override
    public void add(K key, V value) throws OutOfMemoryError, IllegalArgumentException {
        // Jos puussa ei ole solmua
        if (root == null) {
            root = new TreeNode<K, V>(key, value);
            count++;
            maxDepth = 1;
        } else {
            TreeNode.addDepth = 1;
            if (root.insert(key, value)) {
                maxDepth = Math.max(maxDepth, TreeNode.addDepth);
                count++;
            }
        }
    }

    @Override
    public V get(K key) throws IllegalArgumentException {
        if (key == null) {
            throw new IllegalArgumentException("Error: key cannot be null");
        }
        // Jos puussa ei ole solmua niin palautetaan null
        if (root == null) {
            return null;
        }
        // muutoin lähdetään etsimään
        return root.find(key);
    }

    @Override
    public V remove(K key) throws IllegalArgumentException {
        throw new IllegalArgumentException("Key cannot be null");
    }

    @Override
    public V find(Predicate<V> searcher) {
        if (root == null) {
            return null;
        }
        V value = null;
        TreeNode<K, V> currentNode = root;
        TreeNode<K, V> parent = null;
        StackInterface<TreeNode<K, V>> nodeStack = new StackImplementation<>();

        while (!nodeStack.isEmpty() || currentNode != null) {
            if (currentNode != null) {
                nodeStack.push(currentNode);
                parent = currentNode;
                currentNode = currentNode.getLeft();
            } else {
                parent = nodeStack.pop();
                currentNode = parent.getRight();
                if (searcher.test(parent.getValue())) {
                    value = parent.getValue();
                }
            }
        }
        return value;
    }

    @Override
    public int size() {
        // Palautetaan puun
        return this.count;
    }

    @Override
    public int capacity() {
        // Palauttaa elementtien hetkellisen määrän puussa
        return this.maxDepth;

    }

    @Override
    public void ensureCapacity(int capacity) throws OutOfMemoryError, IllegalArgumentException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ensureCapacity'");
    }

    @Override
    public void clear() {
        // Nollataan kaikki arvot
        root = null;
        count = 0;
        maxDepth = 0;
    }

    @Override
    @SuppressWarnings("Checked")
    public Pair<K, V>[] toArray() throws Exception {
        Pair<K, V>[] array = (Pair<K, V>[]) new Pair[count];
        AtomicInteger arrayIndex = new AtomicInteger(0);

        if (root != null) {
            root.toArray(array, arrayIndex);
        }
        return array;
    }

    @Override
    public int indexOf(K itemKey) {
        if (root == null) {
            return -1;
        }

        StackInterface<TreeNode<K, V>> nodeStack = new StackImplementation<>();
        TreeNode<K, V> currentNode = root;
        TreeNode<K, V> parent = null;
        int index = 0;

        while (!nodeStack.isEmpty() || currentNode != null) {
            if (currentNode != null) {
                nodeStack.push(currentNode);
                parent = currentNode;
                currentNode = currentNode.getLeft();
            } else {
                parent = nodeStack.pop();
                currentNode = parent.getRight();
                if (parent.getKey().equals(itemKey)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    @Override
    public Pair<K, V> getIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Error: index out of bounds");
        }
        int currentIndex = 0;
        TreeNode<K, V> currentNode = root;
        TreeNode<K, V> parent = null;
        StackInterface<TreeNode<K, V>> stack = new StackImplementation<>();

        if (root == null) {
            return null;
        }
        while (!stack.isEmpty() || currentNode != null) {
            if (currentNode != null) {
                stack.push(currentNode);
                parent = currentNode;
                currentNode = currentNode.getLeft();
            } else {
                parent = stack.pop();
                currentNode = parent.getRight();
                if (index == currentIndex) {
                    return new Pair<>(parent.getKey(), parent.getValue());
                }
                currentIndex++;
            }
        }
        return null;
    }

    @Override
    public int findIndex(Predicate<V> searcher) {
        StackInterface<TreeNode<K, V>> stack = new StackImplementation<>();
        TreeNode<K, V> current = root;
        TreeNode<K, V> parent = null;
        int index = 0;

        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                parent = current;
                current = current.getLeft();
            } else {
                parent = stack.pop();
                current = parent.getRight();
                if (searcher.test(parent.getValue())) {
                    return index;
                }
                index++;
            }
        }
        return index;
    }

    @Override
    public void accept(Visitor<K, V> visitor) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'accept'");
    }

}
