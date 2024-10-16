package rooms;

public class RoomData {
    private static final String[] ROOM_NAMES = {
            "Northern Room", "Eastern Room", "Western Room", "Dark Chamber",
            "Hall of Shadows", "Chamber of Light",
            "Enchanted Grove", "Crystal Cavern", "Whispering Hall",
            "Forgotten Dungeon", "Fiery Pit", "Frosty Sanctuary",
            "Secret Passage", "Ancient Library", "Labyrinth of Shadows",
            "Throne Room", "Celestial Observatory", "Ruined Fortress",
            "Alchemist's Workshop", "Ethereal Chamber", "Gloomy Cellar",
            "Mystic Shrine", "Sunlit Terrace", "Hidden Vault",
            "Temporal Nexus", "Eldritch Catacombs", "Silent Woods",
            "Starlit Balcony", "Abandoned Quarters", "Shimmering Pool",
            "Infernal Arena", "Lab of Horrors", "Twilight Bower",
            "Haunted Attic", "Serpent's Nest", "Dragon's Lair"
    };

    private static final String[] ROOM_DESCRIPTIONS = {
            "A dark and eerie place.", "A brightly lit chamber.", "A small, dusty room.",
            "A room filled with strange symbols.", "A hallway with flickering torches.",
            "A mysterious room with an ominous atmosphere.",
            "A serene glade filled with vibrant flowers and the sound of chirping birds.",
            "A cavern adorned with shimmering crystals that reflect the light in every direction.",
            "A long hall echoing with whispers of long-forgotten secrets.",
            "A dark and damp dungeon where time seems to stand still.",
            "A scorching pit filled with flames and the scent of sulfur.",
            "A cold sanctuary, blanketed in frost, where shadows dance in the corners.",
            "A narrow passage that leads to unknown destinations, cloaked in mystery.",
            "A library filled with ancient tomes and the scent of aged parchment.",
            "A confusing labyrinth shrouded in darkness and filled with echoes.",
            "A grand room with a majestic throne, where rulers once held court.",
            "A place where the stars can be observed in perfect clarity, revealing celestial wonders.",
            "A once-mighty fortress, now in ruins, where history whispers its tales.",
            "A workshop cluttered with potions and alchemical paraphernalia.",
            "A chamber that seems to exist outside of time, ethereal and calm.",
            "A damp cellar where the air is thick with mystery and old wine.",
            "A sacred shrine dedicated to forgotten gods, radiating a gentle light.",
            "A sunlit terrace overlooking a vast landscape, filled with tranquility.",
            "A hidden vault that guards treasures beyond imagination, enveloped in shadows.",
            "A nexus of time and space, where reality bends and twists unpredictably.",
            "A series of catacombs filled with remnants of ancient magic and eerie silence.",
            "A serene wood filled with silent trees, where the air is thick with magic.",
            "A balcony where stars twinkle brightly, offering a view of the universe.",
            "A set of abandoned quarters, long forgotten, echoing with memories.",
            "A shimmering pool that reflects the sky, said to hold mystical properties.",
            "An arena of fire and brimstone, where fierce battles were once fought.",
            "A lab filled with strange creatures and odd experiments gone awry.",
            "A bower shrouded in twilight, alive with the sounds of night creatures.",
            "An attic filled with forgotten belongings, where every corner holds a ghost.",
            "A nest filled with glistening treasures, guarded by a fearsome serpent.",
            "A cavern that serves as the lair of a dragon, filled with gold and magic."
    };

    public static String[] getRoomNames() {
        return ROOM_NAMES;
    }

    public static String[] getRoomDescriptions() {
        return ROOM_DESCRIPTIONS;
    }
}
