package se.kanisha.adventure;

import se.kanisha.adventure.model.Burglar;
import se.kanisha.adventure.model.Resident;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AdventureGame { //Class starts

    private Scanner scanner = new Scanner(System.in);
    private Scanner scannerInt = new Scanner(System.in);
    private boolean running = true;
    private String currentRoom = "Living Room";
    private Resident resident = new Resident("Resident", 12, 3);
    private Burglar burglar = new Burglar("Burglar", 12, 4);
    private String burglarRoom = "Hall"; // Randomly assigned burglar location


    private Map<String, String[]> rooms = new HashMap<>();

    public AdventureGame() { //Constructor that initializes the connection between the rooms by adding entries
        // to the rooms map using put method
        rooms.put("Living Room", new String[]{"Kitchen", "Bedroom", "Office", "Hall"});//Living room is connected to four other rooms
        rooms.put("Kitchen", new String[]{"Living Room"});
        rooms.put("Bedroom", new String[]{"Living Room"});
        rooms.put("Office", new String[]{"Living Room"});
        rooms.put("Hall", new String[]{"Living Room"});
    }




    public void play() {

        System.out.println("Welcome to the game. You are the " + resident.getRole());
        System.out.println("A burglar has broken into your house, and he is hiding somewhere...");
        System.out.println("You wake up on the sofa in the Living Room, startled by a noise...");

        while (running) { //While the condition is true, keep running the loop.
            // Display room options
            System.out.println("\nYou are in the " + currentRoom + ". Where would you like to go?");
            String[] options = rooms.get(currentRoom);
            for (int i = 0; i < options.length; i++) { //Displays the list,Setting conditions here.
                System.out.println((i + 1) + ": " + options[i]); //i is the index no. of the element here.
            }
            System.out.println("0: Quit");


            // Get user input for room choice, choosing the numbers associated with rooms.
            int choice = scannerInt.nextInt();
            if (choice == 0) {
                System.out.println("You decided to quit the game, Sleep peacefully");
                running = false; //Game stops,the loop stops
            } else if (choice >= 1 && choice <= options.length) {
                currentRoom = options[choice - 1]; // this just gives the value according to the index no.
                roomEvent();
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }





    private void roomEvent() {

       // Check if the player is in the Kitchen
        if (currentRoom.equals("Kitchen")) {
            System.out.println("Do you want to pick up the frying pan from Kitchen? (Y/N)");
            String fryingPanChoice = scanner.nextLine();
            if (fryingPanChoice.equalsIgnoreCase("Y")) {
                if (!resident.hasFryingPan()) {
                    resident.pickUpFryingPan();
                    System.out.println("You have now picked up the frying pan from Kitchen. Now the damage you can cause has doubled to " + resident.getDamage());

                    // Resident picks up frying pan if in the Kitchen

                } else {
                    System.out.println("You already have the frying pan.");
                }
            } else {
                System.out.println("You chose not to have the frying pan.");
            }
        } else if (currentRoom.equals(burglarRoom)) {
            System.out.println("You found the burglar in the " + currentRoom + "!");
            fight();  // Automatically start the fight
        } else {
            if (!currentRoom.equals("Living Room")) System.out.println("The " + currentRoom + " is empty.");
        }
    }





    private void fight() {

        System.out.println("A fight begins!");

        // Fight loop continues until one of the entities has health <= 0
        while (resident.isConscious() && burglar.isConscious()) {
            // Resident attacks first
            resident.punch(burglar);
            burglar.punch(resident); // Assuming burglar is allowed to punch the resident

            if (!burglar.isConscious()) {
                System.out.println("You defeated the burglar!");
                callPolice();
                return;
            }

            //burglar.punch(resident);
            if (!resident.isConscious()) {
                System.out.println("The burglar defeated you. Game Over.");
                running = false;  // End the game if resident is defeated
                return;
            }
        }

    }





    private void callPolice() {

        if (!burglar.isConscious() && resident.isConscious()) {
            System.out.println("Do you want to call the police from office? (Y/N)");
            String policeChoice = scanner.nextLine();

            while (policeChoice.equalsIgnoreCase("N")) {
                System.out.println("You have decided not to call the police. You will be at risk until you call police.");
                System.out.println("Do you want to call the police from office? (Y/N)");
                policeChoice = scanner.nextLine();
            }
            if (policeChoice.equalsIgnoreCase("Y")) {
                System.out.println("Dialing the police...");
                System.out.println("The police is on their way. You win! Game Over.");
            }


            running = false; //Game ends
        }
    }

}
// Class closes
















