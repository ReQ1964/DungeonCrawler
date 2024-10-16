package rooms;

import entities.LivingCreature;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CombatRoom extends Room{
    private ArrayList<LivingCreature> enemies;

    public CombatRoom(String name, String description, List<LivingCreature> enemies, int x, int y) {
        super(name, description, x, y);
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
