package rooms;

import entities.GoblinEnemy;
import entities.LivingCreature;
import entities.Player;
import items.Item;
import items.ItemFactory;

import java.util.*;

public class DungeonGenerator {
    private static Room[][] grid;

    public static Map<String, Room> generateDungeon(int width, int height, Player player) {
        Map<String, Room> rooms = new HashMap<>();
        Random rand = new Random();
        grid = new Room[width][height];

        int totalRooms = width * height;
        int combatRoomCount = 0;
        int treasureRoomCount = 0;
        int desiredCombatRooms = (int) (totalRooms * 0.20);
        int desiredTreasureRooms = (int) (totalRooms * 0.20);


        // Step 1: Generate Rooms
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                String name = RoomData.getRoomNames()[rand.nextInt(RoomData.getRoomNames().length)] + " (" + x + ", " + y + ")";
                String description = RoomData.getRoomDescriptions()[rand.nextInt(RoomData.getRoomDescriptions().length)];
                Room room;

                if (combatRoomCount < desiredCombatRooms && rand.nextDouble() < (double) (desiredCombatRooms - combatRoomCount) / (totalRooms - (x * height + y))) {
                    room = createCombatRoom(name, description, rand, x, y);
                    combatRoomCount++;
                } else if (treasureRoomCount < desiredTreasureRooms && rand.nextDouble() < (double) (desiredTreasureRooms - treasureRoomCount) / (totalRooms - (x * height + y))) {
                    room = createTreasureRoom(name, description, rand, x, y);
                    treasureRoomCount++;
                } else {
                    room = new Room(name, description, x, y);
                }

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
        Room startingRoom;
        do {
            startingRoom = grid[rand.nextInt(width)][rand.nextInt(height)];
        } while (startingRoom instanceof CombatRoom);

        player.setCurrentRoom(startingRoom);

        return rooms;
    }

    private static CombatRoom createCombatRoom(String name, String description, Random rand, int x, int y) {
        List<LivingCreature> enemies = generateRandomEnemies(rand);
        enemies.add(new GoblinEnemy(40 + rand.nextInt(21), 3 + rand.nextInt(3)));
        return new CombatRoom(name, description, enemies, x, y);
    }

    private static TreasureRoom createTreasureRoom(String name, String description, Random rand, int x, int y) {
        List<LivingCreature> enemies = generateRandomEnemies(rand);
        enemies.add(new GoblinEnemy(40 + rand.nextInt(21), 3 + rand.nextInt(3)));
        Item treasure = ItemFactory.createRandomItem();
        return new TreasureRoom(name, description, treasure, x, y);
    }

    // Generate random enemies for the rooms
    private static List<LivingCreature> generateRandomEnemies(Random rand) {
        List<LivingCreature> enemies = new ArrayList<>();
        int numEnemies = rand.nextInt(2);  // 0 to 1 enemies per room
        for (int i = 0; i < numEnemies; i++) {
            enemies.add(new GoblinEnemy( 50 + rand.nextInt(50), 5));
        }
        return enemies;
    }

    public static void printDungeonMap(Player player) {
        int playerX = player.getCurrentRoom().getX();
        int playerY = player.getCurrentRoom().getY();

        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                if (x == playerY && y == playerX) {
                    // Player's current room
                    System.out.print("[0] ");
                } else {
                    // Any other room
                    System.out.print("[ ] ");
                }
            }
            System.out.println();  // Move to the next row of the grid
        }
    }

}
