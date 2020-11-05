package DataStructureAndAlgorithms;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> mySL = new SinglyLinkedList<>();

//        mySL.addFirst(78);
        mySL.addLast(50);
        mySL.addLast(940);

        System.out.print("AHHHHHH");
        int a = 8;
        System.out.println(mySL.getClass().getName());
        System.out.println(a);

        for (Integer i : mySL)
            System.out.println(i);

        System.out.println("\nNew method");
        int cont = 0;
//        while(mySL.getI(cont)!=null)
        while (cont < mySL.size())
            System.out.println(mySL.get(cont++));

        System.out.println("\nNew method 2");
//        while (mySL.iterator().hasNext()) { // not working idk why
//            Integer val = mySL.iterator().next();
//            System.out.println(val);
//        }

//        test *a;


//        func();

        var intHeap = new BinaryHeap<Integer>();
        intHeap.add(8);
        intHeap.add(7);
        intHeap.add(1);
        intHeap.add(15);
        intHeap.add(10);
        intHeap.add(25);

        System.out.println(intHeap.toString());

//        HashMap < Integer, String> zzz;
        var map = new Hashmap<Integer, Character>();
//        map.put(0, "A");
        for(int i='A'; i < 'Z'; i++)
            map.put(i, (char)i);

        System.out.println(map.toString());
        System.out.println(map.get(0));
    }

    public static void func() {
        SinglyLinkedList<String> myList = new SinglyLinkedList<>();
        int opt;
        Scanner S;
        do {
            System.out.println("1. Create");
            System.out.println("2. Read");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("0. EXIT");
            S = new Scanner(System.in);
            System.out.println("Your selection: ");
            opt = S.nextInt();
            if (opt == 0) break;

            System.out.println();
            switch (opt) {
                case 1:
                    System.out.println("Enter the position & the object");
                    int pos = S.nextInt();
                    S.nextLine();
//                    String str= S.nextLine();
                    myList.add(pos, S.nextLine());
                    break;
                case 2:
                    System.out.println("All the elements in the list are: ");
                    for (String s : myList)
                        System.out.println(s);
                    break;
                case 3:
                    System.out.println("Enter the position & the new object");
                    int a = S.nextInt();
                    S.nextLine();
                    myList.update(a, S.nextLine());
                    break;
                case 4:
                    System.out.println("Enter the position of the object to delete");
                    myList.delete(S.nextInt());
                    break;
            }
        } while (opt != 0);
        S.close();
    }
}