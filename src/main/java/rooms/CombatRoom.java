package rooms;

import entities.LivingCreature;

import java.util.ArrayList;
import java.util.List;

public class CombatRoom extends Room{

    public CombatRoom(String name, String description, List<LivingCreature> enemies) {
        super(name, description, enemies);
        this.enemies = new ArrayList<>(enemies);
    }

    public List<LivingCreature> getEnemies() {
        return enemies;
    }

    public void removeEnemy(LivingCreature enemy) {
        enemies.remove(enemy);
    }

    public void clearEnemies() {
        enemies.clear();
    }
}
