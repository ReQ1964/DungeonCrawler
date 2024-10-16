package items;

public class Sword implements Weapon{
    private String name;
    private String description;
    private int damage;

    public Sword(String name, String description, int damage){
        this.name = name;
        this.description = description;
        this.damage = damage;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public void use(){}

    @Override
    public String examine() {
        return name + ". " + description + "\n" + "Damage: " + damage;
    }
}
