package se.kanisha.adventure.model;


public class Resident extends Entity {
    public Resident(String role, int health, int damage) {
        super(role, health, damage);
    }


    public boolean hasFryingPan = false; //We declared here that resident does not have the frying pan.

    public void pickUpFryingPan() {
        hasFryingPan = true;
        this.damage += 3; // Increases damage if resident has frying pan.
    }

    public boolean hasFryingPan(){ //To check if the resident has frying pan or not.
        return hasFryingPan;

    }

}

