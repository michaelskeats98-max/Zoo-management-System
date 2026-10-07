import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class zoo {
    private ArrayList<Animal> animals;
    private String zooName;

    public zoo() {
        animals = new ArrayList<>();
        zooName = "Ulster Zoo";
    }

    public void addAnimal() {
        Animal animal = null;
        Scanner scan = new Scanner(System.in);

        // Common attributes
        System.out.println("Enter name:");
        String name = scan.nextLine().trim();

        System.out.println("Enter age");
        int age = scan.nextInt();
        scan.nextLine();

        System.out.println("Enter color");
        String color = scan.nextLine().trim();

        System.out.println("Enter weight");
        double weight = scan.nextDouble();
        scan.nextLine();

        // subclass menu
        System.out.println("Select Animal Type");
        System.out.println("1. Lion");
        System.out.println("2. Dove");
        System.out.println("3. Goose");
        System.out.println("Enter choice: ");
        int choice = scan.nextInt();

        // creates subclass based on user choice
        switch (choice) {
            case 1:
                System.out.println("Enter Mane size");
                double Manesize = scan.nextDouble();
                scan.nextLine();
                animal = new Lion(name, age, color, weight, Manesize);
                break;
            case 2:
                System.out.println("Enter wingspan: ");
                double Wingspan = scan.nextDouble();
                scan.nextLine();
                animal = new Dove(name, age, color, weight, Wingspan);
                break;
            case 3:
                System.out.println("Enter neck length: ");
                double neckLength = scan.nextDouble();
                scan.nextLine();
                animal = new Goose(name, age, color, weight, neckLength);
                break;
            default:
                System.out.println("Invalid animal type");
                return;
        }
        // adds animal to list
        animals.add(animal);

        System.out.println(animal.getType() + "Added successfully");

        saveToFile(); // saves to file


    }
    //removes all animals
    public void removeAnimal(String name) {
        boolean removed = animals.removeIf(a -> a.getName().trim().equalsIgnoreCase(name));

        if (removed) {
            System.out.println("Animal removed");
        } else {
           System.out.println("Animal not found");
        }
    }
    // prints all animals currently in Zoo
     public void viewAnimal() {
        if (animals.isEmpty()) {
            System.out.println("No animals are in the zoo currently");
            return;
        }
        for (Animal a : animals) {
            System.out.println(a);
        }
     }

     public void searchByName(String name) {
        Boolean found = false;

        for (Animal a : animals) {
            if (a.getName().equalsIgnoreCase(name)) {
                System.out.println(a);
                System.out.println(a.makeSound());
                found = true;
            }

        }
        if (!found) {
            System.out.println("Animal does not exist");
        }
     }

     public boolean modifyAnimal(String name, String newName ,int newAge, String newColor, double newWeight) {
        // gets existing name of animal to be modified
        if(name == null && name.trim().isEmpty()) {
            System.out.println("Error: existing name cannot be empty!");
            return false;
        }
        for (Animal a : animals) {
            if (a.getName().equalsIgnoreCase(name.trim())) {
                // changes name
                if(newName != null && !newName.trim().isEmpty()) {
                    a.setName(newName.trim());
                }
                // change age
                if (newAge > 0) {
                    a.setAge(newAge);
                }
                // change color
                if(newColor != null && !newColor.trim().isEmpty()) {
                    a.setColor(newColor.trim());
                }
                // change color
                if(newWeight > 0) {
                    a.setWeight(newWeight);
                }

                System.out.println("Details successfully changed!");
                saveToFile();
                return true;
            }
        }
        System.out.println("Animal named" + name + "not found!");
        return false;
     }

     public void dailyCare() {
        System.out.println("\n=== Starting daily care routine at Belfast Zoo ===\n");

        for (Animal animal : animals) {
            System.out.println("Caring for:" + animal.getName());
            System.out.println(" Sound: " + animal.makeSound());

            if (animal instanceof Swimmable swimmable){
                System.out.println("Swimming:" + swimmable.swim());
                System.out.println("Water quality check: " + swimmable.checkWaterQuality());
            }
            if (animal instanceof Flyable flyable) {
                System.out.println("flying:" + flyable.fly());
                System.out.println("wing check:" + flyable.checkWings());
            }
        }
         System.out.println("=== Daily care completed ===\n");
     }

     public void Report() {
        System.out.println("=== Zoo Report ===");
        System.out.println("Zoo Name:" + zooName );
        System.out.println("Total Animals:" + animals.size());

        Map<String, Integer> colorCount = new HashMap<>();
        Map<String, Integer> typeCount = new HashMap<>();

        for (Animal animal : animals) {
            // count Animal types
            String type = animal.getClass().getSimpleName();
            typeCount.put(type, typeCount.getOrDefault(type, 0)+1);

            //counts colors
            String color = animal.getColor();
            colorCount.put(color, colorCount.getOrDefault(color, 0)+1);
        }
        // displays number of animal types
        System.out.println("Animal Types");
        for (String type : typeCount.keySet()) {
            System.out.println((type + ":" + typeCount.get(type)));
        }

        //  finds most frequent color
         String dominantColor = null;
        int max = 0;

        for(String c : colorCount.keySet()) {
            if (colorCount.get(c) > max) {
                max = colorCount.get(c);
                dominantColor = c;
            }
        }
        System.out.println("\nDominant color:" + dominantColor);

     }
     public void loadFromFile() {
        try {
            File file = new File("AnimalDetails.txt");

            if(!file.exists()) return;
            Scanner scanner = new Scanner(file);

            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                // reconstruction of arraylist into string
                String type = parts[0];
                String name = parts[1];
                int age = Integer.parseInt(parts[2]);
                String color = parts[3];
                double weight = Double.parseDouble(parts[4]);

                switch (type) {
                    case "Lion":
                        animals.add(new Lion(name, age, color, weight, 1.0));
                        break;
                    case "Goose":
                        animals.add(new Goose(name, age, color, weight, 1.0));
                        break;
                    case "Dove":
                        animals.add(new Dove(name, age, color, weight, 2.0));
                        break;
                }
            }
            scanner.close();;
            System.out.println("Data loaded.");

        } catch (Exception e) {
            System.out.println("Error loading file.");
            throw new RuntimeException(e);
        }
     }
     public void saveToFile() {
        try {
            FileWriter writer = new FileWriter("AnimalDetails.txt");

            for (Animal a : animals) {
                if( a.getName() != null && !a.getName().isEmpty()) {
                    String Line =  a.getType() + ","
                            + a.getName() + ","
                            + a.getAge() + ","
                            + a.getColor() + ","
                            + a.getWeight();

                    writer.write(Line + System.lineSeparator());
                }
            }
            writer.close();
            System.out.println("Animals saved to file");
        } catch (IOException e) {
            System.out.println("Error saving to file");
        }
     }


}


