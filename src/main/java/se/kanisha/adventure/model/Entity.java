package se.kanisha.adventure.model;

public abstract class Entity {

        String role;
        int health;
        int damage;


    public String getRole() {
        return role;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public Entity(String role, int health, int damage) {
        this.role = role;
        this.health = health;
        this.damage = damage;
    }

    public void punch(Entity toPunch) {

        System.out.println(this.role + " punched " + toPunch.role);
        toPunch.takeHit (this.damage);
    }

    public void takeHit(int damage) {
        health -= damage;
        System.out.println(this.role + " takes " + damage + " damage! Health is now " + this.health);
    }

    public boolean isConscious(){
        return health > 0;
    }
}
