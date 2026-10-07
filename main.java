import java.util.Scanner;

public class main {
    public static void main (String[] args){
        zoo zoo = new zoo();
        Scanner scan = new Scanner(System.in);

        System.out.println("===================================");
        System.out.println("Welcome to the Belfast Zoo management system");
        System.out.println("===================================");

        int choice;
        do {
            System.out.println("==== Zoo Menu ====");
            System.out.println("1. Add Animal");
            System.out.println("2. Remove Animals");
            System.out.println("3. Modify Animal Details");
            System.out.println("4. View All Animal Details");
            System.out.println("5. Search For Animal");
            System.out.println("6. Perform Daily care");
            System.out.println("7. Print Zoo Details");
            System.out.println("8. load from file");
            System.out.println("9. Exit and Save");
            System.out.println("Enter choice: ");

            choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    zoo.addAnimal();
                    break;
                case 2:
                    System.out.print("Enter name to search: ");
                    String removeName = scan.nextLine();
                    zoo.removeAnimal(removeName);
                    break;
                case 3:
                    System.out.println("Enter name of animal to be modified");
                    String name = scan.nextLine();

                    System.out.print("Enter new name (leave blank to keep the same): ");
                    String newName = scan.nextLine();

                    System.out.print("Enter new age (or -1 to keep the same): ");
                    int newAge = scan.nextInt();
                    scan.nextLine(); // clear buffer

                    System.out.print("Enter new colour (leave blank to keep the same): ");
                    String newColour = scan.nextLine();

                    System.out.print("Enter new weight (or -1 to keep the same): ");
                    double newWeight = scan.nextDouble();
                    scan.nextLine();

                    zoo.modifyAnimal(name, newName, newAge, newColour, newWeight);
                    break;
                case 4:
                    zoo.viewAnimal();
                    break;

                case 5:
                    System.out.print("Enter a name to search: ");
                    name = scan.nextLine();
                    zoo.searchByName(name);
                    break;
                case 6:
                    zoo.dailyCare();
                    break;
                case 7:
                    zoo.Report();
                    break;
                case 8:
                    zoo.loadFromFile();
                case 9:
                    zoo.saveToFile();
                    System.out.println("Exiting program");
                    break;
                default:
                    System.out.println("Invalid choice. Try again...");
            }

        } while (choice != 9);
        scan.close();





    }


}
