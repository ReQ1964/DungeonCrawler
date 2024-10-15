package rooms;

import entities.LivingCreature;
import entities.Player;
import game.Battle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CombatRoom extends Room{
    private String name;
    private String description;
    private ArrayList<LivingCreature> enemies = null;

    public CombatRoom(String name, String description, List<LivingCreature> enemies) {
        super(name, description, enemies);
        this.enemies = (ArrayList<LivingCreature>) enemies;
    }

    public LivingCreature getEnemy() {
        return enemies.get(0);
    }

    public void addEnemy(LivingCreature enemy) {
        enemies.add(enemy);
    }

    public void removeEnemy(LivingCreature enemy) {
        enemies.remove(enemy);
    }
}
