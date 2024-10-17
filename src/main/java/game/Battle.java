package game;

import data.BattleMessages;
import entities.LivingCreature;
import entities.Player;
import rooms.CombatRoom;

public class Battle {
    public void startBattle(Player player, CombatRoom combatRoom) throws InterruptedException {
        LivingCreature enemy = combatRoom.getEnemies().getFirst();

        System.out.println("A battle begins between " + player.getName() + " and the " + enemy.getName() + "!\n");

        while (player.isAlive() && enemy.isAlive()) {
            player.attack(enemy);
            String damageIndicatorMessage = player.isDmgCritical ? " CRITICAL DAMAGE!" : " DAMAGE!";

            System.out.println(player.getName() + BattleMessages.getRandomAttackMessage() + enemy.getName() + " for " + player.getAttackDamage() + damageIndicatorMessage);
            System.out.println(enemy.getName() + BattleMessages.getRandomReceiveDamageMessage() + enemy.getHealth() + " health.");
            System.out.println();
            waitForNextTurn();

            if (enemy.isAlive()) {
                enemy.attack(player);
                System.out.println(enemy.getName() + BattleMessages.getRandomAttackMessage() + player.getName() + " for " + enemy.getAttackDamage() + " DAMAGE!");
                System.out.println(player.getName() + BattleMessages.getRandomReceiveDamageMessage() + player.getHealth() + " health.");
                System.out.println();
                waitForNextTurn();
            }
        }

        // Determine the winner
        if (!enemy.isAlive()) {
            System.out.println(player.getName() + " stands victorious, raising their weapon in triumph!");
            System.out.println("The defeated " + enemy.getName() + " crumples to the ground, never to rise again.");
            combatRoom.removeEnemy(enemy);
        } else {
            System.out.println(enemy.getName() + " lets out a triumphant roar, having bested " + player.getName() + " in combat!");
            System.out.println(player.getName() + " falls, but their spirit will live on in the hearts of their allies.");
        }
        System.out.println();
    }

    private void waitForNextTurn() throws InterruptedException {
        Thread.sleep(800); // Waits for 1 second
    }
}
