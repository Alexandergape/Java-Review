import DataStructureAndAlgorithms.SinglyLinkedList;

import javax.print.attribute.standard.NumberOfDocuments;

public class DoublyLinkedList<E> {
    private static class Node<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }//----------- end of nested Node class -----------

    // instance variables of the DoublyLinkedList
    private Node<E> header; // header sentinel
    private Node<E> trailer; // trailer sentinel
    private int size = 0;

    /* Constructs a new empty list. */
    public DoublyLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, null, null);
        header.setNext(trailer); // header is followed by trailer
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) return null;
        return header.getNext().getElement(); // first element is beyond header
    }

    public E last() {
        if (isEmpty()) return null;
        return trailer.getPrev().getElement(); // last element is before trailer
    }

    public void addFirst(E e) {
        addBetween(e, header, header.getNext()); // place just after the header
    }

    public void addLast(E e) {
        addBetween(e, header, trailer.getPrev()); // place just before the trailer
    }

    public E removeFirst() {
        if (isEmpty()) return null;
        return remove(header.getNext());
    }

    public E removeLast() {
        if (isEmpty()) return null;
        return remove(trailer.getPrev());
    }

    // Adds element e to the linked list in between the given nodes.
    private void addBetween(E e, Node<E> predecessor, Node<E> sucessor) {
        // create and link a new node
        Node<E> newest = new Node<>(e, predecessor, sucessor);
        predecessor.setNext(newest);
        sucessor.setPrev(newest);
        size++;
    }

    private E remove(Node<E> node){
        Node<E> predecessor=node.getPrev();
        Node<E> sucessor=node.getNext();
        predecessor.setNext(sucessor);
        sucessor.setPrev(predecessor);
        size--;
        return node.getElement();
     }

     // not implemented yet
//     public boolean equals(Object o, Class<E> eClass){
//        if(o==null)return false;
//        if(getClass()!=o.getClass())return false;
//         SinglyLinkedList<eClass> other;
//     }
}
