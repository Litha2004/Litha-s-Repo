/*
 * Class: CMSC203 
 * Instructor:
 * Description: (Give a brief description for each Class)
 * Due: 02/04/2004
 * Platform/compiler:
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: _Lithalethu Mkunqwana_________
*/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Circus {
    private String name;
    private List<Animal> animals;
    private List<Person> persons;
    private List<Building> buildings;
    private List<Ticket> tickets;

    public Circus() {
        this.animals = new ArrayList<>();
        this.persons = new ArrayList<>();
        this.buildings = new ArrayList<>();
        this.tickets = new ArrayList<>();
    }

    public Circus(String name) {
        this();
        this.name = name;
    }

    // Animal methods
    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void sortAnimalsByAge() {
        animals.sort(Comparator.comparingInt(Animal::getAge));
    }

    public void sortAnimalsByName() {
        animals.sort(Comparator.comparing(Animal::getName));
    }

    public Animal searchAnimalByName(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                return animal;
            }
        }
        return null;
    }

    // Person methods (add as needed)
    public void addPerson(Person person) {
        persons.add(person);
    }

    public List<Person> getPersons() {
        return persons;
    }

    // Building methods (add as needed)
    public void addBuilding(Building building) {
        buildings.add(building);
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    // Ticket methods
    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void displayAnimals() {
        if (animals.isEmpty()) {
            System.out.println("No animals in the circus.");
        } else {
            System.out.println("Animals in the circus:");
            for (Animal animal : animals) {
                System.out.println(animal);
            }
        }
    }

    public void displayPersons() {
        if (persons.isEmpty()) {
            System.out.println("No persons in the circus.");
        } else {
            System.out.println("Persons in the circus:");
            for (Person person : persons) {
                System.out.println(person);
            }
        }
    }

    public void displayBuildings() {
        if (buildings.isEmpty()) {
            System.out.println("No buildings in the circus.");
        } else {
            System.out.println("Buildings in the circus:");
            for (Building building : buildings) {
                System.out.println(building);
            }
        }
    }
}