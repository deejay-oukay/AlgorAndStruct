package seminar3;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(0);
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addLast(7);
        linkedList.addLast(8);
        linkedList.addLast(9);
        linkedList.print();
        linkedList.reverse();
        linkedList.print();
    }
}
