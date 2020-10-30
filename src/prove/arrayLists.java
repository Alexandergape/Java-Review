package prove;

// import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class arrayLists {
    public static void main(String[]args){
        ArrayList<String> arrayList1 = new ArrayList<>(20);
        arrayList1.add("Sue");
        System.out.println(arrayList1);

        ArrayList<Integer> arrayList2 = new ArrayList<>(Arrays.asList(5, 7, 6, 3, 8, 9));
        System.out.println(arrayList2);
        for(int i: arrayList2)
            System.out.print(i + " ");
        System.out.println();
        for(Integer i: arrayList2)  // this is tha same as the previous one
            System.out.print(i + " ");

        System.out.println();
        System.out.println(arrayList2.get(1));

        arrayList2.set(1, 0);//replace set(int index, E element)
        arrayList2.remove(3);
        //clear all
        arrayList2.clear();
        System.out.println(arrayList2);

        //############################################
        //############################################
        //iterators
        arrayList2.addAll(Arrays.asList(4, 8, 2, 3));
        Iterator<Integer> it = arrayList2.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        //############################################
        //############################################
        //LINKED LISTS
        LinkedList<Integer> linkedList1 = new LinkedList<Integer>();
        linkedList1.add(5);
        linkedList1.add(4);
        linkedList1.addAll(Arrays.asList(4, 2, 1, 0));

        linkedList1.addFirst(6);
        System.out.println(linkedList1.contains(4));




    }
}
