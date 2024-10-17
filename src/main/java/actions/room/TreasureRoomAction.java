package actions.room;

import entities.Player;
import items.Item;
import rooms.Room;
import rooms.TreasureRoom;
import utils.UserInputUtil;

import java.util.Scanner;

public class TreasureRoomAction implements RoomAction {
    @Override
    public void perform(Player player, Room room) {
        TreasureRoom treasureRoom = (TreasureRoom) room;
        Item treasure = treasureRoom.getTreasure();

        if(treasure != null){
            if (UserInputUtil.getYesNoInput("You've found a treasure! Do you want to examine the item?")) {
                System.out.println("\nYou found a: " + treasure.examine() + "\n");

                if (UserInputUtil.getYesNoInput("Do you want to keep the item?")) {
                    player.inventory.addItem(treasure.getName(), treasure);
                    System.out.println("\nYou've added " + treasure.getName() + " to your inventory.\n");
                    treasureRoom.removeTreasure();
                } else {
                    System.out.println("\nYou decide to leave the treasure for now.\n");
                }
            } else {
                System.out.println("\nYou decide to leave the treasure for now.\n");
            }
        }
    }
}