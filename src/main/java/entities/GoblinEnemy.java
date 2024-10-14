package entities;
import com.github.javafaker.Faker;

public class GoblinEnemy implements LivingCreature {
    private final String name;
    private int health;
    private int attackDamage;

    public GoblinEnemy(String name, int health, int attackDamage) {
        Faker faker = new Faker();
        this.name = faker.name().fullName();
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
        return "A goblin called" + name;
    }

    public int getHealth(){
        return health;
    }
}
