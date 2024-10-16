package rooms;

import entities.LivingCreature;
import items.Item;

import java.util.List;

public class TreasureRoom extends Room{
    private Item treasure;
    public TreasureRoom(String name, String description, Item treasure) {
        super(name, description);
        this.treasure = treasure;
    }

    public Item getTreasure(){
        return treasure;
    }

    public void removeTreasure(){
        treasure=null;
    }
}
