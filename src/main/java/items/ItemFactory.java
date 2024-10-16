package items;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ItemFactory {
    static Random random = new Random();

    private static final List<String> SWORD_PREFIXES = Arrays.asList(
            "Rusty", "Sharp", "Gleaming", "Ancient", "Mythical", "Legendary", "Enchanted", "Divine"
    );
    private static final List<String> SWORD_TYPES = Arrays.asList(
            "Shortsword", "Longsword", "Broadsword", "Claymore", "Rapier", "Scimitar", "Katana"
    );
    private static final List<String> SWORD_SUFFIXES = Arrays.asList(
            "of Power", "of the Ancients", "of Destiny", "of the Fallen", "of Light", "of Shadows"
    );
    private static final List<String> SWORD_DESCRIPTIONS = Arrays.asList(
            "A well-crafted blade with a sharp edge.",
            "An old sword with mysterious runes etched on its blade.",
            "A lightweight sword that gleams in the light.",
            "A heavy sword that radiates an aura of power.",
            "A sword with an intricate hilt and a perfectly balanced blade."
    );

    public static Sword createRandomSword() {
        String name = generateRandomSwordName();
        String description = SWORD_DESCRIPTIONS.get(random.nextInt(SWORD_DESCRIPTIONS.size()));
        int damage = calculateDamageBasedOnName(name);
        return new Sword(name, description, damage);
    }

    private static String generateRandomSwordName() {
        StringBuilder nameBuilder = new StringBuilder();

        // 50% chance to add a prefix
        if (random.nextBoolean()) {
            nameBuilder.append(SWORD_PREFIXES.get(random.nextInt(SWORD_PREFIXES.size()))).append(" ");
        }

        // Always add a sword type
        nameBuilder.append(SWORD_TYPES.get(random.nextInt(SWORD_TYPES.size())));

        // 30% chance to add a suffix
        if (random.nextDouble() < 0.3) {
            nameBuilder.append(" ").append(SWORD_SUFFIXES.get(random.nextInt(SWORD_SUFFIXES.size())));
        }

        return nameBuilder.toString();
    }

    private static int calculateDamageBasedOnName(String name) {
        int baseDamage = 5 + random.nextInt(11); // Base damage between 5 and 15

        // Increase damage for each word in the name
        String[] words = name.split(" ");
        baseDamage += words.length * 2;

        // Bonus damage for special words
        for (String word : words) {
            if (SWORD_PREFIXES.contains(word) || SWORD_SUFFIXES.contains(word)) {
                baseDamage += 3;
            }
            if (word.equals("Legendary") || word.equals("Mythical") || word.equals("Divine")) {
                baseDamage += 5;
            }
        }

        return Math.min(baseDamage, 30); // Cap damage at 30
    }

    public static Item createRandomItem() {
       /* int itemType = random.nextInt(3);*/
        int itemType=0;
        switch (itemType) {
            case 0:
                return createRandomSword(
                );
            default: return null;
            }
    }
}