package sec14.chap02.com.petshop;

public class Cat extends Pet {
    public Cat(String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return "야옹";
    }
}