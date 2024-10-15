package entities;

public interface LivingCreature {
    String name = "";
    int health = 0;
    int attackDamage = 0;

    String getName();
    int getHealth();
    boolean isAlive();
    void attack(LivingCreature target);
    void takeDamage(int damage);
}
