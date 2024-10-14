package rooms;

import entities.LivingCreature;

import java.util.ArrayList;
import java.util.List;

public class CombatRoom extends Room{
    private String name;
    private String description;
    private ArrayList<LivingCreature> enemies = null;

    public CombatRoom(String name, String description, List<LivingCreature> enemies) {
        super(name, description, enemies);
        this.enemies = (ArrayList<LivingCreature>) enemies;
    }

    public void startBattle() {

    }
}
