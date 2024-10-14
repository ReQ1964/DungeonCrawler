package entities;

public class Player implements LivingCreature {
    private final String name;
    private int health;
    private int attackDamage;

    public Player(String name, int health, int attackDamage) {
        this.name = name;
        this.health = health;
        this.attackDamage = attackDamage;
    }

    @Override
    public void attack(LivingCreature target) {
        target.takeDamage(this.attackDamage);
    }

    @Override
    public void takeDamage(int damage){
        health -= damage;
    }

    @Override
    public boolean isAlive(){
        return health > 0;
    }

    public String getName(){
        return name;
    }

    public int getHealth(){
        return health;
    }
}
