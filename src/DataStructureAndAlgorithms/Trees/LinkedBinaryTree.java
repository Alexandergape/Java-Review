package DataStructureAndAlgorithms.Trees;

import java.util.*;
import java.util.List;

public class LinkedBinaryTree<E> {
    protected static class Node<E> {
        private E element; // an element stored at this node
        private Node<E> parent; // a reference to the parent node (if any)
        private Node<E> left; // a reference to the left child (if any)
        private Node<E> right; // a reference to the right child (if any)

        //Constructs a node with the given element and neighbors
        public Node(E e, Node<E> parent, Node<E> left, Node<E> right) {
            element = e;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getParent() {
            return parent;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }
    }

    protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right) {
        return new Node<>(e, parent, left, right);
    }

    protected Node<E> root = null;
    private int size = 0;

    public LinkedBinaryTree() {
    }  // constructor

    public Node<E> getRoot() {
        return root;
    }

    public void setRoot(Node<E> root) {
        this.root = root;
    }

    public int getSize() {
        return size;
    }

    // delete this method
    public void setSize(int size) {
        this.size = size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Node<E> getParent(Node<E> node) throws IllegalArgumentException {
//        Node<E> node = validate(p);
        return node.getParent(); // this is not recursive
    }

    public Node<E> getLeft(Node<E> node) throws IllegalArgumentException {
//        LinkedBinTree.Node<E> node = validate(p);
        return node.getLeft();
    }

    public Node<E> getRight(Node<E> node) throws IllegalArgumentException {
//        LinkedBinTree.Node<E> node = validate(p);
        return node.getRight();
    }

    public Node<E> addRoot(E e) throws IllegalArgumentException {
        if (!isEmpty()) throw new IllegalArgumentException("Tree is not empty!");
        root = createNode(e, null, null, null);
        size = 1;
        return root;
    }

    public Node<E> addLeft(Node<E> parent, E e) throws IllegalArgumentException {
//        LinkedBinTree.Node<E> parent = validate(p);
        if (parent.getLeft() != null)
            throw new IllegalArgumentException("p already has a left child");
        Node<E> child = createNode(e, parent, null, null);
        parent.setLeft(child);
        size++;
        return child;
    }

    public Node<E> addRight(Node<E> parent, E e) throws IllegalArgumentException {
//        LinkedBinTree.Node<E> parent = validate(p);
        if (parent.getRight() != null)
            throw new IllegalArgumentException("p already has a right child");
        Node<E> child = createNode(e, parent, null, null);
        parent.setRight(child);
        size++;
        return child;
    }


    public E set(Node<E> node, E e) throws IllegalArgumentException {
//        LinkedBinTree.Node<E> node = validate(p);
        E temp = node.getElement();
        node.setElement(e);
        return temp;
    }

    private int numChildren(Node<E> node) {
        int n = 0;
        if (node.getRight() != null) n++;
        if (node.getLeft() != null) n++;
        return n;
    }

    private boolean isInternal(Node<E> node) {
        return (numChildren(node) > 0);
    }

    private boolean isExternal(Node<E> node) {
        return (numChildren(node) == 0);
    }


    // Attaches trees t1 and t2 as left and right subtrees of external p
    public void attach(Node<E> node, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) throws IllegalArgumentException {
//        LinkedBinTree.Node<E> node = validate(p);
        if (isInternal(node)) throw new IllegalArgumentException("p must be a leaf!");
        size += t1.getSize() + t2.getSize();
        if (!t1.isEmpty()) { // attach t1 as left subtree of node
            t1.root.setParent(node);
            node.setLeft(t1.root);
            t1.root = null;
            t1.size = 0;
        }
        if (!t2.isEmpty()) { // attach t2 as right subtree of node
            t2.root.setParent(node);
            node.setLeft(t2.root);
            t2.root = null;
            t2.size = 0;
        }
    }

    // Removes the node at Position p and replaces it with its child, if any
    public E remove(Node<E> node) throws IllegalArgumentException {
//        LinkedBinTree.Node<E> node = validate(p);
        if (numChildren(node) == 2)
            throw new IllegalArgumentException("p has two children!");
        Node<E> child = (node.getLeft() != null ? node.getLeft() : node.getRight());
        if (child != null)
            child.setParent(node.getParent()); // child’s grandparent becomes its parent
        if (node == root)
            root = child; // child becomes root
        else {
            Node<E> parent = node.getParent();
            if (node == parent.getLeft())
                parent.setLeft(child);
            else parent.setRight(child);
        }
        size--;
        E temp = node.getElement();
        node.setElement(null); // help garbage collection
        node.setRight(null);
        node.setLeft(null);
        node.setParent(node); // convention for defunct node
        return temp;
    }

    // Added by me...

    // save elements in order
    public void add(E element) {
        if (root == null) {
            this.addRoot(element);
            size = 1;
            return;
        }
        Node<E> Parent = root;
        while (Parent != null) {
//            if (Parent.getElement().hashCode() < element.hashCode()) {
            if (Parent.getElement().toString().compareTo(element.toString()) < 0) {
                System.out.println("Parent: " + Parent.getElement().toString() + "element: " + element.toString());
                if (Parent.getRight() != null)
                    Parent = Parent.getRight(); // keep searching a location
                else {
                    Parent.setRight(new Node<>(element, Parent, null, null));
                    break;
                }
//            } else if (Parent.getElement().hashCode()<element.hashCode()) {
            } else if (Parent.getElement().toString().compareTo(element.toString()) > 0) {
                if (Parent.getLeft() != null)
                    Parent = Parent.getLeft();
                else {
                    Parent.setLeft(new Node<>(element, Parent, null, null));
                    break;
                }
            } else {
                System.out.println("\n\tThis element already exists");
                break;
            }
        }
        size++;
    }

    private Iterable<Node<E>> children(Node<E> node) {
        var children = new LinkedList<Node<E>>();
        if (node.getLeft() != null) children.add(node.getLeft());
        if (node.getRight() != null) children.add(node.getRight());
        return children;
    }


    public Iterable<E> BreadthFirst() {
        var nodes = new LinkedList<Node<E>>();
        var elements = new LinkedList<E>();
        if (this.root == null) return null;
        nodes.add(root);
        Node<E> node;

        while (nodes.size() > 0) {
            node = nodes.removeFirst();
            elements.add(node.getElement());
            nodes.addAll((Collection<? extends Node<E>>) children(node)); // add all the elements in the list of children of each
        }
        return elements;
    }

    public int getLevel(Node<E> node, int level) { // when calling this method level must be zero (0)
        if (node == root) return level;
        return getLevel(node.getParent(), level + 1);
    }

    //    public LinkedList<E> inOrder() {
//        if (root == null) return null;
//        Node<E> node = root;
//        var elements = new LinkedList<E>();
//
//        while (elements.size() != size) {
//            while (node != null) {
//                if (node.getLeft() != null)
//                    node = node.getLeft();
//                else break;
//            }
//            elements.add(node.element); // add the left child, or the right one
//            if (node.getParent() != null) {
//                node = node.getParent();
//                elements.add(node.element); // add the parent
//            }
////            else elements.add(node.getElement());
//            if (node.getRight() != null)
//                node = node.getRight(); // move to the right child
////            break;
//        }
//        return elements;
//    }
    public Iterable<E> inOrder() {
        LinkedList<Node<E>> nodes = new LinkedList<>();
        inOrder(root, nodes);
        var elements = new LinkedList<E>();
        for (Node<E> node : nodes)
            elements.add(node.getElement());
        return elements;
    }

    private void inOrder(Node<E> parent, List<Node<E>> elements) {
        if (parent.getLeft() != null)
            inOrder(parent.getLeft(), elements);
        elements.add(parent);
        if (parent.getRight() != null)
            inOrder(parent.getRight(), elements);
    }

    public Iterable<E> postOrder() {
        List<E> elements = new ArrayList<>();
        postOrder(root, elements);
        return elements;
    }

    private void postOrder(Node<E> node, List<E> elements) {
        for (Node<E> child : children(node))
            postOrder(child, elements);
        elements.add(node.getElement()); // for postOrder, we add position p after exploring subtrees
    }

    public Iterable<E> preOrder() {
        List<E> elements = new ArrayList<>();
        preOrder(root, elements);
        return elements;
    }

    private void preOrder(Node<E> node, List<E> elements) {
        elements.add(node.getElement());
        for (Node<E> child : children(node))
            preOrder(child, elements);
    }

    private int compare(E e1, E e2) {
        int comp;
        if (isNumeric(e1.toString()) && isNumeric(e2.toString()))
            comp = Double.compare(Double.parseDouble(e1.toString()), Double.parseDouble(e2.toString()));
        else comp = e1.toString().compareTo(e2.toString());
        return comp;
    }

//    public Node<E> search(Node<E> node, E element) {
//        if (isExternal(node)) return null; // if not found, return null
//
//        int comp = compare(node.element, element);
////        if (isNumeric(element.toString()) && isNumeric(node.getElement().toString()))
////            comp = Double.compare(Double.parseDouble(node.getElement().toString()), Double.parseDouble(element.toString()));
////        else comp = node.getElement().toString().compareTo(element.toString());
//
//        if (comp == 0)
//            return node;
//        if (comp < 0)
//            return search(node.getRight(), element);
//        else
//            return search(node.getLeft(), element);
//    }

    public LinkedBinaryTree<E> search(Node<E> node, E element) {
        if (isExternal(node)) return null; // if not found, return null

        int comp = compare(node.element, element);
//        if (isNumeric(element.toString()) && isNumeric(node.getElement().toString()))
//            comp = Double.compare(Double.parseDouble(node.getElement().toString()), Double.parseDouble(element.toString()));
//        else comp = node.getElement().toString().compareTo(element.toString());
        var tree =new LinkedBinaryTree<E>();
        if (comp == 0) {
            tree.add(element);//tree.root.setParent(null);
            return tree;
        }
        if (comp < 0) {
            return search(node.getRight(), element);
        }
        else
            return search(node.getLeft(), element);
    }

//    public void delete(E element) {
////        List<Node<E>> nodes;
////        inOrder(root, nodes);
////        for (Node<E> node : nodes)
////            if (node.getElement() == element){
//
//        Node<E> node = search(root, element);
//        if (node == null) return; // check if the element exists
//
//        int comp = compare(node.element, element);
//
//        if (isExternal(node)) {
//            if (node.getParent() != null) {
//                node = node.getParent();
//                if (comp < 0) node.setRight(null);
//                else
//            } else node = null;
//
//            if (node.getLeft() != null)
//                node.setLeft(null);
//            else
//                node.setRight(null);
//            return;
//        }
//        if (numChildren(node) == 1) {
////            Node<E> aux=node;
////            node = node.getParent();
////            if (node.getLeft() != null) aux=node.getLeft();
////            else aux=node.getRight();
////            node
//
//            if (node.getLeft() != null) {
//                node = node.getLeft();
//                node.setLeft(null);
//            } else {
//                node = node.getRight();
//                node.setRight(null);
//            }
//            return;
//
//
//        }
//        int a = (node.getLeft() == null ? node.setLeft(null) : node.setRight(null));
//
//
////            }
//    }

    private static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }
}
