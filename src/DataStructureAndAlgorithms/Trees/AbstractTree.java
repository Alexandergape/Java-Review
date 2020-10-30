package DataStructureAndAlgorithms.Trees;

import DataStructureAndAlgorithms.LinkedQueue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractTree<E> implements Tree<E> {
    @Override
    public boolean isInternal(Position<E> p) {
        return numChildren(p) > 0;
    }

    @Override
    public boolean isExternal(Position<E> p) {
        return numChildren(p) == 0;
    }

    @Override
    public boolean isRoot(Position<E> p) throws IllegalArgumentException {
        return p == root();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    public int depth(Position<E> p) {
        if (isRoot(p))
            return 0;
        return 1 + depth(parent(p));
    }

    // Returns the height of the tree
    private int heigthBad() { // works, but quadratic worst-case time
        int h = 0;
        for (Position<E> p : positions())
            if (isExternal(p)) // only consider leaf positions
                h = Math.max(h, depth(p));
        return h;
    }

    /* Returns the height of the subtree rooted at Position p. */
    public int heigth(Position<E> p) {
        int h = 0; // base case if p is external
        for (Position<E> c : children(p))
            h = Math.max(h, 1 + heigth(c));
        return h;
    }

    // new methods
    private class ElementIterator implements Iterator<E> {
        Iterator<Position<E>> posIterator = positions().iterator();

        @Override
        public boolean hasNext() {
            return posIterator.hasNext();
        }

        public E next() {
            try {
                return posIterator.next().getElement();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return null;
        }

        public void remove() {
            posIterator.remove();
        }
    }

    public Iterator<E> iterator() {
        return new ElementIterator();
    }

    public Iterable<Position<E>> positions() {
        return preOrder();
    }

    // Adds positions of the subtree rooted at Position p to the given snapshot
    private void preOrderSubtree(Position<E> p, List<Position<E>> snapshot) {
        snapshot.add(p); // for preorder, we add position p before exploring subtrees
        for (Position<E> c : children(p))
            preOrderSubtree(c, snapshot);
    }

    // Returns an iterable collection of positions of the tree, reported in preorder
    public Iterable<Position<E>> preOrder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty())
            preOrderSubtree(root(), snapshot); // fill the snapshot recursively
        return snapshot;
    }

    private void postOrderSubtree(Position<E> p, List<Position<E>> snapshot) {
        for (Position<E> c : children(p))
            postOrderSubtree(c, snapshot);
        snapshot.add(p);
    }

    public Iterable<Position<E>> postOrder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty())
            postOrderSubtree(root(), snapshot);
        return snapshot;
    }

    public Iterable<Position<E>> breathFirst() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
//            Queue<Position<E>> fringe=new LinkedQueue<>();
//            Queue<Position<E>> fringe=new ConcurrentLinkedQueue<>();
//            ConcurrentLinkedQueue
            var fringe = new LinkedQueue<Position<E>>();

            fringe.enqueue(root());
            while (!fringe.isEmpty()) {
                Position<E> p = fringe.dequeue();
                snapshot.add(p);
                for (Position<E> child : children(p))
                    fringe.enqueue(child);
            }
        }
        return snapshot;
    }
}
