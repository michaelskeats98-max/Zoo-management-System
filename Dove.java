public class Dove extends Animal implements Flyable{

    private double Wingspan;

    public Dove(String name, int age, String color, double weight, double Wingspan) {
        super(name, age, color, weight);
        this.Wingspan = Wingspan;
    }

    @Override
    public String toString() {
        return super.toString() + ", Wingspan: " + Wingspan;
    }


    @Override
    public String makeSound() {
        return "whoo whoo, my name is" + getName() + ", a" + getAge() + "year old dove";
    }

    @Override
     public String fly() {
        return getName() +"is flying through the air!";

    }
    @Override
    public String checkWings() {
        return "Checking the wings of"+ getName();

    }
}
