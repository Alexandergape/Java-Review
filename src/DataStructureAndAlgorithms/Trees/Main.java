package DataStructureAndAlgorithms.Trees;

import DataStructureAndAlgorithms.SortingMethods.HeapSort;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        System.out.println("test");
        LinkedBinTree<Integer> tree = new LinkedBinTree<>();

        var t2 = new LinkedBinTree<String>();
//        auto t2=new Scanner.in;
        tree.addRoot(0);
//        tree.root.setLeft(new LinkedBinaryTree.Node<>(1, tree.root, null, null));
//        tree.createNode(1, tree.root, null, null);
        tree.addLeft(tree.root, 1); // error

        System.out.println((tree.root.getElement()));
        System.out.println(tree.root.getLeft().getElement());
        tree.addRight(tree.root, 2);
        System.out.println(tree.root.getRight().getElement());

//        tree.parent(tree.root); // this is a position

//        tree.addLeft(tree.left(tree.parent(tree.root)), 5); // error: root has no parent

//        tree.addLeft(tree.root(), 5); // error: p already has a left child
        tree.addLeft(tree.left(tree.root), 5);
        System.out.println(tree.root.getLeft().getLeft().getElement());
        System.out.println("\n");

        System.out.println("Level: " + tree.getLevel(tree.root.getLeft().getLeft(), 0));

        printPreorderIndent(tree, tree.root(), 0);

        var nums = new LinkedBinaryTree<Double>();
//        add(nums, 17);
//        add(nums, 25);
//        add(nums, 12);
//        add(nums, 5);
//        add(nums, 16);
//        add(nums, 20);
//        add(nums, 29);
//        add(nums, 19);
//        add(nums, 22);
//        add(nums, 21);
//        add(nums, 25);
//
//        nums.setSize(10);

        nums.add(17.);
        nums.add(17.);
        nums.add(25.);
        nums.add(12.);
        nums.add(2.);
        nums.add(16.);
        nums.add(20.);
        nums.add(29.);
        nums.add(19.);
        nums.add(22.);
        nums.add(21.);
        nums.add(-25.4);


        System.out.println("\nBreadthFirst: ");
        for (Double i : nums.BreadthFirst())
            System.out.print(i + ", ");

//        System.out.println("\nComp: "+"17".compareTo("5"));
//        System.out.println("\nComp: "+"17".hashCode()+",   5 :"+"5".hashCode());
        System.out.println("\ninOrder: ");
        for (Double i : nums.inOrder())
            System.out.print(i + ", ");

        System.out.println("\npreOrder: ");
        for (Double i : nums.preOrder())
            System.out.print(i + ", ");

        System.out.println("\npostOrder: ");
        for (Double i : nums.postOrder())
            System.out.print(i + ", ");


        System.out.println("\nNew subtree");
        var t = nums.search(nums.root, 12.0);
        System.out.println(t.root.getElement());
        for (Double d : t.BreadthFirst())
            System.out.print(d + ", ");

//        var heapSort=new HeapSort();
        int[] arr = new int[nums.getSize()];//=Integer.nums.BreadthFirst();
        int i = 0;
        for (Double d : nums.BreadthFirst()) {
            arr[i] = (int) Math.round(d);//Integer)d;Double.in
            i++;
        }
        HeapSort.heapSort(arr);

        System.out.println("\nSorted:");
        for (int in : arr)
            System.out.println(in);
    }


    private static void add(LinkedBinaryTree<Integer> tree, Integer element) {
        if (tree.root == null) {
            tree.addRoot(element);
//            size=1;
            return;
        }
        LinkedBinaryTree.Node<Integer> Parent = tree.root;
        while (Parent != null) {
            if (Parent.getElement() < element) {
//                System.out.println("Parent: "+Parent.getElement().toString()+ "element: "+element.toString());
                if (Parent.getRight() != null)
                    Parent = Parent.getRight(); // keep searching a location
                else {
                    Parent.setRight(new LinkedBinaryTree.Node<>(element, Parent, null, null));
                    break;
                }
            } else if (Parent.getElement() > element) {
                if (Parent.getLeft() != null)
                    Parent = Parent.getLeft();
                else {
                    Parent.setLeft(new LinkedBinaryTree.Node<>(element, Parent, null, null));
                    break;
                }
            } else {
                System.out.println("\n\tThis element already exists");
                break;
            }
        }
//        size++;
    }

    private static String spaces(int n) {
        return " ".repeat(Math.max(0, n));
    }

    public static <E> void printPreorderIndent(Tree<E> T, Position<E> p, int d) throws IllegalAccessException {
        String s = spaces(2 * d);
        E ele = p.getElement();
        System.out.println(s + ele); // indent based on d
        for (Position<E> c : T.children(p))
            printPreorderIndent(T, c, d + 1); // child depth is d+1
    }


    // Prints labeled representation of subtree of T rooted at p having depth d.
    public static <E>
    void printPreorderLabeled(Tree<E> T, Position<E> p, ArrayList<Integer> path) throws IllegalAccessException {
        int d = path.size(); // depth equals the length of the path
        String s = spaces(2 * d);
        System.out.print(s); // print indentation, then label
        for (int j = 0; j < d; j++) {
            String a = (j == d - 1 ? " " : ".");
            System.out.print(path.get(j) + a);
        }
        System.out.println(p.getElement());
        path.add(1); // add path entry for first child
        for (Position<E> c : T.children(p)) {
            printPreorderLabeled(T, c, path);
            path.set(d, 1 + path.get(d)); // increment last entry of path
        }
        path.remove(d);
    }

    public static void menu() {
        LinkedBinTree<Integer> tri = new LinkedBinTree<>();
        int opt;
        var S = new Scanner(System.in);
        do {
            System.out.println("1. Add element");
            System.out.println("2. Remove element");
            System.out.println("3. Update element");
            System.out.println("4. List all");
            System.out.println("5. Exit");
            opt = S.nextInt();

            switch (opt) {
                case 1:
                    System.out.println("Select a position from top to bottom, and from left to right: ");


                    break;
                case 2:

                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println("bad option");
            }
        } while (opt != 0);
    }
}
