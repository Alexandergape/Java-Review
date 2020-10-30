package DataStructureAndAlgorithms.Trees;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBinTree<E> extends AbstractTree<E> implements BinTree<E> {

    // Returns the Position of p's sibling (or null if no sibling exists).
    public Position<E> sibling(Position<E> p) {
        Position<E> parent = parent(p);
        if (parent == null) return null; // p must be the root
        if (p == left(parent)) return right(parent); // p is a left child
        else // p is a right child
            return left(parent); // (left child might be null)
    }

    // Returns the number of children of Position p.
    @Override
    public int numChildren(Position<E> p) {
        int count = 0;
        if (left(p) != null)
            count++;
        if (right(p) != null)
            count++;
        return count;
    }

    // Returns an iterable collection of the Positions representing p's children.
    @Override
    public Iterable<Position<E>> children(Position<E> p) {
        List<Position<E>> snapshot = new ArrayList<>(2);
        if (left(p) != null)
            snapshot.add(left(p));
        if (right(p) != null)
            snapshot.add(right(p));
        return snapshot;
    }

    // new methods
    private void inOrderSubtree(Position<E> p, List<Position<E>> snapshot) {
        if (left(p) != null)
            inOrderSubtree(left(p), snapshot);
        snapshot.add(p);
        if(right(p)!=null)
            inOrderSubtree(right(p), snapshot);
    }

    public Iterable<Position<E>> inOrder(){
        List<Position<E>> snapshot=new ArrayList<>();
        if(!isEmpty())
            inOrderSubtree(root(), snapshot);
        return snapshot;
    }

    @Override
    public Iterable<Position<E>> positions(){
        return inOrder();
    }
}
