package DataStructureAndAlgorithms;

import java.util.Iterator;

public class SinglyLinkedList<E> implements Iterable<E> {

    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n) {
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
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return (currentIndex < size/* && (getI(currentIndex)!=null)*/);
            }

            @Override
            public E next() {
                return getI(currentIndex++);
            }
        };
    }

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public int size() {
        return size;
//        System.out.println(SinglyLinkedList<>[0]);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) return null;
        return head.getElement();
    }

    public E last() {
        if (isEmpty()) return null;
        return tail.getElement();
    }

    public void addFirst(E e) {
        head = new Node<>(e, head);
        if (size == 0)
            tail = head;
        size++;
    }

    public void addLast(E e) {
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

    // The next methods were added by me

    public E getI(int pos) {
//        if (!(pos>=0 && pos <size))
//            System.out.println("\nThe entered position is not valid.\n");
//        else {
        Node<E> headCopy = head;
        while (pos > 0) {
//                System.out.print(headCopy.element.toString() + '\t');
            headCopy = headCopy.getNext();
            pos--;
        }
//            if (headCopy.getElement()!=null) {
//                System.out.println("\nnull0");
////                return null;
//            }else System.out.println("nu11");
        return headCopy.getElement();
//        }
    }

    private Node<E> getNode(int pos){
        Node<E> headCopy = head;
        while (pos > 0) {
            headCopy = headCopy.getNext();
            pos--;
        }
        return  headCopy;
    }

//    public E getAll(){ // already developed above
//        Node<E> headCopy = head;
//        while (headCopy!=null) {
////                System.out.print(headCopy.element.toString() + '\t');
//            headCopy = headCopy.getNext();
//        }
//        yield headCopy.getElement();
//    }

//    public SinglyLinkedList<E> report() { // list all the elements in the list
//        if (isEmpty()) System.out.println("\nThe list is empty.\n");
////        else {
////            Node<E> headCopy = head;
////            while (headCopy != null) {
////                System.out.print(headCopy.element.toString() + '\t');
////                headCopy = headCopy.getNext();
////            }
////        }
//        return this;
//    }

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
//            System.out.println("\nThe entered position is not valid.\n");
//        Node<E> headCopy = head;
//        for (int i = 0; i < this.size; i++)
//            headCopy = headCopy.next;
        getNode(pos).element=newVal;
//        headCopy.element = newVal;
//            for (E e : this)
        return 0;
    }

    public int delete(int pos) {
        if (pos < 0 || pos >= size)
            return 1; //error

//        this.getI(pos);
        if (pos==0) // first position
                head=head.getNext();
        else if(pos<size-1){ // intermediate position
            Node<E> aux = getNode(pos-1);
            aux.setNext(getNode(pos+1));
        }else{ // last position
            getNode(size-1).setNext(null);
//            this.tail=null;
        }
        size--;
        if (size==0)
            tail=null;
        return 0;
    }

    public int add(int pos, E e){
        if (pos < 0 || pos > size)
            return 1; //error
        if (pos==0) {
//            Node<E> aux=new Node<>(e, head);
//            if (size==0)
//                tail.setNext(new Node<>(e, null));

            head = new Node<>(e, head);
        }
        else if(pos<size-1){
//            getNode(pos).setNext(new Node<>(e, getNode(pos)/*null*/));
//            getNode(pos)= new Node<>(e, getNode(pos)/*null*/);
//
            Node<E> aux=head;
            for (int i=0;i<pos;i++){
                head=head.getNext();
            }
            head=new Node<>(e, getNode(pos)/*null*/);
            head=aux;
//            getNode(pos).setNext(getNode(pos+1));
        }else{
            Node<E> aux=new Node<>(e,null);
            tail.setNext(aux);
            tail=aux;
        }
        if(size==0)tail=head;
        size++;
        return 0; // success
    }
}
//    public void addFirst(E e) {
//        head = new Node<>(e, head);
//        if (size == 0)
//            tail = head;
//        size++;
//    }
//
//    public void addLast(E e) {
//        Node<E> newest = new Node<>(e, null);
//        if (isEmpty()) head = newest;
//        else
//            tail.setNext(newest);
//        tail = newest;
//        size++;
//    }
