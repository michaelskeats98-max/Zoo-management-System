public class Goose extends Animal implements Swimmable{

    private double neckLength;

    public Goose(String name, int age, String color, double weight, double neckLength){
        super(name, age, color, weight);
        this.neckLength = neckLength;
    }

    @Override
    public String toString() {
        return super.toString() + ", Neck Length: " + neckLength;
    }

    @Override
    public String makeSound() {
        return "Honk Honk, my name is"+ getName() +",a" +  getAge() + "year old goose";
    }

    @Override
    public String swim(){
        return getName() + "is swimming gracefully";
    }

    @Override
    public String checkWaterQuality(){
        return "Checking quality of water in"+ getName() +"'s habitat";
    }
}
