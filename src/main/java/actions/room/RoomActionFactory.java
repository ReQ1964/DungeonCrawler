package actions.room;

import rooms.CombatRoom;
import rooms.Room;
import rooms.TreasureRoom;

public class RoomActionFactory {
    public static RoomAction getAction(Room room) {
        System.out.println("You are in: " + room.getName());
        System.out.println("Description: " + room.getDescription() + "\n");

        if (room instanceof CombatRoom) {
            return new CombatRoomAction();
        } else if (room instanceof TreasureRoom) {
            return new TreasureRoomAction();
        } else {
            return new DefaultRoomAction();
        }
    }
}
