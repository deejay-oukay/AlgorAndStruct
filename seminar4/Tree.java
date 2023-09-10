package seminar4;

import java.util.Scanner;

public class Tree {
    private static Node root = null;

    public static void main(String[] args) {

        Tree node = new Tree();
        Scanner in = new Scanner(System.in);

        char ch;
        do {
            System.out.print("Введите целое число: ");

            int num = in.nextInt();
            root = node.insert(root, num);

            node.print(root);
            System.out.println("\nПродолжить? [Y/N]");
            ch = in.next().charAt(0);
        } while (ch == 'Y' || ch == 'y');
        in.close();
    }

    class Node {
        int value;
        Node left;
        Node right;
        boolean color; // красный - true, черный - false

        Node(int value) {
            this.value = value;
            left = null;
            right = null;
            color = true; // новый узел, - всегда красноый
        }
    }

    // поворот узла против часовой стрелки
    Node rotateLeft(Node node) {
        System.out.println("Производим поворот влево");
        Node child = node.right;
        Node childLeft = child.left;
        child.left = node;
        node.right = childLeft;
        return child;
    }

    // поворот узла по часовой стрелке
    Node rotateRight(Node node) {
        System.out.println("Производим поворот вправо");
        Node child = node.left;
        Node childRight = child.right;
        child.right = node;
        node.left = childRight;
        return child;
    }

    // проверка узла на "красность"
    boolean isRed(Node node) {
        if (node == null) {
            return false;
        }
        return (node.color == true);
    }

    // обмен узлов цветами
    void swapColors(Node node1, Node node2) {
        boolean temp = node1.color;
        node1.color = node2.color;
        node2.color = temp;
    }

    // вставка
    Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }

        if (value < node.value) {
            node.left = insert(node.left, value);
        } else if (value > node.value) {
            node.right = insert(node.right, value);
        } else {
            return node;
        }

        // правый дочерний - красный, а левый дочерний - черный или не существует
        if (isRed(node.right) && !isRed(node.left)) {
            // повернуть влево
            node = rotateLeft(node);
            // поменять местами цвета
            swapColors(node, node.left);
        }

        // левый потомок и его левый потомок - красные
        if (isRed(node.left) && isRed(node.left.left)) {
            // повернуть вправо
            node = rotateRight(node);
            swapColors(node, node.right);
        }

        // оба потомка - красные
        if (isRed(node.left) && isRed(node.right)) {
            // инвертировать цвет
            node.color = !node.color;
            // изменить цвет на черный
            node.left.color = false;
            node.right.color = false;
        }
        return node;
    }

    void print(Node node) {
        if (node != null) {
            print(node.left);
            char c = 'R';// red
            if (node.color == false)
                c = 'B';// black
            System.out.print(node.value + "" + c + " ");
            print(node.right);
        }
    }

    private boolean contains(int value) {
        if (root == null)
            return false;
        return contains(value, root);
    }

    private boolean contains(int value, Node node) {
        if (node.value == value)
            return true;
        if (value < node.value)
            return contains(value, node.left);
        return contains(value, node.right);
    }
}
