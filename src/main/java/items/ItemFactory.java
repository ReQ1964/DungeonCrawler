package items;

import java.util.Random;
import data.ItemsData;

public class ItemFactory {
    static Random random = new Random();

    public static Sword createRandomSword() {
        String name = generateRandomSwordName();
        String description = ItemsData.getSwordDescriptions().get(random.nextInt(ItemsData.getSwordDescriptions().size()));
        int damage = calculateDamageBasedOnName(name);
        return new Sword(name, description, damage);
    }

    private static String generateRandomSwordName() {
        StringBuilder nameBuilder = new StringBuilder();

        // 50% chance to add a prefix
        if (random.nextBoolean()) {
            nameBuilder.append(ItemsData.getSwordPrefixes().get(random.nextInt(ItemsData.getSwordPrefixes().size()))).append(" ");
        }

        // Always add a sword type
        nameBuilder.append(ItemsData.getSwordTypes().get(random.nextInt(ItemsData.getSwordTypes().size())));

        // 30% chance to add a suffix
        if (random.nextDouble() < 0.3) {
            nameBuilder.append(" ").append(ItemsData.getSwordSuffixes().get(random.nextInt(ItemsData.getSwordSuffixes().size())));
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
            if (ItemsData.getSwordPrefixes().contains(word) || ItemsData.getSwordSuffixes().contains(word)) {
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
        return switch (itemType) {
            case 0 -> createRandomSword(
            );
            default -> null;
        };
    }
}