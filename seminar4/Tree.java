package seminar4;

public class Tree {
    Node root;

    private class Node {
        private int value;
        private Node left;
        private Node right;
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
