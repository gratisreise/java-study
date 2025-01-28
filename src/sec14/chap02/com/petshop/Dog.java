package sec14.chap02.com.petshop;

public class Dog extends Pet {
    public Dog(String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return "멍멍";
    }
}