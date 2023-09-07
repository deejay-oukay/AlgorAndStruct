package seminar3;

public class LinkedList {
    private Node head;

    public void addFirst(int value) {
        Node node = new Node();
        node.value = value;
        node.next = head;
        head = node;
    }

    public void addLast(int value) {
        Node newNode = new Node();
        newNode.value = value;
        newNode.next = null;

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void removeFirst() {
        if (head != null) {
            head = head.next;
        }
    }

    public void removeLast() {
        if (head == null)
            return;
        Node current = head.next;
        while (current.next != null) {
            if (current.next.next == null) {
                current.next = null;
                return;
            }
            current = current.next;
        }
        head = null;
    }

    public boolean contains(int value) {
        Node current = head;
        while (current != null) {
            if (current.value == value)
                return true;
            current = current.next;
        }
        return false;
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    private class Node {
        private Node next;
        private int value;
    }
}
