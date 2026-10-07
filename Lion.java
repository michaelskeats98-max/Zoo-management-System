public class Lion extends Animal{

    private double ManeSize;

    public Lion(String name, int age, String color, double weight, double manesize) {
        super(name, age, color, weight);
        this.ManeSize = manesize;
    }

    @Override
    public String toString() {
        return super.toString() + ", Mane Size: " + ManeSize;
    }


    @Override
    public String makeSound() {
        return "ROAR, my name is" + getName() + ", a" + getAge() + " year old Lion";
    }
}
