package prove;

import java.util.Scanner;

public class idk {
    public static void main(String []args){
        int secret = 38;
        int guess = 0;
        Scanner sc= new Scanner(System.in);

        do {
            System.out.println("Guess: ");
            if (sc.hasNextInt())
                guess = sc.nextInt();
            else break;
        }while (guess != secret);
        sc.close();
    }

    static int factorial(int num){
        if(num == 1)return 1;
        else return num*factorial(num-1);
    }
}
