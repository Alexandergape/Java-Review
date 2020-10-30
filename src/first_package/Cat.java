package first_package;

public class Cat extends Animal{
    public Cat(){

    }

    @Override  // makeSound from Animal
    public String makeSound(){
        return "Meow";
    }

    public static void main(String[] args){
        Animal fido = new Dog();
        Animal fluffy = new Cat(); // both fido and fluffy are Animals

        Animal.speakAnimal(fido);
        speakAnimal(fluffy);  // this and the previous one have the same meaning
    }
}
