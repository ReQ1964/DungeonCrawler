package data;

import java.util.Arrays;
import java.util.List;

public class ItemsData {

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

    public static List<java.lang.String> getSwordPrefixes() {
        return SWORD_PREFIXES;
    }
    public static List<String> getSwordTypes(){
        return SWORD_TYPES;
    }
    public static List<String> getSwordSuffixes(){
        return SWORD_SUFFIXES;
    }
    public static List<String> getSwordDescriptions(){
        return SWORD_DESCRIPTIONS;
    }
}
