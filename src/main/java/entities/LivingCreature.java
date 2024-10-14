package entities;

public interface LivingCreature {
    public String name = "";
    public int health = 0;
    public int attackDamage = 0;

    public void attack(LivingCreature target);
    public void takeDamage(int damage);
}
