package actions.room;

import entities.Player;
import rooms.Room;

public interface RoomAction {
    void perform(Player player, Room room) throws InterruptedException;
}
