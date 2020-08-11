package DataStructureAndAlgorithms;

import java.util.Iterator;

public class SinglyLinkedList<E> implements Iterable<E> {

    private static class Node<E> {
        private E element; // reference to the node stored at this node
        private Node<E> next;// the subsequent node in the list

        public Node(E e, Node<E> n) { // constructor
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    }

    @Override
    public Iterator<E> iterator() { // allows implementing for-each loop and show all the content
        return new Iterator<E>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return (currentIndex < size/* && (getI(currentIndex)!=null)*/); // I don't see useful the commented part
            }

            @Override
            public E next() {
                return get(currentIndex++);
            }
        };
    }

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addLast(E e) { // adds an element to the end of the list
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()) head = newest;
        else
            tail.setNext(newest);
        tail = newest;
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) return null;
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if (size == 0)
            tail = null;
        return answer;
    }

    public E get(int pos) {
        Node<E> headCopy = head;
        while (pos > 0) {
            headCopy = headCopy.getNext();
            pos--;
        }
        return headCopy.getElement();
    }

    private Node<E> getNode(int pos) {
        Node<E> headCopy = head;
        while (pos > 0) {
            headCopy = headCopy.getNext();
            pos--;
        }
        return headCopy;
    }

    public int search(E e) { // prints out all the matches of the searched object
        if (isEmpty()) return -1;
        Node<E> headCopy = head;
        int pos = 0;
        while (headCopy != null) {
            if (head.toString().equals(e.toString()))
                break;
            pos++;
            headCopy = headCopy.getNext();
        }
        return pos; //if success, return the position where the object was found
    }

    public int update(int pos, E newVal) {
        if (pos < 0 || pos >= size)
            return 1; //error
        getNode(pos).element = newVal;
        return 0;
    }

    public int delete(int pos) {
        if (pos < 0 || pos >= size)
            return 1; //error
        if (pos == 0) // first position
            head = head.getNext();
        else if (pos < size - 1) { // intermediate position
            Node<E> aux = getNode(pos - 1);
            aux.setNext(getNode(pos + 1));
        } else { // last position
            getNode(size - 1).setNext(null);
        }
        size--;
        if (size == 0)
            tail = null;
        return 0;
    }

    public int add(int pos, E e) {
        if (pos < 0 || pos > size)
            return 1; //error
        if (pos == 0) {
            head = new Node<>(e, head);
        } else if (pos < size - 1) {
            Node<E> neu = new Node<>(e, getNode(pos)); // neu is new in German
            getNode(pos - 1).setNext(neu);
            neu.setNext(getNode(pos + 1));
        } else {
            Node<E> aux = new Node<>(e, null);
            tail.setNext(aux);
            tail = aux;
        }
        if (size == 0) tail = head;
        size++;
        return 0; // success
    }
}
