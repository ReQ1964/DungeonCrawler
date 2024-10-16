package rooms;

import entities.GoblinEnemy;
import entities.LivingCreature;
import entities.Player;

import java.util.*;

public class RoomFactory {

    private static final String[] ROOM_NAMES = {
            "Northern Room", "Eastern Room", "Western Room", "Dark Chamber",
            "Hall of Shadows", "Chamber of Light"
    };

    private static final String[] ROOM_DESCRIPTIONS = {
            "A dark and eerie place.", "A brightly lit chamber.", "A small, dusty room.",
            "A room filled with strange symbols.", "A hallway with flickering torches.",
            "A mysterious room with an ominous atmosphere."
    };

    public static Map<String, Room> createRandomRooms(int width, int height, Player player) {
        Map<String, Room> rooms = new HashMap<>();
        Random rand = new Random();
        Room[][] grid = new Room[width][height];

        // Step 1: Generate Rooms
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                String name = ROOM_NAMES[rand.nextInt(ROOM_NAMES.length)] + " (" + x + ", " + y + ")";
                String description = ROOM_DESCRIPTIONS[rand.nextInt(ROOM_DESCRIPTIONS.length)];
                List<LivingCreature> enemies = generateRandomEnemies(rand);  // Add random enemies

                Room room = new Room(name, description, enemies);
                grid[x][y] = room;
                rooms.put(name, room);
            }
        }

        // Step 2: Link Rooms with Opposite Exits
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Room currentRoom = grid[x][y];

                if (x > 0) { // West
                    Room westRoom = grid[x - 1][y];
                    currentRoom.setExit("west", westRoom);
                    westRoom.setExit("east", currentRoom);
                }
                if (x < width - 1) { // East
                    Room eastRoom = grid[x + 1][y];
                    currentRoom.setExit("east", eastRoom);
                    eastRoom.setExit("west", currentRoom);
                }
                if (y > 0) { // North
                    Room northRoom = grid[x][y - 1];
                    currentRoom.setExit("north", northRoom);
                    northRoom.setExit("south", currentRoom);
                }
                if (y < height - 1) { // South
                    Room southRoom = grid[x][y + 1];
                    currentRoom.setExit("south", southRoom);
                    southRoom.setExit("north", currentRoom);
                }
            }
        }

        // Step 3: Pick a starting room and ensure no enemies there
        Room startingRoom = grid[rand.nextInt(width)][rand.nextInt(height)];
        startingRoom.clearEnemies();  // Remove enemies from the starting room
        player.setCurrentRoom(startingRoom);

        return rooms;
    }

    // Generate random enemies for the rooms
    private static List<LivingCreature> generateRandomEnemies(Random rand) {
        List<LivingCreature> enemies = new ArrayList<>();
        int numEnemies = rand.nextInt(3);  // 0 to 2 enemies per room
        for (int i = 0; i < numEnemies; i++) {
            enemies.add(new GoblinEnemy( 50 + rand.nextInt(50), 10 + rand.nextInt(5)));
        }
        return enemies;
    }
}
