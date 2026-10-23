Zoo Management System

A command-line Java program for managing the animals in a zoo. Through a text menu, you can add, remove, modify, search and view animals, run a daily care routine and print a summary report of the zoo. Animal details are saved to a text file.

I built this as Year 1 university coursework to practise object-oriented programming in Java.

## Features

| Menu option | What it does |
|---|---|
| 1. Add Animal | Asks for an animal's name, age, colour and weight, then its type (Lion, Dove or Goose) and that type's own attribute |
| 2. Remove Animals | Removes every animal with the name you enter (not case-sensitive) |
| 3. Modify Animal Details | Changes an animal's name, age, colour or weight; leave a field blank or enter `-1` to keep the current value |
| 4. View All Animal Details | Lists every animal in the zoo |
| 5. Search For Animal | Finds animals by name and shows their details and sound |
| 6. Perform Daily Care | Goes through each animal: makes its sound, runs swimming and water quality checks for animals that swim, and flying and wing checks for animals that fly |
| 7. Print Zoo Details | Report showing the zoo name, total animals, a count of each type and the most common colour |
| 8. Load From File | Replaces the current list with the animals saved in `AnimalDetails.txt` |
| 9. Exit and Save | Saves all animals to file and closes the program |

## Files
| File | Description |
|---|---|
| `main.java` | Entry point. Shows the menu, reads the user's choices and calls the matching `zoo` methods. |
| `zoo.java` | Keeps the `ArrayList` of animals. Handles adding, removing, modifying, searching, daily care, the report, and saving to and loading from file. |
| `Animal.java` | Abstract base class for every animal. Stores name, age, colour and weight in private fields, with setters that check the values. Declares the abstract `makeSound()` method. |
| `Lion.java` | Extends `Animal`. Adds a mane size and roars. |
| `Dove.java` | Extends `Animal` and implements `Flyable`. Adds a wingspan. |
| `Goose.java` | Extends `Animal` and implements `Swimmable`. Adds a neck length. |
| `Flyable.java` | Interface for animals that fly: `fly()` and `checkWings()`. |
| `Swimmable.java` | Interface for animals that swim: `swim()` and `checkWaterQuality()`. |
| `AnimalDetails.txt` | Save file the program writes animal data to. |

Zoo Management System

A command-line Java program for managing the animals in a zoo. Through a text menu, you can add, remove, modify, search and view animals, run a daily care routine and print a summary report of the zoo. Animal details are saved to a text file.

I built this as Year 1 university coursework to practise object-oriented programming in Java.

## Features

| Menu option | What it does |
|---|---|
| 1. Add Animal | Asks for an animal's name, age, colour and weight, then its type (Lion, Dove or Goose) and that type's own attribute |
| 2. Remove Animals | Removes every animal with the name you enter (not case-sensitive) |
| 3. Modify Animal Details | Changes an animal's name, age, colour or weight; leave a field blank or enter `-1` to keep the current value |
| 4. View All Animal Details | Lists every animal in the zoo |
| 5. Search For Animal | Finds animals by name and shows their details and sound |
| 6. Perform Daily Care | Goes through each animal: makes its sound, runs swimming and water quality checks for animals that swim, and flying and wing checks for animals that fly |
| 7. Print Zoo Details | Report showing the zoo name, total animals, a count of each type and the most common colour |
| 8. Load From File | Replaces the current list with the animals saved in `AnimalDetails.txt` |
| 9. Exit and Save | Saves all animals to file and closes the program |

## Files

| File | Description |
|---|---|
| `main.java` | Entry point. Shows the menu, reads the user's choices and calls the matching `zoo` methods. |
| `zoo.java` | Keeps the `ArrayList` of animals. Handles adding, removing, modifying, searching, daily care, the report, and saving to and loading from file. |
| `Animal.java` | Abstract base class for every animal. Stores name, age, colour and weight in private fields, with setters that check the values. Declares the abstract `makeSound()` method. |
| `Lion.java` | Extends `Animal`. Adds a mane size and roars. |
| `Dove.java` | Extends `Animal` and implements `Flyable`. Adds a wingspan. |
| `Goose.java` | Extends `Animal` and implements `Swimmable`. Adds a neck length. |
| `Flyable.java` | Interface for animals that fly: `fly()` and `checkWings()`. |
| `Swimmable.java` | Interface for animals that swim: `swim()` and `checkWaterQuality()`. |
| `AnimalDetails.txt` | Save file the program writes animal data to. |

## OOP concepts demonstrated

- **Abstraction:** `Animal` is abstract and declares `makeSound()` without a body, so each animal type has to provide its own sound.
- **Inheritance:** `Lion`, `Dove` and `Goose` extend `Animal`, reuse its fields and constructor through `super(...)`, and add their own attribute.
- **Interfaces:** `Flyable` and `Swimmable` describe abilities that only some animals have.
- **Polymorphism:** `dailyCare()` loops over a list of `Animal` objects and calls `makeSound()` on each one. It uses `instanceof` pattern matching to call the flying or swimming methods only on animals that support them.
- **Encapsulation:** `Animal`'s fields are private and only reachable through getters and setters. The setters reject invalid values: an empty name or colour, a negative age, or a weight of zero or less.
- **Collections:** an `ArrayList` holds the animals, and `HashMap`s count animal types and colours for the report.

## File format

Animals are saved to `AnimalDetails.txt` automatically whenever one is added, removed or modified. Each line holds one animal, with the values separated by commas. The last value is the attribute unique to that animal type: mane size, wingspan or neck length.

```
Type,Name,Age,Colour,Weight,TypeSpecificAttribute
Lion,Leo,5,golden,190.0,2.5
Dove,Daisy,2,white,0.3,30.0
Goose,Gus,3,grey,4.0,0.4
```

## How to run

You need **Java 16 or later**, because the code uses `instanceof` pattern matching.

From the folder containing the `.java` files:

```bash
javac *.java
java main
```

You can also open the folder in IntelliJ IDEA and run `main.java`.
