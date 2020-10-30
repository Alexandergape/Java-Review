package first_package;

import prove.Warrior;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Animal theAnimal = new Animal();

        byte minNum = 1;
        long maxNum = 999999;
//      Math.random() // returns a double
        long random = minNum + (long) (Math.random() * ((maxNum - minNum) + 1));
        System.out.println(random);
        // convert data types, from number to String (no cast)
        String stringNum = Long.toString(maxNum);
        System.out.println(stringNum);
        // convert data types, from String to number
        int numString = Integer.parseInt(stringNum);
        System.out.println(numString);


        int n = (int)(Math.random() * 100 +1);
        int biggerNum = (50 > n) ? 50 : (int)random;  // if (50 > n) is true biggerNum=50, else biggerNum=random
        System.out.println("n: " + n + "\tbiggerNum: " + biggerNum);
    
        Warrior w = new Warrior();
        w.foo();
    }
}
