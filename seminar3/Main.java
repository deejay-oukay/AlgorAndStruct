package seminar3;

public class Main {
    public static void main(String[] args) {
        TwoLinkedList linkedList = new TwoLinkedList();
        linkedList.addFirst(0);
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addLast(7);
        linkedList.addLast(8);
        linkedList.addLast(9);
        linkedList.print();
        linkedList.bubbleSort();
        linkedList.print();
    }
}
