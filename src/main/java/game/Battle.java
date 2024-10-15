package game;

import entities.LivingCreature;
import entities.Player;
import rooms.CombatRoom;

public class Battle {
    public void startBattle(Player player, CombatRoom combatRoom) throws InterruptedException {
        LivingCreature enemy = combatRoom.getEnemies().get(0);

        while (player.isAlive() && enemy.isAlive()) {
            player.attack(enemy);
            System.out.println(player.getName() + " attacked " + enemy.getName() + " leaving them with " + enemy.getHealth() + " health");
            waitForNextTurn();

            if (enemy.isAlive()) {
                enemy.attack(player);
                System.out.println(enemy.getName() + " attacked " + player.getName() + " leaving them with " + player.getHealth() + " health");
                waitForNextTurn();
            }
        }

        if (!enemy.isAlive()) {
            System.out.println(player.getName() + " is the winner!");
            combatRoom.removeEnemy(enemy);
        } else {
            System.out.println(enemy.getName() + " is the winner!");
        }
    }

    private static void waitForNextTurn() throws InterruptedException {
        Thread.sleep(100);
    }
}
