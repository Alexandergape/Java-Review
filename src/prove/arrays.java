package prove;

import java.util.Arrays;
import java.util.stream.IntStream;

public class arrays {
    public static void main(String[] args){
        int[] array = new int[10];
        array[0] = 1;
        Arrays.fill(array, 3); // fill all the array with 3

        for(int n: array)
            System.out.print(n + " ");

        // fill with values from 1 to 10
        System.out.println();
        int[] array2 = IntStream.rangeClosed(1, 10).toArray();
        for(int n: array2)
            System.out.print(n + " ");

        //search a value
        System.out.println();
        System.out.println(Arrays.binarySearch(array2, 9));// return the index of 9

        int array3[][] = new int[2][3];

        String array4[][][] = {{{"000"}, {"100"}, {"200"}, {"300"}},
                                {{"010"}, {"110"}, {"210"}, {"310"}},
                                {{"020"}, {"120"}, {"220"}, {"320"}}};

        int array5[] = Arrays.copyOf(array2, 3);
        System.out.println(Arrays.toString(array5));

        System.out.println(Arrays.equals(array, array2)); // returns a boolean

        int[] array6 = {7, 1, 9, 0 ,4, 6};
        Arrays.sort(array6);
        System.out.println(Arrays.toString(array6));

    }
}
