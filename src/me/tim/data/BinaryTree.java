package me.tim.data;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class BinaryTree {

    private static Node emptyNode(int id) {
        return new Node(id);
    }

    private static Node insertNode(Node root, int id) {
        if (root == null) return emptyNode(id);

        if (root.getId() < id) root.setRight(insertNode(root.getRight(), id));
        if (root.getId() > id) root.setLeft(insertNode(root.getLeft(), id));
        return root;
    }

    private static int treeSum(Node root) {
        if (root == null) return 0;
        return root.getId() + treeSum(root.getLeft()) + treeSum(root.getRight());
    }

    private static ArrayList<Node> depthFirst(Node root) {
        ArrayList<Node> finalList = new ArrayList<>(), stack = new ArrayList<>();
        stack.add(root);

        while (stack.size() > 0)
        {
            Node current = stack.get(0);
            stack.remove(0);
            finalList.add(current);

            if (current.getLeft() != null) {
                stack.add(current.getLeft());
            }

            if (current.getRight() != null) {
                stack.add(current.getRight());
            }
        }
        return finalList;
    }

    private static boolean treeIncludes(Node root, int id) {
        for (Node node : depthFirst(root)) {
            if (node.getId() == id) return true;
        }
        return false;
    }

    private static int treeMax(Node root) {
        int max = Integer.MIN_VALUE;
        for (Node node : depthFirst(root)) {
            if (node.getId() > max) max = node.getId();
        }
        return max;
    }

    private static int treeMin(Node root) {
        int min = Integer.MAX_VALUE;
        for (Node node : depthFirst(root)) {
            if (node.getId() < min) min = node.getId();
        }
        return min;
    }

    public static void main(String[] args) {
        Node rootNode = null;
        rootNode = insertNode(rootNode, 1);
        rootNode = insertNode(rootNode, 21);
        rootNode = insertNode(rootNode, 61);
        rootNode = insertNode(rootNode, 11);

        System.out.println(treeMax(rootNode));
    }

    public static class Node {
        private int id;
        private Node left, right;

        public Node(int id, Node left, Node right) {
            this.id = id;
            this.left = left;
            this.right = right;
        }

        public Node(int id) {
            this(id, null, null);
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}
