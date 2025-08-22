package FINAL_2_METHOD;

class Animal {
    void sound() {//final word cannot be used for overidden infront of method
        System.out.println("Some generic animal sound");
    }
}

class Dog extends Animal {
    @Override  // This annotation is optional but helps catch errors during compilation
    void sound() {
        System.out.println("Bark");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Meow");
    }
}

public class F  {
    public static void main(String[] args) {
        Animal myAnimal = new Animal();
        Animal myDog = new Dog();
        Animal myCat = new Cat();

        myAnimal.sound();  // Output: Some generic animal sound
        myDog.sound();     // Output: Bark (overridden in Dog)
        myCat.sound();     // Output: Meow (overridden in Cat)
    }
}
