package first_package;

public class Dog extends Animal{  // extends mean inheritance
    public Dog(){

    }

    @Override  // makeSound from Animal
    public String makeSound(){
        return "Woof";
    }
}
