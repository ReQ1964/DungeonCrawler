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
        if (!(room instanceof TreasureRoom)) {
            System.out.println("This is not a treasure room!");
            return;
        }

        TreasureRoom treasureRoom = (TreasureRoom) room;
        Item treasure = treasureRoom.getTreasure();

        if (UserInputUtil.getYesNoInput("You've found a treasure! Do you want to examine the item?")) {
            System.out.println("You found a: " + treasure.examine());

            if (UserInputUtil.getYesNoInput("Do you want to keep the item?")) {
                player.inventory.addItem(treasure.getName(), treasure);
                System.out.println("You've added " + treasure.getName() + " to your inventory.");
                treasureRoom.removeTreasure();
            } else {
                System.out.println("You decide to leave the treasure for now.");
            }
        } else {
            System.out.println("You decide to leave the treasure for now.");
        }
    }
}