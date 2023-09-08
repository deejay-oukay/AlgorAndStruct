package seminar4;

import java.lang.reflect.Array;

public class HashTable<K, V> {
    private static final int INT_BASKET_COUNT = 16;
    private static final double LOAD_FACTOR = .75;

    private Basket[] baskets;
    private int size = 0;

    public HashTable(int initSize) {
        this.baskets = (Basket[]) Array.newInstance(Basket.class, initSize);
    }

    public HashTable() {
        this(INT_BASKET_COUNT);
    }

    private void recalculate() {
        Basket[] old = baskets;
        baskets = (Basket[]) new Object[old.length * 2];
        for (int i = 0; i < old.length; i++) {
            Basket basket = old[i];
            Basket.Node node = basket.head;
            while (node != null) {
                add(node.value.key, node.value.value);
                node = node.next;
            }
            old[i] = null;
        }
    }

    private int calculateBasketIndex(K key) {
        return key.hashCode() % baskets.length;
    }

    public V get(K key) {
        int index = calculateBasketIndex(key);
        Basket basket = baskets[index];
        if (basket != null) {
            return basket.get(key);
        }
        return null;
    }

    public boolean add(K key, V value) {
        if (baskets.length * LOAD_FACTOR < size)
            recalculate();
        int index = calculateBasketIndex(key);
        Entity entity = new Entity(key, value);
        Basket basket = baskets[index];
        if (basket == null) {
            basket = new Basket();
            baskets[index] = basket;
        }
        boolean add = basket.add(entity);
        if (add)
            size++;
        return add;
    }

    public boolean remove(K key) {
        int index = calculateBasketIndex(key);
        Basket basket = baskets[index];
        if (basket == null)
            return false;
        boolean remove = basket.remove(key);
        if (remove)
            size--;
        return remove;
    }

    private class Entity {
        private K key;
        private V value;

        public Entity(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private class Basket {
        private Node head;

        public V get(K key) {
            Node current = head;
            while (current != null) {
                if (current.value.key.equals(key))
                    return current.value.value;
                current = current.next;
            }
            return null;
        }

        public boolean remove(K key) {
            if (head != null) {
                Entity entity = head.value;
                if (entity.key.equals(key)) {
                    head = head.next;
                } else {
                    Node node = head;
                    while (node.next != null) {
                        Entity entityNext = node.next.value;
                        if (entityNext.key.equals(key)) {
                            node.next = node.next.next;
                            return true;
                        }
                        node = node.next;
                    }
                }

            }
            return false;
        }

        public boolean add(Entity entity) {
            Node node = new Node();
            node.value = entity;
            if (head != null) {
                Node current = head;
                while (current != null) {
                    if (current.value.key.equals(entity.key)) {
                        return false;
                    }
                    if (current.next == null) {
                        current.next = node;
                        return true;
                    } else {
                        current = current.next;
                    }
                }
            }
            head = node;
            return true;
        }

        private class Node {
            private Node next;
            private Entity value;
        }
    }
}
