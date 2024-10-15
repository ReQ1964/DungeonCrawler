package rooms;

import entities.LivingCreature;
import game.Battle;
import java.util.ArrayList;
import java.util.List;

public class CombatRoom extends Room {
    private ArrayList<LivingCreature> enemies;

    public CombatRoom(String name, String description, List<LivingCreature> enemies) {
        super(name, description, enemies);
        this.enemies = new ArrayList<>(enemies);
    }

    public void addEnemy(LivingCreature enemy) {
        enemies.add(enemy);
    }

    public void removeEnemy(LivingCreature enemy) {
        enemies.remove(enemy);
    }
}
