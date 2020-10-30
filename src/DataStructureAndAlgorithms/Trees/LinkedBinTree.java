package DataStructureAndAlgorithms.Trees;

//import DataStructureAndAlgorithms.LinkedQueue;
//import com.sun.jdi.ArrayReference;
//import com.sun.source.tree.BreakTree;

//import java.awt.desktop.PrintFilesEvent;
//import java.io.PipedOutputStream;
//import java.lang.invoke.DelegatingMethodHandle$Holder;

import java.util.*;
//import java.util.concurrent.ConcurrentLinkedQueue;
//import java.util.concurrent.LinkedBlockingQueue;

public /*abstract*/ class LinkedBinTree<E> extends AbstractBinTree<E> {

//    @Override
//    public Iterator<E> iterator() {
//        var list = new ArrayList<E>(size);
//        var node=this.root;
//        while (node!=null) {
//            list.add(node.element);
//            if(node.getLeft()!=null) {
//                node=node.getLeft();
//                list.add(node.element);
//            }
//            if(node.getLeft()!=null)
//        }
////        this.parent()
//        return list.iterator();
//        return null;
//    }
//
//    @Override
//    public Iterable<Position<E>> positions() {
//        return null;
//    }

    public void report(Position<E> p, List<Position<E>> snapshot) {
        snapshot.add(p);
        for (Position<E> child : children(p))
            snapshot.add(child);

    }

    // NESTED NODE CLASS
    protected static class Node<E> implements Position<E> {
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

        // getters
        public E getElement() {
            return element;
        }

        public Node<E> getParent() {
            return parent;
        }

        public Node<E> getLeft() {
            return left;
        }

        public Node<E> getRight() {
            return right;
        }

        // setters
        public void setElement(E e) {
            element = e;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }
    }//----------- end of nested Node class -----------

    protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right) {
        return new Node<>(e, parent, left, right);
    }

    protected Node<E> root = null;
    private int size = 0;

    public LinkedBinTree() {
    }  // constructor

    // Validates the position and returns it as a node
    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node))
            throw new IllegalArgumentException("Not valid position type!");
        Node<E> node = (Node<E>) p; //safe cast
        if (node.getParent() == node) // convention for defunct node
            throw new IllegalArgumentException("p is no longer in the tree!");
        return node;
    }

    public int size() {
        return size;
    }

    public Position<E> root() {
        return root;
    }

    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getParent();
    }

    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getLeft();
    }

    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getRight();
    }

    public Position<E> addRoot(E e) throws IllegalArgumentException {
        if (!isEmpty()) throw new IllegalArgumentException("Tree is not empty!");
        root = createNode(e, null, null, null);
        size = 1;
        return root;
    }

    public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if (parent.getLeft() != null)
            throw new IllegalArgumentException("p already has a left child");
        Node<E> child = createNode(e, parent, null, null);
        parent.setLeft(child);
        size++;
        return child;
    }

    public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if (parent.getRight() != null)
            throw new IllegalArgumentException("p already has a right child");
        Node<E> child = createNode(e, parent, null, null);
        parent.setRight(child);
        size++;
        return child;
    }

    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E temp = node.getElement();
        node.setElement(e);
        return temp;
    }

    // Attaches trees t1 and t2 as left and right subtrees of external p
    public void attach(Position<E> p, LinkedBinTree<E> t1, LinkedBinTree<E> t2) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if (isInternal(p)) throw new IllegalArgumentException("p must be a leaf!");
        size += t1.size() + t2.size();
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
    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if (numChildren(p) == 2)
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

    public void add(Node<E> Parent, E element) {
        if (root == null) {
//        Node<E> par=new Node<>()
            this.addRoot(element);
            return;
        }
//        if(Parent.getLeft())
    }


//    public LinkedList<E> PrintByLevel() {
//        LinkedList<Node<E>> list = new LinkedList<Node<E>>();
//        var elements = new LinkedList<E>();
//        return BreadthFirst(list, elements, 0);
//    }

//    private LinkedList<E> BreadthFirst(LinkedList<Node<E>> list, LinkedList<E> elements, int pos) {
////        var elements = new LinkedList<E>();
//        if (list.size() == 0) {
//            if (this.root == null) return null;
//            list = new LinkedList<>();
//            list.add(root);
//            elements.add(root.element);
//            pos = 0;
//        }
//        int cont = 0;
////        for (int i=list.size()-pos; i<list.size();i++){
////            for (Node<E> N=list.get(pos); list.; list.)
//        for (Node<E> N : list) {
//            if (N.getLeft() != null) {
//                list.add(N.getLeft());
//                elements.add(N.getLeft().element);
////                cont++;
//            }
//            if (N.getRight() != null) {
//                list.add(N.getRight());
//                elements.add(N.getRight().element);
////                cont++;
//            }
//            list.removeFirst();
//        }
////        for (int i = 0; i < list.size() - pos; i++) {
////            list.removeFirst();
////        }
//
//        if (list.size() == 0) return elements;
//
////        LinkedList<E> l = new LinkedList<>();
////        l.get()
//        //        Queue q=new Queue();
////        ConcurrentLinkedQueue s=new ConcurrentLinkedQueue();
//
//        return BreadthFirst(list, elements, cont);
//    }

    public int getLevel(Node<E> node, int level) { // when calling this method level must be zero (0)
        if (node == root) return level;
        return getLevel(node.getParent(), level + 1);
    }
}
