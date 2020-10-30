package first_package;

import java.util.Scanner;  //import just this method
// import java.util.*;  //import all the package

public class Animal {
//    public // available in all the project
//    static // this will be shared by every Animal object that is created
//    final // means that is a constant and can't be changed
//    private // means it can be accessed by other methods in the class
//    long // from -2^63 to 2^63
//    protected // means it can only be accessed by other code in the package
//    super() // it calls whatever the superclass was for this animal to be executed, int this case Animal is the
//    superclass for dog and cat
//    polymorphism // Treat a subclass as a super but have overwritten methods execute
//    interface // empty class that defines the methods you must use but none of the code

    public static final double FAVNUMBER = 1.6180;
    private String name;
    private int weight;
    private boolean hasOwner = false;
    private byte age;
    private long uniqueID;
    private char favoriteChar;
    private double speed; // 32-bit number
    private float height; // 64-bit number

    protected static int numberOfAnimals = 0;

    static Scanner userInput = new Scanner(System.in);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isHasOwner() {
        return hasOwner;
    }

    public void setHasOwner(boolean hasOwner) {
        this.hasOwner = hasOwner;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public long getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(long uniqueID) {
        this.uniqueID = uniqueID;
    }

    public char getFavoriteChar() {
        return favoriteChar;
    }

    public void setFavoriteChar(char favoriteChar) {
        this.favoriteChar = favoriteChar;
    }

    public void setFavoriteChar() {
        int randomNum = (int)(Math.random() * 126) + 1;
        this.favoriteChar = (char)randomNum;

        if(randomNum == 32)     System.out.println("Favorite character set to Space");
        else if(randomNum == 10)System.out.println("Favorite character set to NewLine");
        else System.out.println("Favorite character set to " + this.favoriteChar);

        switch (randomNum){
            case 8:
                System.out.println("Favorite character set to backspace");
                break;
            case 10:
            case 11:
            case 12:
                System.out.println("Favorite character set to backspace");
                break;
            default:
                System.out.println();
                break;

        }
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    protected static void countTo(int startingNum){
        for(int i = startingNum; i<= 100; i++){
            if(i == 90) continue;// with continue, the next line is not executed
            System.out.println("Ninety: " + i);
        }
    }

    public String makeSound(){  //polymorphism
        return "Grrrrr";
    }

    public static void speakAnimal(Animal animal){
        System.out.println("Animal says " + animal.makeSound());
    }

    public Animal() {
//        super();
        numberOfAnimals++;

        System.out.println("Enter your namecusei:");

        if(userInput.hasNextLine()){ // hasNextLine means if the user entered a serie of characters
            this.setName(userInput.nextLine()); // nextLine returns the data the user entered as a String
        }
        Animal.countTo(85);  // count is static
    }

}

// each one of these return a boolean:
// hasNextInt, hasNextFloat, hasNextDouble, hasNextLine, hasNextByte, hasNextBoolean
// To get the data: nexInt, nexFloat, nexDouble, nexLine, nexByte, nexBoolean


// ^ returns true if one is true, and the other one is false