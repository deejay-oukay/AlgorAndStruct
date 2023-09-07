package seminar3;

public class TwoLinkedList {
    private Node head;
    private Node tail;

    public void addFirst(int value) {
        Node node = new Node();
        node.value = value;
        if (head != null) {
            node.next = head;
            head.prev = node;
        } else {
            tail = node;
        }
        head = node;
    }

    public void addLast(int value) {
        Node newNode = new Node();
        newNode.value = value;
        newNode.next = null;
        newNode.prev = null;

        if (tail == null) {
            head = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
        }
        tail = newNode;
    }

    public void removeFirst() {
        if ((head != null) && (head.next != null)) {
            head.next.prev = null;
            head = head.next;
        } else {
            head = null;
            tail = null;
        }
    }

    public void removeLast() {
        if (tail != null) {
            tail.prev.next = null;
            tail = tail.prev;
        } else {
            head = null;
            tail = null;
        }
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

    public void bubbleSort() {
        boolean needSort;
        do {
            needSort = false;
            Node node = head;
            while ((node != null) && (node.next != null)) {
                if (node.value > node.next.value) {
                    // вариант с семинара - меняются ссылки, а не значения
                    // Node before = node.prev;
                    // Node after = node.next.next;
                    // Node current = node;
                    // Node nextNode = node.next;
                    // current.next = after;
                    // current.prev = nextNode;
                    // nextNode.next = current;
                    // nextNode.prev = before;
                    // if (before != null) {
                    // before.next = nextNode;
                    // } else {
                    // head = nextNode;
                    // }
                    // if (after != null) {
                    // after.prev = current;
                    // } else {
                    // tail = current;
                    // }

                    // мой вариант - меняются значения, а не ссылки
                    int temp = node.value;
                    node.value = node.next.value;
                    node.next.value = temp;

                    needSort = true;
                }
                node = node.next;
            }
        } while (needSort);
    }

    public void print() {
        Node node = head;
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    private class Node {
        private Node next;
        private Node prev;
        private int value;
    }
}
