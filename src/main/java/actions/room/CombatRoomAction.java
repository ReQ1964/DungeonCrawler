package actions.room;

import entities.Player;
import game.Battle;
import rooms.CombatRoom;
import rooms.Room;
import utils.UserInputUtil;

public class CombatRoomAction implements RoomAction {
    @Override
    public void perform(Player player, Room room) throws InterruptedException {
            if (!((CombatRoom) room).getEnemies().isEmpty()) {
                if (UserInputUtil.getYesNoInput("You have encountered an enemy! Do you want to fight them?")) {
                    new Battle().startBattle(player, (CombatRoom) room);
                } else {
                    player.setCurrentRoom(player.getPreviousRoom());
                    System.out.println("You have fled!");
                }
            } else {
                System.out.println("The room appears to have been a combat area, but it's now clear of enemies.");
            }
        }
    }

