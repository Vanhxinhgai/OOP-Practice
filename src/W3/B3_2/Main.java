package W3.B3_2;

public class Main {
    public static void main(String[] args) {
        Animal[] zoo = new Animal[4];
        zoo[0] = new Dog();
        zoo[1] = new Cat();
        zoo[2] = new Duck();
        zoo[3] = new Dog();
        for(int i=0; i<zoo.length; i++){
            zoo[i].makeSound();
        }

    }
}
