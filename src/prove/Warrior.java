package prove;

import java.util.Random;

// import javax.sound.sampled.SourceDataLine;

public class Warrior {
    protected String name = "Warrior";
    public int health = 0;
    public int attackMax = 0;
    public int blockMax = 0;

    public Warrior() throws InterruptedException { 
            Thread.sleep(1500);
        
    }

    public Warrior(String name, int health, int attackMax, int blockMax){
        
    }

    public  void foo(){
        System.out.println("hi");
        Random rand = new Random();
        System.out.println(rand);
        System.out.println("hi");
    }

    /*
        printf is for formatted output
        %s : Strings
        %d : Integers
        %F : Floats
        %.2f : TO limit to 2 decimals
        %c : Characters
        %e : scientific Notation
        %t : Dates
        %b : Booleans
    */
}
